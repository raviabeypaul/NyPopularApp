#include <jni.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_ravi_newsNyTimes_utility_Constant_baseUrl(JNIEnv *env, jclass type) {
    return env->NewStringUTF("http://api.nytimes.com/svc/");
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_ravi_newsNyTimes_utility_Constant_getApiKey(JNIEnv *env, jclass type) {
    return env->NewStringUTF("W0gIB6AKrz8Bf7ywJbVPypQDbCVjyqPF");
}