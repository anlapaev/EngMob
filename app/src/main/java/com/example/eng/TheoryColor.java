package com.example.eng;

public class TheoryColor {
    private String colorText;
    private String colorDesc;
    private int colorInt;

    public TheoryColor(String colorText, String colorDesc, int colorInt) {
        this.colorText = colorText;
        this.colorDesc = colorDesc;
        this.colorInt = colorInt;
    }

    public String getColorText() {
        return colorText;
    }

    public void setColorText(String colorText) {
        this.colorText = colorText;
    }

    public String getColorDesc() {
        return colorDesc;
    }

    public void setColorDesc(String colorDesc) {
        this.colorDesc = colorDesc;
    }

    public int getColorInt() {
        return colorInt;
    }

    public void setColorInt(int colorInt) {
        this.colorInt = colorInt;
    }
}
