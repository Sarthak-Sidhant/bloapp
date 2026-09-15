package in.gov.eci.bloapp.views.activity.newsir.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class VoterDataPayload implements Parcelable {
    public static final Parcelable.Creator<VoterDataPayload> CREATOR = new Parcelable.Creator<VoterDataPayload>() { // from class: in.gov.eci.bloapp.views.activity.newsir.model.VoterDataPayload.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VoterDataPayload createFromParcel(Parcel in2) {
            return new VoterDataPayload(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VoterDataPayload[] newArray(int size) {
            return new VoterDataPayload[size];
        }
    };
    public String acNo;
    public String applicantName;
    public String dispatchDate;
    public String epicNumber;
    public int partNumber;
    public int partSerialNumber;
    public String referenceNumber;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPartSerialNo() {
        return this.partSerialNumber;
    }

    public void setPartSerialNo(int partSerialNo) {
        this.partSerialNumber = partSerialNo;
    }

    public String getApplicantName() {
        return this.applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    public String getReferenceNumber() {
        return this.referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getAcNo() {
        return this.acNo;
    }

    public void setAcNo(String acNo) {
        this.acNo = acNo;
    }

    public String getEpicNumber() {
        return this.epicNumber;
    }

    public void setEpicNumber(String epicNumber) {
        this.epicNumber = epicNumber;
    }

    public String getDispatchDate() {
        return this.dispatchDate;
    }

    public void setDispatchDate(String dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.partSerialNumber);
        dest.writeInt(this.partNumber);
        dest.writeString(this.applicantName);
        dest.writeString(this.epicNumber);
        dest.writeString(this.acNo);
        dest.writeString(this.referenceNumber);
        dest.writeString(this.dispatchDate);
    }

    protected VoterDataPayload(Parcel in2) {
        this.partSerialNumber = in2.readInt();
        this.partNumber = in2.readInt();
        this.epicNumber = in2.readString();
        this.acNo = in2.readString();
        this.dispatchDate = in2.readString();
        this.referenceNumber = in2.readString();
        this.applicantName = in2.readString();
    }
}
