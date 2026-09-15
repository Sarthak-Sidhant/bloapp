package in.gov.eci.bloapp.room.dao;

import androidx.lifecycle.LiveData;
import in.gov.eci.bloapp.model.SIR.SpecialSurveyRevisionModel;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface SpecialRevisionDao {
    void UpdateErrorMessage(Long epicID, String errorMessage, int statuscode);

    void addSpecialSurveyRevisionDetails(SpecialSurveyRevisionModel specialSurveyRevisionModel);

    void deleteSpecialSurveyRevisionDetails(SpecialSurveyRevisionModel specialSurveyRevisionModel);

    void deleteSpecialSurveyRevisionDetails(Long epicID);

    LiveData<List<SpecialSurveyRevisionModel>> getAllForms();

    int getAllFormsFromDB();

    List<String> getFormsFromDB();

    int getPendingCountFromDB();

    List<SpecialSurveyRevisionModel> getSpecialSurveyRevisionDetails(String partNumber);

    boolean isFormExist(Long epicID);

    void updateSpecialSurveyRevisionDetails(SpecialSurveyRevisionModel specialSurveyRevisionModel);
}
