package in.gov.eci.bloapp.views.activity.newsir.network;

import java.io.File;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public abstract class ProgressRequestBody extends RequestBody {
    private final MediaType contentType;
    private final File file;

    protected abstract void onProgress(long transferred, long total);

    public ProgressRequestBody(File file, MediaType contentType) {
        this.file = file;
        this.contentType = contentType;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.file.length();
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: contentType */
    public MediaType get$contentType() {
        return this.contentType;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws IOException {
        long jContentLength = contentLength();
        Source source = null;
        try {
            source = Okio.source(this.file);
            long j = 0;
            while (true) {
                long j2 = source.read(sink.getBufferField(), 8192L);
                if (j2 == -1) {
                    break;
                }
                sink.flush();
                j += j2;
                onProgress(j, jContentLength);
            }
            if (source != null) {
                source.close();
            }
        } catch (Throwable th) {
            if (source != null) {
                source.close();
            }
            throw th;
        }
    }
}
