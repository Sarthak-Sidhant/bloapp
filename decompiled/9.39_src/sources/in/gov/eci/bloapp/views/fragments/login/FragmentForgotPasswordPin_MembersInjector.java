package in.gov.eci.bloapp.views.fragments.login;

import dagger.MembersInjector;
import in.gov.eci.bloapp.utils.Utils;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class FragmentForgotPasswordPin_MembersInjector implements MembersInjector<FragmentForgotPasswordPin> {
    private final Provider<Utils> utilsProvider;

    public FragmentForgotPasswordPin_MembersInjector(Provider<Utils> utilsProvider) {
        this.utilsProvider = utilsProvider;
    }

    public static MembersInjector<FragmentForgotPasswordPin> create(Provider<Utils> utilsProvider) {
        return new FragmentForgotPasswordPin_MembersInjector(utilsProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(FragmentForgotPasswordPin instance) {
        injectUtils(instance, (Utils) this.utilsProvider.get());
    }

    public static void injectUtils(FragmentForgotPasswordPin instance, Utils utils) {
        instance.utils = utils;
    }
}
