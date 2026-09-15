package in.gov.eci.bloapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.model.app_model.FormsinDraftMigrationModel;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import in.gov.eci.bloapp.room.database.EciDatabase;
import in.gov.eci.bloapp.utils.Logger;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import net.sqlcipher.Cursor;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteStatement;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class MigrationRepository {
    private static final String CONTENT = "CONTENT ";
    private static final String SUBMITTED = "Submitted";
    public MutableLiveData<List<FormsinDraftMigrationModel>> _data;
    ApiInterface apiInterface;
    public LiveData<List<FormsinDraftMigrationModel>> data;
    List<FormsinDraftMigrationModel> dataList;

    @Inject
    DatabaseHelper dbHandler;

    @Inject
    EciDatabase eciDatabase;
    private String insertIntoStageDetails;
    private String stageDataValue;
    String voterIdStatus = "";
    String[] stageData = {SUBMITTED, "BLO Assigned", "Directly forwarded to ERO", "Core document verified", "FVR Submitted", " FVR Review and sent to ERO", "Re-initiated", "Hearing Scheduled", "Accepted", "Rejected", "Roll back Requested", "Roll back Accepted"};

    @Inject
    protected MigrationRepository(ApiInterface apiInterface) {
        MutableLiveData<List<FormsinDraftMigrationModel>> mutableLiveData = new MutableLiveData<>();
        this._data = mutableLiveData;
        this.data = mutableLiveData;
        this.dataList = new ArrayList();
        this.apiInterface = apiInterface;
    }

    public void deletedraftData(String epicnumber, String refnumber, String createdon) {
        SQLiteDatabase writableDatabase = this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY);
        try {
            writableDatabase.execSQL("DELETE FROM DRAFT_FORMS where FORM_REFERENCE_NUMBER='" + refnumber + "'");
            writableDatabase.execSQL("UPDATE APPLICANT_DETAILS set FORM_STATUS='Completed', COMPLETED_STATUS='Form Processed', GENERATED_REFERENCE_NUMBER='" + refnumber + "' where EPIC_NUMBER='" + epicnumber + "';");
            for (int i = 0; i < this.stageData.length; i++) {
                Logger.d("", "Length " + i + " " + this.stageData[i]);
                String str = this.stageData[i];
                this.stageDataValue = str;
                this.insertIntoStageDetails = "";
                Logger.d("stageDataValue ", str);
                if (this.stageDataValue.equals(SUBMITTED)) {
                    this.insertIntoStageDetails = "INSERT INTO STAGE_DETAILS (STAGE,DATE,REFERENCE_ID) VALUES ('" + this.stageDataValue + "','" + createdon + "','" + refnumber + "')";
                } else {
                    this.insertIntoStageDetails = "INSERT INTO STAGE_DETAILS (STAGE,REFERENCE_ID) VALUES ('" + this.stageDataValue + "','" + refnumber + "')";
                }
                writableDatabase.execSQL(this.insertIntoStageDetails);
            }
        } catch (Exception e) {
            Logger.d("Tag", e.getMessage());
        }
    }

    public void insertforms(String name, String insertState, String personal, int seq, String formtype, String referenceNumber, String createdOn, String formGeneratedfor, String epicNumber) {
        String str = "Insert into DRAFT_FORMS(NAME,STATE_DETAILS,PERSONAL_DETAILS,STEP_SEQUENCE,FORM_TYPE,FORM_REFERENCE_NUMBER,CREATED_ON,FORM_ORIGIN,EPIC_NUMBER) values('" + name + "','" + insertState + "','" + personal + "','" + seq + "','" + formtype + "','" + referenceNumber + "','" + createdOn + "','" + formGeneratedfor + "','" + epicNumber + "')";
        Logger.e("TAG", str);
        try {
            this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL(str);
        } catch (Exception e) {
            Logger.d("TAG", e.getMessage());
        }
    }

    public void updatepersonalpage(String referenceNumber, String personal) {
        SQLiteDatabase writableDatabase = this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY);
        try {
            Logger.e("TAG", "UPDATE DRAFT_FORMS SET PERSONAL_DETAILS =? WHERE FORM_REFERENCE_NUMBER =?");
            SQLiteStatement sQLiteStatementCompileStatement = writableDatabase.compileStatement("UPDATE DRAFT_FORMS SET PERSONAL_DETAILS =? WHERE FORM_REFERENCE_NUMBER =?");
            sQLiteStatementCompileStatement.clearBindings();
            sQLiteStatementCompileStatement.bindString(1, personal);
            sQLiteStatementCompileStatement.bindString(2, referenceNumber);
            sQLiteStatementCompileStatement.execute();
            writableDatabase.close();
        } catch (SQLException e) {
            Logger.d(CONTENT, e.getMessage());
        }
    }

    public void updateapplicationSOR(String referenceNumber, String application, int seq, String img) {
        SQLiteDatabase writableDatabase = this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY);
        try {
            Logger.e("TAG", "UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =?, PASSPORT_PDF =? WHERE FORM_REFERENCE_NUMBER =?");
            SQLiteStatement sQLiteStatementCompileStatement = writableDatabase.compileStatement("UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =?, PASSPORT_PDF =? WHERE FORM_REFERENCE_NUMBER =?");
            sQLiteStatementCompileStatement.clearBindings();
            sQLiteStatementCompileStatement.bindString(1, String.valueOf(seq));
            sQLiteStatementCompileStatement.bindString(2, application);
            sQLiteStatementCompileStatement.bindString(3, img);
            sQLiteStatementCompileStatement.bindString(4, referenceNumber);
            sQLiteStatementCompileStatement.execute();
            writableDatabase.close();
        } catch (SQLException e) {
            Logger.d(CONTENT, e.getMessage());
        }
    }

    public void updateapplicationIOR(String referenceNumber, String application, int seq, boolean LOSTATTACHMENT, String img) {
        SQLiteDatabase writableDatabase = this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY);
        if (LOSTATTACHMENT) {
            try {
                Logger.e("TAG", "UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =?, LOST_FIR =? WHERE FORM_REFERENCE_NUMBER =?");
                SQLiteStatement sQLiteStatementCompileStatement = writableDatabase.compileStatement("UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =?, LOST_FIR =? WHERE FORM_REFERENCE_NUMBER =?");
                sQLiteStatementCompileStatement.clearBindings();
                sQLiteStatementCompileStatement.bindString(1, String.valueOf(seq));
                sQLiteStatementCompileStatement.bindString(2, application);
                sQLiteStatementCompileStatement.bindString(3, img);
                sQLiteStatementCompileStatement.bindString(4, referenceNumber);
                sQLiteStatementCompileStatement.execute();
                writableDatabase.close();
                return;
            } catch (SQLException e) {
                Logger.d(CONTENT, e.getMessage());
                return;
            }
        }
        try {
            Logger.e("TAG", "UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =? WHERE FORM_REFERENCE_NUMBER =?");
            SQLiteStatement sQLiteStatementCompileStatement2 = writableDatabase.compileStatement("UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =? WHERE FORM_REFERENCE_NUMBER =?");
            sQLiteStatementCompileStatement2.clearBindings();
            sQLiteStatementCompileStatement2.bindString(1, String.valueOf(seq));
            sQLiteStatementCompileStatement2.bindString(2, application);
            sQLiteStatementCompileStatement2.bindString(3, referenceNumber);
            sQLiteStatementCompileStatement2.execute();
            writableDatabase.close();
        } catch (SQLException e2) {
            Logger.d(CONTENT, e2.getMessage());
        }
    }

    public void updateapplicationROM(String referenceNumber, String application, int seq, boolean disattachment, String img) {
        SQLiteDatabase writableDatabase = this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY);
        if (disattachment) {
            try {
                Logger.e("TAG", "UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =? , DISABILITY_CERTIFICATE =? WHERE FORM_REFERENCE_NUMBER =?");
                SQLiteStatement sQLiteStatementCompileStatement = writableDatabase.compileStatement("UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =? , DISABILITY_CERTIFICATE =? WHERE FORM_REFERENCE_NUMBER =?");
                sQLiteStatementCompileStatement.clearBindings();
                sQLiteStatementCompileStatement.bindString(1, String.valueOf(seq));
                sQLiteStatementCompileStatement.bindString(2, application);
                sQLiteStatementCompileStatement.bindString(3, img);
                sQLiteStatementCompileStatement.bindString(4, referenceNumber);
                sQLiteStatementCompileStatement.execute();
                writableDatabase.close();
                return;
            } catch (SQLException e) {
                Logger.d(CONTENT, e.getMessage());
                return;
            }
        }
        try {
            Logger.e("TAG", "UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =? WHERE FORM_REFERENCE_NUMBER =?");
            SQLiteStatement sQLiteStatementCompileStatement2 = writableDatabase.compileStatement("UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =? WHERE FORM_REFERENCE_NUMBER =?");
            sQLiteStatementCompileStatement2.clearBindings();
            sQLiteStatementCompileStatement2.bindString(1, String.valueOf(seq));
            sQLiteStatementCompileStatement2.bindString(2, application);
            sQLiteStatementCompileStatement2.bindString(3, referenceNumber);
            sQLiteStatementCompileStatement2.execute();
            writableDatabase.close();
        } catch (SQLException e2) {
            Logger.d(CONTENT, e2.getMessage());
        }
    }

    public void updateapplicationCOE(String referenceNumber, String application, int seq, boolean cb1, boolean cb2, boolean cb3, boolean cb4, boolean cb5, boolean cb6, boolean cb7, boolean cb8, String img1, String img2, String img3, String img4, String img5, String img6, String img8) {
        SQLiteDatabase writableDatabase = this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY);
        if (cb1) {
            try {
                Logger.e("TAG", "UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =?, CORRECT_NAME_DOC =? WHERE FORM_REFERENCE_NUMBER =?");
                SQLiteStatement sQLiteStatementCompileStatement = writableDatabase.compileStatement("UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =?, CORRECT_NAME_DOC =? WHERE FORM_REFERENCE_NUMBER =?");
                sQLiteStatementCompileStatement.clearBindings();
                sQLiteStatementCompileStatement.bindString(1, String.valueOf(seq));
                sQLiteStatementCompileStatement.bindString(2, application);
                sQLiteStatementCompileStatement.bindString(3, img1);
                sQLiteStatementCompileStatement.bindString(4, referenceNumber);
                sQLiteStatementCompileStatement.execute();
            } catch (SQLException e) {
                Logger.d(CONTENT, e.getMessage());
            }
        }
        if (cb2) {
            try {
                Logger.e("TAG", "UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =?, CORRECT_GENDER_DOC =? WHERE FORM_REFERENCE_NUMBER =?");
                SQLiteStatement sQLiteStatementCompileStatement2 = writableDatabase.compileStatement("UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =?, CORRECT_GENDER_DOC =? WHERE FORM_REFERENCE_NUMBER =?");
                sQLiteStatementCompileStatement2.clearBindings();
                sQLiteStatementCompileStatement2.bindString(1, String.valueOf(seq));
                sQLiteStatementCompileStatement2.bindString(2, application);
                sQLiteStatementCompileStatement2.bindString(3, img2);
                sQLiteStatementCompileStatement2.bindString(4, referenceNumber);
                sQLiteStatementCompileStatement2.execute();
            } catch (SQLException e2) {
                Logger.d(CONTENT, e2.getMessage());
            }
        }
        if (cb3) {
            try {
                Logger.e("TAG", "UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =?, CORRECT_DOB_DOC =? WHERE FORM_REFERENCE_NUMBER =?");
                SQLiteStatement sQLiteStatementCompileStatement3 = writableDatabase.compileStatement("UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =?, CORRECT_DOB_DOC =? WHERE FORM_REFERENCE_NUMBER =?");
                sQLiteStatementCompileStatement3.clearBindings();
                sQLiteStatementCompileStatement3.bindString(1, String.valueOf(seq));
                sQLiteStatementCompileStatement3.bindString(2, application);
                sQLiteStatementCompileStatement3.bindString(3, img3);
                sQLiteStatementCompileStatement3.bindString(4, referenceNumber);
                sQLiteStatementCompileStatement3.execute();
            } catch (SQLException e3) {
                Logger.d(CONTENT, e3.getMessage());
            }
        }
        if (cb4) {
            try {
                Logger.e("TAG", "UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =?, CORRECT_RELATIVE_TYPE_DOC =? WHERE FORM_REFERENCE_NUMBER =?");
                SQLiteStatement sQLiteStatementCompileStatement4 = writableDatabase.compileStatement("UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =?, CORRECT_RELATIVE_TYPE_DOC =? WHERE FORM_REFERENCE_NUMBER =?");
                sQLiteStatementCompileStatement4.clearBindings();
                sQLiteStatementCompileStatement4.bindString(1, String.valueOf(seq));
                sQLiteStatementCompileStatement4.bindString(2, application);
                sQLiteStatementCompileStatement4.bindString(3, img4);
                sQLiteStatementCompileStatement4.bindString(4, referenceNumber);
                sQLiteStatementCompileStatement4.execute();
            } catch (SQLException e4) {
                Logger.d(CONTENT, e4.getMessage());
            }
        }
        if (cb5) {
            try {
                Logger.e("TAG", "UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =?, CORRECT_RELATIVE_NAME_DOC =? WHERE FORM_REFERENCE_NUMBER =?");
                SQLiteStatement sQLiteStatementCompileStatement5 = writableDatabase.compileStatement("UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =?, CORRECT_RELATIVE_NAME_DOC =? WHERE FORM_REFERENCE_NUMBER =?");
                sQLiteStatementCompileStatement5.clearBindings();
                sQLiteStatementCompileStatement5.bindString(1, String.valueOf(seq));
                sQLiteStatementCompileStatement5.bindString(2, application);
                sQLiteStatementCompileStatement5.bindString(3, img5);
                sQLiteStatementCompileStatement5.bindString(4, referenceNumber);
                sQLiteStatementCompileStatement5.execute();
            } catch (SQLException e5) {
                Logger.d(CONTENT, e5.getMessage());
            }
        }
        if (cb6) {
            try {
                Logger.e("TAG", "UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =?, CORRECT_ADDRESS_DOC =? WHERE FORM_REFERENCE_NUMBER =?");
                SQLiteStatement sQLiteStatementCompileStatement6 = writableDatabase.compileStatement("UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =?, CORRECT_ADDRESS_DOC =? WHERE FORM_REFERENCE_NUMBER =?");
                sQLiteStatementCompileStatement6.clearBindings();
                sQLiteStatementCompileStatement6.bindString(1, String.valueOf(seq));
                sQLiteStatementCompileStatement6.bindString(2, application);
                sQLiteStatementCompileStatement6.bindString(3, img6);
                sQLiteStatementCompileStatement6.bindString(4, referenceNumber);
                sQLiteStatementCompileStatement6.execute();
            } catch (SQLException e6) {
                Logger.d(CONTENT, e6.getMessage());
            }
        }
        if (cb7) {
            try {
                Logger.e("TAG", "UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =? WHERE FORM_REFERENCE_NUMBER =?");
                SQLiteStatement sQLiteStatementCompileStatement7 = writableDatabase.compileStatement("UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =? WHERE FORM_REFERENCE_NUMBER =?");
                sQLiteStatementCompileStatement7.clearBindings();
                sQLiteStatementCompileStatement7.bindString(1, String.valueOf(seq));
                sQLiteStatementCompileStatement7.bindString(2, application);
                sQLiteStatementCompileStatement7.bindString(3, referenceNumber);
                sQLiteStatementCompileStatement7.execute();
            } catch (SQLException e7) {
                Logger.d(CONTENT, e7.getMessage());
            }
        }
        if (cb8) {
            try {
                Logger.e("TAG", "UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =?, PHOTOGRAPH =? WHERE FORM_REFERENCE_NUMBER =?");
                SQLiteStatement sQLiteStatementCompileStatement8 = writableDatabase.compileStatement("UPDATE DRAFT_FORMS SET STEP_SEQUENCE =?, TYPE_OF_APPLICATION =?, PHOTOGRAPH =? WHERE FORM_REFERENCE_NUMBER =?");
                sQLiteStatementCompileStatement8.clearBindings();
                sQLiteStatementCompileStatement8.bindString(1, String.valueOf(seq));
                sQLiteStatementCompileStatement8.bindString(2, application);
                sQLiteStatementCompileStatement8.bindString(3, img8);
                sQLiteStatementCompileStatement8.bindString(4, referenceNumber);
                sQLiteStatementCompileStatement8.execute();
            } catch (SQLException e8) {
                Logger.d(CONTENT, e8.getMessage());
            }
        }
    }

    public LiveData<List<FormsinDraftMigrationModel>> dataoneditbutton(String name, String date, String formtype) {
        this.dataList.clear();
        String str = "SELECT STATE_DETAILS,PERSONAL_DETAILS,TYPE_OF_APPLICATION,STEP_SEQUENCE,FORM_REFERENCE_NUMBER,PASSPORT_PDF,CORRECT_NAME_DOC,CORRECT_GENDER_DOC,CORRECT_DOB_DOC,CORRECT_RELATIVE_TYPE_DOC,CORRECT_RELATIVE_NAME_DOC,CORRECT_ADDRESS_DOC,PHOTOGRAPH,LOST_FIR,DISABILITY_CERTIFICATE,CitizenshipType,CitizenshipTypeCat,CtDocTypeForSelf,CtDocOfSelfUrl,DoctypeselfFileName,DoctypeselFileSize,Before2004ParentType,DoctypeFather,DoctypeMother,DocURLFather,DocURLMother,Before2004docFileName,Before2004docFileSize,After2004isParentIndian,After2004ParentNameNotindian,After2004doctypeFather,After2004doctypeMother,After2004docURLFather,After2004docURLMother,After2004MotherFileName,After2004MotherFileSize,After2004FatherFileName,After2004FatherFileSize,BornOutofIndiadoctype,BornOutofIndiadocURL,BornOutofIndiaFileName,BornOutofIndiaFileSize,CitizenAquuireddoctype,CitizenAquuireddocURL,CitizenAquuiredFileName,CitizenAquuiredFileSize,AnnexureSignURL,AnexSignFileName,AnexSignFileSize,IsOtherState,DeclarationForm FROM DRAFT_FORMS WHERE FORM_TYPE  = '" + formtype + "' and NAME='" + name + "' and CREATED_ON='" + date + "'";
        Logger.e("TAG", str);
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery(str, (String[]) null);
        if (cursorRawQuery.getCount() > 0) {
            cursorRawQuery.moveToFirst();
            for (int i = 0; i < cursorRawQuery.getCount(); i++) {
                this.dataList.add(new FormsinDraftMigrationModel(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("STATE_DETAILS")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PERSONAL_DETAILS")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("TYPE_OF_APPLICATION")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("STEP_SEQUENCE")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("FORM_REFERENCE_NUMBER")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PASSPORT_PDF")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CORRECT_NAME_DOC")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CORRECT_GENDER_DOC")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CORRECT_DOB_DOC")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CORRECT_RELATIVE_TYPE_DOC")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CORRECT_RELATIVE_NAME_DOC")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CORRECT_ADDRESS_DOC")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("PHOTOGRAPH")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("LOST_FIR")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DISABILITY_CERTIFICATE")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CitizenshipType")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CitizenshipTypeCat")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CtDocTypeForSelf")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CtDocOfSelfUrl")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DoctypeselfFileName")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DoctypeselFileSize")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("Before2004ParentType")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DoctypeFather")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DoctypeMother")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DocURLFather")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DocURLMother")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("Before2004docFileName")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("Before2004docFileSize")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("After2004isParentIndian")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("After2004ParentNameNotindian")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("After2004doctypeFather")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("After2004doctypeMother")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("After2004docURLFather")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("After2004docURLMother")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("After2004MotherFileName")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("After2004MotherFileSize")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("After2004FatherFileName")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("After2004FatherFileSize")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BornOutofIndiadoctype")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BornOutofIndiadocURL")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BornOutofIndiaFileName")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("BornOutofIndiaFileSize")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CitizenAquuireddoctype")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CitizenAquuireddocURL")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CitizenAquuiredFileName")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("CitizenAquuiredFileSize")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("AnnexureSignURL")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("AnexSignFileName")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("AnexSignFileSize")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("IsOtherState")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("DeclarationForm"))));
                this._data.postValue(this.dataList);
                cursorRawQuery.moveToNext();
            }
            this._data.postValue(this.dataList);
        }
        return this.data;
    }

    public void updateAnnexureD(String referencenumber, String citizenshipType, String citizenshipTypeCat, String ctDocTypeForSelf, String ctDocOfSelfUrl, int stepSeqence, String doctypeselfFileName, String doctypeselFileSize, String before2004ParentType, String doctypeFather, String doctypeMother, String docURLFather, String docURLMother, String before2004docFileName, String before2004docFileSize, String after2004isParentIndian, String after2004ParentNameNotindian, String after2004doctypeFather, String after2004doctypeMother, String after2004docURLFather, String after2004docURLMother, String after2004MotherFileName, String after2004MotherFileSize, String after2004FatherFileName, String after2004FatherFileSize, String bornOutofIndiadoctype, String bornOutofIndiadocURL, String bornOutofIndiaFileName, String bornOutofIndiaFileSize, String citizenAquuireddoctype, String citizenAquuireddocURL, String citizenAquuiredFileName, String citizenAquuiredFileSize, String annexuresignatureURL, String anexSignFileName, String anexSignFileSize, String isOtherState) {
        this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL("Update DRAFT_FORMS set CitizenshipType='" + citizenshipType + "',IsOtherState='" + isOtherState + "',AnexSignFileSize='" + anexSignFileSize + "',AnexSignFileName='" + anexSignFileName + "',AnnexureSignURL='" + annexuresignatureURL + "',CitizenAquuiredFileSize='" + citizenAquuiredFileSize + "',CitizenAquuiredFileName='" + citizenAquuiredFileName + "',CitizenAquuireddocURL='" + citizenAquuireddocURL + "',CitizenAquuireddoctype='" + citizenAquuireddoctype + "',BornOutofIndiaFileSize='" + bornOutofIndiaFileSize + "',BornOutofIndiaFileSize='" + bornOutofIndiaFileName + "',BornOutofIndiaFileName='" + bornOutofIndiaFileName + "',BornOutofIndiadocURL='" + bornOutofIndiadocURL + "',BornOutofIndiadoctype='" + bornOutofIndiadoctype + "',After2004FatherFileSize='" + after2004FatherFileSize + "',After2004FatherFileName='" + after2004FatherFileName + "',After2004MotherFileSize='" + after2004MotherFileSize + "',After2004MotherFileName='" + after2004MotherFileName + "',After2004docURLMother='" + after2004docURLMother + "',After2004docURLFather='" + after2004docURLFather + "',After2004doctypeMother='" + after2004doctypeMother + "',After2004doctypeFather='" + after2004doctypeFather + "',After2004ParentNameNotindian='" + after2004ParentNameNotindian + "',After2004isParentIndian='" + after2004isParentIndian + "',Before2004docFileSize='" + before2004docFileSize + "',Before2004docFileName='" + before2004docFileName + "',DocURLMother='" + docURLMother + "',DocURLFather='" + docURLFather + "',DoctypeMother='" + doctypeMother + "',DoctypeFather='" + doctypeFather + "',Before2004ParentType='" + before2004ParentType + "',CitizenshipTypeCat='" + citizenshipTypeCat + "',CtDocTypeForSelf='" + ctDocTypeForSelf + "',CtDocOfSelfUrl='" + ctDocOfSelfUrl + "',DoctypeselfFileName='" + doctypeselfFileName + "',DoctypeselFileSize='" + doctypeselFileSize + "',STEP_SEQUENCE='" + stepSeqence + "' where FORM_REFERENCE_NUMBER='" + referencenumber + "'");
    }

    public void updateDeclarationForm(String declarationForm, String referencenumber, int i) {
        this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL("Update DRAFT_FORMS set DeclarationForm='" + declarationForm + "',STEP_SEQUENCE='" + i + "' where FORM_REFERENCE_NUMBER='" + referencenumber + "'");
    }
}
