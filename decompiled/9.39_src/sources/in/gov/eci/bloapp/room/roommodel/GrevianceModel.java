package in.gov.eci.bloapp.room.roommodel;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class GrevianceModel {
    public String category;
    public String constituency;
    public String district;
    public String form;
    public Long id;
    public String incident;
    public String mobNum;
    public String referenceNo;
    public String state;
    public String subCat;
    public String subjectType;

    public GrevianceModel(Long id, String mobNum, String state, String district, String constituency, String category, String subCat, String subjectType, String incident, String form, String referenceNo) {
        this.id = id;
        this.mobNum = mobNum;
        this.state = state;
        this.district = district;
        this.constituency = constituency;
        this.category = category;
        this.subCat = subCat;
        this.subjectType = subjectType;
        this.incident = incident;
        this.form = form;
        this.referenceNo = referenceNo;
    }

    public Long getId() {
        return this.id;
    }

    public String getMobNum() {
        return this.mobNum;
    }

    public String getState() {
        return this.state;
    }

    public String getDistrict() {
        return this.district;
    }

    public String getConstituency() {
        return this.constituency;
    }

    public String getCategory() {
        return this.category;
    }

    public String getSubCat() {
        return this.subCat;
    }

    public String getSubjectType() {
        return this.subjectType;
    }

    public String getIncident() {
        return this.incident;
    }

    public String getForm() {
        return this.form;
    }

    public String getReferenceNo() {
        return this.referenceNo;
    }
}
