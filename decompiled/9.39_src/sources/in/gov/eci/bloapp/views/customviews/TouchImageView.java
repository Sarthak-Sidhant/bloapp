package in.gov.eci.bloapp.views.customviews;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import in.gov.eci.bloapp.utils.Logger;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class TouchImageView extends AppCompatImageView implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    static final int CLICK = 3;
    static final int DRAG = 1;
    static final int NONE = 0;
    static final int ZOOM = 2;
    Context context;
    PointF last;
    float[] m;
    GestureDetector mGestureDetector;
    ScaleGestureDetector mScaleDetector;
    Matrix matrix;
    float maxScale;
    float minScale;
    int mode;
    int oldMeasuredHeight;
    int oldMeasuredWidth;
    protected float origHeight;
    protected float origWidth;
    float saveScale;
    PointF start;
    int viewHeight;
    int viewWidth;

    float getFixDragTrans(float delta, float viewSize, float contentSize) {
        if (contentSize <= viewSize) {
            return 0.0f;
        }
        return delta;
    }

    float getFixTrans(float trans, float viewSize, float contentSize) {
        float f;
        float f2;
        if (contentSize <= viewSize) {
            f2 = viewSize - contentSize;
            f = 0.0f;
        } else {
            f = viewSize - contentSize;
            f2 = 0.0f;
        }
        if (trans < f) {
            return (-trans) + f;
        }
        if (trans > f2) {
            return (-trans) + f2;
        }
        return 0.0f;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent e) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent e) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    public TouchImageView(Context context) {
        super(context);
        this.mode = 0;
        this.last = new PointF();
        this.start = new PointF();
        this.minScale = 1.0f;
        this.maxScale = 3.0f;
        this.saveScale = 1.0f;
        sharedConstructing(context);
    }

    public TouchImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mode = 0;
        this.last = new PointF();
        this.start = new PointF();
        this.minScale = 1.0f;
        this.maxScale = 3.0f;
        this.saveScale = 1.0f;
        sharedConstructing(context);
    }

    private void sharedConstructing(Context context) {
        super.setClickable(true);
        this.context = context;
        GestureDetector gestureDetector = new GestureDetector(context, this);
        this.mGestureDetector = gestureDetector;
        gestureDetector.setOnDoubleTapListener(this);
        this.mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
        Matrix matrix = new Matrix();
        this.matrix = matrix;
        this.m = new float[9];
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
        setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.customviews.TouchImageView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                TouchImageView.this.mScaleDetector.onTouchEvent(event);
                TouchImageView.this.mGestureDetector.onTouchEvent(event);
                PointF pointF = new PointF(event.getX(), event.getY());
                int action = event.getAction();
                if (action == 0) {
                    TouchImageView.this.last.set(pointF);
                    TouchImageView.this.start.set(TouchImageView.this.last);
                    TouchImageView.this.mode = 1;
                } else if (action == 1) {
                    TouchImageView.this.mode = 0;
                    int iAbs = (int) Math.abs(pointF.x - TouchImageView.this.start.x);
                    int iAbs2 = (int) Math.abs(pointF.y - TouchImageView.this.start.y);
                    if (iAbs < 3 && iAbs2 < 3) {
                        TouchImageView.this.performClick();
                    }
                } else if (action != 2) {
                    if (action == 6) {
                        TouchImageView.this.mode = 0;
                    }
                } else if (TouchImageView.this.mode == 1) {
                    float f = pointF.x - TouchImageView.this.last.x;
                    float f2 = pointF.y - TouchImageView.this.last.y;
                    TouchImageView touchImageView = TouchImageView.this;
                    float fixDragTrans = touchImageView.getFixDragTrans(f, touchImageView.viewWidth, TouchImageView.this.origWidth * TouchImageView.this.saveScale);
                    TouchImageView touchImageView2 = TouchImageView.this;
                    TouchImageView.this.matrix.postTranslate(fixDragTrans, touchImageView2.getFixDragTrans(f2, touchImageView2.viewHeight, TouchImageView.this.origHeight * TouchImageView.this.saveScale));
                    TouchImageView.this.fixTrans();
                    TouchImageView.this.last.set(pointF.x, pointF.y);
                }
                TouchImageView touchImageView3 = TouchImageView.this;
                touchImageView3.setImageMatrix(touchImageView3.matrix);
                TouchImageView.this.invalidate();
                return true;
            }
        });
    }

    public void setMaxZoom(float x) {
        this.maxScale = x;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent e) {
        Logger.i("MAIN_TAG", "Double tap detected");
        float f = this.saveScale;
        float f2 = this.maxScale;
        if (f == f2) {
            f2 = this.minScale;
            this.saveScale = f2;
        } else {
            this.saveScale = f2;
        }
        float f3 = f2 / f;
        this.matrix.postScale(f3, f3, this.viewWidth / 2.0f, this.viewHeight / 2.0f);
        fixTrans();
        return false;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private ScaleListener() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            TouchImageView.this.mode = 2;
            return true;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0073  */
        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector detector) {
            float f;
            float scaleFactor = detector.getScaleFactor();
            float f2 = TouchImageView.this.saveScale;
            TouchImageView.this.saveScale *= scaleFactor;
            if (TouchImageView.this.saveScale > TouchImageView.this.maxScale) {
                TouchImageView touchImageView = TouchImageView.this;
                touchImageView.saveScale = touchImageView.maxScale;
                f = TouchImageView.this.maxScale;
            } else {
                if (TouchImageView.this.saveScale < TouchImageView.this.minScale) {
                    TouchImageView touchImageView2 = TouchImageView.this;
                    touchImageView2.saveScale = touchImageView2.minScale;
                    f = TouchImageView.this.minScale;
                }
                if (TouchImageView.this.origWidth * TouchImageView.this.saveScale > TouchImageView.this.viewWidth || TouchImageView.this.origHeight * TouchImageView.this.saveScale <= TouchImageView.this.viewHeight) {
                    TouchImageView.this.matrix.postScale(scaleFactor, scaleFactor, TouchImageView.this.viewWidth / 2.0f, TouchImageView.this.viewHeight / 2.0f);
                } else {
                    TouchImageView.this.matrix.postScale(scaleFactor, scaleFactor, detector.getFocusX(), detector.getFocusY());
                }
                TouchImageView.this.fixTrans();
                return true;
            }
            scaleFactor = f / f2;
            if (TouchImageView.this.origWidth * TouchImageView.this.saveScale > TouchImageView.this.viewWidth) {
                TouchImageView.this.matrix.postScale(scaleFactor, scaleFactor, TouchImageView.this.viewWidth / 2.0f, TouchImageView.this.viewHeight / 2.0f);
            } else {
                TouchImageView.this.matrix.postScale(scaleFactor, scaleFactor, TouchImageView.this.viewWidth / 2.0f, TouchImageView.this.viewHeight / 2.0f);
            }
            TouchImageView.this.fixTrans();
            return true;
        }
    }

    void fixTrans() {
        this.matrix.getValues(this.m);
        float[] fArr = this.m;
        float f = fArr[2];
        float f2 = fArr[5];
        float fixTrans = getFixTrans(f, this.viewWidth, this.origWidth * this.saveScale);
        float fixTrans2 = getFixTrans(f2, this.viewHeight, this.origHeight * this.saveScale);
        if (fixTrans == 0.0f && fixTrans2 == 0.0f) {
            return;
        }
        this.matrix.postTranslate(fixTrans, fixTrans2);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.viewWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        this.viewHeight = size;
        int i = this.oldMeasuredHeight;
        int i2 = this.viewWidth;
        if ((i == i2 && i == size) || i2 == 0 || size == 0) {
            return;
        }
        this.oldMeasuredHeight = size;
        this.oldMeasuredWidth = i2;
        if (this.saveScale == 1.0f) {
            Drawable drawable = getDrawable();
            if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
                return;
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Logger.d("bmSize", "bmWidth: " + intrinsicWidth + " bmHeight : " + intrinsicHeight);
            float f = intrinsicWidth;
            float f2 = intrinsicHeight;
            float fMin = Math.min(this.viewWidth / f, this.viewHeight / f2);
            this.matrix.setScale(fMin, fMin);
            float f3 = (this.viewHeight - (f2 * fMin)) / 2.0f;
            float f4 = (this.viewWidth - (fMin * f)) / 2.0f;
            this.matrix.postTranslate(f4, f3);
            this.origWidth = this.viewWidth - (f4 * 2.0f);
            this.origHeight = this.viewHeight - (f3 * 2.0f);
            setImageMatrix(this.matrix);
        }
        fixTrans();
    }
}
