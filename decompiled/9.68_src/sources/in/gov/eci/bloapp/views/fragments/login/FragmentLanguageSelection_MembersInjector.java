package in.gov.eci.bloapp.views.fragments.login;

import dagger.MembersInjector;
import in.gov.eci.bloapp.utils.Utils;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public final class FragmentLanguageSelection_MembersInjector implements MembersInjector<FragmentLanguageSelection> {
    private final Provider<Utils> utilsProvider;

    public FragmentLanguageSelection_MembersInjector(Provider<Utils> utilsProvider) {
        this.utilsProvider = utilsProvider;
    }

    public static MembersInjector<FragmentLanguageSelection> create(Provider<Utils> utilsProvider) {
        return new FragmentLanguageSelection_MembersInjector(utilsProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(FragmentLanguageSelection instance) {
        injectUtils(instance, this.utilsProvider.get());
    }

    public static void injectUtils(FragmentLanguageSelection instance, Utils utils) {
        instance.utils = utils;
    }
}
