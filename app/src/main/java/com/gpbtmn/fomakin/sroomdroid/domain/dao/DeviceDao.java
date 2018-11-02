package com.gpbtmn.fomakin.sroomdroid.domain.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.gpbtmn.fomakin.sroomdroid.domain.entity.Device;

import java.util.List;

@Dao
public interface DeviceDao {

    @Insert
    void insert(Device device);

    @Update
    void update(Device device);

    @Delete
    void delete(Device... devices);

    @Query("select * from Device")
    LiveData<List<Device>> getAll();

}
