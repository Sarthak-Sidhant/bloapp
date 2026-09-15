package in.gov.eci.bloapp.views.activity.newsir.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class BloBlaMoMRoot implements Parcelable {
    public static final Parcelable.Creator<BloBlaMoMRoot> CREATOR = new Parcelable.Creator<BloBlaMoMRoot>() { // from class: in.gov.eci.bloapp.views.activity.newsir.model.BloBlaMoMRoot.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BloBlaMoMRoot createFromParcel(Parcel in2) {
            return new BloBlaMoMRoot(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BloBlaMoMRoot[] newArray(int size) {
            return new BloBlaMoMRoot[size];
        }
    };
    public String message;
    public BloBlaMomPayload payload;
    public String refId;
    public String status;
    public int statusCode;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BloBlaMoMRoot(String status, int statusCode, String refId, String message, BloBlaMomPayload payload) {
        this.status = status;
        this.statusCode = statusCode;
        this.refId = refId;
        this.message = message;
        this.payload = payload;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getRefId() {
        return this.refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BloBlaMomPayload getPayload() {
        return this.payload;
    }

    public void setPayload(BloBlaMomPayload payload) {
        this.payload = payload;
    }

    protected BloBlaMoMRoot(Parcel in2) {
        this.status = in2.readString();
        this.statusCode = in2.readInt();
        this.refId = in2.readString();
        this.message = in2.readString();
        this.payload = (BloBlaMomPayload) in2.readParcelable(BloBlaMomPayload.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.status);
        dest.writeInt(this.statusCode);
        dest.writeString(this.refId);
        dest.writeString(this.message);
        dest.writeParcelable(this.payload, flags);
    }
}
