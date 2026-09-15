package in.gov.eci.bloapp.utils;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class DottedLineView extends View {
    private Paint paint;
    private float phase;

    public DottedLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.phase = CropImageView.DEFAULT_ASPECT_RATIO;
        Paint paint = new Paint(1);
        this.paint = paint;
        paint.setColor(-16777216);
        this.paint.setStrokeWidth(6.0f);
        this.paint.setStyle(Paint.Style.STROKE);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(4.0f);
        this.paint.setPathEffect(new DashPathEffect(new float[]{20.0f, 20.0f}, this.phase));
        float height = getHeight() / 2.0f;
        canvas.drawLine(CropImageView.DEFAULT_ASPECT_RATIO, height, getWidth(), height, this.paint);
    }

    public void startSyncAnimation() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(CropImageView.DEFAULT_ASPECT_RATIO, 30.0f);
        valueAnimatorOfFloat.setDuration(1000L);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: in.gov.eci.bloapp.utils.DottedLineView$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$startSyncAnimation$0(valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startSyncAnimation$0(ValueAnimator valueAnimator) {
        this.phase = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }
}
