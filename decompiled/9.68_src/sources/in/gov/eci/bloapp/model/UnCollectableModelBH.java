package in.gov.eci.bloapp.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class UnCollectableModelBH {

    @SerializedName("acNo")
    private int acNo;

    @SerializedName("partNo")
    private int partNo;

    @SerializedName("stateCd")
    private String stateCd;

    @SerializedName("status")
    private ArrayList<UnCollectableStatusBH> unCollectableStatusArrayList;

    public UnCollectableModelBH(String stateCd, int acNo, int partNo, ArrayList<UnCollectableStatusBH> unCollectableStatusArrayList) {
        this.stateCd = stateCd;
        this.acNo = acNo;
        this.partNo = partNo;
        this.unCollectableStatusArrayList = unCollectableStatusArrayList;
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

    public ArrayList<UnCollectableStatusBH> getUnCollectableStatusArrayList() {
        return this.unCollectableStatusArrayList;
    }

    public void setUnCollectableStatusArrayList(ArrayList<UnCollectableStatusBH> unCollectableStatusArrayList) {
        this.unCollectableStatusArrayList = unCollectableStatusArrayList;
    }
}
