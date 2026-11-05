package cn.richinfo.mthttp.service;

import android.annotation.SuppressLint;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.IntentFilter;
import b1.a;
import com.richinfo.mthttp.Constant;
import com.richinfo.mthttp.MTSDK;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public class MTHeartJobService extends JobService {
    public a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JobParameters f547b;

    @Override // android.app.Service
    public final void onDestroy() {
        try {
            j2.a.C("心跳服务", "销毁心跳服务");
            a aVar = this.a;
            if (aVar != null) {
                unregisterReceiver(aVar);
                this.a = null;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        MTSDK.getInstance().init(getApplication(), 1);
        j2.a.C("心跳服务", "启动心跳服务");
        MTSDK.getInstance().heartClient();
        this.a = new a(this);
        this.f547b = jobParameters;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constant.BROADCAST_JOB_HEART);
        registerReceiver(this.a, intentFilter);
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
