package in.gov.eci.bloapp.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.google.android.material.snackbar.Snackbar;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloProgressLayoutBinding;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class Utils {
    @Inject
    public Utils() {
    }

    public static boolean emailValidator(String etMail) {
        return !etMail.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(etMail).matches();
    }

    public static Dialog createSimpleDialogOneBtn(Context context, String msg, String btnLabel1, final MethodInterface method1) {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(context, R.style.blo_AlertDialogTheme).create();
        alertDialogCreate.requestWindowFeature(1);
        alertDialogCreate.setMessage(msg);
        alertDialogCreate.setTitle(context.getString(R.string.blo_update_available));
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setButton(-1, btnLabel1, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.utils.Utils$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                Utils.lambda$createSimpleDialogOneBtn$0(method1, dialogInterface, i);
            }
        });
        alertDialogCreate.show();
        return alertDialogCreate;
    }

    static /* synthetic */ void lambda$createSimpleDialogOneBtn$0(MethodInterface methodInterface, DialogInterface dialogInterface, int i) {
        if (methodInterface != null) {
            methodInterface.execute();
        }
    }

    public static boolean isPhoneValid(String contact) {
        return Pattern.compile("[0-9]{10}").matcher(contact).matches();
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenWidthWithMargin(int margins) {
        return getScreenWidth() - margins;
    }

    public static Bitmap convertFileToBitmap(Context context, String imagePath) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imagePath, options);
        int iMin = Math.min(options.outWidth / i2, options.outHeight / i);
        options.inJustDecodeBounds = false;
        options.inSampleSize = iMin;
        return BitmapFactory.decodeFile(imagePath);
    }

    public static void hideKeyboard(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus == null) {
                currentFocus = new View(activity);
            }
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        } catch (Exception e) {
            Logger.d("", e.getMessage());
        }
    }

    public static Bitmap createViewBitmap(View view) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        view.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static String getFormattedDate(String dateString, String actualFormat, String displayFormat) {
        try {
            return new SimpleDateFormat(displayFormat).format(new SimpleDateFormat(actualFormat).parse(dateString));
        } catch (Exception unused) {
            return "";
        }
    }

    public static void initializeSnackBar(Snackbar snackbar, Context context) {
        View view = snackbar.getView();
        view.setElevation(30.0f);
        view.setBackgroundColor(ContextCompat.getColor(context, android.R.color.black));
        ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(-1);
        snackbar.setActionTextColor(ContextCompat.getColor(context, android.R.color.white));
    }

    public static CircularProgressDrawable getImageProgressBar(Context context) {
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
        circularProgressDrawable.setStrokeWidth(5.0f);
        circularProgressDrawable.setCenterRadius(30.0f);
        circularProgressDrawable.start();
        return circularProgressDrawable;
    }

    public static Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(newWidth / width, newHeight / height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        bm.recycle();
        return bitmapCreateBitmap;
    }

    public static float convertDpToPixel(float dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().densityDpi / 160.0f);
    }

    public static float convertPixelsToDp(float px, Context context) {
        return px / (context.getResources().getDisplayMetrics().densityDpi / 160.0f);
    }

    public static float getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels / displayMetrics.density;
    }

    public static float getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.heightPixels / displayMetrics.density;
    }

    public void showToast(Context context, String message) {
        Toast.makeText(context, message, 0).show();
    }

    public static boolean eMailValidation(String emailstring) {
        return Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matcher(emailstring).matches();
    }

    public static boolean mobileValidation(String mobileNumber) {
        return Pattern.compile("[1-9]{10}").matcher(mobileNumber).matches();
    }

    public void showMessageYesNoBoth(Context ctx, String message, DialogInterface.OnClickListener okListener) {
        new androidx.appcompat.app.AlertDialog.Builder(ctx).setMessage(message).setPositiveButton("Yes", okListener).setNegativeButton("No", okListener).setIcon(android.R.drawable.ic_dialog_alert).create().show();
    }

    public void showMessageOK(Context ctx, String title, String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(ctx).setTitle(title).setMessage(message).setNeutralButton("OK", okListener).setIcon(android.R.drawable.ic_dialog_alert).create().show();
    }

    public static Dialog showProgressDialog(Context context) {
        BloProgressLayoutBinding bloProgressLayoutBindingInflate = BloProgressLayoutBinding.inflate(LayoutInflater.from(context));
        Dialog dialog = new Dialog(context, 2132017708);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(bloProgressLayoutBindingInflate.getRoot());
        dialog.setCancelable(false);
        return dialog;
    }

    public static String getDisplayDate(Date submitDate) {
        return new SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(submitDate);
    }

    public static String maskAadhaar(String raw) {
        if (raw == null) {
            return "Invalid Aadhaar";
        }
        String strReplaceAll = raw.replaceAll("\\D", "");
        if (strReplaceAll.length() != 12) {
            return "Invalid Aadhaar";
        }
        return "xxxx-xxxx-" + strReplaceAll.substring(8);
    }
}
