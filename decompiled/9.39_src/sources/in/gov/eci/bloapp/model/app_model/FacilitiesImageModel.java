package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FacilitiesImageModel {

    @SerializedName("POLLING_STATION_IMAGE")
    public byte[] pollingstationimage;

    public FacilitiesImageModel(byte[] pollingstationimage) {
        this.pollingstationimage = pollingstationimage;
    }

    public byte[] getPollingstationimage() {
        return this.pollingstationimage;
    }
}
