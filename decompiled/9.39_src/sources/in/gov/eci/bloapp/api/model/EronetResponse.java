package in.gov.eci.bloapp.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.json.simple.JSONArray;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class EronetResponse implements Serializable {

    @SerializedName("access_token")
    @Expose
    private String access_token;

    @SerializedName("atkn_bnd")
    @Expose
    private String atknBnd;

    @SerializedName("firstTimeLogin")
    @Expose
    private String firstTimeLogin;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("payload")
    private JSONArray payload;

    @SerializedName("refresh_token")
    @Expose
    private String refresh_token;

    @SerializedName("rtkn_bnd")
    @Expose
    private String rtknBnd;

    @SerializedName("stateCd")
    private String stateCd;

    @SerializedName("status")
    @Expose
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAtknBnd() {
        return this.atknBnd;
    }

    public void setAtknBnd(String atknBnd) {
        this.atknBnd = atknBnd;
    }

    public String getRtknBnd() {
        return this.rtknBnd;
    }

    public void setRtknBnd(String rtknBnd) {
        this.rtknBnd = rtknBnd;
    }

    public String getAccess_token() {
        return this.access_token;
    }

    public String getFirstTimeLogin() {
        return this.firstTimeLogin;
    }

    public void setFirstTimeLogin(String firstTimeLogin) {
        this.firstTimeLogin = firstTimeLogin;
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

    public JSONArray getPayload() {
        return this.payload;
    }

    public String getRefresh_token() {
        return this.refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public void setPayload(JSONArray payload) {
        this.payload = payload;
    }

    public String getStateCd() {
        return this.stateCd;
    }

    public void setStateCd(String stateCd) {
        this.stateCd = stateCd;
    }
}
