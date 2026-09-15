package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FormsinDraftModel {

    @SerializedName("AUTHENTICATION_DETAILS")
    public String authentication;

    @SerializedName("OPTION_OF_APPLICATION")
    public String otherDetail;

    @SerializedName("PERSONAL_DETAILS")
    public String personal;

    @SerializedName("PHOTOGRAPH")
    public byte[] photo;

    @SerializedName("FORM_REFERENCE_NUMBER")
    public String reference;

    @SerializedName("STATE_DETAILS")
    public String state;

    @SerializedName("STEP_SEQUENCE")
    public String stepseq;

    public FormsinDraftModel(String state, String personal, String authentication, String otherDetail, String stepseq, String reference, byte[] photo) {
        this.state = state;
        this.personal = personal;
        this.authentication = authentication;
        this.otherDetail = otherDetail;
        this.stepseq = stepseq;
        this.reference = reference;
        this.photo = photo;
    }

    public String getState() {
        return this.state;
    }

    public String getPersonal() {
        return this.personal;
    }

    public String getAuthentication() {
        return this.authentication;
    }

    public String getOtherDetail() {
        return this.otherDetail;
    }

    public String getStepseq() {
        return this.stepseq;
    }

    public String getReference() {
        return this.reference;
    }

    public byte[] getPhoto() {
        return this.photo;
    }
}
