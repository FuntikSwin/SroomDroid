package com.gpbtmn.fomakin.sroomdroid.domain.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Device"
        , indices =
        {
                @Index(value = "Id", unique = true),
                @Index(value = "Num", unique = true)
        }
        , foreignKeys =
        {
                @ForeignKey(
                        entity = ServerBox.class,
                        parentColumns = "Id",
                        childColumns = "ServerBoxId",
                        onDelete = ForeignKey.SET_NULL)
        })
public class Device {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "Id")
    private int id;

    @NonNull
    @ColumnInfo(name = "Name")
    private String name;

    @ColumnInfo(name = "Num")
    private int num;

    @NonNull
    @ColumnInfo(name = "Size")
    private int size;

    @ColumnInfo(name = "ServerBoxId")
    private int serverBoxId;

    @ColumnInfo(name = "Desc")
    private String desc;

    public Device(@NonNull int id, @NonNull String name, int num, @NonNull int size, int serverBoxId, String desc) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.size = size;
        this.serverBoxId = serverBoxId;
        this.desc = desc;
    }

    @NonNull
    public int getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    @NonNull
    public int getSize() {
        return size;
    }

    public int getServerBoxId() {
        return serverBoxId;
    }

    public String getDesc() {
        return desc;
    }
}
