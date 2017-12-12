package com.example.acer.mylibrary;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by acer on 12/11/2017.
 */

public class Members implements Parcelable {
    private String id_members;
    private Pinjaman pinjaman;


    public String getId_members() {
        return id_members;
    }

    public void setId_members(String id_member) {
        this.id_members = id_member;
    }

    public Pinjaman getPinjaman() {
        return pinjaman;
    }

    public void setPinjaman(Pinjaman pinjaman) {
        this.pinjaman = pinjaman;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id_members);
        dest.writeParcelable(this.pinjaman, flags);
    }

    protected Members(Parcel in) {
        this.id_members = in.readString();
        this.pinjaman = in.readParcelable(Pinjaman.class.getClassLoader());
    }

    public static final Creator<Members> CREATOR = new Creator<Members>() {
        @Override
        public Members createFromParcel(Parcel source) {
            return new Members(source);
        }

        @Override
        public Members[] newArray(int size) {
            return new Members[size];
        }
    };
}
