package com.chm.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import com.chm.push.LivePusher;
import com.mabeijianxi.smallvideorecord2.R;

/**
 * Created by dell on 2018/3/8.
 */

public class VedioActivity extends Activity {

    private Button btnTtart, btnStop;
    private SurfaceView mSurfaceView;
    private LivePusher livePusher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_recorder);
        initView();
    }

    private void initView() {

        mSurfaceView = (SurfaceView) findViewById(R.id.pre_view);
        livePusher = new LivePusher(mSurfaceView.getHolder());

        findViewById(R.id.btn_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                livePusher.stopPusher();
            }
        });
        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                livePusher.startPusher();
            }
        });
    }

}