package in.gov.eci.bloapp.model.SIR;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class pendingListModel {
    private int acNo;
    private int age;
    private String dob;
    private Long epicId;
    private int epicMatch;
    private String epicNo;
    private String gender;
    private String name;
    private int partNo;
    private String relationType;
    private String relativeFullName;
    private String serialNo;
    private String state;

    public pendingListModel(String name, String epicNo, String serialNo, Long epicId, String dob, int age, String state, int acNo, int partNo, String gender, String relativeFullName, String relationType, int epicMatch) {
        this.name = name;
        this.epicNo = epicNo;
        this.serialNo = serialNo;
        this.epicId = epicId;
        this.dob = dob;
        this.age = age;
        this.state = state;
        this.acNo = acNo;
        this.partNo = partNo;
        this.gender = gender;
        this.relativeFullName = relativeFullName;
        this.relationType = relationType;
        this.epicMatch = epicMatch;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Long getEpicId() {
        return this.epicId;
    }

    public void setEpicId(Long epicId) {
        this.epicId = epicId;
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

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAcNo() {
        return this.acNo;
    }

    public void setAcNo(int acNo) {
        this.acNo = acNo;
    }

    public int getPartNo() {
        return this.partNo;
    }

    public void setPartNo(int partNo) {
        this.partNo = partNo;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRelativeFullName() {
        return this.relativeFullName;
    }

    public void setRelativeFullName(String relativeFullName) {
        this.relativeFullName = relativeFullName;
    }

    public int getEpicMatch() {
        return this.epicMatch;
    }

    public void setEpicMatch(int epicMatch) {
        this.epicMatch = epicMatch;
    }

    public String getRelationType() {
        return this.relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }
}
