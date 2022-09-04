package com.example.quranappv3;

public class Ayat {
    String ayatId;
    String suratId;
    String ayatNumber;
    String arabicText;
    String urduFateh;
    String UrduMehmood;
    String englishMohsin;
    String taqiUsmani;
    String parahId;
    String rakuId;
    String pRakuId;

    public Ayat(String ayatId, String suratId, String ayatNumber, String arabicText,
                String urduFateh, String urduMehmood, String englishMohsin, String taqiUsmani,  String rakuId, String pRakuId,String parahId) {
        this.ayatId = ayatId;
        this.suratId = suratId;
        this.ayatNumber = ayatNumber;
        this.arabicText = arabicText;
        this.urduFateh = urduFateh;
        UrduMehmood = urduMehmood;
        this.englishMohsin = englishMohsin;
        this.taqiUsmani = taqiUsmani;
        this.parahId = parahId;
        this.rakuId = rakuId;
        this.pRakuId = pRakuId;
    }

    public String getAyatId() {
        return ayatId;
    }

    public void setAyatId(String ayatId) {
        this.ayatId = ayatId;
    }

    public String getSuratId() {
        return suratId;
    }

    public void setSuratId(String suratId) {
        this.suratId = suratId;
    }

    public String getAyatNumber() {
        return ayatNumber;
    }

    public void setAyatNumber(String ayatNumber) {
        this.ayatNumber = ayatNumber;
    }

    public String getArabicText() {
        return arabicText;
    }

    public void setArabicText(String arabicText) {
        this.arabicText = arabicText;
    }

    public String getUrduFateh() {
        return urduFateh;
    }

    public void setUrduFateh(String urduFateh) {
        this.urduFateh = urduFateh;
    }

    public String getUrduMehmood() {
        return UrduMehmood;
    }

    public void setUrduMehmood(String urduMehmood) {
        UrduMehmood = urduMehmood;
    }

    public String getEnglishMohsin() {
        return englishMohsin;
    }

    public void setEnglishMohsin(String englishMohsin) {
        this.englishMohsin = englishMohsin;
    }

    public String getTaqiUsmani() {
        return taqiUsmani;
    }

    public void setTaqiUsmani(String taqiUsmani) {
        this.taqiUsmani = taqiUsmani;
    }

    public String getParahId() {
        return parahId;
    }

    public void setParahId(String parahId) {
        this.parahId = parahId;
    }

    public String getRakuId() {
        return rakuId;
    }

    public void setRakuId(String rakuId) {
        this.rakuId = rakuId;
    }

    public String getpRakuId() {
        return pRakuId;
    }

    public void setpRakuId(String pRakuId) {
        this.pRakuId = pRakuId;
    }
}
