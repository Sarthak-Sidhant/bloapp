package in.gov.eci.bloapp.views.activity.newsir.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class EFPayload implements Parcelable {
    public static final Parcelable.Creator<EFPayload> CREATOR = new Parcelable.Creator<EFPayload>() { // from class: in.gov.eci.bloapp.views.activity.newsir.model.EFPayload.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EFPayload createFromParcel(Parcel in2) {
            return new EFPayload(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EFPayload[] newArray(int size) {
            return new EFPayload[size];
        }
    };
    public String backToBloRemarks;
    public int currentAge;
    public Long epicId;
    public int epicMatch;
    public String epicNo;
    public String flag;
    public String name;
    public int partSerialNo;
    public String relationType;
    public String relativeFullName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public EFPayload() {
    }

    protected EFPayload(Parcel in2) {
        this.partSerialNo = in2.readInt();
        this.name = in2.readString();
        this.epicId = Long.valueOf(in2.readLong());
        this.epicNo = in2.readString();
        this.epicMatch = in2.readInt();
        this.relativeFullName = in2.readString();
        this.flag = in2.readString();
        this.relationType = in2.readString();
        this.currentAge = in2.readInt();
        this.backToBloRemarks = in2.readString();
    }

    public int getPartSerialNo() {
        return this.partSerialNo;
    }

    public void setPartSerialNo(int partSerialNo) {
        this.partSerialNo = partSerialNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getEpicMatch() {
        return this.epicMatch;
    }

    public void setEpicMatch(int epicMatch) {
        this.epicMatch = epicMatch;
    }

    public String getRelativeFullName() {
        return this.relativeFullName;
    }

    public void setRelativeFullName(String relativeFullName) {
        this.relativeFullName = relativeFullName;
    }

    public String getFlag() {
        return this.flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRelationType() {
        return this.relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public int getCurrentAge() {
        return this.currentAge;
    }

    public void setCurrentAge(int currentAge) {
        this.currentAge = currentAge;
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
        dest.writeString(this.name);
        dest.writeLong(this.epicId.longValue());
        dest.writeString(this.epicNo);
        dest.writeInt(this.epicMatch);
        dest.writeString(this.relativeFullName);
        dest.writeString(this.flag);
        dest.writeString(this.relationType);
        dest.writeInt(this.currentAge);
        dest.writeString(this.backToBloRemarks);
    }
}
