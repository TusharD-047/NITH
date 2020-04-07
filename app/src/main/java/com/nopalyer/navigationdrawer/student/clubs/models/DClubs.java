package com.nopalyer.navigationdrawer.student.clubs.models;

import android.os.Parcel;
import android.os.Parcelable;

public class DClubs implements Parcelable {

    private String name,overview,photo,description;

    public DClubs() {
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected DClubs(Parcel in) {
        name = in.readString();
        photo = in.readString();
        description = in.readString();
    }

    public static final Creator<DClubs> CREATOR = new Creator<DClubs>() {
        @Override
        public DClubs createFromParcel(Parcel in) {
            return new DClubs(in);
        }

        @Override
        public DClubs[] newArray(int size) {
            return new DClubs[size];
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
        dest.writeString(description);
    }
}
