package in.gov.eci.bloapp.views.activity.newsir.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class PSEPayload implements Parcelable {
    public static final Parcelable.Creator<PSEPayload> CREATOR = new Parcelable.Creator<PSEPayload>() { // from class: in.gov.eci.bloapp.views.activity.newsir.model.PSEPayload.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PSEPayload createFromParcel(Parcel in2) {
            return new PSEPayload(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PSEPayload[] newArray(int size) {
            return new PSEPayload[size];
        }
    };
    public String dseClusterId;
    public String dseElector;
    public String dseType;
    public Long epicId;
    public String epicName;
    public String epicNo;
    public int partSerialNo;
    public String pseElector;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PSEPayload() {
    }

    protected PSEPayload(Parcel in2) {
        this.partSerialNo = in2.readInt();
        this.epicName = in2.readString();
        this.epicId = Long.valueOf(in2.readLong());
        this.epicNo = in2.readString();
        this.pseElector = in2.readString();
        this.dseElector = in2.readString();
        this.dseClusterId = in2.readString();
        this.dseType = in2.readString();
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
        dest.writeString(this.pseElector);
        dest.writeString(this.dseElector);
        dest.writeString(this.dseClusterId);
        dest.writeString(this.dseType);
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

    public String getDseType() {
        return this.dseType;
    }

    public void setDseType(String dseType) {
        this.dseType = dseType;
    }
}
