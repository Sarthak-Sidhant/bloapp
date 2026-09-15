package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FacilitiesGenderModel {

    @SerializedName("gender_data")
    public String genCounter;

    @SerializedName("gender_data")
    public String genType;

    public FacilitiesGenderModel(String genCounter, String genType) {
        this.genCounter = genCounter;
        this.genType = genType;
    }

    public String getGenCounter() {
        return this.genCounter;
    }

    public String getGenType() {
        return this.genType;
    }
}
