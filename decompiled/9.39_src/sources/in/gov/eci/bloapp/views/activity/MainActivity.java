package in.gov.eci.bloapp.views.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloActivityMainBinding;
import in.gov.eci.bloapp.languagetransliteration.FormsMethod;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.MainActivityViewModel;
import in.gov.eci.bloapp.views.TransliterationCallback;
import in.gov.eci.bloapp.views.fragments.FormsResponse;
import in.gov.eci.bloapp.views.fragments.my_account.MyAccount;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class MainActivity extends Hilt_MainActivity implements NavigationView.OnNavigationItemSelectedListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    String asmblyNO;
    String asmblyName;
    BloActivityMainBinding binding;
    String districtName;
    DrawerLayout drawer;
    AppBarConfiguration mAppBarConfiguration;
    TextView navHeaderBOName;
    String partLang;
    String stateCode;
    String stateName;
    String token;
    ImageView toolbarButton;
    TextView toolbarTitle;
    MainActivityViewModel viewModel;
    String tag = "NAV";
    String classNameLog = "MainActivity";
    private final CommomUtility commonUtilClass = new CommomUtility();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean z = true;
        AppCompatDelegate.setDefaultNightMode(1);
        this.viewModel = (MainActivityViewModel) new ViewModelProvider(this).get(MainActivityViewModel.class);
        BloActivityMainBinding bloActivityMainBindingInflate = BloActivityMainBinding.inflate(getLayoutInflater());
        this.binding = bloActivityMainBindingInflate;
        setContentView((View) bloActivityMainBindingInflate.getRoot());
        final Toolbar toolbarFindViewById = findViewById(R.id.toolbar);
        setSupportActionBar(toolbarFindViewById);
        Logger.d("sbhdjsbfhm ", SharedPref.getInstance(this).getSectionData());
        this.drawer = findViewById(R.id.drawer_layout);
        String string = getString(R.string.blo_version_no, new Object[]{BuildConfig.VERSION_NAME});
        NavigationView navigationViewFindViewById = findViewById(R.id.nav_view);
        MenuItem menuItemFindItem = navigationViewFindViewById.getMenu().findItem(R.id.nav_log_version);
        if (menuItemFindItem != null) {
            ((TextView) menuItemFindItem.getActionView().findViewById(R.id.app_version)).setText(string);
        }
        this.mAppBarConfiguration = new AppBarConfiguration.Builder(new int[]{R.id.nav_home, R.id.nav_my_profile, R.id.nav_blo_patrika, R.id.nav_faqs, R.id.nav_about_eci, R.id.nav_ElectorData, R.id.nav_contact_us, R.id.nav_feedback, R.id.nav_share_app, R.id.nav_change_language, R.id.nav_device_compatability}).setOpenableLayout(this.drawer).build();
        NavController navControllerFindNavController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navControllerFindNavController, this.mAppBarConfiguration);
        toolbarFindViewById.post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.MainActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreate$0(toolbarFindViewById);
            }
        });
        NavigationUI.setupWithNavController(navigationViewFindViewById, navControllerFindNavController);
        this.navHeaderBOName = (TextView) navigationViewFindViewById.getHeaderView(0).findViewById(R.id.textView2);
        navControllerFindNavController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() { // from class: in.gov.eci.bloapp.views.activity.MainActivity$$ExternalSyntheticLambda1
            public final void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle) {
                this.f$0.lambda$onCreate$1(navController, navDestination, bundle);
            }
        });
        SharedPref.getInstance(this).setIsLoggedIn(true);
        navigationViewFindViewById.getMenu().findItem(R.id.nav_logout).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: in.gov.eci.bloapp.views.activity.MainActivity$$ExternalSyntheticLambda2
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.f$0.lambda$onCreate$3(menuItem);
            }
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(z) { // from class: in.gov.eci.bloapp.views.activity.MainActivity.1
            public void handleOnBackPressed() {
            }
        });
        this.token = SharedPref.getInstance(this).getToken();
        this.stateCode = SharedPref.getInstance(this).getStateCode();
        this.asmblyNO = SharedPref.getInstance(this).getAssemblyNumber();
        this.stateName = SharedPref.getInstance(this).getStateName();
        this.districtName = SharedPref.getInstance(this).getDistrictName();
        this.asmblyName = SharedPref.getInstance(this).getAssemblyName();
        String partNumberLanguageName = SharedPref.getInstance(this).getPartNumberLanguageName();
        this.partLang = partNumberLanguageName;
        if (partNumberLanguageName == null || partNumberLanguageName.trim().isEmpty()) {
            this.partLang = "en_in";
        }
        try {
            FormsMethod.translitrationForString(this, "state", this.stateName, this.partLang, "ADDRESS", new TransliterationCallback() { // from class: in.gov.eci.bloapp.views.activity.MainActivity.2
                @Override // in.gov.eci.bloapp.views.TransliterationCallback
                public void onSuccessCallBack(String transliteratedtext) throws IOException {
                    Logger.d(MainActivity.this.classNameLog, transliteratedtext);
                }
            });
        } catch (Exception e) {
            Logger.d(this.classNameLog, e.getMessage());
        }
        this.navHeaderBOName.setText(this.asmblyNO + " | " + this.asmblyName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(Toolbar toolbar) {
        if (toolbar.getNavigationIcon() != null) {
            toolbar.getNavigationIcon().setTint(ContextCompat.getColor(this, R.color.blo_white));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(NavController navController, NavDestination navDestination, Bundle bundle) {
        Logger.e(this.tag, "onDestinationChanged: " + ((Object) navDestination.getLabel()));
        Logger.d("sgdhxfb", getString(R.string.blo_nav_header_title));
        if (navDestination.getLabel().equals(getString(R.string.blo_nav_header_title))) {
            ImageView imageView = (ImageView) findViewById(R.id.toolbar_button);
            this.toolbarButton = imageView;
            imageView.setVisibility(0);
            TextView textView = (TextView) findViewById(R.id.toolbar_title);
            this.toolbarTitle = textView;
            textView.setText(navDestination.getLabel());
            return;
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.toolbar_button);
        this.toolbarButton = imageView2;
        imageView2.setVisibility(8);
        this.toolbarTitle.setVisibility(0);
        TextView textView2 = (TextView) findViewById(R.id.toolbar_title);
        this.toolbarTitle = textView2;
        textView2.setText(navDestination.getLabel());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean lambda$onCreate$3(MenuItem menuItem) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userName", SharedPref.getInstance(this).getPreferredUsername());
        map.put("id", SharedPref.getInstance(this).getSessionState());
        this.commonUtilClass.logOutApi(this, SharedPref.getInstance(this).getToken(), SharedPref.getInstance(this).getRefreshToken(), SharedPref.getInstance(this).getAtknBnd(), SharedPref.getInstance(this).getRtknBnd(), map, new FormsResponse() { // from class: in.gov.eci.bloapp.views.activity.MainActivity$$ExternalSyntheticLambda5
            @Override // in.gov.eci.bloapp.views.fragments.FormsResponse
            public final void onCallback(int i, String str) {
                this.f$0.lambda$onCreate$2(i, str);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(int i, String str) {
        if (i == 200) {
            SharedPref.getInstance(getApplicationContext()).clear();
            Logger.d("MainActivity logOutItem1 - ", String.valueOf(i));
            SharedPref.getInstance(getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(getApplicationContext()).setLocaleBool(false);
            showdialog("Success", str);
            return;
        }
        if (i == 401) {
            SharedPref.getInstance(getApplicationContext()).clear();
            Logger.d("MainActivity logOutItem2 - ", String.valueOf(i));
            SharedPref.getInstance(getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(getApplicationContext()).setLocaleBool(false);
            showdialog("Alert", "Session Expired. Please Login again..");
            return;
        }
        showdialog1("Error - " + i, str);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.nav_host_fragment), this.mAppBarConfiguration) || super.onSupportNavigateUp();
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == 2131364801) {
            startActivity(new Intent(getApplicationContext(), (Class<?>) MyAccount.class));
        }
        if (itemId == 2131364792) {
            startActivity(new Intent(getApplicationContext(), (Class<?>) MyAccount.class));
        }
        if (itemId == 2131364788) {
            startActivity(new Intent(getApplicationContext(), (Class<?>) MyAccount.class));
        }
        this.drawer.closeDrawer(8388611);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showdialog(String title, String msg) {
        new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.MainActivity$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialog$4(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showdialog$4(DialogInterface dialogInterface, int i) {
        startActivity(new Intent((Context) this, (Class<?>) LoginActivity.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showdialog1(String title, String msg) {
        new AlertDialog.Builder(this).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.MainActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    public void onDestroy() {
        super.onDestroy();
    }
}
