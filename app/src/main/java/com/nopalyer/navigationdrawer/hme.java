package com.nopalyer.navigationdrawer;

import android.os.Parcel;
import android.os.Parcelable;

public class hme implements Parcelable {
    private String name;
    public hme(){

    }

    protected hme(Parcel in) {
        name = in.readString();
    }

    public static final Creator<hme> CREATOR = new Creator<hme>() {
        @Override
        public hme createFromParcel(Parcel in) {
            return new hme(in);
        }

        @Override
        public hme[] newArray(int size) {
            return new hme[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}
