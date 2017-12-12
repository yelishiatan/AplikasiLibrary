package com.example.acer.mylibrary;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by acer on 12/11/2017.
 */

public class Pinjaman implements Parcelable {
    private Buku buku;
    private String tanggalPinjam;
    private String tanggalKembali;
    private String id_members;
    private String id;

    private String[][] data = new String[][] {
            {"0001","3 Januari 2017","9 Februari 2017","bk1"},
            {"0002","10 Januari 2017","16 Februari 2017","bk2"}
    };

    public Pinjaman(String id_members) {
        this.id_members = id_members;
        this.login();
    }

    private void login() {
        for (int i = 0; i < this.data.length; i++) {
            if (this.id_members.equals(this.data[i][0])) {
                this.tanggalPinjam = this.data[i][1];
                this.tanggalKembali = this.data[i][2];
                this.buku = new Buku(data[i][3]);
                this.id ="1";
                break;
            }else {
                this.id = "0";
            }

        }
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public String getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(String tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public String getId_members() {
        return id_members;
    }

    public void setId_members(String id_members) {
        this.id_members = id_members;
    }


    //tambahan

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.buku, flags);
        dest.writeString(this.tanggalPinjam);
        dest.writeString(this.tanggalKembali);
        dest.writeString(this.id_members);
        dest.writeString(this.id);
    }

    protected Pinjaman(Parcel in) {
        this.buku = in.readParcelable(Buku.class.getClassLoader());
        this.tanggalPinjam = in.readString();
        this.tanggalKembali = in.readString();
        this.id_members = in.readString();
        this.id = in.readString();
    }

    public static final Creator<Pinjaman> CREATOR = new Creator<Pinjaman>() {
        @Override
        public Pinjaman createFromParcel(Parcel source) {
            return new Pinjaman(source);
        }

        @Override
        public Pinjaman[] newArray(int size) {
            return new Pinjaman[size];
        }
    };
}
