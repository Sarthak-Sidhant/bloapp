package in.gov.eci.bloapp.views.activity.newsir.model;

import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class BloMapping {
    public int progenyMappingCount;
    public List<SelfMappingList> progenyMappingList;
    public int selfMappingCount;
    public List<SelfMappingList> selfMappingList;

    public int getSelfMappingCount() {
        return this.selfMappingCount;
    }

    public void setSelfMappingCount(int selfMappingCount) {
        this.selfMappingCount = selfMappingCount;
    }

    public int getProgenyMappingCount() {
        return this.progenyMappingCount;
    }

    public void setProgenyMappingCount(int progenyMappingCount) {
        this.progenyMappingCount = progenyMappingCount;
    }

    public List<SelfMappingList> getSelfMappingList() {
        return this.selfMappingList;
    }

    public void setSelfMappingList(List<SelfMappingList> selfMappingList) {
        this.selfMappingList = selfMappingList;
    }

    public List<SelfMappingList> getProgenyMappingList() {
        return this.progenyMappingList;
    }

    public void setProgenyMappingList(List<SelfMappingList> progenyMappingList) {
        this.progenyMappingList = progenyMappingList;
    }
}
