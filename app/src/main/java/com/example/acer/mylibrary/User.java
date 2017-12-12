package com.example.acer.mylibrary;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by acer on 12/11/2017.
 */

public class User implements Parcelable {
    private String email;
    private String pass;
    private String namalengkap;
    private String tlp;
    private Pinjaman pinjam;
    private Buku buku;
    private String idmember;

    private String[][] data = new String[][] {

            {"yelishiatan@gmail.com","yelishiatan","Yelishia Tandilisan","081343920290","0001"},
            {"jesschan@gmail.com","jeschan","Jessica Chandra","081345697862","0002"},
            {"evelynwijaya@gmail.com","evelynwijaya","Evelyn Wijaya","083498712345","0003"}


    };

    public void setData(String[][] data) {this.data =data;}

    public User(String email) {
        this.email = email;
        this.login();

    }

    public void setEmail(String email) {
        this.email = email;
        this.login();
    }

    public void setPass(String pass) {
        this.pass = pass;
        this.login();
    }

    private void login() {
        for(int i=0; i<this.data.length; i++){
            if(this.email.equals(this.data[i][0])) {
                this.pass = this.data[i][1];
                this.namalengkap = this.data[i][2];
                this.tlp = this.data[i][3];
                this.idmember = this.data[i][4];
            }
        }
    }

    public String getEmail() {
        return this.email;
    }



    public String getPass() {
        return pass;
    }



    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getTlp() {
        return tlp;
    }

    public void setTlp(String tlp) {
        this.tlp = tlp;
    }

    public String getIdmember() {
        return idmember;
    }

    public void setIdmember(String idmember) {
        this.idmember = idmember;
    }

    //*method tambahan untuk parcelable*//

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.email);
        dest.writeString(this.pass);
        dest.writeString(this.namalengkap);
        dest.writeString(this.tlp);
        dest.writeParcelable(this.pinjam, flags);
        dest.writeParcelable(this.buku, flags);
        dest.writeString(this.idmember);
    }

    protected User(Parcel in) {
        this.email = in.readString();
        this.pass = in.readString();
        this.namalengkap = in.readString();
        this.tlp = in.readString();
        this.pinjam = in.readParcelable(Pinjaman.class.getClassLoader());
        this.buku = in.readParcelable(Buku.class.getClassLoader());
        this.idmember = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}


