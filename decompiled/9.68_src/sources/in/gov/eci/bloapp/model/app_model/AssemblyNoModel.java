package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class AssemblyNoModel {

    @SerializedName("ASMBLY_NO")
    public String asmblyNo;

    @SerializedName("PRLMNT_NO")
    public String parliaNo;

    public AssemblyNoModel(String asmblyNo, String parliaNo) {
        this.asmblyNo = asmblyNo;
        this.parliaNo = parliaNo;
    }

    public String getAsmblyNo() {
        return this.asmblyNo;
    }

    public String getParliaNo() {
        return this.parliaNo;
    }
}
