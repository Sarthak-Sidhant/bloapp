package com.microsoft.schemas.vml;

import io.reactivex.annotations.SchedulerSupport;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class STFillMethod$Enum extends StringEnumAbstractBase {
    static final int INT_ANY = 4;
    static final int INT_LINEAR = 2;
    static final int INT_LINEAR_SIGMA = 5;
    static final int INT_NONE = 1;
    static final int INT_SIGMA = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STFillMethod$Enum[]{new STFillMethod$Enum(SchedulerSupport.NONE, 1), new STFillMethod$Enum("linear", 2), new STFillMethod$Enum("sigma", 3), new STFillMethod$Enum("any", 4), new STFillMethod$Enum("linear sigma", 5)});

    private STFillMethod$Enum(String str, int i) {
        super(str, i);
    }

    public static STFillMethod$Enum forInt(int i) {
        return (STFillMethod$Enum) table.forInt(i);
    }

    public static STFillMethod$Enum forString(String str) {
        return (STFillMethod$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
