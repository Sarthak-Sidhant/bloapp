package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class DeletionObjectionDataModel {

    @SerializedName("ASSEMBLY_DETAILS")
    public String assembly;

    @SerializedName("DISTRICT_DETAILS")
    public String district;

    @SerializedName("EPIC")
    public String epic;

    @SerializedName("MOBILE")
    public String mobile;

    @SerializedName("NAME")
    public String name;

    @SerializedName("PHOTOGRAPH")
    public byte[] photo;

    @SerializedName("PINCODE")
    public String pincode;

    @SerializedName("POSTOFFICE")
    public String postoffice;

    @SerializedName("STATE_DETAILS")
    public String state;

    @SerializedName("STREET")
    public String street;

    @SerializedName("SURNAME")
    public String surname;

    @SerializedName("TEHSIL")
    public String tehsil;

    @SerializedName("VILLAGE")
    public String village;

    public DeletionObjectionDataModel(String state, String district, String assembly, String name, String surname, String epic, String mobile, String street, String village, String postoffice, String pincode, String tehsil, byte[] photo) {
        this.state = state;
        this.district = district;
        this.assembly = assembly;
        this.name = name;
        this.surname = surname;
        this.epic = epic;
        this.mobile = mobile;
        this.street = street;
        this.village = village;
        this.postoffice = postoffice;
        this.pincode = pincode;
        this.tehsil = tehsil;
        this.photo = photo;
    }

    public String getState() {
        return this.state;
    }

    public String getDistrict() {
        return this.district;
    }

    public String getAssembly() {
        return this.assembly;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getEpic() {
        return this.epic;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getStreet() {
        return this.street;
    }

    public String getVillage() {
        return this.village;
    }

    public String getPostoffice() {
        return this.postoffice;
    }

    public String getPincode() {
        return this.pincode;
    }

    public String getTehsil() {
        return this.tehsil;
    }

    public byte[] getPhoto() {
        return this.photo;
    }
}
