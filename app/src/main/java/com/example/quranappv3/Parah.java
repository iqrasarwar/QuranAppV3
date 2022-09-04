package com.example.quranappv3;

public class Parah {
    String id;
    String nameE;
    String nameU;
    String parahStart;

    public String getParahStart() {
        return parahStart;
    }

    public void setParahStart(String parahStart) {
        this.parahStart = parahStart;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameE() {
        return nameE;
    }

    public void setNameE(String nameE) {
        this.nameE = nameE;
    }

    public String getNameU() {
        return nameU;
    }

    public void setNameU(String nameU) {
        this.nameU = nameU;
    }

    public Parah(String id, String nameE, String nameU, String ParahStrt) {
        this.id = id;
        this.nameE = nameE;
        this.nameU = nameU;
        this.parahStart = ParahStrt;
    }
}
