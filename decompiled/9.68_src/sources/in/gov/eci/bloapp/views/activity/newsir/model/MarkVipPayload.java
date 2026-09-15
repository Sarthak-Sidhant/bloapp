package in.gov.eci.bloapp.views.activity.newsir.model;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class MarkVipPayload {
    public int assemblyNo;
    public String electorName;
    public int epicId;
    public String epicNumber;
    public String gender;
    public Boolean isVip;
    public int partNumber;
    public int partSerialNumber;
    public String recommendationStatus;
    public String relationName;
    public String status;

    public int getEpicId() {
        return this.epicId;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
    }

    public String getEpicNumber() {
        return this.epicNumber;
    }

    public void setEpicNumber(String epicNumber) {
        this.epicNumber = epicNumber;
    }

    public String getElectorName() {
        return this.electorName;
    }

    public void setElectorName(String electorName) {
        this.electorName = electorName;
    }

    public Boolean getVip() {
        return this.isVip;
    }

    public void setVip(Boolean vip) {
        this.isVip = vip;
    }

    public String getRecommendationStatus() {
        return this.recommendationStatus;
    }

    public void setRecommendationStatus(String recommendationStatus) {
        this.recommendationStatus = recommendationStatus;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    public int getAssemblyNo() {
        return this.assemblyNo;
    }

    public void setAssemblyNo(int assemblyNo) {
        this.assemblyNo = assemblyNo;
    }

    public int getPartSerialNumber() {
        return this.partSerialNumber;
    }

    public void setPartSerialNumber(int partSerialNumber) {
        this.partSerialNumber = partSerialNumber;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRelationName() {
        return this.relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }
}
