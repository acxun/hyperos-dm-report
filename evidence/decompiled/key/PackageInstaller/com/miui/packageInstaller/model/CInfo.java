package com.miui.packageInstaller.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class CInfo implements Serializable {
    private Boolean cFlag;
    private Long cOffset = 0L;
    private Long cSize = 0L;
    private Boolean tFlag;

    public final Boolean getCFlag() {
        return this.cFlag;
    }

    public final Long getCOffset() {
        return this.cOffset;
    }

    public final Long getCSize() {
        return this.cSize;
    }

    public final Boolean getTFlag() {
        return this.tFlag;
    }

    public final void setCFlag(Boolean bool) {
        this.cFlag = bool;
    }

    public final void setCOffset(Long l6) {
        this.cOffset = l6;
    }

    public final void setCSize(Long l6) {
        this.cSize = l6;
    }

    public final void setTFlag(Boolean bool) {
        this.tFlag = bool;
    }
}
