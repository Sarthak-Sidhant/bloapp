package in.gov.eci.bloapp.views.activity.newsir.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class AnomalyListPayload implements Parcelable {
    public static final Parcelable.Creator<AnomalyListPayload> CREATOR = new Parcelable.Creator<AnomalyListPayload>() { // from class: in.gov.eci.bloapp.views.activity.newsir.model.AnomalyListPayload.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AnomalyListPayload createFromParcel(Parcel in2) {
            return new AnomalyListPayload(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AnomalyListPayload[] newArray(int size) {
            return new AnomalyListPayload[size];
        }
    };
    public Long epicId;
    public String epicName;
    public String epicNo;
    public int partSerialNo;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AnomalyListPayload() {
    }

    protected AnomalyListPayload(Parcel in2) {
        this.partSerialNo = in2.readInt();
        this.epicName = in2.readString();
        this.epicId = Long.valueOf(in2.readLong());
        this.epicNo = in2.readString();
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
        dest.writeInt(this.partSerialNo);
        dest.writeString(this.epicName);
        dest.writeLong(this.epicId.longValue());
        dest.writeString(this.epicNo);
    }
}
