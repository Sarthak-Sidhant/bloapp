package in.gov.eci.bloapp.views.activity.newsir.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class EpicDeliveryPayload implements Parcelable {
    public static final Parcelable.Creator<EpicDeliveryPayload> CREATOR = new Parcelable.Creator<EpicDeliveryPayload>() { // from class: in.gov.eci.bloapp.views.activity.newsir.model.EpicDeliveryPayload.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EpicDeliveryPayload createFromParcel(Parcel in2) {
            return new EpicDeliveryPayload(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EpicDeliveryPayload[] newArray(int size) {
            return new EpicDeliveryPayload[size];
        }
    };
    public List<VoterDataPayload> voterData;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public EpicDeliveryPayload(List<VoterDataPayload> voterData) {
        this.voterData = voterData;
    }

    protected EpicDeliveryPayload(Parcel in2) {
        this.voterData = in2.createTypedArrayList(VoterDataPayload.CREATOR);
    }

    public List<VoterDataPayload> getVoterData() {
        return this.voterData;
    }

    public void setVoterData(List<VoterDataPayload> voterData) {
        this.voterData = voterData;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.voterData);
    }
}
