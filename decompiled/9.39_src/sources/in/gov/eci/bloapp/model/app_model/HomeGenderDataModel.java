package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class HomeGenderDataModel {

    @SerializedName("gender_data")
    public String genCounter;

    @SerializedName("gender_data")
    public String genType;

    public HomeGenderDataModel(String genCounter, String genType) {
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
