package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class BloModel {

    @SerializedName("OFFICE_ADDRESS")
    public String address;

    @SerializedName("NAME_CONSTITUENCY")
    public String constituency;

    @SerializedName("NUMBER_CONSTITUENCY")
    public String constituencyNo;

    @SerializedName("DISTRICT")
    public String district;

    @SerializedName("EMAIL")
    public String email;

    @SerializedName("EPIC_NUMBER")
    public String epicNo;

    @SerializedName("FIRST_NAME")
    public String firstName;

    @SerializedName("LAST_NAME")
    public String lastName;

    @SerializedName("MOBILE_NUMBER")
    public String mobNo;

    @SerializedName("STATE")
    public String state;

    public BloModel(String firstName, String mobNo, String email, String address) {
        this.firstName = firstName;
        this.mobNo = mobNo;
        this.email = email;
        this.address = address;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEpicNo() {
        return this.epicNo;
    }

    public String getMobNo() {
        return this.mobNo;
    }

    public String getState() {
        return this.state;
    }

    public String getDistrict() {
        return this.district;
    }

    public String getConstituency() {
        return this.constituency;
    }

    public String getConstituencyNo() {
        return this.constituencyNo;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAddress() {
        return this.address;
    }
}
