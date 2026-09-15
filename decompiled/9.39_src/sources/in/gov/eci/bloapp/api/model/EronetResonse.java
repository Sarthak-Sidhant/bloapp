package in.gov.eci.bloapp.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.json.simple.JSONArray;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class EronetResonse implements Serializable {

    @SerializedName("access_token")
    @Expose
    private String access_token;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("payload")
    @Expose
    public JSONArray payload;

    @SerializedName("refId")
    @Expose
    public String refId;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("statusCode")
    @Expose
    public String statusCode;

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

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getRefId() {
        return this.refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public JSONArray getPayload() {
        return this.payload;
    }

    public void setPayload(JSONArray payload) {
        this.payload = payload;
    }
}
