package in.gov.eci.bloapp.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import in.gov.eci.bloapp.room.database.EciDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class AppModule_ProvideEciDatabaseFactory implements Factory<EciDatabase> {
    private final Provider<Context> contextProvider;
    private final AppModule module;

    public AppModule_ProvideEciDatabaseFactory(AppModule module, Provider<Context> contextProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider
    public EciDatabase get() {
        return provideEciDatabase(this.module, this.contextProvider.get());
    }

    public static AppModule_ProvideEciDatabaseFactory create(AppModule module, Provider<Context> contextProvider) {
        return new AppModule_ProvideEciDatabaseFactory(module, contextProvider);
    }

    public static EciDatabase provideEciDatabase(AppModule instance, Context context) {
        return (EciDatabase) Preconditions.checkNotNullFromProvides(instance.provideEciDatabase(context));
    }
}
