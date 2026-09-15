package in.gov.eci.bloapp.views.activity.newsir.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class PseVerifyPayload implements Parcelable {
    public static final Parcelable.Creator<PseVerifyPayload> CREATOR = new Parcelable.Creator<PseVerifyPayload>() { // from class: in.gov.eci.bloapp.views.activity.newsir.model.PseVerifyPayload.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PseVerifyPayload createFromParcel(Parcel in2) {
            return new PseVerifyPayload(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PseVerifyPayload[] newArray(int size) {
            return new PseVerifyPayload[size];
        }
    };
    public String epicName;
    public String epicNo;
    public int partSerialNo;
    public int pseClusterId;
    public Long pseId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PseVerifyPayload() {
    }

    protected PseVerifyPayload(Parcel in2) {
        this.partSerialNo = in2.readInt();
        this.epicName = in2.readString();
        this.epicNo = in2.readString();
        this.pseId = Long.valueOf(in2.readLong());
        this.pseClusterId = in2.readInt();
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

    public String getEpicNo() {
        return this.epicNo;
    }

    public void setEpicNo(String epicNo) {
        this.epicNo = epicNo;
    }

    public int getPseClusterId() {
        return this.pseClusterId;
    }

    public void setPseClusterId(int pseClusterId) {
        this.pseClusterId = pseClusterId;
    }

    public Long getPseId() {
        return this.pseId;
    }

    public void setPseId(Long pseId) {
        this.pseId = pseId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.partSerialNo);
        dest.writeString(this.epicName);
        dest.writeString(this.epicNo);
        dest.writeInt(this.pseClusterId);
        dest.writeLong(this.pseId.longValue());
    }
}
