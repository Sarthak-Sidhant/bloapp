package in.gov.eci.bloapp.views.activity.newsir.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class EpicDeliveryRoot implements Parcelable {
    public static final Parcelable.Creator<EpicDeliveryRoot> CREATOR = new Parcelable.Creator<EpicDeliveryRoot>() { // from class: in.gov.eci.bloapp.views.activity.newsir.model.EpicDeliveryRoot.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EpicDeliveryRoot createFromParcel(Parcel in2) {
            return new EpicDeliveryRoot(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EpicDeliveryRoot[] newArray(int size) {
            return new EpicDeliveryRoot[size];
        }
    };
    public String message;
    public boolean next;
    public EpicDeliveryPayload payload;
    public String refId;
    public String status;
    public int statusCode;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public EpicDeliveryRoot(String status, int statusCode, String refId, String message, EpicDeliveryPayload payload) {
        this.status = status;
        this.statusCode = statusCode;
        this.refId = refId;
        this.message = message;
        this.payload = payload;
    }

    public boolean isNext() {
        return this.next;
    }

    public void setNext(boolean next) {
        this.next = next;
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

    public EpicDeliveryPayload getPayload() {
        return this.payload;
    }

    public void setPayload(EpicDeliveryPayload payload) {
        this.payload = payload;
    }

    protected EpicDeliveryRoot(Parcel in2) {
        this.status = in2.readString();
        this.statusCode = in2.readInt();
        this.refId = in2.readString();
        this.message = in2.readString();
        this.payload = (EpicDeliveryPayload) in2.readParcelable(EpicDeliveryPayload.class.getClassLoader());
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
