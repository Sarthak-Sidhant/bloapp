package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class H2hDetailsModel {

    @SerializedName("AGE")
    public String age;

    @SerializedName("DATE_OF_BIRTH")
    public String dob;

    @SerializedName("EMAIL_ID")
    public String email;

    @SerializedName("EPIC")
    public String epic;

    @SerializedName("FIRST_NAME")
    public String firstname;

    @SerializedName("GENDER")
    public String gender;

    @SerializedName("HOUSE_NUMBER")
    public String houseno;

    @SerializedName("LAST_NAME")
    public String lastname;

    @SerializedName("MOBILE_NUMBER")
    public String mobile;

    @SerializedName("PINCODE")
    public String pincode;

    @SerializedName("POST_OFFICE")
    public String postoffice;

    @SerializedName("RELATION_TYPE")
    public String relationtype;

    @SerializedName("RELATIVE_NAME")
    public String relativename;

    @SerializedName("STREET")
    public String street;

    @SerializedName("VILLAGE")
    public String village;

    public H2hDetailsModel(String firstname, String lastname, String epic, String gender, String relativename, String relationtype, String mobile, String email, String age, String dob, String houseno, String street, String postoffice, String village, String pincode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.epic = epic;
        this.gender = gender;
        this.relativename = relativename;
        this.relationtype = relationtype;
        this.mobile = mobile;
        this.email = email;
        this.age = age;
        this.dob = dob;
        this.houseno = houseno;
        this.street = street;
        this.postoffice = postoffice;
        this.village = village;
        this.pincode = pincode;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getEpic() {
        return this.epic;
    }

    public String getGender() {
        return this.gender;
    }

    public String getRelativename() {
        return this.relativename;
    }

    public String getRelationtype() {
        return this.relationtype;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAge() {
        return this.age;
    }

    public String getDob() {
        return this.dob;
    }

    public String getHouseno() {
        return this.houseno;
    }

    public String getStreet() {
        return this.street;
    }

    public String getPostoffice() {
        return this.postoffice;
    }

    public String getVillage() {
        return this.village;
    }

    public String getPincode() {
        return this.pincode;
    }
}
