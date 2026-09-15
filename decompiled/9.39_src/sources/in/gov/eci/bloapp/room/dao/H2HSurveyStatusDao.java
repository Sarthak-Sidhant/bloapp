package in.gov.eci.bloapp.room.dao;

import in.gov.eci.bloapp.model.ElectroleDeatils.H2HSurveyStatusModel;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface H2HSurveyStatusDao {
    void addH2HSurveyDetails(H2HSurveyStatusModel.Payload h2HSurveyStatusModel);

    void deleteH2HSurveyDetails(String partNo, String bloId);

    List<H2HSurveyStatusModel.Payload> getH2HSurveyDetails(int partNo, String bloId);

    List<H2HSurveyStatusModel.Payload> getH2HSurveyDetailsAsPerDate(int partNo, String bloId, String fromDate, String toDate);

    List<H2HSurveyStatusModel.Payload> getH2HSurveyDetailsAsPerSerialNo(int partNo, String bloId, String serialNo);

    List<H2HSurveyStatusModel.Payload> getLastModifiedDate(int partNo, String bloId);
}
