package com.chm.push;

import android.hardware.Camera;
import android.view.SurfaceHolder;

import com.chm.param.AudioParam;
import com.chm.param.VideoParam;

/**
 * Created by dell on 2018/3/8.
 */

public class LivePusher implements SurfaceHolder.Callback {


    private SurfaceHolder surfaceHolder;
    private VideoPusher videoPusher;
    private AudioPusher audioPusher;
    private PusherNative pusherNative;
    public LivePusher(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        surfaceHolder.addCallback(this);
        prepare();
    }

    private void prepare() {
        pusherNative = new PusherNative();
        VideoParam videoParam = new VideoParam(1080, 920, Camera.CameraInfo.CAMERA_FACING_BACK);
        videoPusher = new VideoPusher(surfaceHolder,pusherNative ,videoParam);
        AudioParam audioParam = new AudioParam();
        audioPusher = new AudioPusher(audioParam);

    }


    public void startPusher() {
        videoPusher.startPush();
        audioPusher.startPush();
    }

    public void stopPusher() {
        videoPusher.stopPus();
        audioPusher.stopPus();
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
