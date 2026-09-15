package in.gov.eci.bloapp.room.dao;

import in.gov.eci.bloapp.model.ElectroleDeatils.HouseSurveyModel;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface HouseSurveyModelDao {
    void addHouseSurveyDetails(HouseSurveyModel.Payload houseSurveyModel);

    void deleteHouseSurveyDetails(String partNo, String bloId);

    List<HouseSurveyModel.Payload> getAllHouseSurveyDetails(String partNo, String bloId);

    List<HouseSurveyModel.Payload> getLastModifiedDate(String partNo, String bloId);

    void updateHouseSurveyDetails(HouseSurveyModel.Payload houseSurveyModel);
}
