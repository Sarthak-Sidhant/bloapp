package in.gov.eci.bloapp.views.activity.newsir.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class VerifyPayload implements Parcelable {
    public static final Parcelable.Creator<VerifyPayload> CREATOR = new Parcelable.Creator<VerifyPayload>() { // from class: in.gov.eci.bloapp.views.activity.newsir.model.VerifyPayload.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VerifyPayload createFromParcel(Parcel in2) {
            return new VerifyPayload(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VerifyPayload[] newArray(int size) {
            return new VerifyPayload[size];
        }
    };
    public String anomalyNoActionRequired;
    public String backToBloRemarks;
    public String categoryType;
    public String deceased;
    public String dseClusterId;
    public String dseElector;
    public int dseType;
    public String eightyFivePlus;
    public Long epicId;
    public String epicName;
    public String epicNo;
    public String flag;
    public String hearingScheduled;
    public int partSerialNo;
    public String pseElector;
    public String relationType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VerifyPayload() {
    }

    protected VerifyPayload(Parcel in2) {
        this.partSerialNo = in2.readInt();
        this.epicName = in2.readString();
        this.epicId = Long.valueOf(in2.readLong());
        this.epicNo = in2.readString();
        this.backToBloRemarks = in2.readString();
        this.categoryType = in2.readString();
        this.deceased = in2.readString();
        this.eightyFivePlus = in2.readString();
        this.pseElector = in2.readString();
        this.dseElector = in2.readString();
        this.dseClusterId = in2.readString();
        this.dseType = in2.readInt();
        this.hearingScheduled = in2.readString();
        this.relationType = in2.readString();
        this.anomalyNoActionRequired = in2.readString();
        this.flag = in2.readString();
    }

    public String getCategoryType() {
        return this.categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public int getPartSerialNo() {
        return this.partSerialNo;
    }

    public void setPartSerialNo(int partSerialNo) {
        this.partSerialNo = partSerialNo;
    }

    public String getEpicName() {
        return this.epicName;
    }

    public void setEpicName(String epicName) {
        this.epicName = epicName;
    }

    public Long getEpicId() {
        return this.epicId;
    }

    public void setEpicId(Long epicId) {
        this.epicId = epicId;
    }

    public String getEpicNo() {
        return this.epicNo;
    }

    public void setEpicNo(String epicNo) {
        this.epicNo = epicNo;
    }

    public String getBackToBloRemarks() {
        return this.backToBloRemarks;
    }

    public void setBackToBloRemarks(String backToBloRemarks) {
        this.backToBloRemarks = backToBloRemarks;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.partSerialNo);
        dest.writeString(this.epicName);
        dest.writeLong(this.epicId.longValue());
        dest.writeString(this.epicNo);
        dest.writeString(this.backToBloRemarks);
        dest.writeString(this.categoryType);
        dest.writeString(this.deceased);
        dest.writeString(this.eightyFivePlus);
        dest.writeString(this.pseElector);
        dest.writeString(this.dseElector);
        dest.writeString(this.dseClusterId);
        dest.writeInt(this.dseType);
        dest.writeString(this.hearingScheduled);
        dest.writeString(this.relationType);
        dest.writeString(this.anomalyNoActionRequired);
        dest.writeString(this.flag);
    }

    public String getDeceased() {
        return this.deceased;
    }

    public void setDeceased(String deceased) {
        this.deceased = deceased;
    }

    public String getEightyFivePlus() {
        return this.eightyFivePlus;
    }

    public void setEightyFivePlus(String eightyFivePlus) {
        this.eightyFivePlus = eightyFivePlus;
    }

    public String getPse() {
        return this.pseElector;
    }

    public void setPse(String pse) {
        this.pseElector = pse;
    }

    public String getDse() {
        return this.dseElector;
    }

    public void setDse(String dse) {
        this.dseElector = dse;
    }

    public String getDseClusterId() {
        return this.dseClusterId;
    }

    public void setDseClusterId(String dseClusterId) {
        this.dseClusterId = dseClusterId;
    }

    public int getDseType() {
        return this.dseType;
    }

    public String getRelationType() {
        return this.relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getHearingScheduled() {
        return this.hearingScheduled;
    }

    public void setHearingScheduled(String hearingScheduled) {
        this.hearingScheduled = hearingScheduled;
    }

    public String getAnomalyNoActionRequired() {
        return this.anomalyNoActionRequired;
    }

    public void setAnomalyNoActionRequired(String anomalyNoActionRequired) {
        this.anomalyNoActionRequired = anomalyNoActionRequired;
    }

    public String getFlag() {
        return this.flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setDseType(int dseType) {
        this.dseType = dseType;
    }
}
