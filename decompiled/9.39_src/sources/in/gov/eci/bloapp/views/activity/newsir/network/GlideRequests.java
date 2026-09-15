package in.gov.eci.bloapp.views.activity.newsir.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;
import java.net.URL;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class GlideRequests extends RequestManager {
    public /* bridge */ /* synthetic */ RequestManager addDefaultRequestListener(RequestListener listener) {
        return m1925addDefaultRequestListener((RequestListener<Object>) listener);
    }

    public GlideRequests(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode treeNode, Context context) {
        super(glide, lifecycle, treeNode, context);
    }

    public <ResourceType> GlideRequest<ResourceType> as(Class<ResourceType> resourceClass) {
        return new GlideRequest<>(this.glide, this, resourceClass, this.context);
    }

    public synchronized GlideRequests applyDefaultRequestOptions(RequestOptions options) {
        return (GlideRequests) super.applyDefaultRequestOptions(options);
    }

    public synchronized GlideRequests setDefaultRequestOptions(RequestOptions options) {
        return (GlideRequests) super.setDefaultRequestOptions(options);
    }

    public synchronized GlideRequests clearOnStop() {
        return (GlideRequests) super.clearOnStop();
    }

    /* JADX INFO: renamed from: addDefaultRequestListener, reason: collision with other method in class */
    public GlideRequests m1925addDefaultRequestListener(RequestListener<Object> listener) {
        return (GlideRequests) super.addDefaultRequestListener(listener);
    }

    public GlideRequest<Bitmap> asBitmap() {
        return (GlideRequest) super.asBitmap();
    }

    public GlideRequest<GifDrawable> asGif() {
        return (GlideRequest) super.asGif();
    }

    public GlideRequest<Drawable> asDrawable() {
        return (GlideRequest) super.asDrawable();
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<Drawable> m1944load(Bitmap bitmap) {
        return (GlideRequest) super.load(bitmap);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<Drawable> m1945load(Drawable drawable) {
        return (GlideRequest) super.load(drawable);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<Drawable> m1950load(String string) {
        return (GlideRequest) super.load(string);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<Drawable> m1946load(Uri uri) {
        return (GlideRequest) super.load(uri);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<Drawable> m1947load(File file) {
        return (GlideRequest) super.load(file);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<Drawable> m1948load(Integer id) {
        return (GlideRequest) super.load(id);
    }

    @Deprecated
    /* JADX INFO: renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<Drawable> m1951load(URL url) {
        return (GlideRequest) super.load(url);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<Drawable> m1952load(byte[] bytes) {
        return (GlideRequest) super.load(bytes);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public GlideRequest<Drawable> m1949load(Object o) {
        return (GlideRequest) super.load(o);
    }

    public GlideRequest<File> downloadOnly() {
        return (GlideRequest) super.downloadOnly();
    }

    public GlideRequest<File> download(Object o) {
        return (GlideRequest) super.download(o);
    }

    public GlideRequest<File> asFile() {
        return (GlideRequest) super.asFile();
    }

    protected void setRequestOptions(RequestOptions toSet) {
        if (toSet instanceof GlideOptions) {
            super.setRequestOptions(toSet);
        } else {
            super.setRequestOptions(new GlideOptions().m1801apply((BaseRequestOptions<?>) toSet));
        }
    }
}
