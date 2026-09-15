package in.gov.eci.bloapp.views.activity.newsir.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class UpdateMobilePayload implements Parcelable {
    public static final Parcelable.Creator<UpdateMobilePayload> CREATOR = new Parcelable.Creator<UpdateMobilePayload>() { // from class: in.gov.eci.bloapp.views.activity.newsir.model.UpdateMobilePayload.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UpdateMobilePayload createFromParcel(Parcel in2) {
            return new UpdateMobilePayload(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UpdateMobilePayload[] newArray(int size) {
            return new UpdateMobilePayload[size];
        }
    };
    public String anomalyNoActionRequired;
    public String categoryType;
    public Long epicId;
    public String epicName;
    public String epicNo;
    public String mobileNo;
    public int partSerialNo;
    public String relationType;
    public String updatedEpic;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UpdateMobilePayload() {
    }

    protected UpdateMobilePayload(Parcel in2) {
        this.relationType = in2.readString();
        this.categoryType = in2.readString();
        this.epicName = in2.readString();
        this.mobileNo = in2.readString();
        this.epicNo = in2.readString();
        this.epicId = Long.valueOf(in2.readLong());
        this.partSerialNo = in2.readInt();
        this.anomalyNoActionRequired = in2.readString();
        this.updatedEpic = in2.readString();
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.relationType);
        dest.writeString(this.categoryType);
        dest.writeString(this.epicName);
        dest.writeString(this.mobileNo);
        dest.writeString(this.epicNo);
        dest.writeLong(this.epicId.longValue());
        dest.writeInt(this.partSerialNo);
        dest.writeString(this.anomalyNoActionRequired);
        dest.writeString(this.updatedEpic);
    }

    public String getRelationType() {
        return this.relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getAnomalyNoActionRequired() {
        return this.anomalyNoActionRequired;
    }

    public void setAnomalyNoActionRequired(String anomalyNoActionRequired) {
        this.anomalyNoActionRequired = anomalyNoActionRequired;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getUpdatedEpic() {
        return this.updatedEpic;
    }

    public void setUpdatedEpic(String updatedEpic) {
        this.updatedEpic = updatedEpic;
    }
}
