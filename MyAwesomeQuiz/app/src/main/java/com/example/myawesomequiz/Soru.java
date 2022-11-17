package com.example.myawesomequiz;

public class Soru {
    private String Soru;
    private String Secenek1;
    private String Secenek2;
    private String Secenek3;
    private int cevapNr;

    public Soru(){}

    public Soru(String soru, String secenek1, String secenek2, String secenek3, int cevapNr) {
        Soru = soru;
        Secenek1 = secenek1;
        Secenek2 = secenek2;
        Secenek3 = secenek3;
        this.cevapNr = cevapNr;
    }

    public String getSoru() {
        return Soru;
    }

    public void setSoru(String soru) {
        Soru = soru;
    }

    public String getSecenek1() {
        return Secenek1;
    }

    public void setSecenek1(String secenek1) {
        Secenek1 = secenek1;
    }

    public String getSecenek2() {
        return Secenek2;
    }

    public void setSecenek2(String secenek2) {
        Secenek2 = secenek2;
    }

    public String getSecenek3() {
        return Secenek3;
    }

    public void setSecenek3(String secenek3) {
        Secenek3 = secenek3;
    }

    public int getCevapNr() {
        return cevapNr;
    }

    public void setCevapNr(int cevapNr) {
        this.cevapNr = cevapNr;
    }
}
