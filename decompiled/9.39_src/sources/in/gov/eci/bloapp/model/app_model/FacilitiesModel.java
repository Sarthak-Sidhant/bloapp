package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FacilitiesModel {

    @SerializedName("ELECTOR_FEMALE")
    public String electorFemale;

    @SerializedName("ELECTOR_MALE")
    public String electorMale;

    @SerializedName("ELECTOR_OTHER")
    public String electorOther;

    @SerializedName("ELECTOR_PWD")
    public String electorPWD;

    public FacilitiesModel(String electorMale, String electorFemale, String electorOther, String electorPWD) {
        this.electorMale = electorMale;
        this.electorFemale = electorFemale;
        this.electorOther = electorOther;
        this.electorPWD = electorPWD;
    }

    public String getElectorMale() {
        return this.electorMale;
    }

    public String getElectorFemale() {
        return this.electorFemale;
    }

    public String getElectorOther() {
        return this.electorOther;
    }

    public String getElectorPWD() {
        return this.electorPWD;
    }
}
