package in.gov.eci.bloapp.model.SIR;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class DeleveryHearingListModel {
    private String epicNo;
    private String name;
    private int partNo;
    private String serialNo;

    public DeleveryHearingListModel(String name, String epicNo, String serialNo, int partNo) {
        this.name = name;
        this.epicNo = epicNo;
        this.serialNo = serialNo;
        this.partNo = partNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEpicNo() {
        return this.epicNo;
    }

    public void setEpicNo(String epicNo) {
        this.epicNo = epicNo;
    }

    public String getSerialNo() {
        return this.serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public int getPartNo() {
        return this.partNo;
    }

    public void setPartNo(int partNo) {
        this.partNo = partNo;
    }
}
