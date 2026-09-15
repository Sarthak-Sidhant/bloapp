package in.gov.eci.bloapp.views.activity.newsir.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class BloBlaMomPayload implements Parcelable {
    public static final Parcelable.Creator<BloBlaMomPayload> CREATOR = new Parcelable.Creator<BloBlaMomPayload>() { // from class: in.gov.eci.bloapp.views.activity.newsir.model.BloBlaMomPayload.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BloBlaMomPayload createFromParcel(Parcel in2) {
            return new BloBlaMomPayload(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BloBlaMomPayload[] newArray(int size) {
            return new BloBlaMomPayload[size];
        }
    };
    public int acNo;
    public int id;
    public String momDoc1;
    public String momDoc2;
    public String momDoc3;
    public String momDoc4;
    public int partNo;
    public String stateCd;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BloBlaMomPayload() {
    }

    protected BloBlaMomPayload(Parcel in2) {
        this.id = in2.readInt();
        this.stateCd = in2.readString();
        this.acNo = in2.readInt();
        this.partNo = in2.readInt();
        this.momDoc1 = in2.readString();
        this.momDoc2 = in2.readString();
        this.momDoc3 = in2.readString();
        this.momDoc4 = in2.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.stateCd);
        dest.writeInt(this.acNo);
        dest.writeInt(this.partNo);
        dest.writeString(this.momDoc1);
        dest.writeString(this.momDoc2);
        dest.writeString(this.momDoc3);
        dest.writeString(this.momDoc4);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStateCd() {
        return this.stateCd;
    }

    public void setStateCd(String stateCd) {
        this.stateCd = stateCd;
    }

    public int getAcNo() {
        return this.acNo;
    }

    public void setAcNo(int acNo) {
        this.acNo = acNo;
    }

    public int getPartNo() {
        return this.partNo;
    }

    public void setPartNo(int partNo) {
        this.partNo = partNo;
    }

    public String getMomDoc1() {
        return this.momDoc1;
    }

    public void setMomDoc1(String momDoc1) {
        this.momDoc1 = momDoc1;
    }

    public String getMomDoc2() {
        return this.momDoc2;
    }

    public void setMomDoc2(String momDoc2) {
        this.momDoc2 = momDoc2;
    }

    public String getMomDoc3() {
        return this.momDoc3;
    }

    public void setMomDoc3(String momDoc3) {
        this.momDoc3 = momDoc3;
    }

    public String getMomDoc4() {
        return this.momDoc4;
    }

    public void setMomDoc4(String momDoc4) {
        this.momDoc4 = momDoc4;
    }
}
