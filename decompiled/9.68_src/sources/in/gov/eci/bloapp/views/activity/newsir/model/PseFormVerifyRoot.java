package in.gov.eci.bloapp.views.activity.newsir.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class PseFormVerifyRoot implements Parcelable {
    public static final Parcelable.Creator<PseFormVerifyRoot> CREATOR = new Parcelable.Creator<PseFormVerifyRoot>() { // from class: in.gov.eci.bloapp.views.activity.newsir.model.PseFormVerifyRoot.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PseFormVerifyRoot createFromParcel(Parcel in2) {
            return new PseFormVerifyRoot(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PseFormVerifyRoot[] newArray(int size) {
            return new PseFormVerifyRoot[size];
        }
    };
    public String message;
    public List<PseVerifyPayload> payload;
    public String refId;
    public String status;
    public int statusCode;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PseFormVerifyRoot(String status, int statusCode, String refId, String message, List<PseVerifyPayload> payload) {
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

    public List<PseVerifyPayload> getPayload() {
        return this.payload;
    }

    public void setPayload(List<PseVerifyPayload> payload) {
        this.payload = payload;
    }

    protected PseFormVerifyRoot(Parcel in2) {
        this.status = in2.readString();
        this.statusCode = in2.readInt();
        this.refId = in2.readString();
        this.message = in2.readString();
        this.payload = in2.createTypedArrayList(PseVerifyPayload.CREATOR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.status);
        dest.writeInt(this.statusCode);
        dest.writeString(this.refId);
        dest.writeString(this.message);
        dest.writeTypedList(this.payload);
    }
}
