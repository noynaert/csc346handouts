package edu.missouriwestern.noynaert.book;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Publisher {
    @JsonAlias({"publishing house", "publisher"})
    private String name;

    @JsonAlias({"city"})
    private String location;

    public Publisher(String name, String location){
        setName(name);
        setLocation(location);
    }
    public Publisher(){
        this("--","--");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String toString(){
        return String.format("%s (%s)",name,location);
    }

}
