package in.gov.eci.bloapp.languagetransliteration.db;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class TDistrict implements Serializable {

    @SerializedName("core_document_enabled")
    public boolean core_document_enabled;

    @SerializedName("dist_code")
    public String dist_code;

    @SerializedName("dist_name")
    public String dist_name;

    @SerializedName("id")
    public long id;

    @SerializedName("state_code")
    public String state_code;

    @SerializedName("status")
    public int status;

    public String toString() {
        return this.dist_name;
    }
}
