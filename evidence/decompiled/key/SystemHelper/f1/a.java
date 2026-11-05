package f1;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.CellIdentity;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.NetworkRegistrationInfo;
import android.telephony.ServiceState;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements o.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2552a = h("persist.vendor.radio.5g_mode_pref", "0");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f2553b = h("persist.radio.vivo.fiveg", "false");

    public static String h(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
            return (objInvoke == null || !(objInvoke instanceof String)) ? str2 : (String) objInvoke;
        } catch (Exception e2) {
            Log.e("DeviceInfoReaderBase", "getString failed", e2);
            return str2;
        }
    }

    public static int i(int i2) {
        String strO = g1.l.o("ro.product.manufacturer");
        if (strO == null || strO.isEmpty()) {
            return -1;
        }
        if (!strO.equalsIgnoreCase("Xiaomi") && !strO.equalsIgnoreCase("SamSung") && !strO.equalsIgnoreCase("WIKO") && !strO.equalsIgnoreCase("ZTE") && !strO.equalsIgnoreCase("Tianyi")) {
            int[] iArr = (int[]) g1.k.c(g1.k.b(g1.k.a("android.telephony.SubscriptionManager"), "getSubId", Integer.TYPE), null, Integer.valueOf(i2));
            if (iArr != null) {
                return iArr[0];
            }
            return -1;
        }
        Class<?> clsA = g1.k.a("android.telephony.SubscriptionManager");
        if (Build.VERSION.SDK_INT > 33) {
            return ((Integer) g1.k.c(g1.k.b(clsA, "getSubscriptionId", Integer.TYPE), null, Integer.valueOf(i2))).intValue();
        }
        int[] iArr2 = (int[]) g1.k.c(g1.k.b(clsA, "getSubId", Integer.TYPE), null, Integer.valueOf(i2));
        if (iArr2 != null) {
            return iArr2[0];
        }
        return -1;
    }

    private String j(Context context) {
        String string = Settings.Global.getString(context.getContentResolver(), "miui_version_name");
        String strO = g1.l.o("ro.build.version.incremental");
        if (!TextUtils.isEmpty(string) && string.length() > 1) {
            return string.replaceAll("\r|\n", "");
        }
        if (strO == null || strO.length() == 0) {
            return strO;
        }
        int iLastIndexOf = strO.lastIndexOf(".");
        String strSubstring = strO.substring(1, iLastIndexOf);
        return "MIUI " + strSubstring.substring(0, strSubstring.indexOf(".", strSubstring.indexOf(".", strSubstring.indexOf(".") + 1) + 1)) + strSubstring + "(" + strO.substring(iLastIndexOf + 1) + ")";
    }

    private boolean k(Context context, int i2) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return false;
            }
            return (telephonyManager.getSimState(i2) == 5) && (i2 != -1);
        } catch (Exception e2) {
            Log.e("EsimStatus", "检查SIM卡存在状态失败: " + e2.getMessage());
            return false;
        }
    }

    private boolean m(String str, String str2) {
        return (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || !str.matches("\\d+") || !str2.matches("\\d+")) ? false : true;
    }

    public static synchronized void n(Context context) {
        g1.h.a("DeviceInfoReaderBase", "listenNetworkState---->");
        if (g1.d.f2652e) {
            int i2 = i(0);
            g1.h.a("DeviceInfoReaderBase", "subIdSlot1:" + i2);
            if (i2 > 0 && g1.d.f2653f == null) {
                g1.d.f2653f = ((TelephonyManager) context.getSystemService("phone")).createForSubscriptionId(i2);
                g1.h.a("DeviceInfoReaderBase", "telephonyManagerSlot1" + g1.d.f2653f);
                if (g1.d.f2655h == null) {
                    g1.h.a("DeviceInfoReaderBase", "registerTelephonyCallback--mDMTelephonyCallback1");
                    g1.d.f2655h = new e1.a(context, 0);
                    g1.d.f2653f.registerTelephonyCallback(context.getMainExecutor(), g1.d.f2655h);
                }
            }
            int i3 = i(1);
            g1.h.a("DeviceInfoReaderBase", "subIdSlot2:" + i3);
            if (i3 > 0 && g1.d.f2654g == null) {
                g1.d.f2654g = ((TelephonyManager) context.getSystemService("phone")).createForSubscriptionId(i3);
                g1.h.a("DeviceInfoReaderBase", "telephonyManagerSlot2" + g1.d.f2654g);
                if (g1.d.f2656i == null) {
                    g1.h.a("DeviceInfoReaderBase", "registerTelephonyCallback--mDMTelephonyCallback2");
                    g1.d.f2656i = new e1.a(context, 1);
                    g1.d.f2654g.registerTelephonyCallback(context.getMainExecutor(), g1.d.f2656i);
                }
            }
        }
    }

    private String q(SubscriptionInfo subscriptionInfo) {
        try {
            return subscriptionInfo.getMccString() != null ? subscriptionInfo.getMccString() : "";
        } catch (Exception unused) {
            return "";
        }
    }

    private String r(SubscriptionInfo subscriptionInfo) {
        try {
            return subscriptionInfo.getMncString() != null ? subscriptionInfo.getMncString() : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static synchronized void s(Context context) {
        g1.h.a("DeviceInfoReaderBase", "unlistenNetworkState-->");
        if (g1.d.f2655h != null) {
            g1.d.f2653f.unregisterTelephonyCallback(g1.d.f2655h);
        }
        g1.d.f2653f = null;
        g1.d.f2655h = null;
        if (g1.d.f2656i != null) {
            g1.d.f2654g.unregisterTelephonyCallback(g1.d.f2656i);
        }
        g1.d.f2654g = null;
        g1.d.f2656i = null;
    }

    @Override // f1.o.c
    public boolean a(Context context) {
        return new ServiceState().getRoaming();
    }

    @Override // f1.o.c
    public void b(Context context, e1.b bVar) {
        StringBuilder sb;
        String str;
        String str2 = Build.MODEL;
        bVar.f2449b = str2;
        String str3 = o.f2556a.get(str2);
        bVar.f2447a = str3;
        if (str3 == null || str3.isEmpty()) {
            bVar.f2447a = Build.MANUFACTURER;
        }
        if (bVar.f2447a.equals("vivo")) {
            boolean zA = g1.l.a(context);
            g1.d.f2652e = zA;
            if (!zA) {
                sb = new StringBuilder();
            }
            sb.append("vivo DM isUserPermissionOpen : ");
            sb.append(g1.d.f2652e);
            g1.h.a("DeviceInfoReaderBase", sb.toString());
            return;
        }
        g1.d.f2652e = c(context);
        g1.h.a("DeviceInfoReaderBase", "queryAppUsageStatsDescend  isUserPermissionOpen :" + g1.d.f2652e);
        g1.h.a("DeviceInfoReaderBase", "GlobalSetting.isUserPermissionOpen" + g1.d.f2652e);
        if (!g1.d.f2652e) {
            bVar.f2449b = str2;
            String str4 = o.f2556a.get(str2);
            bVar.f2447a = str4;
            if (str4 == null || str4.isEmpty()) {
                bVar.f2447a = Build.MANUFACTURER;
            }
            bVar.f2454e = "Android";
            bVar.f2455f = Build.VERSION.RELEASE;
            bVar.f2453d = Build.DISPLAY;
            bVar.f2451c = g1.l.q("ro.hardware.version", "Unknown");
            bVar.U = g1.g.c(context);
            return;
        }
        bVar.f2454e = "Android";
        bVar.f2455f = Build.VERSION.RELEASE;
        bVar.f2453d = bVar.f2447a.equals("Xiaomi") ? j(context) : Build.DISPLAY;
        bVar.f2451c = g1.l.q("ro.hardware.version", "Unknown");
        bVar.U = g1.g.c(context);
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo == null || connectionInfo.getNetworkId() == -1) {
                    bVar.H = "NWC";
                    bVar.I = "NWC";
                    bVar.J = "NWC";
                    bVar.K = "NWC";
                    str = "没有连接wifi！";
                } else {
                    bVar.H = connectionInfo.getBSSID();
                    bVar.I = String.valueOf(connectionInfo.getLinkSpeed());
                    bVar.J = String.valueOf(connectionInfo.getRssi());
                    bVar.K = String.valueOf(connectionInfo.getFrequency());
                    str = "wifiManager :路由器的mac地址： " + connectionInfo.getBSSID();
                }
                g1.h.a("DeviceInfoReaderBase", str);
            } else {
                g1.h.a("DeviceInfoReaderBase", "设备不支持wifi");
                bVar.H = "NW";
            }
        } catch (Exception e2) {
            g1.h.a("DeviceInfoReaderBase", "Exception " + e2);
        }
        if (!bVar.f2447a.equals("vivo")) {
            o(context, bVar);
            return;
        }
        boolean zA2 = g1.l.a(g1.d.f2651d);
        g1.d.f2652e = zA2;
        if (!zA2) {
            sb = new StringBuilder();
            sb.append("vivo DM isUserPermissionOpen : ");
            sb.append(g1.d.f2652e);
            g1.h.a("DeviceInfoReaderBase", sb.toString());
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            g1.h.a("DeviceInfoReaderBase", "enter DeviceInfoReaderBase super.read read vivo");
            p(context, bVar);
        } else {
            g1.h.b("DeviceInfoReaderBase", "Unsupported API:" + i2);
        }
    }

    protected synchronized boolean c(Context context) {
        Boolean boolValueOf;
        boolValueOf = Boolean.valueOf(Settings.Global.getInt(context.getContentResolver(), "device_provisioned", 0) == 1);
        g1.h.a("DeviceInfoReaderBase", "isBootWizardCompleted: " + boolValueOf);
        return boolValueOf.booleanValue();
    }

    public String d(Context context, int i2, int i3) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            Log.w("EsimStatus", "Telephony服务不可用");
            return "00";
        }
        if (telephonyManager.getPhoneCount() >= 2) {
            return e(context, i2, i3);
        }
        Log.d("EsimStatus", "设备只支持单SIM卡");
        boolean z2 = k(context, i2) && l(context, i2);
        StringBuilder sb = new StringBuilder();
        sb.append(z2 ? "1" : "0");
        sb.append("0");
        return sb.toString();
    }

    public String e(Context context, int i2, int i3) {
        boolean zL = l(context, i2);
        boolean zL2 = l(context, i3);
        StringBuilder sb = new StringBuilder();
        sb.append(zL ? "1" : "0");
        sb.append(zL2 ? "1" : "0");
        return sb.toString();
    }

    public String f(Context context) {
        SubscriptionManager subscriptionManager;
        List<SubscriptionInfo> allSubscriptionInfoList;
        List<SubscriptionInfo> activeSubscriptionInfoList;
        if (y.a.a(context, "android.permission.READ_PHONE_STATE") != 0 || (subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service")) == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        try {
            if (Build.VERSION.SDK_INT >= 34) {
                allSubscriptionInfoList = subscriptionManager.getAllSubscriptionInfoList();
                activeSubscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList();
            } else {
                allSubscriptionInfoList = null;
                activeSubscriptionInfoList = null;
            }
            if (allSubscriptionInfoList == null) {
                return "";
            }
            ArrayList<SubscriptionInfo> arrayList2 = new ArrayList();
            if (!allSubscriptionInfoList.isEmpty()) {
                if (activeSubscriptionInfoList == null || activeSubscriptionInfoList.isEmpty()) {
                    arrayList2.addAll(allSubscriptionInfoList);
                } else {
                    HashSet hashSet = new HashSet();
                    Iterator<SubscriptionInfo> it = activeSubscriptionInfoList.iterator();
                    while (it.hasNext()) {
                        hashSet.add(Integer.valueOf(it.next().getSubscriptionId()));
                    }
                    for (SubscriptionInfo subscriptionInfo : allSubscriptionInfoList) {
                        if (!hashSet.contains(Integer.valueOf(subscriptionInfo.getSubscriptionId()))) {
                            arrayList2.add(subscriptionInfo);
                        }
                    }
                }
            }
            for (SubscriptionInfo subscriptionInfo2 : arrayList2) {
                try {
                    if (subscriptionInfo2.isEmbedded()) {
                        String strQ = q(subscriptionInfo2);
                        String strR = r(subscriptionInfo2);
                        if (m(strQ, strR)) {
                            arrayList.add(strQ + strR);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Exception e2) {
            g1.h.a("DeviceInfoReaderBase", "exception" + e2);
        }
        return TextUtils.join(",", arrayList);
    }

    protected synchronized void g(Context context, int i2, e1.b bVar) {
        if (y.a.a(context, "android.permission.ACCESS_COARSE_LOCATION") == 0 && y.a.a(context, "android.permission.READ_PHONE_STATE") == 0) {
            String strValueOf = "";
            String strValueOf2 = "";
            String strValueOf3 = "";
            String str = "";
            String str2 = "1";
            TelephonyManager telephonyManagerCreateForSubscriptionId = ((TelephonyManager) context.getSystemService("phone")).createForSubscriptionId(i(i2));
            String simSerialNumber = telephonyManagerCreateForSubscriptionId.getSimSerialNumber();
            g1.h.a("DeviceInfoReaderBase", "iccid:" + simSerialNumber);
            if (simSerialNumber == null || simSerialNumber.isEmpty()) {
                simSerialNumber = "ex01";
            }
            String subscriberId = telephonyManagerCreateForSubscriptionId.getSubscriberId();
            if (subscriberId == null || subscriberId.isEmpty()) {
                subscriberId = "ex01";
            }
            String networkOperator = telephonyManagerCreateForSubscriptionId.getNetworkOperator();
            g1.h.a("DeviceInfoReaderBase", "MNCCH register network:" + networkOperator);
            String simOperator = telephonyManagerCreateForSubscriptionId.getSimOperator();
            g1.h.a("DeviceInfoReaderBase", "tm.getSimOperator mnc :" + simOperator);
            if (simOperator == null || simOperator.isEmpty()) {
                simOperator = "ex01";
            }
            ServiceState serviceState = telephonyManagerCreateForSubscriptionId.getServiceState();
            if (serviceState == null) {
                g1.h.a("DeviceInfoReaderBase", "setCellLoc failed!");
                return;
            }
            for (NetworkRegistrationInfo networkRegistrationInfo : serviceState.getNetworkRegistrationInfoList()) {
                if (networkRegistrationInfo.getDomain() == 2 && networkRegistrationInfo.getTransportType() == 1) {
                    String string = networkRegistrationInfo.toString();
                    CellIdentity cellIdentity = networkRegistrationInfo.getCellIdentity();
                    if (cellIdentity != null) {
                        if (!(cellIdentity instanceof CellIdentityGsm)) {
                            if (!(cellIdentity instanceof CellIdentityWcdma)) {
                                if (!(cellIdentity instanceof CellIdentityTdscdma)) {
                                    if (!(cellIdentity instanceof CellIdentityCdma)) {
                                        if (cellIdentity instanceof CellIdentityLte) {
                                            CellIdentityLte cellIdentityLte = (CellIdentityLte) cellIdentity;
                                            strValueOf = String.valueOf(cellIdentityLte.getCi());
                                            strValueOf2 = String.valueOf(cellIdentityLte.getTac());
                                            strValueOf3 = String.valueOf(cellIdentityLte.getPci());
                                            str = string.contains("isEnDcAvailable = true") ? "NSA" : "LTE";
                                        } else if (cellIdentity instanceof CellIdentityNr) {
                                            CellIdentityNr cellIdentityNr = (CellIdentityNr) cellIdentity;
                                            strValueOf = String.valueOf(cellIdentityNr.getNci());
                                            strValueOf2 = String.valueOf(cellIdentityNr.getTac());
                                            strValueOf3 = String.valueOf(cellIdentityNr.getPci());
                                            str = "SA";
                                            if (!string.contains("mVopsSupport = 1")) {
                                                str2 = "0";
                                                break;
                                            }
                                        }
                                        str2 = "1";
                                        break;
                                    }
                                    CellIdentityCdma cellIdentityCdma = (CellIdentityCdma) cellIdentity;
                                    strValueOf = String.valueOf(cellIdentityCdma.getBasestationId());
                                    int longitude = cellIdentityCdma.getLongitude();
                                    int latitude = cellIdentityCdma.getLatitude();
                                    if (longitude != Integer.MAX_VALUE && latitude != Integer.MAX_VALUE) {
                                        strValueOf2 = String.format("%d:%d", Integer.valueOf(longitude), Integer.valueOf(latitude));
                                    }
                                    str = "CDMA";
                                    break;
                                }
                                CellIdentityTdscdma cellIdentityTdscdma = (CellIdentityTdscdma) cellIdentity;
                                strValueOf = String.valueOf(cellIdentityTdscdma.getCid());
                                strValueOf2 = String.valueOf(cellIdentityTdscdma.getLac());
                                str = "TD-SCDMA";
                                break;
                            }
                            CellIdentityWcdma cellIdentityWcdma = (CellIdentityWcdma) cellIdentity;
                            strValueOf = String.valueOf(cellIdentityWcdma.getCid());
                            strValueOf2 = String.valueOf(cellIdentityWcdma.getLac());
                            str = "WCDMA";
                            break;
                        }
                        CellIdentityGsm cellIdentityGsm = (CellIdentityGsm) cellIdentity;
                        strValueOf = String.valueOf(cellIdentityGsm.getCid());
                        strValueOf2 = String.valueOf(cellIdentityGsm.getLac());
                        str = "GSM";
                        break;
                    }
                    g1.h.b("DeviceInfoReaderBase", "cellIdentity==null!");
                    break;
                }
            }
            if (strValueOf == null || strValueOf.isEmpty()) {
                strValueOf = "ex01";
            }
            if (strValueOf2 == null || strValueOf2.isEmpty()) {
                strValueOf2 = "ex01";
            }
            if (strValueOf3 == null || strValueOf3.isEmpty()) {
                strValueOf3 = "ex01";
            }
            if (str.isEmpty()) {
                str = "ex01";
            }
            g1.h.a("DeviceInfoReaderBase", "getNetworkRegistrationInfo->slot:" + i2 + ", tac:" + strValueOf2 + ", cid:" + strValueOf + "，pci:" + strValueOf3 + "，networkType:" + str + ", voNREnable:" + str2);
            if (i2 == 0) {
                bVar.f2457h = simSerialNumber;
                bVar.f2458i = subscriberId;
                bVar.f2460k = simOperator;
                bVar.f2461l = networkOperator;
                bVar.f2464o = strValueOf;
                bVar.f2463n = strValueOf2;
                bVar.f2465p = strValueOf3;
                bVar.f2462m = str;
                bVar.f2468s = str2;
            } else if (i2 == 1) {
                bVar.f2470u = simSerialNumber;
                bVar.f2471v = subscriberId;
                bVar.f2473x = simOperator;
                bVar.f2474y = networkOperator;
                bVar.B = strValueOf;
                bVar.A = strValueOf2;
                bVar.C = strValueOf3;
                bVar.f2475z = str;
                bVar.F = str2;
            }
            return;
        }
        g1.h.b("DeviceInfoReaderBase", "getNetworkRegistrationInfo no enough permission!");
    }

    public boolean l(Context context, int i2) {
        List<SubscriptionInfo> activeSubscriptionInfoList;
        if (y.a.a(context, "android.permission.READ_PHONE_STATE") != 0) {
            Log.e("DeviceInfoReaderBase", "缺少 READ_PHONE_STATE 权限");
            return false;
        }
        SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
        if (subscriptionManager != null && (activeSubscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList()) != null) {
            for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                if (subscriptionInfo.getSubscriptionId() == i2) {
                    return subscriptionInfo.isEmbedded();
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0154  */
    /* JADX WARN: Code duplicated, block: B:41:0x015c  */
    /* JADX WARN: Code duplicated, block: B:43:0x0172  */
    /* JADX WARN: Code duplicated, block: B:44:0x017a  */
    void o(Context context, e1.b bVar) {
        String strValueOf;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        bVar.V = "000005";
        if (bVar.f2447a.equals("Xiaomi")) {
            bVar.V = "000005";
            Class<?> clsA = g1.k.a("miui.telephony.TelephonyManager");
            Object objC = g1.k.c(g1.k.b(clsA, "getDefault", new Class[0]), null, new Object[0]);
            try {
                Class cls = Integer.TYPE;
                bVar.f2456g = (String) g1.k.c(g1.k.b(clsA, "getImeiForSlot", cls), objC, 0);
                bVar.f2469t = (String) g1.k.c(g1.k.b(clsA, "getImeiForSlot", cls), objC, 1);
            } catch (Exception unused) {
                g1.h.b("DeviceInfoReaderBase", "Exception:getImeiForSlot");
            }
        } else {
            bVar.f2456g = telephonyManager.getImei(0);
            bVar.f2469t = telephonyManager.getImei(1);
        }
        String str = bVar.f2456g;
        if (str == null || str.isEmpty()) {
            bVar.f2456g = "ex00";
        }
        String str2 = bVar.f2469t;
        if (str2 == null || str2.isEmpty()) {
            bVar.f2469t = "ex00";
        }
        SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
        int i2 = i(0);
        int i3 = i(1);
        int activeDataSubscriptionId = SubscriptionManager.getActiveDataSubscriptionId();
        g1.h.a("DeviceInfoReaderBase", "subId0:" + i2 + "，subId1:" + i3 + ", activeDataSubId：" + activeDataSubscriptionId);
        try {
            try {
                if (i2 < 0 && i3 < 0) {
                    strValueOf = "0";
                } else {
                    if (activeDataSubscriptionId != i2) {
                        if (activeDataSubscriptionId == i3) {
                            strValueOf = String.valueOf(2);
                        }
                        g1.h.a("DeviceInfoReaderBase", "20240524dataslot: " + bVar.G);
                        bVar.L = d(g1.d.f2651d, i2, i3);
                        bVar.M = f(g1.d.f2651d);
                        g1.h.a("DeviceInfoReaderBase", "20240524defaultDataSubId: " + ((Integer) subscriptionManager.getClass().getMethod("getDefaultDataSubscriptionId", new Class[0]).invoke(subscriptionManager, new Object[0])).intValue());
                        if (i2 >= 0) {
                            bVar.f2467r = "1";
                            g(context, 0, bVar);
                            bVar.f2466q = "1";
                        } else {
                            bVar.f2457h = "ex00";
                            bVar.f2458i = "ex00";
                            bVar.f2460k = "ex00";
                            bVar.f2462m = "ex00";
                            bVar.f2463n = "ex00";
                            bVar.f2464o = "ex00";
                            bVar.f2465p = "ex00";
                            bVar.f2468s = "ex00";
                            bVar.f2466q = "ex00";
                            bVar.f2467r = "ex00";
                        }
                        if (i3 >= 0) {
                            bVar.E = "1";
                            g(context, 1, bVar);
                            bVar.D = "1";
                            return;
                        }
                        bVar.f2470u = "ex00";
                        bVar.f2471v = "ex00";
                        bVar.f2473x = "ex00";
                        bVar.f2475z = "ex00";
                        bVar.A = "ex00";
                        bVar.B = "ex00";
                        bVar.C = "ex00";
                        bVar.F = "ex00";
                        bVar.D = "ex00";
                        bVar.E = "ex00";
                    }
                    strValueOf = String.valueOf(1);
                }
                bVar.L = d(g1.d.f2651d, i2, i3);
                bVar.M = f(g1.d.f2651d);
            } catch (Exception e2) {
                g1.h.a("DeviceInfoReaderBase", "get eSIM Exception " + e2);
            }
            g1.h.a("DeviceInfoReaderBase", "20240524defaultDataSubId: " + ((Integer) subscriptionManager.getClass().getMethod("getDefaultDataSubscriptionId", new Class[0]).invoke(subscriptionManager, new Object[0])).intValue());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        bVar.G = strValueOf;
        g1.h.a("DeviceInfoReaderBase", "20240524dataslot: " + bVar.G);
        if (i2 >= 0) {
            bVar.f2467r = "1";
            g(context, 0, bVar);
            bVar.f2466q = "1";
        } else {
            bVar.f2457h = "ex00";
            bVar.f2458i = "ex00";
            bVar.f2460k = "ex00";
            bVar.f2462m = "ex00";
            bVar.f2463n = "ex00";
            bVar.f2464o = "ex00";
            bVar.f2465p = "ex00";
            bVar.f2468s = "ex00";
            bVar.f2466q = "ex00";
            bVar.f2467r = "ex00";
        }
        if (i3 >= 0) {
            bVar.E = "1";
            g(context, 1, bVar);
            bVar.D = "1";
            return;
        }
        bVar.f2470u = "ex00";
        bVar.f2471v = "ex00";
        bVar.f2473x = "ex00";
        bVar.f2475z = "ex00";
        bVar.A = "ex00";
        bVar.B = "ex00";
        bVar.C = "ex00";
        bVar.F = "ex00";
        bVar.D = "ex00";
        bVar.E = "ex00";
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:31:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:32:0x00d3  */
    void p(Context context, e1.b bVar) {
        String strValueOf;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        bVar.V = "000005";
        String imei = telephonyManager.getImei(0);
        bVar.f2456g = imei;
        if (imei == null || imei.isEmpty()) {
            bVar.f2456g = "ex00";
        }
        String imei2 = telephonyManager.getImei(1);
        bVar.f2469t = imei2;
        if (imei2 == null || imei2.isEmpty()) {
            bVar.f2469t = "ex00";
        }
        int i2 = i(0);
        int i3 = i(1);
        int activeDataSubscriptionId = SubscriptionManager.getActiveDataSubscriptionId();
        g1.h.a("DeviceInfoReaderBase", "subId0:" + i2 + "，subId1:" + i3 + ", activeDataSubId：" + activeDataSubscriptionId);
        try {
            if (i2 < 0 && i3 < 0) {
                strValueOf = "0";
            } else {
                if (activeDataSubscriptionId != i2) {
                    if (activeDataSubscriptionId == i3) {
                        strValueOf = String.valueOf(2);
                    }
                    bVar.L = d(g1.d.f2651d, i2, i3);
                    bVar.M = f(g1.d.f2651d);
                    if (i2 >= 0) {
                        bVar.f2467r = "1";
                        g(context, 0, bVar);
                        bVar.f2466q = "1";
                    } else {
                        bVar.f2457h = "ex00";
                        bVar.f2458i = "ex00";
                        bVar.f2460k = "ex00";
                        bVar.f2462m = "ex00";
                        bVar.f2463n = "ex00";
                        bVar.f2464o = "ex00";
                        bVar.f2465p = "ex00";
                        bVar.f2468s = "ex00";
                        bVar.f2466q = "ex00";
                        bVar.f2467r = "ex00";
                    }
                    if (i3 >= 0) {
                        bVar.E = "1";
                        g(context, 1, bVar);
                        bVar.D = "1";
                        return;
                    }
                    bVar.f2470u = "ex00";
                    bVar.f2471v = "ex00";
                    bVar.f2473x = "ex00";
                    bVar.f2475z = "ex00";
                    bVar.A = "ex00";
                    bVar.B = "ex00";
                    bVar.C = "ex00";
                    bVar.F = "ex00";
                    bVar.D = "ex00";
                    bVar.E = "ex00";
                }
                strValueOf = String.valueOf(1);
            }
            bVar.L = d(g1.d.f2651d, i2, i3);
            bVar.M = f(g1.d.f2651d);
        } catch (Exception e2) {
            g1.h.a("DeviceInfoReaderBase", "get eSIM Exception " + e2);
        }
        bVar.G = strValueOf;
        if (i2 >= 0) {
            bVar.f2467r = "1";
            g(context, 0, bVar);
            bVar.f2466q = "1";
        } else {
            bVar.f2457h = "ex00";
            bVar.f2458i = "ex00";
            bVar.f2460k = "ex00";
            bVar.f2462m = "ex00";
            bVar.f2463n = "ex00";
            bVar.f2464o = "ex00";
            bVar.f2465p = "ex00";
            bVar.f2468s = "ex00";
            bVar.f2466q = "ex00";
            bVar.f2467r = "ex00";
        }
        if (i3 >= 0) {
            bVar.E = "1";
            g(context, 1, bVar);
            bVar.D = "1";
            return;
        }
        bVar.f2470u = "ex00";
        bVar.f2471v = "ex00";
        bVar.f2473x = "ex00";
        bVar.f2475z = "ex00";
        bVar.A = "ex00";
        bVar.B = "ex00";
        bVar.C = "ex00";
        bVar.F = "ex00";
        bVar.D = "ex00";
        bVar.E = "ex00";
    }
}
