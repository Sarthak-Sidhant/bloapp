package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ReceivedFormStatsDashModel {

    @SerializedName("form_counter")
    public String formCounter;

    @SerializedName("form_counter")
    public String formType;

    public ReceivedFormStatsDashModel(String formCounter, String formType) {
        this.formCounter = formCounter;
        this.formType = formType;
    }

    public String getFormCounter() {
        return this.formCounter;
    }

    public String getFormType() {
        return this.formType;
    }
}
