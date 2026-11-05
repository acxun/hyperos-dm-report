package com.richinfo.mthttp.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import com.google.gson.Gson;
import com.richinfo.mthttp.Constant;
import com.richinfo.mthttp.MTSDK;
import com.richinfo.mthttp.entity.RuleConfigEntity;
import com.richinfo.mthttp.utils.SPUtils;
import j2.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import z0.g;

/* JADX INFO: loaded from: classes.dex */
public class MTService extends Service {
    public JobScheduler a;

    /* JADX WARN: Code duplicated, block: B:18:0x00af  */
    /* JADX WARN: Code duplicated, block: B:20:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:21:0x00db  */
    /* JADX WARN: Code duplicated, block: B:23:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:24:0x0127  */
    /* JADX WARN: Code duplicated, block: B:29:0x0137 A[Catch: Exception -> 0x015c, TryCatch #0 {Exception -> 0x015c, blocks: (B:27:0x0133, B:29:0x0137, B:30:0x0144), top: B:63:0x0133 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0162  */
    /* JADX WARN: Code duplicated, block: B:40:0x016b  */
    /* JADX WARN: Code duplicated, block: B:41:0x016f A[Catch: Exception -> 0x0214, TryCatch #1 {Exception -> 0x0214, blocks: (B:38:0x0167, B:56:0x0204, B:41:0x016f, B:43:0x019e, B:46:0x01a6, B:48:0x01af, B:49:0x01b9, B:51:0x01dc, B:52:0x01e1, B:54:0x01f2, B:55:0x01f8, B:57:0x0208), top: B:65:0x0167 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x01af A[Catch: Exception -> 0x0214, TryCatch #1 {Exception -> 0x0214, blocks: (B:38:0x0167, B:56:0x0204, B:41:0x016f, B:43:0x019e, B:46:0x01a6, B:48:0x01af, B:49:0x01b9, B:51:0x01dc, B:52:0x01e1, B:54:0x01f2, B:55:0x01f8, B:57:0x0208), top: B:65:0x0167 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x01dc A[Catch: Exception -> 0x0214, TryCatch #1 {Exception -> 0x0214, blocks: (B:38:0x0167, B:56:0x0204, B:41:0x016f, B:43:0x019e, B:46:0x01a6, B:48:0x01af, B:49:0x01b9, B:51:0x01dc, B:52:0x01e1, B:54:0x01f2, B:55:0x01f8, B:57:0x0208), top: B:65:0x0167 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x01f2 A[Catch: Exception -> 0x0214, TryCatch #1 {Exception -> 0x0214, blocks: (B:38:0x0167, B:56:0x0204, B:41:0x016f, B:43:0x019e, B:46:0x01a6, B:48:0x01af, B:49:0x01b9, B:51:0x01dc, B:52:0x01e1, B:54:0x01f2, B:55:0x01f8, B:57:0x0208), top: B:65:0x0167 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x01f8 A[Catch: Exception -> 0x0214, TryCatch #1 {Exception -> 0x0214, blocks: (B:38:0x0167, B:56:0x0204, B:41:0x016f, B:43:0x019e, B:46:0x01a6, B:48:0x01af, B:49:0x01b9, B:51:0x01dc, B:52:0x01e1, B:54:0x01f2, B:55:0x01f8, B:57:0x0208), top: B:65:0x0167 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0133 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:18:0x00af, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:23:0x00ff, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:41:0x016f, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:55:0x01f8, please report this as an issue */
    public final boolean a() {
        boolean z3;
        String str;
        long reportTime;
        int iSchedule;
        String str2;
        int maxRetryNum;
        long reportTime2;
        String strB;
        boolean z4;
        JobScheduler jobScheduler;
        String str3;
        a.C("核心保活服务", "开始校验当天最大上报总数");
        try {
            try {
                int maxReportCount = SPUtils.getMaxReportCount();
                int i3 = Integer.parseInt(SPUtils.getReportCount());
                if (i3 < maxReportCount) {
                    str3 = "当前" + i3 + "次，未达到当天最大上报次数" + maxReportCount;
                } else {
                    long reportTime3 = (((long) ((RuleConfigEntity) new Gson().fromJson(SPUtils.getRuleConfig(), RuleConfigEntity.class)).getReportTime()) * 60 * 1000) + SPUtils.getReportTime();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (reportTime3 > jCurrentTimeMillis) {
                        a.C("核心保活服务", "在" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(reportTime3)) + "前达到最大上报次数上限" + maxReportCount);
                        z3 = true;
                        if (z3) {
                            str = "核心保活服务";
                        } else {
                            a.C("核心保活服务", "开始检查重试次数");
                            maxRetryNum = SPUtils.getMaxRetryNum();
                            a.B("当前重试次数->" + g.f3257d);
                            if (g.f3257d <= SPUtils.getMaxRetryNum()) {
                                strB = androidx.activity.result.a.b("未达到最大重试次数->", maxRetryNum);
                                str = "核心保活服务";
                            } else {
                                reportTime2 = (((long) ((RuleConfigEntity) new Gson().fromJson(SPUtils.getRuleConfig(), RuleConfigEntity.class)).getReportTime()) * 60 * 1000) + SPUtils.getReportTime();
                                if (reportTime2 > System.currentTimeMillis()) {
                                    str = "核心保活服务";
                                    a.C(str, "在" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(reportTime2)) + "前达到最大重试次数上限" + maxRetryNum);
                                    z4 = true;
                                } else {
                                    str = "核心保活服务";
                                    g.f3257d = 0;
                                    strB = "重置操作触发，重置最大重试数为0";
                                }
                                if (!z4) {
                                    try {
                                        jobScheduler = this.a;
                                        if (jobScheduler != null) {
                                            jobScheduler.cancel(418);
                                            a.C(str, "移除定时计划");
                                            g.f3255b = false;
                                        }
                                        ((AlarmManager) getSystemService("alarm")).cancel(PendingIntent.getBroadcast(this, 0, new Intent(Constant.BROADCAST_ALARM_DATE_RESET), 201326592));
                                        return true;
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                        return true;
                                    }
                                }
                            }
                            a.C(str, strB);
                            z4 = false;
                            if (!z4) {
                                jobScheduler = this.a;
                                if (jobScheduler != null) {
                                    jobScheduler.cancel(418);
                                    a.C(str, "移除定时计划");
                                    g.f3255b = false;
                                }
                                ((AlarmManager) getSystemService("alarm")).cancel(PendingIntent.getBroadcast(this, 0, new Intent(Constant.BROADCAST_ALARM_DATE_RESET), 201326592));
                                return true;
                            }
                        }
                        if (g.f3255b) {
                            reportTime = ((RuleConfigEntity) new Gson().fromJson(SPUtils.getRuleConfig(), RuleConfigEntity.class)).getReportTime();
                            a.C(str, "重置计时器将在" + reportTime + "分钟后执行");
                            if (MTSDK.getHeartChanel() != 1 && MTSDK.getHeartChanel() != 2) {
                                a.C(str, "JobServer模式");
                                if (this.a == null) {
                                    this.a = (JobScheduler) getSystemService("jobscheduler");
                                }
                                this.a.cancel(418);
                                JobInfo.Builder builder = new JobInfo.Builder(418, new ComponentName(getPackageName(), MTAlarmJobService.class.getName()));
                                if (reportTime < 900) {
                                    a.C(str, "由于android机制，重置计时器任务太短，最低支持时间15分钟，可能会被系统调整到15分钟");
                                }
                                builder.setMinimumLatency(reportTime * 60 * 1000);
                                iSchedule = this.a.schedule(builder.build());
                                if (iSchedule > 0) {
                                    g.f3255b = true;
                                    str2 = "重置计时器服务启动成功";
                                } else {
                                    str2 = "重置计时器服务启动失败->" + iSchedule;
                                }
                            }
                            a.C(str, "闹钟模式进行定时计划");
                            t0.g.d0(this, reportTime * 60 * 1000, Constant.BROADCAST_ALARM_DATE_RESET, false);
                            return false;
                        }
                        str2 = "已开启重置计时器，不再重复开启";
                        a.C(str, str2);
                        return false;
                    }
                    SPUtils.setReportTime(jCurrentTimeMillis);
                    SPUtils.setReportCount(Constant.SP_MODEL);
                    str3 = "日期变更，重置最大次数为0";
                }
                a.C("核心保活服务", str3);
                z3 = false;
            } catch (Exception e4) {
                e4.printStackTrace();
                a.E("核心保活服务", "checkReportCount 异常 返回true" + e4.getMessage());
            }
            if (g.f3255b) {
                reportTime = ((RuleConfigEntity) new Gson().fromJson(SPUtils.getRuleConfig(), RuleConfigEntity.class)).getReportTime();
                a.C(str, "重置计时器将在" + reportTime + "分钟后执行");
                if (MTSDK.getHeartChanel() != 1) {
                    a.C(str, "JobServer模式");
                    if (this.a == null) {
                        this.a = (JobScheduler) getSystemService("jobscheduler");
                    }
                    this.a.cancel(418);
                    JobInfo.Builder builder2 = new JobInfo.Builder(418, new ComponentName(getPackageName(), MTAlarmJobService.class.getName()));
                    if (reportTime < 900) {
                        a.C(str, "由于android机制，重置计时器任务太短，最低支持时间15分钟，可能会被系统调整到15分钟");
                    }
                    builder2.setMinimumLatency(reportTime * 60 * 1000);
                    iSchedule = this.a.schedule(builder2.build());
                    if (iSchedule > 0) {
                        g.f3255b = true;
                        str2 = "重置计时器服务启动成功";
                    } else {
                        str2 = "重置计时器服务启动失败->" + iSchedule;
                    }
                }
                a.C(str, "闹钟模式进行定时计划");
                t0.g.d0(this, reportTime * 60 * 1000, Constant.BROADCAST_ALARM_DATE_RESET, false);
                return false;
            }
            str2 = "已开启重置计时器，不再重复开启";
            a.C(str, str2);
            return false;
        } catch (Exception e5) {
            e5.printStackTrace();
            return false;
        }
        if (z3) {
            a.C("核心保活服务", "开始检查重试次数");
            maxRetryNum = SPUtils.getMaxRetryNum();
            a.B("当前重试次数->" + g.f3257d);
            if (g.f3257d <= SPUtils.getMaxRetryNum()) {
                strB = androidx.activity.result.a.b("未达到最大重试次数->", maxRetryNum);
                str = "核心保活服务";
            } else {
                reportTime2 = (((long) ((RuleConfigEntity) new Gson().fromJson(SPUtils.getRuleConfig(), RuleConfigEntity.class)).getReportTime()) * 60 * 1000) + SPUtils.getReportTime();
                if (reportTime2 > System.currentTimeMillis()) {
                    str = "核心保活服务";
                    a.C(str, "在" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(reportTime2)) + "前达到最大重试次数上限" + maxRetryNum);
                    z4 = true;
                } else {
                    str = "核心保活服务";
                    g.f3257d = 0;
                    strB = "重置操作触发，重置最大重试数为0";
                }
                if (!z4) {
                    jobScheduler = this.a;
                    if (jobScheduler != null) {
                        jobScheduler.cancel(418);
                        a.C(str, "移除定时计划");
                        g.f3255b = false;
                    }
                    ((AlarmManager) getSystemService("alarm")).cancel(PendingIntent.getBroadcast(this, 0, new Intent(Constant.BROADCAST_ALARM_DATE_RESET), 201326592));
                    return true;
                }
            }
            a.C(str, strB);
            z4 = false;
            if (!z4) {
                jobScheduler = this.a;
                if (jobScheduler != null) {
                    jobScheduler.cancel(418);
                    a.C(str, "移除定时计划");
                    g.f3255b = false;
                }
                ((AlarmManager) getSystemService("alarm")).cancel(PendingIntent.getBroadcast(this, 0, new Intent(Constant.BROADCAST_ALARM_DATE_RESET), 201326592));
                return true;
            }
        } else {
            str = "核心保活服务";
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        long j3;
        super.onCreate();
        a.g0("核心保活服务", "启动服务");
        try {
            j3 = Long.parseLong(SPUtils.getFirstInstallTime());
        } catch (Exception e3) {
            e3.printStackTrace();
            j3 = 0;
        }
        if (j3 <= 0) {
            a.C("核心保活服务", "首次安装，写入当前日期");
            SPUtils.setFirstInstallTime(System.currentTimeMillis() + "");
            try {
                SPUtils.setReportTime(System.currentTimeMillis());
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        MTSDK.getInstance().IMTService.onCreate(this);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        a.C("核心保活服务", "控制服务被销毁");
        MTSDK.getInstance().IMTService.onDestroy();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i3) {
        super.onStart(intent, i3);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i4) {
        if (intent == null) {
            a.E("核心保活服务", "intent==null");
        } else {
            MTSDK.getInstance().IMTService.onStartCommand(intent, i3, i4);
        }
        return super.onStartCommand(intent, i3, i4);
    }
}
