package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ParliamantaryModel {

    @SerializedName("PRLMNT_NAME")
    public String parlia;

    public ParliamantaryModel(String parlia) {
        this.parlia = parlia;
    }

    public String getParlia() {
        return this.parlia;
    }
}
