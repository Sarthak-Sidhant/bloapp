package in.gov.eci.bloapp.room.roommodel;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class VoterChangeModel {
    public String assemblyCons;
    public String changeType;
    public String district;
    public String epicNum;
    public String fatherName;
    public String houseNo;
    public Long id;
    public String name;
    public String partNo;
    public String pincode;
    public String postOffice;
    public String pwdMob;
    public String requestType;
    public String state;
    public String status;
    public String street;
    public String town;

    public VoterChangeModel(Long id, String name, String fatherName, String state, String district, String assemblyCons, String status, String pwdMob, String houseNo, String street, String town, String postOffice, String changeType, String pincode, String requestType, String partNo, String epicNum) {
        this.id = id;
        this.name = name;
        this.fatherName = fatherName;
        this.state = state;
        this.district = district;
        this.assemblyCons = assemblyCons;
        this.status = status;
        this.pwdMob = pwdMob;
        this.houseNo = houseNo;
        this.street = street;
        this.town = town;
        this.postOffice = postOffice;
        this.changeType = changeType;
        this.pincode = pincode;
        this.requestType = requestType;
        this.partNo = partNo;
        this.epicNum = epicNum;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getFatherName() {
        return this.fatherName;
    }

    public String getState() {
        return this.state;
    }

    public String getDistrict() {
        return this.district;
    }

    public String getAssemblyCons() {
        return this.assemblyCons;
    }

    public String getStatus() {
        return this.status;
    }

    public String getPwdMob() {
        return this.pwdMob;
    }

    public String getHouseNo() {
        return this.houseNo;
    }

    public String getStreet() {
        return this.street;
    }

    public String getTown() {
        return this.town;
    }

    public String getPostOffice() {
        return this.postOffice;
    }

    public String getChangeType() {
        return this.changeType;
    }

    public String getPincode() {
        return this.pincode;
    }

    public String getRequestType() {
        return this.requestType;
    }

    public String getPartNo() {
        return this.partNo;
    }

    public String getEpicNum() {
        return this.epicNum;
    }
}
