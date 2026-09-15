package in.gov.eci.bloapp.views.activity.newsir.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class UncollectableDetailsPayload implements Parcelable {
    public static final Parcelable.Creator<UncollectableDetailsPayload> CREATOR = new Parcelable.Creator<UncollectableDetailsPayload>() { // from class: in.gov.eci.bloapp.views.activity.newsir.model.UncollectableDetailsPayload.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UncollectableDetailsPayload createFromParcel(Parcel in2) {
            return new UncollectableDetailsPayload(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UncollectableDetailsPayload[] newArray(int size) {
            return new UncollectableDetailsPayload[size];
        }
    };
    public int acNo;
    public String backToBlo;
    public String backToBloRemarks;
    public String efBackUrl;
    public String efFrontUrl;
    public String electorName;
    public String enrolledEpicNo;
    public Long epicId;
    public String epicNo;
    public int partNo;
    public int partSerialNo;
    public String suppDoc1Url;
    public String suppDoc2Url;
    public String uncollectableReason;
    public String uncollectableRemarks;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UncollectableDetailsPayload() {
    }

    protected UncollectableDetailsPayload(Parcel in2) {
        this.partNo = in2.readInt();
        this.partSerialNo = in2.readInt();
        this.electorName = in2.readString();
        this.backToBlo = in2.readString();
        this.backToBloRemarks = in2.readString();
        this.efFrontUrl = in2.readString();
        this.efBackUrl = in2.readString();
        this.suppDoc1Url = in2.readString();
        this.suppDoc2Url = in2.readString();
        this.uncollectableReason = in2.readString();
        this.partNo = in2.readInt();
        this.acNo = in2.readInt();
        this.epicId = Long.valueOf(in2.readLong());
        this.epicNo = in2.readString();
        this.uncollectableRemarks = in2.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.partNo);
        dest.writeInt(this.acNo);
        dest.writeLong(this.epicId.longValue());
        dest.writeString(this.epicNo);
        dest.writeInt(this.partSerialNo);
        dest.writeString(this.electorName);
        dest.writeString(this.backToBlo);
        dest.writeString(this.backToBloRemarks);
        dest.writeString(this.efFrontUrl);
        dest.writeString(this.efBackUrl);
        dest.writeString(this.suppDoc1Url);
        dest.writeString(this.suppDoc2Url);
        dest.writeString(this.uncollectableReason);
        dest.writeString(this.uncollectableRemarks);
    }

    public int getPartNo() {
        return this.partNo;
    }

    public void setPartNo(int partNo) {
        this.partNo = partNo;
    }

    public int getAcNo() {
        return this.acNo;
    }

    public void setAcNo(int acNo) {
        this.acNo = acNo;
    }

    public int getPartSerialNo() {
        return this.partSerialNo;
    }

    public void setPartSerialNo(int partSerialNo) {
        this.partSerialNo = partSerialNo;
    }

    public String getElectorName() {
        return this.electorName;
    }

    public void setElectorName(String electorName) {
        this.electorName = electorName;
    }

    public String getBackToBlo() {
        return this.backToBlo;
    }

    public void setBackToBlo(String backToBlo) {
        this.backToBlo = backToBlo;
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

    public String getEfFrontUrl() {
        return this.efFrontUrl;
    }

    public void setEfFrontUrl(String efFrontUrl) {
        this.efFrontUrl = efFrontUrl;
    }

    public String getEfBackUrl() {
        return this.efBackUrl;
    }

    public void setEfBackUrl(String efBackUrl) {
        this.efBackUrl = efBackUrl;
    }

    public String getEnrolledEpicNo() {
        return this.enrolledEpicNo;
    }

    public void setEnrolledEpicNo(String enrolledEpicNo) {
        this.enrolledEpicNo = enrolledEpicNo;
    }

    public String getSuppDoc1Url() {
        return this.suppDoc1Url;
    }

    public void setSuppDoc1Url(String suppDoc1Url) {
        this.suppDoc1Url = suppDoc1Url;
    }

    public String getSuppDoc2Url() {
        return this.suppDoc2Url;
    }

    public void setSuppDoc2Url(String suppDoc2Url) {
        this.suppDoc2Url = suppDoc2Url;
    }

    public String getUncollectableReason() {
        return this.uncollectableReason;
    }

    public void setUncollectableReason(String uncollectableReason) {
        this.uncollectableReason = uncollectableReason;
    }

    public String getUncollectableRemarks() {
        return this.uncollectableRemarks;
    }

    public void setUncollectableRemarks(String uncollectableRemarks) {
        this.uncollectableRemarks = uncollectableRemarks;
    }
}
