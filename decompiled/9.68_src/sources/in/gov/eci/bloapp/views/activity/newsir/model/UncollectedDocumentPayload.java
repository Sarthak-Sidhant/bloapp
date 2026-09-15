package in.gov.eci.bloapp.views.activity.newsir.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class UncollectedDocumentPayload implements Parcelable {
    public static final Parcelable.Creator<UncollectedDocumentPayload> CREATOR = new Parcelable.Creator<UncollectedDocumentPayload>() { // from class: in.gov.eci.bloapp.views.activity.newsir.model.UncollectedDocumentPayload.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UncollectedDocumentPayload createFromParcel(Parcel in2) {
            return new UncollectedDocumentPayload(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UncollectedDocumentPayload[] newArray(int size) {
            return new UncollectedDocumentPayload[size];
        }
    };
    public String enrolledEpicNo;
    public Long epicId;
    public String epicNo;
    public String name;
    public int partSerialNo;
    public String uncollectReason;
    public String uncollectRemarks;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UncollectedDocumentPayload() {
    }

    protected UncollectedDocumentPayload(Parcel in2) {
        this.partSerialNo = in2.readInt();
        this.name = in2.readString();
        this.epicId = Long.valueOf(in2.readLong());
        this.epicNo = in2.readString();
        this.enrolledEpicNo = in2.readString();
        this.uncollectReason = in2.readString();
        this.uncollectRemarks = in2.readString();
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

    public String getEpicNo() {
        return this.epicNo;
    }

    public void setEpicNo(String epicNo) {
        this.epicNo = epicNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnrolledEpicNo() {
        return this.enrolledEpicNo;
    }

    public void setEnrolledEpicNo(String enrolledEpicNo) {
        this.enrolledEpicNo = enrolledEpicNo;
    }

    public String getUncollectReason() {
        return this.uncollectReason;
    }

    public void setUncollectReason(String uncollectReason) {
        this.uncollectReason = uncollectReason;
    }

    public String getUncollectRemarks() {
        return this.uncollectRemarks;
    }

    public void setUncollectRemarks(String uncollectRemarks) {
        this.uncollectRemarks = uncollectRemarks;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.partSerialNo);
        dest.writeString(this.name);
        dest.writeLong(this.epicId.longValue());
        dest.writeString(this.epicNo);
        dest.writeString(this.enrolledEpicNo);
        dest.writeString(this.uncollectReason);
        dest.writeString(this.uncollectRemarks);
    }
}
