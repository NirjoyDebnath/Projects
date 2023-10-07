package com.example.advancedcalculator;

public class History {
    private String input,i2,i3,i4,i5;
    public History() {


    }

    public History(String input, String i2, String i3, String i4, String i5) {
        this.input = input;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
        this.i5 = i5;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getI2() {
        return i2;
    }

    public void setI2(String i2) {
        this.i2 = i2;
    }

    public String getI3() {
        return i3;
    }

    public void setI3(String i3) {
        this.i3 = i3;
    }

    public String getI4() {
        return i4;
    }

    public void setI4(String i4) {
        this.i4 = i4;
    }

    public String getI5() {
        return i5;
    }

    public void setI5(String i5) {
        this.i5 = i5;
    }
}
