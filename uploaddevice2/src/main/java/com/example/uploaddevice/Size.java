package com.example.uploaddevice;

import java.io.Serializable;

/**
 * Created by Jackson Fu on 15/7/23.
 */
public class Size implements Serializable {

    public int width;

    public int height;

    public float xdpi;

    public  float ydpi;

    public  float density;
    public int densityDpi;

    public Size() {

    }

    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Size(int width, int height, float xdpi, float ydpi, float density, int densityDpi) {
        this.width = width;
        this.height = height;
        this.xdpi = xdpi;
        this.ydpi = ydpi;
        this.density = density;
        this.densityDpi = densityDpi;
    }

    public float getXdpi() {
        return xdpi;
    }

    public void setXdpi(float xdpi) {
        this.xdpi = xdpi;
    }

    public float getYdpi() {
        return ydpi;
    }

    public void setYdpi(float ydpi) {
        this.ydpi = ydpi;
    }

    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public int getDensityDpi() {
        return densityDpi;
    }

    public void setDensityDpi(int densityDpi) {
        this.densityDpi = densityDpi;
    }



    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
