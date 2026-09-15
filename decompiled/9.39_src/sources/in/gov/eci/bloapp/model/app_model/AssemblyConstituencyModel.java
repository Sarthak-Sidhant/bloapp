package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class AssemblyConstituencyModel {

    @SerializedName("ASMBLY_NAME")
    public String asmblyName;

    public AssemblyConstituencyModel(String asmblyName) {
        this.asmblyName = asmblyName;
    }

    public String getAsmbly() {
        return this.asmblyName;
    }
}
