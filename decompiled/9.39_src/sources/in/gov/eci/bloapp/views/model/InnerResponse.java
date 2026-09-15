package in.gov.eci.bloapp.views.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class InnerResponse {
    public ArrayList<EpicIssuedPayload> payload;
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

    public ArrayList<EpicIssuedPayload> getPayload() {
        return this.payload;
    }

    public void setPayload(ArrayList<EpicIssuedPayload> payload) {
        this.payload = payload;
    }
}
