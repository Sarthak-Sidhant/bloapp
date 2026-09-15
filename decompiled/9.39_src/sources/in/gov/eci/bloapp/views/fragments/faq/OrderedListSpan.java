package in.gov.eci.bloapp.views.fragments.faq;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class OrderedListSpan implements LeadingMarginSpan {
    private final String leadingText;
    private final int width;

    public OrderedListSpan(int width, String leadingText) {
        this.width = width;
        this.leadingText = leadingText;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean first) {
        return this.width;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout layout) {
        if (((Spanned) text).getSpanStart(this) == start) {
            c.drawText(this.leadingText, x, baseline, p);
        }
    }
}
