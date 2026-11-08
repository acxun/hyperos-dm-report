package defpackage;

import com.miui.guardprovider.sdk.android.pojo.networkdomain.CloudScanApkInfo;
import com.miui.guardprovider.sdk.android.pojo.networkdomain.CloudScanResponse;
import com.xiaomi.onetrack.util.a;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import tmsdk.common.tcc.SmsCheckerContentTypes;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J6\u0010\t\u001a\u00020\b2\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H§@¢\u0006\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lbx;", a.c, a.c, "Lcom/miui/guardprovider/sdk/android/pojo/networkdomain/CloudScanApkInfo;", "body", a.c, a.c, "query", "Lcom/miui/guardprovider/sdk/android/pojo/networkdomain/CloudScanResponse;", "a", "(Ljava/util/List;Ljava/util/Map;Lj20;)Ljava/lang/Object;", "flamingo-android"}, k = 1, mv = {2, 4, 0}, xi = SmsCheckerContentTypes.TYPE_TEL_NET_TEL)
public interface bx {
    @by1("/risk/scan")
    Object a(@ln List<CloudScanApkInfo> list, @y62 Map<String, String> map, j20<? super CloudScanResponse> j20Var);
}
