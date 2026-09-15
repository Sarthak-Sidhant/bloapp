package in.gov.eci.bloapp.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.similarity.JaroWinklerSimilarity;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class NameMatcher {
    private static final DoubleMetaphone dm = new DoubleMetaphone();
    private static final JaroWinklerSimilarity jw = new JaroWinklerSimilarity();

    public enum MatchType {
        EXACT,
        TOKEN_MATCH,
        PARTIAL_CLOSE,
        PARTIAL_WEAK,
        NO_MATCH
    }

    public static class MatchResult {
        public int score;
        public MatchType type;

        public MatchResult(int score, MatchType type) {
            this.score = score;
            this.type = type;
        }
    }

    public static String normalize(String name) {
        if (name == null) {
            return "";
        }
        return name.toLowerCase().trim().replace("0", "o").replace("1", "l").replace("5", "s").replace("rn", "m").replaceAll("[^a-z ]", "").replaceAll("\\s+", StringUtils.SPACE).trim();
    }

    public static List<String> getTokens(String name) {
        String strNormalize = normalize(name);
        return strNormalize.isEmpty() ? Collections.emptyList() : Arrays.asList(strNormalize.split(StringUtils.SPACE));
    }

    public static List<String> splitMergedToken(String merged, List<String> refTokens) {
        ArrayList arrayList = new ArrayList();
        for (String str : refTokens) {
            if (merged.contains(str)) {
                arrayList.add(str);
                merged = merged.replaceFirst(str, "");
            }
        }
        if (!merged.isEmpty()) {
            arrayList.add(merged);
        }
        return arrayList;
    }

    public static List<String> getTokensSmart(String name, String refName) {
        List<String> tokens = getTokens(name);
        if (tokens.size() != 1 || refName == null) {
            return tokens;
        }
        return splitMergedToken(tokens.get(0), getTokens(refName));
    }

    public static boolean isSameTokensDifferentOrder(String name1, String name2) {
        List<String> tokensSmart = getTokensSmart(name1, name2);
        List<String> tokensSmart2 = getTokensSmart(name2, name1);
        if (tokensSmart.size() != tokensSmart2.size()) {
            return false;
        }
        ArrayList arrayList = new ArrayList(tokensSmart);
        ArrayList arrayList2 = new ArrayList(tokensSmart2);
        Collections.sort(arrayList);
        Collections.sort(arrayList2);
        return arrayList.equals(arrayList2);
    }

    public static double tokenSimilarity(String name1, String name2) {
        List<String> tokensSmart = getTokensSmart(name1, name2);
        List<String> tokensSmart2 = getTokensSmart(name2, name1);
        if (tokensSmart.isEmpty() || tokensSmart2.isEmpty()) {
            return 0.0d;
        }
        double d = 0.0d;
        for (String str : tokensSmart) {
            double dMax = 0.0d;
            for (String str2 : tokensSmart2) {
                double dDoubleValue = jw.apply(str, str2).doubleValue();
                if (str.contains(str2) || str2.contains(str)) {
                    dDoubleValue = Math.max(dDoubleValue, 0.85d);
                }
                if (dDoubleValue >= 0.75d) {
                    dMax = Math.max(dMax, dDoubleValue);
                }
            }
            d += dMax;
        }
        return (d / ((double) tokensSmart.size())) * 100.0d;
    }

    public static double fullSimilarity(String n1, String n2) {
        double dDoubleValue = jw.apply(n1, n2).doubleValue();
        if (dDoubleValue < 0.7d) {
            return 0.0d;
        }
        return dDoubleValue * 100.0d;
    }

    public static boolean phoneticMatch(String n1, String n2) {
        DoubleMetaphone doubleMetaphone = dm;
        return doubleMetaphone.doubleMetaphone(n1).equals(doubleMetaphone.doubleMetaphone(n2));
    }

    public static MatchResult getMatchResult(String name1, String name2) {
        String strNormalize = normalize(name1);
        String strNormalize2 = normalize(name2);
        if (strNormalize.isEmpty() || strNormalize2.isEmpty()) {
            return new MatchResult(0, MatchType.NO_MATCH);
        }
        if (strNormalize.equals(strNormalize2)) {
            return new MatchResult(100, MatchType.EXACT);
        }
        double dFullSimilarity = fullSimilarity(strNormalize, strNormalize2);
        double d = tokenSimilarity(strNormalize, strNormalize2);
        boolean zPhoneticMatch = phoneticMatch(strNormalize, strNormalize2);
        if (isSameTokensDifferentOrder(strNormalize, strNormalize2)) {
            if (zPhoneticMatch) {
                d += 5.0d;
            }
            return new MatchResult((int) Math.min(95.0d, Math.max(80.0d, d)), MatchType.TOKEN_MATCH);
        }
        double d2 = (0.6d * dFullSimilarity) + (0.4d * d);
        if (dFullSimilarity == 0.0d && d == 0.0d) {
            d2 = 0.0d;
        }
        if (d < 70.0d) {
            d2 *= 0.5d;
        }
        if (zPhoneticMatch) {
            d2 += 5.0d;
        }
        int iMin = (int) Math.min(100.0d, d2);
        if (dFullSimilarity >= 85.0d) {
            return new MatchResult(Math.min(iMin, 92), MatchType.PARTIAL_CLOSE);
        }
        if (iMin >= 50) {
            return new MatchResult(iMin, MatchType.PARTIAL_WEAK);
        }
        return new MatchResult(iMin, MatchType.NO_MATCH);
    }
}
