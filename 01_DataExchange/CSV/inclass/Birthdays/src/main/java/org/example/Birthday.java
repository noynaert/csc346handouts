package org.example;

import com.opencsv.bean.CsvBindByPosition;

import java.io.Serializable;

public class Birthday implements Serializable, Comparable<Birthday> {
    @CsvBindByPosition(position = 0)
    private String name;
    @CsvBindByPosition(position = 1)
    private String birthday;
    @CsvBindByPosition(position = 2)
    private int id;

    public Birthday(){
        setBirthday("01-01-1970");
        setName("Unknown");
        setId(0);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%06d %11s %s", id, birthday,name);
    }

    @Override
    public int compareTo(Birthday other) {
        return -this.birthday.compareTo(other.birthday);
    }
}

// 2022-09-27
