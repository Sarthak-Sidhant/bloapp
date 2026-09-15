package in.gov.eci.bloapp.repository;

import android.content.Context;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.model.SIR.SpecialSurveyRevisionModel;
import in.gov.eci.bloapp.room.dao.SpecialRevisionDao;
import in.gov.eci.bloapp.room.database.SIRDatabaseHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class SpecialRevisionRepository {
    private final Context ctx;
    private final SpecialRevisionDao dao;
    private final SIRDatabaseHelper databaseHelper;
    private final UserClient userClient;

    public SpecialRevisionRepository(Context ctx) {
        this.userClient = (UserClient) ApiClient.getClient1(ctx).create(UserClient.class);
        SIRDatabaseHelper db = SIRDatabaseHelper.getDB(ctx);
        this.databaseHelper = db;
        this.dao = db.SpecialRevisionDao();
        this.ctx = ctx;
    }

    public List<SpecialSurveyRevisionModel> filterPendingList(List<SpecialSurveyRevisionModel> list) {
        List<String> formsFromDB = this.dao.getFormsFromDB();
        ArrayList arrayList = new ArrayList();
        for (SpecialSurveyRevisionModel specialSurveyRevisionModel : list) {
            if (!formsFromDB.contains(specialSurveyRevisionModel.getEpic_no())) {
                arrayList.add(specialSurveyRevisionModel);
            }
        }
        return arrayList;
    }
}
