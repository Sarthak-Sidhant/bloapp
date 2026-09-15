package in.gov.eci.bloapp.repository;

import android.content.ContentValues;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.model.app_model.DraftNewVoterModel;
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
public class NewVoterrepository {
    ApiInterface apiInterface;
    public LiveData<List<DraftNewVoterModel>> data;
    List<DraftNewVoterModel> dataList;
    public MutableLiveData<List<DraftNewVoterModel>> dataMutable;

    @Inject
    DatabaseHelper dbHandler;

    @Inject
    EciDatabase eciDatabase;
    private String insertIntoStageDetails;
    String[] stageData = {"Submitted", "BLO Assigned", "Directly forwarded to ERO", "Core document verified", "FVR Submitted", " FVR Review and sent to ERO", "Re-initiated", "Hearing Scheduled", "Accepted", "Rejected", "Roll back Requested", "Roll back Accepted"};
    private String stageDataValue;

    @Inject
    public NewVoterrepository(ApiInterface apiInterface) {
        MutableLiveData<List<DraftNewVoterModel>> mutableLiveData = new MutableLiveData<>();
        this.dataMutable = mutableLiveData;
        this.data = mutableLiveData;
        this.dataList = new ArrayList();
        this.apiInterface = apiInterface;
    }

    public void insertforms(String s, String insertState, String personal, int i, String s1, String referencenumber, String datecreated, String byteArray, String pdfbyteArray2, String section) {
        SQLiteDatabase writableDatabase = this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY);
        SQLiteStatement sQLiteStatementCompileStatement = writableDatabase.compileStatement("INSERT INTO DRAFT_FORMS (NAME,STATE_DETAILS,PERSONAL_DETAILS,STEP_SEQUENCE,FORM_TYPE,FORM_REFERENCE_NUMBER,CREATED_ON,PHOTOGRAPH,DOB_DOCUMENT,SECTION_NO) VALUES(?,?,?,?,?,?,?,?,?,?)");
        sQLiteStatementCompileStatement.clearBindings();
        sQLiteStatementCompileStatement.bindString(1, s);
        sQLiteStatementCompileStatement.bindString(2, insertState);
        sQLiteStatementCompileStatement.bindString(3, personal);
        sQLiteStatementCompileStatement.bindString(4, String.valueOf(i));
        sQLiteStatementCompileStatement.bindString(5, s1);
        sQLiteStatementCompileStatement.bindString(6, referencenumber);
        sQLiteStatementCompileStatement.bindString(7, datecreated);
        if (byteArray != null) {
            sQLiteStatementCompileStatement.bindString(8, byteArray);
        } else {
            sQLiteStatementCompileStatement.bindString(8, StringUtils.SPACE);
        }
        if (pdfbyteArray2 != null) {
            sQLiteStatementCompileStatement.bindString(9, pdfbyteArray2);
        } else {
            sQLiteStatementCompileStatement.bindString(9, StringUtils.SPACE);
        }
        sQLiteStatementCompileStatement.bindString(10, section);
        try {
            sQLiteStatementCompileStatement.executeInsert();
            writableDatabase.close();
        } catch (Exception e) {
            Logger.d("TAG", e.getMessage());
        }
    }

    public void updateresidence(String referencenumber, String residence, int i, String pdfbyteArray) {
        SQLiteDatabase writableDatabase = this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("STEP_SEQUENCE", Integer.valueOf(i));
            contentValues.put("RESIDENCE_DETAILS", residence);
            contentValues.put("RESIDENCE_DOCUMENT", pdfbyteArray);
            writableDatabase.update("DRAFT_FORMS", contentValues, "FORM_REFERENCE_NUMBER = ?", new String[]{referencenumber});
            writableDatabase.close();
        } catch (Exception e) {
            Logger.d("TAG", e.getMessage());
        }
    }

    public void updateDetails(String referencenumber, String details, int i, String pdfbyteArray1) {
        Logger.e("TAG", "Update DRAFT_FORMS set STEP_SEQUENCE=?, OPTION_OF_APPLICATION=?,DISABILITY_DOC=? where FORM_REFERENCE_NUMBER=?");
        SQLiteDatabase writableDatabase = this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY);
        SQLiteStatement sQLiteStatementCompileStatement = writableDatabase.compileStatement("Update DRAFT_FORMS set STEP_SEQUENCE=?, OPTION_OF_APPLICATION=?,DISABILITY_DOC=? where FORM_REFERENCE_NUMBER=?");
        sQLiteStatementCompileStatement.clearBindings();
        sQLiteStatementCompileStatement.bindString(1, String.valueOf(i));
        sQLiteStatementCompileStatement.bindString(2, details);
        if (pdfbyteArray1 != null) {
            sQLiteStatementCompileStatement.bindString(3, pdfbyteArray1);
        } else {
            sQLiteStatementCompileStatement.bindString(3, StringUtils.SPACE);
        }
        sQLiteStatementCompileStatement.bindString(4, referencenumber);
        try {
            sQLiteStatementCompileStatement.execute();
            writableDatabase.close();
        } catch (Exception e) {
            Logger.d("TAG", e.getMessage());
        }
    }

    public LiveData<List<DraftNewVoterModel>> dataoneditbutton(String name, String date, String formtype) {
        this.dataList.clear();
        String str = "SELECT STATE_DETAILS,PERSONAL_DETAILS,RESIDENCE_DETAILS,OPTION_OF_APPLICATION,FAMILY_DETAILS,STEP_SEQUENCE,FORM_REFERENCE_NUMBER,PHOTOGRAPH,DOB_DOCUMENT,RESIDENCE_DOCUMENT,DISABILITY_DOC,DECLARATION_DETAILS,SECTION_NO,CitizenshipType,CitizenshipTypeCat,CtDocTypeForSelf,CtDocOfSelfUrl,DoctypeselfFileName,DoctypeselFileSize,Before2004ParentType,DoctypeFather,DoctypeMother,DocURLFather,DocURLMother,Before2004docFileName,Before2004docFileSize,After2004isParentIndian,After2004ParentNameNotindian,After2004doctypeFather,After2004doctypeMother,After2004docURLFather,After2004docURLMother,After2004MotherFileName,After2004MotherFileSize,After2004FatherFileName,After2004FatherFileSize,BornOutofIndiadoctype,BornOutofIndiadocURL,BornOutofIndiaFileName,BornOutofIndiaFileSize,CitizenAquuireddoctype,CitizenAquuireddocURL,CitizenAquuiredFileName,CitizenAquuiredFileSize,AnnexureSignURL,AnexSignFileName,AnexSignFileSize,DeclarationForm FROM DRAFT_FORMS WHERE FORM_TYPE  = '" + formtype + "' and NAME='" + name + "' and CREATED_ON='" + date + "'";
        Logger.e("TAG", str);
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery(str, (String[]) null);
        if (cursorRawQuery.getCount() > 0) {
            cursorRawQuery.moveToFirst();
            for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("STATE_DETAILS"));
                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PERSONAL_DETAILS"));
                String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("RESIDENCE_DETAILS"));
                String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("OPTION_OF_APPLICATION"));
                String string5 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("FAMILY_DETAILS"));
                String string6 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DECLARATION_DETAILS"));
                String string7 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("STEP_SEQUENCE"));
                String string8 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("FORM_REFERENCE_NUMBER"));
                this.dataList.add(new DraftNewVoterModel(string, string2, string3, string4, cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PHOTOGRAPH")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DOB_DOCUMENT")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("RESIDENCE_DOCUMENT")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DISABILITY_DOC")), string7, string8, string5, string6, cursorRawQuery.getString(cursorRawQuery.getColumnIndex("SECTION_NO")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CitizenshipType")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CitizenshipTypeCat")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CtDocTypeForSelf")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CtDocOfSelfUrl")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DoctypeselfFileName")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DoctypeselFileSize")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("Before2004ParentType")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DoctypeFather")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DoctypeMother")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DocURLFather")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DocURLMother")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("Before2004docFileName")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("Before2004docFileSize")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("After2004isParentIndian")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("After2004ParentNameNotindian")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("After2004doctypeFather")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("After2004doctypeMother")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("After2004docURLFather")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("After2004docURLMother")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("After2004MotherFileName")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("After2004MotherFileSize")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("After2004FatherFileName")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("After2004FatherFileSize")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BornOutofIndiadoctype")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BornOutofIndiadocURL")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BornOutofIndiaFileName")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BornOutofIndiaFileSize")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CitizenAquuireddoctype")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CitizenAquuireddocURL")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CitizenAquuiredFileName")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CitizenAquuiredFileSize")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("AnnexureSignURL")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("AnexSignFileName")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("AnexSignFileSize")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DeclarationForm"))));
                this.dataMutable.postValue(this.dataList);
                cursorRawQuery.moveToNext();
            }
            this.dataMutable.postValue(this.dataList);
        }
        return this.data;
    }

    public void inserData(String toString, String toString1, String toString2, String toString3, String toString4, String toString5, String toString6, byte[] byteArray, int family, String toString9, String toString10, String mobile, String toString11, String email, String toString12, String aadhar, String toString13, String gender, String toString14, byte[] pdfbyteArray2, String toString15, String toString16, String toString17, String toString18, String toString19, String toString20, String referencenumber, String createdDate) {
        Logger.e("TAG", "Insert into VOTER_DETAILS(GENDER,REFERENCE_NUMBER,REQUEST_TYPE,CREATED_ON) values (?,?,?,?)");
        SQLiteDatabase writableDatabase = this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY);
        SQLiteStatement sQLiteStatementCompileStatement = writableDatabase.compileStatement("Insert into VOTER_DETAILS(GENDER,REFERENCE_NUMBER,REQUEST_TYPE,CREATED_ON) values (?,?,?,?)");
        sQLiteStatementCompileStatement.clearBindings();
        sQLiteStatementCompileStatement.bindString(1, gender);
        sQLiteStatementCompileStatement.bindString(2, referencenumber);
        sQLiteStatementCompileStatement.bindString(3, "Form 6");
        sQLiteStatementCompileStatement.bindString(4, createdDate);
        try {
            sQLiteStatementCompileStatement.executeInsert();
            writableDatabase.execSQL("DELETE FROM DRAFT_FORMS where FORM_REFERENCE_NUMBER='" + referencenumber + "'");
            for (int i = 0; i < this.stageData.length; i++) {
                Logger.d("", "Length " + i + StringUtils.SPACE + this.stageData[i]);
                String str = this.stageData[i];
                this.stageDataValue = str;
                this.insertIntoStageDetails = "";
                Logger.d("stageDataValue ", str);
                if (this.stageDataValue.equals("Submitted")) {
                    this.insertIntoStageDetails = "INSERT INTO STAGE_DETAILS (STAGE,DATE,REFERENCE_ID) VALUES ('" + this.stageDataValue + "','" + createdDate + "','" + referencenumber + "')";
                } else {
                    this.insertIntoStageDetails = "INSERT INTO STAGE_DETAILS (STAGE,REFERENCE_ID) VALUES ('" + this.stageDataValue + "','" + referencenumber + "')";
                }
                writableDatabase.execSQL(this.insertIntoStageDetails);
            }
            writableDatabase.close();
        } catch (Exception e) {
            Logger.d("TAG", e.getMessage());
        }
    }

    public void updateFamily(String referencenumber, String familydetail, int i) {
        this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL("Update DRAFT_FORMS set FAMILY_DETAILS='" + familydetail + "',STEP_SEQUENCE='" + i + "' where FORM_REFERENCE_NUMBER='" + referencenumber + "'");
    }

    public void updatedeclaration(String referencenumber, String declaration, int i) {
        this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL("Update DRAFT_FORMS set DECLARATION_DETAILS='" + declaration + "',STEP_SEQUENCE='" + i + "' where FORM_REFERENCE_NUMBER='" + referencenumber + "'");
    }

    public void updatepersonal(String name, String personal, String referencenumber, int i, String photoref, String birthref) {
        this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL("Update DRAFT_FORMS set NAME='" + name + "',PERSONAL_DETAILS='" + personal + "',STEP_SEQUENCE='" + i + "',PHOTOGRAPH='" + photoref + "',DOB_DOCUMENT='" + birthref + "' where FORM_REFERENCE_NUMBER='" + referencenumber + "'");
    }

    public void updateAnnexureD(String referencenumber, String citizenshipType, String citizenshipTypeCat, String ctDocTypeForSelf, String ctDocOfSelfUrl, int stepSeqence, String doctypeselfFileName, String doctypeselFileSize, String before2004ParentType, String doctypeFather, String doctypeMother, String docURLFather, String docURLMother, String before2004docFileName, String before2004docFileSize, String after2004isParentIndian, String after2004ParentNameNotindian, String after2004doctypeFather, String after2004doctypeMother, String after2004docURLFather, String after2004docURLMother, String after2004MotherFileName, String after2004MotherFileSize, String after2004FatherFileName, String after2004FatherFileSize, String bornOutofIndiadoctype, String bornOutofIndiadocURL, String bornOutofIndiaFileName, String bornOutofIndiaFileSize, String citizenAquuireddoctype, String citizenAquuireddocURL, String citizenAquuiredFileName, String citizenAquuiredFileSize, String annexuresignatureURL, String anexSignFileName, String anexSignFileSize) {
        this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL("Update DRAFT_FORMS set CitizenshipType='" + citizenshipType + "',AnexSignFileSize='" + anexSignFileSize + "',AnexSignFileName='" + anexSignFileName + "',AnnexureSignURL='" + annexuresignatureURL + "',CitizenAquuiredFileSize='" + citizenAquuiredFileSize + "',CitizenAquuiredFileName='" + citizenAquuiredFileName + "',CitizenAquuireddocURL='" + citizenAquuireddocURL + "',CitizenAquuireddoctype='" + citizenAquuireddoctype + "',BornOutofIndiaFileSize='" + bornOutofIndiaFileSize + "',BornOutofIndiaFileSize='" + bornOutofIndiaFileName + "',BornOutofIndiaFileName='" + bornOutofIndiaFileName + "',BornOutofIndiadocURL='" + bornOutofIndiadocURL + "',BornOutofIndiadoctype='" + bornOutofIndiadoctype + "',After2004FatherFileSize='" + after2004FatherFileSize + "',After2004FatherFileName='" + after2004FatherFileName + "',After2004MotherFileSize='" + after2004MotherFileSize + "',After2004MotherFileName='" + after2004MotherFileName + "',After2004docURLMother='" + after2004docURLMother + "',After2004docURLFather='" + after2004docURLFather + "',After2004doctypeMother='" + after2004doctypeMother + "',After2004doctypeFather='" + after2004doctypeFather + "',After2004ParentNameNotindian='" + after2004ParentNameNotindian + "',After2004isParentIndian='" + after2004isParentIndian + "',Before2004docFileSize='" + before2004docFileSize + "',Before2004docFileName='" + before2004docFileName + "',DocURLMother='" + docURLMother + "',DocURLFather='" + docURLFather + "',DoctypeMother='" + doctypeMother + "',DoctypeFather='" + doctypeFather + "',Before2004ParentType='" + before2004ParentType + "',CitizenshipTypeCat='" + citizenshipTypeCat + "',CtDocTypeForSelf='" + ctDocTypeForSelf + "',CtDocOfSelfUrl='" + ctDocOfSelfUrl + "',DoctypeselfFileName='" + doctypeselfFileName + "',DoctypeselFileSize='" + doctypeselFileSize + "',STEP_SEQUENCE='" + stepSeqence + "' where FORM_REFERENCE_NUMBER='" + referencenumber + "'");
    }

    public void updateDeclarationForm(String declarationForm, String referencenumber, int i) {
        this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL("Update DRAFT_FORMS set DeclarationForm='" + declarationForm + "',STEP_SEQUENCE='" + i + "' where FORM_REFERENCE_NUMBER='" + referencenumber + "'");
    }

    public boolean isFormExists(String referenceNumber) {
        SQLiteDatabase readableDatabase = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY);
        SQLiteStatement sQLiteStatementCompileStatement = readableDatabase.compileStatement("SELECT COUNT(*) FROM DRAFT_FORMS WHERE FORM_REFERENCE_NUMBER = ?");
        sQLiteStatementCompileStatement.bindString(1, referenceNumber);
        long jSimpleQueryForLong = sQLiteStatementCompileStatement.simpleQueryForLong();
        readableDatabase.close();
        return jSimpleQueryForLong > 0;
    }
}
