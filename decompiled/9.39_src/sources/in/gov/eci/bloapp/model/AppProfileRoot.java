package in.gov.eci.bloapp.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class AppProfileRoot {
    public Object message;
    public ArrayList<Payload> payload;
    public Object refId;
    public String status;
    public int statusCode;

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

    public Object getRefId() {
        return this.refId;
    }

    public void setRefId(Object refId) {
        this.refId = refId;
    }

    public Object getMessage() {
        return this.message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public ArrayList<Payload> getPayload() {
        return this.payload;
    }

    public void setPayload(ArrayList<Payload> payload) {
        this.payload = payload;
    }
}
