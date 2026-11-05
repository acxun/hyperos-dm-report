package com.richinfo.mthttp.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.IntentFilter;
import b1.a;
import com.richinfo.mthttp.Constant;
import com.richinfo.mthttp.MTSDK;
import z0.g;

/* JADX INFO: loaded from: classes.dex */
public class MTAlarmJobService extends JobService {
    public JobParameters a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f748b = "重置服务";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f749c;

    @Override // android.app.Service
    public final void onDestroy() {
        try {
            j2.a.C(this.f748b, "停止重置服务");
            a aVar = this.f749c;
            if (aVar != null) {
                unregisterReceiver(aVar);
                this.f749c = null;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        int i3 = getSharedPreferences(Constant.SP_CONFIG_FILE, 0).getInt(Constant.SP_MODEL, 0);
        MTSDK.getInstance().init(getApplication(), i3);
        j2.a.C(this.f748b, "开启重置服务->" + i3);
        MTSDK.getInstance().startClient();
        g.f3255b = false;
        this.a = jobParameters;
        this.f749c = new a(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constant.BROADCAST_JOB_ALARM);
        registerReceiver(this.f749c, intentFilter);
        return false;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
