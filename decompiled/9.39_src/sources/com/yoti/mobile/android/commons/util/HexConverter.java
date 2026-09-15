package com.yoti.mobile.android.commons.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HexConverter.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003¨\u0006\u0005"}, d2 = {"bytesToHex", "", "byteArray", "", "toHex", "commons-utils_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class HexConverter {
    public static final String bytesToHex(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "byteArray");
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(0xFF and byteArray[i].toInt())");
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public static final String toHex(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bytesToHex(bArr);
    }
}
