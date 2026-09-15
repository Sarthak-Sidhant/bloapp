package com.yoti.mobile.android.capture.face.ui.mappers;

import android.util.Log;
import com.yoti.mobile.android.capture.face.ui.models.camera.CameraError;
import com.yoti.mobile.android.capture.face.ui.models.camera.CameraState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraInitializationErrorMapper.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/mappers/CameraInitializationErrorMapper;", "", "()V", "invoke", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState$CameraInitializationError;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CameraInitializationErrorMapper {
    public final CameraState.CameraInitializationError invoke(Exception exception) {
        CameraError.Unknown unknown;
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (exception instanceof IllegalStateException) {
            Log.e("CameraInitErrorMapper", "Not on the main thread OR already bound to another lifecycle");
            unknown = CameraError.IllegalState.INSTANCE;
        } else if (exception instanceof IllegalArgumentException) {
            Log.e("CameraInitErrorMapper", "Unable to resolve camera");
            unknown = CameraError.UnableToResolveCamera.INSTANCE;
        } else {
            Log.e("CameraInitErrorMapper", "Unknown error. " + exception);
            unknown = CameraError.Unknown.INSTANCE;
        }
        return new CameraState.CameraInitializationError(unknown);
    }
}
