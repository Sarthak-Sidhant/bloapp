package in.gov.eci.bloapp.di;

import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Subcomponent;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.android.components.ViewComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.components.ViewWithFragmentComponent;
import dagger.hilt.android.flags.FragmentGetContextFix;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_DefaultViewModelFactories_ActivityModule;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ViewModelModule;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_LifecycleModule;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.android.internal.managers.ViewComponentManager;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.HiltWrapper_ActivityModule;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedComponent;
import in.gov.eci.bloapp.viewmodel.AadharAuthViewModel_HiltModules;
import in.gov.eci.bloapp.viewmodel.AllApplicatonViewModel_HiltModules;
import in.gov.eci.bloapp.viewmodel.BloNotificationViewModel_HiltModules;
import in.gov.eci.bloapp.viewmodel.CheckListViewModel_HiltModules;
import in.gov.eci.bloapp.viewmodel.DeletionObjectionViewModel_HiltModules;
import in.gov.eci.bloapp.viewmodel.DeviceCompatibilityViewModel_HiltModules;
import in.gov.eci.bloapp.viewmodel.DraftinformsViewModel_HiltModules;
import in.gov.eci.bloapp.viewmodel.ElectorsListViewModel_HiltModules;
import in.gov.eci.bloapp.viewmodel.FacilitiesViewModel_HiltModules;
import in.gov.eci.bloapp.viewmodel.FormsViewModel_HiltModules;
import in.gov.eci.bloapp.viewmodel.LoginViewModel_HiltModules;
import in.gov.eci.bloapp.viewmodel.MainActivityViewModel_HiltModules;
import in.gov.eci.bloapp.viewmodel.MigrationViewModel_HiltModules;
import in.gov.eci.bloapp.viewmodel.MyDetailsViewModel_HiltModules;
import in.gov.eci.bloapp.viewmodel.NewVoterViewModel_HiltModules;
import in.gov.eci.bloapp.viewmodel.OverseasDetailViewModel_HiltModules;
import in.gov.eci.bloapp.viewmodel.PreviewEpicViewModel_HiltModules;
import in.gov.eci.bloapp.viewmodel.PreviewViewModel_HiltModules;
import in.gov.eci.bloapp.viewmodel.PseViewModel_HiltModules;
import in.gov.eci.bloapp.views.activity.AboutECIActivity_GeneratedInjector;
import in.gov.eci.bloapp.views.activity.AboutHonbleCommissionActivity_GeneratedInjector;
import in.gov.eci.bloapp.views.activity.ActivityEditMyAccount_GeneratedInjector;
import in.gov.eci.bloapp.views.activity.ActivityMyAccount_GeneratedInjector;
import in.gov.eci.bloapp.views.activity.ActivityPendingProfile_GeneratedInjector;
import in.gov.eci.bloapp.views.activity.ActivitySendForApproval_GeneratedInjector;
import in.gov.eci.bloapp.views.activity.BloNotifiy_GeneratedInjector;
import in.gov.eci.bloapp.views.activity.CheckList_GeneratedInjector;
import in.gov.eci.bloapp.views.activity.DseActivity_GeneratedInjector;
import in.gov.eci.bloapp.views.activity.ElectorsListActivity_GeneratedInjector;
import in.gov.eci.bloapp.views.activity.Housetohouse_GeneratedInjector;
import in.gov.eci.bloapp.views.activity.LoginActivity_GeneratedInjector;
import in.gov.eci.bloapp.views.activity.MainActivity_GeneratedInjector;
import in.gov.eci.bloapp.views.activity.PseActivity_GeneratedInjector;
import in.gov.eci.bloapp.views.activity.VoterForms_GeneratedInjector;
import in.gov.eci.bloapp.views.activity.facility_GeneratedInjector;
import in.gov.eci.bloapp.views.activity.trackStatus_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsForm7Fragment_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.checklist.ApplicantDetailsFragment_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.checklist.CheckListMain_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.checklist.SearchListFragment_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.checklist.TotalListFragment_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.checklist.VerifiedFragment_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.checklist.VerifiedSearchListActivity_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.checklist.form6.Form6_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.elector_data_sync.ElectorDataSyncFragment_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.facilities.Facilities_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.h2h.H2HFragment_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.h2h.HouseNumberFragment_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.home.HomeFragment_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.login.FragmentDeviceCompatibility_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.login.FragmentLanguageSelection_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.login.FragmentPartNumberSelection_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.login.LoginFragment_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.login.OTPFragment_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.my_account.MyAccount_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionTabLayoutActivity_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.PreviewForm7Activity_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Epic_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Form_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.voterforms.migration.PreviewActivity_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackRejectedFragment_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusMainFragment_GeneratedInjector;
import in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackSubmittedStatusFragment_GeneratedInjector;
import javax.inject.Singleton;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class MyApp_HiltComponents {

    @Subcomponent(modules = {HiltWrapper_ActivityModule.class, HiltWrapper_DefaultViewModelFactories_ActivityModule.class, FragmentCBuilderModule.class, ViewCBuilderModule.class})
    public static abstract class ActivityC implements ActivityComponent, DefaultViewModelFactories.ActivityEntryPoint, HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint, FragmentComponentManager.FragmentComponentBuilderEntryPoint, ViewComponentManager.ViewComponentBuilderEntryPoint, GeneratedComponent, AboutECIActivity_GeneratedInjector, AboutHonbleCommissionActivity_GeneratedInjector, ActivityEditMyAccount_GeneratedInjector, ActivityMyAccount_GeneratedInjector, ActivityPendingProfile_GeneratedInjector, ActivitySendForApproval_GeneratedInjector, BloNotifiy_GeneratedInjector, CheckList_GeneratedInjector, DseActivity_GeneratedInjector, ElectorsListActivity_GeneratedInjector, Housetohouse_GeneratedInjector, LoginActivity_GeneratedInjector, MainActivity_GeneratedInjector, PseActivity_GeneratedInjector, VoterForms_GeneratedInjector, facility_GeneratedInjector, trackStatus_GeneratedInjector, VerifiedSearchListActivity_GeneratedInjector, DeletionObjectionTabLayoutActivity_GeneratedInjector, PreviewForm7Activity_GeneratedInjector, PreviewActivity_GeneratedInjector {

        @Subcomponent.Builder
        interface Builder extends ActivityComponentBuilder {
        }
    }

    @Module(subcomponents = {ActivityC.class})
    interface ActivityCBuilderModule {
        @Binds
        ActivityComponentBuilder bind(ActivityC.Builder builder);
    }

    @Subcomponent(modules = {AadharAuthViewModel_HiltModules.KeyModule.class, AllApplicatonViewModel_HiltModules.KeyModule.class, BloNotificationViewModel_HiltModules.KeyModule.class, CheckListViewModel_HiltModules.KeyModule.class, DeletionObjectionViewModel_HiltModules.KeyModule.class, DeviceCompatibilityViewModel_HiltModules.KeyModule.class, DraftinformsViewModel_HiltModules.KeyModule.class, ElectorsListViewModel_HiltModules.KeyModule.class, FacilitiesViewModel_HiltModules.KeyModule.class, FormsViewModel_HiltModules.KeyModule.class, HiltWrapper_ActivityRetainedComponentManager_LifecycleModule.class, LoginViewModel_HiltModules.KeyModule.class, MainActivityViewModel_HiltModules.KeyModule.class, MigrationViewModel_HiltModules.KeyModule.class, ActivityCBuilderModule.class, ViewModelCBuilderModule.class, MyDetailsViewModel_HiltModules.KeyModule.class, NewVoterViewModel_HiltModules.KeyModule.class, OverseasDetailViewModel_HiltModules.KeyModule.class, PreviewEpicViewModel_HiltModules.KeyModule.class, PreviewViewModel_HiltModules.KeyModule.class, PseViewModel_HiltModules.KeyModule.class})
    public static abstract class ActivityRetainedC implements ActivityRetainedComponent, ActivityComponentManager.ActivityComponentBuilderEntryPoint, HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ActivityRetainedComponentBuilder {
        }
    }

    @Module(subcomponents = {ActivityRetainedC.class})
    interface ActivityRetainedCBuilderModule {
        @Binds
        ActivityRetainedComponentBuilder bind(ActivityRetainedC.Builder builder);
    }

    @Subcomponent(modules = {ViewWithFragmentCBuilderModule.class})
    public static abstract class FragmentC implements FragmentComponent, DefaultViewModelFactories.FragmentEntryPoint, ViewComponentManager.ViewWithFragmentComponentBuilderEntryPoint, GeneratedComponent, ApplicantDetailsForm7Fragment_GeneratedInjector, ApplicantDetailsFragment_GeneratedInjector, CheckListMain_GeneratedInjector, SearchListFragment_GeneratedInjector, TotalListFragment_GeneratedInjector, VerifiedFragment_GeneratedInjector, Form6_GeneratedInjector, ElectorDataSyncFragment_GeneratedInjector, Facilities_GeneratedInjector, H2HFragment_GeneratedInjector, HouseNumberFragment_GeneratedInjector, HomeFragment_GeneratedInjector, FragmentDeviceCompatibility_GeneratedInjector, FragmentLanguageSelection_GeneratedInjector, FragmentPartNumberSelection_GeneratedInjector, LoginFragment_GeneratedInjector, OTPFragment_GeneratedInjector, MyAccount_GeneratedInjector, FormsInDraft_GeneratedInjector, Migration_preview_Epic_GeneratedInjector, Migration_preview_Form_GeneratedInjector, TrackRejectedFragment_GeneratedInjector, TrackStatusMainFragment_GeneratedInjector, TrackSubmittedStatusFragment_GeneratedInjector {

        @Subcomponent.Builder
        interface Builder extends FragmentComponentBuilder {
        }
    }

    @Module(subcomponents = {FragmentC.class})
    interface FragmentCBuilderModule {
        @Binds
        FragmentComponentBuilder bind(FragmentC.Builder builder);
    }

    @Subcomponent
    public static abstract class ServiceC implements ServiceComponent, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ServiceComponentBuilder {
        }
    }

    @Module(subcomponents = {ServiceC.class})
    interface ServiceCBuilderModule {
        @Binds
        ServiceComponentBuilder bind(ServiceC.Builder builder);
    }

    @Component(modules = {AppModule.class, ApplicationContextModule.class, ElectoralListModule.class, HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule.class, ActivityRetainedCBuilderModule.class, ServiceCBuilderModule.class})
    @Singleton
    public static abstract class SingletonC implements FragmentGetContextFix.FragmentGetContextFixEntryPoint, HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint, ServiceComponentManager.ServiceComponentBuilderEntryPoint, SingletonComponent, GeneratedComponent, MyApp_GeneratedInjector {
    }

    @Subcomponent
    public static abstract class ViewC implements ViewComponent, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ViewComponentBuilder {
        }
    }

    @Module(subcomponents = {ViewC.class})
    interface ViewCBuilderModule {
        @Binds
        ViewComponentBuilder bind(ViewC.Builder builder);
    }

    @Subcomponent(modules = {AadharAuthViewModel_HiltModules.BindsModule.class, AllApplicatonViewModel_HiltModules.BindsModule.class, BloNotificationViewModel_HiltModules.BindsModule.class, CheckListViewModel_HiltModules.BindsModule.class, DeletionObjectionViewModel_HiltModules.BindsModule.class, DeviceCompatibilityViewModel_HiltModules.BindsModule.class, DraftinformsViewModel_HiltModules.BindsModule.class, ElectorsListViewModel_HiltModules.BindsModule.class, FacilitiesViewModel_HiltModules.BindsModule.class, FormsViewModel_HiltModules.BindsModule.class, HiltWrapper_HiltViewModelFactory_ViewModelModule.class, LoginViewModel_HiltModules.BindsModule.class, MainActivityViewModel_HiltModules.BindsModule.class, MigrationViewModel_HiltModules.BindsModule.class, MyDetailsViewModel_HiltModules.BindsModule.class, NewVoterViewModel_HiltModules.BindsModule.class, OverseasDetailViewModel_HiltModules.BindsModule.class, PreviewEpicViewModel_HiltModules.BindsModule.class, PreviewViewModel_HiltModules.BindsModule.class, PseViewModel_HiltModules.BindsModule.class})
    public static abstract class ViewModelC implements ViewModelComponent, HiltViewModelFactory.ViewModelFactoriesEntryPoint, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ViewModelComponentBuilder {
        }
    }

    @Module(subcomponents = {ViewModelC.class})
    interface ViewModelCBuilderModule {
        @Binds
        ViewModelComponentBuilder bind(ViewModelC.Builder builder);
    }

    @Subcomponent
    public static abstract class ViewWithFragmentC implements ViewWithFragmentComponent, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ViewWithFragmentComponentBuilder {
        }
    }

    @Module(subcomponents = {ViewWithFragmentC.class})
    interface ViewWithFragmentCBuilderModule {
        @Binds
        ViewWithFragmentComponentBuilder bind(ViewWithFragmentC.Builder builder);
    }

    private MyApp_HiltComponents() {
    }
}
