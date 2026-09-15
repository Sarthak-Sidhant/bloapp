package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class VerifiedModel1 {

    @SerializedName("FIRST_NAME")
    public String houseno;

    @SerializedName("LAST_NAME")
    public String noofpeople;

    @SerializedName("SEC_NAME")
    public String secName;

    @SerializedName("DATE")
    public String secNo;

    @SerializedName("EPIC_NUMBER")
    public String status;

    public VerifiedModel1(String houseno, String noofpeople, String status, String secName, String secNo) {
        this.houseno = houseno;
        this.noofpeople = noofpeople;
        this.status = status;
        this.secName = secName;
        this.secNo = secNo;
    }

    public String getHouseno() {
        return this.houseno;
    }

    public void setHouseno(String houseno) {
        this.houseno = houseno;
    }

    public String getNoofpeople() {
        return this.noofpeople;
    }

    public void setNoofpeople(String noofpeople) {
        this.noofpeople = noofpeople;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSecName() {
        return this.secName;
    }

    public void setSecName(String secName) {
        this.secName = secName;
    }

    public String getSecNo() {
        return this.secNo;
    }

    public void setSecNo(String secNo) {
        this.secNo = secNo;
    }
}
