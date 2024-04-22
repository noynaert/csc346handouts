package edu.missouriwestern.noynaert.u03_150_h2.Models;

import jakarta.persistence.*;

@Entity
@Table(name="people")
public class PersonModel {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column Double height;

    public PersonModel(String name, Double height){
        setName(name);
        setHeight(height);
    }
    public PersonModel(){
        this("Unknown",0.0);
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
