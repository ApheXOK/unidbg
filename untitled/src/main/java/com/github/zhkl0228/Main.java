package com.github.zhkl0228;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String text = "/dash?tvid=668374600&bid=0&&vid=&abid=600&src=02022001010000000000&vt=2&uid=&ut=1&tm=1687594181098&qd_v=1&k_uid=000000000000000&pt=0&lid=0&cf=0&ct=0&k_ver=10.12.5&k_ft1=704443624456704&k_ft2=2147483647&k_ft4=8&k_ft5=1";
        NativeUtils instance = new NativeUtils("test/iqiyi_mobile_6.11.apk", "test/libprotect.so", "com/qiyi/Protect");
        instance.getVf(text);
        instance.destroy();
    }
}