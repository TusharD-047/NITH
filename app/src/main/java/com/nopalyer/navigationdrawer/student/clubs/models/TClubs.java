package com.nopalyer.navigationdrawer.student.clubs.models;

import android.os.Parcel;
import android.os.Parcelable;

public class TClubs implements Parcelable {

    private String name,overview,photo,description;

    public TClubs() {
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

    protected TClubs(Parcel in) {
        name = in.readString();
        overview = in.readString();
        photo = in.readString();
        description = in.readString();
    }

    public static final Creator<TClubs> CREATOR = new Creator<TClubs>() {
        @Override
        public TClubs createFromParcel(Parcel in) {
            return new TClubs(in);
        }

        @Override
        public TClubs[] newArray(int size) {
            return new TClubs[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(overview);
        dest.writeString(photo);
        dest.writeString(description);
    }
}