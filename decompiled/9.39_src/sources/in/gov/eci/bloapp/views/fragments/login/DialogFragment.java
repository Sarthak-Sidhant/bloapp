package in.gov.eci.bloapp.views.fragments.login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class DialogFragment extends AppCompatDialogFragment {
    static /* synthetic */ void lambda$onCreateDialog$0(DialogInterface dialogInterface, int i) {
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.blo_AlertDialogTheme);
        builder.setTitle("Alert").setMessage("The mobile number or password is incorrect, Try again").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.DialogFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DialogFragment.lambda$onCreateDialog$0(dialogInterface, i);
            }
        });
        return builder.create();
    }
}
