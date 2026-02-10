package com.noynaert;

public class Office {
    private int id;
    private String number;
    private String type;
    private double size;

    public Office(int id, String number, String type, double size) {
        setID(id);
        setNumber(number);
        setType(type);
        setSize(size);
    }
    public Office(String number, String type, double size) {
        this(-999, number, type, size);
    }

    private void setID(int id) {
        this.id = id;
    }
    public int getID() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
    @Override
    public String toString() {
        return "Office{" + "number=" + number + ", type=" + type + ", size=" + size + '}';
    }
}
