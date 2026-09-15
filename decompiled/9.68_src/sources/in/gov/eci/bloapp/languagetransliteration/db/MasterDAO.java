package in.gov.eci.bloapp.languagetransliteration.db;

import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface MasterDAO {
    void deleteAcs();

    void deleteDists();

    void deleteStates();

    TAc getAc(String state_code, String ac_code);

    List<TAc> getAcs(String state_code);

    List<TDistrict> getDistricts(String state_code);

    List<TState> getStates();

    void insertAcs(TAc... acs);

    void insertDistricts(TDistrict... districts);

    void insertStates(TState... states);
}
