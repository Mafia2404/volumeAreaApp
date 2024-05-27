package com.example.volumeareaapp;

public class ModalClassShape {
    private int shapeImg;
    private String imgName;

    public ModalClassShape(int shapeImg, String imgName) {
        this.shapeImg = shapeImg;
        this.imgName = imgName;
    }

    public int getShapeImg() {
        return shapeImg;
    }

    public void setShapeImg(int shapeImg) {
        this.shapeImg = shapeImg;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }
}
