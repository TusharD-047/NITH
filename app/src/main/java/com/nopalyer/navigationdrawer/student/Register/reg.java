package com.nopalyer.navigationdrawer.student.Register;

import android.os.Parcel;
import android.os.Parcelable;

public class reg implements Parcelable {
    private String name,photo;

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

    public reg(){

    }

    protected reg(Parcel in) {
        name = in.readString();
        photo = in.readString();
    }

    public static final Creator<reg> CREATOR = new Creator<reg>() {
        @Override
        public reg createFromParcel(Parcel in) {
            return new reg(in);
        }

        @Override
        public reg[] newArray(int size) {
            return new reg[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(photo);
    }
}
