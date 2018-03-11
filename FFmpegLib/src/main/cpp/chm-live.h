//
// Created by dell on 2018/3/9.
//


//#ifndef MYVEDIOSTUDY_CHM_LIVE_H
//#define MYVEDIOSTUDY_CHM_LIVE_H

#include <jni.h>
#include "jx_log.h"
#include <string.h>
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT void JNICALL Java_com_chm_push_PusherNative_test(JNIEnv *env, jclass jclz);

JNIEXPORT void JNICALL Java_com_chm_push_PusherNative_startPush(JNIEnv *env, jclass jclz, jstring jurl);

JNIEXPORT void JNICALL Java_com_chm_push_PusherNative_stopPush(JNIEnv *env, jclass jclz);

JNIEXPORT void JNICALL Java_com_chm_push_PusherNative_release(JNIEnv *env, jclass jclz);

JNIEXPORT void JNICALL Java_com_chm_push_PusherNative_setVideoOption(JNIEnv *env, jclass jclz
                                                                     ,jint jw, jint jh, jint jbit, jint jfps);

JNIEXPORT void JNICALL Java_com_chm_push_PusherNative_fireVideo(JNIEnv *env, jclass jclz, jbyteArray jdata);

#ifdef __cplusplus
};
#endif //MYVEDIOSTUDY_CHM_LIVE_H
