package defpackage;

import com.miui.guardprovider.sdk.android.pojo.networkdomain.ResultReportData;
import com.miui.guardprovider.sdk.android.pojo.networkdomain.ResultRequestResponse;
import com.xiaomi.onetrack.util.a;
import java.util.List;
import kotlin.Metadata;
import tmsdk.common.tcc.SmsCheckerContentTypes;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J*\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H§@¢\u0006\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lrd2;", a.c, a.c, "ts", a.c, "Lcom/miui/guardprovider/sdk/android/pojo/networkdomain/ResultReportData;", "body", "Lcom/miui/guardprovider/sdk/android/pojo/networkdomain/ResultRequestResponse;", "a", "(JLjava/util/List;Lj20;)Ljava/lang/Object;", "flamingo-android"}, k = 1, mv = {2, 4, 0}, xi = SmsCheckerContentTypes.TYPE_TEL_NET_TEL)
public interface rd2 {
    @by1("/virus/localResult/report")
    Object a(@x62("timestamp") long j, @ln List<ResultReportData> list, j20<? super ResultRequestResponse> j20Var);
}
