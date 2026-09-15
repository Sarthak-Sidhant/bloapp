package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class VerifiedModel {

    @SerializedName("FIRST_NAME")
    public String houseno;

    @SerializedName("LAST_NAME")
    public String noofpeople;

    @SerializedName("EPIC_NUMBER")
    public String status;

    public VerifiedModel(String houseno, String noofpeople, String status) {
        this.houseno = houseno;
        this.noofpeople = noofpeople;
        this.status = status;
    }

    public String getHouseNo() {
        return this.houseno;
    }

    public String getNoofpeople() {
        return this.noofpeople;
    }

    public String getStatus() {
        return this.status;
    }
}
