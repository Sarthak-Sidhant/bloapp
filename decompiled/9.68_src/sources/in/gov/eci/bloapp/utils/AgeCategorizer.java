package in.gov.eci.bloapp.utils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class AgeCategorizer {
    public static String getCategory(int age) {
        if (age >= 37) {
            return "Born in India before 1987";
        }
        if (age >= 20 && age <= 37) {
            return "Born in India between 01.07.1987 and 02.12.2004";
        }
        return "Born in India after 03.12.2004";
    }
}
