package org.example;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

import java.io.Serializable;

public class Country implements Comparable<Country>, Serializable {

    @CsvBindByPosition(position=0)
    //@CsvBindByName(column="entity")
    String name;
    @CsvBindByPosition(position=1)
    String url;
    @CsvBindByPosition(position=2)
    String gec;
    @CsvBindByPosition(position=3)
    String iso;
    @CsvBindByPosition(position=4)
    String stanag;
    @CsvBindByPosition(position=5)
    String internet;
    @CsvBindByPosition(position=6)
    String comment;
    final public String EMPTY = "???";
    public Country(){

        setName(EMPTY);
        setName(EMPTY);
        setUrl(EMPTY);
        setGec(EMPTY);
        setIso(EMPTY);
        setInternet(EMPTY);
        setComment(EMPTY);
    }
    public Country(String name, String url, String gec, String iso, String stanag, String internet, String comment) {
        this.name = name;
        this.url = url;
        this.gec = gec;
        this.iso = iso;
        this.stanag = stanag;
        this.internet = internet;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGec() {
        return gec;
    }

    public void setGec(String gec) {
        this.gec = gec;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getStanag() {
        return stanag;
    }

    public void setStanag(String stanag) {
        this.stanag = stanag;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", gec='" + gec + '\'' +
                ", iso='" + iso + '\'' +
                ", stanag='" + stanag + '\'' +
                ", internet='" + internet + '\'' +
                ", comment='" + comment + '\'' +

                '}';
    }

    @Override
    public int compareTo(Country other) {
        int result = name.compareTo(other.name);
        return result;
    }
}
