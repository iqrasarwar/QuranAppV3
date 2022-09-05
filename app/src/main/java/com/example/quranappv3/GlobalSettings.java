package com.example.quranappv3;

public class GlobalSettings {
    private String urduTranslator;
    private String EnglishTraslator;

    private static final GlobalSettings ourInstance = new GlobalSettings();
    public static GlobalSettings getInstance() {
        return ourInstance;
    }

    private GlobalSettings() {
        this.urduTranslator = "fateh";
        this.EnglishTraslator = "taqi";
    }


    public String getUrduTranslator() {
        return urduTranslator;
    }

    public void setUrduTranslator(String urduTranslator) {
        this.urduTranslator = urduTranslator;
    }

    public String getEnglishTraslator() {
        return EnglishTraslator;
    }

    public void setEnglishTraslator(String englishTraslator) {
        EnglishTraslator = englishTraslator;
    }
}
