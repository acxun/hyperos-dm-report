package com.richinfo.mthttp;

import a2.a;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import b2.b;
import cn.richinfo.mthttp.service.HttpService;
import com.dmyk.android.mt.IDeviceForMt;
import com.richinfo.mthttp.service.IMTService;
import com.richinfo.mthttp.service.MTService;
import com.richinfo.mthttp.utils.SPUtils;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class MTSDK {
    public static final String API_VERSION = "4.0.1";
    private static boolean DEBUG_MODE = false;
    public static int HEART_CHANNEL = 1;
    public static final int HEART_CHANNEL_DYNAMIC_ALARM = 1;
    public static final int HEART_CHANNEL_JOBSERVER = 0;
    public static final int HEART_CHANNEL_STATIC_ALARM = 2;
    public static final int MODEL_HTTP = 1;
    public static final int MODEL_LWM2M = 0;
    public static final String SDK_VERSION = "4.0.9";
    private static final String TAG = "lwm2m核心";
    public static String logDirPath = "";
    public static MTSDK mtSdk;
    public IMTService IMTService;
    public Application application;
    private a httpRequestAgent;
    public IDeviceForMt iDeviceForMT;
    private int model = 0;
    private volatile ScheduledThreadPoolExecutor mFixedThreadExecutor = null;

    private MTSDK() {
    }

    public static boolean getDebugMode() {
        return DEBUG_MODE;
    }

    public static int getHeartChanel() {
        return HEART_CHANNEL;
    }

    public static synchronized MTSDK getInstance() {
        if (mtSdk == null) {
            mtSdk = new MTSDK();
        }
        return mtSdk;
    }

    public static void setDebugMode(boolean z3) {
        j2.a.C(TAG, "setDebugMode() called with: debugMode =" + z3);
        DEBUG_MODE = z3;
        if (z3) {
            j2.a.f1457b = true;
            b.b("");
        }
    }

    public static void setHeartChanel(int i3) {
        HEART_CHANNEL = i3;
    }

    public void businessReport() {
        Intent intent = new Intent(this.application, (Class<?>) MTService.class);
        intent.putExtra(Constant.SERVER_MODEL, this.model);
        intent.setAction(Constant.SERVER_BUSINESS);
        try {
            this.application.startService(intent);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public Context getContext() {
        if (this.application == null && getDebugMode()) {
            new Throwable("请先在application进行初始化 MTSDK").printStackTrace();
        }
        return this.application.getApplicationContext();
    }

    public IDeviceForMt getDeviceManager() {
        if (this.iDeviceForMT == null) {
            new Throwable("请先调用 setDeviceManager 传入设备信息接口").printStackTrace();
        }
        return this.iDeviceForMT;
    }

    public ScheduledThreadPoolExecutor getExecutor() {
        if (this.mFixedThreadExecutor == null) {
            synchronized (MTSDK.class) {
                if (this.mFixedThreadExecutor == null) {
                    this.mFixedThreadExecutor = new ScheduledThreadPoolExecutor(8, new ThreadPoolExecutor.CallerRunsPolicy());
                    this.mFixedThreadExecutor.setMaximumPoolSize(16);
                    this.mFixedThreadExecutor.setKeepAliveTime(120L, TimeUnit.SECONDS);
                }
            }
        }
        return this.mFixedThreadExecutor;
    }

    public a getHttpRequestAgent() {
        return this.httpRequestAgent;
    }

    public void heartClient() {
        Intent intent = new Intent(this.application, (Class<?>) MTService.class);
        intent.putExtra(Constant.SERVER_MODEL, this.model);
        intent.setAction(Constant.SERVER_HEART);
        try {
            this.application.startService(intent);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void init(Application application, int i3) {
        if (this.application != null) {
            return;
        }
        try {
            this.model = i3;
            application.getSharedPreferences(Constant.SP_CONFIG_FILE, 0).edit().putInt(Constant.SP_MODEL, i3).apply();
            this.IMTService = (IMTService) (i3 == 1 ? HttpService.class : Class.forName("cn.richinfo.mtlwm2m.service.Lwm2mService")).newInstance();
            this.application = application;
            j2.a.g0(TAG, "MT SDK init , SDK_INT=" + Build.VERSION.SDK_INT);
            j2.a.g0(TAG, "Start service finish");
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void killClient() {
        Intent intent = new Intent(this.application, (Class<?>) MTService.class);
        intent.putExtra(Constant.SERVER_MODEL, this.model);
        intent.setAction(Constant.SERVER_KILL);
        try {
            this.application.startService(intent);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void resetClient() {
        Intent intent = new Intent(this.application, (Class<?>) MTService.class);
        intent.putExtra(Constant.SERVER_MODEL, this.model);
        intent.setAction(Constant.SERVER_RESET);
        try {
            this.application.startService(intent);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void setDeviceManager(IDeviceForMt iDeviceForMt) {
        this.iDeviceForMT = iDeviceForMt;
    }

    public void setHttpRequestAgent(a aVar) {
        this.httpRequestAgent = aVar;
    }

    public void setUrl(String str) {
        if (this.model == 1) {
            SPUtils.setHttpUrl(str);
        }
        if (this.model == 0) {
            SPUtils.setLwm2mUrl(str);
        }
    }

    public void startClient() {
        Intent intent = new Intent(this.application, (Class<?>) MTService.class);
        intent.putExtra(Constant.SERVER_MODEL, this.model);
        intent.setAction(Constant.SERVER_START);
        try {
            this.application.startService(intent);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void setDebugMode(boolean z3, String str) {
        j2.a.C(TAG, "setDebugMode() called with: debugMode =" + z3);
        if (!TextUtils.isEmpty(str)) {
            j2.a.C(TAG, "setDebugMode() called with: dirPath =" + str);
            logDirPath = str;
        }
        DEBUG_MODE = z3;
        if (z3) {
            j2.a.f1457b = true;
            b.b(str);
        }
    }
}
