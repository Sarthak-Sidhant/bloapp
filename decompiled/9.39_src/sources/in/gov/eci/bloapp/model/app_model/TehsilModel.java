package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class TehsilModel {

    @SerializedName("TEHSIL_NAME")
    public String tehsil;

    public TehsilModel(String tehsil) {
        this.tehsil = tehsil;
    }

    public String getTehsil() {
        return this.tehsil;
    }
}
