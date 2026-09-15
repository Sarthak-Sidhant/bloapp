package in.gov.eci.bloapp.views.activity.newsir.network;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class S3Uploader {
    private final OkHttpClient client;

    public interface ProgressListener {
        void onProgress(long transferredBytes, long totalBytes);
    }

    public S3Uploader(Context context) {
        this.client = OkHttpFactory.createDefault(context);
    }

    public Response uploadToPresignedPut(final String presignedUrl, final File file, final String contentType, final ProgressListener progressCallback) throws UploadException {
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        try {
            try {
                Response responseExecute = this.client.newCall(new Request.Builder().url(presignedUrl).put(new ProgressRequestBody(file, MediaType.parse(contentType)) { // from class: in.gov.eci.bloapp.views.activity.newsir.network.S3Uploader.1
                    @Override // in.gov.eci.bloapp.views.activity.newsir.network.ProgressRequestBody
                    protected void onProgress(long transferred, long total) {
                        ProgressListener progressListener = progressCallback;
                        if (progressListener != null) {
                            progressListener.onProgress(transferred, total);
                        }
                    }
                }).build()).execute();
                if (responseExecute.isSuccessful()) {
                    return responseExecute;
                }
                String strString = null;
                try {
                    ResponseBody responseBodyBody = responseExecute.body();
                    if (responseBodyBody != null) {
                        strString = responseBodyBody.string();
                    }
                } catch (IOException unused) {
                }
                throw new UploadException(responseExecute.code(), "Upload failed: HTTP " + responseExecute.code() + " body=" + strString);
            } catch (IOException e) {
                throw new UploadException("IO error during upload: " + e.getMessage(), e);
            }
        } catch (SocketTimeoutException e2) {
            throw new UploadException("Socket timeout: " + e2.getMessage(), e2);
        } catch (SSLHandshakeException e3) {
            throw new UploadException("TLS/Certificate error: " + e3.getMessage(), e3);
        } catch (Exception e4) {
            throw new UploadException("Unexpected error: " + e4.getMessage(), e4);
        }
    }

    public static class UploadException extends Exception {
        private int httpCode;

        public UploadException(String message, Throwable cause) {
            super(message, cause);
            this.httpCode = -1;
        }

        public UploadException(int httpCode, String message) {
            super(message);
            this.httpCode = httpCode;
        }

        public int getHttpCode() {
            return this.httpCode;
        }
    }
}
