package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FacilitiespollingModel {

    @SerializedName("POLLING_STATION")
    public String pollingstation;

    public FacilitiespollingModel(String pollingstation) {
        this.pollingstation = pollingstation;
    }

    public String getPollingstation() {
        return this.pollingstation;
    }
}
