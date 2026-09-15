package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FormsinDraftOverseasModel {

    @SerializedName("DECLARATION_DETAILS")
    public String decalaration;

    @SerializedName("ORDINARY_ADDRESS")
    public String ordinary;

    @SerializedName("OUTSIDE_DETAILS")
    public String outside;

    @SerializedName("PASSPORT_DETAILS")
    public String passport;

    @SerializedName("PASSPORT_PDF")
    public String pdf;

    @SerializedName("PERSONAL_DETAILS")
    public String personal;

    @SerializedName("PHOTOGRAPH")
    public String photo;

    @SerializedName("FORM_REFERENCE_NUMBER")
    public String reference;

    @SerializedName("RESIDENCE_DETAILS")
    public String residence;

    @SerializedName("STATE_DETAILS")
    public String state;

    @SerializedName("STEP_SEQUENCE")
    public String stepseq;

    @SerializedName("VISA_DETAILS")
    public String visa;

    public FormsinDraftOverseasModel(String state, String personal, String residence, String passport, String visa, String outside, String stepseq, String reference, String photo, String pdf, String ordinary, String decalaration) {
        this.state = state;
        this.personal = personal;
        this.residence = residence;
        this.passport = passport;
        this.visa = visa;
        this.outside = outside;
        this.stepseq = stepseq;
        this.reference = reference;
        this.photo = photo;
        this.pdf = pdf;
        this.ordinary = ordinary;
        this.decalaration = decalaration;
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

    public String getPassport() {
        return this.passport;
    }

    public String getVisa() {
        return this.visa;
    }

    public String getOutside() {
        return this.outside;
    }

    public String getStepseq() {
        return this.stepseq;
    }

    public String getReference() {
        return this.reference;
    }

    public String getPhoto() {
        return this.photo;
    }

    public String getPdf() {
        return this.pdf;
    }

    public String getOrdinary() {
        return this.ordinary;
    }

    public String getDecalaration() {
        return this.decalaration;
    }
}
