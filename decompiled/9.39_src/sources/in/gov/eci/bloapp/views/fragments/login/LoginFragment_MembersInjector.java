package in.gov.eci.bloapp.views.fragments.login;

import dagger.MembersInjector;
import in.gov.eci.bloapp.utils.Utils;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class LoginFragment_MembersInjector implements MembersInjector<LoginFragment> {
    private final Provider<Utils> utilsProvider;

    public LoginFragment_MembersInjector(Provider<Utils> utilsProvider) {
        this.utilsProvider = utilsProvider;
    }

    public static MembersInjector<LoginFragment> create(Provider<Utils> utilsProvider) {
        return new LoginFragment_MembersInjector(utilsProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(LoginFragment instance) {
        injectUtils(instance, (Utils) this.utilsProvider.get());
    }

    public static void injectUtils(LoginFragment instance, Utils utils) {
        instance.utils = utils;
    }
}
