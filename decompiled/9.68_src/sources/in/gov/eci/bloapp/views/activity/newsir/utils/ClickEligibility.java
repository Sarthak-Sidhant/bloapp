package in.gov.eci.bloapp.views.activity.newsir.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ClickEligibility {
    private static final Map<String, Integer> STATE_CUTOFF_AGE;

    static {
        HashMap map = new HashMap();
        map.put("S12", 37);
        map.put("U01", 38);
        map.put("S26", 37);
        map.put("S06", 38);
        map.put("S22", 35);
        map.put("S20", 38);
        map.put("U07", 38);
        map.put("U06", 38);
        map.put("S11", 38);
        map.put("S05", 38);
        map.put("S24", 37);
        map.put("S25", 38);
        STATE_CUTOFF_AGE = Collections.unmodifiableMap(map);
    }

    public static boolean canClick(String state, int userAge) {
        if (state == null || ClickEligibility$$ExternalSyntheticBackport0.m(state)) {
            throw new IllegalArgumentException("State must be provided.");
        }
        if (userAge < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        normalizeState(state);
        Integer num = STATE_CUTOFF_AGE.get(state);
        if (num != null) {
            return userAge <= num.intValue();
        }
        throw new IllegalArgumentException("Unknown state: " + state);
    }

    private static String normalizeState(String state) {
        return state.trim().replaceAll("\\s+", StringUtils.SPACE);
    }
}
