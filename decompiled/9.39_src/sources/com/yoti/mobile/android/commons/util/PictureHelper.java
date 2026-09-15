package com.yoti.mobile.android.commons.util;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Environment;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;
import android.util.Base64;
import android.view.View;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class PictureHelper {
    public static Bitmap YuvToBitmap(Context context, byte[] bArr, int i, int i2) {
        RenderScript renderScriptCreate = RenderScript.create(context);
        ScriptIntrinsicYuvToRGB scriptIntrinsicYuvToRGBCreate = ScriptIntrinsicYuvToRGB.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
        try {
            Allocation allocationCreateTyped = Allocation.createTyped(renderScriptCreate, new Type.Builder(renderScriptCreate, Element.U8(renderScriptCreate)).setX(bArr.length).create(), 1);
            Allocation allocationCreateTyped2 = Allocation.createTyped(renderScriptCreate, new Type.Builder(renderScriptCreate, Element.RGBA_8888(renderScriptCreate)).setX(i).setY(i2).create(), 1);
            allocationCreateTyped.copyFrom(bArr);
            scriptIntrinsicYuvToRGBCreate.setInput(allocationCreateTyped);
            scriptIntrinsicYuvToRGBCreate.forEach(allocationCreateTyped2);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            allocationCreateTyped2.copyTo(bitmapCreateBitmap);
            return bitmapCreateBitmap;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static Bitmap YuvToBitmapCompat(byte[] bArr, int i, int i2) {
        try {
            return YuvToBitmapViaRgb(bArr, i, i2);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static Bitmap YuvToBitmapViaRgb(byte[] bArr, int i, int i2) {
        return Bitmap.createBitmap(YuvToRGB(bArr, i, i2), i, i2, Bitmap.Config.ARGB_8888);
    }

    public static int[] YuvToRGB(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int[] iArr = new int[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = ((i5 >> 1) * i) + i3;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i7 < i) {
                int i10 = (bArr[i4] & 255) - 16;
                if (i10 < 0) {
                    i10 = 0;
                }
                if ((i7 & 1) == 0) {
                    int i11 = i6 + 1;
                    i9 = (bArr[i6] & 255) - 128;
                    i6 += 2;
                    i8 = (bArr[i11] & 255) - 128;
                }
                int i12 = i10 * 1192;
                int i13 = (i9 * 1634) + i12;
                int i14 = (i12 - (i9 * 833)) - (i8 * 400);
                int i15 = i12 + (i8 * 2066);
                if (i13 < 0) {
                    i13 = 0;
                } else if (i13 > 262143) {
                    i13 = 262143;
                }
                if (i14 < 0) {
                    i14 = 0;
                } else if (i14 > 262143) {
                    i14 = 262143;
                }
                if (i15 < 0) {
                    i15 = 0;
                } else if (i15 > 262143) {
                    i15 = 262143;
                }
                iArr[i4] = ((i15 >> 10) & 255) | ((i13 << 6) & 16711680) | (-16777216) | ((i14 >> 2) & 65280);
                i7++;
                i4++;
            }
        }
        return iArr;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 > i2 && i7 / i5 > i) {
                i5 *= 2;
            }
            for (long j = (i4 * i3) / i5; j > i * i2 * 2; j /= 2) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public static Bitmap compressBitmap(Bitmap bitmap, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    }

    public static File createImageFile() throws IOException {
        return File.createTempFile(("PNG_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + "_") + (new Random().nextInt(10) + 1), ".png", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
    }

    public static String createRandomImageFilename() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/" + (("PNG_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + "_") + (new Random().nextInt(10) + 1)) + ".png";
    }

    public static Bitmap createYotiPatternMaskSquares(Bitmap bitmap, RectF[] rectFArr) {
        if (bitmap == null || rectFArr == null || rectFArr.length <= 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        for (RectF rectF : rectFArr) {
            canvas.drawRect(rectF, paint);
        }
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    public static Bitmap decodeBase64(String str) {
        WeakReference weakReference = new WeakReference(Base64.decode(str, 0));
        return BitmapFactory.decodeByteArray((byte[]) weakReference.get(), 0, ((byte[]) weakReference.get()).length);
    }

    public static Bitmap decodeBase64ToBitmap(String str) {
        WeakReference weakReference = new WeakReference(Base64.decode(str, 0));
        return BitmapFactory.decodeByteArray((byte[]) weakReference.get(), 0, ((byte[]) weakReference.get()).length);
    }

    public static Bitmap decodeSampledBitmapFromFile(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources resources, int i, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = calculateInSampleSize(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    public static String encodeBitmapFileTobase64(String str) {
        return Base64.encodeToString(loadBitmapFromFileToByteArray(str), 0);
    }

    public static String encodeBitmapTobase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static String encodeJpegFileTobase64(String str) {
        return Base64.encodeToString(FileManager.readByteArrayFromFile(str), 0);
    }

    public static String encodeTobase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static WeakReference<Bitmap> flipMirroredBitmap(WeakReference<Bitmap> weakReference, int i, int i2) {
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        return new WeakReference<>(Bitmap.createBitmap(weakReference.get(), 0, 0, i, i2, matrix, false));
    }

    public static String getDocumentFilePathInInternalStorage(Context context) {
        return new File(new ContextWrapper(context).getDir("ytdoc", 0), (("PNG_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + "_") + (new Random().nextInt(10) + 1)) + ".png").getAbsolutePath();
    }

    public static String getTemporalPathForBitmapWithFileName(String str) {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/" + str;
    }

    public static byte[] loadAndRotateBitmapFromFileToByteArray(String str, float f, int i, int i2, int i3, boolean z) {
        byte[] byteArrayFromFile = FileManager.readByteArrayFromFile(str);
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArrayFromFile, 0, byteArrayFromFile.length);
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        int width = bitmapDecodeByteArray.getWidth();
        if (i <= 0) {
            i = width;
        }
        int height = bitmapDecodeByteArray.getHeight();
        if (i2 > 0) {
            height = bitmapDecodeByteArray.getHeight();
        }
        matrix.setRectToRect(new RectF(0.0f, 0.0f, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight()), new RectF(0.0f, 0.0f, i, height), Matrix.ScaleToFit.CENTER);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap.CompressFormat compressFormat = z ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
        if (i3 <= 0 || i3 > 100) {
            i3 = 100;
        }
        bitmapCreateBitmap.compress(compressFormat, i3, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        bitmapCreateBitmap.recycle();
        bitmapDecodeByteArray.recycle();
        return byteArray;
    }

    public static byte[] loadBitmapFromFileToByteArray(String str) {
        return FileManager.readByteArrayFromFile(str);
    }

    public static Bitmap loadBitmapFromView(View view) {
        if (view == null || view.getWidth() <= 0 || view.getHeight() <= 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        view.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static byte[] loadImageInByteArrayFormat(String str) {
        return FileManager.readByteArrayFromFile(str);
    }

    public static Bitmap punchAHoleInABitmap(Bitmap bitmap, float f, float f2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawCircle(bitmap.getWidth() * 0.5f, bitmap.getHeight() * f2, bitmap.getWidth() * f, paint);
        return bitmapCreateBitmap;
    }

    public static Bitmap readBitmapFromFile(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return BitmapFactory.decodeFile(str, options);
    }

    public static String rotateAndEncodeBitmapFileTobase64(String str, float f, int i, int i2, int i3, boolean z) {
        return Base64.encodeToString(loadAndRotateBitmapFromFileToByteArray(str, f, i, i2, i3, z), 0);
    }

    public static boolean saveBitmapToFile(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i) throws Throwable {
        if (bitmap != null) {
            WeakReference weakReference = null;
            try {
                WeakReference weakReference2 = new WeakReference(new FileOutputStream(str));
                try {
                    bitmap.compress(compressFormat, i, (OutputStream) weakReference2.get());
                    try {
                        ((FileOutputStream) weakReference2.get()).close();
                        weakReference2.clear();
                        return true;
                    } catch (IOException unused) {
                        return false;
                    } finally {
                        weakReference2.clear();
                    }
                } catch (Exception unused2) {
                    weakReference = weakReference2;
                    if (weakReference == null) {
                        if (weakReference != null) {
                            weakReference.clear();
                        }
                        return false;
                    }
                    try {
                        ((FileOutputStream) weakReference.get()).close();
                        weakReference.clear();
                        return true;
                    } catch (IOException unused3) {
                        return false;
                    } finally {
                        if (weakReference != null) {
                            weakReference.clear();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    weakReference = weakReference2;
                    if (weakReference == null) {
                        if (weakReference != null) {
                            weakReference.clear();
                        }
                        throw th;
                    }
                    try {
                        ((FileOutputStream) weakReference.get()).close();
                        weakReference.clear();
                        return true;
                    } catch (IOException unused4) {
                        return false;
                    } finally {
                        if (weakReference != null) {
                            weakReference.clear();
                        }
                    }
                }
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return false;
    }

    public static String saveBitmapToInternalStorage(Context context, Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i) {
        File file = new File(new ContextWrapper(context).getDir("ytself", 0), str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(compressFormat, i, fileOutputStream);
            fileOutputStream.close();
        } catch (Exception unused) {
        }
        return file.getAbsolutePath();
    }

    public static boolean saveBitmapToPNGFile(Bitmap bitmap, String str) throws Throwable {
        if (bitmap != null) {
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (IOException unused) {
                        return false;
                    }
                } catch (Exception unused2) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return true;
                        } catch (IOException unused3) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream == null) {
                        throw th;
                    }
                    try {
                        fileOutputStream.close();
                        return true;
                    } catch (IOException unused4) {
                        return false;
                    }
                }
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return false;
    }

    public static boolean saveByteArrayToFile(byte[] bArr, String str) throws Throwable {
        if (bArr != null) {
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    fileOutputStream2.write(bArr);
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (IOException unused) {
                        return false;
                    }
                } catch (Exception unused2) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return true;
                        } catch (IOException unused3) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream == null) {
                        throw th;
                    }
                    try {
                        fileOutputStream.close();
                        return true;
                    } catch (IOException unused4) {
                        return false;
                    }
                }
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return false;
    }

    public static WeakReference<Bitmap> scaleBitmapFromFile(String str, int i) {
        try {
            WeakReference weakReference = new WeakReference(BitmapFactory.decodeFile(str));
            if (weakReference.get() == null) {
                return null;
            }
            int i2 = 100 - i;
            return new WeakReference<>(Bitmap.createScaledBitmap((Bitmap) weakReference.get(), (((Bitmap) weakReference.get()).getWidth() * i2) / 100, (((Bitmap) weakReference.get()).getHeight() * i2) / 100, false));
        } catch (Exception unused) {
            return null;
        }
    }

    public static WeakReference<Bitmap> scaleBitmapKeepingAspectRatio(WeakReference<Bitmap> weakReference, int i, int i2) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, weakReference.get().getWidth(), weakReference.get().getHeight()), new RectF(0.0f, 0.0f, i, i2), Matrix.ScaleToFit.CENTER);
        return new WeakReference<>(Bitmap.createBitmap(weakReference.get(), 0, 0, weakReference.get().getWidth(), weakReference.get().getHeight(), matrix, true));
    }

    public static boolean saveBitmapToFile(Bitmap bitmap, String str) throws Throwable {
        if (bitmap != null) {
            WeakReference weakReference = null;
            try {
                WeakReference weakReference2 = new WeakReference(new FileOutputStream(str));
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream) weakReference2.get());
                    try {
                        ((FileOutputStream) weakReference2.get()).close();
                        weakReference2.clear();
                        return true;
                    } catch (IOException unused) {
                        return false;
                    } finally {
                        weakReference2.clear();
                    }
                } catch (Exception unused2) {
                    weakReference = weakReference2;
                    if (weakReference == null) {
                        if (weakReference != null) {
                            weakReference.clear();
                        }
                        return false;
                    }
                    try {
                        ((FileOutputStream) weakReference.get()).close();
                        weakReference.clear();
                        return true;
                    } catch (IOException unused3) {
                        return false;
                    } finally {
                        if (weakReference != null) {
                            weakReference.clear();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    weakReference = weakReference2;
                    if (weakReference != null) {
                        try {
                            ((FileOutputStream) weakReference.get()).close();
                            weakReference.clear();
                            return true;
                        } catch (IOException unused4) {
                            return false;
                        } finally {
                            if (weakReference != null) {
                                weakReference.clear();
                            }
                        }
                    }
                    if (weakReference != null) {
                        weakReference.clear();
                    }
                    throw th;
                }
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return false;
    }

    public static void saveBitmapToFile(Bitmap bitmap) throws Throwable {
        if (bitmap != null) {
            try {
                saveBitmapToPNGFile(bitmap, createImageFile().getAbsolutePath());
            } catch (IOException unused) {
            }
        }
    }
}
