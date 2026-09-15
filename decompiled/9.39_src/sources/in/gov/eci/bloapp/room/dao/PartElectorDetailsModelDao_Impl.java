package in.gov.eci.bloapp.room.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import in.gov.eci.bloapp.model.ElectroleDeatils.PartElectorDetailsModel;
import in.gov.eci.bloapp.model.app_model.HouseModel;
import in.gov.eci.bloapp.model.app_model.ViewFamilyMemberListModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class PartElectorDetailsModelDao_Impl implements PartElectorDetailsModelDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<PartElectorDetailsModel.Items> __insertAdapterOfItems = new EntityInsertAdapter<PartElectorDetailsModel.Items>() { // from class: in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao_Impl.1
        protected String createQuery() {
            return "INSERT OR IGNORE INTO `PART_ELECTOR_DETAILS` (`id`,`epicNo`,`houseNo`,`applicantName`,`applicantNameL1`,`gender`,`relativeName`,`relativeNameL1`,`relativeType`,`mobileNo`,`email`,`isElectorRecordSame`,`dob`,`dobAttachment`,`isDobRecordSame`,`addressAttachment`,`isAddressRecordSame`,`houseApplicantFound`,`allDetailsVerified`,`remarks`,`misDocument`,`dateOfVerification`,`coordinate`,`age`,`localitySreet`,`village`,`postOffice`,`pinCode`,`stateCode`,`acNo`,`partNo`,`photo`,`localitySreetL1`,`houseNoL1`,`postOfficeL1`,`villageL1`,`tehsilTalukaMandal`,`tehsilTalukaMandalL1`,`aadharNo`,`sectionNo`,`sectionName`,`pwd`,`disabilityPercentage`,`otherDisability`,`disabilityLocomotor`,`disabilitySpeechHearing`,`disabilityVisually`,`partSerialNumber`,`BLO_ID`,`MODIFIED_ON`,`LAST_SYNC_STATUS`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final PartElectorDetailsModel.Items entity) {
            statement.bindLong(1, entity.getId());
            if (entity.getEpicNo() == null) {
                statement.bindNull(2);
            } else {
                statement.bindText(2, entity.getEpicNo());
            }
            if (entity.getHouseNo() == null) {
                statement.bindNull(3);
            } else {
                statement.bindText(3, entity.getHouseNo());
            }
            if (entity.getApplicantName() == null) {
                statement.bindNull(4);
            } else {
                statement.bindText(4, entity.getApplicantName());
            }
            if (entity.getApplicantNameL1() == null) {
                statement.bindNull(5);
            } else {
                statement.bindText(5, entity.getApplicantNameL1());
            }
            if (entity.getGender() == null) {
                statement.bindNull(6);
            } else {
                statement.bindText(6, entity.getGender());
            }
            if (entity.getRelativeName() == null) {
                statement.bindNull(7);
            } else {
                statement.bindText(7, entity.getRelativeName());
            }
            if (entity.getRelativeNameL1() == null) {
                statement.bindNull(8);
            } else {
                statement.bindText(8, entity.getRelativeNameL1());
            }
            if (entity.getRelativeType() == null) {
                statement.bindNull(9);
            } else {
                statement.bindText(9, entity.getRelativeType());
            }
            if (entity.getMobileNo() == null) {
                statement.bindNull(10);
            } else {
                statement.bindText(10, entity.getMobileNo());
            }
            if (entity.getEmail() == null) {
                statement.bindNull(11);
            } else {
                statement.bindText(11, entity.getEmail());
            }
            if (entity.getIsElectorRecordSame() == null) {
                statement.bindNull(12);
            } else {
                statement.bindText(12, entity.getIsElectorRecordSame());
            }
            if (entity.getDob() == null) {
                statement.bindNull(13);
            } else {
                statement.bindText(13, entity.getDob());
            }
            if (entity.getDobAttachment() == null) {
                statement.bindNull(14);
            } else {
                statement.bindText(14, entity.getDobAttachment());
            }
            if (entity.getIsDobRecordSame() == null) {
                statement.bindNull(15);
            } else {
                statement.bindText(15, entity.getIsDobRecordSame());
            }
            if (entity.getAddressAttachment() == null) {
                statement.bindNull(16);
            } else {
                statement.bindText(16, entity.getAddressAttachment());
            }
            if (entity.getIsAddressRecordSame() == null) {
                statement.bindNull(17);
            } else {
                statement.bindText(17, entity.getIsAddressRecordSame());
            }
            if (entity.getHouseApplicantFound() == null) {
                statement.bindNull(18);
            } else {
                statement.bindText(18, entity.getHouseApplicantFound());
            }
            if (entity.getAllDetailsVerified() == null) {
                statement.bindNull(19);
            } else {
                statement.bindText(19, entity.getAllDetailsVerified());
            }
            if (entity.getRemarks() == null) {
                statement.bindNull(20);
            } else {
                statement.bindText(20, entity.getRemarks());
            }
            if (entity.getMisDocument() == null) {
                statement.bindNull(21);
            } else {
                statement.bindText(21, entity.getMisDocument());
            }
            if (entity.getDateOfVerification() == null) {
                statement.bindNull(22);
            } else {
                statement.bindText(22, entity.getDateOfVerification());
            }
            if (entity.getCoordinate() == null) {
                statement.bindNull(23);
            } else {
                statement.bindText(23, entity.getCoordinate());
            }
            if (entity.getAge() == null) {
                statement.bindNull(24);
            } else {
                statement.bindText(24, entity.getAge());
            }
            if (entity.getLocalitySreet() == null) {
                statement.bindNull(25);
            } else {
                statement.bindText(25, entity.getLocalitySreet());
            }
            if (entity.getVillage() == null) {
                statement.bindNull(26);
            } else {
                statement.bindText(26, entity.getVillage());
            }
            if (entity.getPostOffice() == null) {
                statement.bindNull(27);
            } else {
                statement.bindText(27, entity.getPostOffice());
            }
            if (entity.getPinCode() == null) {
                statement.bindNull(28);
            } else {
                statement.bindText(28, entity.getPinCode());
            }
            if (entity.getStateCode() == null) {
                statement.bindNull(29);
            } else {
                statement.bindText(29, entity.getStateCode());
            }
            if (entity.getAcNo() == null) {
                statement.bindNull(30);
            } else {
                statement.bindText(30, entity.getAcNo());
            }
            if (entity.getPartNo() == null) {
                statement.bindNull(31);
            } else {
                statement.bindText(31, entity.getPartNo());
            }
            if (entity.getPhoto() == null) {
                statement.bindNull(32);
            } else {
                statement.bindText(32, entity.getPhoto());
            }
            if (entity.getLocalitySreetL1() == null) {
                statement.bindNull(33);
            } else {
                statement.bindText(33, entity.getLocalitySreetL1());
            }
            if (entity.getHouseNoL1() == null) {
                statement.bindNull(34);
            } else {
                statement.bindText(34, entity.getHouseNoL1());
            }
            if (entity.getPostOfficeL1() == null) {
                statement.bindNull(35);
            } else {
                statement.bindText(35, entity.getPostOfficeL1());
            }
            if (entity.getVillageL1() == null) {
                statement.bindNull(36);
            } else {
                statement.bindText(36, entity.getVillageL1());
            }
            if (entity.getTehsilTalukaMandal() == null) {
                statement.bindNull(37);
            } else {
                statement.bindText(37, entity.getTehsilTalukaMandal());
            }
            if (entity.getTehsilTalukaMandalL1() == null) {
                statement.bindNull(38);
            } else {
                statement.bindText(38, entity.getTehsilTalukaMandalL1());
            }
            if (entity.getAadharNo() == null) {
                statement.bindNull(39);
            } else {
                statement.bindText(39, entity.getAadharNo());
            }
            if (entity.getSectionNo() == null) {
                statement.bindNull(40);
            } else {
                statement.bindText(40, entity.getSectionNo());
            }
            if (entity.getSectionName() == null) {
                statement.bindNull(41);
            } else {
                statement.bindText(41, entity.getSectionName());
            }
            if (entity.getPwd() == null) {
                statement.bindNull(42);
            } else {
                statement.bindText(42, entity.getPwd());
            }
            if (entity.getDisabilityPercentage() == null) {
                statement.bindNull(43);
            } else {
                statement.bindText(43, entity.getDisabilityPercentage());
            }
            if (entity.getOtherDisability() == null) {
                statement.bindNull(44);
            } else {
                statement.bindText(44, entity.getOtherDisability());
            }
            if (entity.getDisabilityLocomotor() == null) {
                statement.bindNull(45);
            } else {
                statement.bindText(45, entity.getDisabilityLocomotor());
            }
            if (entity.getDisabilitySpeechHearing() == null) {
                statement.bindNull(46);
            } else {
                statement.bindText(46, entity.getDisabilitySpeechHearing());
            }
            if (entity.getDisabilityVisually() == null) {
                statement.bindNull(47);
            } else {
                statement.bindText(47, entity.getDisabilityVisually());
            }
            if (entity.getPartSerialNumber() == null) {
                statement.bindNull(48);
            } else {
                statement.bindText(48, entity.getPartSerialNumber());
            }
            if (entity.getBloId() == null) {
                statement.bindNull(49);
            } else {
                statement.bindText(49, entity.getBloId());
            }
            if (entity.getModifiedOn() == null) {
                statement.bindNull(50);
            } else {
                statement.bindText(50, entity.getModifiedOn());
            }
            if (entity.getLastSyncStatus() == null) {
                statement.bindNull(51);
            } else {
                statement.bindText(51, entity.getLastSyncStatus());
            }
        }
    };
    private final EntityDeleteOrUpdateAdapter<PartElectorDetailsModel.Items> __updateAdapterOfItems = new EntityDeleteOrUpdateAdapter<PartElectorDetailsModel.Items>() { // from class: in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao_Impl.2
        protected String createQuery() {
            return "UPDATE OR ABORT `PART_ELECTOR_DETAILS` SET `id` = ?,`epicNo` = ?,`houseNo` = ?,`applicantName` = ?,`applicantNameL1` = ?,`gender` = ?,`relativeName` = ?,`relativeNameL1` = ?,`relativeType` = ?,`mobileNo` = ?,`email` = ?,`isElectorRecordSame` = ?,`dob` = ?,`dobAttachment` = ?,`isDobRecordSame` = ?,`addressAttachment` = ?,`isAddressRecordSame` = ?,`houseApplicantFound` = ?,`allDetailsVerified` = ?,`remarks` = ?,`misDocument` = ?,`dateOfVerification` = ?,`coordinate` = ?,`age` = ?,`localitySreet` = ?,`village` = ?,`postOffice` = ?,`pinCode` = ?,`stateCode` = ?,`acNo` = ?,`partNo` = ?,`photo` = ?,`localitySreetL1` = ?,`houseNoL1` = ?,`postOfficeL1` = ?,`villageL1` = ?,`tehsilTalukaMandal` = ?,`tehsilTalukaMandalL1` = ?,`aadharNo` = ?,`sectionNo` = ?,`sectionName` = ?,`pwd` = ?,`disabilityPercentage` = ?,`otherDisability` = ?,`disabilityLocomotor` = ?,`disabilitySpeechHearing` = ?,`disabilityVisually` = ?,`partSerialNumber` = ?,`BLO_ID` = ?,`MODIFIED_ON` = ?,`LAST_SYNC_STATUS` = ? WHERE `epicNo` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void bind(final SQLiteStatement statement, final PartElectorDetailsModel.Items entity) {
            statement.bindLong(1, entity.getId());
            if (entity.getEpicNo() == null) {
                statement.bindNull(2);
            } else {
                statement.bindText(2, entity.getEpicNo());
            }
            if (entity.getHouseNo() == null) {
                statement.bindNull(3);
            } else {
                statement.bindText(3, entity.getHouseNo());
            }
            if (entity.getApplicantName() == null) {
                statement.bindNull(4);
            } else {
                statement.bindText(4, entity.getApplicantName());
            }
            if (entity.getApplicantNameL1() == null) {
                statement.bindNull(5);
            } else {
                statement.bindText(5, entity.getApplicantNameL1());
            }
            if (entity.getGender() == null) {
                statement.bindNull(6);
            } else {
                statement.bindText(6, entity.getGender());
            }
            if (entity.getRelativeName() == null) {
                statement.bindNull(7);
            } else {
                statement.bindText(7, entity.getRelativeName());
            }
            if (entity.getRelativeNameL1() == null) {
                statement.bindNull(8);
            } else {
                statement.bindText(8, entity.getRelativeNameL1());
            }
            if (entity.getRelativeType() == null) {
                statement.bindNull(9);
            } else {
                statement.bindText(9, entity.getRelativeType());
            }
            if (entity.getMobileNo() == null) {
                statement.bindNull(10);
            } else {
                statement.bindText(10, entity.getMobileNo());
            }
            if (entity.getEmail() == null) {
                statement.bindNull(11);
            } else {
                statement.bindText(11, entity.getEmail());
            }
            if (entity.getIsElectorRecordSame() == null) {
                statement.bindNull(12);
            } else {
                statement.bindText(12, entity.getIsElectorRecordSame());
            }
            if (entity.getDob() == null) {
                statement.bindNull(13);
            } else {
                statement.bindText(13, entity.getDob());
            }
            if (entity.getDobAttachment() == null) {
                statement.bindNull(14);
            } else {
                statement.bindText(14, entity.getDobAttachment());
            }
            if (entity.getIsDobRecordSame() == null) {
                statement.bindNull(15);
            } else {
                statement.bindText(15, entity.getIsDobRecordSame());
            }
            if (entity.getAddressAttachment() == null) {
                statement.bindNull(16);
            } else {
                statement.bindText(16, entity.getAddressAttachment());
            }
            if (entity.getIsAddressRecordSame() == null) {
                statement.bindNull(17);
            } else {
                statement.bindText(17, entity.getIsAddressRecordSame());
            }
            if (entity.getHouseApplicantFound() == null) {
                statement.bindNull(18);
            } else {
                statement.bindText(18, entity.getHouseApplicantFound());
            }
            if (entity.getAllDetailsVerified() == null) {
                statement.bindNull(19);
            } else {
                statement.bindText(19, entity.getAllDetailsVerified());
            }
            if (entity.getRemarks() == null) {
                statement.bindNull(20);
            } else {
                statement.bindText(20, entity.getRemarks());
            }
            if (entity.getMisDocument() == null) {
                statement.bindNull(21);
            } else {
                statement.bindText(21, entity.getMisDocument());
            }
            if (entity.getDateOfVerification() == null) {
                statement.bindNull(22);
            } else {
                statement.bindText(22, entity.getDateOfVerification());
            }
            if (entity.getCoordinate() == null) {
                statement.bindNull(23);
            } else {
                statement.bindText(23, entity.getCoordinate());
            }
            if (entity.getAge() == null) {
                statement.bindNull(24);
            } else {
                statement.bindText(24, entity.getAge());
            }
            if (entity.getLocalitySreet() == null) {
                statement.bindNull(25);
            } else {
                statement.bindText(25, entity.getLocalitySreet());
            }
            if (entity.getVillage() == null) {
                statement.bindNull(26);
            } else {
                statement.bindText(26, entity.getVillage());
            }
            if (entity.getPostOffice() == null) {
                statement.bindNull(27);
            } else {
                statement.bindText(27, entity.getPostOffice());
            }
            if (entity.getPinCode() == null) {
                statement.bindNull(28);
            } else {
                statement.bindText(28, entity.getPinCode());
            }
            if (entity.getStateCode() == null) {
                statement.bindNull(29);
            } else {
                statement.bindText(29, entity.getStateCode());
            }
            if (entity.getAcNo() == null) {
                statement.bindNull(30);
            } else {
                statement.bindText(30, entity.getAcNo());
            }
            if (entity.getPartNo() == null) {
                statement.bindNull(31);
            } else {
                statement.bindText(31, entity.getPartNo());
            }
            if (entity.getPhoto() == null) {
                statement.bindNull(32);
            } else {
                statement.bindText(32, entity.getPhoto());
            }
            if (entity.getLocalitySreetL1() == null) {
                statement.bindNull(33);
            } else {
                statement.bindText(33, entity.getLocalitySreetL1());
            }
            if (entity.getHouseNoL1() == null) {
                statement.bindNull(34);
            } else {
                statement.bindText(34, entity.getHouseNoL1());
            }
            if (entity.getPostOfficeL1() == null) {
                statement.bindNull(35);
            } else {
                statement.bindText(35, entity.getPostOfficeL1());
            }
            if (entity.getVillageL1() == null) {
                statement.bindNull(36);
            } else {
                statement.bindText(36, entity.getVillageL1());
            }
            if (entity.getTehsilTalukaMandal() == null) {
                statement.bindNull(37);
            } else {
                statement.bindText(37, entity.getTehsilTalukaMandal());
            }
            if (entity.getTehsilTalukaMandalL1() == null) {
                statement.bindNull(38);
            } else {
                statement.bindText(38, entity.getTehsilTalukaMandalL1());
            }
            if (entity.getAadharNo() == null) {
                statement.bindNull(39);
            } else {
                statement.bindText(39, entity.getAadharNo());
            }
            if (entity.getSectionNo() == null) {
                statement.bindNull(40);
            } else {
                statement.bindText(40, entity.getSectionNo());
            }
            if (entity.getSectionName() == null) {
                statement.bindNull(41);
            } else {
                statement.bindText(41, entity.getSectionName());
            }
            if (entity.getPwd() == null) {
                statement.bindNull(42);
            } else {
                statement.bindText(42, entity.getPwd());
            }
            if (entity.getDisabilityPercentage() == null) {
                statement.bindNull(43);
            } else {
                statement.bindText(43, entity.getDisabilityPercentage());
            }
            if (entity.getOtherDisability() == null) {
                statement.bindNull(44);
            } else {
                statement.bindText(44, entity.getOtherDisability());
            }
            if (entity.getDisabilityLocomotor() == null) {
                statement.bindNull(45);
            } else {
                statement.bindText(45, entity.getDisabilityLocomotor());
            }
            if (entity.getDisabilitySpeechHearing() == null) {
                statement.bindNull(46);
            } else {
                statement.bindText(46, entity.getDisabilitySpeechHearing());
            }
            if (entity.getDisabilityVisually() == null) {
                statement.bindNull(47);
            } else {
                statement.bindText(47, entity.getDisabilityVisually());
            }
            if (entity.getPartSerialNumber() == null) {
                statement.bindNull(48);
            } else {
                statement.bindText(48, entity.getPartSerialNumber());
            }
            if (entity.getBloId() == null) {
                statement.bindNull(49);
            } else {
                statement.bindText(49, entity.getBloId());
            }
            if (entity.getModifiedOn() == null) {
                statement.bindNull(50);
            } else {
                statement.bindText(50, entity.getModifiedOn());
            }
            if (entity.getLastSyncStatus() == null) {
                statement.bindNull(51);
            } else {
                statement.bindText(51, entity.getLastSyncStatus());
            }
            if (entity.getEpicNo() == null) {
                statement.bindNull(52);
            } else {
                statement.bindText(52, entity.getEpicNo());
            }
        }
    };

    public PartElectorDetailsModelDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
    }

    @Override // in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao
    public void addPartElecorDetails(final PartElectorDetailsModel.Items partElectorDetailsModel) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return this.f$0.lambda$addPartElecorDetails$0(partElectorDetailsModel, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$addPartElecorDetails$0(PartElectorDetailsModel.Items items, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfItems.insert(sQLiteConnection, items);
        return null;
    }

    @Override // in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao
    public void insertElecorDetails(final PartElectorDetailsModel.Items partElectorDetailsModel) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao_Impl$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                return this.f$0.lambda$insertElecorDetails$1(partElectorDetailsModel, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$insertElecorDetails$1(PartElectorDetailsModel.Items items, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfItems.insert(sQLiteConnection, items);
        return null;
    }

    @Override // in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao
    public void updatePartElecorDetails(final PartElectorDetailsModel.Items partElectorDetailsModel) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao_Impl$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                return this.f$0.lambda$updatePartElecorDetails$2(partElectorDetailsModel, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$updatePartElecorDetails$2(PartElectorDetailsModel.Items items, SQLiteConnection sQLiteConnection) {
        this.__updateAdapterOfItems.handle(sQLiteConnection, items);
        return null;
    }

    @Override // in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao
    public List<PartElectorDetailsModel.Items> getAllElectorDetails(final String partNo, final String bloId) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao_Impl$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                return PartElectorDetailsModelDao_Impl.lambda$getAllElectorDetails$3(partNo, bloId, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getAllElectorDetails$3(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select * from PART_ELECTOR_DETAILS where partNo = ? and BLO_ID = ? and LAST_SYNC_STATUS = 'SUCCESS'");
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            if (str2 == null) {
                sQLiteStatementPrepare.bindNull(2);
            } else {
                sQLiteStatementPrepare.bindText(2, str2);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "epicNo");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "houseNo");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "applicantName");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "applicantNameL1");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "gender");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "relativeName");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "relativeNameL1");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "relativeType");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "mobileNo");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "email");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isElectorRecordSame");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dob");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dobAttachment");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isDobRecordSame");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "addressAttachment");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isAddressRecordSame");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "houseApplicantFound");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "allDetailsVerified");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "remarks");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "misDocument");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dateOfVerification");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "coordinate");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "age");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "localitySreet");
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "village");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "postOffice");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "pinCode");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "stateCode");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "acNo");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "partNo");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "photo");
            int columnIndexOrThrow33 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "localitySreetL1");
            int columnIndexOrThrow34 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "houseNoL1");
            int columnIndexOrThrow35 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "postOfficeL1");
            int columnIndexOrThrow36 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "villageL1");
            int columnIndexOrThrow37 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "tehsilTalukaMandal");
            int columnIndexOrThrow38 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "tehsilTalukaMandalL1");
            int columnIndexOrThrow39 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "aadharNo");
            int columnIndexOrThrow40 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sectionNo");
            int columnIndexOrThrow41 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sectionName");
            int columnIndexOrThrow42 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "pwd");
            int columnIndexOrThrow43 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "disabilityPercentage");
            int columnIndexOrThrow44 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "otherDisability");
            int columnIndexOrThrow45 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "disabilityLocomotor");
            int columnIndexOrThrow46 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "disabilitySpeechHearing");
            int columnIndexOrThrow47 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "disabilityVisually");
            int columnIndexOrThrow48 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "partSerialNumber");
            int columnIndexOrThrow49 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "BLO_ID");
            int columnIndexOrThrow50 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MODIFIED_ON");
            int columnIndexOrThrow51 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LAST_SYNC_STATUS");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i = columnIndexOrThrow14;
                ArrayList arrayList2 = arrayList;
                int i2 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow);
                String text = sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8);
                String text8 = sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9);
                String text9 = sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow10);
                String text10 = sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11);
                String text11 = sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12);
                String text12 = sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13);
                String text13 = sQLiteStatementPrepare.isNull(i) ? null : sQLiteStatementPrepare.getText(i);
                int i3 = columnIndexOrThrow;
                int i4 = columnIndexOrThrow15;
                String text14 = sQLiteStatementPrepare.isNull(i4) ? null : sQLiteStatementPrepare.getText(i4);
                columnIndexOrThrow16 = columnIndexOrThrow16;
                String text15 = sQLiteStatementPrepare.isNull(columnIndexOrThrow16) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow16);
                columnIndexOrThrow17 = columnIndexOrThrow17;
                arrayList2.add(new PartElectorDetailsModel.Items(i2, text, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13, text14, text15, sQLiteStatementPrepare.isNull(columnIndexOrThrow17) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow17), sQLiteStatementPrepare.isNull(columnIndexOrThrow18) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow18), sQLiteStatementPrepare.isNull(columnIndexOrThrow19) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow19), sQLiteStatementPrepare.isNull(columnIndexOrThrow20) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow20), sQLiteStatementPrepare.isNull(columnIndexOrThrow21) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow21), sQLiteStatementPrepare.isNull(columnIndexOrThrow22) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow22), sQLiteStatementPrepare.isNull(columnIndexOrThrow23) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow23), sQLiteStatementPrepare.isNull(columnIndexOrThrow24) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow24), sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow25), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), sQLiteStatementPrepare.isNull(columnIndexOrThrow27) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow27), sQLiteStatementPrepare.isNull(columnIndexOrThrow28) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow28), sQLiteStatementPrepare.isNull(columnIndexOrThrow29) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow29), sQLiteStatementPrepare.isNull(columnIndexOrThrow30) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow30), sQLiteStatementPrepare.isNull(columnIndexOrThrow31) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow31), sQLiteStatementPrepare.isNull(columnIndexOrThrow32) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow32), sQLiteStatementPrepare.isNull(columnIndexOrThrow33) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow33), sQLiteStatementPrepare.isNull(columnIndexOrThrow34) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow34), sQLiteStatementPrepare.isNull(columnIndexOrThrow35) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow35), sQLiteStatementPrepare.isNull(columnIndexOrThrow36) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow36), sQLiteStatementPrepare.isNull(columnIndexOrThrow37) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow37), sQLiteStatementPrepare.isNull(columnIndexOrThrow38) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow38), sQLiteStatementPrepare.isNull(columnIndexOrThrow39) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow39), sQLiteStatementPrepare.isNull(columnIndexOrThrow40) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow40), sQLiteStatementPrepare.isNull(columnIndexOrThrow41) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow41), sQLiteStatementPrepare.isNull(columnIndexOrThrow42) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow42), sQLiteStatementPrepare.isNull(columnIndexOrThrow43) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow43), sQLiteStatementPrepare.isNull(columnIndexOrThrow44) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow44), sQLiteStatementPrepare.isNull(columnIndexOrThrow45) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow45), sQLiteStatementPrepare.isNull(columnIndexOrThrow46) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow46), sQLiteStatementPrepare.isNull(columnIndexOrThrow47) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow47), sQLiteStatementPrepare.isNull(columnIndexOrThrow49) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow49), sQLiteStatementPrepare.isNull(columnIndexOrThrow50) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow50), sQLiteStatementPrepare.isNull(columnIndexOrThrow51) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow51), sQLiteStatementPrepare.isNull(columnIndexOrThrow48) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow48)));
                columnIndexOrThrow = i3;
                columnIndexOrThrow15 = i4;
                arrayList = arrayList2;
                columnIndexOrThrow14 = i;
            }
            ArrayList arrayList3 = arrayList;
            sQLiteStatementPrepare.close();
            return arrayList3;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao
    public List<PartElectorDetailsModel.Items> getLastModifiedDate(final String partNo, final String bloId) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao_Impl$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                return PartElectorDetailsModelDao_Impl.lambda$getLastModifiedDate$4(partNo, bloId, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getLastModifiedDate$4(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select * from PART_ELECTOR_DETAILS where partNo = ? and BLO_ID = ? and LAST_SYNC_STATUS is not null and LAST_SYNC_STATUS != ''");
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            if (str2 == null) {
                sQLiteStatementPrepare.bindNull(2);
            } else {
                sQLiteStatementPrepare.bindText(2, str2);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "epicNo");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "houseNo");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "applicantName");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "applicantNameL1");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "gender");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "relativeName");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "relativeNameL1");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "relativeType");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "mobileNo");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "email");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isElectorRecordSame");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dob");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dobAttachment");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isDobRecordSame");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "addressAttachment");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isAddressRecordSame");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "houseApplicantFound");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "allDetailsVerified");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "remarks");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "misDocument");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dateOfVerification");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "coordinate");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "age");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "localitySreet");
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "village");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "postOffice");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "pinCode");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "stateCode");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "acNo");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "partNo");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "photo");
            int columnIndexOrThrow33 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "localitySreetL1");
            int columnIndexOrThrow34 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "houseNoL1");
            int columnIndexOrThrow35 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "postOfficeL1");
            int columnIndexOrThrow36 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "villageL1");
            int columnIndexOrThrow37 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "tehsilTalukaMandal");
            int columnIndexOrThrow38 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "tehsilTalukaMandalL1");
            int columnIndexOrThrow39 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "aadharNo");
            int columnIndexOrThrow40 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sectionNo");
            int columnIndexOrThrow41 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sectionName");
            int columnIndexOrThrow42 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "pwd");
            int columnIndexOrThrow43 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "disabilityPercentage");
            int columnIndexOrThrow44 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "otherDisability");
            int columnIndexOrThrow45 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "disabilityLocomotor");
            int columnIndexOrThrow46 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "disabilitySpeechHearing");
            int columnIndexOrThrow47 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "disabilityVisually");
            int columnIndexOrThrow48 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "partSerialNumber");
            int columnIndexOrThrow49 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "BLO_ID");
            int columnIndexOrThrow50 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MODIFIED_ON");
            int columnIndexOrThrow51 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LAST_SYNC_STATUS");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i = columnIndexOrThrow14;
                ArrayList arrayList2 = arrayList;
                int i2 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow);
                String text = sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8);
                String text8 = sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9);
                String text9 = sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow10);
                String text10 = sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11);
                String text11 = sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12);
                String text12 = sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13);
                String text13 = sQLiteStatementPrepare.isNull(i) ? null : sQLiteStatementPrepare.getText(i);
                int i3 = columnIndexOrThrow;
                int i4 = columnIndexOrThrow15;
                String text14 = sQLiteStatementPrepare.isNull(i4) ? null : sQLiteStatementPrepare.getText(i4);
                columnIndexOrThrow16 = columnIndexOrThrow16;
                String text15 = sQLiteStatementPrepare.isNull(columnIndexOrThrow16) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow16);
                columnIndexOrThrow17 = columnIndexOrThrow17;
                arrayList2.add(new PartElectorDetailsModel.Items(i2, text, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13, text14, text15, sQLiteStatementPrepare.isNull(columnIndexOrThrow17) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow17), sQLiteStatementPrepare.isNull(columnIndexOrThrow18) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow18), sQLiteStatementPrepare.isNull(columnIndexOrThrow19) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow19), sQLiteStatementPrepare.isNull(columnIndexOrThrow20) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow20), sQLiteStatementPrepare.isNull(columnIndexOrThrow21) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow21), sQLiteStatementPrepare.isNull(columnIndexOrThrow22) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow22), sQLiteStatementPrepare.isNull(columnIndexOrThrow23) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow23), sQLiteStatementPrepare.isNull(columnIndexOrThrow24) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow24), sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow25), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), sQLiteStatementPrepare.isNull(columnIndexOrThrow27) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow27), sQLiteStatementPrepare.isNull(columnIndexOrThrow28) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow28), sQLiteStatementPrepare.isNull(columnIndexOrThrow29) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow29), sQLiteStatementPrepare.isNull(columnIndexOrThrow30) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow30), sQLiteStatementPrepare.isNull(columnIndexOrThrow31) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow31), sQLiteStatementPrepare.isNull(columnIndexOrThrow32) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow32), sQLiteStatementPrepare.isNull(columnIndexOrThrow33) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow33), sQLiteStatementPrepare.isNull(columnIndexOrThrow34) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow34), sQLiteStatementPrepare.isNull(columnIndexOrThrow35) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow35), sQLiteStatementPrepare.isNull(columnIndexOrThrow36) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow36), sQLiteStatementPrepare.isNull(columnIndexOrThrow37) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow37), sQLiteStatementPrepare.isNull(columnIndexOrThrow38) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow38), sQLiteStatementPrepare.isNull(columnIndexOrThrow39) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow39), sQLiteStatementPrepare.isNull(columnIndexOrThrow40) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow40), sQLiteStatementPrepare.isNull(columnIndexOrThrow41) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow41), sQLiteStatementPrepare.isNull(columnIndexOrThrow42) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow42), sQLiteStatementPrepare.isNull(columnIndexOrThrow43) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow43), sQLiteStatementPrepare.isNull(columnIndexOrThrow44) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow44), sQLiteStatementPrepare.isNull(columnIndexOrThrow45) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow45), sQLiteStatementPrepare.isNull(columnIndexOrThrow46) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow46), sQLiteStatementPrepare.isNull(columnIndexOrThrow47) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow47), sQLiteStatementPrepare.isNull(columnIndexOrThrow49) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow49), sQLiteStatementPrepare.isNull(columnIndexOrThrow50) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow50), sQLiteStatementPrepare.isNull(columnIndexOrThrow51) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow51), sQLiteStatementPrepare.isNull(columnIndexOrThrow48) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow48)));
                columnIndexOrThrow = i3;
                columnIndexOrThrow15 = i4;
                arrayList = arrayList2;
                columnIndexOrThrow14 = i;
            }
            ArrayList arrayList3 = arrayList;
            sQLiteStatementPrepare.close();
            return arrayList3;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao
    public List<HouseModel> getAllElectorDetails1(final String partNumber) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao_Impl$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                return PartElectorDetailsModelDao_Impl.lambda$getAllElectorDetails1$5(partNumber, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getAllElectorDetails1$5(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select  TRIM(ped.houseNo) as houseno, ped.sectionNo as sectionNumber,ped.sectionName , COUNT(distinct ped.epicNo) as noofpeople \n FROM PART_ELECTOR_DETAILS  ped WHERE NOT EXISTS (SELECT  hsd.EPIC_NO FROM HOUSE_SURVEY_DETAILS hsd  WHERE\n  hsd.EPIC_NO = ped.epicNo) and ped.partNo=? and LAST_SYNC_STATUS = 'SUCCESS' GROUP BY ped.sectionNo,ped.sectionName, ped.houseNo having ped.sectionNo not null ");
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new HouseModel(sQLiteStatementPrepare.isNull(0) ? null : sQLiteStatementPrepare.getText(0), sQLiteStatementPrepare.isNull(3) ? null : sQLiteStatementPrepare.getText(3), null, null, sQLiteStatementPrepare.isNull(1) ? null : sQLiteStatementPrepare.getText(1), sQLiteStatementPrepare.isNull(2) ? null : sQLiteStatementPrepare.getText(2)));
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao
    public List<HouseModel> getAllVerifiedElectorDetails(final String partNumber) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao_Impl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return PartElectorDetailsModelDao_Impl.lambda$getAllVerifiedElectorDetails$6(partNumber, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getAllVerifiedElectorDetails$6(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select  TRIM(ped.houseNo) as houseno, ped.sectionNo as sectionNumber,ped.sectionName , COUNT(distinct ped.epicNo) as noofpeople \n FROM PART_ELECTOR_DETAILS  ped WHERE EXISTS (SELECT  hsd.EPIC_NO FROM HOUSE_SURVEY_DETAILS hsd  WHERE\n  hsd.EPIC_NO = ped.epicNo) and ped.partNo=? GROUP BY ped.sectionNo,ped.sectionName, ped.houseNo having ped.sectionNo not null ");
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new HouseModel(sQLiteStatementPrepare.isNull(0) ? null : sQLiteStatementPrepare.getText(0), sQLiteStatementPrepare.isNull(3) ? null : sQLiteStatementPrepare.getText(3), null, null, sQLiteStatementPrepare.isNull(1) ? null : sQLiteStatementPrepare.getText(1), sQLiteStatementPrepare.isNull(2) ? null : sQLiteStatementPrepare.getText(2)));
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao
    public List<ViewFamilyMemberListModel> getElectorDetails(final String epicNo) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao_Impl$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return PartElectorDetailsModelDao_Impl.lambda$getElectorDetails$7(epicNo, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getElectorDetails$7(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select   *  FROM PART_ELECTOR_DETAILS  a WHERE Not EXISTS (SELECT b.EPIC_NO\n            FROM HOUSE_SURVEY_DETAILS b WHERE b.EPIC_NO = a.epicNo ) and  a.epicNo=?");
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "epicNo");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "houseNo");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "applicantName");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "gender");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "relativeName");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "relativeType");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "mobileNo");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "email");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isElectorRecordSame");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dob");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dobAttachment");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isDobRecordSame");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "addressAttachment");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isAddressRecordSame");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "houseApplicantFound");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "allDetailsVerified");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "remarks");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "misDocument");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dateOfVerification");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "coordinate");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "age");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "localitySreet");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "village");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "postOffice");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "pinCode");
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "stateCode");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "acNo");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "partNo");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "aadharNo");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sectionNo");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sectionName");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "otherDisability");
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
                columnIndexOrThrow32 = columnIndexOrThrow32;
                arrayList.add(new ViewFamilyMemberListModel(text, text3, text7, text4, text8, text29, text10, text21, text5, text6, text2, text23, text24, text27, text22, null, text25, text28, text26, text20, null, text15, null, text9, text16, text14, text12, null, null, null, text30, text31, null, null, null, null, text32, text19, text13, text11, text18, text17));
                columnIndexOrThrow = i;
                columnIndexOrThrow15 = i2;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao
    public List<ViewFamilyMemberListModel> getNonVerifiedElectorDetails(final String houseno, final String secNo) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao_Impl$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                return PartElectorDetailsModelDao_Impl.lambda$getNonVerifiedElectorDetails$8(houseno, secNo, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getNonVerifiedElectorDetails$8(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select   *  FROM PART_ELECTOR_DETAILS  a WHERE Not EXISTS (SELECT b.EPIC_NO\n            FROM HOUSE_SURVEY_DETAILS b WHERE b.EPIC_NO = a.epicNo ) and  trim(a.houseNo)=? and a.sectionNo=?");
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            if (str2 == null) {
                sQLiteStatementPrepare.bindNull(2);
            } else {
                sQLiteStatementPrepare.bindText(2, str2);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "epicNo");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "houseNo");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "applicantName");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "gender");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "relativeName");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "relativeType");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "mobileNo");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "email");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isElectorRecordSame");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dob");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dobAttachment");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isDobRecordSame");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "addressAttachment");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isAddressRecordSame");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "houseApplicantFound");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "allDetailsVerified");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "remarks");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "misDocument");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dateOfVerification");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "coordinate");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "age");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "localitySreet");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "village");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "postOffice");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "pinCode");
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "stateCode");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "acNo");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "partNo");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "aadharNo");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sectionNo");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sectionName");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "otherDisability");
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
                columnIndexOrThrow17 = columnIndexOrThrow17;
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
                columnIndexOrThrow32 = columnIndexOrThrow32;
                arrayList.add(new ViewFamilyMemberListModel(text, text3, text7, text4, text8, text29, text10, text21, text5, text6, text2, text23, text24, text27, text22, null, text25, text28, text26, text20, null, text15, null, text9, text16, text14, text12, null, null, null, text30, text31, null, null, null, null, text32, text19, text13, text11, text18, text17));
                columnIndexOrThrow = i;
                columnIndexOrThrow15 = i2;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao
    public List<HouseModel> getAllSearchElectorDetails1(final String partNumber) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao_Impl$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return PartElectorDetailsModelDao_Impl.lambda$getAllSearchElectorDetails1$9(partNumber, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getAllSearchElectorDetails1$9(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select  TRIM(ped.houseNo) as houseno,ped.epicNo as noofpeople , ped.sectionNo as sectionNumber,ped.sectionName ,ped.applicantName \n FROM PART_ELECTOR_DETAILS  ped WHERE Not EXISTS (SELECT  hsd.EPIC_NO FROM HOUSE_SURVEY_DETAILS hsd  WHERE\n  hsd.EPIC_NO = ped.epicNo)  and ped.partNo=?");
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new HouseModel(sQLiteStatementPrepare.isNull(0) ? null : sQLiteStatementPrepare.getText(0), sQLiteStatementPrepare.isNull(1) ? null : sQLiteStatementPrepare.getText(1), null, sQLiteStatementPrepare.isNull(4) ? null : sQLiteStatementPrepare.getText(4), sQLiteStatementPrepare.isNull(2) ? null : sQLiteStatementPrepare.getText(2), sQLiteStatementPrepare.isNull(3) ? null : sQLiteStatementPrepare.getText(3)));
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao
    public List<HouseModel> getAllVerifiedSearchElectorDetails1(final String partNumber) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return PartElectorDetailsModelDao_Impl.lambda$getAllVerifiedSearchElectorDetails1$10(partNumber, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getAllVerifiedSearchElectorDetails1$10(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select  TRIM(ped.houseNo) as houseno, ped.sectionNo as sectionNumber,ped.sectionName ,ped.applicantName \n FROM PART_ELECTOR_DETAILS  ped WHERE EXISTS (SELECT  hsd.EPIC_NO FROM HOUSE_SURVEY_DETAILS hsd  WHERE\n  hsd.EPIC_NO = ped.epicNo)  and ped.partNo=?");
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new HouseModel(sQLiteStatementPrepare.isNull(0) ? null : sQLiteStatementPrepare.getText(0), null, null, sQLiteStatementPrepare.isNull(3) ? null : sQLiteStatementPrepare.getText(3), sQLiteStatementPrepare.isNull(1) ? null : sQLiteStatementPrepare.getText(1), sQLiteStatementPrepare.isNull(2) ? null : sQLiteStatementPrepare.getText(2)));
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao
    public List<PartElectorDetailsModel.Items> getNonVerifiedElectorDetails22(final String epicNo) {
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return PartElectorDetailsModelDao_Impl.lambda$getNonVerifiedElectorDetails22$11(epicNo, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ List lambda$getNonVerifiedElectorDetails22$11(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("select   *  FROM PART_ELECTOR_DETAILS  a WHERE Not EXISTS (SELECT b.EPIC_NO\n            FROM HOUSE_SURVEY_DETAILS b WHERE b.EPIC_NO = a.epicNo ) and  a.epicNo=?");
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "epicNo");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "houseNo");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "applicantName");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "applicantNameL1");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "gender");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "relativeName");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "relativeNameL1");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "relativeType");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "mobileNo");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "email");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isElectorRecordSame");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dob");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dobAttachment");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isDobRecordSame");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "addressAttachment");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isAddressRecordSame");
            int columnIndexOrThrow18 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "houseApplicantFound");
            int columnIndexOrThrow19 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "allDetailsVerified");
            int columnIndexOrThrow20 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "remarks");
            int columnIndexOrThrow21 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "misDocument");
            int columnIndexOrThrow22 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "dateOfVerification");
            int columnIndexOrThrow23 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "coordinate");
            int columnIndexOrThrow24 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "age");
            int columnIndexOrThrow25 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "localitySreet");
            int columnIndexOrThrow26 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "village");
            int columnIndexOrThrow27 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "postOffice");
            int columnIndexOrThrow28 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "pinCode");
            int columnIndexOrThrow29 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "stateCode");
            int columnIndexOrThrow30 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "acNo");
            int columnIndexOrThrow31 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "partNo");
            int columnIndexOrThrow32 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "photo");
            int columnIndexOrThrow33 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "localitySreetL1");
            int columnIndexOrThrow34 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "houseNoL1");
            int columnIndexOrThrow35 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "postOfficeL1");
            int columnIndexOrThrow36 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "villageL1");
            int columnIndexOrThrow37 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "tehsilTalukaMandal");
            int columnIndexOrThrow38 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "tehsilTalukaMandalL1");
            int columnIndexOrThrow39 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "aadharNo");
            int columnIndexOrThrow40 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sectionNo");
            int columnIndexOrThrow41 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sectionName");
            int columnIndexOrThrow42 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "pwd");
            int columnIndexOrThrow43 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "disabilityPercentage");
            int columnIndexOrThrow44 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "otherDisability");
            int columnIndexOrThrow45 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "disabilityLocomotor");
            int columnIndexOrThrow46 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "disabilitySpeechHearing");
            int columnIndexOrThrow47 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "disabilityVisually");
            int columnIndexOrThrow48 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "partSerialNumber");
            int columnIndexOrThrow49 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "BLO_ID");
            int columnIndexOrThrow50 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "MODIFIED_ON");
            int columnIndexOrThrow51 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "LAST_SYNC_STATUS");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i = columnIndexOrThrow14;
                ArrayList arrayList2 = arrayList;
                int i2 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow);
                String text = sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow8);
                String text8 = sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9);
                String text9 = sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow10);
                String text10 = sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11);
                String text11 = sQLiteStatementPrepare.isNull(columnIndexOrThrow12) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow12);
                String text12 = sQLiteStatementPrepare.isNull(columnIndexOrThrow13) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow13);
                String text13 = sQLiteStatementPrepare.isNull(i) ? null : sQLiteStatementPrepare.getText(i);
                int i3 = columnIndexOrThrow;
                int i4 = columnIndexOrThrow15;
                String text14 = sQLiteStatementPrepare.isNull(i4) ? null : sQLiteStatementPrepare.getText(i4);
                columnIndexOrThrow16 = columnIndexOrThrow16;
                arrayList2.add(new PartElectorDetailsModel.Items(i2, text, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13, text14, sQLiteStatementPrepare.isNull(columnIndexOrThrow16) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow16), sQLiteStatementPrepare.isNull(columnIndexOrThrow17) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow17), sQLiteStatementPrepare.isNull(columnIndexOrThrow18) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow18), sQLiteStatementPrepare.isNull(columnIndexOrThrow19) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow19), sQLiteStatementPrepare.isNull(columnIndexOrThrow20) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow20), sQLiteStatementPrepare.isNull(columnIndexOrThrow21) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow21), sQLiteStatementPrepare.isNull(columnIndexOrThrow22) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow22), sQLiteStatementPrepare.isNull(columnIndexOrThrow23) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow23), sQLiteStatementPrepare.isNull(columnIndexOrThrow24) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow24), sQLiteStatementPrepare.isNull(columnIndexOrThrow25) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow25), sQLiteStatementPrepare.isNull(columnIndexOrThrow26) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow26), sQLiteStatementPrepare.isNull(columnIndexOrThrow27) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow27), sQLiteStatementPrepare.isNull(columnIndexOrThrow28) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow28), sQLiteStatementPrepare.isNull(columnIndexOrThrow29) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow29), sQLiteStatementPrepare.isNull(columnIndexOrThrow30) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow30), sQLiteStatementPrepare.isNull(columnIndexOrThrow31) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow31), sQLiteStatementPrepare.isNull(columnIndexOrThrow32) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow32), sQLiteStatementPrepare.isNull(columnIndexOrThrow33) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow33), sQLiteStatementPrepare.isNull(columnIndexOrThrow34) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow34), sQLiteStatementPrepare.isNull(columnIndexOrThrow35) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow35), sQLiteStatementPrepare.isNull(columnIndexOrThrow36) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow36), sQLiteStatementPrepare.isNull(columnIndexOrThrow37) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow37), sQLiteStatementPrepare.isNull(columnIndexOrThrow38) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow38), sQLiteStatementPrepare.isNull(columnIndexOrThrow39) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow39), sQLiteStatementPrepare.isNull(columnIndexOrThrow40) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow40), sQLiteStatementPrepare.isNull(columnIndexOrThrow41) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow41), sQLiteStatementPrepare.isNull(columnIndexOrThrow42) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow42), sQLiteStatementPrepare.isNull(columnIndexOrThrow43) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow43), sQLiteStatementPrepare.isNull(columnIndexOrThrow44) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow44), sQLiteStatementPrepare.isNull(columnIndexOrThrow45) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow45), sQLiteStatementPrepare.isNull(columnIndexOrThrow46) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow46), sQLiteStatementPrepare.isNull(columnIndexOrThrow47) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow47), sQLiteStatementPrepare.isNull(columnIndexOrThrow49) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow49), sQLiteStatementPrepare.isNull(columnIndexOrThrow50) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow50), sQLiteStatementPrepare.isNull(columnIndexOrThrow51) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow51), sQLiteStatementPrepare.isNull(columnIndexOrThrow48) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow48)));
                columnIndexOrThrow = i3;
                columnIndexOrThrow15 = i4;
                arrayList = arrayList2;
                columnIndexOrThrow14 = i;
            }
            ArrayList arrayList3 = arrayList;
            sQLiteStatementPrepare.close();
            return arrayList3;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao
    public void deletePartElecorDetails(final String partNo, final String bloId) {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: in.gov.eci.bloapp.room.dao.PartElectorDetailsModelDao_Impl$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                return PartElectorDetailsModelDao_Impl.lambda$deletePartElecorDetails$12(partNo, bloId, (SQLiteConnection) obj);
            }
        });
    }

    static /* synthetic */ Object lambda$deletePartElecorDetails$12(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("DELETE FROM PART_ELECTOR_DETAILS WHERE partNo = ? and BLO_ID = ?");
        try {
            if (str == null) {
                sQLiteStatementPrepare.bindNull(1);
            } else {
                sQLiteStatementPrepare.bindText(1, str);
            }
            if (str2 == null) {
                sQLiteStatementPrepare.bindNull(2);
            } else {
                sQLiteStatementPrepare.bindText(2, str2);
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
