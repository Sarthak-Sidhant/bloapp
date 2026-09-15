package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class DashFormsDetailsModel {

    @SerializedName("CURRENT_STATUS")
    public String currentStatus;

    @SerializedName("FORM_TYPE")
    public String formType;

    @SerializedName("LAST_MODIFIED_DATE")
    public String lastModifiedDate;

    @SerializedName("REFERENCE_NO")
    public String referenceNo;

    public DashFormsDetailsModel(String formType, String referenceNo, String currentStatus, String lastModifiedDate) {
        this.formType = formType;
        this.referenceNo = referenceNo;
        this.currentStatus = currentStatus;
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getFormType() {
        return this.formType;
    }

    public String getReferenceNo() {
        return this.referenceNo;
    }

    public String getCurrentStatus() {
        return this.currentStatus;
    }

    public String getLastModifiedDate() {
        return this.lastModifiedDate;
    }
}
