package com.chm.myvediostudy;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;

import com.chm.myvediostudy.audio.AudioCapturer;

import java.io.IOException;

public class MainActivityCopy extends AppCompatActivity implements SurfaceHolder.Callback {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }


    private SurfaceView mSurfaceView;
    private Camera mCamear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        AudioCapturer audioCapturer = new AudioCapturer();
        audioCapturer.createAudioRecord();
        audioCapturer.startRecord();

        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
    }

    private void initView() {
        mSurfaceView = findViewById(R.id.surfaceview);
        mSurfaceView.getHolder().addCallback(this);
        mCamear = Camera.open();
        mCamear.setDisplayOrientation(90);
    }
    public native String stringFromJNI();

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            mCamear.setPreviewDisplay(holder);
            mCamear.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mCamear.release();
    }
}
