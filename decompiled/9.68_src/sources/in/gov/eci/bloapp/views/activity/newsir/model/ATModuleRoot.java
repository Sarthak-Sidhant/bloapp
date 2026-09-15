package in.gov.eci.bloapp.views.activity.newsir.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ATModuleRoot {
    public ArrayList<ATPayload> payload;
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

    public ArrayList<ATPayload> getPayload() {
        return this.payload;
    }

    public void setPayload(ArrayList<ATPayload> payload) {
        this.payload = payload;
    }
}
