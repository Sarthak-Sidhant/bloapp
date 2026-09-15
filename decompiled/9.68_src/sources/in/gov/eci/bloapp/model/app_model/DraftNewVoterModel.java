package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class DraftNewVoterModel {

    @SerializedName("RESIDENCE_DOCUMENT")
    public String address;

    @SerializedName("After2004FatherFileName")
    String after2004FatherFileName;

    @SerializedName("After2004FatherFileSize")
    String after2004FatherFileSize;

    @SerializedName("After2004MotherFileName")
    String after2004MotherFileName;

    @SerializedName("After2004MotherFileSize")
    String after2004MotherFileSize;

    @SerializedName("After2004ParentNameNotindian")
    String after2004ParentNameNotindian;

    @SerializedName("After2004docURLFather")
    String after2004docURLFather;

    @SerializedName("After2004docURLMother")
    String after2004docURLMother;

    @SerializedName("After2004doctypeFather")
    String after2004doctypeFather;

    @SerializedName("After2004doctypeMother")
    String after2004doctypeMother;

    @SerializedName("After2004isParentIndian")
    String after2004isParentIndian;

    @SerializedName("AnexSignFileName")
    String anexSignFileName;

    @SerializedName("AnexSignFileSize")
    String anexSignFileSize;

    @SerializedName("AnnexureSignURL")
    String annexureSignURL;

    @SerializedName("Before2004ParentType")
    String before2004ParentType;

    @SerializedName("Before2004docFileName")
    String before2004docFileName;

    @SerializedName("Before2004docFileSize")
    String before2004docFileSize;

    @SerializedName("BornOutofIndiaFileName")
    String bornOutofIndiaFileName;

    @SerializedName("BornOutofIndiaFileSize")
    String bornOutofIndiaFileSize;

    @SerializedName("BornOutofIndiadocURL")
    String bornOutofIndiadocURL;

    @SerializedName("BornOutofIndiadoctype")
    String bornOutofIndiadoctype;

    @SerializedName("CitizenAquuiredFileName")
    String citizenAquuiredFileName;

    @SerializedName("CitizenAquuiredFileSize")
    String citizenAquuiredFileSize;

    @SerializedName("CitizenAquuireddocURL")
    String citizenAquuireddocURL;

    @SerializedName("CitizenAquuireddoctype")
    String citizenAquuireddoctype;

    @SerializedName("CitizenshipType")
    String citizenshipType;

    @SerializedName("CitizenshipTypeCat")
    String citizenshipTypeCat;

    @SerializedName("CtDocOfSelfUrl")
    String ctDocOfSelfUrl;

    @SerializedName("CtDocTypeForSelf")
    String ctDocTypeForSelf;

    @SerializedName("DECLARATION_DETAILS")
    public String declaration;

    @SerializedName("DeclarationForm")
    String declarationForm;

    @SerializedName("DISABILITY_DOC")
    public String disability;

    @SerializedName("DocURLFather")
    String docURLFather;

    @SerializedName("DocURLMother")
    String docURLMother;

    @SerializedName("DoctypeFather")
    String doctypeFather;

    @SerializedName("DoctypeMother")
    String doctypeMother;

    @SerializedName("Before2004ParentType")
    String doctypeselFileSize;

    @SerializedName("DoctypeselfFileName")
    String doctypeselfFileName;

    @SerializedName("FAMILY_DETAILS")
    public String family;

    @SerializedName("OPTION_OF_APPLICATION")
    public String option;

    @SerializedName("DOB_DOCUMENT")
    public String pdf;

    @SerializedName("PERSONAL_DETAILS")
    public String personal;

    @SerializedName("PHOTOGRAPH")
    public String photo;

    @SerializedName("FORM_REFERENCE_NUMBER")
    public String reference;

    @SerializedName("RESIDENCE_DETAILS")
    public String residence;

    @SerializedName("SECTION_No")
    public String section;

    @SerializedName("STATE_DETAILS")
    public String state;

    @SerializedName("STEP_SEQUENCE")
    public String stepseq;

    public DraftNewVoterModel(String state, String personal, String residence, String option, String photo, String pdf, String address, String disability, String stepseq, String reference, String family, String declaration, String section, String citizenshipType, String citizenshipTypeCat, String ctDocTypeForSelf, String ctDocOfSelfUrl, String doctypeselfFileName, String doctypeselFileSize, String before2004ParentType, String doctypeFather, String doctypeMother, String docURLFather, String docURLMother, String before2004docFileName, String before2004docFileSize, String after2004isParentIndian, String after2004ParentNameNotindian, String after2004doctypeFather, String after2004doctypeMother, String after2004docURLFather, String after2004docURLMother, String after2004MotherFileName, String after2004MotherFileSize, String after2004FatherFileName, String after2004FatherFileSize, String bornOutofIndiadoctype, String bornOutofIndiadocURL, String bornOutofIndiaFileName, String bornOutofIndiaFileSize, String citizenAquuireddoctype, String citizenAquuireddocURL, String citizenAquuiredFileName, String citizenAquuiredFileSize, String annexureSignURL, String anexSignFileName, String anexSignFileSize, String declarationForm) {
        this.state = state;
        this.personal = personal;
        this.residence = residence;
        this.option = option;
        this.photo = photo;
        this.pdf = pdf;
        this.address = address;
        this.disability = disability;
        this.stepseq = stepseq;
        this.reference = reference;
        this.family = family;
        this.declaration = declaration;
        this.section = section;
        this.citizenshipType = citizenshipType;
        this.citizenshipTypeCat = citizenshipTypeCat;
        this.ctDocTypeForSelf = ctDocTypeForSelf;
        this.ctDocOfSelfUrl = ctDocOfSelfUrl;
        this.doctypeselfFileName = doctypeselfFileName;
        this.doctypeselFileSize = doctypeselFileSize;
        this.before2004ParentType = before2004ParentType;
        this.doctypeFather = doctypeFather;
        this.doctypeMother = doctypeMother;
        this.docURLFather = docURLFather;
        this.docURLMother = docURLMother;
        this.before2004docFileName = before2004docFileName;
        this.before2004docFileSize = before2004docFileSize;
        this.after2004isParentIndian = after2004isParentIndian;
        this.after2004ParentNameNotindian = after2004ParentNameNotindian;
        this.after2004doctypeFather = after2004doctypeFather;
        this.after2004doctypeMother = after2004doctypeMother;
        this.after2004docURLFather = after2004docURLFather;
        this.after2004docURLMother = after2004docURLMother;
        this.after2004MotherFileName = after2004MotherFileName;
        this.after2004MotherFileSize = after2004MotherFileSize;
        this.after2004FatherFileName = after2004FatherFileName;
        this.after2004FatherFileSize = after2004FatherFileSize;
        this.bornOutofIndiadoctype = bornOutofIndiadoctype;
        this.bornOutofIndiadocURL = bornOutofIndiadocURL;
        this.bornOutofIndiaFileName = bornOutofIndiaFileName;
        this.bornOutofIndiaFileSize = bornOutofIndiaFileSize;
        this.citizenAquuireddoctype = citizenAquuireddoctype;
        this.citizenAquuireddocURL = citizenAquuireddocURL;
        this.citizenAquuiredFileName = citizenAquuiredFileName;
        this.citizenAquuiredFileSize = citizenAquuiredFileSize;
        this.annexureSignURL = annexureSignURL;
        this.anexSignFileName = anexSignFileName;
        this.anexSignFileSize = anexSignFileSize;
        this.declarationForm = declarationForm;
    }

    public String getState() {
        return this.state;
    }

    public String getPersonal() {
        return this.personal;
    }

    public String getResidence() {
        return this.residence;
    }

    public String getOption() {
        return this.option;
    }

    public String getPhoto() {
        return this.photo;
    }

    public String getPdf() {
        return this.pdf;
    }

    public String getAddress() {
        return this.address;
    }

    public String getDisability() {
        return this.disability;
    }

    public String getStepseq() {
        return this.stepseq;
    }

    public String getReference() {
        return this.reference;
    }

    public String getFamily() {
        return this.family;
    }

    public String getDeclaration() {
        return this.declaration;
    }

    public String getSection() {
        return this.section;
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

    public String getCtDocTypeForSelf() {
        return this.ctDocTypeForSelf;
    }

    public void setCtDocTypeForSelf(String ctDocTypeForSelf) {
        this.ctDocTypeForSelf = ctDocTypeForSelf;
    }

    public String getCtDocOfSelfUrl() {
        return this.ctDocOfSelfUrl;
    }

    public void setCtDocOfSelfUrl(String ctDocOfSelfUrl) {
        this.ctDocOfSelfUrl = ctDocOfSelfUrl;
    }

    public String getDoctypeselfFileName() {
        return this.doctypeselfFileName;
    }

    public void setDoctypeselfFileName(String doctypeselfFileName) {
        this.doctypeselfFileName = doctypeselfFileName;
    }

    public String getDoctypeselFileSize() {
        return this.doctypeselFileSize;
    }

    public void setDoctypeselFileSize(String doctypeselFileSize) {
        this.doctypeselFileSize = doctypeselFileSize;
    }

    public String getBefore2004ParentType() {
        return this.before2004ParentType;
    }

    public void setBefore2004ParentType(String before2004ParentType) {
        this.before2004ParentType = before2004ParentType;
    }

    public String getDoctypeFather() {
        return this.doctypeFather;
    }

    public void setDoctypeFather(String doctypeFather) {
        this.doctypeFather = doctypeFather;
    }

    public String getDoctypeMother() {
        return this.doctypeMother;
    }

    public void setDoctypeMother(String doctypeMother) {
        this.doctypeMother = doctypeMother;
    }

    public String getDocURLFather() {
        return this.docURLFather;
    }

    public void setDocURLFather(String docURLFather) {
        this.docURLFather = docURLFather;
    }

    public String getDocURLMother() {
        return this.docURLMother;
    }

    public void setDocURLMother(String docURLMother) {
        this.docURLMother = docURLMother;
    }

    public String getBefore2004docFileName() {
        return this.before2004docFileName;
    }

    public void setBefore2004docFileName(String before2004docFileName) {
        this.before2004docFileName = before2004docFileName;
    }

    public String getBefore2004docFileSize() {
        return this.before2004docFileSize;
    }

    public void setBefore2004docFileSize(String before2004docFileSize) {
        this.before2004docFileSize = before2004docFileSize;
    }

    public String getAfter2004isParentIndian() {
        return this.after2004isParentIndian;
    }

    public void setAfter2004isParentIndian(String after2004isParentIndian) {
        this.after2004isParentIndian = after2004isParentIndian;
    }

    public String getAfter2004ParentNameNotindian() {
        return this.after2004ParentNameNotindian;
    }

    public void setAfter2004ParentNameNotindian(String after2004ParentNameNotindian) {
        this.after2004ParentNameNotindian = after2004ParentNameNotindian;
    }

    public String getAfter2004doctypeFather() {
        return this.after2004doctypeFather;
    }

    public void setAfter2004doctypeFather(String after2004doctypeFather) {
        this.after2004doctypeFather = after2004doctypeFather;
    }

    public String getAfter2004doctypeMother() {
        return this.after2004doctypeMother;
    }

    public void setAfter2004doctypeMother(String after2004doctypeMother) {
        this.after2004doctypeMother = after2004doctypeMother;
    }

    public String getAfter2004docURLFather() {
        return this.after2004docURLFather;
    }

    public void setAfter2004docURLFather(String after2004docURLFather) {
        this.after2004docURLFather = after2004docURLFather;
    }

    public String getAfter2004docURLMother() {
        return this.after2004docURLMother;
    }

    public void setAfter2004docURLMother(String after2004docURLMother) {
        this.after2004docURLMother = after2004docURLMother;
    }

    public String getAfter2004MotherFileName() {
        return this.after2004MotherFileName;
    }

    public void setAfter2004MotherFileName(String after2004MotherFileName) {
        this.after2004MotherFileName = after2004MotherFileName;
    }

    public String getAfter2004MotherFileSize() {
        return this.after2004MotherFileSize;
    }

    public void setAfter2004MotherFileSize(String after2004MotherFileSize) {
        this.after2004MotherFileSize = after2004MotherFileSize;
    }

    public String getAfter2004FatherFileName() {
        return this.after2004FatherFileName;
    }

    public void setAfter2004FatherFileName(String after2004FatherFileName) {
        this.after2004FatherFileName = after2004FatherFileName;
    }

    public String getAfter2004FatherFileSize() {
        return this.after2004FatherFileSize;
    }

    public void setAfter2004FatherFileSize(String after2004FatherFileSize) {
        this.after2004FatherFileSize = after2004FatherFileSize;
    }

    public String getBornOutofIndiadoctype() {
        return this.bornOutofIndiadoctype;
    }

    public void setBornOutofIndiadoctype(String bornOutofIndiadoctype) {
        this.bornOutofIndiadoctype = bornOutofIndiadoctype;
    }

    public String getBornOutofIndiadocURL() {
        return this.bornOutofIndiadocURL;
    }

    public void setBornOutofIndiadocURL(String bornOutofIndiadocURL) {
        this.bornOutofIndiadocURL = bornOutofIndiadocURL;
    }

    public String getBornOutofIndiaFileName() {
        return this.bornOutofIndiaFileName;
    }

    public void setBornOutofIndiaFileName(String bornOutofIndiaFileName) {
        this.bornOutofIndiaFileName = bornOutofIndiaFileName;
    }

    public String getBornOutofIndiaFileSize() {
        return this.bornOutofIndiaFileSize;
    }

    public void setBornOutofIndiaFileSize(String bornOutofIndiaFileSize) {
        this.bornOutofIndiaFileSize = bornOutofIndiaFileSize;
    }

    public String getCitizenAquuireddoctype() {
        return this.citizenAquuireddoctype;
    }

    public void setCitizenAquuireddoctype(String citizenAquuireddoctype) {
        this.citizenAquuireddoctype = citizenAquuireddoctype;
    }

    public String getCitizenAquuireddocURL() {
        return this.citizenAquuireddocURL;
    }

    public void setCitizenAquuireddocURL(String citizenAquuireddocURL) {
        this.citizenAquuireddocURL = citizenAquuireddocURL;
    }

    public String getCitizenAquuiredFileName() {
        return this.citizenAquuiredFileName;
    }

    public void setCitizenAquuiredFileName(String citizenAquuiredFileName) {
        this.citizenAquuiredFileName = citizenAquuiredFileName;
    }

    public String getCitizenAquuiredFileSize() {
        return this.citizenAquuiredFileSize;
    }

    public void setCitizenAquuiredFileSize(String citizenAquuiredFileSize) {
        this.citizenAquuiredFileSize = citizenAquuiredFileSize;
    }

    public String getAnnexureSignURL() {
        return this.annexureSignURL;
    }

    public void setAnnexureSignURL(String annexureSignURL) {
        this.annexureSignURL = annexureSignURL;
    }

    public String getAnexSignFileSize() {
        return this.anexSignFileSize;
    }

    public void setAnexSignFileSize(String anexSignFileSize) {
        this.anexSignFileSize = anexSignFileSize;
    }

    public String getAnexSignFileName() {
        return this.anexSignFileName;
    }

    public void setAnexSignFileName(String anexSignFileName) {
        this.anexSignFileName = anexSignFileName;
    }

    public String getDeclarationForm() {
        return this.declarationForm;
    }

    public void setDeclarationForm(String declarationForm) {
        this.declarationForm = declarationForm;
    }
}
