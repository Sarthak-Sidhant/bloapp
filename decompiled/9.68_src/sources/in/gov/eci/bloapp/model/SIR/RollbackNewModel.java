package in.gov.eci.bloapp.model.SIR;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class RollbackNewModel {
    private String efBackUrl;
    private String efFrontUrl;
    private String enrolledEpicNo;
    private Long epicId;
    private String epicNo;
    private String name;
    private String remarks;
    private String serialNo;
    private String suppDoc1Url;
    private String suppDoc2Url;
    private String uncollectableReason;

    public RollbackNewModel(String name, String epicNo, Long epicId, String serialNo, String remarks, String efFrontUrl, String efBackUrl, String suppDoc1Url, String suppDoc2Url, String uncollectableReason, String enrolledEpicNo) {
        this.name = name;
        this.epicNo = epicNo;
        this.epicId = epicId;
        this.serialNo = serialNo;
        this.remarks = remarks;
        this.efFrontUrl = efFrontUrl;
        this.efBackUrl = efBackUrl;
        this.suppDoc1Url = suppDoc1Url;
        this.suppDoc2Url = suppDoc2Url;
        this.uncollectableReason = uncollectableReason;
        this.enrolledEpicNo = enrolledEpicNo;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public String getEfFrontUrl() {
        return this.efFrontUrl;
    }

    public void setEfFrontUrl(String efFrontUrl) {
        this.efFrontUrl = efFrontUrl;
    }

    public String getEfBackUrl() {
        return this.efBackUrl;
    }

    public void setEfBackUrl(String efBackUrl) {
        this.efBackUrl = efBackUrl;
    }

    public String getSuppDoc1Url() {
        return this.suppDoc1Url;
    }

    public void setSuppDoc1Url(String suppDoc1Url) {
        this.suppDoc1Url = suppDoc1Url;
    }

    public String getSuppDoc2Url() {
        return this.suppDoc2Url;
    }

    public void setSuppDoc2Url(String suppDoc2Url) {
        this.suppDoc2Url = suppDoc2Url;
    }

    public String getUncollectableReason() {
        return this.uncollectableReason;
    }

    public void setUncollectableReason(String uncollectableReason) {
        this.uncollectableReason = uncollectableReason;
    }

    public Long getEpicId() {
        return this.epicId;
    }

    public void setEpicId(Long epicId) {
        this.epicId = epicId;
    }

    public String getEnrolledEpicNo() {
        return this.enrolledEpicNo;
    }

    public void setEnrolledEpicNo(String enrolledEpicNo) {
        this.enrolledEpicNo = enrolledEpicNo;
    }
}
