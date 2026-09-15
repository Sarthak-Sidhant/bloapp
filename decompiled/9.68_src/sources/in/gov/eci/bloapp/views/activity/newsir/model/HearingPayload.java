package in.gov.eci.bloapp.views.activity.newsir.model;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class HearingPayload {
    public int acNo;
    public String deliveredTo;
    public Long epicId;
    public String epicNo;
    public String name;
    public int partNo;
    public int partSerialNo;
    public String uploadHearingReciept;

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

    public int getPartSerialNo() {
        return this.partSerialNo;
    }

    public void setPartSerialNo(int partSerialNo) {
        this.partSerialNo = partSerialNo;
    }

    public Long getEpicId() {
        return this.epicId;
    }

    public void setEpicId(Long epicId) {
        this.epicId = epicId;
    }

    public String getUploadHearingReciept() {
        return this.uploadHearingReciept;
    }

    public void setUploadHearingReciept(String uploadHearingReciept) {
        this.uploadHearingReciept = uploadHearingReciept;
    }

    public String getDeliveredTo() {
        return this.deliveredTo;
    }

    public void setDeliveredTo(String deliveredTo) {
        this.deliveredTo = deliveredTo;
    }
}
