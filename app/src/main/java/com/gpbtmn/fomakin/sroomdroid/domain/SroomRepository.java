package com.gpbtmn.fomakin.sroomdroid.domain;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.gpbtmn.fomakin.sroomdroid.domain.dao.DeviceDao;
import com.gpbtmn.fomakin.sroomdroid.domain.dao.ServerBoxDao;
import com.gpbtmn.fomakin.sroomdroid.domain.entity.Device;
import com.gpbtmn.fomakin.sroomdroid.domain.entity.ServerBox;

import java.util.List;

public class SroomRepository {

    private ServerBoxDao serverBoxDao;
    private DeviceDao deviceDao;

    private LiveData<List<ServerBox>> allServerBoxes;
    private LiveData<List<Device>> allDevices;

    public SroomRepository(Application application) {
        SroomRoomDatabase db = SroomRoomDatabase.getDatabase(application);
        serverBoxDao = db.serverBoxDao();
        deviceDao = db.deviceDao();

        allServerBoxes = serverBoxDao.getAll();
        allDevices = deviceDao.getAll();
    }

    public LiveData<List<ServerBox>> getAllServerBoxes() {
        return allServerBoxes;
    }

    public LiveData<List<Device>> getAllDevices() {
        return allDevices;
    }
}
