package in.gov.eci.bloapp.room.dao;

import in.gov.eci.bloapp.room.roommodel.BoothModel;
import io.reactivex.Completable;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface BoothDao {
    Completable delete(BoothModel boothModel);

    Completable insert(BoothModel boothModel);

    Completable update(BoothModel boothModel);
}
