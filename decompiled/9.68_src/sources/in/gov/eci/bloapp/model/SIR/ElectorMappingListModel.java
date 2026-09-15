package in.gov.eci.bloapp.model.SIR;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ElectorMappingListModel {
    private int Ac;
    private int Part;
    private int SerialNo;
    private int currentAc;
    private int currentAge;
    private int currentPart;
    private int currentSerialNo;
    private String discrepancyFlag;
    private String epicNo;
    private String erollRelationType;
    private int id;
    private String modifiedBy;
    private String name;
    private String oldEpic;
    private String previousElectorName;
    private int progencyCount;
    private String relativeCurrentName;
    private String relativeName;
    private String remark;
    private String stateCode;
    private int verifyStatus;

    public ElectorMappingListModel(int id, String name, String previousElectorName, String relativeName, String relativeCurrentName, String erollRelationType, String epicNo, int ac, int part, int serialNo, String oldEpic, int currentAc, int currentPart, int currentSerialNo, String stateCode, String modifiedBy, int progencyCount, int verifyStatus, int currentAge, String discrepancyFlag, String remark) {
        this.id = id;
        this.name = name;
        this.previousElectorName = previousElectorName;
        this.relativeName = relativeName;
        this.relativeCurrentName = relativeCurrentName;
        this.erollRelationType = erollRelationType;
        this.epicNo = epicNo;
        this.Ac = ac;
        this.Part = part;
        this.SerialNo = serialNo;
        this.oldEpic = oldEpic;
        this.currentAc = currentAc;
        this.currentPart = currentPart;
        this.currentSerialNo = currentSerialNo;
        this.stateCode = stateCode;
        this.modifiedBy = modifiedBy;
        this.verifyStatus = verifyStatus;
        this.progencyCount = progencyCount;
        this.currentAge = currentAge;
        this.discrepancyFlag = discrepancyFlag;
        this.remark = remark;
    }

    public String getDiscrepancyFlag() {
        return this.discrepancyFlag;
    }

    public void setDiscrepancyFlag(String discrepancyFlag) {
        this.discrepancyFlag = discrepancyFlag;
    }

    public String getOldEpic() {
        return this.oldEpic;
    }

    public void setOldEpic(String oldEpic) {
        this.oldEpic = oldEpic;
    }

    public int getAc() {
        return this.Ac;
    }

    public void setAc(int ac) {
        this.Ac = ac;
    }

    public int getPart() {
        return this.Part;
    }

    public void setPart(int part) {
        this.Part = part;
    }

    public int getSerialNo() {
        return this.SerialNo;
    }

    public void setSerialNo(int serialNo) {
        this.SerialNo = serialNo;
    }

    public int getId() {
        return this.id;
    }

    public String getRelativeCurrentName() {
        return this.relativeCurrentName;
    }

    public void setRelativeCurrentName(String relativeCurrentName) {
        this.relativeCurrentName = relativeCurrentName;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCurrentAc() {
        return this.currentAc;
    }

    public void setCurrentAc(int currentAc) {
        this.currentAc = currentAc;
    }

    public int getCurrentPart() {
        return this.currentPart;
    }

    public void setCurrentPart(int currentPart) {
        this.currentPart = currentPart;
    }

    public int getCurrentSerialNo() {
        return this.currentSerialNo;
    }

    public void setCurrentSerialNo(int currentSerialNo) {
        this.currentSerialNo = currentSerialNo;
    }

    public String getStateCode() {
        return this.stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getRelativeName() {
        return this.relativeName;
    }

    public void setRelativeName(String relativeName) {
        this.relativeName = relativeName;
    }

    public String getErollRelationType() {
        return this.erollRelationType;
    }

    public void setErollRelationType(String erollRelationType) {
        this.erollRelationType = erollRelationType;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getPreviousElectorName() {
        return this.previousElectorName;
    }

    public void setPreviousElectorName(String previousElectorName) {
        this.previousElectorName = previousElectorName;
    }

    public int getProgencyCount() {
        return this.progencyCount;
    }

    public void setProgencyCount(int progencyCount) {
        this.progencyCount = progencyCount;
    }

    public int getCurrentAge() {
        return this.currentAge;
    }

    public void setCurrentAge(int currentAge) {
        this.currentAge = currentAge;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
