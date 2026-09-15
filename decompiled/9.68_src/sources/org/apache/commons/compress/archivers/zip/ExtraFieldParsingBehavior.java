package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface ExtraFieldParsingBehavior extends UnparseableExtraFieldBehavior {
    ZipExtraField createExtraField(ZipShort zipShort) throws IllegalAccessException, ZipException, InstantiationException;

    ZipExtraField fill(ZipExtraField zipExtraField, byte[] bArr, int i, int i2, boolean z) throws ZipException;
}
