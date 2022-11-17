package com.noynaert.People;

public abstract class Person {
    private String name;
    private int id;
    public Person(){
        this("Anonymous Person");
    }
    public Person(String name) {
        setName(name);
        setId(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        int number =(int)(Math.random()*10000000);
        this.id = number;
    }
    @Override
    public String toString(){
        String s = String.format("G%08d %s (%s)", id, name, this.getClass());
        return s;
    }
}
