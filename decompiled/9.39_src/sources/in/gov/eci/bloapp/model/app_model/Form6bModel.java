package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class Form6bModel {

    @SerializedName("AADHAR_NUMBER")
    public String aadharno;

    @SerializedName("AADHAR_TYPE")
    public String aadhartype;

    @SerializedName("SUBMISSION_DATE")
    public String date;

    @SerializedName("EMAIL_ID")
    public String emailid;

    @SerializedName("EPIC_NUMBER")
    public String epicNo;

    @SerializedName("FIRST_NAME")
    public String firstName;

    @SerializedName("LAST_NAME")
    public String lastName;

    @SerializedName("MOBILE_NUMBER")
    public String mobileno;

    @SerializedName("SUBMISSION_PLACE")
    public String place;

    public Form6bModel(String firstName, String lastName, String epicNo, String aadhartype, String aadharno, String mobileno, String emailid, String place, String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.epicNo = epicNo;
        this.aadhartype = aadhartype;
        this.aadharno = aadharno;
        this.mobileno = mobileno;
        this.emailid = emailid;
        this.place = place;
        this.date = date;
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

    public String getAadhartype() {
        return this.aadhartype;
    }

    public String getAadharno() {
        return this.aadharno;
    }

    public String getMobileno() {
        return this.mobileno;
    }

    public String getEmailid() {
        return this.emailid;
    }

    public String getPlace() {
        return this.place;
    }

    public String getDate() {
        return this.date;
    }
}
