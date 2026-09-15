package in.gov.eci.bloapp.model.SIR;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class unCollectableModel1 {

    @SerializedName("acNo")
    private int acNo;

    @SerializedName("partNo")
    private int partNo;

    @SerializedName("stateCd")
    private String stateCd;

    @SerializedName("status")
    private ArrayList<unCollectableStatus1> unCollectableStatusArrayList;

    public unCollectableModel1(String stateCd, int acNo, int partNo, ArrayList<unCollectableStatus1> unCollectableStatusArrayList) {
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

    public ArrayList<unCollectableStatus1> getUnCollectableStatusArrayList() {
        return this.unCollectableStatusArrayList;
    }

    public void setUnCollectableStatusArrayList(ArrayList<unCollectableStatus1> unCollectableStatusArrayList) {
        this.unCollectableStatusArrayList = unCollectableStatusArrayList;
    }
}
