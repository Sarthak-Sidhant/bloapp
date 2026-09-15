package in.gov.eci.bloapp.views.activity.newsir.network;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import java.io.File;
import java.net.URL;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class GlideRequest<TranscodeType> extends RequestBuilder<TranscodeType> implements Cloneable {
    public /* bridge */ /* synthetic */ RequestBuilder apply(BaseRequestOptions options) {
        return m1917apply((BaseRequestOptions<?>) options);
    }

    /* JADX INFO: renamed from: apply, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ BaseRequestOptions m1916apply(BaseRequestOptions options) {
        return m1917apply((BaseRequestOptions<?>) options);
    }

    public /* bridge */ /* synthetic */ BaseRequestOptions decode(Class clazz) {
        return m1925decode((Class<?>) clazz);
    }

    public /* bridge */ /* synthetic */ BaseRequestOptions optionalTransform(Transformation transformation) {
        return m1968optionalTransform((Transformation<Bitmap>) transformation);
    }

    public /* bridge */ /* synthetic */ BaseRequestOptions set(Option option, Object y) {
        return m1975set((Option<Object>) option, y);
    }

    public /* bridge */ /* synthetic */ BaseRequestOptions transform(Transformation transformation) {
        return m1985transform((Transformation<Bitmap>) transformation);
    }

    public /* bridge */ /* synthetic */ BaseRequestOptions transform(Transformation[] transformations) {
        return m1987transform((Transformation<Bitmap>[]) transformations);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ BaseRequestOptions transforms(Transformation[] transformations) {
        return m1988transforms((Transformation<Bitmap>[]) transformations);
    }

    GlideRequest(Class<TranscodeType> transcodeClass, RequestBuilder<?> other) {
        super(transcodeClass, other);
    }

    GlideRequest(Glide glide, RequestManager requestManager, Class<TranscodeType> transcodeClass, Context context) {
        super(glide, requestManager, transcodeClass, context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GlideRequest<File> getDownloadOnlyRequest() {
        return new GlideRequest(File.class, this).m1917apply((BaseRequestOptions<?>) DOWNLOAD_ONLY_OPTIONS);
    }

    public GlideRequest<TranscodeType> sizeMultiplier(float value) {
        return super.sizeMultiplier(value);
    }

    public GlideRequest<TranscodeType> useUnlimitedSourceGeneratorsPool(boolean flag) {
        return super.useUnlimitedSourceGeneratorsPool(flag);
    }

    public GlideRequest<TranscodeType> useAnimationPool(boolean flag) {
        return super.useAnimationPool(flag);
    }

    public GlideRequest<TranscodeType> onlyRetrieveFromCache(boolean flag) {
        return super.onlyRetrieveFromCache(flag);
    }

    public GlideRequest<TranscodeType> diskCacheStrategy(DiskCacheStrategy strategy) {
        return super.diskCacheStrategy(strategy);
    }

    public GlideRequest<TranscodeType> priority(Priority priority) {
        return super.priority(priority);
    }

    public GlideRequest<TranscodeType> placeholder(Drawable drawable) {
        return super.placeholder(drawable);
    }

    public GlideRequest<TranscodeType> placeholder(int id) {
        return super.placeholder(id);
    }

    public GlideRequest<TranscodeType> fallback(Drawable drawable) {
        return super.fallback(drawable);
    }

    public GlideRequest<TranscodeType> fallback(int id) {
        return super.fallback(id);
    }

    public GlideRequest<TranscodeType> error(Drawable drawable) {
        return super.error(drawable);
    }

    public GlideRequest<TranscodeType> error(int id) {
        return super.error(id);
    }

    public GlideRequest<TranscodeType> theme(Resources.Theme theme) {
        return super.theme(theme);
    }

    public GlideRequest<TranscodeType> skipMemoryCache(boolean skip) {
        return super.skipMemoryCache(skip);
    }

    public GlideRequest<TranscodeType> override(int width, int height) {
        return super.override(width, height);
    }

    public GlideRequest<TranscodeType> override(int size) {
        return super.override(size);
    }

    public GlideRequest<TranscodeType> signature(Key key) {
        return super.signature(key);
    }

    /* JADX INFO: renamed from: set, reason: collision with other method in class */
    public <Y> GlideRequest<TranscodeType> m1975set(Option<Y> option, Y y) {
        return super.set(option, y);
    }

    /* JADX INFO: renamed from: decode, reason: collision with other method in class */
    public GlideRequest<TranscodeType> m1925decode(Class<?> clazz) {
        return super.decode(clazz);
    }

    public GlideRequest<TranscodeType> encodeFormat(Bitmap.CompressFormat format) {
        return super.encodeFormat(format);
    }

    public GlideRequest<TranscodeType> encodeQuality(int value) {
        return super.encodeQuality(value);
    }

    public GlideRequest<TranscodeType> frame(long value) {
        return super.frame(value);
    }

    public GlideRequest<TranscodeType> format(DecodeFormat format) {
        return super.format(format);
    }

    public GlideRequest<TranscodeType> disallowHardwareConfig() {
        return super.disallowHardwareConfig();
    }

    public GlideRequest<TranscodeType> downsample(DownsampleStrategy strategy) {
        return super.downsample(strategy);
    }

    public GlideRequest<TranscodeType> timeout(int value) {
        return super.timeout(value);
    }

    public GlideRequest<TranscodeType> optionalCenterCrop() {
        return super.optionalCenterCrop();
    }

    public GlideRequest<TranscodeType> centerCrop() {
        return super.centerCrop();
    }

    public GlideRequest<TranscodeType> optionalFitCenter() {
        return super.optionalFitCenter();
    }

    public GlideRequest<TranscodeType> fitCenter() {
        return super.fitCenter();
    }

    public GlideRequest<TranscodeType> optionalCenterInside() {
        return super.optionalCenterInside();
    }

    public GlideRequest<TranscodeType> centerInside() {
        return super.centerInside();
    }

    public GlideRequest<TranscodeType> optionalCircleCrop() {
        return super.optionalCircleCrop();
    }

    public GlideRequest<TranscodeType> circleCrop() {
        return super.circleCrop();
    }

    /* JADX INFO: renamed from: transform, reason: collision with other method in class */
    public GlideRequest<TranscodeType> m1985transform(Transformation<Bitmap> transformation) {
        return super.transform(transformation);
    }

    /* JADX INFO: renamed from: transform, reason: collision with other method in class */
    public GlideRequest<TranscodeType> m1987transform(Transformation<Bitmap>... transformations) {
        return super.transform(transformations);
    }

    @Deprecated
    /* JADX INFO: renamed from: transforms, reason: collision with other method in class */
    public GlideRequest<TranscodeType> m1988transforms(Transformation<Bitmap>... transformations) {
        return super.transforms(transformations);
    }

    /* JADX INFO: renamed from: optionalTransform, reason: collision with other method in class */
    public GlideRequest<TranscodeType> m1968optionalTransform(Transformation<Bitmap> transformation) {
        return super.optionalTransform(transformation);
    }

    public <Y> GlideRequest<TranscodeType> optionalTransform(Class<Y> clazz, Transformation<Y> transformation) {
        return super.optionalTransform(clazz, transformation);
    }

    public <Y> GlideRequest<TranscodeType> transform(Class<Y> clazz, Transformation<Y> transformation) {
        return super.transform(clazz, transformation);
    }

    public GlideRequest<TranscodeType> dontTransform() {
        return super.dontTransform();
    }

    public GlideRequest<TranscodeType> dontAnimate() {
        return super.dontAnimate();
    }

    public GlideRequest<TranscodeType> lock() {
        return super.lock();
    }

    public GlideRequest<TranscodeType> autoClone() {
        return super.autoClone();
    }

    /* JADX INFO: renamed from: apply, reason: collision with other method in class */
    public GlideRequest<TranscodeType> m1917apply(BaseRequestOptions<?> options) {
        return (GlideRequest) super.apply(options);
    }

    public GlideRequest<TranscodeType> transition(TransitionOptions<?, ? super TranscodeType> options) {
        return (GlideRequest) super.transition(options);
    }

    public GlideRequest<TranscodeType> listener(RequestListener<TranscodeType> listener) {
        return (GlideRequest) super.listener(listener);
    }

    public GlideRequest<TranscodeType> addListener(RequestListener<TranscodeType> listener) {
        return (GlideRequest) super.addListener(listener);
    }

    public GlideRequest<TranscodeType> error(RequestBuilder<TranscodeType> builder) {
        return (GlideRequest) super.error(builder);
    }

    public GlideRequest<TranscodeType> error(Object o) {
        return (GlideRequest) super.error(o);
    }

    public GlideRequest<TranscodeType> thumbnail(RequestBuilder<TranscodeType> builder) {
        return (GlideRequest) super.thumbnail(builder);
    }

    @SafeVarargs
    public final GlideRequest<TranscodeType> thumbnail(RequestBuilder<TranscodeType>... builders) {
        return (GlideRequest) super.thumbnail(builders);
    }

    public GlideRequest<TranscodeType> thumbnail(List<RequestBuilder<TranscodeType>> list) {
        return (GlideRequest) super.thumbnail(list);
    }

    @Deprecated
    public GlideRequest<TranscodeType> thumbnail(float sizeMultiplier) {
        return (GlideRequest) super.thumbnail(sizeMultiplier);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<TranscodeType> m1958load(Object o) {
        return (GlideRequest) super.load(o);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<TranscodeType> m1953load(Bitmap bitmap) {
        return (GlideRequest) super.load(bitmap);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<TranscodeType> m1954load(Drawable drawable) {
        return (GlideRequest) super.load(drawable);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<TranscodeType> m1959load(String string) {
        return (GlideRequest) super.load(string);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<TranscodeType> m1955load(Uri uri) {
        return (GlideRequest) super.load(uri);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<TranscodeType> m1956load(File file) {
        return (GlideRequest) super.load(file);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<TranscodeType> m1957load(Integer id) {
        return (GlideRequest) super.load(id);
    }

    @Deprecated
    /* JADX INFO: renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<TranscodeType> m1960load(URL url) {
        return (GlideRequest) super.load(url);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<TranscodeType> m1961load(byte[] bytes) {
        return (GlideRequest) super.load(bytes);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<TranscodeType> m1924clone() {
        return (GlideRequest) super.clone();
    }
}
