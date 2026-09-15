package com.microsoft.schemas.vml;

import io.reactivex.annotations.SchedulerSupport;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class STStrokeArrowType$Enum extends StringEnumAbstractBase {
    static final int INT_BLOCK = 2;
    static final int INT_CLASSIC = 3;
    static final int INT_DIAMOND = 5;
    static final int INT_NONE = 1;
    static final int INT_OPEN = 6;
    static final int INT_OVAL = 4;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STStrokeArrowType$Enum[]{new STStrokeArrowType$Enum(SchedulerSupport.NONE, 1), new STStrokeArrowType$Enum("block", 2), new STStrokeArrowType$Enum("classic", 3), new STStrokeArrowType$Enum("oval", 4), new STStrokeArrowType$Enum("diamond", 5), new STStrokeArrowType$Enum(AbstractCircuitBreaker.PROPERTY_NAME, 6)});

    private STStrokeArrowType$Enum(String str, int i) {
        super(str, i);
    }

    public static STStrokeArrowType$Enum forInt(int i) {
        return (STStrokeArrowType$Enum) table.forInt(i);
    }

    public static STStrokeArrowType$Enum forString(String str) {
        return (STStrokeArrowType$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
