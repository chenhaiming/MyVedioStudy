package com.chm.myvediostudy;

import android.content.Intent;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;
import android.widget.Toast;

import com.chm.myvediostudy.audio.AudioCapturer;
import com.chm.myvediostudy.entry.Person;
import com.chm.ui.VedioActivity;

import java.io.IOException;

import javax.inject.Inject;

import dagger.Lazy;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Inject
    Lazy<Person> mKobe;
    private SurfaceView mSurfaceView;
    private Camera mCamear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("TAG", "Init");
        initView();

//        AudioCapturer audioCapturer = new AudioCapturer();
//        audioCapturer.createAudioRecord();
//        audioCapturer.startRecord();
//
//        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());

        startActivity(new Intent(MainActivity.this, VedioActivity.class));
    }

    private void initView() {
//        mSurfaceView = findViewById(R.id.surfaceview);
//        mSurfaceView.getHolder().addCallback(this);
//        mCamear = Camera.open();
//        mCamear.setDisplayOrientation(90);
//        Toast.makeText(this, mKobe.get().getName(), Toast.LENGTH_SHORT).show();

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
