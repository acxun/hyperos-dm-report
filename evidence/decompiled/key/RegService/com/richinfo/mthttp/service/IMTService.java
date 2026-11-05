package com.richinfo.mthttp.service;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public interface IMTService {
    void onCreate(MTService mTService);

    void onDestroy();

    void onStartCommand(Intent intent, int i3, int i4);
}
