package in.gov.eci.bloapp.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.json.simple.JSONArray;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class Response implements Serializable {

    @SerializedName("statusCode")
    @Expose
    private String access_token;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("payload")
    @Expose
    private JSONArray payload;

    @SerializedName("refId")
    @Expose
    private String refid;

    @SerializedName("status")
    @Expose
    private String status;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccess_token() {
        return this.access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public JSONArray getPayload() {
        return this.payload;
    }

    public void setPayload(JSONArray payload) {
        this.payload = payload;
    }

    public String getRefid() {
        return this.refid;
    }

    public void setRefid(String refid) {
        this.refid = refid;
    }
}
