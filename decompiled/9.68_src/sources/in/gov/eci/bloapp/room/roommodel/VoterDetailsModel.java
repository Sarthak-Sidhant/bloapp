package in.gov.eci.bloapp.room.roommodel;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class VoterDetailsModel {
    public String agr;
    public String constituency;
    public String district;
    public String epicNum;
    public String fatherName;
    public String firstName;
    public String gender;
    public Long id;
    public String lastName;
    public String mobNum;
    public String state;

    public VoterDetailsModel(Long id, String firstName, String lastName, String fatherName, String mobNum, String agr, String gender, String constituency, String epicNum, String state, String district) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.mobNum = mobNum;
        this.agr = agr;
        this.gender = gender;
        this.constituency = constituency;
        this.epicNum = epicNum;
        this.state = state;
        this.district = district;
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFatherName() {
        return this.fatherName;
    }

    public String getMobNum() {
        return this.mobNum;
    }

    public String getAgr() {
        return this.agr;
    }

    public String getGender() {
        return this.gender;
    }

    public String getConstituency() {
        return this.constituency;
    }

    public String getEpicNum() {
        return this.epicNum;
    }

    public String getState() {
        return this.state;
    }

    public String getDistrict() {
        return this.district;
    }
}
