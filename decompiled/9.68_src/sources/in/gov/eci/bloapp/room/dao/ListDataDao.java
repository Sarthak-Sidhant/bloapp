package in.gov.eci.bloapp.room.dao;

import in.gov.eci.bloapp.entity.ListData;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface ListDataDao {
    void clearTable();

    int getCount();

    Long getLastUpdatedTime();

    List<ListData> getList(String list);

    void insertAll(List<ListData> listData);

    void setLastUpdatedTime(Long lastUpdated);
}
