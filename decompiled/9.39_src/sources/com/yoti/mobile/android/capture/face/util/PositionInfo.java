package com.yoti.mobile.android.capture.face.util;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RectStabilityValidator.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0000H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0000H\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0000H\u0002J\u0010\u0010\u001d\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0000J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/yoti/mobile/android/capture/face/util/PositionInfo;", "", "position", "Landroid/graphics/Rect;", "imageWidth", "", "imageHeight", "(Landroid/graphics/Rect;II)V", "heightTolerance", "", "getImageHeight", "()I", "getImageWidth", "getPosition", "()Landroid/graphics/Rect;", "translationXTolerance", "translationYTolerance", "widthTolerance", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "isCameraStable", "isPositionStable", "isSizeStable", "isStable", "toString", "", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
final /* data */ class PositionInfo {
    private final float heightTolerance;
    private final int imageHeight;
    private final int imageWidth;
    private final Rect position;
    private final float translationXTolerance;
    private final float translationYTolerance;
    private final float widthTolerance;

    public static /* synthetic */ PositionInfo copy$default(PositionInfo positionInfo, Rect rect, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            rect = positionInfo.position;
        }
        if ((i3 & 2) != 0) {
            i = positionInfo.imageWidth;
        }
        if ((i3 & 4) != 0) {
            i2 = positionInfo.imageHeight;
        }
        return positionInfo.copy(rect, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Rect getPosition() {
        return this.position;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getImageWidth() {
        return this.imageWidth;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getImageHeight() {
        return this.imageHeight;
    }

    public final PositionInfo copy(Rect position, int imageWidth, int imageHeight) {
        Intrinsics.checkNotNullParameter(position, "position");
        return new PositionInfo(position, imageWidth, imageHeight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PositionInfo)) {
            return false;
        }
        PositionInfo positionInfo = (PositionInfo) other;
        return Intrinsics.areEqual(this.position, positionInfo.position) && this.imageWidth == positionInfo.imageWidth && this.imageHeight == positionInfo.imageHeight;
    }

    public int hashCode() {
        return (((this.position.hashCode() * 31) + Integer.hashCode(this.imageWidth)) * 31) + Integer.hashCode(this.imageHeight);
    }

    public String toString() {
        return "PositionInfo(position=" + this.position + ", imageWidth=" + this.imageWidth + ", imageHeight=" + this.imageHeight + ')';
    }

    public PositionInfo(Rect rect, int i, int i2) {
        Intrinsics.checkNotNullParameter(rect, "position");
        this.position = rect;
        this.imageWidth = i;
        this.imageHeight = i2;
        this.widthTolerance = i * 0.015f;
        this.heightTolerance = i2 * 0.015f;
        this.translationXTolerance = i * 0.025f;
        this.translationYTolerance = i2 * 0.025f;
    }

    public final int getImageHeight() {
        return this.imageHeight;
    }

    public final int getImageWidth() {
        return this.imageWidth;
    }

    public final Rect getPosition() {
        return this.position;
    }

    public final boolean isStable(PositionInfo other) {
        return other != null && isCameraStable(other) && isSizeStable(other) && isPositionStable(other);
    }

    private final boolean isCameraStable(PositionInfo other) {
        return this.imageWidth == other.imageWidth && this.imageHeight == other.imageHeight;
    }

    private final boolean isSizeStable(PositionInfo other) {
        return ((float) Math.abs(this.position.width() - other.position.width())) <= this.widthTolerance && ((float) Math.abs(this.position.height() - other.position.height())) <= this.heightTolerance;
    }

    private final boolean isPositionStable(PositionInfo other) {
        return ((float) Math.abs(this.position.centerX() - other.position.centerX())) <= this.translationXTolerance && ((float) Math.abs(this.position.centerY() - other.position.centerY())) <= this.translationYTolerance;
    }
}
