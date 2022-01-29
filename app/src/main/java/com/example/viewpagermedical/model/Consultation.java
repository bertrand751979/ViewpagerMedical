package com.example.viewpagermedical.model;

import java.io.Serializable;

public class Consultation implements Serializable {
    private String nameSurname;
    private int age;
    private String symptom;

    public Consultation(String nameSurname, int age, String symptom) {
        this.nameSurname = nameSurname;
        this.age = age;
        this.symptom = symptom;
    }

    public Consultation(){}

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
}
