package com.miui.packageInstaller.util;

import H3.g;

/* JADX INFO: loaded from: classes.dex */
public final class XiaoMiSafe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f16218a = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public final native String checkPackageSafe(String str, int i6);

        public final native byte[] getKeyBytes();

        public final native byte[] getKeyViBytes();

        public final native String getSaltIv();

        public final native String getSaltKey();

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    static {
        System.loadLibrary("xiaomiSafe");
    }
}
