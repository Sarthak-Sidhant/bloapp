package in.gov.eci.bloapp.views.activity.newsir.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class DeclarationFormPayload implements Parcelable {
    public static final Parcelable.Creator<DeclarationFormPayload> CREATOR = new Parcelable.Creator<DeclarationFormPayload>() { // from class: in.gov.eci.bloapp.views.activity.newsir.model.DeclarationFormPayload.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeclarationFormPayload createFromParcel(Parcel in2) {
            return new DeclarationFormPayload(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeclarationFormPayload[] newArray(int size) {
            return new DeclarationFormPayload[size];
        }
    };
    public String aadharNo;
    public int acNo;
    public String annexureCUrl;
    public String applicantEligibleInPrevSir;
    public String bloOverridenFlg;
    public String categoryType;
    public String createdBy;
    public String createdDttm;
    public String currentRelationType;
    public String districtCd;
    public String dobVerified;
    public String epicName;
    public String epicNo;
    public int erollAge;
    public String erollDob;
    public String fatherOrGuardianEpicNo;
    public String fatherOrGuardianName;
    public String houseNo;
    public String imageName;
    public String imageSize;
    public String imageURL;
    public String isPDF;
    public String isSir03;
    public String isSir2526;
    public String isdeclarationEnabled;
    public String mappingType;
    public String mobileNo;
    public String mothersEpicNo;
    public String mothersName;
    public String oldAcName;
    public int oldAcNo;
    public int oldAge;
    public String oldPartName;
    public int oldPartNo;
    public int oldPslNo;
    public String oldStateCd;
    public String oldStateName;
    public int partNo;
    public int partSerialNo;
    public String photoUrl;
    public String progenyAcName;
    public String progenyDistCd;
    public String progenyOldName;
    public String progenyOldRelativeName;
    public String progenySearchedAcName;
    public String progenySearchedAcNo;
    public String progenySearchedEpic;
    public String progenySearchedPartNo;
    public String progenySearchedRlnType;
    public String progenySearchedStateName;
    public String progenySerialNo;
    public String relationOldAcName;
    public int relationOldAcNo;
    public String relationOldPartName;
    public int relationOldPartNo;
    public int relationOldPslNo;
    public String relationOldStateCd;
    public String relationOldStateName;
    public String relationSpinnerType;
    public String relationSpinnerTypeID;
    public String relationType;
    public String relationTypeValue;
    public String relativeFullName;
    public int relativeOldAge;
    public String rlnPrgyEpic;
    public String rlnPrgyName;
    public String rlnPrgyRlnName;
    public String rlnPrgyRlnType;
    public String selfOldEpic;
    public String selfOldName;
    public String selfOldRlnName;
    public String selfOldRlnType;
    public String selfSearchedAcName;
    public String selfSearchedAcNo;
    public String selfSearchedEpic;
    public String selfSearchedPartNo;
    public String selfSearchedRlnType;
    public String selfSearchedStateName;
    public String selfSerialNo;
    public String spouseEpicNo;
    public String spouseName;
    public String srFormPage1Url;
    public String srFormPage2Url;
    public String stateCd;
    public String submittedForRecommendation;
    public String surveyChannel;
    public String userId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getIsSir03() {
        return this.isSir03;
    }

    public void setIsSir03(String isSir03) {
        this.isSir03 = isSir03;
    }

    public String getIsSir2526() {
        return this.isSir2526;
    }

    public void setIsSir2526(String isSir2526) {
        this.isSir2526 = isSir2526;
    }

    public String getRelationSpinnerType() {
        return this.relationSpinnerType;
    }

    public void setRelationSpinnerType(String relationSpinnerType) {
        this.relationSpinnerType = relationSpinnerType;
    }

    public String getRelationSpinnerTypeID() {
        return this.relationSpinnerTypeID;
    }

    public void setRelationSpinnerTypeID(String relationSpinnerTypeID) {
        this.relationSpinnerTypeID = relationSpinnerTypeID;
    }

    public String getIsPDF() {
        return this.isPDF;
    }

    public void setIsPDF(String isPDF) {
        this.isPDF = isPDF;
    }

    public String getProgenyAcName() {
        return this.progenyAcName;
    }

    public void setProgenyAcName(String progenyAcName) {
        this.progenyAcName = progenyAcName;
    }

    public String getProgenyDistCd() {
        return this.progenyDistCd;
    }

    public void setProgenyDistCd(String progenyDistCd) {
        this.progenyDistCd = progenyDistCd;
    }

    public DeclarationFormPayload() {
    }

    protected DeclarationFormPayload(Parcel in2) {
        this.relationType = in2.readString();
        this.partSerialNo = in2.readInt();
        this.erollDob = in2.readString();
        this.photoUrl = in2.readString();
        this.srFormPage1Url = in2.readString();
        this.districtCd = in2.readString();
        this.dobVerified = in2.readString();
        this.aadharNo = in2.readString();
        this.mothersEpicNo = in2.readString();
        this.oldStateCd = in2.readString();
        this.oldPartNo = in2.readInt();
        this.mobileNo = in2.readString();
        this.spouseEpicNo = in2.readString();
        this.srFormPage2Url = in2.readString();
        this.oldPslNo = in2.readInt();
        this.relationOldAcNo = in2.readInt();
        this.mothersName = in2.readString();
        this.spouseName = in2.readString();
        this.rlnPrgyEpic = in2.readString();
        this.mappingType = in2.readString();
        this.selfOldEpic = in2.readString();
        this.rlnPrgyName = in2.readString();
        this.selfOldName = in2.readString();
        this.epicName = in2.readString();
        this.rlnPrgyRlnName = in2.readString();
        this.rlnPrgyRlnType = in2.readString();
        this.selfOldRlnType = in2.readString();
        this.categoryType = in2.readString();
        this.selfOldRlnName = in2.readString();
        this.surveyChannel = in2.readString();
        this.createdBy = in2.readString();
        this.partNo = in2.readInt();
        this.acNo = in2.readInt();
        this.oldAcNo = in2.readInt();
        this.houseNo = in2.readString();
        this.epicNo = in2.readString();
        this.userId = in2.readString();
        this.stateCd = in2.readString();
        this.submittedForRecommendation = in2.readString();
        this.relationOldStateCd = in2.readString();
        this.relationOldPslNo = in2.readInt();
        this.relationOldPartNo = in2.readInt();
        this.createdDttm = in2.readString();
        this.erollAge = in2.readInt();
        this.fatherOrGuardianEpicNo = in2.readString();
        this.fatherOrGuardianName = in2.readString();
        this.relativeFullName = in2.readString();
        this.annexureCUrl = in2.readString();
        this.currentRelationType = in2.readString();
        this.oldAge = in2.readInt();
        this.relativeOldAge = in2.readInt();
        this.applicantEligibleInPrevSir = in2.readString();
        this.oldStateName = in2.readString();
        this.oldPartName = in2.readString();
        this.oldAcName = in2.readString();
        this.relationOldStateName = in2.readString();
        this.relationOldPartName = in2.readString();
        this.relationOldAcName = in2.readString();
        this.bloOverridenFlg = in2.readString();
        this.selfSerialNo = in2.readString();
        this.progenySerialNo = in2.readString();
        this.selfSearchedAcName = in2.readString();
        this.selfSearchedAcNo = in2.readString();
        this.selfSearchedEpic = in2.readString();
        this.selfSearchedPartNo = in2.readString();
        this.selfSearchedRlnType = in2.readString();
        this.selfSearchedStateName = in2.readString();
        this.progenySearchedAcName = in2.readString();
        this.progenySearchedAcNo = in2.readString();
        this.progenySearchedEpic = in2.readString();
        this.progenySearchedPartNo = in2.readString();
        this.progenySearchedRlnType = in2.readString();
        this.progenySearchedStateName = in2.readString();
        this.progenyOldName = in2.readString();
        this.progenyOldRelativeName = in2.readString();
        this.relationTypeValue = in2.readString();
        this.imageURL = in2.readString();
        this.imageName = in2.readString();
        this.imageSize = in2.readString();
        this.progenyDistCd = in2.readString();
        this.progenyAcName = in2.readString();
        this.isdeclarationEnabled = in2.readString();
        this.isPDF = in2.readString();
        this.relationSpinnerType = in2.readString();
        this.relationSpinnerTypeID = in2.readString();
        this.isSir03 = in2.readString();
        this.isSir2526 = in2.readString();
    }

    public String getOldStateName() {
        return this.oldStateName;
    }

    public void setOldStateName(String oldStateName) {
        this.oldStateName = oldStateName;
    }

    public String getOldPartName() {
        return this.oldPartName;
    }

    public String getIsdeclarationEnabled() {
        return this.isdeclarationEnabled;
    }

    public void setIsdeclarationEnabled(String isdeclarationEnabled) {
        this.isdeclarationEnabled = isdeclarationEnabled;
    }

    public void setOldPartName(String oldPartName) {
        this.oldPartName = oldPartName;
    }

    public String getOldAcName() {
        return this.oldAcName;
    }

    public void setOldAcName(String oldAcName) {
        this.oldAcName = oldAcName;
    }

    public String getRelationOldStateName() {
        return this.relationOldStateName;
    }

    public void setRelationOldStateName(String relationOldStateName) {
        this.relationOldStateName = relationOldStateName;
    }

    public String getRelationOldPartName() {
        return this.relationOldPartName;
    }

    public void setRelationOldPartName(String relationOldPartName) {
        this.relationOldPartName = relationOldPartName;
    }

    public String getRelationOldAcName() {
        return this.relationOldAcName;
    }

    public void setRelationOldAcName(String relationOldAcName) {
        this.relationOldAcName = relationOldAcName;
    }

    public String getRelationType() {
        return this.relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public int getPartSerialNo() {
        return this.partSerialNo;
    }

    public void setPartSerialNo(int partSerialNo) {
        this.partSerialNo = partSerialNo;
    }

    public String getErollDob() {
        return this.erollDob;
    }

    public void setErollDob(String erollDob) {
        this.erollDob = erollDob;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getSrFormPage1Url() {
        return this.srFormPage1Url;
    }

    public void setSrFormPage1Url(String srFormPage1Url) {
        this.srFormPage1Url = srFormPage1Url;
    }

    public String getDistrictCd() {
        return this.districtCd;
    }

    public void setDistrictCd(String districtCd) {
        this.districtCd = districtCd;
    }

    public String getDobVerified() {
        return this.dobVerified;
    }

    public void setDobVerified(String dobVerified) {
        this.dobVerified = dobVerified;
    }

    public String getAadharNo() {
        return this.aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getMothersEpicNo() {
        return this.mothersEpicNo;
    }

    public void setMothersEpicNo(String mothersEpicNo) {
        this.mothersEpicNo = mothersEpicNo;
    }

    public String getOldStateCd() {
        return this.oldStateCd;
    }

    public void setOldStateCd(String oldStateCd) {
        this.oldStateCd = oldStateCd;
    }

    public int getOldPartNo() {
        return this.oldPartNo;
    }

    public void setOldPartNo(int oldPartNo) {
        this.oldPartNo = oldPartNo;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getSpouseEpicNo() {
        return this.spouseEpicNo;
    }

    public void setSpouseEpicNo(String spouseEpicNo) {
        this.spouseEpicNo = spouseEpicNo;
    }

    public String getSrFormPage2Url() {
        return this.srFormPage2Url;
    }

    public void setSrFormPage2Url(String srFormPage2Url) {
        this.srFormPage2Url = srFormPage2Url;
    }

    public int getOldPslNo() {
        return this.oldPslNo;
    }

    public void setOldPslNo(int oldPslNo) {
        this.oldPslNo = oldPslNo;
    }

    public int getRelationOldAcNo() {
        return this.relationOldAcNo;
    }

    public void setRelationOldAcNo(int relationOldAcNo) {
        this.relationOldAcNo = relationOldAcNo;
    }

    public String getMothersName() {
        return this.mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getSpouseName() {
        return this.spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getRlnPrgyEpic() {
        return this.rlnPrgyEpic;
    }

    public void setRlnPrgyEpic(String rlnPrgyEpic) {
        this.rlnPrgyEpic = rlnPrgyEpic;
    }

    public String getMappingType() {
        return this.mappingType;
    }

    public void setMappingType(String mappingType) {
        this.mappingType = mappingType;
    }

    public String getSelfOldEpic() {
        return this.selfOldEpic;
    }

    public void setSelfOldEpic(String selfOldEpic) {
        this.selfOldEpic = selfOldEpic;
    }

    public String getRlnPrgyName() {
        return this.rlnPrgyName;
    }

    public void setRlnPrgyName(String rlnPrgyName) {
        this.rlnPrgyName = rlnPrgyName;
    }

    public String getSelfOldName() {
        return this.selfOldName;
    }

    public void setSelfOldName(String selfOldName) {
        this.selfOldName = selfOldName;
    }

    public String getEpicName() {
        return this.epicName;
    }

    public void setEpicName(String epicName) {
        this.epicName = epicName;
    }

    public String getRlnPrgyRlnName() {
        return this.rlnPrgyRlnName;
    }

    public void setRlnPrgyRlnName(String rlnPrgyRlnName) {
        this.rlnPrgyRlnName = rlnPrgyRlnName;
    }

    public String getRlnPrgyRlnType() {
        return this.rlnPrgyRlnType;
    }

    public void setRlnPrgyRlnType(String rlnPrgyRlnType) {
        this.rlnPrgyRlnType = rlnPrgyRlnType;
    }

    public String getSelfOldRlnType() {
        return this.selfOldRlnType;
    }

    public void setSelfOldRlnType(String selfOldRlnType) {
        this.selfOldRlnType = selfOldRlnType;
    }

    public String getCategoryType() {
        return this.categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getSelfOldRlnName() {
        return this.selfOldRlnName;
    }

    public void setSelfOldRlnName(String selfOldRlnName) {
        this.selfOldRlnName = selfOldRlnName;
    }

    public String getSurveyChannel() {
        return this.surveyChannel;
    }

    public void setSurveyChannel(String surveyChannel) {
        this.surveyChannel = surveyChannel;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public int getPartNo() {
        return this.partNo;
    }

    public void setPartNo(int partNo) {
        this.partNo = partNo;
    }

    public int getAcNo() {
        return this.acNo;
    }

    public void setAcNo(int acNo) {
        this.acNo = acNo;
    }

    public int getOldAcNo() {
        return this.oldAcNo;
    }

    public void setOldAcNo(int oldAcNo) {
        this.oldAcNo = oldAcNo;
    }

    public String getHouseNo() {
        return this.houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getEpicNo() {
        return this.epicNo;
    }

    public void setEpicNo(String epicNo) {
        this.epicNo = epicNo;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStateCd() {
        return this.stateCd;
    }

    public void setStateCd(String stateCd) {
        this.stateCd = stateCd;
    }

    public String getSubmittedForRecommendation() {
        return this.submittedForRecommendation;
    }

    public void setSubmittedForRecommendation(String submittedForRecommendation) {
        this.submittedForRecommendation = submittedForRecommendation;
    }

    public String getRelationOldStateCd() {
        return this.relationOldStateCd;
    }

    public void setRelationOldStateCd(String relationOldStateCd) {
        this.relationOldStateCd = relationOldStateCd;
    }

    public int getRelationOldPslNo() {
        return this.relationOldPslNo;
    }

    public void setRelationOldPslNo(int relationOldPslNo) {
        this.relationOldPslNo = relationOldPslNo;
    }

    public int getRelationOldPartNo() {
        return this.relationOldPartNo;
    }

    public void setRelationOldPartNo(int relationOldPartNo) {
        this.relationOldPartNo = relationOldPartNo;
    }

    public String getCreatedDttm() {
        return this.createdDttm;
    }

    public void setCreatedDttm(String createdDttm) {
        this.createdDttm = createdDttm;
    }

    public int getErollAge() {
        return this.erollAge;
    }

    public void setErollAge(int erollAge) {
        this.erollAge = erollAge;
    }

    public String getFatherOrGuardianEpicNo() {
        return this.fatherOrGuardianEpicNo;
    }

    public void setFatherOrGuardianEpicNo(String fatherOrGuardianEpicNo) {
        this.fatherOrGuardianEpicNo = fatherOrGuardianEpicNo;
    }

    public String getFatherOrGuardianName() {
        return this.fatherOrGuardianName;
    }

    public void setFatherOrGuardianName(String fatherOrGuardianName) {
        this.fatherOrGuardianName = fatherOrGuardianName;
    }

    public String getRelativeFullName() {
        return this.relativeFullName;
    }

    public void setRelativeFullName(String relativeFullName) {
        this.relativeFullName = relativeFullName;
    }

    public String getAnnexureCUrl() {
        return this.annexureCUrl;
    }

    public String getCurrentRelationType() {
        return this.currentRelationType;
    }

    public void setCurrentRelationType(String currentRelationType) {
        this.currentRelationType = currentRelationType;
    }

    public void setAnnexureCUrl(String annexureCUrl) {
        this.annexureCUrl = annexureCUrl;
    }

    public int getOldAge() {
        return this.oldAge;
    }

    public void setOldAge(int oldAge) {
        this.oldAge = oldAge;
    }

    public int getRelativeOldAge() {
        return this.relativeOldAge;
    }

    public void setRelativeOldAge(int relativeOldAge) {
        this.relativeOldAge = relativeOldAge;
    }

    public String getBloOverridenFlg() {
        return this.bloOverridenFlg;
    }

    public void setBloOverridenFlg(String bloOverridenFlg) {
        this.bloOverridenFlg = bloOverridenFlg;
    }

    public String getSelfSearchedEpic() {
        return this.selfSearchedEpic;
    }

    public void setSelfSearchedEpic(String selfSearchedEpic) {
        this.selfSearchedEpic = selfSearchedEpic;
    }

    public String getSelfSearchedRlnType() {
        return this.selfSearchedRlnType;
    }

    public void setSelfSearchedRlnType(String selfSearchedRlnType) {
        this.selfSearchedRlnType = selfSearchedRlnType;
    }

    public String getSelfSearchedStateName() {
        return this.selfSearchedStateName;
    }

    public void setSelfSearchedStateName(String selfSearchedStateName) {
        this.selfSearchedStateName = selfSearchedStateName;
    }

    public String getSelfSearchedAcName() {
        return this.selfSearchedAcName;
    }

    public void setSelfSearchedAcName(String selfSearchedAcName) {
        this.selfSearchedAcName = selfSearchedAcName;
    }

    public String getSelfSearchedAcNo() {
        return this.selfSearchedAcNo;
    }

    public void setSelfSearchedAcNo(String selfSearchedAcNo) {
        this.selfSearchedAcNo = selfSearchedAcNo;
    }

    public String getSelfSearchedPartNo() {
        return this.selfSearchedPartNo;
    }

    public void setSelfSearchedPartNo(String selfSearchedPartNo) {
        this.selfSearchedPartNo = selfSearchedPartNo;
    }

    public String getApplicantEligibleInPrevSir() {
        return this.applicantEligibleInPrevSir;
    }

    public void setApplicantEligibleInPrevSir(String applicantEligibleInPrevSir) {
        this.applicantEligibleInPrevSir = applicantEligibleInPrevSir;
    }

    public String getSelfSerialNo() {
        return this.selfSerialNo;
    }

    public void setSelfSerialNo(String selfSerialNo) {
        this.selfSerialNo = selfSerialNo;
    }

    public String getProgenySerialNo() {
        return this.progenySerialNo;
    }

    public void setProgenySerialNo(String progenySerialNo) {
        this.progenySerialNo = progenySerialNo;
    }

    public String getProgenySearchedEpic() {
        return this.progenySearchedEpic;
    }

    public void setProgenySearchedEpic(String progenySearchedEpic) {
        this.progenySearchedEpic = progenySearchedEpic;
    }

    public String getProgenySearchedRlnType() {
        return this.progenySearchedRlnType;
    }

    public void setProgenySearchedRlnType(String progenySearchedRlnType) {
        this.progenySearchedRlnType = progenySearchedRlnType;
    }

    public String getProgenySearchedStateName() {
        return this.progenySearchedStateName;
    }

    public void setProgenySearchedStateName(String progenySearchedStateName) {
        this.progenySearchedStateName = progenySearchedStateName;
    }

    public String getProgenySearchedAcName() {
        return this.progenySearchedAcName;
    }

    public void setProgenySearchedAcName(String progenySearchedAcName) {
        this.progenySearchedAcName = progenySearchedAcName;
    }

    public String getProgenySearchedAcNo() {
        return this.progenySearchedAcNo;
    }

    public void setProgenySearchedAcNo(String progenySearchedAcNo) {
        this.progenySearchedAcNo = progenySearchedAcNo;
    }

    public String getProgenySearchedPartNo() {
        return this.progenySearchedPartNo;
    }

    public void setProgenySearchedPartNo(String progenySearchedPartNo) {
        this.progenySearchedPartNo = progenySearchedPartNo;
    }

    public String getProgenyOldName() {
        return this.progenyOldName;
    }

    public void setProgenyOldName(String progenyOldName) {
        this.progenyOldName = progenyOldName;
    }

    public String getProgenyOldRelativeName() {
        return this.progenyOldRelativeName;
    }

    public void setProgenyOldRelativeName(String progenyOldRelativeName) {
        this.progenyOldRelativeName = progenyOldRelativeName;
    }

    public String getRelationTypeValue() {
        return this.relationTypeValue;
    }

    public void setRelationTypeValue(String relationTypeValue) {
        this.relationTypeValue = relationTypeValue;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageName() {
        return this.imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageSize() {
        return this.imageSize;
    }

    public void setImageSize(String imageSize) {
        this.imageSize = imageSize;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.relationType);
        dest.writeInt(this.partSerialNo);
        dest.writeString(this.erollDob);
        dest.writeString(this.photoUrl);
        dest.writeString(this.srFormPage1Url);
        dest.writeString(this.districtCd);
        dest.writeString(this.dobVerified);
        dest.writeString(this.aadharNo);
        dest.writeString(this.mothersEpicNo);
        dest.writeString(this.oldStateCd);
        dest.writeInt(this.oldPartNo);
        dest.writeString(this.mobileNo);
        dest.writeString(this.spouseEpicNo);
        dest.writeString(this.srFormPage2Url);
        dest.writeInt(this.oldPslNo);
        dest.writeInt(this.relationOldAcNo);
        dest.writeString(this.mothersName);
        dest.writeString(this.spouseName);
        dest.writeString(this.rlnPrgyEpic);
        dest.writeString(this.mappingType);
        dest.writeString(this.selfOldEpic);
        dest.writeString(this.rlnPrgyName);
        dest.writeString(this.selfOldName);
        dest.writeString(this.epicName);
        dest.writeString(this.rlnPrgyRlnName);
        dest.writeString(this.rlnPrgyRlnType);
        dest.writeString(this.selfOldRlnType);
        dest.writeString(this.categoryType);
        dest.writeString(this.selfOldRlnName);
        dest.writeString(this.surveyChannel);
        dest.writeString(this.createdBy);
        dest.writeInt(this.partNo);
        dest.writeInt(this.acNo);
        dest.writeInt(this.oldAcNo);
        dest.writeString(this.houseNo);
        dest.writeString(this.epicNo);
        dest.writeString(this.userId);
        dest.writeString(this.stateCd);
        dest.writeString(this.submittedForRecommendation);
        dest.writeString(this.relationOldStateCd);
        dest.writeInt(this.relationOldPslNo);
        dest.writeInt(this.relationOldPartNo);
        dest.writeString(this.createdDttm);
        dest.writeInt(this.erollAge);
        dest.writeString(this.fatherOrGuardianEpicNo);
        dest.writeString(this.fatherOrGuardianName);
        dest.writeString(this.relativeFullName);
        dest.writeString(this.annexureCUrl);
        dest.writeString(this.currentRelationType);
        dest.writeInt(this.oldAge);
        dest.writeInt(this.relativeOldAge);
        dest.writeString(this.applicantEligibleInPrevSir);
        dest.writeString(this.oldStateName);
        dest.writeString(this.oldPartName);
        dest.writeString(this.oldAcName);
        dest.writeString(this.relationOldStateName);
        dest.writeString(this.relationOldAcName);
        dest.writeString(this.relationOldPartName);
        dest.writeString(this.bloOverridenFlg);
        dest.writeString(this.selfSerialNo);
        dest.writeString(this.progenySerialNo);
        dest.writeString(this.selfSearchedAcName);
        dest.writeString(this.selfSearchedAcNo);
        dest.writeString(this.selfSearchedEpic);
        dest.writeString(this.selfSearchedPartNo);
        dest.writeString(this.selfSearchedRlnType);
        dest.writeString(this.selfSearchedStateName);
        dest.writeString(this.progenySearchedAcName);
        dest.writeString(this.progenySearchedAcNo);
        dest.writeString(this.progenySearchedEpic);
        dest.writeString(this.progenySearchedPartNo);
        dest.writeString(this.progenySearchedRlnType);
        dest.writeString(this.progenySearchedStateName);
        dest.writeString(this.progenyOldName);
        dest.writeString(this.progenyOldRelativeName);
        dest.writeString(this.relationTypeValue);
        dest.writeString(this.imageURL);
        dest.writeString(this.imageName);
        dest.writeString(this.imageSize);
        dest.writeString(this.progenyDistCd);
        dest.writeString(this.progenyAcName);
        dest.writeString(this.isdeclarationEnabled);
        dest.writeString(this.isPDF);
        dest.writeString(this.relationSpinnerType);
        dest.writeString(this.relationSpinnerTypeID);
        dest.writeString(this.isSir03);
        dest.writeString(this.isSir2526);
    }
}
