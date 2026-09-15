package in.gov.eci.bloapp.views.fragments.login;

import dagger.MembersInjector;
import in.gov.eci.bloapp.utils.Utils;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class FragmentDeviceCompatibility_MembersInjector implements MembersInjector<FragmentDeviceCompatibility> {
    private final Provider<Utils> utilsProvider;

    public FragmentDeviceCompatibility_MembersInjector(Provider<Utils> utilsProvider) {
        this.utilsProvider = utilsProvider;
    }

    public static MembersInjector<FragmentDeviceCompatibility> create(Provider<Utils> utilsProvider) {
        return new FragmentDeviceCompatibility_MembersInjector(utilsProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(FragmentDeviceCompatibility instance) {
        injectUtils(instance, (Utils) this.utilsProvider.get());
    }

    public static void injectUtils(FragmentDeviceCompatibility instance, Utils utils) {
        instance.utils = utils;
    }
}
