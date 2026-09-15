package in.gov.eci.bloapp.utils;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class Utils_Factory implements Factory<Utils> {
    @Override // javax.inject.Provider
    public Utils get() {
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
