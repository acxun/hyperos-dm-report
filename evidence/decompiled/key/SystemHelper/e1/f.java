package e1;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import g1.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f extends Thread {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PackageManager f2485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f2486e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f2488g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private e1.b f2489h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f2483b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f2484c = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<g1.b> f2487f = null;

    public interface a {
        void a(Context context, e1.b bVar, List<g1.b> list);
    }

    class b implements Comparator<UsageStats> {
        b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(UsageStats usageStats, UsageStats usageStats2) {
            return (int) (usageStats2.getTotalTimeInForeground() - usageStats.getTotalTimeInForeground());
        }
    }

    public f(Context context, e1.b bVar, a aVar) {
        this.f2486e = context;
        this.f2489h = bVar;
        this.f2488g = aVar;
    }

    private g1.b a(List<ApplicationInfo> list, UsageStats usageStats, UsageStatsManager usageStatsManager) {
        g1.b bVar = new g1.b();
        bVar.e(usageStats.getPackageName());
        for (ApplicationInfo applicationInfo : list) {
            if (applicationInfo.packageName.equalsIgnoreCase(usageStats.getPackageName())) {
                bVar.p(applicationInfo.uid);
                bVar.c((String) applicationInfo.loadLabel(this.f2485d));
                break;
            }
        }
        bVar.f(usageStats.getTotalTimeInForeground() / 60000);
        try {
            bVar.d(b(usageStatsManager, usageStats.getPackageName()));
            c(bVar);
            return bVar;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private int b(UsageStatsManager usageStatsManager, String str) {
        int i2 = 0;
        try {
            UsageEvents usageEventsQueryEvents = usageStatsManager.queryEvents(this.f2484c, this.f2483b);
            while (usageEventsQueryEvents.hasNextEvent()) {
                UsageEvents.Event event = new UsageEvents.Event();
                usageEventsQueryEvents.getNextEvent(event);
                if (event.getEventType() == 7 && str.equals(event.getPackageName())) {
                    i2++;
                }
                if (event.getEventType() == 1 && str.equals(event.getPackageName())) {
                    i2++;
                }
            }
        } catch (Exception e2) {
            h.b("QueryAppInfoThread", "Error querying usage events for package: " + e2);
        }
        return i2;
    }

    private void c(g1.b bVar) {
        long txBytes;
        long rxBytes;
        long txBytes2;
        long rxBytes2;
        long txBytes3;
        NetworkStatsManager networkStatsManager = (NetworkStatsManager) this.f2486e.getSystemService("netstats");
        String str = this.f2489h.f2458i;
        long rxBytes3 = 0;
        NetworkStats networkStatsQuerySummary = null;
        if (str != null && !str.isEmpty()) {
            NetworkStats.Bucket bucket = new NetworkStats.Bucket();
            try {
                networkStatsQuerySummary = networkStatsManager.querySummary(0, this.f2489h.f2458i, this.f2484c, this.f2483b);
                rxBytes2 = 0;
                txBytes3 = 0;
                do {
                    try {
                        networkStatsQuerySummary.getNextBucket(bucket);
                        if (bVar.b() == bucket.getUid()) {
                            rxBytes2 += bucket.getRxBytes();
                            txBytes3 += bucket.getTxBytes();
                        }
                    } catch (RemoteException e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                } while (networkStatsQuerySummary.hasNextBucket());
            } catch (RemoteException e3) {
                e = e3;
                rxBytes2 = 0;
                txBytes3 = 0;
            }
            networkStatsQuerySummary.close();
            bVar.m(txBytes3 / 1024);
            bVar.g(rxBytes2 / 1024);
            bVar.j((txBytes3 + rxBytes2) / 1024);
        }
        String str2 = this.f2489h.f2471v;
        if (str2 != null && !str2.isEmpty()) {
            NetworkStats.Bucket bucket2 = new NetworkStats.Bucket();
            try {
                networkStatsQuerySummary = networkStatsManager.querySummary(0, this.f2489h.f2471v, this.f2484c, this.f2483b);
                rxBytes = 0;
                txBytes2 = 0;
                do {
                    try {
                        networkStatsQuerySummary.getNextBucket(bucket2);
                        if (bVar.b() == bucket2.getUid()) {
                            rxBytes += bucket2.getRxBytes();
                            txBytes2 += bucket2.getTxBytes();
                        }
                    } catch (RemoteException e4) {
                        e = e4;
                        e.printStackTrace();
                    }
                } while (networkStatsQuerySummary.hasNextBucket());
            } catch (RemoteException e5) {
                e = e5;
                rxBytes = 0;
                txBytes2 = 0;
            }
            networkStatsQuerySummary.close();
            bVar.n(txBytes2 / 1024);
            bVar.h(rxBytes / 1024);
            bVar.k((txBytes2 + rxBytes) / 1024);
        }
        NetworkStats.Bucket bucket3 = new NetworkStats.Bucket();
        try {
            networkStatsQuerySummary = networkStatsManager.querySummary(1, null, this.f2484c, this.f2483b);
            txBytes = 0;
            do {
                try {
                    networkStatsQuerySummary.getNextBucket(bucket3);
                    if (bVar.b() == bucket3.getUid()) {
                        rxBytes3 += bucket3.getRxBytes();
                        txBytes += bucket3.getTxBytes();
                    }
                } catch (RemoteException e6) {
                    e = e6;
                    e.printStackTrace();
                }
            } while (networkStatsQuerySummary.hasNextBucket());
        } catch (RemoteException e7) {
            e = e7;
            txBytes = 0;
        }
        networkStatsQuerySummary.close();
        bVar.o(txBytes / 1048576);
        bVar.i(rxBytes3 / 1048576);
        bVar.l((txBytes + rxBytes3) / 1048576);
    }

    private List<UsageStats> d() {
        UsageStatsManager usageStatsManager = (UsageStatsManager) this.f2486e.getSystemService("usagestats");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, UsageStats>> it = usageStatsManager.queryAndAggregateUsageStats(this.f2484c, this.f2483b).entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    private List<g1.b> e() {
        if (!g1.d.f2652e) {
            return null;
        }
        h.a("QueryAppInfoThread", "queryAppUsageStatsDescend  isUserPermissionOpen :" + g1.d.f2652e);
        PackageManager packageManager = this.f2486e.getPackageManager();
        this.f2485d = packageManager;
        List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(0);
        UsageStatsManager usageStatsManager = (UsageStatsManager) this.f2486e.getSystemService("usagestats");
        List<UsageStats> listD = d();
        if (listD != null) {
            Collections.sort(listD, new b());
        }
        ArrayList arrayList = new ArrayList();
        Iterator<UsageStats> it = listD.iterator();
        while (it.hasNext()) {
            arrayList.add(a(installedApplications, it.next(), usageStatsManager));
        }
        return arrayList;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.f2484c == 0 && this.f2483b == 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f2483b = jCurrentTimeMillis;
            this.f2484c = jCurrentTimeMillis - g1.d.f2667t;
        }
        this.f2487f = e();
        if (g1.d.f2652e) {
            h.a("QueryAppInfoThread", "queryAppUsageStatsDescend  isUserPermissionOpen :" + g1.d.f2652e);
            this.f2488g.a(this.f2486e, this.f2489h, this.f2487f);
        }
    }
}
