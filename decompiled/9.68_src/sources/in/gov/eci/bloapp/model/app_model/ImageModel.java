package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ImageModel {

    @SerializedName("IMAGES")
    public byte[] image;

    @SerializedName("IMAGE_TEXT")
    public String imagetext;

    @SerializedName("IMAGE_LOCATION")
    public String location;

    public ImageModel(byte[] image, String imagetext, String location) {
        this.image = image;
        this.imagetext = imagetext;
        this.location = location;
    }

    public byte[] getImage() {
        return this.image;
    }

    public String getImagetext() {
        return this.imagetext;
    }

    public String getLocation() {
        return this.location;
    }
}
