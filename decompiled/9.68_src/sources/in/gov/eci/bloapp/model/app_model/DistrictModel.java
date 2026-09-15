package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class DistrictModel {

    @SerializedName("DISTRICT_VALUE")
    public String district_name;

    public DistrictModel(String district_name) {
        this.district_name = district_name;
    }

    public String getDistrict() {
        return this.district_name;
    }
}
