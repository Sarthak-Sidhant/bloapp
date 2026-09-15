package in.gov.eci.bloapp.room.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import in.gov.eci.bloapp.model.ElectroleDeatils.H2HElectorDetailModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class H2HElectorDetailModelDao_Impl implements H2HElectorDetailModelDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<H2HElectorDetailModel> __insertAdapterOfH2HElectorDetailModel = new EntityInsertAdapter<H2HElectorDetailModel>() { // from class: in.gov.eci.bloapp.room.dao.H2HElectorDetailModelDao_Impl.1
        protected String createQuery() {
            return "INSERT OR IGNORE INTO `H2H_ELECTOR_DETAILS` (`epicNo`,`applicantName`,`mobileNo`,`gender`,`email`,`aadharNo`,`dob`,`age`,`relativeName`,`relativeType`,`houseNo`,`village`,`postOffice`,`acNo`,`localitySreet`,`address`,`pinCode`,`partNo`,`stateCode`,`coordinate`,`residingPeriod`,`houseApplicantFound`,`isAadharVerified`,`isElectorRecordSame`,`allDetailsVerified`,`isAddressRecordSame`,`isDobRecordSame`,`photographEleIsCorrect`,`disabilityType`,`isVisual`,`sectionNo`,`isPwd`,`isDeaf`,`pwdPercentage`,`isLocomotive`,`otherDisability`,`metInPerson`,`phoneNumberVerified`,`dateOfVerification`,`addressAttachment`,`dobAttachment`,`misDocument`,`remarks`,`sectionName`,`applicantNameRegional`,`partSerialNumber`,`relativeNameRegional`,`photo`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final H2HElectorDetailModel entity) {
            if (entity.getEpicNo() == null) {
                statement.bindNull(1);
            } else {
                statement.bindText(1, entity.getEpicNo());
            }
            if (entity.getApplicantName() == null) {
                statement.bindNull(2);
            } else {
                statement.bindText(2, entity.getApplicantName());
            }
            if (entity.getMobileNo() == null) {
                statement.bindNull(3);
            } else {
                statement.bindText(3, entity.getMobileNo());
            }
            if (entity.getGender() == null) {
                statement.bindNull(4);
            } else {
                statement.bindText(4, entity.getGender());
            }
            if (entity.getEmail() == null) {
                statement.bindNull(5);
            } else {
                statement.bindText(5, entity.getEmail());
            }
            if (entity.getAadharNo() == null) {
                statement.bindNull(6);
            } else {
                statement.bindText(6, entity.getAadharNo());
            }
            if (entity.getDob() == null) {
                statement.bindNull(7);
            } else {
                statement.bindText(7, entity.getDob());
            }
            if (entity.getAge() == null) {
                statement.bindNull(8);
            } else {
                statement.bindText(8, entity.getAge());
            }
            if (entity.getRelativeName() == null) {
                statement.bindNull(9);
            } else {
                statement.bindText(9, entity.getRelativeName());
            }
            if (entity.getRelativeType() == null) {
                statement.bindNull(10);
            } else {
                statement.bindText(10, entity.getRelativeType());
            }
            if (entity.getHouseNo() == null) {
                statement.bindNull(11);
            } else {
                statement.bindText(11, entity.getHouseNo());
            }
            if (entity.getVillage() == null) {
                statement.bindNull(12);
            } else {
                statement.bindText(12, entity.getVillage());
            }
            if (entity.getPostOffice() == null) {
                statement.bindNull(13);
            } else {
                statement.bindText(13, entity.getPostOffice());
            }
            if (entity.getAcNo() == null) {
                statement.bindNull(14);
            } else {
                statement.bindText(14, entity.getAcNo());
            }
            if (entity.getLocalitySreet() == null) {
                statement.bindNull(15);
            } else {
                statement.bindText(15, entity.getLocalitySreet());
            }
            if (entity.getAddress() == null) {
                statement.bindNull(16);
            } else {
                statement.bindText(16, entity.getAddress());
            }
            if (entity.getPinCode() == null) {
                statement.bindNull(17);
            } else {
                statement.bindText(17, entity.getPinCode());
            }
            if (entity.getPartNo() == null) {
                statement.bindNull(18);
            } else {
                statement.bindText(18, entity.getPartNo());
            }
            if (entity.getStateCode() == null) {
                statement.bindNull(19);
            } else {
                statement.bindText(19, entity.getStateCode());
            }
            if (entity.getCoordinate() == null) {
                statement.bindNull(20);
            } else {
                statement.bindText(20, entity.getCoordinate());
            }
            if (entity.getResidingPeriod() == null) {
                statement.bindNull(21);
            } else {
                statement.bindText(21, entity.getResidingPeriod());
            }
            if (entity.getHouseApplicantFound() == null) {
                statement.bindNull(22);
            } else {
                statement.bindText(22, entity.getHouseApplicantFound());
            }
            if (entity.getIsAadharVerified() == null) {
                statement.bindNull(23);
            } else {
                statement.bindText(23, entity.getIsAadharVerified());
            }
            if (entity.getIsElectorRecordSame() == null) {
                statement.bindNull(24);
            } else {
                statement.bindText(24, entity.getIsElectorRecordSame());
            }
            if (entity.getAllDetailsVerified() == null) {
                statement.bindNull(25);
            } else {
                statement.bindText(25, entity.getAllDetailsVerified());
            }
            if (entity.getIsAddressRecordSame() == null) {
                statement.bindNull(26);
            } else {
                statement.bindText(26, entity.getIsAddressRecordSame());
            }
            if (entity.getIsDobRecordSame() == null) {
                statement.bindNull(27);
            } else {
                statement.bindText(27, entity.getIsDobRecordSame());
            }
            if (entity.getPhotographEleIsCorrect() == null) {
                statement.bindNull(28);
            } else {
                statement.bindText(28, entity.getPhotographEleIsCorrect());
            }
            if (entity.getDisabilityType() == null) {
                statement.bindNull(29);
            } else {
                statement.bindText(29, entity.getDisabilityType());
            }
            if (entity.getIsVisual() == null) {
                statement.bindNull(30);
            } else {
                statement.bindText(30, entity.getIsVisual());
            }
            if (entity.getSectionNo() == null) {
                statement.bindNull(31);
            } else {
                statement.bindText(31, entity.getSectionNo());
            }
            if (entity.getIsPwd() == null) {
                statement.bindNull(32);
            } else {
                statement.bindText(32, entity.getIsPwd());
            }
            if (entity.getIsDeaf() == null) {
                statement.bindNull(33);
            } else {
                statement.bindText(33, entity.getIsDeaf());
            }
            if (entity.getPwdPercentage() == null) {
                statement.bindNull(34);
            } else {
                statement.bindText(34, entity.getPwdPercentage());
            }
            if (entity.getIsLocomotive() == null) {
                statement.bindNull(35);
            } else {
                statement.bindText(35, entity.getIsLocomotive());
            }
            if (entity.getOtherDisability() == null) {
                statement.bindNull(36);
            } else {
                statement.bindText(36, entity.getOtherDisability());
            }
            statement.bindLong(37, entity.getIsMetElector());
            if (entity.getPhoneNumberVerified() == null) {
                statement.bindNull(38);
            } else {
                statement.bindText(38, entity.getPhoneNumberVerified());
            }
            if (entity.getDateOfVerification() == null) {
                statement.bindNull(39);
            } else {
                statement.bindText(39, entity.getDateOfVerification());
            }
            if (entity.getAddressAttachment() == null) {
                statement.bindNull(40);
            } else {
                statement.bindText(40, entity.getAddressAttachment());
            }
            if (entity.getDobAttachment() == null) {
                statement.bindNull(41);
            } else {
                statement.bindText(41, entity.getDobAttachment());
            }
            if (entity.getMisDocument() == null) {
                statement.bindNull(42);
            } else {
                statement.bindText(42, entity.getMisDocument());
            }
            if (entity.getRemarks() == null) {
                statement.bindNull(43);
            } else {
                statement.bindText(43, entity.getRemarks());
            }
            if (entity.getSectionName() == null) {
                statement.bindNull(44);
            } else {
                statement.bindText(44, entity.getSectionName());
            }
            if (entity.getApplicantNameRegional() == null) {
                statement.bindNull(45);
            } else {
                statement.bindText(45, entity.getApplicantNameRegional());
            }
            if (entity.getPartSerialNumber() == null) {
                statement.bindNull(46);
            } else {
                statement.bindText(46, entity.getPartSerialNumber());
            }
            if (entity.getRelativeNameRegional() == null) {
                statement.bindNull(47);
            } else {
                statement.bindText(47, entity.getRelativeNameRegional());
            }
            if (entity.getPhoto() == null) {
                statement.bindNull(48);
            } else {
                statement.bindText(48, entity.getPhoto());
            }
        }
    };
    private final EntityDeleteOrUpdateAdapter<H2HElectorDetailModel> __deleteAdapterOfH2HElectorDetailModel = new EntityDeleteOrUpdateAdapter<H2HElectorDetailModel>() { // from class: in.gov.eci.bloapp.room.dao.H2HElectorDetailModelDao_Impl.2
        protected String createQuery() {
            return "DELETE FROM `H2H_ELECTOR_DETAILS` WHERE `epicNo` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final H2HElectorDetailModel entity) {
            if (entity.getEpicNo() == null) {
                statement.bindNull(1);
            } else {
                statement.bindText(1, entity.getEpicNo());
            }
        }
    };
    private final EntityDeleteOrUpdateAdapter<H2HElectorDetailModel> __updateAdapterOfH2HElectorDetailModel = new EntityDeleteOrUpdateAdapter<H2HElectorDetailModel>() { // from class: in.gov.eci.bloapp.room.dao.H2HElectorDetailModelDao_Impl.3
        protected String createQuery() {
            return "UPDATE OR ABORT `H2H_ELECTOR_DETAILS` SET `epicNo` = ?,`applicantName` = ?,`mobileNo` = ?,`gender` = ?,`email` = ?,`aadharNo` = ?,`dob` = ?,`age` = ?,`relativeName` = ?,`relativeType` = ?,`houseNo` = ?,`village` = ?,`postOffice` = ?,`acNo` = ?,`localitySreet` = ?,`address` = ?,`pinCode` = ?,`partNo` = ?,`stateCode` = ?,`coordinate` = ?,`residingPeriod` = ?,`houseApplicantFound` = ?,`isAadharVerified` = ?,`isElectorRecordSame` = ?,`allDetailsVerified` = ?,`isAddressRecordSame` = ?,`isDobRecordSame` = ?,`photographEleIsCorrect` = ?,`disabilityType` = ?,`isVisual` = ?,`sectionNo` = ?,`isPwd` = ?,`isDeaf` = ?,`pwdPercentage` = ?,`isLocomotive` = ?,`otherDisability` = ?,`metInPerson` = ?,`phoneNumberVerified` = ?,`dateOfVerification` = ?,`addressAttachment` = ?,`dobAttachment` = ?,`misDocument` = ?,`remarks` = ?,`sectionName` = ?,`applicantNameRegional` = ?,`partSerialNumber` = ?,`relativeNameRegional` = ?,`photo` = ? WHERE `epicNo` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final H2HElectorDetailModel entity) {
            if (entity.getEpicNo() == null) {
                statement.bindNull(1);
            } else {
                statement.bindText(1, entity.getEpicNo());
            }
            if (entity.getApplicantName() == null) {
                statement.bindNull(2);
            } else {
                statement.bindText(2, entity.getApplicantName());
            }
            if (entity.getMobileNo() == null) {
                statement.bindNull(3);
            } else {
                statement.bindText(3, entity.getMobileNo());
            }
            if (entity.getGender() == null) {
                statement.bindNull(4);
            } else {
                statement.bindText(4, entity.getGender());
            }
            if (entity.getEmail() == null) {
                statement.bindNull(5);
            } else {
                statement.bindText(5, entity.getEmail());
            }
            if (entity.getAadharNo() == null) {
                statement.bindNull(6);
            } else {
                statement.bindText(6, entity.getAadharNo());
            }
            if (entity.getDob() == null) {
                statement.bindNull(7);
            } else {
                statement.bindText(7, entity.getDob());
            }
            if (entity.getAge() == null) {
                statement.bindNull(8);
            } else {
                statement.bindText(8, entity.getAge());
            }
            if (entity.getRelativeName() == null) {
                statement.bindNull(9);
            } else {
                statement.bindText(9, entity.getRelativeName());
            }
            if (entity.getRelativeType() == null) {
                statement.bindNull(10);
            } else {
                statement.bindText(10, entity.getRelativeType());
            }
            if (entity.getHouseNo() == null) {
                statement.bindNull(11);
            } else {
                statement.bindText(11, entity.getHouseNo());
            }
            if (entity.getVillage() == null) {
                statement.bindNull(12);
            } else {
                statement.bindText(12, entity.getVillage());
            }
            if (entity.getPostOffice() == null) {
                statement.bindNull(13);
            } else {
                statement.bindText(13, entity.getPostOffice());
            }
            if (entity.getAcNo() == null) {
                statement.bindNull(14);
            } else {
                statement.bindText(14, entity.getAcNo());
            }
            if (entity.getLocalitySreet() == null) {
                statement.bindNull(15);
            } else {
                statement.bindText(15, entity.getLocalitySreet());
            }
            if (entity.getAddress() == null) {
                statement.bindNull(16);
            } else {
                statement.bindText(16, entity.getAddress());
            }
            if (entity.getPinCode() == null) {
                statement.bindNull(17);
            } else {
                statement.bindText(17, entity.getPinCode());
            }
            if (entity.getPartNo() == null) {
                statement.bindNull(18);
            } else {
                statement.bindText(18, entity.getPartNo());
            }
            if (entity.getStateCode() == null) {
                statement.bindNull(19);
            } else {
                statement.bindText(19, entity.getStateCode());
            }
            if (entity.getCoordinate() == null) {
                statement.bindNull(20);
            } else {
                statement.bindText(20, entity.getCoordinate());
            }
            if (entity.getResidingPeriod() == null) {
                statement.bindNull(21);
            } else {
                statement.bindText(21, entity.getResidingPeriod());
            }
            if (entity.getHouseApplicantFound() == null) {
                statement.bindNull(22);
            } else {
                statement.bindText(22, entity.getHouseApplicantFound());
            }
            if (entity.getIsAadharVerified() == null) {
                statement.bindNull(23);
            } else {
                statement.bindText(23, entity.getIsAadharVerified());
            }
            if (entity.getIsElectorRecordSame() == null) {
                statement.bindNull(24);
            } else {
                statement.bindText(24, entity.getIsElectorRecordSame());
            }
            if (entity.getAllDetailsVerified() == null) {
                statement.bindNull(25);
            } else {
                statement.bindText(25, entity.getAllDetailsVerified());
            }
            if (entity.getIsAddressRecordSame() == null) {
                statement.bindNull(26);
            } else {
                statement.bindText(26, entity.getIsAddressRecordSame());
            }
            if (entity.getIsDobRecordSame() == null) {
                statement.bindNull(27);
            } else {
                statement.bindText(27, entity.getIsDobRecordSame());
            }
            if (entity.getPhotographEleIsCorrect() == null) {
                statement.bindNull(28);
            } else {
                statement.bindText(28, entity.getPhotographEleIsCorrect());
            }
            if (entity.getDisabilityType() == null) {
                statement.bindNull(29);
            } else {
                statement.bindText(29, entity.getDisabilityType());
            }
            if (entity.getIsVisual() == null) {
                statement.bindNull(30);
            } else {
                statement.bindText(30, entity.getIsVisual());
            }
            if (entity.getSectionNo() == null) {
                statement.bindNull(31);
            } else {
                statement.bindText(31, entity.getSectionNo());
            }
            if (entity.getIsPwd() == null) {
                statement.bindNull(32);
            } else {
                statement.bindText(32, entity.getIsPwd());
            }
            if (entity.getIsDeaf() == null) {
                statement.bindNull(33);
            } else {
                statement.bindText(33, entity.getIsDeaf());
            }
            if (entity.getPwdPercentage() == null) {
                statement.bindNull(34);
            } else {
                statement.bindText(34, entity.getPwdPercentage());
            }
            if (entity.getIsLocomotive() == null) {
                statement.bindNull(35);
            } else {
                statement.bindText(35, entity.getIsLocomotive());
            }
            if (entity.getOtherDisability() == null) {
                statement.bindNull(36);
            } else {
                statement.bindText(36, entity.getOtherDisability());
            }
            statement.bindLong(37, entity.getIsMetElector());
            if (entity.getPhoneNumberVerified() == null) {
                statement.bindNull(38);
            } else {
                statement.bindText(38, entity.getPhoneNumberVerified());
            }
            if (entity.getDateOfVerification() == null) {
                statement.bindNull(39);
            } else {
                statement.bindText(39, entity.getDateOfVerification());
            }
            if (entity.getAddressAttachment() == null) {
                statement.bindNull(40);
            } else {
                statement.bindText(40, entity.getAddressAttachment());
            }
            if (entity.getDobAttachment() == null) {
                statement.bindNull(41);
            } else {
                statement.bindText(41, entity.getDobAttachment());
            }
            if (entity.getMisDocument() == null) {
                statement.bindNull(42);
            } else {
                statement.bindText(42, entity.getMisDocument());
            }
            if (entity.getRemarks() == null) {
                statement.bindNull(43);
            } else {
                statement.bindText(43, entity.getRemarks());
            }
            if (entity.getSectionName() == null) {
                statement.bindNull(44);
            } else {
                statement.bindText(44, entity.getSectionName());
            }
            if (entity.getApplicantNameRegional() == null) {
                statement.bindNull(45);
            } else {
                statement.bindText(45, entity.getApplicantNameRegional());
            }
            if (entity.getPartSerialNumber() == null) {
                statement.bindNull(46);
            } else {
                statement.bindText(46, entity.getPartSerialNumber());
            }
            if (entity.getRelativeNameRegional() == null) {
                statement.bindNull(47);
            } else {
                statement.bindText(47, entity.getRelativeNameRegional());
            }
            if (entity.getPhoto() == null) {
                statement.bindNull(48);
            } else {
                statement.bindText(48, entity.getPhoto());
            }
            if (entity.getEpicNo() == null) {
                statement.bindNull(49);
            } else {
                statement.bindText(49, entity.getEpicNo());
            }
        }
    };

    public H2HElectorDetailModelDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
    }

    @Override // in.gov.eci.bloapp.room.dao.H2HElectorDetailModelDao
    public void addH2HElecorDetails(final H2HElectorDetailModel h2HElectorDetailModel) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.H2HElectorDetailModelDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$addH2HElecorDetails$0(h2HElectorDetailModel, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$addH2HElecorDetails$0(H2HElectorDetailModel h2HElectorDetailModel, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfH2HElectorDetailModel.insert(sQLiteConnection, h2HElectorDetailModel);
        return null;
    }

    @Override // in.gov.eci.bloapp.room.dao.H2HElectorDetailModelDao
    public void deleteH2HElecorDetails(final H2HElectorDetailModel h2HElectorDetailModel) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.H2HElectorDetailModelDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$deleteH2HElecorDetails$1(h2HElectorDetailModel, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$deleteH2HElecorDetails$1(H2HElectorDetailModel h2HElectorDetailModel, SQLiteConnection sQLiteConnection) {
        this.__deleteAdapterOfH2HElectorDetailModel.handle(sQLiteConnection, h2HElectorDetailModel);
        return null;
    }

    @Override // in.gov.eci.bloapp.room.dao.H2HElectorDetailModelDao
    public void updateH2HElecorDetails(final H2HElectorDetailModel h2HElectorDetailModel) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.H2HElectorDetailModelDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$updateH2HElecorDetails$2(h2HElectorDetailModel, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$updateH2HElecorDetails$2(H2HElectorDetailModel h2HElectorDetailModel, SQLiteConnection sQLiteConnection) {
        this.__updateAdapterOfH2HElectorDetailModel.handle(sQLiteConnection, h2HElectorDetailModel);
        return null;
    }

    @Override // in.gov.eci.bloapp.room.dao.H2HElectorDetailModelDao
    public List<H2HElectorDetailModel> getH2HAllElectorDetails(final String partNumber) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.H2HElectorDetailModelDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return H2HElectorDetailModelDao_Impl.lambda$getH2HAllElectorDetails$3(partNumber, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getH2HAllElectorDetails$3(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select * from H2H_ELECTOR_DETAILS where partNo = ?");
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "epicNo");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "applicantName");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "mobileNo");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "gender");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "email");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "aadharNo");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dob");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "age");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "relativeName");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "relativeType");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "houseNo");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "village");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "postOffice");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "acNo");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "localitySreet");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "address");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "pinCode");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "partNo");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "stateCode");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "coordinate");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "residingPeriod");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "houseApplicantFound");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isAadharVerified");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isElectorRecordSame");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "allDetailsVerified");
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isAddressRecordSame");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isDobRecordSame");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "photographEleIsCorrect");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "disabilityType");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isVisual");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sectionNo");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPwd");
            int columnIndexOrThrow33 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isDeaf");
            int columnIndexOrThrow34 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "pwdPercentage");
            int columnIndexOrThrow35 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isLocomotive");
            int columnIndexOrThrow36 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "otherDisability");
            int columnIndexOrThrow37 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "metInPerson");
            int columnIndexOrThrow38 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "phoneNumberVerified");
            int columnIndexOrThrow39 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dateOfVerification");
            int columnIndexOrThrow40 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "addressAttachment");
            int columnIndexOrThrow41 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dobAttachment");
            int columnIndexOrThrow42 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "misDocument");
            int columnIndexOrThrow43 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "remarks");
            int columnIndexOrThrow44 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sectionName");
            int columnIndexOrThrow45 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "applicantNameRegional");
            int columnIndexOrThrow46 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "partSerialNumber");
            int columnIndexOrThrow47 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "relativeNameRegional");
            int columnIndexOrThrow48 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "photo");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.isNull(columnIndexOrThrow) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                String text8 = sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8);
                String text9 = sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9);
                String text10 = sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow10);
                String text11 = sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11);
                String text12 = sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12);
                String text13 = sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13);
                String text14 = sQLiteStatementPrepare.isNull(columnIndexOrThrow14) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow14);
                int i = columnIndexOrThrow;
                int i2 = columnIndexOrThrow15;
                String text15 = sQLiteStatementPrepare.isNull(i2) ? null : sQLiteStatementPrepare.getText(i2);
                columnIndexOrThrow16 = columnIndexOrThrow16;
                String text16 = sQLiteStatementPrepare.isNull(columnIndexOrThrow16) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow16);
                String text17 = sQLiteStatementPrepare.isNull(columnIndexOrThrow17) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow17);
                String text18 = sQLiteStatementPrepare.isNull(columnIndexOrThrow18) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow18);
                String text19 = sQLiteStatementPrepare.isNull(columnIndexOrThrow19) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow19);
                String text20 = sQLiteStatementPrepare.isNull(columnIndexOrThrow20) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow20);
                String text21 = sQLiteStatementPrepare.isNull(columnIndexOrThrow21) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow21);
                String text22 = sQLiteStatementPrepare.isNull(columnIndexOrThrow22) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow22);
                String text23 = sQLiteStatementPrepare.isNull(columnIndexOrThrow23) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow23);
                String text24 = sQLiteStatementPrepare.isNull(columnIndexOrThrow24) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow24);
                String text25 = sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow25);
                String text26 = sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26);
                String text27 = sQLiteStatementPrepare.isNull(columnIndexOrThrow27) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow27);
                String text28 = sQLiteStatementPrepare.isNull(columnIndexOrThrow28) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow28);
                String text29 = sQLiteStatementPrepare.isNull(columnIndexOrThrow29) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow29);
                String text30 = sQLiteStatementPrepare.isNull(columnIndexOrThrow30) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow30);
                String text31 = sQLiteStatementPrepare.isNull(columnIndexOrThrow31) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow31);
                String text32 = sQLiteStatementPrepare.isNull(columnIndexOrThrow32) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow32);
                String text33 = sQLiteStatementPrepare.isNull(columnIndexOrThrow33) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow33);
                String text34 = sQLiteStatementPrepare.isNull(columnIndexOrThrow34) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow34);
                String text35 = sQLiteStatementPrepare.isNull(columnIndexOrThrow35) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow35);
                String text36 = sQLiteStatementPrepare.isNull(columnIndexOrThrow36) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow36);
                int i3 = columnIndexOrThrow2;
                int i4 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow37);
                int i5 = columnIndexOrThrow38;
                String text37 = sQLiteStatementPrepare.isNull(i5) ? null : sQLiteStatementPrepare.getText(i5);
                String text38 = sQLiteStatementPrepare.isNull(columnIndexOrThrow39) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow39);
                String text39 = sQLiteStatementPrepare.isNull(columnIndexOrThrow40) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow40);
                String text40 = sQLiteStatementPrepare.isNull(columnIndexOrThrow41) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow41);
                String text41 = sQLiteStatementPrepare.isNull(columnIndexOrThrow42) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow42);
                String text42 = sQLiteStatementPrepare.isNull(columnIndexOrThrow43) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow43);
                String text43 = sQLiteStatementPrepare.isNull(columnIndexOrThrow44) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow44);
                String text44 = sQLiteStatementPrepare.isNull(columnIndexOrThrow45) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow45);
                String text45 = sQLiteStatementPrepare.isNull(columnIndexOrThrow46) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow46);
                String text46 = sQLiteStatementPrepare.isNull(columnIndexOrThrow47) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow47);
                String text47 = sQLiteStatementPrepare.isNull(columnIndexOrThrow48) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow48);
                columnIndexOrThrow48 = columnIndexOrThrow48;
                arrayList.add(new H2HElectorDetailModel(text, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13, text14, text15, text16, text17, text18, text19, text20, text21, text22, text23, text24, text25, text26, text27, text28, text29, text30, text31, text32, text33, text34, text35, text36, i4, text37, text38, text39, text40, text41, text42, text43, text44, text46, text47, text45));
                columnIndexOrThrow = i;
                columnIndexOrThrow2 = i3;
                columnIndexOrThrow37 = columnIndexOrThrow37;
                columnIndexOrThrow15 = i2;
                columnIndexOrThrow38 = i5;
                columnIndexOrThrow3 = columnIndexOrThrow3;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.H2HElectorDetailModelDao
    public void deleteH2HRecord(final String epicID) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.H2HElectorDetailModelDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return H2HElectorDetailModelDao_Impl.lambda$deleteH2HRecord$4(epicID, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ Object lambda$deleteH2HRecord$4(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("DELETE FROM H2H_ELECTOR_DETAILS WHERE epicNo = ?");
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return null;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
