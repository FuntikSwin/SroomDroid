package com.gpbtmn.fomakin.sroomdroid.ui.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.gpbtmn.fomakin.sroomdroid.domain.SroomRepository;
import com.gpbtmn.fomakin.sroomdroid.domain.entity.Device;

import java.util.List;

public class DevicesViewModel extends AndroidViewModel {

    private SroomRepository repository;
    private LiveData<List<Device>> allDevices;

    public DevicesViewModel(@NonNull Application application) {
        super(application);
        repository = new SroomRepository(application);
        allDevices = repository.getAllDevices();
    }

    public LiveData<List<Device>> getAllDevices() {
        return allDevices;
    }
}
