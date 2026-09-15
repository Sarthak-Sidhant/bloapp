package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class CountryModel {

    @SerializedName("CountryName")
    public String country;

    public CountryModel(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }
}
