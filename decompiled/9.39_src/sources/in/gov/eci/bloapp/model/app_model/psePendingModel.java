package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class psePendingModel {

    @SerializedName("FIRST_NAME")
    public String clusterId;

    public psePendingModel(String clusterId) {
        this.clusterId = clusterId;
    }

    public String getClusterId() {
        return this.clusterId;
    }

    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }
}
