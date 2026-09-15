package com.yoti.mobile.android.capture.face.ui.models.face;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yoti.mobile.android.capture.face.ui.models.face.ImageQuality, still in use, count: 1, list:
  (r0v1 com.yoti.mobile.android.capture.face.ui.models.face.ImageQuality) from 0x0032: SPUT (r0v1 com.yoti.mobile.android.capture.face.ui.models.face.ImageQuality) (LINE:13) com.yoti.mobile.android.capture.face.ui.models.face.ImageQuality.default com.yoti.mobile.android.capture.face.ui.models.face.ImageQuality
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: ImageQuality.kt */
/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/ImageQuality;", "", "quality", "", "(Ljava/lang/String;II)V", "getQuality", "()I", "HIGH", "MEDIUM", "LOW", "Companion", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageQuality {
    HIGH(100),
    MEDIUM(96),
    LOW(90);


    /* JADX INFO: renamed from: default, reason: not valid java name */
    private static final ImageQuality f0default = new ImageQuality(96);
    private final int quality;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static ImageQuality valueOf(String str) {
        return (ImageQuality) Enum.valueOf(ImageQuality.class, str);
    }

    public static ImageQuality[] values() {
        return (ImageQuality[]) $VALUES.clone();
    }

    private ImageQuality(int i) {
        super(str, i);
        this.quality = i;
    }

    public final int getQuality() {
        return this.quality;
    }

    static {
    }

    /* JADX INFO: compiled from: ImageQuality.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/models/face/ImageQuality$Companion;", "", "()V", "default", "Lcom/yoti/mobile/android/capture/face/ui/models/face/ImageQuality;", "getDefault", "()Lcom/yoti/mobile/android/capture/face/ui/models/face/ImageQuality;", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImageQuality getDefault() {
            return ImageQuality.f0default;
        }
    }
}
