package com.gpbtmn.fomakin.sroomdroid.domain;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.gpbtmn.fomakin.sroomdroid.domain.dao.DeviceDao;
import com.gpbtmn.fomakin.sroomdroid.domain.dao.ServerBoxDao;
import com.gpbtmn.fomakin.sroomdroid.domain.entity.Device;
import com.gpbtmn.fomakin.sroomdroid.domain.entity.ServerBox;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Database(entities = {ServerBox.class, Device.class}, version = 1)
public abstract class SroomRoomDatabase extends RoomDatabase {

    private static volatile SroomRoomDatabase INSTANCE;

    private static final String DBNAME = "sroom_db";

    public abstract ServerBoxDao serverBoxDao();
    public abstract DeviceDao deviceDao();

    private static SroomRoomDatabase.Callback sroomDatabaseCallback = new SroomRoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static void copyDatabase(Context context) {
        File dbPath = context.getDatabasePath(DBNAME);
        if (dbPath.exists()) {
            return;
        }

        try (InputStream is = context.getAssets().open("databases/" + DBNAME)) {
            try (OutputStream os = new FileOutputStream(dbPath)) {
                byte[] buffer = new byte[8192];
                int length;
                while ((length = is.read(buffer, 0, 8192)) > 0) {
                    os.write(buffer, 0, length);
                }
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static SroomRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SroomRoomDatabase.class) {
                if (INSTANCE == null) {
                    copyDatabase(context);
                    INSTANCE = Room
                            .databaseBuilder(context.getApplicationContext(), SroomRoomDatabase.class, DBNAME)
                            .addCallback(sroomDatabaseCallback)
                            .build();
                }
            }
        }

        return INSTANCE;
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final ServerBoxDao serverBoxDao;
        private final DeviceDao deviceDao;

        PopulateDbAsync(SroomRoomDatabase db) {
            serverBoxDao = db.serverBoxDao();
            deviceDao = db.deviceDao();
        }

        @Override
        protected Void doInBackground(final Void... parms) {
            return null;
        }
    }

}
