package com.gpbtmn.fomakin.sroomdroid.domain.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "ServerBox"
        , indices =
        {
                @Index(value = "Name", unique = true),
                @Index(value = "Id", unique = true)
        })
public class ServerBox {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "Id")
    private int id;

    @NonNull
    @ColumnInfo(name = "Name")
    private String name;

    public ServerBox(@NonNull int id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    @NonNull
    public int getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }
}
