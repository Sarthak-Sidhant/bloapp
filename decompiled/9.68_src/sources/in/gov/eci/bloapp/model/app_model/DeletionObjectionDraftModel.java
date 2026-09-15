package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class DeletionObjectionDraftModel {

    @SerializedName("PERSONAL_DETAILS")
    public String personal;

    @SerializedName("PHOTOGRAPH")
    public byte[] photo;

    @SerializedName("FORM_REFERENCE_NUMBER")
    public String reference;

    @SerializedName("OPTION_OF_APPLICATION")
    public String rejection;

    @SerializedName("REQUEST_RAISE_DETAILS")
    public String requestdetails;

    @SerializedName("STATE_DETAILS")
    public String state;

    @SerializedName("STEP_SEQUENCE")
    public String stepseq;

    public DeletionObjectionDraftModel(String state, String personal, String rejection, String requestdetails, String stepseq, String reference, byte[] photo) {
        this.state = state;
        this.personal = personal;
        this.rejection = rejection;
        this.requestdetails = requestdetails;
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

    public String getRejection() {
        return this.rejection;
    }

    public String getRequestdetails() {
        return this.requestdetails;
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
