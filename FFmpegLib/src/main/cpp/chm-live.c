//
// Created by dell on 2018/3/9.
//
#include "chm-live.h"


JNIEXPORT void JNICALL Java_com_chm_push_PusherNative_test(JNIEnv *env, jclass jclz) {
    LOGE("%s", "jnicall");
}

JNIEXPORT void JNICALL Java_com_chm_push_PusherNative_startPush(JNIEnv *env, jclass jclz, jstring jurl){

}

JNIEXPORT void JNICALL Java_com_chm_push_PusherNative_stopPush(JNIEnv *env, jclass jclz){

}

JNIEXPORT void JNICALL Java_com_chm_push_PusherNative_release(JNIEnv *env, jclass jclz){

}

JNIEXPORT void JNICALL Java_com_chm_push_PusherNative_setVideoOption(JNIEnv *env, jclass jclz
        ,jint jw, jint jh, jint jbit, jint jfps){

}

JNIEXPORT void JNICALL Java_com_chm_push_PusherNative_fireVideo(JNIEnv *env, jclass jclz, jbyteArray jdata){

    LOGE("size of data is : %d", "jdata");

}