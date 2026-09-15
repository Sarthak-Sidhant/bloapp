package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class StageDetailsModel {

    @SerializedName("DATE")
    public String date;

    @SerializedName("STAGE")
    public String stage;

    public StageDetailsModel(String stage, String date) {
        this.stage = stage;
        this.date = date;
    }

    public String getStage() {
        return this.stage;
    }

    public String getDate() {
        return this.date;
    }
}
