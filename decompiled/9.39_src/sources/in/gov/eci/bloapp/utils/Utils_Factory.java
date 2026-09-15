package in.gov.eci.bloapp.utils;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class Utils_Factory implements Factory<Utils> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Utils m633get() {
        return newInstance();
    }

    public static Utils_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Utils newInstance() {
        return new Utils();
    }

    private static final class InstanceHolder {
        private static final Utils_Factory INSTANCE = new Utils_Factory();

        private InstanceHolder() {
        }
    }
}
