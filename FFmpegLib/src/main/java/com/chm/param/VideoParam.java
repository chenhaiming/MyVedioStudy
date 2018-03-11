package com.chm.param;

/**
 * Created by dell on 2018/3/8.
 */

public class VideoParam {

    private int width;
    private int height;
    private int cameraId;

    public VideoParam(int width, int height, int cameraId) {
        this.cameraId = cameraId;
        this.width = width;
        this.height = height;
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

    public int getCameraId() {
        return cameraId;
    }

    public void setCameraId(int cameraId) {
        this.cameraId = cameraId;
    }
}
