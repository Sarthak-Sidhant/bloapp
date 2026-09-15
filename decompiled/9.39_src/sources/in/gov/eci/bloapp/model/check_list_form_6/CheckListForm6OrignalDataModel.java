package in.gov.eci.bloapp.model.check_list_form_6;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class CheckListForm6OrignalDataModel implements Serializable {
    String aadharNumber;
    String aadharRefNo;
    String acNAme;
    String addressProofOthers;
    String adharLinkedMobileNumber;
    String ageAtFormSubmission;
    String ageDecl;
    String ageProofDocument;
    String ageProofOthers;
    String ageProofType;
    String anxDSignUrl;
    String applicantDate;
    String applicantGender;
    String applicantRelativeName;
    String applicantRelativeNameL1;
    String applicantRelativeNameL2;
    String applicantRelativeSurname;
    String applicantRelativeSurnameL1;
    String applicantRelativeSurnameL2;
    String applicantRlnWithMember;
    String applicantVerifiedDetailsConfirm;
    String applicationObjection;
    String applicationObjectionReason;
    String asmblyConstituencyNo;
    String assemblyName;
    String birthDistrictName;
    String birthDistrictNo;
    String birthStateCd;
    String birthStateName;
    String birthVillage;
    String citizenshipType;
    String citizenshipTypeCat;
    String consentToLinkAadhar;
    String createdBy;
    String creationDttm;
    String ctDocOfFatherUrl;
    String ctDocOfMotherUrl;
    String ctDocOfSelfUrl;
    String ctDocTypeForFather;
    String ctDocTypeForMother;
    String ctDocTypeForSelf;
    String currRelRelation;
    String currentAddressProofDocument;
    String currentAddressProofType;
    String currentAddressSameAsPermanentAddress;
    String currentAddressStayDate;
    String currentAddressTehL1;
    String currentAddressTehL2;
    String currentAddressTehTalMan;
    String currentDistrictCd;
    String currentHouseNumber;
    String currentHouseNumberL1;
    String currentHouseNumberL2;
    String currentLocality;
    String currentLocalityL1;
    String currentLocalityL2;
    String currentPinCode;
    String currentPostOffice;
    String currentPostOfficeL1;
    String currentPostOfficeL2;
    String currentRelEpic;
    String currentRelFullName;
    String currentRelRelationship;
    String currentStateCd;
    String currentVillageOrTown;
    String currentVillageOrTownL1;
    String currentVillageOrTownL2;
    String deathCertificate;
    String declDistrict;
    String declState;
    String declVillage;
    String declrBirthDocName;
    String decsirf6DeclCategory;
    String decsirf6DeclSignature;
    String decsirf6RefNo;
    String decsirf6formID;
    String disability;
    String disabilityCertAttached;
    String disabilityCertificate;
    String disabilityPercentage;
    String disabilityTypeLocomotor;
    String disabilityTypeOthers;
    String disabilityTypeSh;
    String disabilityTypeVi;
    String districtCd;
    String districtName;
    String dob;
    String dobcopy;
    String electorAcNo;
    String electorAssemblyName;
    String electorDistrictCd;
    String electorName;
    String electorPartNumber;
    String electorPartSerialNumber;
    String electorRelationShip;
    String electorRelativeName;
    String electorStateCd;
    String electorStateName;
    String electorepicNumber;
    String electorsRelation;
    String email;
    String epicNumberFamilyMember;
    String familOrNeighbourAadharNumber;
    String fatherorGuardianEpicNo;
    String fatherorGuardianname;
    String firstName;
    String firstNameL1;
    String firstNameL2;
    String firstTimeVoter;
    String form6Id;
    String formSubmissionChannel;
    String formSubmissionDate;
    String formSubmissionMode;
    String formSubmissionPlace;
    String genderDesc;
    String isDraft;
    String isExistingElector;
    String isParentsIndian;
    String isReinitiated;
    String isSir03;
    String isSir2526;
    String isVip;
    String lastName;
    String lastNameL1;
    String lastNameL2;
    String middleName;
    String mobileNumber;
    String modifiedBy;
    String modifiedDttm;
    String motherEpicNo;
    String motherName;
    String nameChangeDoc;
    String nationalityProof;
    String ordinaryResDate;
    String ordinaryResidenceSameOrNot;
    String outSideIndiaSameOrNot;
    String partNumber;
    String pcName;
    String pcNo;
    String photograph;
    String preEpicNo;
    String prevAcNo;
    String prevDistrictNo;
    String prevEpicExists;
    String prevHouseNo;
    String prevHouseNoV1;
    String prevPinCode;
    String prevPostOffice;
    String prevStateCode;
    String prevStreetArea;
    String prevVillage;
    String prmntAddressProofDocument;
    String prmntAddressProofType;
    String prmntDistrictCd;
    String prmntHouseNumber;
    String prmntHouseNumberL1;
    String prmntHouseNumberL2;
    String prmntLocality;
    String prmntLocalityL1;
    String prmntLocalityL2;
    String prmntPinCode;
    String prmntPostOffice;
    String prmntPostOfficeL1;
    String prmntPostOfficeL2;
    String prmntStateCd;
    String prmntVillageOrTown;
    String prmntVillageOrTownL1;
    String prmntVillageOrTownL2;
    String prvsEpic;
    String referenceNumber;
    String relationDesc;
    String relativeAcName;
    String relativeAcNo;
    String relativeDistrictCd;
    String relativeEmail;
    String relativeEpicNumber;
    String relativeMobile;
    String relativeName;
    String relativePartNo;
    String relativePartSerialNumber;
    String relativeRelationShip;
    String relativeRelativeName;
    String relativeStateCd;
    String relativeStateName;
    String residingInIndia;
    String scannedChecklist1;
    String scannedChecklist2;
    String scannedFromPage1;
    String scannedFromPage2;
    String scannedFromPage3;
    String sectionNo;
    String selfOrOtherMember;
    String serialNumber;
    String shiftingFromConstituency;
    String spouseEpicNo;
    String spouseName;
    String stateCd;
    String stateName;
    String typeOfRelation;
    String uncollectableSir;
    String validationOfAadhar;
    String visaSameOrNot;
    ArrayList<String> relationList = new ArrayList<>();
    ArrayList<String> addressPoofList = new ArrayList<>();
    ArrayList<String> ageProofList = new ArrayList<>();

    public String getIsReinitiated() {
        return this.isReinitiated;
    }

    public void setIsReinitiated(String isReinitiated) {
        this.isReinitiated = isReinitiated;
    }

    public String getAcNAme() {
        return this.acNAme;
    }

    public void setAcNAme(String acNAme) {
        this.acNAme = acNAme;
    }

    public String getPcNo() {
        return this.pcNo;
    }

    public void setPcNo(String pcNo) {
        this.pcNo = pcNo;
    }

    public String getPcName() {
        return this.pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public String getDisabilityPercentage() {
        return this.disabilityPercentage;
    }

    public void setDisabilityPercentage(String disabilityPercentage) {
        this.disabilityPercentage = disabilityPercentage;
    }

    public String getCurrentRelEpic() {
        return this.currentRelEpic;
    }

    public void setCurrentRelEpic(String currentRelEpic) {
        this.currentRelEpic = currentRelEpic;
    }

    public String getAgeProofOthers() {
        return this.ageProofOthers;
    }

    public void setAgeProofOthers(String ageProofOthers) {
        this.ageProofOthers = ageProofOthers;
    }

    public String getAddressProofOthers() {
        return this.addressProofOthers;
    }

    public void setAddressProofOthers(String addressProofOthers) {
        this.addressProofOthers = addressProofOthers;
    }

    public String getTypeOfRelation() {
        return this.typeOfRelation;
    }

    public void setTypeOfRelation(String typeOfRelation) {
        this.typeOfRelation = typeOfRelation;
    }

    public String getPrevAcNo() {
        return this.prevAcNo;
    }

    public void setPrevAcNo(String prevAcNo) {
        this.prevAcNo = prevAcNo;
    }

    public String getIsVip() {
        return this.isVip;
    }

    public void setIsVip(String isVip) {
        this.isVip = isVip;
    }

    public String getPrmntAddressProofDocument() {
        return this.prmntAddressProofDocument;
    }

    public void setPrmntAddressProofDocument(String prmntAddressProofDocument) {
        this.prmntAddressProofDocument = prmntAddressProofDocument;
    }

    public String getDisabilityTypeVi() {
        return this.disabilityTypeVi;
    }

    public void setDisabilityTypeVi(String disabilityTypeVi) {
        this.disabilityTypeVi = disabilityTypeVi;
    }

    public String getDisabilityTypeSh() {
        return this.disabilityTypeSh;
    }

    public void setDisabilityTypeSh(String disabilityTypeSh) {
        this.disabilityTypeSh = disabilityTypeSh;
    }

    public String getCurrentAddressProofType() {
        return this.currentAddressProofType;
    }

    public void setCurrentAddressProofType(String currentAddressProofType) {
        this.currentAddressProofType = currentAddressProofType;
    }

    public String getCurrentAddressProofDocument() {
        return this.currentAddressProofDocument;
    }

    public void setCurrentAddressProofDocument(String currentAddressProofDocument) {
        this.currentAddressProofDocument = currentAddressProofDocument;
    }

    public String getPrmntAddressProofType() {
        return this.prmntAddressProofType;
    }

    public void setPrmntAddressProofType(String prmntAddressProofType) {
        this.prmntAddressProofType = prmntAddressProofType;
    }

    public String getNationalityProof() {
        return this.nationalityProof;
    }

    public void setNationalityProof(String nationalityProof) {
        this.nationalityProof = nationalityProof;
    }

    public String getIsDraft() {
        return this.isDraft;
    }

    public void setIsDraft(String isDraft) {
        this.isDraft = isDraft;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getScannedChecklist1() {
        return this.scannedChecklist1;
    }

    public void setScannedChecklist1(String scannedChecklist1) {
        this.scannedChecklist1 = scannedChecklist1;
    }

    public String getScannedChecklist2() {
        return this.scannedChecklist2;
    }

    public void setScannedChecklist2(String scannedChecklist2) {
        this.scannedChecklist2 = scannedChecklist2;
    }

    public String getNameChangeDoc() {
        return this.nameChangeDoc;
    }

    public void setNameChangeDoc(String nameChangeDoc) {
        this.nameChangeDoc = nameChangeDoc;
    }

    public String getPreEpicNo() {
        return this.preEpicNo;
    }

    public void setPreEpicNo(String preEpicNo) {
        this.preEpicNo = preEpicNo;
    }

    public String getPrevHouseNo() {
        return this.prevHouseNo;
    }

    public void setPrevHouseNo(String prevHouseNo) {
        this.prevHouseNo = prevHouseNo;
    }

    public String getPrevHouseNoV1() {
        return this.prevHouseNoV1;
    }

    public void setPrevHouseNoV1(String prevHouseNoV1) {
        this.prevHouseNoV1 = prevHouseNoV1;
    }

    public String getPrevStreetArea() {
        return this.prevStreetArea;
    }

    public void setPrevStreetArea(String prevStreetArea) {
        this.prevStreetArea = prevStreetArea;
    }

    public String getPrevVillage() {
        return this.prevVillage;
    }

    public void setPrevVillage(String prevVillage) {
        this.prevVillage = prevVillage;
    }

    public String getPrevPostOffice() {
        return this.prevPostOffice;
    }

    public void setPrevPostOffice(String prevPostOffice) {
        this.prevPostOffice = prevPostOffice;
    }

    public String getPrevPinCode() {
        return this.prevPinCode;
    }

    public void setPrevPinCode(String prevPinCode) {
        this.prevPinCode = prevPinCode;
    }

    public String getPrevDistrictNo() {
        return this.prevDistrictNo;
    }

    public void setPrevDistrictNo(String prevDistrictNo) {
        this.prevDistrictNo = prevDistrictNo;
    }

    public String getFormSubmissionMode() {
        return this.formSubmissionMode;
    }

    public void setFormSubmissionMode(String formSubmissionMode) {
        this.formSubmissionMode = formSubmissionMode;
    }

    public String getFormSubmissionChannel() {
        return this.formSubmissionChannel;
    }

    public void setFormSubmissionChannel(String formSubmissionChannel) {
        this.formSubmissionChannel = formSubmissionChannel;
    }

    public String getModifiedDttm() {
        return this.modifiedDttm;
    }

    public void setModifiedDttm(String modifiedDttm) {
        this.modifiedDttm = modifiedDttm;
    }

    public String getApplicantRelativeSurnameL1() {
        return this.applicantRelativeSurnameL1;
    }

    public void setApplicantRelativeSurnameL1(String applicantRelativeSurnameL1) {
        this.applicantRelativeSurnameL1 = applicantRelativeSurnameL1;
    }

    public String getApplicantRelativeSurnameL2() {
        return this.applicantRelativeSurnameL2;
    }

    public void setApplicantRelativeSurnameL2(String applicantRelativeSurnameL2) {
        this.applicantRelativeSurnameL2 = applicantRelativeSurnameL2;
    }

    public String getAdharLinkedMobileNumber() {
        return this.adharLinkedMobileNumber;
    }

    public void setAdharLinkedMobileNumber(String adharLinkedMobileNumber) {
        this.adharLinkedMobileNumber = adharLinkedMobileNumber;
    }

    public String getEpicNumberFamilyMember() {
        return this.epicNumberFamilyMember;
    }

    public void setEpicNumberFamilyMember(String epicNumberFamilyMember) {
        this.epicNumberFamilyMember = epicNumberFamilyMember;
    }

    public String getFamilOrNeighbourAadharNumber() {
        return this.familOrNeighbourAadharNumber;
    }

    public void setFamilOrNeighbourAadharNumber(String familOrNeighbourAadharNumber) {
        this.familOrNeighbourAadharNumber = familOrNeighbourAadharNumber;
    }

    public String getAgeAtFormSubmission() {
        return this.ageAtFormSubmission;
    }

    public void setAgeAtFormSubmission(String ageAtFormSubmission) {
        this.ageAtFormSubmission = ageAtFormSubmission;
    }

    public String getLastNameL2() {
        return this.lastNameL2;
    }

    public void setLastNameL2(String lastNameL2) {
        this.lastNameL2 = lastNameL2;
    }

    public String getApplicantRelativeNameL1() {
        return this.applicantRelativeNameL1;
    }

    public void setApplicantRelativeNameL1(String applicantRelativeNameL1) {
        this.applicantRelativeNameL1 = applicantRelativeNameL1;
    }

    public String getApplicantRelativeNameL2() {
        return this.applicantRelativeNameL2;
    }

    public void setApplicantRelativeNameL2(String applicantRelativeNameL2) {
        this.applicantRelativeNameL2 = applicantRelativeNameL2;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDisabilityTypeLocomotor() {
        return this.disabilityTypeLocomotor;
    }

    public void setDisabilityTypeLocomotor(String disabilityTypeLocomotor) {
        this.disabilityTypeLocomotor = disabilityTypeLocomotor;
    }

    public String getDisabilityTypeOthers() {
        return this.disabilityTypeOthers;
    }

    public void setDisabilityTypeOthers(String disabilityTypeOthers) {
        this.disabilityTypeOthers = disabilityTypeOthers;
    }

    public String getDisabilityCertificate() {
        return this.disabilityCertificate;
    }

    public void setDisabilityCertificate(String disabilityCertificate) {
        this.disabilityCertificate = disabilityCertificate;
    }

    public String getPrmntLocality() {
        return this.prmntLocality;
    }

    public void setPrmntLocality(String prmntLocality) {
        this.prmntLocality = prmntLocality;
    }

    public String getPrmntVillageOrTown() {
        return this.prmntVillageOrTown;
    }

    public void setPrmntVillageOrTown(String prmntVillageOrTown) {
        this.prmntVillageOrTown = prmntVillageOrTown;
    }

    public String getPrmntPostOffice() {
        return this.prmntPostOffice;
    }

    public void setPrmntPostOffice(String prmntPostOffice) {
        this.prmntPostOffice = prmntPostOffice;
    }

    public String getCurrentPostOfficeL1() {
        return this.currentPostOfficeL1;
    }

    public void setCurrentPostOfficeL1(String currentPostOfficeL1) {
        this.currentPostOfficeL1 = currentPostOfficeL1;
    }

    public String getCurrentPostOfficeL2() {
        return this.currentPostOfficeL2;
    }

    public void setCurrentPostOfficeL2(String currentPostOfficeL2) {
        this.currentPostOfficeL2 = currentPostOfficeL2;
    }

    public String getCurrentPinCode() {
        return this.currentPinCode;
    }

    public void setCurrentPinCode(String currentPinCode) {
        this.currentPinCode = currentPinCode;
    }

    public String getPrmntHouseNumberL1() {
        return this.prmntHouseNumberL1;
    }

    public void setPrmntHouseNumberL1(String prmntHouseNumberL1) {
        this.prmntHouseNumberL1 = prmntHouseNumberL1;
    }

    public String getPrmntHouseNumberL2() {
        return this.prmntHouseNumberL2;
    }

    public void setPrmntHouseNumberL2(String prmntHouseNumberL2) {
        this.prmntHouseNumberL2 = prmntHouseNumberL2;
    }

    public String getPrmntLocalityL1() {
        return this.prmntLocalityL1;
    }

    public void setPrmntLocalityL1(String prmntLocalityL1) {
        this.prmntLocalityL1 = prmntLocalityL1;
    }

    public String getPrmntLocalityL2() {
        return this.prmntLocalityL2;
    }

    public void setPrmntLocalityL2(String prmntLocalityL2) {
        this.prmntLocalityL2 = prmntLocalityL2;
    }

    public String getSelfOrOtherMember() {
        return this.selfOrOtherMember;
    }

    public void setSelfOrOtherMember(String selfOrOtherMember) {
        this.selfOrOtherMember = selfOrOtherMember;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getApplicantRelativeName() {
        return this.applicantRelativeName;
    }

    public void setApplicantRelativeName(String applicantRelativeName) {
        this.applicantRelativeName = applicantRelativeName;
    }

    public String getApplicantRelativeSurname() {
        return this.applicantRelativeSurname;
    }

    public void setApplicantRelativeSurname(String applicantRelativeSurname) {
        this.applicantRelativeSurname = applicantRelativeSurname;
    }

    public String getFirstNameL1() {
        return this.firstNameL1;
    }

    public void setFirstNameL1(String firstNameL1) {
        this.firstNameL1 = firstNameL1;
    }

    public String getFirstNameL2() {
        return this.firstNameL2;
    }

    public void setFirstNameL2(String firstNameL2) {
        this.firstNameL2 = firstNameL2;
    }

    public String getLastNameL1() {
        return this.lastNameL1;
    }

    public void setLastNameL1(String lastNameL1) {
        this.lastNameL1 = lastNameL1;
    }

    public String getAsmblyConstituencyNo() {
        return this.asmblyConstituencyNo;
    }

    public void setAsmblyConstituencyNo(String asmblyConstituencyNo) {
        this.asmblyConstituencyNo = asmblyConstituencyNo;
    }

    public String getStateCd() {
        return this.stateCd;
    }

    public void setStateCd(String stateCd) {
        this.stateCd = stateCd;
    }

    public String getApplicantRlnWithMember() {
        return this.applicantRlnWithMember;
    }

    public void setApplicantRlnWithMember(String applicantRlnWithMember) {
        this.applicantRlnWithMember = applicantRlnWithMember;
    }

    public String getAadharRefNo() {
        return this.aadharRefNo;
    }

    public void setAadharRefNo(String aadharRefNo) {
        this.aadharRefNo = aadharRefNo;
    }

    public String getCurrentAddressTehL1() {
        return this.currentAddressTehL1;
    }

    public void setCurrentAddressTehL1(String currentAddressTehL1) {
        this.currentAddressTehL1 = currentAddressTehL1;
    }

    public String getCurrentAddressTehL2() {
        return this.currentAddressTehL2;
    }

    public void setCurrentAddressTehL2(String currentAddressTehL2) {
        this.currentAddressTehL2 = currentAddressTehL2;
    }

    public String getBirthStateName() {
        return this.birthStateName;
    }

    public void setBirthStateName(String birthStateName) {
        this.birthStateName = birthStateName;
    }

    public String getRelativeMobile() {
        return this.relativeMobile;
    }

    public void setRelativeMobile(String relativeMobile) {
        this.relativeMobile = relativeMobile;
    }

    public String getRelativeEmail() {
        return this.relativeEmail;
    }

    public void setRelativeEmail(String relativeEmail) {
        this.relativeEmail = relativeEmail;
    }

    public String getCurrentRelFullName() {
        return this.currentRelFullName;
    }

    public void setCurrentRelFullName(String currentRelFullName) {
        this.currentRelFullName = currentRelFullName;
    }

    public String getCurrentRelRelationship() {
        return this.currentRelRelationship;
    }

    public void setCurrentRelRelationship(String currentRelRelationship) {
        this.currentRelRelationship = currentRelRelationship;
    }

    public String getCurrentAddressTehTalMan() {
        return this.currentAddressTehTalMan;
    }

    public void setCurrentAddressTehTalMan(String currentAddressTehTalMan) {
        this.currentAddressTehTalMan = currentAddressTehTalMan;
    }

    public String getAssemblyName() {
        return this.assemblyName;
    }

    public void setAssemblyName(String assemblyName) {
        this.assemblyName = assemblyName;
    }

    public String getGenderDesc() {
        return this.genderDesc;
    }

    public void setGenderDesc(String genderDesc) {
        this.genderDesc = genderDesc;
    }

    public String getRelationDesc() {
        return this.relationDesc;
    }

    public void setRelationDesc(String relationDesc) {
        this.relationDesc = relationDesc;
    }

    public String getCurrRelRelation() {
        return this.currRelRelation;
    }

    public void setCurrRelRelation(String currRelRelation) {
        this.currRelRelation = currRelRelation;
    }

    public String getDeclVillage() {
        return this.declVillage;
    }

    public void setDeclVillage(String declVillage) {
        this.declVillage = declVillage;
    }

    public String getDeclState() {
        return this.declState;
    }

    public void setDeclState(String declState) {
        this.declState = declState;
    }

    public String getDeclDistrict() {
        return this.declDistrict;
    }

    public void setDeclDistrict(String declDistrict) {
        this.declDistrict = declDistrict;
    }

    public String getAgeDecl() {
        return this.ageDecl;
    }

    public void setAgeDecl(String ageDecl) {
        this.ageDecl = ageDecl;
    }

    public String getScannedFromPage1() {
        return this.scannedFromPage1;
    }

    public void setScannedFromPage1(String scannedFromPage1) {
        this.scannedFromPage1 = scannedFromPage1;
    }

    public String getScannedFromPage2() {
        return this.scannedFromPage2;
    }

    public void setScannedFromPage2(String scannedFromPage2) {
        this.scannedFromPage2 = scannedFromPage2;
    }

    public String getScannedFromPage3() {
        return this.scannedFromPage3;
    }

    public void setScannedFromPage3(String scannedFromPage3) {
        this.scannedFromPage3 = scannedFromPage3;
    }

    public String getApplicantGender() {
        return this.applicantGender;
    }

    public void setApplicantGender(String applicantGender) {
        this.applicantGender = applicantGender;
    }

    public String getConsentToLinkAadhar() {
        return this.consentToLinkAadhar;
    }

    public void setConsentToLinkAadhar(String consentToLinkAadhar) {
        this.consentToLinkAadhar = consentToLinkAadhar;
    }

    public String getAadharNumber() {
        return this.aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getValidationOfAadhar() {
        return this.validationOfAadhar;
    }

    public void setValidationOfAadhar(String validationOfAadhar) {
        this.validationOfAadhar = validationOfAadhar;
    }

    public String getResidingInIndia() {
        return this.residingInIndia;
    }

    public void setResidingInIndia(String residingInIndia) {
        this.residingInIndia = residingInIndia;
    }

    public String getFirstTimeVoter() {
        return this.firstTimeVoter;
    }

    public void setFirstTimeVoter(String firstTimeVoter) {
        this.firstTimeVoter = firstTimeVoter;
    }

    public String getShiftingFromConstituency() {
        return this.shiftingFromConstituency;
    }

    public void setShiftingFromConstituency(String shiftingFromConstituency) {
        this.shiftingFromConstituency = shiftingFromConstituency;
    }

    public String getCurrentAddressSameAsPermanentAddress() {
        return this.currentAddressSameAsPermanentAddress;
    }

    public void setCurrentAddressSameAsPermanentAddress(String currentAddressSameAsPermanentAddress) {
        this.currentAddressSameAsPermanentAddress = currentAddressSameAsPermanentAddress;
    }

    public String getCurrentStateCd() {
        return this.currentStateCd;
    }

    public void setCurrentStateCd(String currentStateCd) {
        this.currentStateCd = currentStateCd;
    }

    public String getCurrentDistrictCd() {
        return this.currentDistrictCd;
    }

    public void setCurrentDistrictCd(String currentDistrictCd) {
        this.currentDistrictCd = currentDistrictCd;
    }

    public String getCurrentLocalityL2() {
        return this.currentLocalityL2;
    }

    public void setCurrentLocalityL2(String currentLocalityL2) {
        this.currentLocalityL2 = currentLocalityL2;
    }

    public String getCurrentVillageOrTownL1() {
        return this.currentVillageOrTownL1;
    }

    public void setCurrentVillageOrTownL1(String currentVillageOrTownL1) {
        this.currentVillageOrTownL1 = currentVillageOrTownL1;
    }

    public String getCurrentVillageOrTownL2() {
        return this.currentVillageOrTownL2;
    }

    public void setCurrentVillageOrTownL2(String currentVillageOrTownL2) {
        this.currentVillageOrTownL2 = currentVillageOrTownL2;
    }

    public String getDisability() {
        return this.disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getFormSubmissionPlace() {
        return this.formSubmissionPlace;
    }

    public void setFormSubmissionPlace(String formSubmissionPlace) {
        this.formSubmissionPlace = formSubmissionPlace;
    }

    public String getFormSubmissionDate() {
        return this.formSubmissionDate;
    }

    public void setFormSubmissionDate(String formSubmissionDate) {
        this.formSubmissionDate = formSubmissionDate;
    }

    public String getCurrentPostOffice() {
        return this.currentPostOffice;
    }

    public void setCurrentPostOffice(String currentPostOffice) {
        this.currentPostOffice = currentPostOffice;
    }

    public String getCurrentHouseNumberL1() {
        return this.currentHouseNumberL1;
    }

    public void setCurrentHouseNumberL1(String currentHouseNumberL1) {
        this.currentHouseNumberL1 = currentHouseNumberL1;
    }

    public String getCurrentHouseNumberL2() {
        return this.currentHouseNumberL2;
    }

    public void setCurrentHouseNumberL2(String currentHouseNumberL2) {
        this.currentHouseNumberL2 = currentHouseNumberL2;
    }

    public String getCurrentLocalityL1() {
        return this.currentLocalityL1;
    }

    public void setCurrentLocalityL1(String currentLocalityL1) {
        this.currentLocalityL1 = currentLocalityL1;
    }

    public String getCurrentHouseNumber() {
        return this.currentHouseNumber;
    }

    public void setCurrentHouseNumber(String currentHouseNumber) {
        this.currentHouseNumber = currentHouseNumber;
    }

    public String getCurrentLocality() {
        return this.currentLocality;
    }

    public void setCurrentLocality(String currentLocality) {
        this.currentLocality = currentLocality;
    }

    public String getCurrentVillageOrTown() {
        return this.currentVillageOrTown;
    }

    public void setCurrentVillageOrTown(String currentVillageOrTown) {
        this.currentVillageOrTown = currentVillageOrTown;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrentAddressStayDate() {
        return this.currentAddressStayDate;
    }

    public void setCurrentAddressStayDate(String currentAddressStayDate) {
        this.currentAddressStayDate = currentAddressStayDate;
    }

    public String getPrmntStateCd() {
        return this.prmntStateCd;
    }

    public void setPrmntStateCd(String prmntStateCd) {
        this.prmntStateCd = prmntStateCd;
    }

    public String getPrmntDistrictCd() {
        return this.prmntDistrictCd;
    }

    public void setPrmntDistrictCd(String prmntDistrictCd) {
        this.prmntDistrictCd = prmntDistrictCd;
    }

    public String getPrmntHouseNumber() {
        return this.prmntHouseNumber;
    }

    public void setPrmntHouseNumber(String prmntHouseNumber) {
        this.prmntHouseNumber = prmntHouseNumber;
    }

    public String getBirthDistrictName() {
        return this.birthDistrictName;
    }

    public void setBirthDistrictName(String birthDistrictName) {
        this.birthDistrictName = birthDistrictName;
    }

    public String getPrmntPostOfficeL2() {
        return this.prmntPostOfficeL2;
    }

    public void setPrmntPostOfficeL2(String prmntPostOfficeL2) {
        this.prmntPostOfficeL2 = prmntPostOfficeL2;
    }

    public String getPrmntPinCode() {
        return this.prmntPinCode;
    }

    public void setPrmntPinCode(String prmntPinCode) {
        this.prmntPinCode = prmntPinCode;
    }

    public String getPhotograph() {
        return this.photograph;
    }

    public void setPhotograph(String photograph) {
        this.photograph = photograph;
    }

    public String getPrmntVillageOrTownL1() {
        return this.prmntVillageOrTownL1;
    }

    public void setPrmntVillageOrTownL1(String prmntVillageOrTownL1) {
        this.prmntVillageOrTownL1 = prmntVillageOrTownL1;
    }

    public String getPrmntVillageOrTownL2() {
        return this.prmntVillageOrTownL2;
    }

    public void setPrmntVillageOrTownL2(String prmntVillageOrTownL2) {
        this.prmntVillageOrTownL2 = prmntVillageOrTownL2;
    }

    public String getPrmntPostOfficeL1() {
        return this.prmntPostOfficeL1;
    }

    public void setPrmntPostOfficeL1(String prmntPostOfficeL1) {
        this.prmntPostOfficeL1 = prmntPostOfficeL1;
    }

    public String getReferenceNumber() {
        return this.referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getStateName() {
        return this.stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getDistrictCd() {
        return this.districtCd;
    }

    public void setDistrictCd(String districtCd) {
        this.districtCd = districtCd;
    }

    public String getDistrictName() {
        return this.districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getPartNumber() {
        return this.partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getSectionNo() {
        return this.sectionNo;
    }

    public void setSectionNo(String sectionNo) {
        this.sectionNo = sectionNo;
    }

    public String getCreationDttm() {
        return this.creationDttm;
    }

    public void setCreationDttm(String creationDttm) {
        this.creationDttm = creationDttm;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getForm6Id() {
        return this.form6Id;
    }

    public void setForm6Id(String form6Id) {
        this.form6Id = form6Id;
    }

    public String getDisabilityCertAttached() {
        return this.disabilityCertAttached;
    }

    public void setDisabilityCertAttached(String disabilityCertAttached) {
        this.disabilityCertAttached = disabilityCertAttached;
    }

    public String getOrdinaryResDate() {
        return this.ordinaryResDate;
    }

    public void setOrdinaryResDate(String ordinaryResDate) {
        this.ordinaryResDate = ordinaryResDate;
    }

    public String getDeclrBirthDocName() {
        return this.declrBirthDocName;
    }

    public void setDeclrBirthDocName(String declrBirthDocName) {
        this.declrBirthDocName = declrBirthDocName;
    }

    public String getAgeProofType() {
        return this.ageProofType;
    }

    public void setAgeProofType(String ageProofType) {
        this.ageProofType = ageProofType;
    }

    public String getAgeProofDocument() {
        return this.ageProofDocument;
    }

    public void setAgeProofDocument(String ageProofDocument) {
        this.ageProofDocument = ageProofDocument;
    }

    public String getApplicantDate() {
        return this.applicantDate;
    }

    public void setApplicantDate(String applicantDate) {
        this.applicantDate = applicantDate;
    }

    public String getPrevStateCode() {
        return this.prevStateCode;
    }

    public void setPrevStateCode(String prevStateCode) {
        this.prevStateCode = prevStateCode;
    }

    public String getBirthVillage() {
        return this.birthVillage;
    }

    public void setBirthVillage(String birthVillage) {
        this.birthVillage = birthVillage;
    }

    public String getBirthDistrictNo() {
        return this.birthDistrictNo;
    }

    public void setBirthDistrictNo(String birthDistrictNo) {
        this.birthDistrictNo = birthDistrictNo;
    }

    public String getBirthStateCd() {
        return this.birthStateCd;
    }

    public void setBirthStateCd(String birthStateCd) {
        this.birthStateCd = birthStateCd;
    }

    public String getPrevEpicExists() {
        return this.prevEpicExists;
    }

    public void setPrevEpicExists(String prevEpicExists) {
        this.prevEpicExists = prevEpicExists;
    }

    public ArrayList<String> getRelationList() {
        return this.relationList;
    }

    public void setRelationList(ArrayList<String> relationList) {
        this.relationList = relationList;
    }

    public ArrayList<String> getAddressPoofList() {
        return this.addressPoofList;
    }

    public void setAddressPoofList(ArrayList<String> addressPoofList) {
        this.addressPoofList = addressPoofList;
    }

    public ArrayList<String> getAgeProofList() {
        return this.ageProofList;
    }

    public void setAgeProofList(ArrayList<String> ageProofList) {
        this.ageProofList = ageProofList;
    }

    public String getVisaSameOrNot() {
        return this.visaSameOrNot;
    }

    public void setVisaSameOrNot(String visaSameOrNot) {
        this.visaSameOrNot = visaSameOrNot;
    }

    public String getOrdinaryResidenceSameOrNot() {
        return this.ordinaryResidenceSameOrNot;
    }

    public void setOrdinaryResidenceSameOrNot(String ordinaryResidenceSameOrNot) {
        this.ordinaryResidenceSameOrNot = ordinaryResidenceSameOrNot;
    }

    public String getOutSideIndiaSameOrNot() {
        return this.outSideIndiaSameOrNot;
    }

    public void setOutSideIndiaSameOrNot(String outSideIndiaSameOrNot) {
        this.outSideIndiaSameOrNot = outSideIndiaSameOrNot;
    }

    public String getApplicantVerifiedDetailsConfirm() {
        return this.applicantVerifiedDetailsConfirm;
    }

    public void setApplicantVerifiedDetailsConfirm(String applicantVerifiedDetailsConfirm) {
        this.applicantVerifiedDetailsConfirm = applicantVerifiedDetailsConfirm;
    }

    public String getApplicationObjection() {
        return this.applicationObjection;
    }

    public void setApplicationObjection(String applicationObjection) {
        this.applicationObjection = applicationObjection;
    }

    public String getApplicationObjectionReason() {
        return this.applicationObjectionReason;
    }

    public void setApplicationObjectionReason(String applicationObjectionReason) {
        this.applicationObjectionReason = applicationObjectionReason;
    }

    public String getDeathCertificate() {
        return this.deathCertificate;
    }

    public void setDeathCertificate(String deathCertificate) {
        this.deathCertificate = deathCertificate;
    }

    public String getCitizenshipTypeCat() {
        return this.citizenshipTypeCat;
    }

    public void setCitizenshipTypeCat(String citizenshipTypeCat) {
        this.citizenshipTypeCat = citizenshipTypeCat;
    }

    public String getUncollectableSir() {
        return this.uncollectableSir;
    }

    public void setUncollectableSir(String uncollectableSir) {
        this.uncollectableSir = uncollectableSir;
    }

    public String getIsExistingElector() {
        return this.isExistingElector;
    }

    public void setIsExistingElector(String isExistingElector) {
        this.isExistingElector = isExistingElector;
    }

    public String getPrvsEpic() {
        return this.prvsEpic;
    }

    public void setPrvsEpic(String prvsEpic) {
        this.prvsEpic = prvsEpic;
    }

    public String getAnxDSignUrl() {
        return this.anxDSignUrl;
    }

    public void setAnxDSignUrl(String anxDSignUrl) {
        this.anxDSignUrl = anxDSignUrl;
    }

    public String getCitizenshipType() {
        return this.citizenshipType;
    }

    public void setCitizenshipType(String citizenshipType) {
        this.citizenshipType = citizenshipType;
    }

    public String getCtDocOfFatherUrl() {
        return this.ctDocOfFatherUrl;
    }

    public void setCtDocOfFatherUrl(String ctDocOfFatherUrl) {
        this.ctDocOfFatherUrl = ctDocOfFatherUrl;
    }

    public String getCtDocOfMotherUrl() {
        return this.ctDocOfMotherUrl;
    }

    public void setCtDocOfMotherUrl(String ctDocOfMotherUrl) {
        this.ctDocOfMotherUrl = ctDocOfMotherUrl;
    }

    public String getCtDocOfSelfUrl() {
        return this.ctDocOfSelfUrl;
    }

    public void setCtDocOfSelfUrl(String ctDocOfSelfUrl) {
        this.ctDocOfSelfUrl = ctDocOfSelfUrl;
    }

    public String getCtDocTypeForFather() {
        return this.ctDocTypeForFather;
    }

    public void setCtDocTypeForFather(String ctDocTypeForFather) {
        this.ctDocTypeForFather = ctDocTypeForFather;
    }

    public String getCtDocTypeForMother() {
        return this.ctDocTypeForMother;
    }

    public void setCtDocTypeForMother(String ctDocTypeForMother) {
        this.ctDocTypeForMother = ctDocTypeForMother;
    }

    public String getCtDocTypeForSelf() {
        return this.ctDocTypeForSelf;
    }

    public void setCtDocTypeForSelf(String ctDocTypeForSelf) {
        this.ctDocTypeForSelf = ctDocTypeForSelf;
    }

    public String getIsParentsIndian() {
        return this.isParentsIndian;
    }

    public void setIsParentsIndian(String isParentsIndian) {
        this.isParentsIndian = isParentsIndian;
    }

    public String getDobcopy() {
        return this.dobcopy;
    }

    public void setDobcopy(String dobcopy) {
        this.dobcopy = dobcopy;
    }

    public String getElectorStateCd() {
        return this.electorStateCd;
    }

    public void setElectorStateCd(String electorStateCd) {
        this.electorStateCd = electorStateCd;
    }

    public String getElectorDistrictCd() {
        return this.electorDistrictCd;
    }

    public void setElectorDistrictCd(String electorDistrictCd) {
        this.electorDistrictCd = electorDistrictCd;
    }

    public String getElectorAcNo() {
        return this.electorAcNo;
    }

    public void setElectorAcNo(String electorAcNo) {
        this.electorAcNo = electorAcNo;
    }

    public String getElectorAssemblyName() {
        return this.electorAssemblyName;
    }

    public void setElectorAssemblyName(String electorAssemblyName) {
        this.electorAssemblyName = electorAssemblyName;
    }

    public String getElectorRelationShip() {
        return this.electorRelationShip;
    }

    public void setElectorRelationShip(String electorRelationShip) {
        this.electorRelationShip = electorRelationShip;
    }

    public String getElectorRelativeName() {
        return this.electorRelativeName;
    }

    public void setElectorRelativeName(String electorRelativeName) {
        this.electorRelativeName = electorRelativeName;
    }

    public String getElectorepicNumber() {
        return this.electorepicNumber;
    }

    public void setElectorepicNumber(String electorepicNumber) {
        this.electorepicNumber = electorepicNumber;
    }

    public String getElectorName() {
        return this.electorName;
    }

    public void setElectorName(String electorName) {
        this.electorName = electorName;
    }

    public String getElectorPartNumber() {
        return this.electorPartNumber;
    }

    public void setElectorPartNumber(String electorPartNumber) {
        this.electorPartNumber = electorPartNumber;
    }

    public String getElectorPartSerialNumber() {
        return this.electorPartSerialNumber;
    }

    public void setElectorPartSerialNumber(String electorPartSerialNumber) {
        this.electorPartSerialNumber = electorPartSerialNumber;
    }

    public String getSpouseName() {
        return this.spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getMotherName() {
        return this.motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getRelativeName() {
        return this.relativeName;
    }

    public void setRelativeName(String relativeName) {
        this.relativeName = relativeName;
    }

    public String getRelativeEpicNumber() {
        return this.relativeEpicNumber;
    }

    public void setRelativeEpicNumber(String relativeEpicNumber) {
        this.relativeEpicNumber = relativeEpicNumber;
    }

    public String getRelativeRelativeName() {
        return this.relativeRelativeName;
    }

    public void setRelativeRelativeName(String relativeRelativeName) {
        this.relativeRelativeName = relativeRelativeName;
    }

    public String getRelativeRelationShip() {
        return this.relativeRelationShip;
    }

    public void setRelativeRelationShip(String relativeRelationShip) {
        this.relativeRelationShip = relativeRelationShip;
    }

    public String getRelativeDistrictCd() {
        return this.relativeDistrictCd;
    }

    public void setRelativeDistrictCd(String relativeDistrictCd) {
        this.relativeDistrictCd = relativeDistrictCd;
    }

    public String getRelativeStateCd() {
        return this.relativeStateCd;
    }

    public void setRelativeStateCd(String relativeStateCd) {
        this.relativeStateCd = relativeStateCd;
    }

    public String getRelativeAcName() {
        return this.relativeAcName;
    }

    public void setRelativeAcName(String relativeAcName) {
        this.relativeAcName = relativeAcName;
    }

    public String getRelativeAcNo() {
        return this.relativeAcNo;
    }

    public void setRelativeAcNo(String relativeAcNo) {
        this.relativeAcNo = relativeAcNo;
    }

    public String getRelativePartNo() {
        return this.relativePartNo;
    }

    public void setRelativePartNo(String relativePartNo) {
        this.relativePartNo = relativePartNo;
    }

    public String getRelativePartSerialNumber() {
        return this.relativePartSerialNumber;
    }

    public void setRelativePartSerialNumber(String relativePartSerialNumber) {
        this.relativePartSerialNumber = relativePartSerialNumber;
    }

    public String getElectorStateName() {
        return this.electorStateName;
    }

    public void setElectorStateName(String electorStateName) {
        this.electorStateName = electorStateName;
    }

    public String getFatherorGuardianname() {
        return this.fatherorGuardianname;
    }

    public void setFatherorGuardianname(String fatherorGuardianname) {
        this.fatherorGuardianname = fatherorGuardianname;
    }

    public String getFatherorGuardianEpicNo() {
        return this.fatherorGuardianEpicNo;
    }

    public void setFatherorGuardianEpicNo(String fatherorGuardianEpicNo) {
        this.fatherorGuardianEpicNo = fatherorGuardianEpicNo;
    }

    public String getMotherEpicNo() {
        return this.motherEpicNo;
    }

    public void setMotherEpicNo(String motherEpicNo) {
        this.motherEpicNo = motherEpicNo;
    }

    public String getDecsirf6DeclSignature() {
        return this.decsirf6DeclSignature;
    }

    public void setDecsirf6DeclSignature(String decsirf6DeclSignature) {
        this.decsirf6DeclSignature = decsirf6DeclSignature;
    }

    public String getDecsirf6DeclCategory() {
        return this.decsirf6DeclCategory;
    }

    public void setDecsirf6DeclCategory(String decsirf6DeclCategory) {
        this.decsirf6DeclCategory = decsirf6DeclCategory;
    }

    public String getSpouseEpicNo() {
        return this.spouseEpicNo;
    }

    public void setSpouseEpicNo(String spouseEpicNo) {
        this.spouseEpicNo = spouseEpicNo;
    }

    public String getRelativeStateName() {
        return this.relativeStateName;
    }

    public void setRelativeStateName(String relativeStateName) {
        this.relativeStateName = relativeStateName;
    }

    public String getDecsirf6formID() {
        return this.decsirf6formID;
    }

    public void setDecsirf6formID(String decsirf6formID) {
        this.decsirf6formID = decsirf6formID;
    }

    public String getDecsirf6RefNo() {
        return this.decsirf6RefNo;
    }

    public void setDecsirf6RefNo(String decsirf6RefNo) {
        this.decsirf6RefNo = decsirf6RefNo;
    }

    public String getElectorRelation() {
        return this.electorsRelation;
    }

    public void setElectorRelation(String electorsRelation) {
        this.electorsRelation = electorsRelation;
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
}
