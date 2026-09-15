package in.gov.eci.bloapp.utils;

import android.content.Context;
import android.util.Base64;
import android.widget.Toast;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class PdfLoader {
    private static final String TAG = "PdfLoader";

    private PdfLoader() {
    }

    public static void loadFromBase64(Context context, final PDFView pdfView, String base64) {
        final File file;
        if (context == null || pdfView == null || base64 == null) {
            return;
        }
        File file2 = null;
        try {
            byte[] bArrDecode = Base64.decode(base64.replaceAll("\\s+", ""), 0);
            final File file3 = new File(context.getCacheDir(), "input_" + System.currentTimeMillis() + ".pdf");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                try {
                    fileOutputStream.write(bArrDecode);
                    fileOutputStream.close();
                    file = new File(context.getCacheDir(), "flat_" + System.currentTimeMillis() + ".pdf");
                    try {
                        PdfDocument pdfDocument = new PdfDocument(new PdfReader(file3.getAbsolutePath()), new PdfWriter(file.getAbsolutePath()));
                        PdfAcroForm acroForm = PdfAcroForm.getAcroForm(pdfDocument, false);
                        if (acroForm != null) {
                            acroForm.flattenFields();
                        }
                        pdfDocument.close();
                        pdfView.recycle();
                        pdfView.fromFile(file).enableSwipe(true).swipeHorizontal(true).enableAnnotationRendering(true).onLoad(new OnLoadCompleteListener() { // from class: in.gov.eci.bloapp.utils.PdfLoader$$ExternalSyntheticLambda0
                            public final void loadComplete(int i) {
                                PdfLoader.lambda$loadFromBase64$1(file3, pdfView, file, i);
                            }
                        }).onError(new OnErrorListener() { // from class: in.gov.eci.bloapp.utils.PdfLoader$$ExternalSyntheticLambda1
                            public final void onError(Throwable th) {
                                PdfLoader.lambda$loadFromBase64$2(file3, file, th);
                            }
                        }).load();
                    } catch (Exception unused) {
                        file2 = file3;
                        deleteFile(file2);
                        deleteFile(file);
                        Toast.makeText(context, "Unable to display PDF", 1).show();
                    }
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                file = null;
            }
        } catch (Exception unused3) {
            file = null;
        }
    }

    static /* synthetic */ void lambda$loadFromBase64$1(File file, PDFView pDFView, final File file2, int i) {
        deleteFile(file);
        pDFView.postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.utils.PdfLoader$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                PdfLoader.deleteFile(file2);
            }
        }, 3000L);
    }

    static /* synthetic */ void lambda$loadFromBase64$2(File file, File file2, Throwable th) {
        deleteFile(file);
        deleteFile(file2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void deleteFile(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception unused) {
            }
        }
    }
}
