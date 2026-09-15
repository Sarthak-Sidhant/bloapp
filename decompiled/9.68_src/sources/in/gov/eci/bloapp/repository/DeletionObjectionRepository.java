package in.gov.eci.bloapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.model.app_model.DeletionObjectionDraftModel;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import in.gov.eci.bloapp.utils.Logger;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteStatement;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class DeletionObjectionRepository {
    public MutableLiveData<List<DeletionObjectionDraftModel>> _data;
    ApiInterface apiInterface;
    public LiveData<List<DeletionObjectionDraftModel>> data;
    List<DeletionObjectionDraftModel> dataList;

    @Inject
    DatabaseHelper dbHandler;

    @Inject
    EciDatabase eciDatabase;
    String[] stageData = {"Submitted", "BLO Assigned", "Directly forwarded to ERO", "Core document verified", "FVR Submitted", " FVR Review and sent to ERO", "Re-initiated", "Hearing Scheduled", "Accepted", "Rejected", "Roll back Requested", "Roll back Accepted"};

    @Inject
    public DeletionObjectionRepository(ApiInterface apiInterface) {
        MutableLiveData<List<DeletionObjectionDraftModel>> mutableLiveData = new MutableLiveData<>();
        this._data = mutableLiveData;
        this.data = mutableLiveData;
        this.dataList = new ArrayList();
        this.apiInterface = apiInterface;
    }

    public void updateData(String objection_options, String objection_options_subcategory, String epic, String declarationdate, String declarationplace, byte[] photo, String reference_no, String created_on, String status, String request_type) {
        String str;
        String str2 = "Update VOTER_DETAILS set OPTION_OF_APPLICATION='" + objection_options + "', SUBCATEGORY_OPTION_OF_APPLICATION='" + objection_options_subcategory + "', SUBMISSION_DATE='" + declarationdate + "', SUBMISSION_PLACE='" + declarationplace + "', DEATH_CERTIFICATE_PDF='" + photo + "', REFERENCE_NUMBER='" + reference_no + "', CREATED_ON='" + created_on + "', STATUS='" + status + "', REQUEST_TYPE='" + request_type + "' where EPIC_NUMBER='" + epic + "'";
        String str3 = "DELETE FROM DRAFT_FORMS where FORM_REFERENCE_NUMBER='" + reference_no + "'";
        Logger.e("TAG", str2);
        SQLiteDatabase writableDatabase = this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY);
        try {
            writableDatabase.execSQL(str2);
            Logger.e("TAG", str3);
            writableDatabase.execSQL(str3);
            for (int i = 0; i < this.stageData.length; i++) {
                Logger.d("", "Length " + i + StringUtils.SPACE + this.stageData[i]);
                String str4 = this.stageData[i];
                Logger.d("stageDataValue ", str4);
                if (str4.equals("Submitted")) {
                    str = "INSERT INTO STAGE_DETAILS (STAGE,DATE,REFERENCE_ID) VALUES ('" + str4 + "','" + created_on + "','" + reference_no + "')";
                } else {
                    str = "INSERT INTO STAGE_DETAILS (STAGE,REFERENCE_ID) VALUES ('" + str4 + "','" + reference_no + "')";
                }
                writableDatabase.execSQL(str);
            }
        } catch (Exception e) {
            Logger.d("TAG", e.getMessage());
        }
    }

    public void insertforms(String name, String insertState, String personal, int seq, String formtype, String reference_number, String created_on, String formOrigin, String epicNumber) {
        String str = "Insert into DRAFT_FORMS(NAME,STATE_DETAILS,PERSONAL_DETAILS,STEP_SEQUENCE,FORM_TYPE,FORM_REFERENCE_NUMBER,CREATED_ON,FORM_ORIGIN,EPIC_NUMBER) values('" + name + "','" + insertState + "','" + personal + "','" + seq + "','" + formtype + "','" + reference_number + "','" + created_on + "','" + formOrigin + "','" + epicNumber + "')";
        Logger.e("TAG", str);
        try {
            this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL(str);
        } catch (Exception e) {
            Logger.d("TAG", e.getMessage());
        }
    }

    public void updatepersonaldetails(String reference_number, String personalDetails, int seq) {
        String str = "Update DRAFT_FORMS set STEP_SEQUENCE='" + seq + "', PERSONAL_DETAILS='" + personalDetails + "' where FORM_REFERENCE_NUMBER='" + reference_number + "'";
        Logger.e("TAG", str);
        try {
            this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL(str);
        } catch (Exception e) {
            Logger.d("TAG", e.getMessage());
        }
    }

    public void updaterejectionoptions(String reference_number, String rejectionOptions, String deathcerti_attach, byte[] photo, int seq) {
        SQLiteDatabase writableDatabase = this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY);
        if (deathcerti_attach.equals("No")) {
            Logger.e("TAG", "Update DRAFT_FORMS set STEP_SEQUENCE=" + seq + ", OPTION_OF_APPLICATION=" + rejectionOptions + " where FORM_REFERENCE_NUMBER=" + reference_number);
            SQLiteStatement sQLiteStatementCompileStatement = writableDatabase.compileStatement("Update DRAFT_FORMS set STEP_SEQUENCE=?, OPTION_OF_APPLICATION=? where FORM_REFERENCE_NUMBER=?");
            sQLiteStatementCompileStatement.clearBindings();
            sQLiteStatementCompileStatement.bindString(1, String.valueOf(seq));
            sQLiteStatementCompileStatement.bindString(2, rejectionOptions);
            sQLiteStatementCompileStatement.bindString(3, reference_number);
            sQLiteStatementCompileStatement.execute();
            writableDatabase.close();
            return;
        }
        try {
            Logger.e("TAG", "Update DRAFT_FORMS set STEP_SEQUENCE=" + seq + ", OPTION_OF_APPLICATION=" + rejectionOptions + ", DEATH_CERTIFICATE_PDF=" + photo + " where FORM_REFERENCE_NUMBER=" + reference_number);
            SQLiteStatement sQLiteStatementCompileStatement2 = writableDatabase.compileStatement("Update DRAFT_FORMS set STEP_SEQUENCE=?, OPTION_OF_APPLICATION=?, DEATH_CERTIFICATE_PDF=? where FORM_REFERENCE_NUMBER=?");
            sQLiteStatementCompileStatement2.clearBindings();
            sQLiteStatementCompileStatement2.bindString(1, String.valueOf(seq));
            sQLiteStatementCompileStatement2.bindString(2, rejectionOptions);
            sQLiteStatementCompileStatement2.bindBlob(3, photo);
            sQLiteStatementCompileStatement2.bindString(4, reference_number);
            sQLiteStatementCompileStatement2.execute();
            writableDatabase.close();
        } catch (Exception e) {
            Logger.e("Deletion Objection", e.getMessage());
        }
    }

    public void updaterequestraisedetails(String reference_number, String requestDetails, int seq) {
        String str = "Update DRAFT_FORMS set STEP_SEQUENCE='" + seq + "', REQUEST_RAISE_DETAILS='" + requestDetails + "' where FORM_REFERENCE_NUMBER='" + reference_number + "'";
        Logger.e("TAG", str);
        try {
            this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL(str);
        } catch (Exception e) {
            Logger.d("TAG", e.getMessage());
        }
    }

    public LiveData<List<DeletionObjectionDraftModel>> dataoneditbutton(String name, String date, String formtype) {
        this.dataList.clear();
        String str = "SELECT STATE_DETAILS,PERSONAL_DETAILS,OPTION_OF_APPLICATION,REQUEST_RAISE_DETAILS,DEATH_CERTIFICATE_PDF,STEP_SEQUENCE,FORM_REFERENCE_NUMBER FROM DRAFT_FORMS WHERE FORM_TYPE  = '" + formtype + "' and NAME='" + name + "' and CREATED_ON='" + date + "'";
        Logger.e("TAG", str);
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery(str, (String[]) null);
        if (cursorRawQuery.getCount() > 0) {
            cursorRawQuery.moveToFirst();
            for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                this.dataList.add(new DeletionObjectionDraftModel(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("STATE_DETAILS")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PERSONAL_DETAILS")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("OPTION_OF_APPLICATION")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("REQUEST_RAISE_DETAILS")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("STEP_SEQUENCE")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("FORM_REFERENCE_NUMBER")), cursorRawQuery.getBlob(cursorRawQuery.getColumnIndex("DEATH_CERTIFICATE_PDF"))));
                this._data.postValue(this.dataList);
                cursorRawQuery.moveToNext();
            }
            this._data.postValue(this.dataList);
        }
        return this.data;
    }
}
