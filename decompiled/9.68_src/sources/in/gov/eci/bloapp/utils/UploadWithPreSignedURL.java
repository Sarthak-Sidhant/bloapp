package in.gov.eci.bloapp.utils;

import android.os.Build;
import android.util.Log;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidationCallback;
import in.gov.eci.bloapp.views.activity.newsir.callback.ValidationEFCallback;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class UploadWithPreSignedURL {
    private static final int CONNECT_TIMEOUT_SEC = 30;
    private static final long INITIAL_BACKOFF_MS = 800;
    private static final int MAX_RETRIES = 3;
    private static final int READ_TIMEOUT_SEC = 60;
    private static final String TAG = "S3Uploader";
    private static final int WRITE_TIMEOUT_SEC = 60;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isRetryableHttp(int code) {
        return code == 429 || (code >= 500 && code < 600);
    }

    public static String getMD5Checksum(File file) {
        String strEncodeToString;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                if (Build.VERSION.SDK_INT >= 33) {
                    strEncodeToString = Base64.getEncoder().encodeToString(messageDigest.digest(fileInputStream.readAllBytes()));
                } else {
                    strEncodeToString = Base64.getEncoder().encodeToString(messageDigest.digest(toByteArray(fileInputStream)));
                }
                fileInputStream.close();
                return strEncodeToString;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = input.read(bArr, 0, 1024);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static String decryptUrl(String cipherText) {
        try {
            String strDecrypt = decrypt("AES/GCM/NoPadding", cipherText, convertStringToSecretKey("P79vtNtk/WZaAXsQKCHClA=="), generateGcm());
            if (strDecrypt.length() < 20 || strDecrypt == null) {
                return null;
            }
            return strDecrypt.substring(14, strDecrypt.length() - 6);
        } catch (Exception unused) {
            System.out.println("decryption failed");
            return null;
        }
    }

    private static SecretKey convertStringToSecretKey(String encodedKey) {
        byte[] bArrDecode = Base64.getDecoder().decode(encodedKey);
        return new SecretKeySpec(bArrDecode, 0, bArrDecode.length, "AES");
    }

    private static String decrypt(String algorithm, String cipherText, SecretKey key, GCMParameterSpec gcmParameterSpec) {
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(2, key, gcmParameterSpec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(cipherText)));
        } catch (Exception unused) {
            return null;
        }
    }

    private static GCMParameterSpec generateGcm() {
        return new GCMParameterSpec(128, new byte[16]);
    }

    public static void uploadToS3(String filePath, String mime, String preSignedUrl, final ValidationCallback validationCallback) {
        new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).build().newCall(new Request.Builder().url(preSignedUrl).put(RequestBody.create(new File(filePath), MediaType.parse(mime))).build()).enqueue(new Callback() { // from class: in.gov.eci.bloapp.utils.UploadWithPreSignedURL.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                validationCallback.onResult(false);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    Logger.d("S3", "Upload successful");
                    validationCallback.onResult(true);
                } else {
                    Logger.e("S3", "S3 error: " + response.code());
                    validationCallback.onResult(false);
                }
            }
        });
    }

    public static void uploadToS3Ef(String filePath, String mime, String preSignedUrl, final ValidationEFCallback validationCallback) {
        new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).build().newCall(new Request.Builder().url(preSignedUrl).put(RequestBody.create(new File(filePath), MediaType.parse(mime))).build()).enqueue(new Callback() { // from class: in.gov.eci.bloapp.utils.UploadWithPreSignedURL.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                validationCallback.onResult(false, e.getMessage());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    Logger.d("S3", "Upload successful");
                    validationCallback.onResult(true, "");
                } else {
                    Logger.e("S3", "S3 error: " + response.code());
                    validationCallback.onResult(false, response.code() + "");
                }
            }
        });
    }

    public static void uploadToS3Ef1(String filePath, String mime, String preSignedUrl, ValidationEFCallback validationCallback) {
        File file = new File(filePath);
        if (!file.exists()) {
            validationCallback.onResult(false, "File not found: " + filePath);
            return;
        }
        if (!file.isFile()) {
            validationCallback.onResult(false, "Path is not a file: " + filePath);
            return;
        }
        if (!file.canRead()) {
            validationCallback.onResult(false, "Cannot read file: " + filePath);
            return;
        }
        try {
            enqueueWithRetry(new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).writeTimeout(60L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS).build(), new Request.Builder().url(preSignedUrl).put(RequestBody.create(file, MediaType.parse(mime))).build(), validationCallback, 1);
        } catch (Throwable unused) {
            validationCallback.onResult(false, "Invalid MIME type: " + mime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void enqueueWithRetry(final OkHttpClient client, final Request request, final ValidationEFCallback callback, final int attempt) {
        client.newCall(request).enqueue(new Callback() { // from class: in.gov.eci.bloapp.utils.UploadWithPreSignedURL.3
            @Override // okhttp3.Callback
            public void onFailure(Call c, IOException e) {
                String strClassifyIOException = UploadWithPreSignedURL.classifyIOException(e);
                Log.e(UploadWithPreSignedURL.TAG, "Upload failed (attempt " + (attempt + 1) + "): " + strClassifyIOException, e);
                if (attempt < 3 && UploadWithPreSignedURL.isRetryableException(e)) {
                    long jBackoffMs = UploadWithPreSignedURL.backoffMs(attempt);
                    Log.w(UploadWithPreSignedURL.TAG, "Retrying after " + jBackoffMs + " ms ...");
                    UploadWithPreSignedURL.sleepQuietly(jBackoffMs);
                    UploadWithPreSignedURL.enqueueWithRetry(client, request, callback, attempt + 1);
                    return;
                }
                callback.onResult(false, strClassifyIOException);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call c, Response response) {
                try {
                    int iCode = response.code();
                    String strSafeBodyString = UploadWithPreSignedURL.safeBodyString(response);
                    if (response.isSuccessful()) {
                        Log.d(UploadWithPreSignedURL.TAG, "S3 upload successful. HTTP " + iCode);
                        callback.onResult(true, "");
                        try {
                            response.close();
                            return;
                        } catch (Throwable unused) {
                            return;
                        }
                    }
                    String strClassifyHttpError = UploadWithPreSignedURL.classifyHttpError(iCode, strSafeBodyString);
                    if (attempt >= 3 || !UploadWithPreSignedURL.isRetryableHttp(iCode)) {
                        callback.onResult(false, strClassifyHttpError);
                    } else {
                        long jBackoffMs = UploadWithPreSignedURL.backoffMs(attempt);
                        Log.w(UploadWithPreSignedURL.TAG, "HTTP " + iCode + " – retrying after " + jBackoffMs + " ms ...");
                        UploadWithPreSignedURL.sleepQuietly(jBackoffMs);
                        UploadWithPreSignedURL.enqueueWithRetry(client, request, callback, attempt + 1);
                    }
                } catch (Throwable th) {
                    try {
                        Log.e(UploadWithPreSignedURL.TAG, "Unexpected error handling response", th);
                        callback.onResult(false, "Unexpected response handling error: " + th.getMessage());
                    } finally {
                        try {
                            response.close();
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isRetryableException(IOException e) {
        return (e instanceof SocketTimeoutException) || (e instanceof UnknownHostException) || (e instanceof InterruptedIOException) || ((e instanceof SSLException) && !(e instanceof SSLHandshakeException));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long backoffMs(int attempt) {
        return ((long) (Math.pow(2.0d, attempt) * 800.0d)) + ((long) (Math.random() * 250.0d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sleepQuietly(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String classifyIOException(IOException e) {
        if (e instanceof UnknownHostException) {
            return "Network/DNS error: unable to resolve host.";
        }
        if (e instanceof SocketTimeoutException) {
            return "Timeout: the server took too long to respond.";
        }
        if (e instanceof SSLHandshakeException) {
            return "SSL handshake failed: certificate or TLS mismatch.";
        }
        if (e instanceof SSLException) {
            return "SSL/TLS error during upload.";
        }
        if (e instanceof InterruptedIOException) {
            return "I/O interrupted or timed out.";
        }
        return "I/O error: " + e.getMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String classifyHttpError(int code, String body) {
        if (code == 400) {
            return "400 Bad Request: malformed request or body.\n" + shortBody(body);
        }
        if (code == 401) {
            return "401 Unauthorized: credentials invalid.\n" + shortBody(body);
        }
        if (code == 403) {
            return "403 Forbidden: presigned URL invalid/expired or headers mismatch.\n" + shortBody(body);
        }
        if (code == 404) {
            return "404 Not Found: bucket/key not found.\n" + shortBody(body);
        }
        if (code == 409) {
            return "409 Conflict.\n" + shortBody(body);
        }
        if (code == 412) {
            return "412 Precondition Failed (e.g., ETag mismatch).\n" + shortBody(body);
        }
        if (code == 429) {
            return "429 Too Many Requests: throttled.\n" + shortBody(body);
        }
        if (code >= 500 && code < 600) {
            return code + " Server error: S3/endpoint issue.\n" + shortBody(body);
        }
        return code + " HTTP error.\n" + shortBody(body);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String safeBodyString(Response response) {
        String strString;
        try {
            return (response.body() == null || (strString = response.body().string()) == null) ? "" : strString;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String shortBody(String body) {
        if (body == null) {
            return "";
        }
        String strTrim = body.trim();
        return strTrim.length() <= 512 ? strTrim : strTrim.substring(0, 512) + " ...";
    }
}
