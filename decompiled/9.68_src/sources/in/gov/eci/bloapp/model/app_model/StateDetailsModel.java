package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class StateDetailsModel {

    @SerializedName("NAME_CONSTITUENCY")
    public String constituency;

    @SerializedName("DISTRICT")
    public String district_name;

    @SerializedName("NUMBER_CONSTITUENCY")
    public String number_const;

    @SerializedName("STATE")
    public String state_name;

    public StateDetailsModel(String state_name, String constituency, String number_const, String district_name) {
        this.state_name = state_name;
        this.constituency = constituency;
        this.number_const = number_const;
        this.district_name = district_name;
    }

    public String getState_name() {
        return this.state_name;
    }

    public String getConstituency() {
        return this.constituency;
    }

    public String getNumber_const() {
        return this.number_const;
    }

    public String getDistrict_name() {
        return this.district_name;
    }
}
