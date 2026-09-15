package in.gov.eci.bloapp.views.fragments.login;

import dagger.MembersInjector;
import in.gov.eci.bloapp.utils.Utils;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class FragmentForgotPassword_MembersInjector implements MembersInjector<FragmentForgotPassword> {
    private final Provider<Utils> utilsProvider;

    public FragmentForgotPassword_MembersInjector(Provider<Utils> utilsProvider) {
        this.utilsProvider = utilsProvider;
    }

    public static MembersInjector<FragmentForgotPassword> create(Provider<Utils> utilsProvider) {
        return new FragmentForgotPassword_MembersInjector(utilsProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(FragmentForgotPassword instance) {
        injectUtils(instance, (Utils) this.utilsProvider.get());
    }

    public static void injectUtils(FragmentForgotPassword instance, Utils utils) {
        instance.utils = utils;
    }
}
