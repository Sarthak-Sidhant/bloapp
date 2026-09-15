package in.gov.eci.bloapp.room.dao;

import in.gov.eci.bloapp.room.roommodel.GrevianceModel;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface GrevianceDao {
    Completable delete(GrevianceModel grevianceModel);

    Maybe<List<GrevianceModel>> getGreviance();

    Completable insert(GrevianceModel grevianceModel);

    Completable update(GrevianceModel grevianceModel);
}
