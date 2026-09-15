package in.gov.eci.bloapp.languagetransliteration.db;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class TState implements Serializable {

    @SerializedName("id")
    public long id;

    @SerializedName("state_code")
    public String state_code;

    @SerializedName("state_name")
    public String state_name;

    @SerializedName("status")
    public int status;

    public String toString() {
        return this.state_name;
    }
}
