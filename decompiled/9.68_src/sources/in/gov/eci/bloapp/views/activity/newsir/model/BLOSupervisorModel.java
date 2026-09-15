package in.gov.eci.bloapp.views.activity.newsir.model;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class BLOSupervisorModel {
    public int acNo;
    public String mobileNumber;
    public String name;
    public String partName;
    public int partNo;

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getPartNo() {
        return this.partNo;
    }

    public void setPartNo(int partNo) {
        this.partNo = partNo;
    }

    public int getAcNo() {
        return this.acNo;
    }

    public void setAcNo(int acNo) {
        this.acNo = acNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartName() {
        return this.partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public BLOSupervisorModel(String mobileNumber, int partNo, int acNo, String name, String partName) {
        this.mobileNumber = mobileNumber;
        this.partNo = partNo;
        this.acNo = acNo;
        this.name = name;
        this.partName = partName;
    }
}
