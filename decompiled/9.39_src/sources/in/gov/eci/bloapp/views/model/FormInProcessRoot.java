package in.gov.eci.bloapp.views.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FormInProcessRoot {
    public Object file;
    public Object message;
    public ArrayList<FormInProcessPayload> payload;
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

    public ArrayList<FormInProcessPayload> getPayload() {
        return this.payload;
    }

    public void setPayload(ArrayList<FormInProcessPayload> payload) {
        this.payload = payload;
    }

    public Object getFile() {
        return this.file;
    }

    public void setFile(Object file) {
        this.file = file;
    }
}
