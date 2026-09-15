package in.gov.eci.bloapp.views.activity.newsir.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.views.activity.newsir.callback.DecisionDialogCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.SpeechtoTextCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback;
import java.util.ArrayList;
import java.util.Locale;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class Utils {
    private static final int REQUEST_RECORD_AUDIO = 1;

    @Inject
    public Utils() {
    }

    public void validateState_Ac_Part_Serial(Context context, String State, String Ac, String Part, String PartSerial, ValidationCallback validationCallback) {
        if (TextUtils.isEmpty(State)) {
            infoDialog(context, context.getResources().getString(R.string.alertMsg), context.getResources().getString(R.string.please_select_previous_sir_state));
            return;
        }
        if (TextUtils.isEmpty(Ac)) {
            infoDialog(context, context.getResources().getString(R.string.alertMsg), context.getResources().getString(R.string.please_select_previous_sir_ac));
            return;
        }
        if (TextUtils.isEmpty(Part)) {
            infoDialog(context, context.getResources().getString(R.string.alertMsg), context.getResources().getString(R.string.please_select_previous_sir_part));
        } else if (TextUtils.isEmpty(PartSerial)) {
            infoDialog(context, context.getResources().getString(R.string.alertMsg), context.getResources().getString(R.string.please_enter_previous_sir_part_serial_no));
        } else {
            validationCallback.onResult(true);
        }
    }

    public void validateState_Ac_Part_Serial(Context context, String State, String district, String Ac, String Part, String PartSerial, ValidationCallback validationCallback) {
        if (TextUtils.isEmpty(State)) {
            infoDialog(context, context.getResources().getString(R.string.alertMsg), context.getResources().getString(R.string.please_select_previous_sir_state));
            return;
        }
        if (TextUtils.isEmpty(Ac)) {
            infoDialog(context, context.getResources().getString(R.string.alertMsg), context.getResources().getString(R.string.please_select_previous_sir_ac));
            return;
        }
        if (TextUtils.isEmpty(Part)) {
            infoDialog(context, context.getResources().getString(R.string.alertMsg), context.getResources().getString(R.string.please_select_previous_sir_part));
        } else if (TextUtils.isEmpty(PartSerial)) {
            infoDialog(context, context.getResources().getString(R.string.alertMsg), context.getResources().getString(R.string.please_enter_previous_sir_part_serial_no));
        } else {
            validationCallback.onResult(true);
        }
    }

    public void validateState_Ac_Family(Context context, String State, String Ac, String electorName, String parentName, String grandParentName, String district, String oldPart, String categorytype, ValidationCallback validationCallback) {
        if (TextUtils.isEmpty(categorytype)) {
            if (TextUtils.isEmpty(State)) {
                infoDialog(context, context.getResources().getString(R.string.alertMsg), context.getResources().getString(R.string.please_select_previous_sir_state));
                return;
            }
            if (TextUtils.isEmpty(parentName)) {
                infoDialog(context, "Alert", "Please enter parent name");
                return;
            } else if (TextUtils.isEmpty(grandParentName)) {
                infoDialog(context, "Alert", "Please enter parent relative's name");
                return;
            } else {
                validationCallback.onResult(true);
                return;
            }
        }
        if (TextUtils.isEmpty(State)) {
            infoDialog(context, context.getResources().getString(R.string.alertMsg), context.getResources().getString(R.string.please_select_previous_sir_state));
            return;
        }
        if (categorytype.equalsIgnoreCase("self") && TextUtils.isEmpty(electorName)) {
            infoDialog(context, "Alert", "Please enter elector name ");
            return;
        }
        if (categorytype.equalsIgnoreCase("self") && TextUtils.isEmpty(parentName)) {
            infoDialog(context, "Alert", "Please enter relative name ");
            return;
        }
        if (categorytype.equalsIgnoreCase("progeny") && TextUtils.isEmpty(parentName)) {
            infoDialog(context, "Alert", "Please enter parent name");
        } else if (categorytype.equalsIgnoreCase("progeny") && TextUtils.isEmpty(grandParentName)) {
            infoDialog(context, "Alert", "Please enter parent relative's name");
        } else {
            validationCallback.onResult(true);
        }
    }

    public void infoDialog(Context context, String alertText, String message) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            new AlertDialog.Builder(context).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(context.getResources().getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.utils.Utils$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).create().show();
        }
    }

    public void infoDialog1(Context context, String alertText, String message) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            final AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setTitle(alertText).setMessage(message).create();
            alertDialogCreate.show();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.utils.Utils.1
                @Override // java.lang.Runnable
                public void run() {
                    if (alertDialogCreate.isShowing()) {
                        alertDialogCreate.dismiss();
                    }
                }
            }, 2000L);
        }
    }

    public void decisionDialog(Context context, String title, String message, String positiveButtonName, String NegativeButtonName, final DecisionDialogCallback decisionDialogCallback) {
        new AlertDialog.Builder(context).setTitle(title).setMessage(message).setCancelable(false).setPositiveButton(positiveButtonName, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.utils.Utils$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                Utils.lambda$decisionDialog$1(decisionDialogCallback, dialogInterface, i);
            }
        }).setNegativeButton(NegativeButtonName, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.utils.Utils$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                Utils.lambda$decisionDialog$2(decisionDialogCallback, dialogInterface, i);
            }
        }).create().show();
    }

    static /* synthetic */ void lambda$decisionDialog$1(DecisionDialogCallback decisionDialogCallback, DialogInterface dialogInterface, int i) {
        decisionDialogCallback.onPositiveButtonClicked();
        dialogInterface.dismiss();
    }

    static /* synthetic */ void lambda$decisionDialog$2(DecisionDialogCallback decisionDialogCallback, DialogInterface dialogInterface, int i) {
        decisionDialogCallback.onNegativeButtonClicked();
        dialogInterface.dismiss();
    }

    public void showVoicePopup(Context context, SpeechtoTextCallback speechtoTextCallback) {
        Activity activity = (Activity) context;
        if (ContextCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") != 0) {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.RECORD_AUDIO"}, 1);
        }
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(context);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.popup_voice, (ViewGroup) null);
        builder.setView(viewInflate);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.cross);
        Glide.with(context).asGif().load(Integer.valueOf(R.drawable.waveblueg)).into((ImageView) viewInflate.findViewById(R.id.ivwave));
        final androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
        final SpeechRecognizer speechRecognizerCreateSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(context);
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        intent.putExtra("android.speech.extra.LANGUAGE", Locale.getDefault());
        speechRecognizerCreateSpeechRecognizer.startListening(intent);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.utils.Utils.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpeechRecognizer speechRecognizer = speechRecognizerCreateSpeechRecognizer;
                if (speechRecognizer != null) {
                    speechRecognizer.destroy();
                }
                alertDialogCreate.dismiss();
            }
        });
        speechRecognizerCreateSpeechRecognizer.setRecognitionListener(new AnonymousClass3(speechtoTextCallback, alertDialogCreate, speechRecognizerCreateSpeechRecognizer, intent));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.newsir.utils.Utils$3, reason: invalid class name */
    class AnonymousClass3 implements RecognitionListener {
        final /* synthetic */ androidx.appcompat.app.AlertDialog val$dialog;
        final /* synthetic */ Intent val$intent;
        final /* synthetic */ SpeechRecognizer val$speechRecognizer;
        final /* synthetic */ SpeechtoTextCallback val$speechtoTextCallback;

        @Override // android.speech.RecognitionListener
        public void onBeginningOfSpeech() {
        }

        @Override // android.speech.RecognitionListener
        public void onBufferReceived(byte[] buffer) {
        }

        @Override // android.speech.RecognitionListener
        public void onEndOfSpeech() {
        }

        @Override // android.speech.RecognitionListener
        public void onEvent(int eventType, Bundle params) {
        }

        @Override // android.speech.RecognitionListener
        public void onReadyForSpeech(Bundle params) {
        }

        @Override // android.speech.RecognitionListener
        public void onRmsChanged(float rmsdB) {
        }

        AnonymousClass3(final SpeechtoTextCallback val$speechtoTextCallback, final androidx.appcompat.app.AlertDialog val$dialog, final SpeechRecognizer val$speechRecognizer, final Intent val$intent) {
            this.val$speechtoTextCallback = val$speechtoTextCallback;
            this.val$dialog = val$dialog;
            this.val$speechRecognizer = val$speechRecognizer;
            this.val$intent = val$intent;
        }

        @Override // android.speech.RecognitionListener
        public void onResults(Bundle bundle) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("results_recognition");
            if (stringArrayList == null || stringArrayList.isEmpty()) {
                return;
            }
            this.val$speechtoTextCallback.onCallBack(stringArrayList.get(0));
            this.val$dialog.dismiss();
        }

        @Override // android.speech.RecognitionListener
        public void onError(int error) {
            if (error == 6 || error == 7) {
                Handler handler = new Handler(Looper.getMainLooper());
                final SpeechRecognizer speechRecognizer = this.val$speechRecognizer;
                final Intent intent = this.val$intent;
                final androidx.appcompat.app.AlertDialog alertDialog = this.val$dialog;
                handler.postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.utils.Utils$3$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        Utils.AnonymousClass3.lambda$onError$0(speechRecognizer, intent, alertDialog);
                    }
                }, 500L);
            }
            Log.e("errorSpeech", error + "");
        }

        static /* synthetic */ void lambda$onError$0(SpeechRecognizer speechRecognizer, Intent intent, androidx.appcompat.app.AlertDialog alertDialog) {
            speechRecognizer.cancel();
            speechRecognizer.startListening(intent);
            alertDialog.dismiss();
        }

        @Override // android.speech.RecognitionListener
        public void onPartialResults(Bundle partialResults) {
            Log.e("errorSpeech", "called");
            ArrayList<String> stringArrayList = partialResults.getStringArrayList("results_recognition");
            if (stringArrayList == null || stringArrayList.isEmpty()) {
                return;
            }
            this.val$speechtoTextCallback.onCallBack(stringArrayList.get(0));
            this.val$dialog.dismiss();
        }
    }

    public void validateProgenyDetails(Context context, String oldState, String oldAC, String oldPart, String oldSerial, String progenyName, ValidationCallback validationCallback) {
        validationCallback.onResult(true);
    }

    public void infoDialogAction(Context context, String alertText, String message, final DecisionDialogCallback decisionDialogCallback) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            new AlertDialog.Builder(context).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(context.getResources().getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.utils.Utils$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Utils.lambda$infoDialogAction$3(decisionDialogCallback, dialogInterface, i);
                }
            }).create().show();
        }
    }

    static /* synthetic */ void lambda$infoDialogAction$3(DecisionDialogCallback decisionDialogCallback, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        decisionDialogCallback.onPositiveButtonClicked();
    }

    public void validateProgenyDetailsnew(Context context, String oldState, String oldAC, String oldPart, String oldSerial, String progenyName, String currentAC, String currentPart, String currentStateCd, ValidationCallback validationCallback) {
        validationCallback.onResult(true);
    }
}
