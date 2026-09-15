package in.gov.eci.bloapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.model.app_model.FormsinDraftOverseasModel;
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
public class OverseasDetailsRepository {
    ApiInterface apiInterface;
    public LiveData<List<FormsinDraftOverseasModel>> data;
    List<FormsinDraftOverseasModel> dataList;
    public MutableLiveData<List<FormsinDraftOverseasModel>> dataMutable;

    @Inject
    DatabaseHelper dbHandler;

    @Inject
    EciDatabase eciDatabase;

    @Inject
    public OverseasDetailsRepository(ApiInterface apiInterface) {
        MutableLiveData<List<FormsinDraftOverseasModel>> mutableLiveData = new MutableLiveData<>();
        this.dataMutable = mutableLiveData;
        this.data = mutableLiveData;
        this.dataList = new ArrayList();
        this.apiInterface = apiInterface;
    }

    public void insertData(String refe) {
        this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL("DELETE FROM DRAFT_FORMS where FORM_REFERENCE_NUMBER='" + refe + "'");
    }

    public void insertforms(String name, String insertState, String personal, int seq, String formtype, String referencenumber, String created_on, String img) {
        SQLiteDatabase writableDatabase = this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY);
        SQLiteStatement sQLiteStatementCompileStatement = writableDatabase.compileStatement("INSERT INTO DRAFT_FORMS (NAME,STATE_DETAILS,PERSONAL_DETAILS,STEP_SEQUENCE,FORM_TYPE,FORM_REFERENCE_NUMBER,CREATED_ON,PHOTOGRAPH) VALUES(?,?,?,?,?,?,?,?)");
        sQLiteStatementCompileStatement.clearBindings();
        sQLiteStatementCompileStatement.bindString(1, name);
        sQLiteStatementCompileStatement.bindString(2, insertState);
        sQLiteStatementCompileStatement.bindString(3, personal);
        sQLiteStatementCompileStatement.bindString(4, String.valueOf(seq));
        sQLiteStatementCompileStatement.bindString(5, formtype);
        sQLiteStatementCompileStatement.bindString(6, referencenumber);
        sQLiteStatementCompileStatement.bindString(7, created_on);
        if (img != null) {
            sQLiteStatementCompileStatement.bindString(8, img);
        } else {
            sQLiteStatementCompileStatement.bindString(8, StringUtils.SPACE);
        }
        try {
            sQLiteStatementCompileStatement.executeInsert();
            writableDatabase.close();
        } catch (Exception e) {
            Logger.d("TAG", e.getMessage());
        }
    }

    public void updateresidence(String referencenumber, String residence, int seq) {
        String str = "Update DRAFT_FORMS set STEP_SEQUENCE='" + seq + "', RESIDENCE_DETAILS='" + residence + "' where FORM_REFERENCE_NUMBER='" + referencenumber + "'";
        Logger.e("TAG", str);
        this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL(str);
    }

    public void updatepassport(String referencenumber, String passport, int seq, String passportpdf) {
        SQLiteDatabase writableDatabase = this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY);
        SQLiteStatement sQLiteStatementCompileStatement = writableDatabase.compileStatement("Update DRAFT_FORMS set STEP_SEQUENCE=?, PASSPORT_DETAILS=? ,PASSPORT_PDF=? where FORM_REFERENCE_NUMBER=?");
        sQLiteStatementCompileStatement.clearBindings();
        sQLiteStatementCompileStatement.bindString(1, String.valueOf(seq));
        sQLiteStatementCompileStatement.bindString(2, passport);
        if (passportpdf != null) {
            sQLiteStatementCompileStatement.bindString(3, passportpdf);
        } else {
            sQLiteStatementCompileStatement.bindString(3, StringUtils.SPACE);
        }
        sQLiteStatementCompileStatement.bindString(4, referencenumber);
        sQLiteStatementCompileStatement.execute();
        writableDatabase.close();
    }

    public void updateVisa(String referencenumber, String visa, int seq) {
        String str = "Update DRAFT_FORMS set STEP_SEQUENCE='" + seq + "', VISA_DETAILS='" + visa + "' where FORM_REFERENCE_NUMBER='" + referencenumber + "'";
        Logger.e("TAG", str);
        this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL(str);
    }

    public void updateordinary(String referencenumber, String address, int seq) {
        String str = "Update DRAFT_FORMS set STEP_SEQUENCE='" + seq + "', ORDINARY_ADDRESS='" + address + "' where FORM_REFERENCE_NUMBER='" + referencenumber + "'";
        Logger.e("TAG", str);
        this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL(str);
    }

    public void updateoutsideIndia(String referencenumber, String outsideindia, int seq) {
        String str = "Update DRAFT_FORMS set STEP_SEQUENCE='" + seq + "', OUTSIDE_DETAILS='" + outsideindia + "' where FORM_REFERENCE_NUMBER='" + referencenumber + "'";
        Logger.e("TAG", str);
        this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL(str);
    }

    public LiveData<List<FormsinDraftOverseasModel>> dataoneditbutton(String name, String date, String formtype) {
        this.dataList.clear();
        String str = "SELECT STATE_DETAILS,PERSONAL_DETAILS,RESIDENCE_DETAILS,PASSPORT_DETAILS,VISA_DETAILS,OUTSIDE_DETAILS,STEP_SEQUENCE,FORM_REFERENCE_NUMBER,PHOTOGRAPH,PASSPORT_PDF,ORDINARY_ADDRESS,DECLARATION_DETAILS FROM DRAFT_FORMS WHERE FORM_TYPE  = '" + formtype + "' and NAME='" + name + "' and CREATED_ON='" + date + "'";
        Logger.e("TAG", str);
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery(str, (String[]) null);
        if (cursorRawQuery.getCount() > 0) {
            cursorRawQuery.moveToFirst();
            for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                this.dataList.add(new FormsinDraftOverseasModel(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("STATE_DETAILS")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PERSONAL_DETAILS")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("RESIDENCE_DETAILS")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PASSPORT_DETAILS")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("VISA_DETAILS")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("OUTSIDE_DETAILS")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("STEP_SEQUENCE")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("FORM_REFERENCE_NUMBER")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PHOTOGRAPH")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PASSPORT_PDF")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ORDINARY_ADDRESS")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DECLARATION_DETAILS"))));
                this.dataMutable.postValue(this.dataList);
                cursorRawQuery.moveToNext();
            }
            this.dataMutable.postValue(this.dataList);
        }
        return this.data;
    }

    public void updatedeclaration(String referencenumber, String declaration, int i) {
        String str = "Update DRAFT_FORMS set STEP_SEQUENCE='" + i + "', DECLARATION_DETAILS='" + declaration + "' where FORM_REFERENCE_NUMBER='" + referencenumber + "'";
        Logger.e("TAG", str);
        this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL(str);
    }

    public void updatepersonal(String name, String personal, String referencenumber, int i, String photoref, String date) {
        String str = "Update DRAFT_FORMS set NAME='" + name + "',STEP_SEQUENCE='" + i + "', PERSONAL_DETAILS='" + personal + "',PHOTOGRAPH='" + photoref + "',CREATED_ON='" + date + "' where FORM_REFERENCE_NUMBER='" + referencenumber + "'";
        Logger.e("TAG", str);
        this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL(str);
    }
}
