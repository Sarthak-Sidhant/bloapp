package in.gov.eci.bloapp.repository;

import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import in.gov.eci.bloapp.utils.Logger;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FormsRepo {
    public static final String TAG = "TAG";
    ApiInterface apiInterface;

    @Inject
    DatabaseHelper dbHandler;

    @Inject
    EciDatabase eciDatabase;

    @Inject
    public FormsRepo(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public void updateaadhar(String houseno, String streetno, String village, String postoffice, String pincode, String teshil, String referenceno, String formtype) {
        String str = "Update VOTER_DETAILS set CURRENT_HOUSE_NUMBER='" + houseno + "', CURRENT_STREET='" + streetno + "', CURRENT_TOWN='" + village + "', CURRENT_POSTOFFICE='" + postoffice + "', CURRENT_PINCODE='" + pincode + "', TEHSIL='" + teshil + "' WHERE REFERENCE_NUMBER='" + referenceno + "' and REQUEST_TYPE='" + formtype + "'";
        Logger.e("TAG", str);
        try {
            this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL(str);
        } catch (Exception e) {
            Logger.d("CONTENT", e.getMessage());
        }
    }
}
