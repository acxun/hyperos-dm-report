package com.xiaomi.security.xsof.frauddetection.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.miui.riskyapp.model.RiskyAppDescriptionItem;
import kotlin.Metadata;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p278tb.n;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0012J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0012J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0012J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0012JL\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0012J\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010$\u001a\u0004\b&\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b'\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b(\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b)\u0010\u0012R\u001a\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b*\u0010\u0012¨\u0006+"}, d2 = {"Lcom/xiaomi/security/xsof/frauddetection/bean/CurrentFraudMetadata;", "Landroid/os/Parcelable;", "", "screenSharing", "voipCalling", "voipFraudCalling", "simCardCalling", "simCardFraudCalling", "callForwarding", "<init>", "(IIIIII)V", "Landroid/os/Parcel;", "dest", "flags", "Leb/w;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(IIIIII)Lcom/xiaomi/security/xsof/frauddetection/bean/CurrentFraudMetadata;", "", "toString", "()Ljava/lang/String;", "hashCode", "", RiskyAppDescriptionItem.Columns.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "I", "getScreenSharing", "getVoipCalling", "getVoipFraudCalling", "getSimCardCalling", "getSimCardFraudCalling", "getCallForwarding", "core-service_cnRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class CurrentFraudMetadata implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<CurrentFraudMetadata> CREATOR = new a();

    @SerializedName("callForwarding")
    private final int callForwarding;

    @SerializedName("screenSharing")
    private final int screenSharing;

    @SerializedName("simCardCalling")
    private final int simCardCalling;

    @SerializedName("simCardFraudCalling")
    private final int simCardFraudCalling;

    @SerializedName("voipCalling")
    private final int voipCalling;

    @SerializedName("voipFraudCalling")
    private final int voipFraudCalling;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CurrentFraudMetadata createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new CurrentFraudMetadata(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CurrentFraudMetadata[] newArray(int i10) {
            return new CurrentFraudMetadata[i10];
        }
    }

    public CurrentFraudMetadata(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.screenSharing = i10;
        this.voipCalling = i11;
        this.voipFraudCalling = i12;
        this.simCardCalling = i13;
        this.simCardFraudCalling = i14;
        this.callForwarding = i15;
    }

    public static /* synthetic */ CurrentFraudMetadata copy$default(CurrentFraudMetadata currentFraudMetadata, int i10, int i11, int i12, int i13, int i14, int i15, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i10 = currentFraudMetadata.screenSharing;
        }
        if ((i16 & 2) != 0) {
            i11 = currentFraudMetadata.voipCalling;
        }
        int i17 = i11;
        if ((i16 & 4) != 0) {
            i12 = currentFraudMetadata.voipFraudCalling;
        }
        int i18 = i12;
        if ((i16 & 8) != 0) {
            i13 = currentFraudMetadata.simCardCalling;
        }
        int i19 = i13;
        if ((i16 & 16) != 0) {
            i14 = currentFraudMetadata.simCardFraudCalling;
        }
        int i20 = i14;
        if ((i16 & 32) != 0) {
            i15 = currentFraudMetadata.callForwarding;
        }
        return currentFraudMetadata.copy(i10, i17, i18, i19, i20, i15);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getScreenSharing() {
        return this.screenSharing;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getVoipCalling() {
        return this.voipCalling;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getVoipFraudCalling() {
        return this.voipFraudCalling;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getSimCardCalling() {
        return this.simCardCalling;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getSimCardFraudCalling() {
        return this.simCardFraudCalling;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getCallForwarding() {
        return this.callForwarding;
    }

    @NotNull
    public final CurrentFraudMetadata copy(int screenSharing, int voipCalling, int voipFraudCalling, int simCardCalling, int simCardFraudCalling, int callForwarding) {
        return new CurrentFraudMetadata(screenSharing, voipCalling, voipFraudCalling, simCardCalling, simCardFraudCalling, callForwarding);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CurrentFraudMetadata)) {
            return false;
        }
        CurrentFraudMetadata currentFraudMetadata = (CurrentFraudMetadata) other;
        return this.screenSharing == currentFraudMetadata.screenSharing && this.voipCalling == currentFraudMetadata.voipCalling && this.voipFraudCalling == currentFraudMetadata.voipFraudCalling && this.simCardCalling == currentFraudMetadata.simCardCalling && this.simCardFraudCalling == currentFraudMetadata.simCardFraudCalling && this.callForwarding == currentFraudMetadata.callForwarding;
    }

    public final int getCallForwarding() {
        return this.callForwarding;
    }

    public final int getScreenSharing() {
        return this.screenSharing;
    }

    public final int getSimCardCalling() {
        return this.simCardCalling;
    }

    public final int getSimCardFraudCalling() {
        return this.simCardFraudCalling;
    }

    public final int getVoipCalling() {
        return this.voipCalling;
    }

    public final int getVoipFraudCalling() {
        return this.voipFraudCalling;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.screenSharing) * 31) + Integer.hashCode(this.voipCalling)) * 31) + Integer.hashCode(this.voipFraudCalling)) * 31) + Integer.hashCode(this.simCardCalling)) * 31) + Integer.hashCode(this.simCardFraudCalling)) * 31) + Integer.hashCode(this.callForwarding);
    }

    @NotNull
    public String toString() {
        return "CurrentFraudMetadata(screenSharing=" + this.screenSharing + ", voipCalling=" + this.voipCalling + ", voipFraudCalling=" + this.voipFraudCalling + ", simCardCalling=" + this.simCardCalling + ", simCardFraudCalling=" + this.simCardFraudCalling + ", callForwarding=" + this.callForwarding + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        n.f(dest, "dest");
        dest.writeInt(this.screenSharing);
        dest.writeInt(this.voipCalling);
        dest.writeInt(this.voipFraudCalling);
        dest.writeInt(this.simCardCalling);
        dest.writeInt(this.simCardFraudCalling);
        dest.writeInt(this.callForwarding);
    }
}
