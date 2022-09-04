package com.example.quranappv3;

public class Surah {
    String nameE;
    String nameU;
    String nazool;
    String id;
    String Intro;

    public Surah(String id, String intro, String nameE, String nazool, String nameU ) {
        this.nameE = nameE;
        this.nameU = nameU;
        this.nazool = nazool;
        this.id = id;
        Intro = intro;
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

    public String getNazool() {
        return nazool;
    }

    public void setNazool(String nazool) {
        this.nazool = nazool;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntro() {
        return Intro;
    }

    public void setIntro(String intro) {
        Intro = intro;
    }

}
