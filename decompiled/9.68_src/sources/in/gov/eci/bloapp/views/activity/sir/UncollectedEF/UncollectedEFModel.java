package in.gov.eci.bloapp.views.activity.sir.UncollectedEF;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class UncollectedEFModel {
    private String acNo;
    private String electorName;
    private String enrolledEpicNo;
    private Long epicId;
    private String epicNo;
    private String partNo;
    private String partSerialNo;
    private String uncollectableReason;

    public UncollectedEFModel(String electorName, String epicNo, String partSerialNo, String uncollectableReason, String acNo, String partNo, String enrolledEpicNo, Long epicId) {
        this.electorName = electorName;
        this.epicNo = epicNo;
        this.partSerialNo = partSerialNo;
        this.uncollectableReason = uncollectableReason;
        this.acNo = acNo;
        this.partNo = partNo;
        this.enrolledEpicNo = enrolledEpicNo;
        this.epicId = epicId;
    }

    public String getEnrolledEpicNo() {
        return this.enrolledEpicNo;
    }

    public void setEnrolledEpicNo(String enrolledEpicNo) {
        this.enrolledEpicNo = enrolledEpicNo;
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

    public String getPartSerialNo() {
        return this.partSerialNo;
    }

    public void setPartSerialNo(String partSerialNo) {
        this.partSerialNo = partSerialNo;
    }

    public String getUncollectableReason() {
        return this.uncollectableReason;
    }

    public void setUncollectableReason(String uncollectableReason) {
        this.uncollectableReason = uncollectableReason;
    }

    public String getAcNo() {
        return this.acNo;
    }

    public void setAcNo(String acNo) {
        this.acNo = acNo;
    }

    public String getPartNo() {
        return this.partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public Long getEpicId() {
        return this.epicId;
    }

    public void setEpicId(Long epicId) {
        this.epicId = epicId;
    }
}
