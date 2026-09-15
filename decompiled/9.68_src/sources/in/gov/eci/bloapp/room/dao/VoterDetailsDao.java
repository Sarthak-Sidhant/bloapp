package in.gov.eci.bloapp.room.dao;

import in.gov.eci.bloapp.room.roommodel.BoothModel;
import in.gov.eci.bloapp.room.roommodel.VoterDetailsModel;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface VoterDetailsDao {
    Completable delete(VoterDetailsModel voterDetails);

    Maybe<List<BoothModel>> getVoterDetails();

    Completable insert(VoterDetailsModel voterDetails);

    Completable update(VoterDetailsModel voterDetails);
}
