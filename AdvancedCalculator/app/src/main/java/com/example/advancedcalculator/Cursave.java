package com.example.advancedcalculator;

public class Cursave {

    private String dol,euro,cad,bit,rup;

    public Cursave(String dol, String euro, String cad, String bit, String rup) {
        this.dol = dol;
        this.euro = euro;
        this.cad = cad;
        this.bit = bit;
        this.rup = rup;
    }

    public String getDol() {
        return dol;
    }

    public void setDol(String dol) {
        this.dol = dol;
    }

    public String getEuro() {
        return euro;
    }

    public void setEuro(String euro) {
        this.euro = euro;
    }

    public String getCad() {
        return cad;
    }

    public void setCad(String cad) {
        this.cad = cad;
    }

    public String getBit() {
        return bit;
    }

    public void setBit(String bit) {
        this.bit = bit;
    }

    public String getRup() {
        return rup;
    }

    public void setRup(String rup) {
        this.rup = rup;
    }
}
