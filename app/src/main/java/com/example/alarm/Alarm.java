package com.example.alarm;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Alarm implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String milisec;

    //на майбутнє перевіряти чи вкл чи викл
    private boolean on ;









    public Alarm(String milisec, boolean on  ){

        this.milisec=milisec;
        this.on=on;


    }


    protected Alarm(Parcel in) {
        id = in.readInt();
        milisec = in.readString();

        on = in.readByte() != 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(milisec);
        dest.writeByte((byte) (on ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Alarm> CREATOR = new Creator<Alarm>() {
        @Override
        public Alarm createFromParcel(Parcel in) {
            return new Alarm(in);
        }

        @Override
        public Alarm[] newArray(int size) {
            return new Alarm[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getMilisec() {
        return milisec;
    }

    public void setMilisec(String milisec) {
        this.milisec = milisec;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

}
