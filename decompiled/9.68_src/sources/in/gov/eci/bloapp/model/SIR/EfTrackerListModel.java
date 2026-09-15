package in.gov.eci.bloapp.model.SIR;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class EfTrackerListModel {
    private int acNo;
    private String epicId;
    private int epicMatch;
    private String epicNo;
    private String isCollected;
    private String isDelivered;
    private String isUncollectable;
    private String name;
    private String serialNo;

    public EfTrackerListModel(String name, String epicNo, String epicId, String serialNo, String isCollected, String isDelivered, String isUncollectable, int epicMatch) {
        this.name = name;
        this.epicNo = epicNo;
        this.epicId = epicId;
        this.serialNo = serialNo;
        this.isCollected = isCollected;
        this.isDelivered = isDelivered;
        this.isUncollectable = isUncollectable;
        this.epicMatch = epicMatch;
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

    public String getEpicId() {
        return this.epicId;
    }

    public void setEpicId(String epicId) {
        this.epicId = epicId;
    }

    public int getAcNo() {
        return this.acNo;
    }

    public void setAcNo(int acNo) {
        this.acNo = acNo;
    }

    public String getIsCollected() {
        return this.isCollected;
    }

    public void setIsCollected(String isCollected) {
        this.isCollected = isCollected;
    }

    public String getIsDelivered() {
        return this.isDelivered;
    }

    public void setIsDelivered(String isDelivered) {
        this.isDelivered = isDelivered;
    }

    public String getIsUncollectable() {
        return this.isUncollectable;
    }

    public void setIsUncollectable(String isUncollectable) {
        this.isUncollectable = isUncollectable;
    }

    public int getEpicMatch() {
        return this.epicMatch;
    }

    public void setEpicMatch(int epicMatch) {
        this.epicMatch = epicMatch;
    }
}
