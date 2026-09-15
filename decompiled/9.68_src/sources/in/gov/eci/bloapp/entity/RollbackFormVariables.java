package in.gov.eci.bloapp.entity;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class RollbackFormVariables {
    private String aadharNo;
    private String acNo;
    private String annexureCUrl;
    private String annexureCUrlPg2;
    private String backToBlo;
    private String backToBloRemarks;
    private String bloOverridenFlg;
    private String citizenSignatureFilepath;
    private String citizenshipType;
    private String citizenshipTypeCat;
    private String createdBy;
    private String createdDttm;
    private String districtCd;
    private String dobVerified;
    private String documentUploadedFlg;
    private String electorName;
    private Long epicId;
    private String epicNo;
    String erollAge;
    private String erollDob;
    private String fathersNationality;
    private String fathersOrGuardianEpicNo;
    private String fathersOrGuardianName;
    private String foldAcNo;
    private String foldPartNo;
    private String foldPslNo;
    private String formSubmissionPlace;
    private String houseNo;
    private int id;
    private String isRelativePreVoterFlg;
    private String isThisYou;
    private String isThisYouRel;
    private String list1Doc;
    private String list1DocUrl;
    private String list1docUrlPg2;
    private String list2Doc;
    private String list2DocUrl;
    private String list2docUrlPg2;
    private String list3Doc;
    private String list3DocUrl;
    private String list3docUrlPg2;
    private String list4Doc;
    private String list4DocUrl;
    private String list4docUrlPg2;
    private String list5Doc;
    private String list5DocUrl;
    private String list5docUrlPg2;
    private String list5docUrlPg3;
    private String list6Doc;
    private String list6DocUrl;
    private String list6docUrlPg2;
    private String list7Doc;
    private String list7DocUrl;
    private String list7docUrlPg2;
    private String list8Doc;
    private String mobileNo;
    private String modifiedBy;
    private String modifiedDttm;
    private String moldAcNo;
    private String moldPartNo;
    private String moldPslNo;
    private String mothersEpicNo;
    private String mothersName;
    private String mothersNationality;
    private String oldAcNo;
    private String oldPartNo;
    private String oldPslNo;
    private String oldStateCd;
    private String partNo;
    private String partSerialNo;
    private String photoUrl;
    private String preRevisionVoterDocUrl;
    private String preRevisionVoterDocUrlPg2;
    private String preRevisionVoterFlg;
    private String relationDocType;
    private String relationDocUrlPg1;
    private String relationDocUrlPg2;
    private String relationOldAcNo;
    private String relationOldPartNo;
    private String relationOldPslNo;
    private String relationOldStateCd;
    private String relationProofDocUrlPg1;
    private String relationProofDocUrlPg2;
    private String relationType;
    private String relativeEpic;
    private String spouseEpicNo;
    private String spouseName;
    private String srFormPage1Url;
    private String srFormPage2Url;
    private String stCode;
    private String submittedForRecommendation;
    private String surveyChannel;

    public String getIsThisYou() {
        return this.isThisYou;
    }

    public void setIsThisYou(String isThisYou) {
        this.isThisYou = isThisYou;
    }

    public String getIsThisYouRel() {
        return this.isThisYouRel;
    }

    public void setIsThisYouRel(String isThisYouRel) {
        this.isThisYouRel = isThisYouRel;
    }

    public RollbackFormVariables(int id, String stCode, String epicNo, Long epicId, String houseNo, String dobVerified, String erollDob, String districtCd, String acNo, String partNo, String partSerialNo, String createdDttm, String createdBy, String modifiedDttm, String modifiedBy, String photoUrl, String srFormPage1Url, String citizenshipType, String citizenshipTypeCat, String surveyChannel, String list1Doc, String list2Doc, String list3Doc, String list4Doc, String list5Doc, String list6Doc, String list7Doc, String list8Doc, String list1DocUrl, String list2DocUrl, String list3DocUrl, String list4DocUrl, String list5DocUrl, String list6DocUrl, String list7DocUrl, String aadharNo, String mobileNo, String fathersOrGuardianName, String fathersOrGuardianEpicNo, String mothersName, String mothersEpicNo, String spouseName, String spouseEpicNo, String annexureCUrl, String preRevisionVoterFlg, String preRevisionVoterDocUrl, String submittedForRecommendation, String fathersNationality, String mothersNationality, String srFormPage2Url, String oldAcNo, String oldPartNo, String oldPslNo, String documentUploadedFlg, String list1docUrlPg2, String list2docUrlPg2, String list3docUrlPg2, String list4docUrlPg2, String list5docUrlPg2, String list5docUrlPg3, String list6docUrlPg2, String list7docUrlPg2, String preRevisionVoterDocUrlPg2, String annexureCUrlPg2, String formSubmissionPlace, String citizenSignatureFilepath, String moldAcNo, String moldPartNo, String moldPslNo, String foldAcNo, String foldPartNo, String foldPslNo, String electorName, String bloOverridenFlg, String backToBlo, String backToBloRemarks, String relationProofDocUrlPg1, String relationProofDocUrlPg2, String relationType, String relationOldAcNo, String relationOldPartNo, String relationOldPslNo, String relationDocType, String relationDocUrlPg1, String relationDocUrlPg2, String isRelativePreVoterFlg, String relativeEpic, String isThisYou, String isThisYouRel, String relationOldStateCd, String oldStateCd, String erollAge) {
        this.id = id;
        this.stCode = stCode;
        this.epicNo = epicNo;
        this.epicId = epicId;
        this.houseNo = houseNo;
        this.dobVerified = dobVerified;
        this.erollDob = erollDob;
        this.districtCd = districtCd;
        this.acNo = acNo;
        this.partNo = partNo;
        this.partSerialNo = partSerialNo;
        this.createdDttm = createdDttm;
        this.createdBy = createdBy;
        this.modifiedDttm = modifiedDttm;
        this.modifiedBy = modifiedBy;
        this.photoUrl = photoUrl;
        this.srFormPage1Url = srFormPage1Url;
        this.citizenshipType = citizenshipType;
        this.citizenshipTypeCat = citizenshipTypeCat;
        this.surveyChannel = surveyChannel;
        this.list1Doc = list1Doc;
        this.list2Doc = list2Doc;
        this.list3Doc = list3Doc;
        this.list4Doc = list4Doc;
        this.list5Doc = list5Doc;
        this.list6Doc = list6Doc;
        this.list7Doc = list7Doc;
        this.list8Doc = list8Doc;
        this.list1DocUrl = list1DocUrl;
        this.list2DocUrl = list2DocUrl;
        this.list3DocUrl = list3DocUrl;
        this.list4DocUrl = list4DocUrl;
        this.list5DocUrl = list5DocUrl;
        this.list6DocUrl = list6DocUrl;
        this.list7DocUrl = list7DocUrl;
        this.aadharNo = aadharNo;
        this.mobileNo = mobileNo;
        this.fathersOrGuardianName = fathersOrGuardianName;
        this.fathersOrGuardianEpicNo = fathersOrGuardianEpicNo;
        this.mothersName = mothersName;
        this.mothersEpicNo = mothersEpicNo;
        this.spouseName = spouseName;
        this.spouseEpicNo = spouseEpicNo;
        this.annexureCUrl = annexureCUrl;
        this.preRevisionVoterFlg = preRevisionVoterFlg;
        this.preRevisionVoterDocUrl = preRevisionVoterDocUrl;
        this.submittedForRecommendation = submittedForRecommendation;
        this.fathersNationality = fathersNationality;
        this.mothersNationality = mothersNationality;
        this.srFormPage2Url = srFormPage2Url;
        this.oldAcNo = oldAcNo;
        this.oldPartNo = oldPartNo;
        this.oldPslNo = oldPslNo;
        this.documentUploadedFlg = documentUploadedFlg;
        this.list1docUrlPg2 = list1docUrlPg2;
        this.list2docUrlPg2 = list2docUrlPg2;
        this.list3docUrlPg2 = list3docUrlPg2;
        this.list4docUrlPg2 = list4docUrlPg2;
        this.list5docUrlPg2 = list5docUrlPg2;
        this.list5docUrlPg3 = list5docUrlPg3;
        this.list6docUrlPg2 = list6docUrlPg2;
        this.list7docUrlPg2 = list7docUrlPg2;
        this.preRevisionVoterDocUrlPg2 = preRevisionVoterDocUrlPg2;
        this.annexureCUrlPg2 = annexureCUrlPg2;
        this.formSubmissionPlace = formSubmissionPlace;
        this.citizenSignatureFilepath = citizenSignatureFilepath;
        this.moldAcNo = moldAcNo;
        this.moldPartNo = moldPartNo;
        this.moldPslNo = moldPslNo;
        this.foldAcNo = foldAcNo;
        this.foldPartNo = foldPartNo;
        this.foldPslNo = foldPslNo;
        this.electorName = electorName;
        this.bloOverridenFlg = bloOverridenFlg;
        this.backToBlo = backToBlo;
        this.backToBloRemarks = backToBloRemarks;
        this.relationProofDocUrlPg1 = relationProofDocUrlPg1;
        this.relationProofDocUrlPg2 = relationProofDocUrlPg2;
        this.relationType = relationType;
        this.relationOldAcNo = relationOldAcNo;
        this.relationOldPartNo = relationOldPartNo;
        this.relationOldPslNo = relationOldPslNo;
        this.relationDocType = relationDocType;
        this.relationDocUrlPg1 = relationDocUrlPg1;
        this.relationDocUrlPg2 = relationDocUrlPg2;
        this.isRelativePreVoterFlg = isRelativePreVoterFlg;
        this.relativeEpic = relativeEpic;
        this.isThisYou = isThisYou;
        this.isThisYouRel = isThisYouRel;
        this.relationOldStateCd = relationOldStateCd;
        this.oldStateCd = oldStateCd;
        this.erollAge = erollAge;
    }

    public int getId() {
        return this.id;
    }

    public String getRelationProofDocUrlPg1() {
        return this.relationProofDocUrlPg1;
    }

    public void setRelationProofDocUrlPg1(String relationProofDocUrlPg1) {
        this.relationProofDocUrlPg1 = relationProofDocUrlPg1;
    }

    public String getRelationProofDocUrlPg2() {
        return this.relationProofDocUrlPg2;
    }

    public void setRelationProofDocUrlPg2(String relationProofDocUrlPg2) {
        this.relationProofDocUrlPg2 = relationProofDocUrlPg2;
    }

    public String getRelationType() {
        return this.relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getRelationOldAcNo() {
        return this.relationOldAcNo;
    }

    public void setRelationOldAcNo(String relationOldAcNo) {
        this.relationOldAcNo = relationOldAcNo;
    }

    public String getRelationOldPartNo() {
        return this.relationOldPartNo;
    }

    public void setRelationOldPartNo(String relationOldPartNo) {
        this.relationOldPartNo = relationOldPartNo;
    }

    public String getRelationOldPslNo() {
        return this.relationOldPslNo;
    }

    public void setRelationOldPslNo(String relationOldPslNo) {
        this.relationOldPslNo = relationOldPslNo;
    }

    public String getRelationDocType() {
        return this.relationDocType;
    }

    public void setRelationDocType(String relationDocType) {
        this.relationDocType = relationDocType;
    }

    public String getRelationDocUrlPg1() {
        return this.relationDocUrlPg1;
    }

    public void setRelationDocUrlPg1(String relationDocUrlPg1) {
        this.relationDocUrlPg1 = relationDocUrlPg1;
    }

    public String getRelationDocUrlPg2() {
        return this.relationDocUrlPg2;
    }

    public void setRelationDocUrlPg2(String relationDocUrlPg2) {
        this.relationDocUrlPg2 = relationDocUrlPg2;
    }

    public String getIsRelativePreVoterFlg() {
        return this.isRelativePreVoterFlg;
    }

    public void setIsRelativePreVoterFlg(String isRelativePreVoterFlg) {
        this.isRelativePreVoterFlg = isRelativePreVoterFlg;
    }

    public String getRelativeEpic() {
        return this.relativeEpic;
    }

    public void setRelativeEpic(String relativeEpic) {
        this.relativeEpic = relativeEpic;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStCode() {
        return this.stCode;
    }

    public void setStCode(String stCode) {
        this.stCode = stCode;
    }

    public String getEpicNo() {
        return this.epicNo;
    }

    public void setEpicNo(String epicNo) {
        this.epicNo = epicNo;
    }

    public String getHouseNo() {
        return this.houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getDobVerified() {
        return this.dobVerified;
    }

    public void setDobVerified(String dobVerified) {
        this.dobVerified = dobVerified;
    }

    public String getErollDob() {
        return this.erollDob;
    }

    public void setErollDob(String erollDob) {
        this.erollDob = erollDob;
    }

    public String getDistrictCd() {
        return this.districtCd;
    }

    public void setDistrictCd(String districtCd) {
        this.districtCd = districtCd;
    }

    public String getAcNo() {
        return this.acNo;
    }

    public void setAcNo(String acNo) {
        this.acNo = acNo;
    }

    public String getPartNo() {
        return this.partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getPartSerialNo() {
        return this.partSerialNo;
    }

    public void setPartSerialNo(String partSerialNo) {
        this.partSerialNo = partSerialNo;
    }

    public String getCreatedDttm() {
        return this.createdDttm;
    }

    public void setCreatedDttm(String createdDttm) {
        this.createdDttm = createdDttm;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedDttm() {
        return this.modifiedDttm;
    }

    public void setModifiedDttm(String modifiedDttm) {
        this.modifiedDttm = modifiedDttm;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
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

    public String getCitizenshipType() {
        return this.citizenshipType;
    }

    public void setCitizenshipType(String citizenshipType) {
        this.citizenshipType = citizenshipType;
    }

    public String getCitizenshipTypeCat() {
        return this.citizenshipTypeCat;
    }

    public void setCitizenshipTypeCat(String citizenshipTypeCat) {
        this.citizenshipTypeCat = citizenshipTypeCat;
    }

    public String getSurveyChannel() {
        return this.surveyChannel;
    }

    public void setSurveyChannel(String surveyChannel) {
        this.surveyChannel = surveyChannel;
    }

    public String getList1Doc() {
        return this.list1Doc;
    }

    public void setList1Doc(String list1Doc) {
        this.list1Doc = list1Doc;
    }

    public String getList2Doc() {
        return this.list2Doc;
    }

    public void setList2Doc(String list2Doc) {
        this.list2Doc = list2Doc;
    }

    public String getList3Doc() {
        return this.list3Doc;
    }

    public void setList3Doc(String list3Doc) {
        this.list3Doc = list3Doc;
    }

    public String getList4Doc() {
        return this.list4Doc;
    }

    public void setList4Doc(String list4Doc) {
        this.list4Doc = list4Doc;
    }

    public String getList5Doc() {
        return this.list5Doc;
    }

    public void setList5Doc(String list5Doc) {
        this.list5Doc = list5Doc;
    }

    public String getList6Doc() {
        return this.list6Doc;
    }

    public void setList6Doc(String list6Doc) {
        this.list6Doc = list6Doc;
    }

    public String getList7Doc() {
        return this.list7Doc;
    }

    public void setList7Doc(String list7Doc) {
        this.list7Doc = list7Doc;
    }

    public String getList8Doc() {
        return this.list8Doc;
    }

    public void setList8Doc(String list8Doc) {
        this.list8Doc = list8Doc;
    }

    public String getList1DocUrl() {
        return this.list1DocUrl;
    }

    public void setList1DocUrl(String list1DocUrl) {
        this.list1DocUrl = list1DocUrl;
    }

    public String getList2DocUrl() {
        return this.list2DocUrl;
    }

    public void setList2DocUrl(String list2DocUrl) {
        this.list2DocUrl = list2DocUrl;
    }

    public String getList3DocUrl() {
        return this.list3DocUrl;
    }

    public void setList3DocUrl(String list3DocUrl) {
        this.list3DocUrl = list3DocUrl;
    }

    public String getList4DocUrl() {
        return this.list4DocUrl;
    }

    public void setList4DocUrl(String list4DocUrl) {
        this.list4DocUrl = list4DocUrl;
    }

    public String getList5DocUrl() {
        return this.list5DocUrl;
    }

    public void setList5DocUrl(String list5DocUrl) {
        this.list5DocUrl = list5DocUrl;
    }

    public String getList6DocUrl() {
        return this.list6DocUrl;
    }

    public void setList6DocUrl(String list6DocUrl) {
        this.list6DocUrl = list6DocUrl;
    }

    public String getList7DocUrl() {
        return this.list7DocUrl;
    }

    public void setList7DocUrl(String list7DocUrl) {
        this.list7DocUrl = list7DocUrl;
    }

    public String getAadharNo() {
        return this.aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getFathersOrGuardianName() {
        return this.fathersOrGuardianName;
    }

    public void setFathersOrGuardianName(String fathersOrGuardianName) {
        this.fathersOrGuardianName = fathersOrGuardianName;
    }

    public String getFathersOrGuardianEpicNo() {
        return this.fathersOrGuardianEpicNo;
    }

    public void setFathersOrGuardianEpicNo(String fathersOrGuardianEpicNo) {
        this.fathersOrGuardianEpicNo = fathersOrGuardianEpicNo;
    }

    public String getMothersName() {
        return this.mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getMothersEpicNo() {
        return this.mothersEpicNo;
    }

    public void setMothersEpicNo(String mothersEpicNo) {
        this.mothersEpicNo = mothersEpicNo;
    }

    public String getSpouseName() {
        return this.spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getSpouseEpicNo() {
        return this.spouseEpicNo;
    }

    public void setSpouseEpicNo(String spouseEpicNo) {
        this.spouseEpicNo = spouseEpicNo;
    }

    public String getAnnexureCUrl() {
        return this.annexureCUrl;
    }

    public void setAnnexureCUrl(String annexureCUrl) {
        this.annexureCUrl = annexureCUrl;
    }

    public String getPreRevisionVoterFlg() {
        return this.preRevisionVoterFlg;
    }

    public void setPreRevisionVoterFlg(String preRevisionVoterFlg) {
        this.preRevisionVoterFlg = preRevisionVoterFlg;
    }

    public String getPreRevisionVoterDocUrl() {
        return this.preRevisionVoterDocUrl;
    }

    public void setPreRevisionVoterDocUrl(String preRevisionVoterDocUrl) {
        this.preRevisionVoterDocUrl = preRevisionVoterDocUrl;
    }

    public String getSubmittedForRecommendation() {
        return this.submittedForRecommendation;
    }

    public void setSubmittedForRecommendation(String submittedForRecommendation) {
        this.submittedForRecommendation = submittedForRecommendation;
    }

    public String getFathersNationality() {
        return this.fathersNationality;
    }

    public void setFathersNationality(String fathersNationality) {
        this.fathersNationality = fathersNationality;
    }

    public String getMothersNationality() {
        return this.mothersNationality;
    }

    public void setMothersNationality(String mothersNationality) {
        this.mothersNationality = mothersNationality;
    }

    public String getSrFormPage2Url() {
        return this.srFormPage2Url;
    }

    public void setSrFormPage2Url(String srFormPage2Url) {
        this.srFormPage2Url = srFormPage2Url;
    }

    public String getOldAcNo() {
        return this.oldAcNo;
    }

    public void setOldAcNo(String oldAcNo) {
        this.oldAcNo = oldAcNo;
    }

    public String getOldPartNo() {
        return this.oldPartNo;
    }

    public void setOldPartNo(String oldPartNo) {
        this.oldPartNo = oldPartNo;
    }

    public String getOldPslNo() {
        return this.oldPslNo;
    }

    public void setOldPslNo(String oldPslNo) {
        this.oldPslNo = oldPslNo;
    }

    public String getDocumentUploadedFlg() {
        return this.documentUploadedFlg;
    }

    public void setDocumentUploadedFlg(String documentUploadedFlg) {
        this.documentUploadedFlg = documentUploadedFlg;
    }

    public String getList1docUrlPg2() {
        return this.list1docUrlPg2;
    }

    public void setList1docUrlPg2(String list1docUrlPg2) {
        this.list1docUrlPg2 = list1docUrlPg2;
    }

    public String getList2docUrlPg2() {
        return this.list2docUrlPg2;
    }

    public void setList2docUrlPg2(String list2docUrlPg2) {
        this.list2docUrlPg2 = list2docUrlPg2;
    }

    public String getList3docUrlPg2() {
        return this.list3docUrlPg2;
    }

    public void setList3docUrlPg2(String list3docUrlPg2) {
        this.list3docUrlPg2 = list3docUrlPg2;
    }

    public String getList4docUrlPg2() {
        return this.list4docUrlPg2;
    }

    public void setList4docUrlPg2(String list4docUrlPg2) {
        this.list4docUrlPg2 = list4docUrlPg2;
    }

    public String getList5docUrlPg2() {
        return this.list5docUrlPg2;
    }

    public void setList5docUrlPg2(String list5docUrlPg2) {
        this.list5docUrlPg2 = list5docUrlPg2;
    }

    public String getList5docUrlPg3() {
        return this.list5docUrlPg3;
    }

    public void setList5docUrlPg3(String list5docUrlPg3) {
        this.list5docUrlPg3 = list5docUrlPg3;
    }

    public String getList6docUrlPg2() {
        return this.list6docUrlPg2;
    }

    public void setList6docUrlPg2(String list6docUrlPg2) {
        this.list6docUrlPg2 = list6docUrlPg2;
    }

    public String getList7docUrlPg2() {
        return this.list7docUrlPg2;
    }

    public void setList7docUrlPg2(String list7docUrlPg2) {
        this.list7docUrlPg2 = list7docUrlPg2;
    }

    public String getPreRevisionVoterDocUrlPg2() {
        return this.preRevisionVoterDocUrlPg2;
    }

    public void setPreRevisionVoterDocUrlPg2(String preRevisionVoterDocUrlPg2) {
        this.preRevisionVoterDocUrlPg2 = preRevisionVoterDocUrlPg2;
    }

    public String getAnnexureCUrlPg2() {
        return this.annexureCUrlPg2;
    }

    public void setAnnexureCUrlPg2(String annexureCUrlPg2) {
        this.annexureCUrlPg2 = annexureCUrlPg2;
    }

    public String getFormSubmissionPlace() {
        return this.formSubmissionPlace;
    }

    public void setFormSubmissionPlace(String formSubmissionPlace) {
        this.formSubmissionPlace = formSubmissionPlace;
    }

    public String getCitizenSignatureFilepath() {
        return this.citizenSignatureFilepath;
    }

    public void setCitizenSignatureFilepath(String citizenSignatureFilepath) {
        this.citizenSignatureFilepath = citizenSignatureFilepath;
    }

    public String getMoldAcNo() {
        return this.moldAcNo;
    }

    public Long getEpicId() {
        return this.epicId;
    }

    public void setEpicId(Long epicId) {
        this.epicId = epicId;
    }

    public void setMoldAcNo(String moldAcNo) {
        this.moldAcNo = moldAcNo;
    }

    public String getMoldPartNo() {
        return this.moldPartNo;
    }

    public void setMoldPartNo(String moldPartNo) {
        this.moldPartNo = moldPartNo;
    }

    public String getMoldPslNo() {
        return this.moldPslNo;
    }

    public void setMoldPslNo(String moldPslNo) {
        this.moldPslNo = moldPslNo;
    }

    public String getFoldAcNo() {
        return this.foldAcNo;
    }

    public void setFoldAcNo(String foldAcNo) {
        this.foldAcNo = foldAcNo;
    }

    public String getFoldPartNo() {
        return this.foldPartNo;
    }

    public void setFoldPartNo(String foldPartNo) {
        this.foldPartNo = foldPartNo;
    }

    public String getFoldPslNo() {
        return this.foldPslNo;
    }

    public void setFoldPslNo(String foldPslNo) {
        this.foldPslNo = foldPslNo;
    }

    public String getElectorName() {
        return this.electorName;
    }

    public void setElectorName(String electorName) {
        this.electorName = electorName;
    }

    public String getBloOverridenFlg() {
        return this.bloOverridenFlg;
    }

    public void setBloOverridenFlg(String bloOverridenFlg) {
        this.bloOverridenFlg = bloOverridenFlg;
    }

    public String getBackToBlo() {
        return this.backToBlo;
    }

    public void setBackToBlo(String backToBlo) {
        this.backToBlo = backToBlo;
    }

    public String getBackToBloRemarks() {
        return this.backToBloRemarks;
    }

    public void setBackToBloRemarks(String backToBloRemarks) {
        this.backToBloRemarks = backToBloRemarks;
    }

    public String getRelationOldStateCd() {
        return this.relationOldStateCd;
    }

    public void setRelationOldStateCd(String relationOldStateCd) {
        this.relationOldStateCd = relationOldStateCd;
    }

    public String getOldStateCd() {
        return this.oldStateCd;
    }

    public void setOldStateCd(String oldStateCd) {
        this.oldStateCd = oldStateCd;
    }

    public String getErollAge() {
        return this.erollAge;
    }

    public void setErollAge(String erollAge) {
        this.erollAge = erollAge;
    }
}
