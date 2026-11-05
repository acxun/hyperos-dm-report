package com.xiaomi.security.xsof.frauddetection.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.miui.riskyapp.model.RiskyAppDescriptionItem;
import com.xiaomi.onetrack.c.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p096gb.F;
import p278tb.n;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B¥\u0002\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u001e\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u001e\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010 J\u001e\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010 J\u001e\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010 J\u001e\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010 J\u001e\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010 J\u001e\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b&\u0010 J\u001e\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b'\u0010 J\u001e\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b(\u0010 J\u001e\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b)\u0010 J\u001e\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b*\u0010 J\u001e\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b+\u0010 J\u001e\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b,\u0010 JÈ\u0002\u0010-\u001a\u00020\u00002\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b1\u0010\u001eJ\u001a\u00105\u001a\u0002042\b\u00103\u001a\u0004\u0018\u000102HÖ\u0003¢\u0006\u0004\b5\u00106R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u00107\u001a\u0004\b8\u0010 R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u00107\u001a\u0004\b9\u0010 R(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u00107\u001a\u0004\b:\u0010 R(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u00107\u001a\u0004\b;\u0010 R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u00107\u001a\u0004\b<\u0010 R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u00107\u001a\u0004\b=\u0010 R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u00107\u001a\u0004\b>\u0010 R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u00107\u001a\u0004\b?\u0010 R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u00107\u001a\u0004\b@\u0010 R(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u00107\u001a\u0004\bA\u0010 R(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u00107\u001a\u0004\bB\u0010 R(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u00107\u001a\u0004\bC\u0010 R(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u00107\u001a\u0004\bD\u0010 ¨\u0006E"}, d2 = {"Lcom/xiaomi/security/xsof/frauddetection/bean/PastFraudData;", "Landroid/os/Parcelable;", "", "", "screenshot", "screenShare", "callForwarding", "airplaneMode", "simFraudCall", "voipFraudCall", "fraudUrl", "financialApp", "loanApp", "conferenceApp", "riskApp", "suspiciousApp", "indistinguishableApp", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "", j.f37184b, "getEventMap", "(Ljava/lang/String;)Ljava/util/Map;", "Landroid/os/Parcel;", "dest", "flags", "Leb/w;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/util/Map;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/xiaomi/security/xsof/frauddetection/bean/PastFraudData;", "toString", "()Ljava/lang/String;", "hashCode", "", RiskyAppDescriptionItem.Columns.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getScreenshot", "getScreenShare", "getCallForwarding", "getAirplaneMode", "getSimFraudCall", "getVoipFraudCall", "getFraudUrl", "getFinancialApp", "getLoanApp", "getConferenceApp", "getRiskApp", "getSuspiciousApp", "getIndistinguishableApp", "core-service_cnRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class PastFraudData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<PastFraudData> CREATOR = new a();

    @SerializedName("airplaneMode")
    @Nullable
    private final Map<Integer, Integer> airplaneMode;

    @SerializedName("callForwarding")
    @Nullable
    private final Map<Integer, Integer> callForwarding;

    @SerializedName("conferenceApp")
    @Nullable
    private final Map<Integer, Integer> conferenceApp;

    @SerializedName("financialApp")
    @Nullable
    private final Map<Integer, Integer> financialApp;

    @SerializedName("fraudUrl")
    @Nullable
    private final Map<Integer, Integer> fraudUrl;

    @SerializedName("indistinguishableApp")
    @Nullable
    private final Map<Integer, Integer> indistinguishableApp;

    @SerializedName("loanApp")
    @Nullable
    private final Map<Integer, Integer> loanApp;

    @SerializedName("riskApp")
    @Nullable
    private final Map<Integer, Integer> riskApp;

    @SerializedName("screenShare")
    @Nullable
    private final Map<Integer, Integer> screenShare;

    @SerializedName("screenshot")
    @Nullable
    private final Map<Integer, Integer> screenshot;

    @SerializedName("simFraudCall")
    @Nullable
    private final Map<Integer, Integer> simFraudCall;

    @SerializedName("suspiciousApp")
    @Nullable
    private final Map<Integer, Integer> suspiciousApp;

    @SerializedName("voipFraudCall")
    @Nullable
    private final Map<Integer, Integer> voipFraudCall;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PastFraudData createFromParcel(Parcel parcel) {
            LinkedHashMap linkedHashMap;
            LinkedHashMap linkedHashMap2;
            LinkedHashMap linkedHashMap3;
            LinkedHashMap linkedHashMap4;
            LinkedHashMap linkedHashMap5;
            LinkedHashMap linkedHashMap6;
            LinkedHashMap linkedHashMap7;
            LinkedHashMap linkedHashMap8;
            LinkedHashMap linkedHashMap9;
            LinkedHashMap linkedHashMap10;
            LinkedHashMap linkedHashMap11;
            LinkedHashMap linkedHashMap12;
            LinkedHashMap linkedHashMap13;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int i10 = parcel.readInt();
                LinkedHashMap linkedHashMap14 = new LinkedHashMap(i10);
                for (int i11 = 0; i11 != i10; i11++) {
                    linkedHashMap14.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));
                }
                linkedHashMap = linkedHashMap14;
            }
            if (parcel.readInt() == 0) {
                linkedHashMap2 = null;
            } else {
                int i12 = parcel.readInt();
                LinkedHashMap linkedHashMap15 = new LinkedHashMap(i12);
                for (int i13 = 0; i13 != i12; i13++) {
                    linkedHashMap15.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));
                }
                linkedHashMap2 = linkedHashMap15;
            }
            if (parcel.readInt() == 0) {
                linkedHashMap3 = null;
            } else {
                int i14 = parcel.readInt();
                LinkedHashMap linkedHashMap16 = new LinkedHashMap(i14);
                for (int i15 = 0; i15 != i14; i15++) {
                    linkedHashMap16.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));
                }
                linkedHashMap3 = linkedHashMap16;
            }
            if (parcel.readInt() == 0) {
                linkedHashMap4 = null;
            } else {
                int i16 = parcel.readInt();
                LinkedHashMap linkedHashMap17 = new LinkedHashMap(i16);
                for (int i17 = 0; i17 != i16; i17++) {
                    linkedHashMap17.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));
                }
                linkedHashMap4 = linkedHashMap17;
            }
            if (parcel.readInt() == 0) {
                linkedHashMap5 = null;
            } else {
                int i18 = parcel.readInt();
                LinkedHashMap linkedHashMap18 = new LinkedHashMap(i18);
                for (int i19 = 0; i19 != i18; i19++) {
                    linkedHashMap18.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));
                }
                linkedHashMap5 = linkedHashMap18;
            }
            if (parcel.readInt() == 0) {
                linkedHashMap6 = null;
            } else {
                int i20 = parcel.readInt();
                LinkedHashMap linkedHashMap19 = new LinkedHashMap(i20);
                for (int i21 = 0; i21 != i20; i21++) {
                    linkedHashMap19.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));
                }
                linkedHashMap6 = linkedHashMap19;
            }
            if (parcel.readInt() == 0) {
                linkedHashMap7 = null;
            } else {
                int i22 = parcel.readInt();
                LinkedHashMap linkedHashMap20 = new LinkedHashMap(i22);
                for (int i23 = 0; i23 != i22; i23++) {
                    linkedHashMap20.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));
                }
                linkedHashMap7 = linkedHashMap20;
            }
            if (parcel.readInt() == 0) {
                linkedHashMap8 = null;
            } else {
                int i24 = parcel.readInt();
                LinkedHashMap linkedHashMap21 = new LinkedHashMap(i24);
                for (int i25 = 0; i25 != i24; i25++) {
                    linkedHashMap21.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));
                }
                linkedHashMap8 = linkedHashMap21;
            }
            if (parcel.readInt() == 0) {
                linkedHashMap9 = null;
            } else {
                int i26 = parcel.readInt();
                LinkedHashMap linkedHashMap22 = new LinkedHashMap(i26);
                for (int i27 = 0; i27 != i26; i27++) {
                    linkedHashMap22.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));
                }
                linkedHashMap9 = linkedHashMap22;
            }
            if (parcel.readInt() == 0) {
                linkedHashMap10 = null;
            } else {
                int i28 = parcel.readInt();
                LinkedHashMap linkedHashMap23 = new LinkedHashMap(i28);
                for (int i29 = 0; i29 != i28; i29++) {
                    linkedHashMap23.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));
                }
                linkedHashMap10 = linkedHashMap23;
            }
            if (parcel.readInt() == 0) {
                linkedHashMap11 = null;
            } else {
                int i30 = parcel.readInt();
                linkedHashMap11 = new LinkedHashMap(i30);
                for (int i31 = 0; i31 != i30; i31++) {
                    linkedHashMap11.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));
                }
            }
            if (parcel.readInt() == 0) {
                linkedHashMap12 = null;
            } else {
                int i32 = parcel.readInt();
                LinkedHashMap linkedHashMap24 = new LinkedHashMap(i32);
                for (int i33 = 0; i33 != i32; i33++) {
                    linkedHashMap24.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));
                }
                linkedHashMap12 = linkedHashMap24;
            }
            if (parcel.readInt() == 0) {
                linkedHashMap13 = null;
            } else {
                int i34 = parcel.readInt();
                LinkedHashMap linkedHashMap25 = new LinkedHashMap(i34);
                for (int i35 = 0; i35 != i34; i35++) {
                    linkedHashMap25.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));
                }
                linkedHashMap13 = linkedHashMap25;
            }
            return new PastFraudData(linkedHashMap, linkedHashMap2, linkedHashMap3, linkedHashMap4, linkedHashMap5, linkedHashMap6, linkedHashMap7, linkedHashMap8, linkedHashMap9, linkedHashMap10, linkedHashMap11, linkedHashMap12, linkedHashMap13);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PastFraudData[] newArray(int i10) {
            return new PastFraudData[i10];
        }
    }

    public PastFraudData(@Nullable Map<Integer, Integer> map, @Nullable Map<Integer, Integer> map2, @Nullable Map<Integer, Integer> map3, @Nullable Map<Integer, Integer> map4, @Nullable Map<Integer, Integer> map5, @Nullable Map<Integer, Integer> map6, @Nullable Map<Integer, Integer> map7, @Nullable Map<Integer, Integer> map8, @Nullable Map<Integer, Integer> map9, @Nullable Map<Integer, Integer> map10, @Nullable Map<Integer, Integer> map11, @Nullable Map<Integer, Integer> map12, @Nullable Map<Integer, Integer> map13) {
        this.screenshot = map;
        this.screenShare = map2;
        this.callForwarding = map3;
        this.airplaneMode = map4;
        this.simFraudCall = map5;
        this.voipFraudCall = map6;
        this.fraudUrl = map7;
        this.financialApp = map8;
        this.loanApp = map9;
        this.conferenceApp = map10;
        this.riskApp = map11;
        this.suspiciousApp = map12;
        this.indistinguishableApp = map13;
    }

    @Nullable
    public final Map<Integer, Integer> component1() {
        return this.screenshot;
    }

    @Nullable
    public final Map<Integer, Integer> component10() {
        return this.conferenceApp;
    }

    @Nullable
    public final Map<Integer, Integer> component11() {
        return this.riskApp;
    }

    @Nullable
    public final Map<Integer, Integer> component12() {
        return this.suspiciousApp;
    }

    @Nullable
    public final Map<Integer, Integer> component13() {
        return this.indistinguishableApp;
    }

    @Nullable
    public final Map<Integer, Integer> component2() {
        return this.screenShare;
    }

    @Nullable
    public final Map<Integer, Integer> component3() {
        return this.callForwarding;
    }

    @Nullable
    public final Map<Integer, Integer> component4() {
        return this.airplaneMode;
    }

    @Nullable
    public final Map<Integer, Integer> component5() {
        return this.simFraudCall;
    }

    @Nullable
    public final Map<Integer, Integer> component6() {
        return this.voipFraudCall;
    }

    @Nullable
    public final Map<Integer, Integer> component7() {
        return this.fraudUrl;
    }

    @Nullable
    public final Map<Integer, Integer> component8() {
        return this.financialApp;
    }

    @Nullable
    public final Map<Integer, Integer> component9() {
        return this.loanApp;
    }

    @NotNull
    public final PastFraudData copy(@Nullable Map<Integer, Integer> screenshot, @Nullable Map<Integer, Integer> screenShare, @Nullable Map<Integer, Integer> callForwarding, @Nullable Map<Integer, Integer> airplaneMode, @Nullable Map<Integer, Integer> simFraudCall, @Nullable Map<Integer, Integer> voipFraudCall, @Nullable Map<Integer, Integer> fraudUrl, @Nullable Map<Integer, Integer> financialApp, @Nullable Map<Integer, Integer> loanApp, @Nullable Map<Integer, Integer> conferenceApp, @Nullable Map<Integer, Integer> riskApp, @Nullable Map<Integer, Integer> suspiciousApp, @Nullable Map<Integer, Integer> indistinguishableApp) {
        return new PastFraudData(screenshot, screenShare, callForwarding, airplaneMode, simFraudCall, voipFraudCall, fraudUrl, financialApp, loanApp, conferenceApp, riskApp, suspiciousApp, indistinguishableApp);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PastFraudData)) {
            return false;
        }
        PastFraudData pastFraudData = (PastFraudData) other;
        return n.b(this.screenshot, pastFraudData.screenshot) && n.b(this.screenShare, pastFraudData.screenShare) && n.b(this.callForwarding, pastFraudData.callForwarding) && n.b(this.airplaneMode, pastFraudData.airplaneMode) && n.b(this.simFraudCall, pastFraudData.simFraudCall) && n.b(this.voipFraudCall, pastFraudData.voipFraudCall) && n.b(this.fraudUrl, pastFraudData.fraudUrl) && n.b(this.financialApp, pastFraudData.financialApp) && n.b(this.loanApp, pastFraudData.loanApp) && n.b(this.conferenceApp, pastFraudData.conferenceApp) && n.b(this.riskApp, pastFraudData.riskApp) && n.b(this.suspiciousApp, pastFraudData.suspiciousApp) && n.b(this.indistinguishableApp, pastFraudData.indistinguishableApp);
    }

    @Nullable
    public final Map<Integer, Integer> getAirplaneMode() {
        return this.airplaneMode;
    }

    @Nullable
    public final Map<Integer, Integer> getCallForwarding() {
        return this.callForwarding;
    }

    @Nullable
    public final Map<Integer, Integer> getConferenceApp() {
        return this.conferenceApp;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    public final Map<Integer, Integer> getEventMap(@NotNull String eventName) {
        n.f(eventName, j.f37184b);
        switch (eventName.hashCode()) {
            case -1637623701:
                if (eventName.equals("fraudUrl")) {
                    return this.fraudUrl;
                }
                break;
            case -572823262:
                if (eventName.equals("voipFraudCall")) {
                    return this.voipFraudCall;
                }
                break;
            case -561091196:
                if (eventName.equals("suspiciousApp")) {
                    return this.suspiciousApp;
                }
                break;
            case -416447130:
                if (eventName.equals("screenshot")) {
                    return this.screenshot;
                }
                break;
            case -54525229:
                if (eventName.equals("screenShare")) {
                    return this.screenShare;
                }
                break;
            case 336910097:
                if (eventName.equals("loanApp")) {
                    return this.loanApp;
                }
                break;
            case 412216536:
                if (eventName.equals("financialApp")) {
                    return this.financialApp;
                }
                break;
            case 794864587:
                if (eventName.equals("simFraudCall")) {
                    return this.simFraudCall;
                }
                break;
            case 1114002453:
                if (eventName.equals("airplaneMode")) {
                    return this.airplaneMode;
                }
                break;
            case 1135368037:
                if (eventName.equals("conferenceApp")) {
                    return this.conferenceApp;
                }
                break;
            case 1211723986:
                if (eventName.equals("riskApp")) {
                    return this.riskApp;
                }
                break;
            case 1658833915:
                if (eventName.equals("callForwarding")) {
                    return this.callForwarding;
                }
                break;
        }
        return F.h();
    }

    @Nullable
    public final Map<Integer, Integer> getFinancialApp() {
        return this.financialApp;
    }

    @Nullable
    public final Map<Integer, Integer> getFraudUrl() {
        return this.fraudUrl;
    }

    @Nullable
    public final Map<Integer, Integer> getIndistinguishableApp() {
        return this.indistinguishableApp;
    }

    @Nullable
    public final Map<Integer, Integer> getLoanApp() {
        return this.loanApp;
    }

    @Nullable
    public final Map<Integer, Integer> getRiskApp() {
        return this.riskApp;
    }

    @Nullable
    public final Map<Integer, Integer> getScreenShare() {
        return this.screenShare;
    }

    @Nullable
    public final Map<Integer, Integer> getScreenshot() {
        return this.screenshot;
    }

    @Nullable
    public final Map<Integer, Integer> getSimFraudCall() {
        return this.simFraudCall;
    }

    @Nullable
    public final Map<Integer, Integer> getSuspiciousApp() {
        return this.suspiciousApp;
    }

    @Nullable
    public final Map<Integer, Integer> getVoipFraudCall() {
        return this.voipFraudCall;
    }

    public int hashCode() {
        Map<Integer, Integer> map = this.screenshot;
        int iHashCode = (map == null ? 0 : map.hashCode()) * 31;
        Map<Integer, Integer> map2 = this.screenShare;
        int iHashCode2 = (iHashCode + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<Integer, Integer> map3 = this.callForwarding;
        int iHashCode3 = (iHashCode2 + (map3 == null ? 0 : map3.hashCode())) * 31;
        Map<Integer, Integer> map4 = this.airplaneMode;
        int iHashCode4 = (iHashCode3 + (map4 == null ? 0 : map4.hashCode())) * 31;
        Map<Integer, Integer> map5 = this.simFraudCall;
        int iHashCode5 = (iHashCode4 + (map5 == null ? 0 : map5.hashCode())) * 31;
        Map<Integer, Integer> map6 = this.voipFraudCall;
        int iHashCode6 = (iHashCode5 + (map6 == null ? 0 : map6.hashCode())) * 31;
        Map<Integer, Integer> map7 = this.fraudUrl;
        int iHashCode7 = (iHashCode6 + (map7 == null ? 0 : map7.hashCode())) * 31;
        Map<Integer, Integer> map8 = this.financialApp;
        int iHashCode8 = (iHashCode7 + (map8 == null ? 0 : map8.hashCode())) * 31;
        Map<Integer, Integer> map9 = this.loanApp;
        int iHashCode9 = (iHashCode8 + (map9 == null ? 0 : map9.hashCode())) * 31;
        Map<Integer, Integer> map10 = this.conferenceApp;
        int iHashCode10 = (iHashCode9 + (map10 == null ? 0 : map10.hashCode())) * 31;
        Map<Integer, Integer> map11 = this.riskApp;
        int iHashCode11 = (iHashCode10 + (map11 == null ? 0 : map11.hashCode())) * 31;
        Map<Integer, Integer> map12 = this.suspiciousApp;
        int iHashCode12 = (iHashCode11 + (map12 == null ? 0 : map12.hashCode())) * 31;
        Map<Integer, Integer> map13 = this.indistinguishableApp;
        return iHashCode12 + (map13 != null ? map13.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PastFraudData(screenshot=" + this.screenshot + ", screenShare=" + this.screenShare + ", callForwarding=" + this.callForwarding + ", airplaneMode=" + this.airplaneMode + ", simFraudCall=" + this.simFraudCall + ", voipFraudCall=" + this.voipFraudCall + ", fraudUrl=" + this.fraudUrl + ", financialApp=" + this.financialApp + ", loanApp=" + this.loanApp + ", conferenceApp=" + this.conferenceApp + ", riskApp=" + this.riskApp + ", suspiciousApp=" + this.suspiciousApp + ", indistinguishableApp=" + this.indistinguishableApp + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        n.f(dest, "dest");
        Map<Integer, Integer> map = this.screenshot;
        if (map == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(map.size());
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                dest.writeInt(entry.getKey().intValue());
                dest.writeInt(entry.getValue().intValue());
            }
        }
        Map<Integer, Integer> map2 = this.screenShare;
        if (map2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(map2.size());
            for (Map.Entry<Integer, Integer> entry2 : map2.entrySet()) {
                dest.writeInt(entry2.getKey().intValue());
                dest.writeInt(entry2.getValue().intValue());
            }
        }
        Map<Integer, Integer> map3 = this.callForwarding;
        if (map3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(map3.size());
            for (Map.Entry<Integer, Integer> entry3 : map3.entrySet()) {
                dest.writeInt(entry3.getKey().intValue());
                dest.writeInt(entry3.getValue().intValue());
            }
        }
        Map<Integer, Integer> map4 = this.airplaneMode;
        if (map4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(map4.size());
            for (Map.Entry<Integer, Integer> entry4 : map4.entrySet()) {
                dest.writeInt(entry4.getKey().intValue());
                dest.writeInt(entry4.getValue().intValue());
            }
        }
        Map<Integer, Integer> map5 = this.simFraudCall;
        if (map5 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(map5.size());
            for (Map.Entry<Integer, Integer> entry5 : map5.entrySet()) {
                dest.writeInt(entry5.getKey().intValue());
                dest.writeInt(entry5.getValue().intValue());
            }
        }
        Map<Integer, Integer> map6 = this.voipFraudCall;
        if (map6 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(map6.size());
            for (Map.Entry<Integer, Integer> entry6 : map6.entrySet()) {
                dest.writeInt(entry6.getKey().intValue());
                dest.writeInt(entry6.getValue().intValue());
            }
        }
        Map<Integer, Integer> map7 = this.fraudUrl;
        if (map7 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(map7.size());
            for (Map.Entry<Integer, Integer> entry7 : map7.entrySet()) {
                dest.writeInt(entry7.getKey().intValue());
                dest.writeInt(entry7.getValue().intValue());
            }
        }
        Map<Integer, Integer> map8 = this.financialApp;
        if (map8 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(map8.size());
            for (Map.Entry<Integer, Integer> entry8 : map8.entrySet()) {
                dest.writeInt(entry8.getKey().intValue());
                dest.writeInt(entry8.getValue().intValue());
            }
        }
        Map<Integer, Integer> map9 = this.loanApp;
        if (map9 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(map9.size());
            for (Map.Entry<Integer, Integer> entry9 : map9.entrySet()) {
                dest.writeInt(entry9.getKey().intValue());
                dest.writeInt(entry9.getValue().intValue());
            }
        }
        Map<Integer, Integer> map10 = this.conferenceApp;
        if (map10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(map10.size());
            for (Map.Entry<Integer, Integer> entry10 : map10.entrySet()) {
                dest.writeInt(entry10.getKey().intValue());
                dest.writeInt(entry10.getValue().intValue());
            }
        }
        Map<Integer, Integer> map11 = this.riskApp;
        if (map11 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(map11.size());
            for (Map.Entry<Integer, Integer> entry11 : map11.entrySet()) {
                dest.writeInt(entry11.getKey().intValue());
                dest.writeInt(entry11.getValue().intValue());
            }
        }
        Map<Integer, Integer> map12 = this.suspiciousApp;
        if (map12 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(map12.size());
            for (Map.Entry<Integer, Integer> entry12 : map12.entrySet()) {
                dest.writeInt(entry12.getKey().intValue());
                dest.writeInt(entry12.getValue().intValue());
            }
        }
        Map<Integer, Integer> map13 = this.indistinguishableApp;
        if (map13 == null) {
            dest.writeInt(0);
            return;
        }
        dest.writeInt(1);
        dest.writeInt(map13.size());
        for (Map.Entry<Integer, Integer> entry13 : map13.entrySet()) {
            dest.writeInt(entry13.getKey().intValue());
            dest.writeInt(entry13.getValue().intValue());
        }
    }
}
