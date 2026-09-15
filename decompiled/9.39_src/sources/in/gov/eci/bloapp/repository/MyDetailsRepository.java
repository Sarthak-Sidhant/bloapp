package in.gov.eci.bloapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.model.app_model.BloModel;
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

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class MyDetailsRepository {
    public static final String TAG = "TAG";
    public MutableLiveData<List<BloModel>> _blo;
    ApiInterface apiInterface;
    public LiveData<List<BloModel>> blo;
    private final List<BloModel> bloList = new ArrayList();

    @Inject
    DatabaseHelper dbHandler;

    @Inject
    EciDatabase eciDatabase;

    @Inject
    public MyDetailsRepository(ApiInterface apiInterface) {
        MutableLiveData<List<BloModel>> mutableLiveData = new MutableLiveData<>();
        this._blo = mutableLiveData;
        this.blo = mutableLiveData;
        this.apiInterface = apiInterface;
    }

    public LiveData<List<BloModel>> getBLO(String partNumber) {
        this.bloList.clear();
        String str = "SELECT * FROM BLO_DETAILS where PART_NUMBER='" + partNumber + "'";
        Logger.e("TAG", str);
        System.out.println("Gaurav Query Test");
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery(str, (String[]) null);
        if (cursorRawQuery.moveToFirst()) {
            if (cursorRawQuery.getCount() > 0) {
                try {
                    this.bloList.add(new BloModel(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("FIRST_NAME")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("MOBILE_NUMBER")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("EMAIL")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("OFFICE_ADDRESS"))));
                    this._blo.postValue(this.bloList);
                } catch (Exception e) {
                    Logger.d("", e.getMessage());
                }
            } else {
                this._blo.postValue(this.bloList);
            }
        }
        return this.blo;
    }

    public void updateBLODetails(String first_name, String mobile_number, String office_address, String email_id, String partNumber) {
        SQLiteDatabase writableDatabase = this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY);
        SQLiteStatement sQLiteStatementCompileStatement = writableDatabase.compileStatement("Insert into BLO_DETAILS(FIRST_NAME,MOBILE_NUMBER,EMAIL,OFFICE_ADDRESS,PART_NUMBER) values(?,?,?,?,?)");
        sQLiteStatementCompileStatement.clearBindings();
        sQLiteStatementCompileStatement.bindString(1, first_name);
        sQLiteStatementCompileStatement.bindString(2, mobile_number);
        sQLiteStatementCompileStatement.bindString(3, email_id);
        sQLiteStatementCompileStatement.bindString(4, office_address);
        sQLiteStatementCompileStatement.bindString(5, partNumber);
        try {
            sQLiteStatementCompileStatement.executeInsert();
            writableDatabase.close();
            Logger.d("updateVoterDetails", "Insert into BLO_DETAILS(FIRST_NAME,MOBILE_NUMBER,EMAIL,OFFICE_ADDRESS,PART_NUMBER) values(?,?,?,?,?)");
        } catch (Exception e) {
            Logger.d("TAG", e.getMessage());
        }
    }

    public void updateDetails(String first_name, String mobile_number, String office_address, String email_id, String partNumber) {
        this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL("Update BLO_DETAILS set FIRST_NAME='" + first_name + "',MOBILE_NUMBER='" + mobile_number + "',OFFICE_ADDRESS='" + office_address + "', EMAIL='" + email_id + "' where PART_NUMBER='" + partNumber + "'");
    }
}
