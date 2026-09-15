package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class PostOfficeModel {

    @SerializedName("PO_PIN")
    public String pincode;

    @SerializedName("PO_NAME")
    public String postoffice;

    public PostOfficeModel(String postoffice, String pincode) {
        this.postoffice = postoffice;
        this.pincode = pincode;
    }

    public String getPostoffice() {
        return this.postoffice;
    }

    public String getPincode() {
        return this.pincode;
    }
}
