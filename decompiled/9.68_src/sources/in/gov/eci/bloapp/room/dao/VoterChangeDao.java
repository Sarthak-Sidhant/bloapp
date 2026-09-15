package in.gov.eci.bloapp.room.dao;

import in.gov.eci.bloapp.room.roommodel.VoterChangeModel;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface VoterChangeDao {
    Completable delete(VoterChangeModel voterChange);

    Maybe<List<VoterChangeModel>> getVoterChangeRequest();

    Completable insert(VoterChangeModel voterChange);

    Completable update(VoterChangeModel voterChange);
}
