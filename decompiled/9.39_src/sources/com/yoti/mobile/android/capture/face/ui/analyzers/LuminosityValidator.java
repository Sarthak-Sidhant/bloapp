package com.yoti.mobile.android.capture.face.ui.analyzers;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LuminosityValidator.kt */
/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0006\u0010\u0015\u001a\u00020\rJ\u0006\u0010\u0016\u001a\u00020\rR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/yoti/mobile/android/capture/face/ui/analyzers/LuminosityValidator;", "Landroid/hardware/SensorEventListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mSensorManager", "Landroid/hardware/SensorManager;", "(Landroid/hardware/SensorManager;)V", "lastLightLevel", "", "isValid", "", "onAccuracyChanged", "", "sensor", "Landroid/hardware/Sensor;", "i", "", "onSensorChanged", "sensorEvent", "Landroid/hardware/SensorEvent;", "start", "stop", "face_bundledRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LuminosityValidator implements SensorEventListener {
    private float lastLightLevel;
    private final SensorManager mSensorManager;

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
    }

    public LuminosityValidator(SensorManager sensorManager) {
        Intrinsics.checkNotNullParameter(sensorManager, "mSensorManager");
        this.mSensorManager = sensorManager;
        this.lastLightLevel = 2000.0f;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LuminosityValidator(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("sensor");
        if (systemService != null) {
            this((SensorManager) systemService);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.hardware.SensorManager");
    }

    public final void start() {
        Sensor defaultSensor = this.mSensorManager.getDefaultSensor(5);
        if (defaultSensor != null) {
            this.mSensorManager.registerListener(this, defaultSensor, 2);
        }
    }

    public final void stop() {
        this.mSensorManager.unregisterListener(this);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Intrinsics.checkNotNullParameter(sensorEvent, "sensorEvent");
        this.lastLightLevel = sensorEvent.values[0];
    }

    public final boolean isValid() {
        return this.lastLightLevel >= 5.0f;
    }
}
