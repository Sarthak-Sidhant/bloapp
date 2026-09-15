package in.gov.eci.bloapp.views.activity.newsir.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FormVerificationRoot implements Parcelable {
    public static final Parcelable.Creator<FormVerificationRoot> CREATOR = new Parcelable.Creator<FormVerificationRoot>() { // from class: in.gov.eci.bloapp.views.activity.newsir.model.FormVerificationRoot.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FormVerificationRoot createFromParcel(Parcel in2) {
            return new FormVerificationRoot(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FormVerificationRoot[] newArray(int size) {
            return new FormVerificationRoot[size];
        }
    };
    public String message;
    public List<FormverificationPayload> payload;
    public String refId;
    public String status;
    public int statusCode;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public FormVerificationRoot(String status, int statusCode, String refId, String message, List<FormverificationPayload> payload) {
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

    public List<FormverificationPayload> getPayload() {
        return this.payload;
    }

    public void setPayload(List<FormverificationPayload> payload) {
        this.payload = payload;
    }

    protected FormVerificationRoot(Parcel in2) {
        this.status = in2.readString();
        this.statusCode = in2.readInt();
        this.refId = in2.readString();
        this.message = in2.readString();
        this.payload = in2.createTypedArrayList(FormverificationPayload.CREATOR);
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
