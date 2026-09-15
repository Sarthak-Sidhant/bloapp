package in.gov.eci.bloapp.model.SIR;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class SelfProgenyModel {
    private int Age;
    private int ac;
    private String currentEpic;
    private String currentEpicNo;
    private String currentacNo;
    private String currentpartNo;
    private String currentpartSerialNo;
    private String currentstate;
    private String discrepancyFlag;
    private String electorName;
    private String epicNo;
    private int id;
    private int part;
    private int partSerialNo;
    private String progenyEpicNo;
    private String relativeLastName;
    private String relativeName;
    private String remark;

    public SelfProgenyModel(int id, String electorName, String epicNo, int ac, int part, String relativeName, String relativeLastName, int partSerialNo, String progenyEpicNo, String currentEpic, int Age, String discrepancyFlag, String currentstate, String currentacNo, String currentpartNo, String currentpartSerialNo, String currentEpicNo, String remark) {
        this.id = id;
        this.electorName = electorName;
        this.epicNo = epicNo;
        this.ac = ac;
        this.part = part;
        this.relativeName = relativeName;
        this.relativeLastName = relativeLastName;
        this.partSerialNo = partSerialNo;
        this.progenyEpicNo = progenyEpicNo;
        this.currentEpic = currentEpic;
        this.Age = Age;
        this.discrepancyFlag = discrepancyFlag;
        this.currentstate = currentstate;
        this.currentacNo = currentacNo;
        this.currentpartNo = currentpartNo;
        this.currentpartSerialNo = currentpartSerialNo;
        this.currentEpicNo = currentEpicNo;
        this.remark = remark;
    }

    public String getCurrentEpic() {
        return this.currentEpic;
    }

    public void setCurrentEpic(String currentEpic) {
        this.currentEpic = currentEpic;
    }

    public String getCurrentstate() {
        return this.currentstate;
    }

    public void setCurrentstate(String currentstate) {
        this.currentstate = currentstate;
    }

    public String getCurrentacNo() {
        return this.currentacNo;
    }

    public void setCurrentacNo(String currentacNo) {
        this.currentacNo = currentacNo;
    }

    public String getCurrentpartNo() {
        return this.currentpartNo;
    }

    public void setCurrentpartNo(String currentpartNo) {
        this.currentpartNo = currentpartNo;
    }

    public String getCurrentpartSerialNo() {
        return this.currentpartSerialNo;
    }

    public void setCurrentpartSerialNo(String currentpartSerialNo) {
        this.currentpartSerialNo = currentpartSerialNo;
    }

    public String getDiscrepancyFlag() {
        return this.discrepancyFlag;
    }

    public void setDiscrepancyFlag(String discrepancyFlag) {
        this.discrepancyFlag = discrepancyFlag;
    }

    public int getAge() {
        return this.Age;
    }

    public void setAge(int age) {
        this.Age = age;
    }

    public String getCurrentEpicNo() {
        return this.currentEpicNo;
    }

    public void setCurrentEpicNo(String currentEpicNo) {
        this.currentEpicNo = currentEpicNo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getElectorName() {
        return this.electorName;
    }

    public void setElectorName(String electorName) {
        this.electorName = electorName;
    }

    public String getEpicNo() {
        return this.epicNo;
    }

    public void setEpicNo(String epicNo) {
        this.epicNo = epicNo;
    }

    public int getAc() {
        return this.ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public int getPart() {
        return this.part;
    }

    public void setPart(int part) {
        this.part = part;
    }

    public String getRelativeName() {
        return this.relativeName;
    }

    public void setRelativeName(String relativeName) {
        this.relativeName = relativeName;
    }

    public String getRelativeLastName() {
        return this.relativeLastName;
    }

    public void setRelativeLastName(String relativeLastName) {
        this.relativeLastName = relativeLastName;
    }

    public int getPartSerialNo() {
        return this.partSerialNo;
    }

    public void setPartSerialNo(int partSerialNo) {
        this.partSerialNo = partSerialNo;
    }

    public String getProgenyEpicNo() {
        return this.progenyEpicNo;
    }

    public void setProgenyEpicNo(String progenyEpicNo) {
        this.progenyEpicNo = progenyEpicNo;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
