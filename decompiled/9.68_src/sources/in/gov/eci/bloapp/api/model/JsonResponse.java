package in.gov.eci.bloapp.api.model;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class JsonResponse {
    private String refId;
    private int statusCode;
    private String status = null;
    private Object message = null;
    private Object payload = null;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getRefId() {
        return this.refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public Object getMessage() {
        return this.message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getPayload() {
        return this.payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
