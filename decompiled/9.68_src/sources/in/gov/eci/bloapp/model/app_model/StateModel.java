package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class StateModel {

    @SerializedName("STATE_NAME")
    public String state_name;

    public StateModel(String state_name) {
        this.state_name = state_name;
    }

    public String getState_name() {
        return this.state_name;
    }
}
