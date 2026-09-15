package in.gov.eci.bloapp.repository;

import dagger.internal.Factory;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class NewVoterrepository_Factory implements Factory<NewVoterrepository> {
    private final Provider<ApiInterface> apiInterfaceProvider;
    private final Provider<DatabaseHelper> dbHandlerProvider;
    private final Provider<EciDatabase> eciDatabaseProvider;

    public NewVoterrepository_Factory(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        this.apiInterfaceProvider = apiInterfaceProvider;
        this.dbHandlerProvider = dbHandlerProvider;
        this.eciDatabaseProvider = eciDatabaseProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public NewVoterrepository m609get() {
        NewVoterrepository newVoterrepositoryNewInstance = newInstance((ApiInterface) this.apiInterfaceProvider.get());
        NewVoterrepository_MembersInjector.injectDbHandler(newVoterrepositoryNewInstance, (DatabaseHelper) this.dbHandlerProvider.get());
        NewVoterrepository_MembersInjector.injectEciDatabase(newVoterrepositoryNewInstance, (EciDatabase) this.eciDatabaseProvider.get());
        return newVoterrepositoryNewInstance;
    }

    public static NewVoterrepository_Factory create(Provider<ApiInterface> apiInterfaceProvider, Provider<DatabaseHelper> dbHandlerProvider, Provider<EciDatabase> eciDatabaseProvider) {
        return new NewVoterrepository_Factory(apiInterfaceProvider, dbHandlerProvider, eciDatabaseProvider);
    }

    public static NewVoterrepository newInstance(ApiInterface apiInterface) {
        return new NewVoterrepository(apiInterface);
    }
}
