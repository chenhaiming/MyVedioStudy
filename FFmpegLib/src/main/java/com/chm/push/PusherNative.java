package com.chm.push;

/**
 * Created by dell on 2018/3/9.
 */

public class PusherNative {


    static {
        System.loadLibrary("jx_ffmpeg_jni");
    }

    public native void test();

    public native void startPush(String url);
    public native void stopPush();
    public native void release();
    /**
     * 格式参数
     * @param w
     * @param h
     * @param fps
     */
    public native void setVideoOption(int w, int h, int fps);
    /**
     * 发送数据
     * @param data
     */
    public native void fireVideo(byte[] data);

}