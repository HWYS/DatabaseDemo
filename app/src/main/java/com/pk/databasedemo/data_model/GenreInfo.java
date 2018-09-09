package com.pk.databasedemo.data_model;

import android.os.Parcel;
import android.os.Parcelable;

public class GenreInfo implements Parcelable {
    private int g_id;
    private String g_name;

    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.g_id);
        dest.writeString(this.g_name);
    }

    public GenreInfo() {
    }

    protected GenreInfo(Parcel in) {
        this.g_id = in.readInt();
        this.g_name = in.readString();
    }

    public static final Parcelable.Creator<GenreInfo> CREATOR = new Parcelable.Creator<GenreInfo>() {
        @Override
        public GenreInfo createFromParcel(Parcel source) {
            return new GenreInfo(source);
        }

        @Override
        public GenreInfo[] newArray(int size) {
            return new GenreInfo[size];
        }
    };
}
