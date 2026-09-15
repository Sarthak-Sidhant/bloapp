package dagger.hilt.android.internal.managers;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ActivityRetainedComponentManager_Lifecycle_Factory implements Factory<ActivityRetainedComponentManager.Lifecycle> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ActivityRetainedComponentManager.Lifecycle m6get() {
        return newInstance();
    }

    public static ActivityRetainedComponentManager_Lifecycle_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ActivityRetainedComponentManager.Lifecycle newInstance() {
        return new ActivityRetainedComponentManager.Lifecycle();
    }

    private static final class InstanceHolder {
        private static final ActivityRetainedComponentManager_Lifecycle_Factory INSTANCE = new ActivityRetainedComponentManager_Lifecycle_Factory();

        private InstanceHolder() {
        }
    }
}
