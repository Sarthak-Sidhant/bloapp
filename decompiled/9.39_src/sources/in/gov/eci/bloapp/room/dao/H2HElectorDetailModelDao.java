package in.gov.eci.bloapp.room.dao;

import in.gov.eci.bloapp.model.ElectroleDeatils.H2HElectorDetailModel;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface H2HElectorDetailModelDao {
    void addH2HElecorDetails(H2HElectorDetailModel h2HElectorDetailModel);

    void deleteH2HElecorDetails(H2HElectorDetailModel h2HElectorDetailModel);

    void deleteH2HRecord(String epicID);

    List<H2HElectorDetailModel> getH2HAllElectorDetails(String partNumber);

    void updateH2HElecorDetails(H2HElectorDetailModel h2HElectorDetailModel);
}
