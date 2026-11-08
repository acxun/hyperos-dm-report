package com.xiaomi.registration.autoregistration;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import i1.e;
import i1.g;
import i1.l;

/* JADX INFO: loaded from: classes.dex */
public class RegistrationJobService extends JobService {
    public final SparseArray a = new SparseArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f835b = new Handler();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f836c = null;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, boolean z2) {
        JobParameters jobParameters;
        l lVar;
        SparseArray sparseArray = this.a;
        if (sparseArray.size() == 0 || (jobParameters = (JobParameters) sparseArray.valueAt(0)) == null) {
            return;
        }
        jobFinished(jobParameters, false);
        sparseArray.removeAt(0);
        if (sparseArray.size() > 0) {
            c((JobParameters) sparseArray.valueAt(0));
        }
        e eVar = (e) jobParameters.getTransientExtras().getSerializable("REG_ENTITY");
        eVar.f1706d = z2;
        eVar.f1707e = str;
        eVar.f1708f = str2;
        Intent intent = new Intent("com.qualcomm.qti.action.AUTO_REGISTRATION");
        intent.putExtra("REG_ENTITY", eVar);
        intent.setFlags(268435456);
        intent.setClass(this, AutoRegReceiver.class);
        sendOrderedBroadcast(intent, null);
        if (!z2 || (lVar = (l) this.f836c.a) == null) {
            return;
        }
        Uri uri = Uri.parse("content://com.xiaomi.registration.service.GET_DEVICE_INFO");
        Context context = lVar.f1738d;
        ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(uri);
        if (contentProviderClientAcquireContentProviderClient != null) {
            context.getContentResolver().call(uri, "get_device_info", "STORE_DEVICE_INFO", lVar.a("STORE_DEVICE_INFO"));
            contentProviderClientAcquireContentProviderClient.close();
        }
    }

    public final void c(JobParameters jobParameters) {
        Log.d("AutoReg_JobService", "performJob job size = " + this.a.size());
        e eVar = (e) jobParameters.getTransientExtras().getSerializable("REG_ENTITY");
        if (eVar == null) {
            return;
        }
        Log.d("AutoReg_JobService", "performJob RegistrationEntity: " + eVar);
        this.f836c = TextUtils.isEmpty(eVar.f1707e) ? new g(this, this, eVar.f1704b, eVar.f1705c) : new g(this, eVar.f1707e);
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        SparseArray sparseArray = this.a;
        sparseArray.put(jobParameters.getJobId(), jobParameters);
        Log.d("AutoReg_JobService", "onStartJob job size = " + sparseArray.size());
        if (sparseArray.size() == 1) {
            c(jobParameters);
        }
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        StringBuilder sb = new StringBuilder("onStopJob job size = ");
        SparseArray sparseArray = this.a;
        sb.append(sparseArray.size());
        Log.d("AutoReg_JobService", sb.toString());
        int iIndexOfValue = sparseArray.indexOfValue(jobParameters);
        if (iIndexOfValue <= -1) {
            return false;
        }
        sparseArray.remove(iIndexOfValue);
        return false;
    }
}
