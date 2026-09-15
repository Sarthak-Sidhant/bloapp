package in.gov.eci.bloapp.model.SIR;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class unCollectableStatus1 {

    @SerializedName("collectedOn")
    private String CollectedOn;

    @SerializedName("collectedBy")
    private String collectedBy;

    @SerializedName("deliveredOn")
    private String deliveredOn;

    @SerializedName("enrolledEpicNo")
    private String enrolledEpicNo;

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

    @SerializedName("unCollectableOtherReason")
    private String unCollectableOtherReason;

    @SerializedName("unCollectableReason")
    private String unCollectableReason;

    public unCollectableStatus1(int partSerialNumber, String epicNo, String status, String isPrinted, String isDelivered, String isCollected, String isUnCollectable, String collectedBy, String collectedOn, String deliveredOn, String unCollectableReason, String unCollectableOtherReason, String enrolledEpicNo) {
        this.partSerialNumber = partSerialNumber;
        this.epicNo = epicNo;
        this.status = status;
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
}
