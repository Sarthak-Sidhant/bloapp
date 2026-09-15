package in.gov.eci.bloapp.views.fragments.blopatrika;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MyCallback;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.databinding.BloFragmentBloPatrikaBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class BloPatrika extends BaseFragment {
    BloFragmentBloPatrikaBinding binding;
    byte[] decodedString;
    FileOutputStream fos;
    String refreshToken;
    String sessionTokenText = "Session token expired please Login";
    float x1 = 1.0f;
    float y1 = 1.0f;
    String token = "";
    private final CommomUtility commonUtilClass = new CommomUtility();
    String prod = "S05/Form/30/Mar_2023_09412f55-b7ea-4871-aaa8-0cb64b194b9a_BLOPATRIKA.pdf";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        BloFragmentBloPatrikaBinding bloFragmentBloPatrikaBindingInflate = BloFragmentBloPatrikaBinding.inflate(getLayoutInflater());
        this.binding = bloFragmentBloPatrikaBindingInflate;
        bloFragmentBloPatrikaBindingInflate.progressCircular.setVisibility(0);
        this.token = SharedPref.getInstance(requireContext()).getToken();
        if (Boolean.TRUE.equals(Boolean.valueOf(isNetworkAvailable(requireContext())))) {
            getpatrika();
        } else {
            Toast.makeText(requireContext(), "Please check network", 1).show();
        }
        this.binding.downloadPatrika.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.blopatrika.BloPatrika$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        this.binding.floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.blopatrika.BloPatrika$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        this.binding.floatingActionButton4.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.blopatrika.BloPatrika$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$2(view);
            }
        });
        this.binding.floatingActionButton5.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.blopatrika.BloPatrika$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$3(view);
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        downloadFiles1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        float scaleX = this.binding.pdfView.getScaleX();
        float scaleY = this.binding.pdfView.getScaleY();
        if (scaleX < 6.0f) {
            this.binding.pdfView.setScaleX(scaleX + 0.3f);
            this.binding.pdfView.setScaleY(scaleY + 0.3f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(View view) {
        float scaleX = this.binding.pdfView.getScaleX();
        float scaleY = this.binding.pdfView.getScaleY();
        double d = scaleX;
        if (d > 0.4d) {
            this.binding.pdfView.setScaleX((float) (d - 0.3d));
            this.binding.pdfView.setScaleY((float) (((double) scaleY) - 0.3d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(View view) {
        if (this.x1 == 1.0f) {
            this.x1 = 2.0f;
            this.y1 = 2.0f;
            this.binding.pdfView.setScaleX(this.x1);
            this.binding.pdfView.setScaleY(this.y1);
            this.binding.floatingActionButton5.setImageResource(R.drawable.blo_baseline_zoom_in_map_black_24dp);
            return;
        }
        this.x1 = 1.0f;
        this.y1 = 1.0f;
        this.binding.pdfView.setScaleX(this.x1);
        this.binding.pdfView.setScaleY(this.y1);
        this.binding.floatingActionButton5.setImageResource(R.drawable.blo_baseline_zoom_out_map_black_24dp);
    }

    private void getpatrika() {
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.prod, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.blopatrika.BloPatrika$$ExternalSyntheticLambda6
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i, String str) {
                this.f$0.lambda$getpatrika$6(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getpatrika$6(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.blopatrika.BloPatrika$$ExternalSyntheticLambda0
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$getpatrika$5(i2, str2, str3);
                }
            });
            return;
        }
        this.decodedString = Base64.decode(str, 0);
        this.binding.pdfView.fromBytes(this.decodedString).load();
        this.binding.progressCircular.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getpatrika$5(int i, String str, String str2) {
        Logger.d("getRefreshToken DBA ", i + " " + str + " " + str2);
        if (i == 401 || i == 400) {
            Logger.d("getRefreshToken DBA---1 ", i + " " + str + " " + str2);
            this.commonUtilClass.showMessageOK(getContext(), "Session Expired. Please Login again..", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.blopatrika.BloPatrika$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$getpatrika$4(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        Logger.d("getRefreshToken DBA----2 ", i + " " + str + " " + str2);
        getpatrika();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getpatrika$4(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    void downloadFiles1() {
        try {
            try {
                try {
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS + "/BLOAPP"), "");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String str = file.getAbsolutePath() + "/BLO_Patrika.PDF";
                    byte[] bArr = this.decodedString;
                    FileOutputStream fileOutputStream = new FileOutputStream(str, false);
                    this.fos = fileOutputStream;
                    fileOutputStream.write(bArr);
                    this.fos.flush();
                    Toast.makeText(requireContext(), "File downloaded", 0).show();
                    Logger.e("TAG", "Failed to generate pdf from base64: ${e.localizedMessage}");
                    this.fos.close();
                } catch (Exception e) {
                    Logger.e("TAG", e.getMessage());
                    Logger.e("TAG", "Failed to generate pdf from base64: ${e.localizedMessage}");
                    this.fos.close();
                }
            } catch (Exception e2) {
                Logger.e("TAG", e2.getMessage());
            }
        } catch (Throwable th) {
            Logger.e("TAG", "Failed to generate pdf from base64: ${e.localizedMessage}");
            try {
                this.fos.close();
            } catch (Exception e3) {
                Logger.e("TAG", e3.getMessage());
            }
            throw th;
        }
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.main, fragment, "Applicant Details");
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commit();
    }
}
