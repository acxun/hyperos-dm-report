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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001Bõ\u0001\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002\u0012 \u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002\u0012 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002\u0012 \u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002\u0012 \u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002\u0012 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002\u0012 \u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u000f\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018J*\u0010\u0019\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ*\u0010\u001b\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ*\u0010\u001c\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001aJ*\u0010\u001d\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001aJ*\u0010\u001e\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001aJ*\u0010\u001f\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001aJ*\u0010 \u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u001aJ\u008c\u0002\u0010!\u001a\u00020\u00002\"\b\u0002\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00022\"\b\u0002\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00022\"\b\u0002\u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00022\"\b\u0002\u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00022\"\b\u0002\u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00022\"\b\u0002\u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00022\"\b\u0002\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b%\u0010\u0018J\u001a\u0010)\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010&HÖ\u0003¢\u0006\u0004\b)\u0010*R4\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010+\u001a\u0004\b,\u0010\u001aR4\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010+\u001a\u0004\b-\u0010\u001aR4\u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010+\u001a\u0004\b.\u0010\u001aR4\u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010+\u001a\u0004\b/\u0010\u001aR4\u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010+\u001a\u0004\b0\u0010\u001aR4\u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010+\u001a\u0004\b1\u0010\u001aR4\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010+\u001a\u0004\b2\u0010\u001a¨\u00063"}, d2 = {"Lcom/xiaomi/security/xsof/frauddetection/bean/DurationFraudData;", "Landroid/os/Parcelable;", "", "", "screenShare", "voipCall", "voipFraudCall", "simCall", "simFraudCall", "overseasCall", "virtualOperatorCall", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "", j.f37184b, "getDurationMap", "(Ljava/lang/String;)Ljava/util/Map;", "Landroid/os/Parcel;", "dest", "flags", "Leb/w;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/util/Map;", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/xiaomi/security/xsof/frauddetection/bean/DurationFraudData;", "toString", "()Ljava/lang/String;", "hashCode", "", RiskyAppDescriptionItem.Columns.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getScreenShare", "getVoipCall", "getVoipFraudCall", "getSimCall", "getSimFraudCall", "getOverseasCall", "getVirtualOperatorCall", "core-service_cnRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class DurationFraudData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<DurationFraudData> CREATOR = new a();

    @SerializedName("overseasCall")
    @Nullable
    private final Map<Integer, Map<Integer, Integer>> overseasCall;

    @SerializedName("screenShare")
    @Nullable
    private final Map<Integer, Map<Integer, Integer>> screenShare;

    @SerializedName("simCall")
    @Nullable
    private final Map<Integer, Map<Integer, Integer>> simCall;

    @SerializedName("simFraudCall")
    @Nullable
    private final Map<Integer, Map<Integer, Integer>> simFraudCall;

    @SerializedName("virtualOperatorCall")
    @Nullable
    private final Map<Integer, Map<Integer, Integer>> virtualOperatorCall;

    @SerializedName("voipCall")
    @Nullable
    private final Map<Integer, Map<Integer, Integer>> voipCall;

    @SerializedName("voipFraudCall")
    @Nullable
    private final Map<Integer, Map<Integer, Integer>> voipFraudCall;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DurationFraudData createFromParcel(Parcel parcel) {
            LinkedHashMap linkedHashMap;
            LinkedHashMap linkedHashMap2;
            LinkedHashMap linkedHashMap3;
            LinkedHashMap linkedHashMap4;
            LinkedHashMap linkedHashMap5;
            LinkedHashMap linkedHashMap6;
            LinkedHashMap linkedHashMap7;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int i10 = parcel.readInt();
                LinkedHashMap linkedHashMap8 = new LinkedHashMap(i10);
                for (int i11 = 0; i11 != i10; i11++) {
                    Integer numValueOf = Integer.valueOf(parcel.readInt());
                    int i12 = parcel.readInt();
                    LinkedHashMap linkedHashMap9 = new LinkedHashMap(i12);
                    for (int i13 = 0; i13 != i12; i13++) {
                        linkedHashMap9.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));
                    }
                    linkedHashMap8.put(numValueOf, linkedHashMap9);
                }
                linkedHashMap = linkedHashMap8;
            }
            if (parcel.readInt() == 0) {
                linkedHashMap2 = null;
            } else {
                int i14 = parcel.readInt();
                LinkedHashMap linkedHashMap10 = new LinkedHashMap(i14);
                for (int i15 = 0; i15 != i14; i15++) {
                    Integer numValueOf2 = Integer.valueOf(parcel.readInt());
                    int i16 = parcel.readInt();
                    LinkedHashMap linkedHashMap11 = new LinkedHashMap(i16);
                    for (int i17 = 0; i17 != i16; i17++) {
                        linkedHashMap11.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));
                    }
                    linkedHashMap10.put(numValueOf2, linkedHashMap11);
                }
                linkedHashMap2 = linkedHashMap10;
            }
            if (parcel.readInt() == 0) {
                linkedHashMap3 = null;
            } else {
                int i18 = parcel.readInt();
                LinkedHashMap linkedHashMap12 = new LinkedHashMap(i18);
                for (int i19 = 0; i19 != i18; i19++) {
                    Integer numValueOf3 = Integer.valueOf(parcel.readInt());
                    int i20 = parcel.readInt();
                    LinkedHashMap linkedHashMap13 = new LinkedHashMap(i20);
                    for (int i21 = 0; i21 != i20; i21++) {
                        linkedHashMap13.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));
                    }
                    linkedHashMap12.put(numValueOf3, linkedHashMap13);
                }
                linkedHashMap3 = linkedHashMap12;
            }
            if (parcel.readInt() == 0) {
                linkedHashMap4 = null;
            } else {
                int i22 = parcel.readInt();
                LinkedHashMap linkedHashMap14 = new LinkedHashMap(i22);
                for (int i23 = 0; i23 != i22; i23++) {
                    Integer numValueOf4 = Integer.valueOf(parcel.readInt());
                    int i24 = parcel.readInt();
                    LinkedHashMap linkedHashMap15 = new LinkedHashMap(i24);
                    for (int i25 = 0; i25 != i24; i25++) {
                        linkedHashMap15.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));
                    }
                    linkedHashMap14.put(numValueOf4, linkedHashMap15);
                }
                linkedHashMap4 = linkedHashMap14;
            }
            if (parcel.readInt() == 0) {
                linkedHashMap5 = null;
            } else {
                int i26 = parcel.readInt();
                LinkedHashMap linkedHashMap16 = new LinkedHashMap(i26);
                for (int i27 = 0; i27 != i26; i27++) {
                    Integer numValueOf5 = Integer.valueOf(parcel.readInt());
                    int i28 = parcel.readInt();
                    LinkedHashMap linkedHashMap17 = new LinkedHashMap(i28);
                    for (int i29 = 0; i29 != i28; i29++) {
                        linkedHashMap17.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));
                    }
                    linkedHashMap16.put(numValueOf5, linkedHashMap17);
                }
                linkedHashMap5 = linkedHashMap16;
            }
            if (parcel.readInt() == 0) {
                linkedHashMap6 = null;
            } else {
                int i30 = parcel.readInt();
                LinkedHashMap linkedHashMap18 = new LinkedHashMap(i30);
                for (int i31 = 0; i31 != i30; i31++) {
                    Integer numValueOf6 = Integer.valueOf(parcel.readInt());
                    int i32 = parcel.readInt();
                    LinkedHashMap linkedHashMap19 = new LinkedHashMap(i32);
                    for (int i33 = 0; i33 != i32; i33++) {
                        linkedHashMap19.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));
                    }
                    linkedHashMap18.put(numValueOf6, linkedHashMap19);
                }
                linkedHashMap6 = linkedHashMap18;
            }
            if (parcel.readInt() == 0) {
                linkedHashMap7 = null;
            } else {
                int i34 = parcel.readInt();
                LinkedHashMap linkedHashMap20 = new LinkedHashMap(i34);
                for (int i35 = 0; i35 != i34; i35++) {
                    Integer numValueOf7 = Integer.valueOf(parcel.readInt());
                    int i36 = parcel.readInt();
                    LinkedHashMap linkedHashMap21 = new LinkedHashMap(i36);
                    for (int i37 = 0; i37 != i36; i37++) {
                        linkedHashMap21.put(Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()));
                    }
                    linkedHashMap20.put(numValueOf7, linkedHashMap21);
                }
                linkedHashMap7 = linkedHashMap20;
            }
            return new DurationFraudData(linkedHashMap, linkedHashMap2, linkedHashMap3, linkedHashMap4, linkedHashMap5, linkedHashMap6, linkedHashMap7);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final DurationFraudData[] newArray(int i10) {
            return new DurationFraudData[i10];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DurationFraudData(@Nullable Map<Integer, ? extends Map<Integer, Integer>> map, @Nullable Map<Integer, ? extends Map<Integer, Integer>> map2, @Nullable Map<Integer, ? extends Map<Integer, Integer>> map3, @Nullable Map<Integer, ? extends Map<Integer, Integer>> map4, @Nullable Map<Integer, ? extends Map<Integer, Integer>> map5, @Nullable Map<Integer, ? extends Map<Integer, Integer>> map6, @Nullable Map<Integer, ? extends Map<Integer, Integer>> map7) {
        this.screenShare = map;
        this.voipCall = map2;
        this.voipFraudCall = map3;
        this.simCall = map4;
        this.simFraudCall = map5;
        this.overseasCall = map6;
        this.virtualOperatorCall = map7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DurationFraudData copy$default(DurationFraudData durationFraudData, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Map map7, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            map = durationFraudData.screenShare;
        }
        if ((i10 & 2) != 0) {
            map2 = durationFraudData.voipCall;
        }
        Map map8 = map2;
        if ((i10 & 4) != 0) {
            map3 = durationFraudData.voipFraudCall;
        }
        Map map9 = map3;
        if ((i10 & 8) != 0) {
            map4 = durationFraudData.simCall;
        }
        Map map10 = map4;
        if ((i10 & 16) != 0) {
            map5 = durationFraudData.simFraudCall;
        }
        Map map11 = map5;
        if ((i10 & 32) != 0) {
            map6 = durationFraudData.overseasCall;
        }
        Map map12 = map6;
        if ((i10 & 64) != 0) {
            map7 = durationFraudData.virtualOperatorCall;
        }
        return durationFraudData.copy(map, map8, map9, map10, map11, map12, map7);
    }

    @Nullable
    public final Map<Integer, Map<Integer, Integer>> component1() {
        return this.screenShare;
    }

    @Nullable
    public final Map<Integer, Map<Integer, Integer>> component2() {
        return this.voipCall;
    }

    @Nullable
    public final Map<Integer, Map<Integer, Integer>> component3() {
        return this.voipFraudCall;
    }

    @Nullable
    public final Map<Integer, Map<Integer, Integer>> component4() {
        return this.simCall;
    }

    @Nullable
    public final Map<Integer, Map<Integer, Integer>> component5() {
        return this.simFraudCall;
    }

    @Nullable
    public final Map<Integer, Map<Integer, Integer>> component6() {
        return this.overseasCall;
    }

    @Nullable
    public final Map<Integer, Map<Integer, Integer>> component7() {
        return this.virtualOperatorCall;
    }

    @NotNull
    public final DurationFraudData copy(@Nullable Map<Integer, ? extends Map<Integer, Integer>> screenShare, @Nullable Map<Integer, ? extends Map<Integer, Integer>> voipCall, @Nullable Map<Integer, ? extends Map<Integer, Integer>> voipFraudCall, @Nullable Map<Integer, ? extends Map<Integer, Integer>> simCall, @Nullable Map<Integer, ? extends Map<Integer, Integer>> simFraudCall, @Nullable Map<Integer, ? extends Map<Integer, Integer>> overseasCall, @Nullable Map<Integer, ? extends Map<Integer, Integer>> virtualOperatorCall) {
        return new DurationFraudData(screenShare, voipCall, voipFraudCall, simCall, simFraudCall, overseasCall, virtualOperatorCall);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DurationFraudData)) {
            return false;
        }
        DurationFraudData durationFraudData = (DurationFraudData) other;
        return n.b(this.screenShare, durationFraudData.screenShare) && n.b(this.voipCall, durationFraudData.voipCall) && n.b(this.voipFraudCall, durationFraudData.voipFraudCall) && n.b(this.simCall, durationFraudData.simCall) && n.b(this.simFraudCall, durationFraudData.simFraudCall) && n.b(this.overseasCall, durationFraudData.overseasCall) && n.b(this.virtualOperatorCall, durationFraudData.virtualOperatorCall);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    public final Map<Integer, Map<Integer, Integer>> getDurationMap(@NotNull String eventName) {
        n.f(eventName, j.f37184b);
        switch (eventName.hashCode()) {
            case -1961529314:
                if (eventName.equals("voipCall")) {
                    return this.voipCall;
                }
                break;
            case -1814346922:
                if (eventName.equals("overseasCall")) {
                    return this.overseasCall;
                }
                break;
            case -679714867:
                if (eventName.equals("virtualOperatorCall")) {
                    return this.virtualOperatorCall;
                }
                break;
            case -572823262:
                if (eventName.equals("voipFraudCall")) {
                    return this.voipFraudCall;
                }
                break;
            case -54525229:
                if (eventName.equals("screenShare")) {
                    return this.screenShare;
                }
                break;
            case 794864587:
                if (eventName.equals("simFraudCall")) {
                    return this.simFraudCall;
                }
                break;
            case 2092525525:
                if (eventName.equals("simCall")) {
                    return this.simCall;
                }
                break;
        }
        return F.h();
    }

    @Nullable
    public final Map<Integer, Map<Integer, Integer>> getOverseasCall() {
        return this.overseasCall;
    }

    @Nullable
    public final Map<Integer, Map<Integer, Integer>> getScreenShare() {
        return this.screenShare;
    }

    @Nullable
    public final Map<Integer, Map<Integer, Integer>> getSimCall() {
        return this.simCall;
    }

    @Nullable
    public final Map<Integer, Map<Integer, Integer>> getSimFraudCall() {
        return this.simFraudCall;
    }

    @Nullable
    public final Map<Integer, Map<Integer, Integer>> getVirtualOperatorCall() {
        return this.virtualOperatorCall;
    }

    @Nullable
    public final Map<Integer, Map<Integer, Integer>> getVoipCall() {
        return this.voipCall;
    }

    @Nullable
    public final Map<Integer, Map<Integer, Integer>> getVoipFraudCall() {
        return this.voipFraudCall;
    }

    public int hashCode() {
        Map<Integer, Map<Integer, Integer>> map = this.screenShare;
        int iHashCode = (map == null ? 0 : map.hashCode()) * 31;
        Map<Integer, Map<Integer, Integer>> map2 = this.voipCall;
        int iHashCode2 = (iHashCode + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<Integer, Map<Integer, Integer>> map3 = this.voipFraudCall;
        int iHashCode3 = (iHashCode2 + (map3 == null ? 0 : map3.hashCode())) * 31;
        Map<Integer, Map<Integer, Integer>> map4 = this.simCall;
        int iHashCode4 = (iHashCode3 + (map4 == null ? 0 : map4.hashCode())) * 31;
        Map<Integer, Map<Integer, Integer>> map5 = this.simFraudCall;
        int iHashCode5 = (iHashCode4 + (map5 == null ? 0 : map5.hashCode())) * 31;
        Map<Integer, Map<Integer, Integer>> map6 = this.overseasCall;
        int iHashCode6 = (iHashCode5 + (map6 == null ? 0 : map6.hashCode())) * 31;
        Map<Integer, Map<Integer, Integer>> map7 = this.virtualOperatorCall;
        return iHashCode6 + (map7 != null ? map7.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "DurationFraudData(screenShare=" + this.screenShare + ", voipCall=" + this.voipCall + ", voipFraudCall=" + this.voipFraudCall + ", simCall=" + this.simCall + ", simFraudCall=" + this.simFraudCall + ", overseasCall=" + this.overseasCall + ", virtualOperatorCall=" + this.virtualOperatorCall + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        n.f(dest, "dest");
        Map<Integer, Map<Integer, Integer>> map = this.screenShare;
        if (map == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(map.size());
            for (Map.Entry<Integer, Map<Integer, Integer>> entry : map.entrySet()) {
                dest.writeInt(entry.getKey().intValue());
                Map<Integer, Integer> value = entry.getValue();
                dest.writeInt(value.size());
                for (Map.Entry<Integer, Integer> entry2 : value.entrySet()) {
                    dest.writeInt(entry2.getKey().intValue());
                    dest.writeInt(entry2.getValue().intValue());
                }
            }
        }
        Map<Integer, Map<Integer, Integer>> map2 = this.voipCall;
        if (map2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(map2.size());
            for (Map.Entry<Integer, Map<Integer, Integer>> entry3 : map2.entrySet()) {
                dest.writeInt(entry3.getKey().intValue());
                Map<Integer, Integer> value2 = entry3.getValue();
                dest.writeInt(value2.size());
                for (Map.Entry<Integer, Integer> entry4 : value2.entrySet()) {
                    dest.writeInt(entry4.getKey().intValue());
                    dest.writeInt(entry4.getValue().intValue());
                }
            }
        }
        Map<Integer, Map<Integer, Integer>> map3 = this.voipFraudCall;
        if (map3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(map3.size());
            for (Map.Entry<Integer, Map<Integer, Integer>> entry5 : map3.entrySet()) {
                dest.writeInt(entry5.getKey().intValue());
                Map<Integer, Integer> value3 = entry5.getValue();
                dest.writeInt(value3.size());
                for (Map.Entry<Integer, Integer> entry6 : value3.entrySet()) {
                    dest.writeInt(entry6.getKey().intValue());
                    dest.writeInt(entry6.getValue().intValue());
                }
            }
        }
        Map<Integer, Map<Integer, Integer>> map4 = this.simCall;
        if (map4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(map4.size());
            for (Map.Entry<Integer, Map<Integer, Integer>> entry7 : map4.entrySet()) {
                dest.writeInt(entry7.getKey().intValue());
                Map<Integer, Integer> value4 = entry7.getValue();
                dest.writeInt(value4.size());
                for (Map.Entry<Integer, Integer> entry8 : value4.entrySet()) {
                    dest.writeInt(entry8.getKey().intValue());
                    dest.writeInt(entry8.getValue().intValue());
                }
            }
        }
        Map<Integer, Map<Integer, Integer>> map5 = this.simFraudCall;
        if (map5 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(map5.size());
            for (Map.Entry<Integer, Map<Integer, Integer>> entry9 : map5.entrySet()) {
                dest.writeInt(entry9.getKey().intValue());
                Map<Integer, Integer> value5 = entry9.getValue();
                dest.writeInt(value5.size());
                for (Map.Entry<Integer, Integer> entry10 : value5.entrySet()) {
                    dest.writeInt(entry10.getKey().intValue());
                    dest.writeInt(entry10.getValue().intValue());
                }
            }
        }
        Map<Integer, Map<Integer, Integer>> map6 = this.overseasCall;
        if (map6 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(map6.size());
            for (Map.Entry<Integer, Map<Integer, Integer>> entry11 : map6.entrySet()) {
                dest.writeInt(entry11.getKey().intValue());
                Map<Integer, Integer> value6 = entry11.getValue();
                dest.writeInt(value6.size());
                for (Map.Entry<Integer, Integer> entry12 : value6.entrySet()) {
                    dest.writeInt(entry12.getKey().intValue());
                    dest.writeInt(entry12.getValue().intValue());
                }
            }
        }
        Map<Integer, Map<Integer, Integer>> map7 = this.virtualOperatorCall;
        if (map7 == null) {
            dest.writeInt(0);
            return;
        }
        dest.writeInt(1);
        dest.writeInt(map7.size());
        for (Map.Entry<Integer, Map<Integer, Integer>> entry13 : map7.entrySet()) {
            dest.writeInt(entry13.getKey().intValue());
            Map<Integer, Integer> value7 = entry13.getValue();
            dest.writeInt(value7.size());
            for (Map.Entry<Integer, Integer> entry14 : value7.entrySet()) {
                dest.writeInt(entry14.getKey().intValue());
                dest.writeInt(entry14.getValue().intValue());
            }
        }
    }
}
