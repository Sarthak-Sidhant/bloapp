package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FacilitiesConstituencyModel {

    @SerializedName("CONSTITUENCY_NAME")
    public String constituencyName;

    @SerializedName("CONSTITUENCY_NUMBER")
    public String constituencyNumber;

    public FacilitiesConstituencyModel(String constituencyName, String constituencyNumber) {
        this.constituencyName = constituencyName;
        this.constituencyNumber = constituencyNumber;
    }

    public String getConstituencyName() {
        return this.constituencyName;
    }

    public String getConstituencyNumber() {
        return this.constituencyNumber;
    }
}
