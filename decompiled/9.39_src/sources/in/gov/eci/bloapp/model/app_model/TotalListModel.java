package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class TotalListModel {

    @SerializedName("CURRENT_STATUS_ID")
    public int currentStatusId;

    @SerializedName("DATE")
    public String date;

    @SerializedName("EMAIL")
    public String email;

    @SerializedName("EPIC_NUMBER")
    public String epicNo;

    @SerializedName("FORM_PROCESSING_DETAIL_ID")
    public int formProcessingDetailsId;

    @SerializedName("FORM_TYPE")
    public int formType;
    String isExistingElector;

    @SerializedName("MOBILE")
    public String mobNo;

    @SerializedName("Name")
    public String name;

    @SerializedName("REFERENCE_NUMBER")
    public String refNo;

    @SerializedName("RELATIVE")
    public String relative;

    @SerializedName("REMARKS")
    public String remarks;

    @SerializedName("REMARKS_TYPE")
    public String remarksType;
    String uncollectableSir;

    @SerializedName("VERIFIED")
    public String verified;

    public TotalListModel(String name, String refNo, String epicNo, String mobNo, String email, String date, String relative, String verified, int formType, int formProcessingDetailsId, int currentStatusId, String remarks, String remarksType, String isExistingElector, String uncollectableSir) {
        this.name = name;
        this.refNo = refNo;
        this.epicNo = epicNo;
        this.mobNo = mobNo;
        this.email = email;
        this.date = date;
        this.relative = relative;
        this.verified = verified;
        this.formType = formType;
        this.formProcessingDetailsId = formProcessingDetailsId;
        this.currentStatusId = currentStatusId;
        this.remarks = remarks;
        this.remarksType = remarksType;
        this.isExistingElector = isExistingElector;
        this.uncollectableSir = uncollectableSir;
    }

    public String getName() {
        return this.name;
    }

    public String getRefNo() {
        return this.refNo;
    }

    public String getEpicNo() {
        return this.epicNo;
    }

    public String getMobNo() {
        return this.mobNo;
    }

    public String getEmail() {
        return this.email;
    }

    public String getDate() {
        return this.date;
    }

    public String getRelative() {
        return this.relative;
    }

    public String getVerified() {
        return this.verified;
    }

    public int getFormProcessingDetailsId() {
        return this.formProcessingDetailsId;
    }

    public int getCurrentStatusId() {
        return this.currentStatusId;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public String getRemarksType() {
        return this.remarksType;
    }

    public void setFormProcessingDetailsId(int formProcessingDetailsId) {
        this.formProcessingDetailsId = formProcessingDetailsId;
    }

    public int getFormType() {
        return this.formType;
    }

    public String getIsExistingElector() {
        return this.isExistingElector;
    }

    public void setIsExistingElector(String isExistingElector) {
        this.isExistingElector = isExistingElector;
    }

    public String getUncollectableSir() {
        return this.uncollectableSir;
    }

    public void setUncollectableSir(String uncollectableSir) {
        this.uncollectableSir = uncollectableSir;
    }
}
