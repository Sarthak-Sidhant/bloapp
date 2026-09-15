package in.gov.eci.bloapp.views.activity.newsir.network;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class UploadCallerNewPdf {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    public void uploadFileInBackground(final Context context, final String presignedUrl, final File file, final ValidationEFCallback validationEFCallback) {
        this.executor.execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.network.UploadCallerNewPdf$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$uploadFileInBackground$4(context, presignedUrl, file, validationEFCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadFileInBackground$4(Context context, String str, File file, final ValidationEFCallback validationEFCallback) {
        try {
            Response responseUploadToPresignedPut = new S3Uploader(context).uploadToPresignedPut(str, file, "application/pdf", new S3Uploader.ProgressListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.network.UploadCallerNewPdf$$ExternalSyntheticLambda1
                @Override // in.gov.eci.bloapp.views.activity.newsir.network.S3Uploader.ProgressListener
                public final void onProgress(long j, long j2) {
                    this.f$0.lambda$uploadFileInBackground$1(j, j2);
                }
            });
            try {
                final int iCode = responseUploadToPresignedPut.code();
                this.mainHandler.post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.network.UploadCallerNewPdf$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        UploadCallerNewPdf.lambda$uploadFileInBackground$2(validationEFCallback, iCode);
                    }
                });
            } finally {
                if (responseUploadToPresignedPut.body() != null) {
                    responseUploadToPresignedPut.body().close();
                }
            }
        } catch (S3Uploader.UploadException e) {
            this.mainHandler.post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.network.UploadCallerNewPdf$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    UploadCallerNewPdf.lambda$uploadFileInBackground$3(validationEFCallback, e);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadFileInBackground$1(long j, long j2) {
        final int i = j2 > 0 ? (int) ((j * 100) / j2) : -1;
        this.mainHandler.post(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.newsir.network.UploadCallerNewPdf$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                System.out.println("Progress UI: " + i + "%");
            }
        });
    }

    static /* synthetic */ void lambda$uploadFileInBackground$2(ValidationEFCallback validationEFCallback, int i) {
        validationEFCallback.onResult(true, "");
        System.out.println("Upload success. HTTP " + i);
    }

    static /* synthetic */ void lambda$uploadFileInBackground$3(ValidationEFCallback validationEFCallback, S3Uploader.UploadException uploadException) {
        validationEFCallback.onResult(false, uploadException.getMessage());
        System.out.println("UPLOAD ERROR: " + uploadException.getMessage());
        uploadException.printStackTrace();
    }
}
