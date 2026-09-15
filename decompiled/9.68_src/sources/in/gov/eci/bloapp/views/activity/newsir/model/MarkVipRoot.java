package in.gov.eci.bloapp.views.activity.newsir.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class MarkVipRoot {
    public String message;
    public ArrayList<MarkVipPayload> payload;
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

    public ArrayList<MarkVipPayload> getPayload() {
        return this.payload;
    }

    public void setPayload(ArrayList<MarkVipPayload> payload) {
        this.payload = payload;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
