package in.gov.eci.bloapp.views.fragments;

import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class BaseFragment extends Fragment {
    protected long filesize;
    private Dialog progressDialog;
    protected String saveImageFileName;
    String functionNameForLogBaseActivity = "";
    String logTagBaseActivity = "BaseActivity";
    String garudaTextBaseActivity = "GARUDA";
    String imageTextBaseActivity = "image";
    String pdfTextBaseActivity = ".pdf";
    String jpgTextBaseActivity = ".jpg";
    String fileNameTextBaseActivity = "fileName";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.progressDialog == null) {
            this.progressDialog = Utils.showProgressDialog(requireActivity());
        }
    }

    protected void showProgressVisible() {
        Dialog dialog = this.progressDialog;
        if (dialog != null) {
            dialog.show();
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
    }

    protected void showProgressInVisible() {
        Dialog dialog = this.progressDialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.progressDialog.dismiss();
    }

    public Uri getSaveImagePath(String fileNameBase64, String documentTypeSelected) throws IOException {
        this.functionNameForLogBaseActivity = "getSaveImagePath ";
        Logger.d(this.logTagBaseActivity, "getSaveImagePath ");
        String str = new SimpleDateFormat("ddMMyyyyHHMMSS").format(new Date());
        File file = new File(requireContext().getExternalFilesDir(null) + this.garudaTextBaseActivity);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (documentTypeSelected.equals(this.imageTextBaseActivity)) {
            this.saveImageFileName = "img_" + str + this.jpgTextBaseActivity;
            Logger.d(this.logTagBaseActivity, this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
        } else if (documentTypeSelected.equals(this.pdfTextBaseActivity)) {
            this.saveImageFileName = "pdf_document" + str + this.pdfTextBaseActivity;
            Logger.d(this.logTagBaseActivity, this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
        }
        File file2 = new File(file, this.saveImageFileName);
        byte[] bArrDecode = Base64.decode(fileNameBase64, 0);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2, false);
            try {
                fileOutputStream.write(bArrDecode);
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            Logger.d(this.logTagBaseActivity, this.functionNameForLogBaseActivity + e.getMessage());
        }
        this.filesize = file2.length() / 1024;
        Logger.d(this.logTagBaseActivity, "filesize " + this.filesize);
        Logger.d(this.logTagBaseActivity, this.functionNameForLogBaseActivity + "imageUri : " + FileProvider.getUriForFile(requireContext(), "in.gov.eci.bloapp.provider", file2));
        return FileProvider.getUriForFile(requireContext(), "in.gov.eci.bloapp.provider", file2);
    }
}
