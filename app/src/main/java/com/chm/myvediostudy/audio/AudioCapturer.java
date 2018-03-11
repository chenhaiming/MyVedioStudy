package com.chm.myvediostudy.audio;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.SystemClock;
import android.util.Log;

/**
 * Created by dell on 2018/3/5.
 */

public class AudioCapturer {

    private static final String TAG = "AudioCapturer";

    private static final int DEFAULT_SOURCE = MediaRecorder.AudioSource.MIC;
    private static final int DEFAULT_SAMPLE_RATE = 44100;
    private static final int DEFAULT_CHANNEL_CONFIG = AudioFormat.CHANNEL_IN_STEREO;
    private static final int DEFAULT_AUDIO_FORMAT = AudioFormat.ENCODING_PCM_16BIT;

    private AudioRecord mAudioRecord = null;
    private int mRecordBufferSize = 0;
    private boolean isRecording = false;

    byte[] data;

    private Thread mRecordThread;

    public void createAudioRecord() {
        mRecordBufferSize = AudioRecord.getMinBufferSize(DEFAULT_SAMPLE_RATE, DEFAULT_CHANNEL_CONFIG, DEFAULT_AUDIO_FORMAT);
        mAudioRecord = new AudioRecord(DEFAULT_SOURCE, DEFAULT_SAMPLE_RATE, DEFAULT_CHANNEL_CONFIG, DEFAULT_AUDIO_FORMAT, mRecordBufferSize);
        data = new byte[mRecordBufferSize];
    }

    public void startRecord() {
        if (!isRecording) {
            mAudioRecord.startRecording();
            if (mRecordThread == null) {
                mRecordThread = new Thread(new AudioRecordRunnable());
            }
            mRecordThread.start();
            isRecording = true;
        }
    }

    private class AudioRecordRunnable implements Runnable {

        @Override
        public void run() {
            while (true) {
                int ret = mAudioRecord.read(data, 0, mRecordBufferSize);
                if (ret == AudioRecord.ERROR_INVALID_OPERATION) {
                    Log.d(TAG, "ERROR_INVALID_OPERATION " + ret + " bytes !");
                } else if (ret == AudioRecord.ERROR_BAD_VALUE) {
                    Log.d(TAG, "ERROR_BAD_VALUE " + ret + " bytes !");
                } else {
                    Log.d(TAG, "OK, Captured " + ret + " bytes !");
                }
                SystemClock.sleep(10);
            }
        }
    }
}