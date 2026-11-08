package com.miui.guardprovider.sdk;

import android.os.Bundle;
import java.util.Collections;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ScanRequestArgs {
    public static final String ENGINE_AVL = "Avl";
    public static final String ENGINE_MI = "Flamingo";
    public static final int ENGINE_MODE_DEFAULT = 0;
    public static final int ENGINE_MODE_RANDOM = 1;
    public static final int ENGINE_MODE_SPECIFIED = 2;
    public static final String ENGINE_TENCENT = "Tencent";
    private static final String PARAM_ENGINE_MODE = "engine_mode";
    private static final String PARAM_ENGINE_NAMES = "engine_names";
    private static final String PARAM_LOCALE = "locale";
    private static final String PARAM_REJECT_WHEN_BUSY = "reject_when_busy";
    private static final String PARAM_REQUEST_TIMEOUT = "request_timeout";
    static final String PARAM_SCENE = "scene";
    private static final String PARAM_SKIP_WHITELIST = "skip_whitelist";
    public static final String PARAM_USE_CACHE = "use_cache";
    static final String PARAM_USE_CLOUD_SCAN = "use_cloud_scan";
    private static final String PARAM_WAIT_ALL_ENGINES = "wait_all_engines";
    public static final int SCAN_SCENE_DOUBAO = 4;
    public static final int SCAN_SCENE_PACKAGE_INSTALLER = 1;
    public static final int SCAN_SCENE_SECURITY_CENTER_HOME = 2;
    public static final int SCAN_SCENE_SECURITY_CENTER_VIRUS_SCAN = 3;
    public static final int SCAN_SCENE_UNKNOWN = 0;
    private final int engineMode;
    private final Set<String> engineNames;
    private final Locale locale;
    private final boolean rejectWhenBusy;
    private final int requestTimeoutSeconds;
    private final int scene;
    private final boolean skipWhitelist;
    private final boolean useCache;
    private final boolean useCloudScan;
    private final boolean waitAllEngines;

    public static class Builder {
        private final int scene;
        private boolean useCloudScan = true;
        private boolean useCache = true;
        private boolean rejectWhenBusy = false;
        private boolean skipWhitelist = false;
        private boolean waitAllEngines = false;
        private int requestTimeoutSeconds = 0;
        private Locale locale = Locale.getDefault();
        private int engineMode = 0;
        private Set<String> engineNames = Collections.emptySet();

        public Builder(int i6) {
            this.scene = i6;
        }

        public ScanRequestArgs build() {
            if (this.engineMode == 2 && this.engineNames.isEmpty()) {
                throw new IllegalArgumentException("setEngineNames should be called when mode is specified.");
            }
            return new ScanRequestArgs(this.useCloudScan, this.useCache, this.rejectWhenBusy, this.skipWhitelist, this.waitAllEngines, this.scene, this.requestTimeoutSeconds, this.locale, this.engineMode, this.engineNames);
        }

        public Builder setEngineMode(int i6) {
            this.engineMode = i6;
            return this;
        }

        public Builder setEngineNames(Set<String> set) {
            Objects.requireNonNull(set);
            if (set.isEmpty()) {
                throw new IllegalArgumentException("engineNames must not be empty.");
            }
            this.engineNames = b.a(set);
            return this;
        }

        public Builder setLocale(Locale locale) {
            Objects.requireNonNull(locale);
            this.locale = locale;
            return this;
        }

        public Builder setRejectWhenBusy(boolean z6) {
            this.rejectWhenBusy = z6;
            return this;
        }

        public Builder setRequestTimeoutSeconds(int i6) {
            this.requestTimeoutSeconds = i6;
            return this;
        }

        public Builder setSkipWhitelist(boolean z6) {
            this.skipWhitelist = z6;
            return this;
        }

        public Builder setUseCache(boolean z6) {
            this.useCache = z6;
            return this;
        }

        public Builder setUseCloudScan(boolean z6) {
            this.useCloudScan = z6;
            return this;
        }

        public Builder setWaitAllEngines(boolean z6) {
            this.waitAllEngines = z6;
            return this;
        }
    }

    static Bundle defaultArgs() {
        return new Builder(0).build().asArgs();
    }

    Bundle asArgs() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(PARAM_USE_CLOUD_SCAN, this.useCloudScan);
        bundle.putBoolean(PARAM_USE_CACHE, this.useCache);
        bundle.putBoolean(PARAM_REJECT_WHEN_BUSY, this.rejectWhenBusy);
        bundle.putBoolean(PARAM_SKIP_WHITELIST, this.skipWhitelist);
        bundle.putBoolean(PARAM_WAIT_ALL_ENGINES, this.waitAllEngines);
        bundle.putInt("scene", this.scene);
        int i6 = this.requestTimeoutSeconds;
        if (i6 > 0) {
            bundle.putInt(PARAM_REQUEST_TIMEOUT, i6);
        }
        bundle.putString(PARAM_LOCALE, this.locale.toLanguageTag());
        bundle.putInt(PARAM_ENGINE_MODE, this.engineMode);
        if (!this.engineNames.isEmpty()) {
            bundle.putStringArray(PARAM_ENGINE_NAMES, (String[]) this.engineNames.toArray(new String[0]));
        }
        return bundle;
    }

    private ScanRequestArgs(boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i6, int i7, Locale locale, int i8, Set<String> set) {
        this.useCloudScan = z6;
        this.useCache = z7;
        this.rejectWhenBusy = z8;
        this.skipWhitelist = z9;
        this.waitAllEngines = z10;
        this.scene = i6;
        this.requestTimeoutSeconds = i7;
        this.locale = locale;
        this.engineMode = i8;
        this.engineNames = set;
    }
}
