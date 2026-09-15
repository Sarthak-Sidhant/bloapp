package in.gov.eci.bloapp.model.SIR;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class unCollectableStatus {

    @SerializedName("collectedOn")
    private String CollectedOn;

    @SerializedName("collectedBy")
    private String collectedBy;

    @SerializedName("deliveredOn")
    private String deliveredOn;

    @SerializedName("efBackUrl")
    private String efBackUrl;

    @SerializedName("efFrontUrl")
    private String efFrontUrl;

    @SerializedName("enrolledEpicNo")
    private String enrolledEpicNo;

    @SerializedName("epicId")
    private Long epicId;

    @SerializedName("epicNo")
    private String epicNo;

    @SerializedName("isCollected")
    private String isCollected;

    @SerializedName("isDelivered")
    private String isDelivered;

    @SerializedName("isPrinted")
    private String isPrinted;

    @SerializedName("isUnCollectable")
    private String isUnCollectable;

    @SerializedName("partSerialNo")
    private int partSerialNumber;

    @SerializedName("status")
    private String status;

    @SerializedName("suppDoc1Url")
    private String suppDoc1Url;

    @SerializedName("suppDoc2Url")
    private String suppDoc2Url;

    @SerializedName("unCollectableOtherReason")
    private String unCollectableOtherReason;

    @SerializedName("unCollectableReason")
    private String unCollectableReason;

    @SerializedName("uncollectableRemarks")
    private String uncollectableRemarks;

    public unCollectableStatus(int partSerialNumber, String epicNo, Long epicId, String status, String isPrinted, String isDelivered, String isCollected, String isUnCollectable, String collectedBy, String collectedOn, String deliveredOn, String unCollectableReason, String unCollectableOtherReason, String enrolledEpicNo, String efFrontUrl, String efBackUrl, String suppDoc1Url, String suppDoc2Url, String uncollectableRemarks) {
        this.partSerialNumber = partSerialNumber;
        this.epicNo = epicNo;
        this.status = status;
        this.epicId = epicId;
        this.isPrinted = isPrinted;
        this.isDelivered = isDelivered;
        this.isCollected = isCollected;
        this.isUnCollectable = isUnCollectable;
        this.collectedBy = collectedBy;
        this.CollectedOn = collectedOn;
        this.deliveredOn = deliveredOn;
        this.unCollectableReason = unCollectableReason;
        this.unCollectableOtherReason = unCollectableOtherReason;
        this.enrolledEpicNo = enrolledEpicNo;
        this.efFrontUrl = efFrontUrl;
        this.efBackUrl = efBackUrl;
        this.suppDoc1Url = suppDoc1Url;
        this.suppDoc2Url = suppDoc2Url;
        this.uncollectableRemarks = uncollectableRemarks;
    }

    public String getUncollectableRemarks() {
        return this.uncollectableRemarks;
    }

    public void setUncollectableRemarks(String uncollectableRemarks) {
        this.uncollectableRemarks = uncollectableRemarks;
    }

    public int getPartSerialNumber() {
        return this.partSerialNumber;
    }

    public void setPartSerialNumber(int partSerialNumber) {
        this.partSerialNumber = partSerialNumber;
    }

    public String getEpicNo() {
        return this.epicNo;
    }

    public void setEpicNo(String epicNo) {
        this.epicNo = epicNo;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsPrinted() {
        return this.isPrinted;
    }

    public void setIsPrinted(String isPrinted) {
        this.isPrinted = isPrinted;
    }

    public String getIsDelivered() {
        return this.isDelivered;
    }

    public void setIsDelivered(String isDelivered) {
        this.isDelivered = isDelivered;
    }

    public String getIsCollected() {
        return this.isCollected;
    }

    public void setIsCollected(String isCollected) {
        this.isCollected = isCollected;
    }

    public String getIsUnCollectable() {
        return this.isUnCollectable;
    }

    public void setIsUnCollectable(String isUnCollectable) {
        this.isUnCollectable = isUnCollectable;
    }

    public String getCollectedBy() {
        return this.collectedBy;
    }

    public void setCollectedBy(String collectedBy) {
        this.collectedBy = collectedBy;
    }

    public String getCollectedOn() {
        return this.CollectedOn;
    }

    public void setCollectedOn(String collectedOn) {
        this.CollectedOn = collectedOn;
    }

    public String getDeliveredOn() {
        return this.deliveredOn;
    }

    public void setDeliveredOn(String deliveredOn) {
        this.deliveredOn = deliveredOn;
    }

    public String getUnCollectableReason() {
        return this.unCollectableReason;
    }

    public void setUnCollectableReason(String unCollectableReason) {
        this.unCollectableReason = unCollectableReason;
    }

    public String getUnCollectableOtherReason() {
        return this.unCollectableOtherReason;
    }

    public void setUnCollectableOtherReason(String unCollectableOtherReason) {
        this.unCollectableOtherReason = unCollectableOtherReason;
    }

    public String getEnrolledEpicNo() {
        return this.enrolledEpicNo;
    }

    public void setEnrolledEpicNo(String enrolledEpicNo) {
        this.enrolledEpicNo = enrolledEpicNo;
    }

    public Long getEpicId() {
        return this.epicId;
    }

    public void setEpicId(Long epicId) {
        this.epicId = epicId;
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
}
