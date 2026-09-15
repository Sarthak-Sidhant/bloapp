package in.gov.eci.bloapp.views.fragments.login;

import dagger.MembersInjector;
import in.gov.eci.bloapp.utils.Utils;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public final class FragmentSetPassword_MembersInjector implements MembersInjector<FragmentSetPassword> {
    private final Provider<Utils> utilsProvider;

    public FragmentSetPassword_MembersInjector(Provider<Utils> utilsProvider) {
        this.utilsProvider = utilsProvider;
    }

    public static MembersInjector<FragmentSetPassword> create(Provider<Utils> utilsProvider) {
        return new FragmentSetPassword_MembersInjector(utilsProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(FragmentSetPassword instance) {
        injectUtils(instance, this.utilsProvider.get());
    }

    public static void injectUtils(FragmentSetPassword instance, Utils utils) {
        instance.utils = utils;
    }
}
