package in.gov.eci.bloapp.di;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_Lifecycle_Factory;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.AadharAuthRepository;
import in.gov.eci.bloapp.repository.AadharAuthRepository_Factory;
import in.gov.eci.bloapp.repository.AadharAuthRepository_MembersInjector;
import in.gov.eci.bloapp.repository.AllApplicationRepository;
import in.gov.eci.bloapp.repository.AllApplicationRepository_Factory;
import in.gov.eci.bloapp.repository.AllApplicationRepository_MembersInjector;
import in.gov.eci.bloapp.repository.BloNotificationRepo;
import in.gov.eci.bloapp.repository.BloNotificationRepo_Factory;
import in.gov.eci.bloapp.repository.BloNotificationRepo_MembersInjector;
import in.gov.eci.bloapp.repository.CheckListRepository;
import in.gov.eci.bloapp.repository.CheckListRepository_Factory;
import in.gov.eci.bloapp.repository.CheckListRepository_MembersInjector;
import in.gov.eci.bloapp.repository.DeletionObjectionRepository;
import in.gov.eci.bloapp.repository.DeletionObjectionRepository_Factory;
import in.gov.eci.bloapp.repository.DeletionObjectionRepository_MembersInjector;
import in.gov.eci.bloapp.repository.DeviceCompatibilityRepository;
import in.gov.eci.bloapp.repository.DeviceCompatibilityRepository_Factory;
import in.gov.eci.bloapp.repository.DeviceCompatibilityRepository_MembersInjector;
import in.gov.eci.bloapp.repository.DraftRepository;
import in.gov.eci.bloapp.repository.DraftRepository_Factory;
import in.gov.eci.bloapp.repository.DraftRepository_MembersInjector;
import in.gov.eci.bloapp.repository.ElectorsListRepository;
import in.gov.eci.bloapp.repository.FacilitiesRepository;
import in.gov.eci.bloapp.repository.FacilitiesRepository_Factory;
import in.gov.eci.bloapp.repository.FacilitiesRepository_MembersInjector;
import in.gov.eci.bloapp.repository.FormsRepo;
import in.gov.eci.bloapp.repository.FormsRepo_Factory;
import in.gov.eci.bloapp.repository.FormsRepo_MembersInjector;
import in.gov.eci.bloapp.repository.MainRepository;
import in.gov.eci.bloapp.repository.MainRepository_Factory;
import in.gov.eci.bloapp.repository.MainRepository_MembersInjector;
import in.gov.eci.bloapp.repository.MigrationRepository;
import in.gov.eci.bloapp.repository.MigrationRepository_Factory;
import in.gov.eci.bloapp.repository.MigrationRepository_MembersInjector;
import in.gov.eci.bloapp.repository.MyDetailsRepository;
import in.gov.eci.bloapp.repository.MyDetailsRepository_Factory;
import in.gov.eci.bloapp.repository.MyDetailsRepository_MembersInjector;
import in.gov.eci.bloapp.repository.NewVoterrepository;
import in.gov.eci.bloapp.repository.NewVoterrepository_Factory;
import in.gov.eci.bloapp.repository.NewVoterrepository_MembersInjector;
import in.gov.eci.bloapp.repository.OverseasDetailsRepository;
import in.gov.eci.bloapp.repository.OverseasDetailsRepository_Factory;
import in.gov.eci.bloapp.repository.OverseasDetailsRepository_MembersInjector;
import in.gov.eci.bloapp.repository.PseRepository;
import in.gov.eci.bloapp.repository.PseRepository_Factory;
import in.gov.eci.bloapp.repository.PseRepository_MembersInjector;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import in.gov.eci.bloapp.utils.Utils;
import in.gov.eci.bloapp.viewmodel.AadharAuthViewModel;
import in.gov.eci.bloapp.viewmodel.AadharAuthViewModel_Factory;
import in.gov.eci.bloapp.viewmodel.AadharAuthViewModel_HiltModules_KeyModule_ProvideFactory;
import in.gov.eci.bloapp.viewmodel.AadharAuthViewModel_MembersInjector;
import in.gov.eci.bloapp.viewmodel.AllApplicatonViewModel;
import in.gov.eci.bloapp.viewmodel.AllApplicatonViewModel_Factory;
import in.gov.eci.bloapp.viewmodel.AllApplicatonViewModel_HiltModules_KeyModule_ProvideFactory;
import in.gov.eci.bloapp.viewmodel.AllApplicatonViewModel_MembersInjector;
import in.gov.eci.bloapp.viewmodel.BloNotificationViewModel;
import in.gov.eci.bloapp.viewmodel.BloNotificationViewModel_HiltModules_KeyModule_ProvideFactory;
import in.gov.eci.bloapp.viewmodel.CheckListViewModel;
import in.gov.eci.bloapp.viewmodel.CheckListViewModel_Factory;
import in.gov.eci.bloapp.viewmodel.CheckListViewModel_HiltModules_KeyModule_ProvideFactory;
import in.gov.eci.bloapp.viewmodel.CheckListViewModel_MembersInjector;
import in.gov.eci.bloapp.viewmodel.DeletionObjectionViewModel;
import in.gov.eci.bloapp.viewmodel.DeletionObjectionViewModel_Factory;
import in.gov.eci.bloapp.viewmodel.DeletionObjectionViewModel_HiltModules_KeyModule_ProvideFactory;
import in.gov.eci.bloapp.viewmodel.DeletionObjectionViewModel_MembersInjector;
import in.gov.eci.bloapp.viewmodel.DeviceCompatibilityViewModel;
import in.gov.eci.bloapp.viewmodel.DeviceCompatibilityViewModel_Factory;
import in.gov.eci.bloapp.viewmodel.DeviceCompatibilityViewModel_HiltModules_KeyModule_ProvideFactory;
import in.gov.eci.bloapp.viewmodel.DeviceCompatibilityViewModel_MembersInjector;
import in.gov.eci.bloapp.viewmodel.DraftinformsViewModel;
import in.gov.eci.bloapp.viewmodel.DraftinformsViewModel_Factory;
import in.gov.eci.bloapp.viewmodel.DraftinformsViewModel_HiltModules_KeyModule_ProvideFactory;
import in.gov.eci.bloapp.viewmodel.DraftinformsViewModel_MembersInjector;
import in.gov.eci.bloapp.viewmodel.ElectorsListViewModel;
import in.gov.eci.bloapp.viewmodel.ElectorsListViewModel_HiltModules_KeyModule_ProvideFactory;
import in.gov.eci.bloapp.viewmodel.FacilitiesViewModel;
import in.gov.eci.bloapp.viewmodel.FacilitiesViewModel_Factory;
import in.gov.eci.bloapp.viewmodel.FacilitiesViewModel_HiltModules_KeyModule_ProvideFactory;
import in.gov.eci.bloapp.viewmodel.FacilitiesViewModel_MembersInjector;
import in.gov.eci.bloapp.viewmodel.FormsViewModel;
import in.gov.eci.bloapp.viewmodel.FormsViewModel_Factory;
import in.gov.eci.bloapp.viewmodel.FormsViewModel_HiltModules_KeyModule_ProvideFactory;
import in.gov.eci.bloapp.viewmodel.FormsViewModel_MembersInjector;
import in.gov.eci.bloapp.viewmodel.LoginViewModel;
import in.gov.eci.bloapp.viewmodel.LoginViewModel_Factory;
import in.gov.eci.bloapp.viewmodel.LoginViewModel_HiltModules_KeyModule_ProvideFactory;
import in.gov.eci.bloapp.viewmodel.LoginViewModel_MembersInjector;
import in.gov.eci.bloapp.viewmodel.MainActivityViewModel;
import in.gov.eci.bloapp.viewmodel.MainActivityViewModel_Factory;
import in.gov.eci.bloapp.viewmodel.MainActivityViewModel_HiltModules_KeyModule_ProvideFactory;
import in.gov.eci.bloapp.viewmodel.MainActivityViewModel_MembersInjector;
import in.gov.eci.bloapp.viewmodel.MigrationViewModel;
import in.gov.eci.bloapp.viewmodel.MigrationViewModel_HiltModules_KeyModule_ProvideFactory;
import in.gov.eci.bloapp.viewmodel.MyDetailsViewModel;
import in.gov.eci.bloapp.viewmodel.MyDetailsViewModel_Factory;
import in.gov.eci.bloapp.viewmodel.MyDetailsViewModel_HiltModules_KeyModule_ProvideFactory;
import in.gov.eci.bloapp.viewmodel.MyDetailsViewModel_MembersInjector;
import in.gov.eci.bloapp.viewmodel.NewVoterViewModel;
import in.gov.eci.bloapp.viewmodel.NewVoterViewModel_HiltModules_KeyModule_ProvideFactory;
import in.gov.eci.bloapp.viewmodel.OverseasDetailViewModel;
import in.gov.eci.bloapp.viewmodel.OverseasDetailViewModel_HiltModules_KeyModule_ProvideFactory;
import in.gov.eci.bloapp.viewmodel.PreviewEpicViewModel;
import in.gov.eci.bloapp.viewmodel.PreviewEpicViewModel_Factory;
import in.gov.eci.bloapp.viewmodel.PreviewEpicViewModel_HiltModules_KeyModule_ProvideFactory;
import in.gov.eci.bloapp.viewmodel.PreviewEpicViewModel_MembersInjector;
import in.gov.eci.bloapp.viewmodel.PreviewViewModel;
import in.gov.eci.bloapp.viewmodel.PreviewViewModel_Factory;
import in.gov.eci.bloapp.viewmodel.PreviewViewModel_HiltModules_KeyModule_ProvideFactory;
import in.gov.eci.bloapp.viewmodel.PreviewViewModel_MembersInjector;
import in.gov.eci.bloapp.viewmodel.PseViewModel;
import in.gov.eci.bloapp.viewmodel.PseViewModel_Factory;
import in.gov.eci.bloapp.viewmodel.PseViewModel_HiltModules_KeyModule_ProvideFactory;
import in.gov.eci.bloapp.viewmodel.PseViewModel_MembersInjector;
import in.gov.eci.bloapp.views.activity.AboutECIActivity;
import in.gov.eci.bloapp.views.activity.AboutHonbleCommissionActivity;
import in.gov.eci.bloapp.views.activity.ActivityEditMyAccount;
import in.gov.eci.bloapp.views.activity.ActivityMyAccount;
import in.gov.eci.bloapp.views.activity.ActivityPendingProfile;
import in.gov.eci.bloapp.views.activity.ActivitySendForApproval;
import in.gov.eci.bloapp.views.activity.BloNotifiy;
import in.gov.eci.bloapp.views.activity.CheckList;
import in.gov.eci.bloapp.views.activity.DseActivity;
import in.gov.eci.bloapp.views.activity.DseForm7Activity;
import in.gov.eci.bloapp.views.activity.ElectorsListActivity;
import in.gov.eci.bloapp.views.activity.Housetohouse;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.activity.PseActivity;
import in.gov.eci.bloapp.views.activity.VoterForms;
import in.gov.eci.bloapp.views.activity.facility;
import in.gov.eci.bloapp.views.activity.trackStatus;
import in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment;
import in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment;
import in.gov.eci.bloapp.views.fragments.checklist.CheckListMain;
import in.gov.eci.bloapp.views.fragments.checklist.SearchListFragment;
import in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment;
import in.gov.eci.bloapp.views.fragments.checklist.VerifiedFragment;
import in.gov.eci.bloapp.views.fragments.checklist.VerifiedSearchListActivity;
import in.gov.eci.bloapp.views.fragments.checklist.form6.Form6;
import in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment;
import in.gov.eci.bloapp.views.fragments.facilities.Facilities;
import in.gov.eci.bloapp.views.fragments.h2h.H2HFragment;
import in.gov.eci.bloapp.views.fragments.h2h.HouseNumberFragment;
import in.gov.eci.bloapp.views.fragments.home.HomeFragment;
import in.gov.eci.bloapp.views.fragments.login.FragmentDeviceCompatibility;
import in.gov.eci.bloapp.views.fragments.login.FragmentDeviceCompatibility_MembersInjector;
import in.gov.eci.bloapp.views.fragments.login.FragmentLanguageSelection;
import in.gov.eci.bloapp.views.fragments.login.FragmentLanguageSelection_MembersInjector;
import in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection;
import in.gov.eci.bloapp.views.fragments.login.LoginFragment;
import in.gov.eci.bloapp.views.fragments.login.LoginFragment_MembersInjector;
import in.gov.eci.bloapp.views.fragments.login.OTPFragment;
import in.gov.eci.bloapp.views.fragments.my_account.MyAccount;
import in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionTabLayoutActivity;
import in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity;
import in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft;
import in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Epic;
import in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form;
import in.gov.eci.bloapp.views.fragments.voterforms.migration.PreviewActivity;
import in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackRejectedFragment;
import in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusMainFragment;
import in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackSubmittedStatusFragment;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class DaggerMyApp_HiltComponents_SingletonC extends MyApp_HiltComponents.SingletonC {
    private final AppModule appModule;
    private final ApplicationContextModule applicationContextModule;
    private final ElectoralListModule electoralListModule;
    private Provider<Retrofit> getApiClientProvider;
    private Provider<ApiInterface> getApiInterfaceProvider;
    private Provider<DatabaseHelper> getDatabaseProvider;
    private Provider<GsonConverterFactory> provideConverterFactoryProvider;
    private Provider<EciDatabase> provideEciDatabaseProvider;
    private Provider<OkHttpClient> provideHttpClientProvider;
    private Provider<HttpLoggingInterceptor> provideHttpLoggingInterceptorProvider;
    private Provider<Retrofit> provideRetrofitElectorsListProvider;
    private Provider<UserClient> provideRetrofitServiceElectorsListProvider;
    private final DaggerMyApp_HiltComponents_SingletonC singletonC;

    @Override // in.gov.eci.bloapp.di.MyApp_GeneratedInjector
    public void injectMyApp(MyApp myApp) {
    }

    private DaggerMyApp_HiltComponents_SingletonC(AppModule appModuleParam, ApplicationContextModule applicationContextModuleParam, ElectoralListModule electoralListModuleParam) {
        this.singletonC = this;
        this.applicationContextModule = applicationContextModuleParam;
        this.appModule = appModuleParam;
        this.electoralListModule = electoralListModuleParam;
        initialize(appModuleParam, applicationContextModuleParam, electoralListModuleParam);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(final AppModule appModuleParam, final ApplicationContextModule applicationContextModuleParam, final ElectoralListModule electoralListModuleParam) {
        this.getApiClientProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonC, 1));
        this.getApiInterfaceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonC, 0));
        this.getDatabaseProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonC, 2));
        this.provideEciDatabaseProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonC, 3));
        this.provideHttpLoggingInterceptorProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonC, 7));
        this.provideHttpClientProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonC, 6));
        this.provideConverterFactoryProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonC, 8));
        this.provideRetrofitElectorsListProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonC, 5));
        this.provideRetrofitServiceElectorsListProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonC, 4));
    }

    @Override // dagger.hilt.android.flags.FragmentGetContextFix.FragmentGetContextFixEntryPoint
    public Set<Boolean> getDisableFragmentGetContextFix() {
        return ImmutableSet.of();
    }

    @Override // dagger.hilt.android.internal.managers.ActivityRetainedComponentManager.ActivityRetainedComponentBuilderEntryPoint
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
        return new ActivityRetainedCBuilder();
    }

    @Override // dagger.hilt.android.internal.managers.ServiceComponentManager.ServiceComponentBuilderEntryPoint
    public ServiceComponentBuilder serviceComponentBuilder() {
        return new ServiceCBuilder();
    }

    public static final class Builder {
        private AppModule appModule;
        private ApplicationContextModule applicationContextModule;
        private ElectoralListModule electoralListModule;

        private Builder() {
        }

        public Builder appModule(AppModule appModule) {
            this.appModule = (AppModule) Preconditions.checkNotNull(appModule);
            return this;
        }

        public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
            this.applicationContextModule = (ApplicationContextModule) Preconditions.checkNotNull(applicationContextModule);
            return this;
        }

        public Builder electoralListModule(ElectoralListModule electoralListModule) {
            this.electoralListModule = (ElectoralListModule) Preconditions.checkNotNull(electoralListModule);
            return this;
        }

        @Deprecated
        public Builder hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule(HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule) {
            Preconditions.checkNotNull(hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule);
            return this;
        }

        public MyApp_HiltComponents.SingletonC build() {
            if (this.appModule == null) {
                this.appModule = new AppModule();
            }
            Preconditions.checkBuilderRequirement(this.applicationContextModule, ApplicationContextModule.class);
            if (this.electoralListModule == null) {
                this.electoralListModule = new ElectoralListModule();
            }
            return new DaggerMyApp_HiltComponents_SingletonC(this.appModule, this.applicationContextModule, this.electoralListModule);
        }
    }

    private static final class ActivityRetainedCBuilder implements MyApp_HiltComponents.ActivityRetainedC.Builder {
        private final DaggerMyApp_HiltComponents_SingletonC singletonC;

        private ActivityRetainedCBuilder(DaggerMyApp_HiltComponents_SingletonC singletonC) {
            this.singletonC = singletonC;
        }

        @Override // dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder
        public MyApp_HiltComponents.ActivityRetainedC build() {
            return new ActivityRetainedCImpl();
        }
    }

    private static final class ActivityCBuilder implements MyApp_HiltComponents.ActivityC.Builder {
        private Activity activity;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final DaggerMyApp_HiltComponents_SingletonC singletonC;

        private ActivityCBuilder(DaggerMyApp_HiltComponents_SingletonC singletonC, ActivityRetainedCImpl activityRetainedCImpl) {
            this.singletonC = singletonC;
            this.activityRetainedCImpl = activityRetainedCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.ActivityComponentBuilder
        public ActivityCBuilder activity(Activity activity) {
            this.activity = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.ActivityComponentBuilder
        public MyApp_HiltComponents.ActivityC build() {
            Preconditions.checkBuilderRequirement(this.activity, Activity.class);
            return new ActivityCImpl(this.activityRetainedCImpl, this.activity);
        }
    }

    private static final class FragmentCBuilder implements MyApp_HiltComponents.FragmentC.Builder {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private Fragment fragment;
        private final DaggerMyApp_HiltComponents_SingletonC singletonC;

        private FragmentCBuilder(DaggerMyApp_HiltComponents_SingletonC singletonC, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
            this.singletonC = singletonC;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.FragmentComponentBuilder
        public FragmentCBuilder fragment(Fragment fragment) {
            this.fragment = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.FragmentComponentBuilder
        public MyApp_HiltComponents.FragmentC build() {
            Preconditions.checkBuilderRequirement(this.fragment, Fragment.class);
            return new FragmentCImpl(this.activityRetainedCImpl, this.activityCImpl, this.fragment);
        }
    }

    private static final class ViewWithFragmentCBuilder implements MyApp_HiltComponents.ViewWithFragmentC.Builder {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final FragmentCImpl fragmentCImpl;
        private final DaggerMyApp_HiltComponents_SingletonC singletonC;
        private View view;

        private ViewWithFragmentCBuilder(DaggerMyApp_HiltComponents_SingletonC singletonC, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, FragmentCImpl fragmentCImpl) {
            this.singletonC = singletonC;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
            this.fragmentCImpl = fragmentCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder
        public ViewWithFragmentCBuilder view(View view) {
            this.view = (View) Preconditions.checkNotNull(view);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder
        public MyApp_HiltComponents.ViewWithFragmentC build() {
            Preconditions.checkBuilderRequirement(this.view, View.class);
            return new ViewWithFragmentCImpl(this.activityRetainedCImpl, this.activityCImpl, this.fragmentCImpl, this.view);
        }
    }

    private static final class ViewCBuilder implements MyApp_HiltComponents.ViewC.Builder {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final DaggerMyApp_HiltComponents_SingletonC singletonC;
        private View view;

        private ViewCBuilder(DaggerMyApp_HiltComponents_SingletonC singletonC, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
            this.singletonC = singletonC;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.ViewComponentBuilder
        public ViewCBuilder view(View view) {
            this.view = (View) Preconditions.checkNotNull(view);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.ViewComponentBuilder
        public MyApp_HiltComponents.ViewC build() {
            Preconditions.checkBuilderRequirement(this.view, View.class);
            return new ViewCImpl(this.activityRetainedCImpl, this.activityCImpl, this.view);
        }
    }

    private static final class ViewModelCBuilder implements MyApp_HiltComponents.ViewModelC.Builder {
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private SavedStateHandle savedStateHandle;
        private final DaggerMyApp_HiltComponents_SingletonC singletonC;

        private ViewModelCBuilder(DaggerMyApp_HiltComponents_SingletonC singletonC, ActivityRetainedCImpl activityRetainedCImpl) {
            this.singletonC = singletonC;
            this.activityRetainedCImpl = activityRetainedCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.ViewModelComponentBuilder
        public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
            this.savedStateHandle = (SavedStateHandle) Preconditions.checkNotNull(handle);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.ViewModelComponentBuilder
        public MyApp_HiltComponents.ViewModelC build() {
            Preconditions.checkBuilderRequirement(this.savedStateHandle, SavedStateHandle.class);
            return new ViewModelCImpl(this.activityRetainedCImpl, this.savedStateHandle);
        }
    }

    private static final class ServiceCBuilder implements MyApp_HiltComponents.ServiceC.Builder {
        private Service service;
        private final DaggerMyApp_HiltComponents_SingletonC singletonC;

        private ServiceCBuilder(DaggerMyApp_HiltComponents_SingletonC singletonC) {
            this.singletonC = singletonC;
        }

        @Override // dagger.hilt.android.internal.builders.ServiceComponentBuilder
        public ServiceCBuilder service(Service service) {
            this.service = (Service) Preconditions.checkNotNull(service);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.ServiceComponentBuilder
        public MyApp_HiltComponents.ServiceC build() {
            Preconditions.checkBuilderRequirement(this.service, Service.class);
            return new ServiceCImpl(this.service);
        }
    }

    private static final class ViewWithFragmentCImpl extends MyApp_HiltComponents.ViewWithFragmentC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final FragmentCImpl fragmentCImpl;
        private final DaggerMyApp_HiltComponents_SingletonC singletonC;
        private final ViewWithFragmentCImpl viewWithFragmentCImpl;

        private ViewWithFragmentCImpl(DaggerMyApp_HiltComponents_SingletonC singletonC, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, FragmentCImpl fragmentCImpl, View viewParam) {
            this.viewWithFragmentCImpl = this;
            this.singletonC = singletonC;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
            this.fragmentCImpl = fragmentCImpl;
        }
    }

    private static final class FragmentCImpl extends MyApp_HiltComponents.FragmentC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final FragmentCImpl fragmentCImpl;
        private final DaggerMyApp_HiltComponents_SingletonC singletonC;

        @Override // in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment_GeneratedInjector
        public void injectApplicantDetailsForm7Fragment(ApplicantDetailsForm7Fragment applicantDetailsForm7Fragment) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment_GeneratedInjector
        public void injectApplicantDetailsFragment(ApplicantDetailsFragment applicantDetailsFragment) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.checklist.CheckListMain_GeneratedInjector
        public void injectCheckListMain(CheckListMain checkListMain) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment_GeneratedInjector
        public void injectElectorDataSyncFragment(ElectorDataSyncFragment electorDataSyncFragment) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.facilities.Facilities_GeneratedInjector
        public void injectFacilities(Facilities facilities) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.checklist.form6.Form6_GeneratedInjector
        public void injectForm6(Form6 form6) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft_GeneratedInjector
        public void injectFormsInDraft(FormsInDraft formsInDraft) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection_GeneratedInjector
        public void injectFragmentPartNumberSelection(FragmentPartNumberSelection fragmentPartNumberSelection) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.h2h.H2HFragment_GeneratedInjector
        public void injectH2HFragment(H2HFragment h2HFragment) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.home.HomeFragment_GeneratedInjector
        public void injectHomeFragment(HomeFragment homeFragment) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.h2h.HouseNumberFragment_GeneratedInjector
        public void injectHouseNumberFragment(HouseNumberFragment houseNumberFragment) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Epic_GeneratedInjector
        public void injectMigration_preview_Epic(Migration_preview_Epic migration_preview_Epic) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form_GeneratedInjector
        public void injectMigration_preview_Form(Migration_preview_Form migration_preview_Form) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.my_account.MyAccount_GeneratedInjector
        public void injectMyAccount(MyAccount myAccount) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.login.OTPFragment_GeneratedInjector
        public void injectOTPFragment(OTPFragment oTPFragment) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.checklist.SearchListFragment_GeneratedInjector
        public void injectSearchListFragment(SearchListFragment searchListFragment) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment_GeneratedInjector
        public void injectTotalListFragment(TotalListFragment totalListFragment) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackRejectedFragment_GeneratedInjector
        public void injectTrackRejectedFragment(TrackRejectedFragment trackRejectedFragment) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusMainFragment_GeneratedInjector
        public void injectTrackStatusMainFragment(TrackStatusMainFragment trackStatusMainFragment) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackSubmittedStatusFragment_GeneratedInjector
        public void injectTrackSubmittedStatusFragment(TrackSubmittedStatusFragment trackSubmittedStatusFragment) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.checklist.VerifiedFragment_GeneratedInjector
        public void injectVerifiedFragment(VerifiedFragment verifiedFragment) {
        }

        private FragmentCImpl(DaggerMyApp_HiltComponents_SingletonC singletonC, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, Fragment fragmentParam) {
            this.fragmentCImpl = this;
            this.singletonC = singletonC;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
        }

        @Override // dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories.FragmentEntryPoint
        public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
            return this.activityCImpl.getHiltInternalFactoryFactory();
        }

        @Override // dagger.hilt.android.internal.managers.ViewComponentManager.ViewWithFragmentComponentBuilderEntryPoint
        public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
            return new ViewWithFragmentCBuilder(this.activityRetainedCImpl, this.activityCImpl, this.fragmentCImpl);
        }

        @Override // in.gov.eci.bloapp.views.fragments.login.FragmentDeviceCompatibility_GeneratedInjector
        public void injectFragmentDeviceCompatibility(FragmentDeviceCompatibility fragmentDeviceCompatibility) {
            injectFragmentDeviceCompatibility2(fragmentDeviceCompatibility);
        }

        @Override // in.gov.eci.bloapp.views.fragments.login.FragmentLanguageSelection_GeneratedInjector
        public void injectFragmentLanguageSelection(FragmentLanguageSelection fragmentLanguageSelection) {
            injectFragmentLanguageSelection2(fragmentLanguageSelection);
        }

        @Override // in.gov.eci.bloapp.views.fragments.login.LoginFragment_GeneratedInjector
        public void injectLoginFragment(LoginFragment loginFragment) {
            injectLoginFragment2(loginFragment);
        }

        private FragmentDeviceCompatibility injectFragmentDeviceCompatibility2(FragmentDeviceCompatibility instance) {
            FragmentDeviceCompatibility_MembersInjector.injectUtils(instance, new Utils());
            return instance;
        }

        private FragmentLanguageSelection injectFragmentLanguageSelection2(FragmentLanguageSelection instance) {
            FragmentLanguageSelection_MembersInjector.injectUtils(instance, new Utils());
            return instance;
        }

        private LoginFragment injectLoginFragment2(LoginFragment instance) {
            LoginFragment_MembersInjector.injectUtils(instance, new Utils());
            return instance;
        }
    }

    private static final class ViewCImpl extends MyApp_HiltComponents.ViewC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final DaggerMyApp_HiltComponents_SingletonC singletonC;
        private final ViewCImpl viewCImpl;

        private ViewCImpl(DaggerMyApp_HiltComponents_SingletonC singletonC, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, View viewParam) {
            this.viewCImpl = this;
            this.singletonC = singletonC;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
        }
    }

    private static final class ActivityCImpl extends MyApp_HiltComponents.ActivityC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final DaggerMyApp_HiltComponents_SingletonC singletonC;

        @Override // in.gov.eci.bloapp.views.activity.AboutECIActivity_GeneratedInjector
        public void injectAboutECIActivity(AboutECIActivity aboutECIActivity) {
        }

        @Override // in.gov.eci.bloapp.views.activity.AboutHonbleCommissionActivity_GeneratedInjector
        public void injectAboutHonbleCommissionActivity(AboutHonbleCommissionActivity aboutHonbleCommissionActivity) {
        }

        @Override // in.gov.eci.bloapp.views.activity.ActivityEditMyAccount_GeneratedInjector
        public void injectActivityEditMyAccount(ActivityEditMyAccount activityEditMyAccount) {
        }

        @Override // in.gov.eci.bloapp.views.activity.ActivityMyAccount_GeneratedInjector
        public void injectActivityMyAccount(ActivityMyAccount activityMyAccount) {
        }

        @Override // in.gov.eci.bloapp.views.activity.ActivityPendingProfile_GeneratedInjector
        public void injectActivityPendingProfile(ActivityPendingProfile activityPendingProfile) {
        }

        @Override // in.gov.eci.bloapp.views.activity.ActivitySendForApproval_GeneratedInjector
        public void injectActivitySendForApproval(ActivitySendForApproval activitySendForApproval) {
        }

        @Override // in.gov.eci.bloapp.views.activity.BloNotifiy_GeneratedInjector
        public void injectBloNotifiy(BloNotifiy bloNotifiy) {
        }

        @Override // in.gov.eci.bloapp.views.activity.CheckList_GeneratedInjector
        public void injectCheckList(CheckList checkList) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionTabLayoutActivity_GeneratedInjector
        public void injectDeletionObjectionTabLayoutActivity(DeletionObjectionTabLayoutActivity deletionObjectionTabLayoutActivity) {
        }

        @Override // in.gov.eci.bloapp.views.activity.DseActivity_GeneratedInjector
        public void injectDseActivity(DseActivity dseActivity) {
        }

        @Override // in.gov.eci.bloapp.views.activity.DseForm7Activity_GeneratedInjector
        public void injectDseForm7Activity(DseForm7Activity dseForm7Activity) {
        }

        @Override // in.gov.eci.bloapp.views.activity.ElectorsListActivity_GeneratedInjector
        public void injectElectorsListActivity(ElectorsListActivity electorsListActivity) {
        }

        @Override // in.gov.eci.bloapp.views.activity.Housetohouse_GeneratedInjector
        public void injectHousetohouse(Housetohouse housetohouse) {
        }

        @Override // in.gov.eci.bloapp.views.activity.LoginActivity_GeneratedInjector
        public void injectLoginActivity(LoginActivity loginActivity) {
        }

        @Override // in.gov.eci.bloapp.views.activity.MainActivity_GeneratedInjector
        public void injectMainActivity(MainActivity mainActivity) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.voterforms.migration.PreviewActivity_GeneratedInjector
        public void injectPreviewActivity(PreviewActivity previewActivity) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity_GeneratedInjector
        public void injectPreviewForm7Activity(PreviewForm7Activity previewForm7Activity) {
        }

        @Override // in.gov.eci.bloapp.views.activity.PseActivity_GeneratedInjector
        public void injectPseActivity(PseActivity pseActivity) {
        }

        @Override // in.gov.eci.bloapp.views.fragments.checklist.VerifiedSearchListActivity_GeneratedInjector
        public void injectVerifiedSearchListActivity(VerifiedSearchListActivity verifiedSearchListActivity) {
        }

        @Override // in.gov.eci.bloapp.views.activity.VoterForms_GeneratedInjector
        public void injectVoterForms(VoterForms voterForms) {
        }

        @Override // in.gov.eci.bloapp.views.activity.facility_GeneratedInjector
        public void injectfacility(facility facility) {
        }

        @Override // in.gov.eci.bloapp.views.activity.trackStatus_GeneratedInjector
        public void injecttrackStatus(trackStatus trackStatus) {
        }

        private ActivityCImpl(DaggerMyApp_HiltComponents_SingletonC singletonC, ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
            this.activityCImpl = this;
            this.singletonC = singletonC;
            this.activityRetainedCImpl = activityRetainedCImpl;
        }

        @Override // dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories.ActivityEntryPoint
        public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
            return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(ApplicationContextModule_ProvideApplicationFactory.provideApplication(this.singletonC.applicationContextModule), getViewModelKeys(), new ViewModelCBuilder(this.activityRetainedCImpl));
        }

        @Override // dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.ActivityCreatorEntryPoint
        public Set<String> getViewModelKeys() {
            return ImmutableSet.of(AadharAuthViewModel_HiltModules_KeyModule_ProvideFactory.provide(), AllApplicatonViewModel_HiltModules_KeyModule_ProvideFactory.provide(), BloNotificationViewModel_HiltModules_KeyModule_ProvideFactory.provide(), CheckListViewModel_HiltModules_KeyModule_ProvideFactory.provide(), DeletionObjectionViewModel_HiltModules_KeyModule_ProvideFactory.provide(), DeviceCompatibilityViewModel_HiltModules_KeyModule_ProvideFactory.provide(), new String[]{DraftinformsViewModel_HiltModules_KeyModule_ProvideFactory.provide(), ElectorsListViewModel_HiltModules_KeyModule_ProvideFactory.provide(), FacilitiesViewModel_HiltModules_KeyModule_ProvideFactory.provide(), FormsViewModel_HiltModules_KeyModule_ProvideFactory.provide(), LoginViewModel_HiltModules_KeyModule_ProvideFactory.provide(), MainActivityViewModel_HiltModules_KeyModule_ProvideFactory.provide(), MigrationViewModel_HiltModules_KeyModule_ProvideFactory.provide(), MyDetailsViewModel_HiltModules_KeyModule_ProvideFactory.provide(), NewVoterViewModel_HiltModules_KeyModule_ProvideFactory.provide(), OverseasDetailViewModel_HiltModules_KeyModule_ProvideFactory.provide(), PreviewEpicViewModel_HiltModules_KeyModule_ProvideFactory.provide(), PreviewViewModel_HiltModules_KeyModule_ProvideFactory.provide(), PseViewModel_HiltModules_KeyModule_ProvideFactory.provide()});
        }

        @Override // dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.ActivityCreatorEntryPoint
        public ViewModelComponentBuilder getViewModelComponentBuilder() {
            return new ViewModelCBuilder(this.activityRetainedCImpl);
        }

        @Override // dagger.hilt.android.internal.managers.FragmentComponentManager.FragmentComponentBuilderEntryPoint
        public FragmentComponentBuilder fragmentComponentBuilder() {
            return new FragmentCBuilder(this.activityRetainedCImpl, this.activityCImpl);
        }

        @Override // dagger.hilt.android.internal.managers.ViewComponentManager.ViewComponentBuilderEntryPoint
        public ViewComponentBuilder viewComponentBuilder() {
            return new ViewCBuilder(this.activityRetainedCImpl, this.activityCImpl);
        }
    }

    private static final class ViewModelCImpl extends MyApp_HiltComponents.ViewModelC {
        private Provider<AadharAuthViewModel> aadharAuthViewModelProvider;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private Provider<AllApplicatonViewModel> allApplicatonViewModelProvider;
        private Provider<BloNotificationViewModel> bloNotificationViewModelProvider;
        private Provider<CheckListViewModel> checkListViewModelProvider;
        private Provider<DeletionObjectionViewModel> deletionObjectionViewModelProvider;
        private Provider<DeviceCompatibilityViewModel> deviceCompatibilityViewModelProvider;
        private Provider<DraftinformsViewModel> draftinformsViewModelProvider;
        private Provider<ElectorsListViewModel> electorsListViewModelProvider;
        private Provider<FacilitiesViewModel> facilitiesViewModelProvider;
        private Provider<FormsViewModel> formsViewModelProvider;
        private Provider<LoginViewModel> loginViewModelProvider;
        private Provider<MainActivityViewModel> mainActivityViewModelProvider;
        private Provider<MigrationViewModel> migrationViewModelProvider;
        private Provider<MyDetailsViewModel> myDetailsViewModelProvider;
        private Provider<NewVoterViewModel> newVoterViewModelProvider;
        private Provider<OverseasDetailViewModel> overseasDetailViewModelProvider;
        private Provider<PreviewEpicViewModel> previewEpicViewModelProvider;
        private Provider<PreviewViewModel> previewViewModelProvider;
        private Provider<PseViewModel> pseViewModelProvider;
        private final DaggerMyApp_HiltComponents_SingletonC singletonC;
        private final ViewModelCImpl viewModelCImpl;

        private ViewModelCImpl(DaggerMyApp_HiltComponents_SingletonC singletonC, ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam) {
            this.viewModelCImpl = this;
            this.singletonC = singletonC;
            this.activityRetainedCImpl = activityRetainedCImpl;
            initialize(savedStateHandleParam);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AadharAuthRepository aadharAuthRepository() {
            return injectAadharAuthRepository(AadharAuthRepository_Factory.newInstance((ApiInterface) this.singletonC.getApiInterfaceProvider.get()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AllApplicationRepository allApplicationRepository() {
            return injectAllApplicationRepository(AllApplicationRepository_Factory.newInstance((ApiInterface) this.singletonC.getApiInterfaceProvider.get()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BloNotificationRepo bloNotificationRepo() {
            return injectBloNotificationRepo(BloNotificationRepo_Factory.newInstance((ApiInterface) this.singletonC.getApiInterfaceProvider.get()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CheckListRepository checkListRepository() {
            return injectCheckListRepository(CheckListRepository_Factory.newInstance((ApiInterface) this.singletonC.getApiInterfaceProvider.get()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DeletionObjectionRepository deletionObjectionRepository() {
            return injectDeletionObjectionRepository(DeletionObjectionRepository_Factory.newInstance((ApiInterface) this.singletonC.getApiInterfaceProvider.get()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DeviceCompatibilityRepository deviceCompatibilityRepository() {
            return injectDeviceCompatibilityRepository(DeviceCompatibilityRepository_Factory.newInstance((ApiInterface) this.singletonC.getApiInterfaceProvider.get()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DraftRepository draftRepository() {
            return injectDraftRepository(DraftRepository_Factory.newInstance((ApiInterface) this.singletonC.getApiInterfaceProvider.get()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ElectorsListRepository electorsListRepository() {
            return new ElectorsListRepository((UserClient) this.singletonC.provideRetrofitServiceElectorsListProvider.get());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FacilitiesRepository facilitiesRepository() {
            return injectFacilitiesRepository(FacilitiesRepository_Factory.newInstance((ApiInterface) this.singletonC.getApiInterfaceProvider.get()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FormsRepo formsRepo() {
            return injectFormsRepo(FormsRepo_Factory.newInstance((ApiInterface) this.singletonC.getApiInterfaceProvider.get()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MainRepository mainRepository() {
            return injectMainRepository(MainRepository_Factory.newInstance((ApiInterface) this.singletonC.getApiInterfaceProvider.get()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MigrationRepository migrationRepository() {
            return injectMigrationRepository(MigrationRepository_Factory.newInstance((ApiInterface) this.singletonC.getApiInterfaceProvider.get()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MyDetailsRepository myDetailsRepository() {
            return injectMyDetailsRepository(MyDetailsRepository_Factory.newInstance((ApiInterface) this.singletonC.getApiInterfaceProvider.get()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public NewVoterrepository newVoterrepository() {
            return injectNewVoterrepository(NewVoterrepository_Factory.newInstance((ApiInterface) this.singletonC.getApiInterfaceProvider.get()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public OverseasDetailsRepository overseasDetailsRepository() {
            return injectOverseasDetailsRepository(OverseasDetailsRepository_Factory.newInstance((ApiInterface) this.singletonC.getApiInterfaceProvider.get()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public PseRepository pseRepository() {
            return injectPseRepository(PseRepository_Factory.newInstance((ApiInterface) this.singletonC.getApiInterfaceProvider.get()));
        }

        private void initialize(final SavedStateHandle savedStateHandleParam) {
            this.aadharAuthViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 0);
            this.allApplicatonViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 1);
            this.bloNotificationViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 2);
            this.checkListViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 3);
            this.deletionObjectionViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 4);
            this.deviceCompatibilityViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 5);
            this.draftinformsViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 6);
            this.electorsListViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 7);
            this.facilitiesViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 8);
            this.formsViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 9);
            this.loginViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 10);
            this.mainActivityViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 11);
            this.migrationViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 12);
            this.myDetailsViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 13);
            this.newVoterViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 14);
            this.overseasDetailViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 15);
            this.previewEpicViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 16);
            this.previewViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 17);
            this.pseViewModelProvider = new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, this.viewModelCImpl, 18);
        }

        @Override // dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.ViewModelFactoriesEntryPoint
        public Map<String, Provider<ViewModel>> getHiltViewModelMap() {
            return ImmutableMap.builderWithExpectedSize(19).put("in.gov.eci.bloapp.viewmodel.AadharAuthViewModel", this.aadharAuthViewModelProvider).put("in.gov.eci.bloapp.viewmodel.AllApplicatonViewModel", this.allApplicatonViewModelProvider).put("in.gov.eci.bloapp.viewmodel.BloNotificationViewModel", this.bloNotificationViewModelProvider).put("in.gov.eci.bloapp.viewmodel.CheckListViewModel", this.checkListViewModelProvider).put("in.gov.eci.bloapp.viewmodel.DeletionObjectionViewModel", this.deletionObjectionViewModelProvider).put("in.gov.eci.bloapp.viewmodel.DeviceCompatibilityViewModel", this.deviceCompatibilityViewModelProvider).put("in.gov.eci.bloapp.viewmodel.DraftinformsViewModel", this.draftinformsViewModelProvider).put("in.gov.eci.bloapp.viewmodel.ElectorsListViewModel", this.electorsListViewModelProvider).put("in.gov.eci.bloapp.viewmodel.FacilitiesViewModel", this.facilitiesViewModelProvider).put("in.gov.eci.bloapp.viewmodel.FormsViewModel", this.formsViewModelProvider).put("in.gov.eci.bloapp.viewmodel.LoginViewModel", this.loginViewModelProvider).put("in.gov.eci.bloapp.viewmodel.MainActivityViewModel", this.mainActivityViewModelProvider).put("in.gov.eci.bloapp.viewmodel.MigrationViewModel", this.migrationViewModelProvider).put("in.gov.eci.bloapp.viewmodel.MyDetailsViewModel", this.myDetailsViewModelProvider).put("in.gov.eci.bloapp.viewmodel.NewVoterViewModel", this.newVoterViewModelProvider).put("in.gov.eci.bloapp.viewmodel.OverseasDetailViewModel", this.overseasDetailViewModelProvider).put("in.gov.eci.bloapp.viewmodel.PreviewEpicViewModel", this.previewEpicViewModelProvider).put("in.gov.eci.bloapp.viewmodel.PreviewViewModel", this.previewViewModelProvider).put("in.gov.eci.bloapp.viewmodel.PseViewModel", this.pseViewModelProvider).build();
        }

        private AadharAuthRepository injectAadharAuthRepository(AadharAuthRepository instance) {
            AadharAuthRepository_MembersInjector.injectDbHandler(instance, (DatabaseHelper) this.singletonC.getDatabaseProvider.get());
            AadharAuthRepository_MembersInjector.injectEciDatabase(instance, (EciDatabase) this.singletonC.provideEciDatabaseProvider.get());
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AadharAuthViewModel injectAadharAuthViewModel(AadharAuthViewModel instance) {
            AadharAuthViewModel_MembersInjector.injectApiInterface(instance, (ApiInterface) this.singletonC.getApiInterfaceProvider.get());
            return instance;
        }

        private AllApplicationRepository injectAllApplicationRepository(AllApplicationRepository instance) {
            AllApplicationRepository_MembersInjector.injectDbHandler(instance, (DatabaseHelper) this.singletonC.getDatabaseProvider.get());
            AllApplicationRepository_MembersInjector.injectEciDatabase(instance, (EciDatabase) this.singletonC.provideEciDatabaseProvider.get());
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AllApplicatonViewModel injectAllApplicatonViewModel(AllApplicatonViewModel instance) {
            AllApplicatonViewModel_MembersInjector.injectApiInterface(instance, (ApiInterface) this.singletonC.getApiInterfaceProvider.get());
            return instance;
        }

        private BloNotificationRepo injectBloNotificationRepo(BloNotificationRepo instance) {
            BloNotificationRepo_MembersInjector.injectDbHandler(instance, (DatabaseHelper) this.singletonC.getDatabaseProvider.get());
            return instance;
        }

        private CheckListRepository injectCheckListRepository(CheckListRepository instance) {
            CheckListRepository_MembersInjector.injectDbHandler(instance, (DatabaseHelper) this.singletonC.getDatabaseProvider.get());
            CheckListRepository_MembersInjector.injectUtils(instance, new Utils());
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CheckListViewModel injectCheckListViewModel(CheckListViewModel instance) {
            CheckListViewModel_MembersInjector.injectApiInterface(instance, (ApiInterface) this.singletonC.getApiInterfaceProvider.get());
            return instance;
        }

        private DeletionObjectionRepository injectDeletionObjectionRepository(DeletionObjectionRepository instance) {
            DeletionObjectionRepository_MembersInjector.injectDbHandler(instance, (DatabaseHelper) this.singletonC.getDatabaseProvider.get());
            DeletionObjectionRepository_MembersInjector.injectEciDatabase(instance, (EciDatabase) this.singletonC.provideEciDatabaseProvider.get());
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DeletionObjectionViewModel injectDeletionObjectionViewModel(DeletionObjectionViewModel instance) {
            DeletionObjectionViewModel_MembersInjector.injectApiInterface(instance, (ApiInterface) this.singletonC.getApiInterfaceProvider.get());
            return instance;
        }

        private DeviceCompatibilityRepository injectDeviceCompatibilityRepository(DeviceCompatibilityRepository instance) {
            DeviceCompatibilityRepository_MembersInjector.injectDbHandler(instance, (DatabaseHelper) this.singletonC.getDatabaseProvider.get());
            DeviceCompatibilityRepository_MembersInjector.injectEciDatabase(instance, (EciDatabase) this.singletonC.provideEciDatabaseProvider.get());
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DeviceCompatibilityViewModel injectDeviceCompatibilityViewModel(DeviceCompatibilityViewModel instance) {
            DeviceCompatibilityViewModel_MembersInjector.injectApiInterface(instance, (ApiInterface) this.singletonC.getApiInterfaceProvider.get());
            return instance;
        }

        private DraftRepository injectDraftRepository(DraftRepository instance) {
            DraftRepository_MembersInjector.injectDbHandler(instance, (DatabaseHelper) this.singletonC.getDatabaseProvider.get());
            DraftRepository_MembersInjector.injectEciDatabase(instance, (EciDatabase) this.singletonC.provideEciDatabaseProvider.get());
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DraftinformsViewModel injectDraftinformsViewModel(DraftinformsViewModel instance) {
            DraftinformsViewModel_MembersInjector.injectApiInterface(instance, (ApiInterface) this.singletonC.getApiInterfaceProvider.get());
            return instance;
        }

        private FacilitiesRepository injectFacilitiesRepository(FacilitiesRepository instance) {
            FacilitiesRepository_MembersInjector.injectDbHandler(instance, (DatabaseHelper) this.singletonC.getDatabaseProvider.get());
            FacilitiesRepository_MembersInjector.injectEciDatabase(instance, (EciDatabase) this.singletonC.provideEciDatabaseProvider.get());
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FacilitiesViewModel injectFacilitiesViewModel(FacilitiesViewModel instance) {
            FacilitiesViewModel_MembersInjector.injectApiInterface(instance, (ApiInterface) this.singletonC.getApiInterfaceProvider.get());
            return instance;
        }

        private FormsRepo injectFormsRepo(FormsRepo instance) {
            FormsRepo_MembersInjector.injectDbHandler(instance, (DatabaseHelper) this.singletonC.getDatabaseProvider.get());
            FormsRepo_MembersInjector.injectEciDatabase(instance, (EciDatabase) this.singletonC.provideEciDatabaseProvider.get());
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FormsViewModel injectFormsViewModel(FormsViewModel instance) {
            FormsViewModel_MembersInjector.injectApiInterface(instance, (ApiInterface) this.singletonC.getApiInterfaceProvider.get());
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public LoginViewModel injectLoginViewModel(LoginViewModel instance) {
            LoginViewModel_MembersInjector.injectApiInterface(instance, (ApiInterface) this.singletonC.getApiInterfaceProvider.get());
            return instance;
        }

        private MainRepository injectMainRepository(MainRepository instance) {
            MainRepository_MembersInjector.injectDbHandler(instance, (DatabaseHelper) this.singletonC.getDatabaseProvider.get());
            MainRepository_MembersInjector.injectEciDatabase(instance, (EciDatabase) this.singletonC.provideEciDatabaseProvider.get());
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MainActivityViewModel injectMainActivityViewModel(MainActivityViewModel instance) {
            MainActivityViewModel_MembersInjector.injectApiInterface(instance, (ApiInterface) this.singletonC.getApiInterfaceProvider.get());
            return instance;
        }

        private MigrationRepository injectMigrationRepository(MigrationRepository instance) {
            MigrationRepository_MembersInjector.injectDbHandler(instance, (DatabaseHelper) this.singletonC.getDatabaseProvider.get());
            MigrationRepository_MembersInjector.injectEciDatabase(instance, (EciDatabase) this.singletonC.provideEciDatabaseProvider.get());
            return instance;
        }

        private MyDetailsRepository injectMyDetailsRepository(MyDetailsRepository instance) {
            MyDetailsRepository_MembersInjector.injectDbHandler(instance, (DatabaseHelper) this.singletonC.getDatabaseProvider.get());
            MyDetailsRepository_MembersInjector.injectEciDatabase(instance, (EciDatabase) this.singletonC.provideEciDatabaseProvider.get());
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MyDetailsViewModel injectMyDetailsViewModel(MyDetailsViewModel instance) {
            MyDetailsViewModel_MembersInjector.injectApiInterface(instance, (ApiInterface) this.singletonC.getApiInterfaceProvider.get());
            return instance;
        }

        private NewVoterrepository injectNewVoterrepository(NewVoterrepository instance) {
            NewVoterrepository_MembersInjector.injectDbHandler(instance, (DatabaseHelper) this.singletonC.getDatabaseProvider.get());
            NewVoterrepository_MembersInjector.injectEciDatabase(instance, (EciDatabase) this.singletonC.provideEciDatabaseProvider.get());
            return instance;
        }

        private OverseasDetailsRepository injectOverseasDetailsRepository(OverseasDetailsRepository instance) {
            OverseasDetailsRepository_MembersInjector.injectDbHandler(instance, (DatabaseHelper) this.singletonC.getDatabaseProvider.get());
            OverseasDetailsRepository_MembersInjector.injectEciDatabase(instance, (EciDatabase) this.singletonC.provideEciDatabaseProvider.get());
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public PreviewEpicViewModel injectPreviewEpicViewModel(PreviewEpicViewModel instance) {
            PreviewEpicViewModel_MembersInjector.injectApiInterface(instance, (ApiInterface) this.singletonC.getApiInterfaceProvider.get());
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public PreviewViewModel injectPreviewViewModel(PreviewViewModel instance) {
            PreviewViewModel_MembersInjector.injectApiInterface(instance, (ApiInterface) this.singletonC.getApiInterfaceProvider.get());
            return instance;
        }

        private PseRepository injectPseRepository(PseRepository instance) {
            PseRepository_MembersInjector.injectDbHandler(instance, (DatabaseHelper) this.singletonC.getDatabaseProvider.get());
            PseRepository_MembersInjector.injectEciDatabase(instance, (EciDatabase) this.singletonC.provideEciDatabaseProvider.get());
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public PseViewModel injectPseViewModel(PseViewModel instance) {
            PseViewModel_MembersInjector.injectApiInterface(instance, (ApiInterface) this.singletonC.getApiInterfaceProvider.get());
            return instance;
        }

        private static final class SwitchingProvider<T> implements Provider<T> {
            private final ActivityRetainedCImpl activityRetainedCImpl;
            private final int id;
            private final DaggerMyApp_HiltComponents_SingletonC singletonC;
            private final ViewModelCImpl viewModelCImpl;

            SwitchingProvider(DaggerMyApp_HiltComponents_SingletonC singletonC, ActivityRetainedCImpl activityRetainedCImpl, ViewModelCImpl viewModelCImpl, int id) {
                this.singletonC = singletonC;
                this.activityRetainedCImpl = activityRetainedCImpl;
                this.viewModelCImpl = viewModelCImpl;
                this.id = id;
            }

            @Override // javax.inject.Provider
            public T get() {
                switch (this.id) {
                    case 0:
                        ViewModelCImpl viewModelCImpl = this.viewModelCImpl;
                        return (T) viewModelCImpl.injectAadharAuthViewModel(AadharAuthViewModel_Factory.newInstance(viewModelCImpl.aadharAuthRepository()));
                    case 1:
                        ViewModelCImpl viewModelCImpl2 = this.viewModelCImpl;
                        return (T) viewModelCImpl2.injectAllApplicatonViewModel(AllApplicatonViewModel_Factory.newInstance(viewModelCImpl2.allApplicationRepository()));
                    case 2:
                        return (T) new BloNotificationViewModel(this.viewModelCImpl.bloNotificationRepo());
                    case 3:
                        ViewModelCImpl viewModelCImpl3 = this.viewModelCImpl;
                        return (T) viewModelCImpl3.injectCheckListViewModel(CheckListViewModel_Factory.newInstance(viewModelCImpl3.checkListRepository()));
                    case 4:
                        ViewModelCImpl viewModelCImpl4 = this.viewModelCImpl;
                        return (T) viewModelCImpl4.injectDeletionObjectionViewModel(DeletionObjectionViewModel_Factory.newInstance(viewModelCImpl4.deletionObjectionRepository()));
                    case 5:
                        ViewModelCImpl viewModelCImpl5 = this.viewModelCImpl;
                        return (T) viewModelCImpl5.injectDeviceCompatibilityViewModel(DeviceCompatibilityViewModel_Factory.newInstance(viewModelCImpl5.deviceCompatibilityRepository()));
                    case 6:
                        ViewModelCImpl viewModelCImpl6 = this.viewModelCImpl;
                        return (T) viewModelCImpl6.injectDraftinformsViewModel(DraftinformsViewModel_Factory.newInstance(viewModelCImpl6.draftRepository()));
                    case 7:
                        return (T) new ElectorsListViewModel(this.viewModelCImpl.electorsListRepository());
                    case 8:
                        ViewModelCImpl viewModelCImpl7 = this.viewModelCImpl;
                        return (T) viewModelCImpl7.injectFacilitiesViewModel(FacilitiesViewModel_Factory.newInstance(viewModelCImpl7.facilitiesRepository()));
                    case 9:
                        ViewModelCImpl viewModelCImpl8 = this.viewModelCImpl;
                        return (T) viewModelCImpl8.injectFormsViewModel(FormsViewModel_Factory.newInstance(viewModelCImpl8.formsRepo()));
                    case 10:
                        ViewModelCImpl viewModelCImpl9 = this.viewModelCImpl;
                        return (T) viewModelCImpl9.injectLoginViewModel(LoginViewModel_Factory.newInstance(viewModelCImpl9.formsRepo()));
                    case 11:
                        ViewModelCImpl viewModelCImpl10 = this.viewModelCImpl;
                        return (T) viewModelCImpl10.injectMainActivityViewModel(MainActivityViewModel_Factory.newInstance(viewModelCImpl10.mainRepository()));
                    case 12:
                        return (T) new MigrationViewModel(this.viewModelCImpl.migrationRepository());
                    case 13:
                        ViewModelCImpl viewModelCImpl11 = this.viewModelCImpl;
                        return (T) viewModelCImpl11.injectMyDetailsViewModel(MyDetailsViewModel_Factory.newInstance(viewModelCImpl11.myDetailsRepository()));
                    case 14:
                        return (T) new NewVoterViewModel(this.viewModelCImpl.newVoterrepository());
                    case 15:
                        return (T) new OverseasDetailViewModel(this.viewModelCImpl.overseasDetailsRepository());
                    case 16:
                        ViewModelCImpl viewModelCImpl12 = this.viewModelCImpl;
                        return (T) viewModelCImpl12.injectPreviewEpicViewModel(PreviewEpicViewModel_Factory.newInstance(viewModelCImpl12.migrationRepository()));
                    case 17:
                        ViewModelCImpl viewModelCImpl13 = this.viewModelCImpl;
                        return (T) viewModelCImpl13.injectPreviewViewModel(PreviewViewModel_Factory.newInstance(viewModelCImpl13.migrationRepository()));
                    case 18:
                        ViewModelCImpl viewModelCImpl14 = this.viewModelCImpl;
                        return (T) viewModelCImpl14.injectPseViewModel(PseViewModel_Factory.newInstance(viewModelCImpl14.pseRepository()));
                    default:
                        throw new AssertionError(this.id);
                }
            }
        }
    }

    private static final class ActivityRetainedCImpl extends MyApp_HiltComponents.ActivityRetainedC {
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private Provider lifecycleProvider;
        private final DaggerMyApp_HiltComponents_SingletonC singletonC;

        private ActivityRetainedCImpl(DaggerMyApp_HiltComponents_SingletonC singletonC) {
            this.activityRetainedCImpl = this;
            this.singletonC = singletonC;
            initialize();
        }

        private void initialize() {
            this.lifecycleProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonC, this.activityRetainedCImpl, 0));
        }

        @Override // dagger.hilt.android.internal.managers.ActivityComponentManager.ActivityComponentBuilderEntryPoint
        public ActivityComponentBuilder activityComponentBuilder() {
            return new ActivityCBuilder(this.activityRetainedCImpl);
        }

        @Override // dagger.hilt.android.internal.managers.ActivityRetainedComponentManager.ActivityRetainedLifecycleEntryPoint
        public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
            return (ActivityRetainedLifecycle) this.lifecycleProvider.get();
        }

        private static final class SwitchingProvider<T> implements Provider<T> {
            private final ActivityRetainedCImpl activityRetainedCImpl;
            private final int id;
            private final DaggerMyApp_HiltComponents_SingletonC singletonC;

            SwitchingProvider(DaggerMyApp_HiltComponents_SingletonC singletonC, ActivityRetainedCImpl activityRetainedCImpl, int id) {
                this.singletonC = singletonC;
                this.activityRetainedCImpl = activityRetainedCImpl;
                this.id = id;
            }

            @Override // javax.inject.Provider
            public T get() {
                if (this.id == 0) {
                    return (T) ActivityRetainedComponentManager_Lifecycle_Factory.newInstance();
                }
                throw new AssertionError(this.id);
            }
        }
    }

    private static final class ServiceCImpl extends MyApp_HiltComponents.ServiceC {
        private final ServiceCImpl serviceCImpl;
        private final DaggerMyApp_HiltComponents_SingletonC singletonC;

        private ServiceCImpl(DaggerMyApp_HiltComponents_SingletonC singletonC, Service serviceParam) {
            this.serviceCImpl = this;
            this.singletonC = singletonC;
        }
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
        private final int id;
        private final DaggerMyApp_HiltComponents_SingletonC singletonC;

        SwitchingProvider(DaggerMyApp_HiltComponents_SingletonC singletonC, int id) {
            this.singletonC = singletonC;
            this.id = id;
        }

        @Override // javax.inject.Provider
        public T get() {
            switch (this.id) {
                case 0:
                    return (T) AppModule_GetApiInterfaceFactory.getApiInterface(this.singletonC.appModule, (Retrofit) this.singletonC.getApiClientProvider.get());
                case 1:
                    return (T) AppModule_GetApiClientFactory.getApiClient(this.singletonC.appModule, ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonC.applicationContextModule));
                case 2:
                    return (T) AppModule_GetDatabaseFactory.getDatabase(this.singletonC.appModule, ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonC.applicationContextModule));
                case 3:
                    return (T) AppModule_ProvideEciDatabaseFactory.provideEciDatabase(this.singletonC.appModule, ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonC.applicationContextModule));
                case 4:
                    return (T) ElectoralListModule_ProvideRetrofitServiceElectorsListFactory.provideRetrofitServiceElectorsList(this.singletonC.electoralListModule, (Retrofit) this.singletonC.provideRetrofitElectorsListProvider.get());
                case 5:
                    return (T) ElectoralListModule_ProvideRetrofitElectorsListFactory.provideRetrofitElectorsList(this.singletonC.electoralListModule, (OkHttpClient) this.singletonC.provideHttpClientProvider.get(), (GsonConverterFactory) this.singletonC.provideConverterFactoryProvider.get());
                case 6:
                    return (T) ElectoralListModule_ProvideHttpClientFactory.provideHttpClient(this.singletonC.electoralListModule, (HttpLoggingInterceptor) this.singletonC.provideHttpLoggingInterceptorProvider.get());
                case 7:
                    return (T) ElectoralListModule_ProvideHttpLoggingInterceptorFactory.provideHttpLoggingInterceptor(this.singletonC.electoralListModule);
                case 8:
                    return (T) ElectoralListModule_ProvideConverterFactoryFactory.provideConverterFactory(this.singletonC.electoralListModule);
                default:
                    throw new AssertionError(this.id);
            }
        }
    }
}
