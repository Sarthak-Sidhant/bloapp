package in.gov.eci.bloapp.views.activity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloActivitySplashBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.MethodInterface;
import in.gov.eci.bloapp.utils.RootDetector;
import in.gov.eci.bloapp.utils.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class SplashActivity extends BaseActivity {
    BloActivitySplashBinding binding;
    private final CommomUtility commomUtility = new CommomUtility();
    FirebaseRemoteConfig mFirebaseRemoteConfig;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BloActivitySplashBinding bloActivitySplashBindingInflate = BloActivitySplashBinding.inflate(getLayoutInflater());
        this.binding = bloActivitySplashBindingInflate;
        setContentView((View) bloActivitySplashBindingInflate.getRoot());
        try {
            FirebaseApp.initializeApp(this);
        } catch (Exception e) {
            Logger.d("Firebaseerror", e.toString());
        }
        new Handler().postDelayed(new AnonymousClass1(), 2000L);
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.SplashActivity$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RootDetector.isDeviceRooted(SplashActivity.this)) {
                SplashActivity.this.commomUtility.showMessageOK(SplashActivity.this, "Your device is rooted. So can not move further.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.SplashActivity$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$run$0(dialogInterface, i);
                    }
                });
            } else if (SplashActivity.isNetworkAvailable(SplashActivity.this)) {
                SplashActivity.this.init();
            } else {
                SplashActivity.this.startActivity(new Intent((Context) SplashActivity.this, (Class<?>) LoginActivity.class));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(DialogInterface dialogInterface, int i) {
            SplashActivity.this.finish();
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.SplashActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.getAppInfo();
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void getAppInfo() {
        this.mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        this.mFirebaseRemoteConfig.setConfigSettingsAsync(new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(3600L).build());
        this.mFirebaseRemoteConfig.fetchAndActivate().addOnCompleteListener(this, new OnCompleteListener() { // from class: in.gov.eci.bloapp.views.activity.SplashActivity$$ExternalSyntheticLambda0
            public final void onComplete(Task task) {
                this.f$0.lambda$getAppInfo$0(task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAppInfo$0(Task task) {
        checkCurrentVersion();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void checkCurrentVersion() {
        try {
            String string = this.mFirebaseRemoteConfig.getString("version_code_bloapp");
            Logger.d("version code", string);
            if (!string.isEmpty()) {
                Logger.d("currentversioncode", "233");
                if (Integer.parseInt(string) > 233) {
                    Utils.createSimpleDialogOneBtn(this, String.format(getResources().getString(R.string.blo_play_store_update_message), getResources().getString(R.string.blo_app_name)), getResources().getString(R.string.blo_google_play_store), new MethodInterface() { // from class: in.gov.eci.bloapp.views.activity.SplashActivity$$ExternalSyntheticLambda2
                        @Override // in.gov.eci.bloapp.utils.MethodInterface
                        public final void execute() {
                            this.f$0.lambda$checkCurrentVersion$1();
                        }
                    });
                } else {
                    startActivity(new Intent((Context) this, (Class<?>) LoginActivity.class));
                    finish();
                }
            } else {
                finish();
            }
        } catch (Exception e) {
            Logger.d("Splash", e.getMessage());
            startActivity(new Intent((Context) this, (Class<?>) LoginActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkCurrentVersion$1() {
        String packageName = getPackageName();
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
        }
        finish();
    }

    public static boolean isDeviceRooted() {
        return checkRootMethod1() || checkRootMethod2() || checkRootMethod3();
    }

    private static boolean checkRootMethod1() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    private static boolean checkRootMethod2() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i = 0; i < 10; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkRootMethod3() {
        Process processExec = null;
        try {
            processExec = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            return new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine() != null;
        } catch (Exception unused) {
            return false;
        } finally {
            if (processExec != null) {
                processExec.destroy();
            }
        }
    }
}
