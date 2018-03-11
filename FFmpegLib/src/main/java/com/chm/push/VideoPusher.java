package com.chm.push;

import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;

import com.chm.param.VideoParam;

import java.io.IOException;

/**
 * Created by dell on 2018/3/8.
 */

public class VideoPusher extends Pusher implements SurfaceHolder.Callback, Camera.PreviewCallback {

    private SurfaceHolder surfaceHolder;
    private Camera camera;
    private VideoParam videoParams;

    private PusherNative mPushNative;

    private byte[] buffers;

    public VideoPusher(SurfaceHolder surfaceHolder, PusherNative mPushNative, VideoParam videoParams) {
        this.surfaceHolder = surfaceHolder;
        this.videoParams = videoParams;
        this.mPushNative = mPushNative;
        surfaceHolder.addCallback(this);
    }

    @Override
    public void startPush() {
        startPreview();
        mPushNative.test();
    }

    private void startPreview() {
        try {
            camera = Camera.open(videoParams.getCameraId());
            camera.setDisplayOrientation(90);
            camera.setPreviewDisplay(surfaceHolder);
            buffers = new byte[videoParams.getWidth() * videoParams.getHeight() * 4];
            camera.addCallbackBuffer(buffers);
            camera.setPreviewCallbackWithBuffer(this);
//            camera.startPreview();


            camera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stopPus() {
        camera.stopPreview();
        camera.release();
    }

    @Override
    public void release() {

    }

    @Override
    public void onPreviewFrame(byte[] data, Camera camera) {
        if (camera != null) {
            camera.addCallbackBuffer(buffers);
        }
        mPushNative.fireVideo(buffers);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}