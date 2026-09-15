package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class VillageModel {

    @SerializedName("VILLAGE_NAME")
    public String village;

    public VillageModel(String village) {
        this.village = village;
    }

    public String getVillage() {
        return this.village;
    }
}
