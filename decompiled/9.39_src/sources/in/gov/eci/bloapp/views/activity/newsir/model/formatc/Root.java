package in.gov.eci.bloapp.views.activity.newsir.model.formatc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class Root implements Parcelable {
    public static final Parcelable.Creator<Root> CREATOR = new Parcelable.Creator<Root>() { // from class: in.gov.eci.bloapp.views.activity.newsir.model.formatc.Root.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Root createFromParcel(Parcel in2) {
            return new Root(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Root[] newArray(int size) {
            return new Root[size];
        }
    };
    public List<Content> content;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Root(List<Content> content) {
        this.content = content;
    }

    public List<Content> getContent() {
        return this.content;
    }

    public void setContent(ArrayList<Content> content) {
        this.content = content;
    }

    protected Root(Parcel in2) {
        this.content = in2.createTypedArrayList(Content.CREATOR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.content);
    }
}
