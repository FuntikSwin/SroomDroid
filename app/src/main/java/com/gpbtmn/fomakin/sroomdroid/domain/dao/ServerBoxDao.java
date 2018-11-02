package com.gpbtmn.fomakin.sroomdroid.domain.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.gpbtmn.fomakin.sroomdroid.domain.entity.ServerBox;

import java.util.List;

@Dao
public interface ServerBoxDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(ServerBox serverBox);

    @Update
    void update(ServerBox serverBox);

    @Delete
    void delete(ServerBox... serverBoxes);

    @Query("select * from ServerBox")
    LiveData<List<ServerBox>> getAll();

}
