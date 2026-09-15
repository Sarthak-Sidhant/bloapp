package in.gov.eci.bloapp.languagetransliteration.db;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class TAc implements Serializable {

    @SerializedName("ac_code")
    public String ac_code;

    @SerializedName("ac_name")
    public String ac_name;

    @SerializedName("dist_code")
    public String dist_code;

    @SerializedName("id")
    public long id;

    @SerializedName("st_lang_code")
    public String st_lang_code;

    @SerializedName("state_code")
    public String state_code;

    public String toString() {
        return this.ac_name;
    }
}
