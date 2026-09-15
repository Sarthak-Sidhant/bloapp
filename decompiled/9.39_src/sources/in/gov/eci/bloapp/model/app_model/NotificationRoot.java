package in.gov.eci.bloapp.model.app_model;

import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class NotificationRoot {
    public String message;
    public List<NotificationItem> payload;
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

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<NotificationItem> getPayload() {
        return this.payload;
    }

    public void setPayload(List<NotificationItem> payload) {
        this.payload = payload;
    }
}
