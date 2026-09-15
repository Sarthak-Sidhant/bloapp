package in.gov.eci.bloapp.entity;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ListData {

    @SerializedName("docCode")
    public String docCode;

    @SerializedName("docName")
    public String docName;
    private long lastUpdated;

    @SerializedName("lists")
    public String lists;

    public long getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getDocCode() {
        return this.docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }

    public String getDocName() {
        return this.docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getLists() {
        return this.lists;
    }

    public void setLists(String lists) {
        this.lists = lists;
    }
}
