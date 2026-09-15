package in.gov.eci.bloapp.views.activity.newsir.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
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
    public Long epicId;
    public int epicMatch;
    public String epicNo;
    public String name;
    public int partSerialNo;

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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.partSerialNo);
        dest.writeString(this.name);
        dest.writeLong(this.epicId.longValue());
        dest.writeString(this.epicNo);
        dest.writeInt(this.epicMatch);
    }
}
