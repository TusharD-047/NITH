package com.nopalyer.navigationdrawer.AboutNithhp;

import android.os.Parcel;
import android.os.Parcelable;

public class Abnith implements Parcelable {
    private  String name,photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Abnith() {

    }

    protected Abnith(Parcel in) {
        name = in.readString();
        photo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(photo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Abnith> CREATOR = new Creator<Abnith>() {
        @Override
        public Abnith createFromParcel(Parcel in) {
            return new Abnith(in);
        }

        @Override
        public Abnith[] newArray(int size) {
            return new Abnith[size];
        }
    };
}
