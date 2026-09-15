package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FormsModel {

    @SerializedName("CREATED_ON")
    public String createdon;

    @SerializedName("NAME")
    public String name;

    @SerializedName("PERSONAL_DETAILS")
    public String personaldetails;

    public FormsModel(String name, String createdon) {
        this.name = name;
        this.createdon = createdon;
    }

    public FormsModel(String name, String createdon, String personaldetails) {
        this.name = name;
        this.createdon = createdon;
        this.personaldetails = personaldetails;
    }

    public String getName() {
        return this.name;
    }

    public String getCreatedon() {
        return this.createdon;
    }

    public String getPersonaldetails() {
        return this.personaldetails;
    }

    public void setPersonaldetails(String personaldetails) {
        this.personaldetails = personaldetails;
    }
}
