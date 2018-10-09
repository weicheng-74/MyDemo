package com.twc.mydemo;

public class ColorInfo {
    private String color;
    private int colorId;
    private int isSelect; //0取消，1选中

    public void setIsSelect(int isSelect) {
        this.isSelect = isSelect;
    }

    public int getIsSelect() {
        return isSelect;
    }

    public ColorInfo(String color, int colorId, int isSelect) {
        this.color = color;
        this.colorId = colorId;
        this.isSelect = isSelect;
    }

    public ColorInfo(String color, int colorId) {
        this.color = color;
        this.colorId = colorId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }
}
