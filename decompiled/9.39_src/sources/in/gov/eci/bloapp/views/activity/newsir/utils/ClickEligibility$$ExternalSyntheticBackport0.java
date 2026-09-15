package in.gov.eci.bloapp.views.activity.newsir.utils;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final /* synthetic */ class ClickEligibility$$ExternalSyntheticBackport0 {
    public static /* synthetic */ boolean m(String str) {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (!Character.isWhitespace(iCodePointAt)) {
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return true;
    }
}
