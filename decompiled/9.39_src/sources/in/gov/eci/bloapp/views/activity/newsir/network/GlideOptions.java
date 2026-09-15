package in.gov.eci.bloapp.views.activity.newsir.network;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class GlideOptions extends RequestOptions implements Cloneable {
    private static GlideOptions centerCropTransform2;
    private static GlideOptions centerInsideTransform1;
    private static GlideOptions circleCropTransform3;
    private static GlideOptions fitCenterTransform0;
    private static GlideOptions noAnimation5;
    private static GlideOptions noTransformation4;

    public /* bridge */ /* synthetic */ BaseRequestOptions apply(BaseRequestOptions options) {
        return m1801apply((BaseRequestOptions<?>) options);
    }

    public /* bridge */ /* synthetic */ BaseRequestOptions decode(Class clazz) {
        return m1808decode((Class<?>) clazz);
    }

    public /* bridge */ /* synthetic */ BaseRequestOptions optionalTransform(Transformation transformation) {
        return m1829optionalTransform((Transformation<Bitmap>) transformation);
    }

    public /* bridge */ /* synthetic */ BaseRequestOptions set(Option option, Object y) {
        return m1836set((Option<Object>) option, y);
    }

    public /* bridge */ /* synthetic */ BaseRequestOptions transform(Transformation transformation) {
        return m1842transform((Transformation<Bitmap>) transformation);
    }

    @SafeVarargs
    public /* bridge */ /* synthetic */ BaseRequestOptions transform(Transformation[] transformations) {
        return m1844transform((Transformation<Bitmap>[]) transformations);
    }

    @SafeVarargs
    @Deprecated
    public /* bridge */ /* synthetic */ BaseRequestOptions transforms(Transformation[] transformations) {
        return m1845transforms((Transformation<Bitmap>[]) transformations);
    }

    public static GlideOptions sizeMultiplierOf(float value) {
        return new GlideOptions().sizeMultiplier(value);
    }

    public static GlideOptions diskCacheStrategyOf(DiskCacheStrategy strategy) {
        return new GlideOptions().diskCacheStrategy(strategy);
    }

    public static GlideOptions priorityOf(Priority priority) {
        return new GlideOptions().priority(priority);
    }

    public static GlideOptions placeholderOf(Drawable drawable) {
        return new GlideOptions().placeholder(drawable);
    }

    public static GlideOptions placeholderOf(int id) {
        return new GlideOptions().placeholder(id);
    }

    public static GlideOptions errorOf(Drawable drawable) {
        return new GlideOptions().error(drawable);
    }

    public static GlideOptions errorOf(int id) {
        return new GlideOptions().error(id);
    }

    public static GlideOptions skipMemoryCacheOf(boolean skipMemoryCache) {
        return new GlideOptions().skipMemoryCache(skipMemoryCache);
    }

    public static GlideOptions overrideOf(int width, int height) {
        return new GlideOptions().override(width, height);
    }

    public static GlideOptions overrideOf(int size) {
        return new GlideOptions().override(size);
    }

    public static GlideOptions signatureOf(Key key) {
        return new GlideOptions().signature(key);
    }

    public static GlideOptions fitCenterTransform() {
        if (fitCenterTransform0 == null) {
            fitCenterTransform0 = new GlideOptions().fitCenter().autoClone();
        }
        return fitCenterTransform0;
    }

    public static GlideOptions centerInsideTransform() {
        if (centerInsideTransform1 == null) {
            centerInsideTransform1 = new GlideOptions().centerInside().autoClone();
        }
        return centerInsideTransform1;
    }

    public static GlideOptions centerCropTransform() {
        if (centerCropTransform2 == null) {
            centerCropTransform2 = new GlideOptions().centerCrop().autoClone();
        }
        return centerCropTransform2;
    }

    public static GlideOptions circleCropTransform() {
        if (circleCropTransform3 == null) {
            circleCropTransform3 = new GlideOptions().circleCrop().autoClone();
        }
        return circleCropTransform3;
    }

    public static GlideOptions bitmapTransform(Transformation<Bitmap> transformation) {
        return new GlideOptions().m1842transform(transformation);
    }

    public static GlideOptions noTransformation() {
        if (noTransformation4 == null) {
            noTransformation4 = new GlideOptions().dontTransform().autoClone();
        }
        return noTransformation4;
    }

    public static <T> GlideOptions option(Option<T> option, T t) {
        return new GlideOptions().m1836set(option, t);
    }

    public static GlideOptions decodeTypeOf(Class<?> clazz) {
        return new GlideOptions().m1808decode(clazz);
    }

    public static GlideOptions formatOf(DecodeFormat format) {
        return new GlideOptions().format(format);
    }

    public static GlideOptions frameOf(long value) {
        return new GlideOptions().frame(value);
    }

    public static GlideOptions downsampleOf(DownsampleStrategy strategy) {
        return new GlideOptions().downsample(strategy);
    }

    public static GlideOptions timeoutOf(int value) {
        return new GlideOptions().timeout(value);
    }

    public static GlideOptions encodeQualityOf(int value) {
        return new GlideOptions().encodeQuality(value);
    }

    public static GlideOptions encodeFormatOf(Bitmap.CompressFormat format) {
        return new GlideOptions().encodeFormat(format);
    }

    public static GlideOptions noAnimation() {
        if (noAnimation5 == null) {
            noAnimation5 = new GlideOptions().dontAnimate().autoClone();
        }
        return noAnimation5;
    }

    public GlideOptions sizeMultiplier(float value) {
        return super.sizeMultiplier(value);
    }

    public GlideOptions useUnlimitedSourceGeneratorsPool(boolean flag) {
        return super.useUnlimitedSourceGeneratorsPool(flag);
    }

    public GlideOptions useAnimationPool(boolean flag) {
        return super.useAnimationPool(flag);
    }

    public GlideOptions onlyRetrieveFromCache(boolean flag) {
        return super.onlyRetrieveFromCache(flag);
    }

    public GlideOptions diskCacheStrategy(DiskCacheStrategy strategy) {
        return super.diskCacheStrategy(strategy);
    }

    public GlideOptions priority(Priority priority) {
        return super.priority(priority);
    }

    public GlideOptions placeholder(Drawable drawable) {
        return super.placeholder(drawable);
    }

    public GlideOptions placeholder(int id) {
        return super.placeholder(id);
    }

    public GlideOptions fallback(Drawable drawable) {
        return super.fallback(drawable);
    }

    public GlideOptions fallback(int id) {
        return super.fallback(id);
    }

    public GlideOptions error(Drawable drawable) {
        return super.error(drawable);
    }

    public GlideOptions error(int id) {
        return super.error(id);
    }

    public GlideOptions theme(Resources.Theme theme) {
        return super.theme(theme);
    }

    public GlideOptions skipMemoryCache(boolean skip) {
        return super.skipMemoryCache(skip);
    }

    public GlideOptions override(int width, int height) {
        return super.override(width, height);
    }

    public GlideOptions override(int size) {
        return super.override(size);
    }

    public GlideOptions signature(Key key) {
        return super.signature(key);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideOptions m1807clone() {
        return super.clone();
    }

    /* JADX INFO: renamed from: set, reason: collision with other method in class */
    public <Y> GlideOptions m1836set(Option<Y> option, Y y) {
        return super.set(option, y);
    }

    /* JADX INFO: renamed from: decode, reason: collision with other method in class */
    public GlideOptions m1808decode(Class<?> clazz) {
        return super.decode(clazz);
    }

    public GlideOptions encodeFormat(Bitmap.CompressFormat format) {
        return super.encodeFormat(format);
    }

    public GlideOptions encodeQuality(int value) {
        return super.encodeQuality(value);
    }

    public GlideOptions frame(long value) {
        return super.frame(value);
    }

    public GlideOptions format(DecodeFormat format) {
        return super.format(format);
    }

    public GlideOptions disallowHardwareConfig() {
        return super.disallowHardwareConfig();
    }

    public GlideOptions downsample(DownsampleStrategy strategy) {
        return super.downsample(strategy);
    }

    public GlideOptions timeout(int value) {
        return super.timeout(value);
    }

    public GlideOptions optionalCenterCrop() {
        return super.optionalCenterCrop();
    }

    public GlideOptions centerCrop() {
        return super.centerCrop();
    }

    public GlideOptions optionalFitCenter() {
        return super.optionalFitCenter();
    }

    public GlideOptions fitCenter() {
        return super.fitCenter();
    }

    public GlideOptions optionalCenterInside() {
        return super.optionalCenterInside();
    }

    public GlideOptions centerInside() {
        return super.centerInside();
    }

    public GlideOptions optionalCircleCrop() {
        return super.optionalCircleCrop();
    }

    public GlideOptions circleCrop() {
        return super.circleCrop();
    }

    /* JADX INFO: renamed from: transform, reason: collision with other method in class */
    public GlideOptions m1842transform(Transformation<Bitmap> transformation) {
        return super.transform(transformation);
    }

    @SafeVarargs
    /* JADX INFO: renamed from: transform, reason: collision with other method in class */
    public final GlideOptions m1844transform(Transformation<Bitmap>... transformations) {
        return super.transform(transformations);
    }

    @SafeVarargs
    @Deprecated
    /* JADX INFO: renamed from: transforms, reason: collision with other method in class */
    public final GlideOptions m1845transforms(Transformation<Bitmap>... transformations) {
        return super.transforms(transformations);
    }

    /* JADX INFO: renamed from: optionalTransform, reason: collision with other method in class */
    public GlideOptions m1829optionalTransform(Transformation<Bitmap> transformation) {
        return super.optionalTransform(transformation);
    }

    public <Y> GlideOptions optionalTransform(Class<Y> clazz, Transformation<Y> transformation) {
        return super.optionalTransform(clazz, transformation);
    }

    public <Y> GlideOptions transform(Class<Y> clazz, Transformation<Y> transformation) {
        return super.transform(clazz, transformation);
    }

    public GlideOptions dontTransform() {
        return super.dontTransform();
    }

    public GlideOptions dontAnimate() {
        return super.dontAnimate();
    }

    /* JADX INFO: renamed from: apply, reason: collision with other method in class */
    public GlideOptions m1801apply(BaseRequestOptions<?> options) {
        return super.apply(options);
    }

    public GlideOptions lock() {
        return super.lock();
    }

    public GlideOptions autoClone() {
        return super.autoClone();
    }
}
