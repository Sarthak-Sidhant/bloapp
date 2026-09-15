package in.gov.eci.bloapp.utils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class PostalCodeValidator {
    private static final Map<String, Pattern> POSTAL_CODE_PATTERNS;

    static {
        HashMap map = new HashMap();
        POSTAL_CODE_PATTERNS = map;
        map.put("US", Pattern.compile("^\\d{5}(-\\d{4})?$"));
        map.put("CA", Pattern.compile("^[ABCEGHJ-NPRSTVXY]\\d[ABCEGHJ-NPRSTV-Z]\\s?\\d[ABCEGHJ-NPRSTV-Z]\\d$", 2));
        map.put("GB", Pattern.compile("^(GIR\\s?0AA|[A-Z]{1,2}\\d[A-Z\\d]?\\s?\\d[ABD-HJLNP-UW-Z]{2})$", 2));
        map.put("IN", Pattern.compile("^[1-9]\\d{5}$"));
        map.put("DE", Pattern.compile("^\\d{5}$"));
        map.put("FR", Pattern.compile("^\\d{5}$"));
        map.put("AU", Pattern.compile("^\\d{4}$"));
        map.put("NL", Pattern.compile("^\\d{4}\\s?[A-Z]{2}$", 2));
        map.put("IT", Pattern.compile("^\\d{5}$"));
        map.put("ES", Pattern.compile("^\\d{5}$"));
        map.put("BR", Pattern.compile("^\\d{5}-?\\d{3}$"));
        map.put("JP", Pattern.compile("^\\d{3}-?\\d{4}$"));
        map.put("CN", Pattern.compile("^\\d{6}$"));
        map.put("SG", Pattern.compile("^\\d{6}$"));
        map.put("ZA", Pattern.compile("^\\d{4}$"));
        map.put("NZ", Pattern.compile("^\\d{4}$"));
        map.put("MX", Pattern.compile("^\\d{5}$"));
        map.put("CH", Pattern.compile("^\\d{4}$"));
        map.put("SE", Pattern.compile("^\\d{3}\\s?\\d{2}$"));
        map.put("NO", Pattern.compile("^\\d{4}$"));
        map.put("DK", Pattern.compile("^\\d{4}$"));
        map.put("BE", Pattern.compile("^\\d{4}$"));
        map.put("AT", Pattern.compile("^\\d{4}$"));
        map.put("IE", Pattern.compile("^[A-Za-z]\\d{2}\\s?[A-Za-z0-9]{4}$", 2));
        map.put("RU", Pattern.compile("^\\d{6}$"));
        map.put("AR", Pattern.compile("^([A-HJ-NP-Z]\\d{4}[A-Z]{3}|\\d{4})$", 2));
        map.put("TR", Pattern.compile("^\\d{5}$"));
    }

    private PostalCodeValidator() {
    }

    public static boolean isValid(String rawPostalCode, String isoCountryCode) {
        if (rawPostalCode == null || isoCountryCode == null) {
            return false;
        }
        String upperCase = isoCountryCode.trim().toUpperCase(Locale.ROOT);
        String strReplaceAll = rawPostalCode.trim().replaceAll("\\s+", " ");
        Pattern pattern = POSTAL_CODE_PATTERNS.get(upperCase);
        if (pattern == null) {
            return strReplaceAll.matches("^[A-Za-z0-9\\-\\s]{3,12}$");
        }
        return pattern.matcher(strReplaceAll).matches();
    }
}
