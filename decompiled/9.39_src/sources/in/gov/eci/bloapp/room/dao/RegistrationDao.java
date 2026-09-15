package in.gov.eci.bloapp.room.dao;

import in.gov.eci.bloapp.room.roommodel.RegistrationModel;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface RegistrationDao {
    Completable delete(RegistrationModel registration);

    Maybe<List<RegistrationModel>> getRegDetails();

    Completable insert(RegistrationModel registration);

    Completable update(RegistrationModel registration);
}
