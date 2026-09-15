package dagger.hilt.android.internal.modules;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class ActivityModule_ProvideFragmentActivityFactory implements Factory<FragmentActivity> {
    private final Provider<Activity> activityProvider;

    public ActivityModule_ProvideFragmentActivityFactory(Provider<Activity> activityProvider) {
        this.activityProvider = activityProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public FragmentActivity m7get() {
        return provideFragmentActivity((Activity) this.activityProvider.get());
    }

    public static ActivityModule_ProvideFragmentActivityFactory create(Provider<Activity> activityProvider) {
        return new ActivityModule_ProvideFragmentActivityFactory(activityProvider);
    }

    public static FragmentActivity provideFragmentActivity(Activity activity) {
        return (FragmentActivity) Preconditions.checkNotNullFromProvides(ActivityModule.provideFragmentActivity(activity));
    }
}
