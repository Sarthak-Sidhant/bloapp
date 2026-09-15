package in.gov.eci.bloapp.views.activity.sir;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.bumptech.glide.Glide;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MultipleString;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityViewFormByAeropage1Binding;
import in.gov.eci.bloapp.pdfDownloadCallback;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.Verhoeff;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.SuperBaseActivity;
import in.gov.eci.bloapp.views.activity.sir.formdatanew.FormDataForBloModificationList;
import in.gov.eci.bloapp.views.customviews.TouchImageView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ViewFormByAEROPage1 extends SuperBaseActivity {
    ArrayList<String> List8docCode;
    ArrayList<String> List8docName;
    String aadharNoS;
    AlertDialog alertDialog;
    String asmblyNO;
    private String atkband;
    private ActivityViewFormByAeropage1Binding binding;
    byte[] byteArray;
    String citizenshipCat;
    String citizenshipTypeS;
    String dob;
    String dobVerified;
    String documentUploadedFlg;
    String electorName;
    String epicNoS;
    String fatherEpicS;
    String fatherNameS;
    protected long filesize;
    Intent intent;
    String mobileNoS;
    String motherEpicS;
    String motherNameS;
    int newRadioId;
    String partNo;
    String partNoS;
    private JsonObject payloadData1;
    private byte[] pdfbyteArray;
    int radioName;
    String referenceNo;
    private String refreshToken;
    ArrayList<String> relationCodeSpinnerVal;
    ArrayList<String> relationNameSpinnerVal;
    private String rtkband;
    protected String saveImageFileName;
    String spouseEpicS;
    String spouseNameS;
    String state;
    String temp;
    private String token;
    String uploadFlag;
    final Calendar dobcalendar = Calendar.getInstance();
    String preSignedurl1 = "";
    String preSignedurl2 = "";
    String preSignedurl3 = "";
    String preSignedurl4 = "";
    String preSignedurl11 = "";
    String preSignedurl21 = "";
    String preSignedurl31 = "";
    String preSignedurl41 = "";
    String filerefphoto = "";
    CommomUtility commomUtility = new CommomUtility();
    String objectStorageString = "objectstorage";
    String TAG = "ViewFormByAEROPage1";
    String fileNotFoundMessage = "आप फिलहाल लो नेटवर्क क्षेत्र में हैं। कृपया बेहतर नेटवर्क कनेक्शन से जुड़ें या दोबारा प्रयास करें। \n\nWeak network detected. Please check your connection and try again.";
    String SESSION = "";
    String comingTag = "coming in onFailure";
    String messageString = "message";
    String noDataString = "No Data Found";
    String alertText = "";
    String cancel = "";
    String takephoto = "";
    String upload = "Please upload file again.";
    String imageTextBaseActivity = "image";
    String garudaTextBaseActivity = "GARUDA";
    String invalidaadhar = "";
    private String aadharref = null;
    private boolean result = false;
    String pdfTextBaseActivity = ".pdf";
    String fileNameTextBaseActivity = "fileName";
    String jpgTextBaseActivity = ".jpg";
    String whitecolor = "#000000";
    private String photoref = null;
    private String annexRef = null;
    String greycolor = "#99000000";
    String blackColor = "#000000";
    String photostr = "Photo";
    String img = "image";
    private String submitFlag = null;
    int photocount = 0;
    int photo1count = 0;
    int photo2count = 0;
    String imgmsg = "";
    String annexureStr = "Annexure";
    String photo1Str = " Photo1 Annexure";
    String photo2str = "Photo2 Annexure";
    String filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    String functionNameForLogBaseActivity = "";
    String photoUrlS = "";
    String srFormPage1UrlS = "";
    String srFormPage2UrlS = "";
    String relationType = "";
    String annexureCUrlS = "";
    String bloOverridenFlgS = "";
    String supportingDocumentPage1UrlS = "";
    String supportingDocumentPage2UrlS = "";
    ArrayList<String> relationList = new ArrayList<>();
    String selectRelationType = "";
    String photo1strNew = "EnumerationFormPage1";
    String photo2strNew = "EnumerationFormPage2";
    String photo3strNew = "SupportingDocumentPage1";
    String photo4strNew = "SupportingDocumentPage2";
    String relativeDocument1UrlS = "";
    String relativeDocument2UrlS = "";
    String relativeSupportingDocumentPage1UrlS = "";
    String relativeSupportingDocumentPage2UrlS = "";
    String relationOldAcS = "";
    String relationOldPartS = "";
    String relationOldPSLS = "";
    String relationlist8DocS = "";
    String relationIs2003 = "";
    int photo1countNew = 0;
    int photo2countNew = 0;
    int photo3countNew = 0;
    int photo4countNew = 0;
    Gson gson = new GsonBuilder().setLenient().create();
    String selectDocumentType = "";
    String relationCode = "";
    String list8code = "";
    boolean isUserAction = false;
    File file1 = null;
    File file2 = null;
    File file3 = null;
    File file4 = null;
    File file11 = null;
    File file21 = null;
    File file31 = null;
    File file41 = null;

    /* JADX WARN: Failed to calculate best type for var: r0v132 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v132 ??, new type: java.util.Calendar
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v132 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v132 ??, new type: java.util.Calendar
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v379 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v379 ??, new type: android.widget.RadioButton
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v379 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v379 ??, new type: android.widget.RadioButton
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v404 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v404 ??, new type: android.widget.RadioButton
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v404 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v404 ??, new type: android.widget.RadioButton
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v418 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v418 ??, new type: android.widget.RadioButton
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v418 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v418 ??, new type: android.widget.RadioButton
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v433 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v433 ??, new type: android.widget.RadioButton
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v433 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v433 ??, new type: android.widget.RadioButton
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v33 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v33 ??, new type: java.util.Calendar
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v33 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v33 ??, new type: java.util.Calendar
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v33 java.util.Calendar, new type: java.util.Calendar
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.applyResolvedVars(TypeSearch.java:100)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:76)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.runMultiVariableSearch(FixTypesVisitor.java:119)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 5 more
     */
    @Override // in.gov.eci.bloapp.views.activity.SuperBaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        int i;
        int i2;
        int i3;
        super.onCreate(savedInstanceState);
        ActivityViewFormByAeropage1Binding activityViewFormByAeropage1BindingInflate = ActivityViewFormByAeropage1Binding.inflate(getLayoutInflater());
        this.binding = activityViewFormByAeropage1BindingInflate;
        setContentView(activityViewFormByAeropage1BindingInflate.getRoot());
        this.SESSION = getString(R.string.sessionMsg);
        this.alertText = getString(R.string.alertMsg);
        this.cancel = getString(R.string.cancelMsg);
        this.takephoto = getString(R.string.takePhotoMsg);
        this.invalidaadhar = getString(R.string.invalidAadharMsg);
        this.imgmsg = getString(R.string.fileNotObtainedMsg);
        this.selectRelationType = getString(R.string.selectRelationMsg);
        this.selectDocumentType = getString(R.string.selectDocumentMsg);
        setRelationList();
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        initClickListener();
        this.binding.submitLayout.setVisibility(8);
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.partNoS = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        this.binding.dateOfBirth.setEnabled(false);
        this.binding.aadharNumber.setEnabled(false);
        this.binding.mobileNumber.setEnabled(false);
        this.binding.fatherEpicNumber.setEnabled(false);
        this.binding.motherEpicNumber.setEnabled(false);
        this.binding.spouseEpicNumber.setEnabled(false);
        Intent intent = getIntent();
        this.intent = intent;
        this.dob = intent.getStringExtra("dob");
        this.epicNoS = this.intent.getStringExtra("epic");
        this.aadharNoS = this.intent.getStringExtra("aadharNo");
        this.mobileNoS = this.intent.getStringExtra("mobileNo");
        this.fatherNameS = this.intent.getStringExtra("fatherName");
        this.fatherEpicS = this.intent.getStringExtra("fatherEpic");
        this.motherNameS = this.intent.getStringExtra("motherName");
        this.motherEpicS = this.intent.getStringExtra("motherEpic");
        this.spouseNameS = this.intent.getStringExtra("spouseName");
        this.spouseEpicS = this.intent.getStringExtra("spouseEpic");
        this.photoUrlS = this.intent.getStringExtra("photoUrl");
        this.annexureCUrlS = this.intent.getStringExtra("annexureCUrl");
        this.srFormPage1UrlS = this.intent.getStringExtra("srFormPage1Url");
        this.srFormPage2UrlS = this.intent.getStringExtra("srFormPage2Url");
        this.citizenshipTypeS = this.intent.getStringExtra("citizenshipType");
        this.citizenshipCat = this.intent.getStringExtra("citizenshipTypeCat");
        this.documentUploadedFlg = this.intent.getStringExtra("documentUploadedFlg");
        this.electorName = this.intent.getStringExtra("electorName");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/YYYY");
        this.relativeDocument1UrlS = TextUtils.isEmpty(this.intent.getStringExtra("relationProofDocUrlPg1")) ? "" : this.intent.getStringExtra("relationProofDocUrlPg1");
        this.relativeDocument2UrlS = TextUtils.isEmpty(this.intent.getStringExtra("relationProofDocUrlPg2")) ? "" : this.intent.getStringExtra("relationProofDocUrlPg2");
        this.relativeSupportingDocumentPage1UrlS = TextUtils.isEmpty(this.intent.getStringExtra("relationList8DocsPage1")) ? "" : this.intent.getStringExtra("relationList8DocsPage1");
        this.relativeSupportingDocumentPage2UrlS = TextUtils.isEmpty(this.intent.getStringExtra("relationList8DocsPage2")) ? "" : this.intent.getStringExtra("relationList8DocsPage2");
        this.relationOldAcS = TextUtils.isEmpty(this.intent.getStringExtra("relationOldAcNo")) ? "" : this.intent.getStringExtra("relationOldAcNo");
        this.relationOldPartS = TextUtils.isEmpty(this.intent.getStringExtra("relationOldPartNo")) ? "" : this.intent.getStringExtra("relationOldPartNo");
        this.relationOldPSLS = TextUtils.isEmpty(this.intent.getStringExtra("relationOldPartSerialNo")) ? "" : this.intent.getStringExtra("relationOldPartSerialNo");
        this.relationlist8DocS = TextUtils.isEmpty(this.intent.getStringExtra("relationListList8DocCode")) ? "" : this.intent.getStringExtra("relationListList8DocCode");
        this.relationIs2003 = TextUtils.isEmpty(this.intent.getStringExtra("relation2003YesOrNo")) ? "" : this.intent.getStringExtra("relation2003YesOrNo");
        String stringExtra = TextUtils.isEmpty(this.intent.getStringExtra("relationType")) ? "" : this.intent.getStringExtra("relationType");
        this.relationCode = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            this.binding.spinnerRelation.setVisibility(8);
        } else if (this.relationCode.equalsIgnoreCase("SELF")) {
            this.relationCode = "";
        }
        this.List8docCode = SharedPref.getInstance(this).getList8Code(Constants.LIST8_CODE);
        this.List8docName = SharedPref.getInstance(this).getList8Name(Constants.LIST8_NAME);
        this.relationCodeSpinnerVal = SharedPref.getInstance(this).getRelativeListCode(Constants.RELATIVE_LIST_CODE);
        this.relationNameSpinnerVal = SharedPref.getInstance(this).getRelativeListName(Constants.RELATIVE_LIST_NAME);
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.List8docName);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.spinnerIR.setAdapter((SpinnerAdapter) arrayAdapter);
        if (this.citizenshipCat.equals("CAT-2") || this.citizenshipCat.equals("CAT-3") || this.citizenshipCat.equals("CAT-4")) {
            this.binding.categoryNameLL.setVisibility(0);
            if (this.citizenshipCat.equals("CAT-2")) {
                this.binding.categoryName.setText(getString(R.string.before_1987));
            } else if (this.citizenshipCat.equals("CAT-3")) {
                this.binding.categoryName.setText(getString(R.string.before_2004));
            } else if (this.citizenshipCat.equals("CAT-4")) {
                this.binding.categoryName.setText(getString(R.string.after_2004));
            }
        } else {
            this.binding.categoryNameLL.setVisibility(8);
        }
        ArrayAdapter arrayAdapter2 = new ArrayAdapter((Context) this, R.layout.blo_spinner_dropdown, (List) this.relationNameSpinnerVal);
        arrayAdapter2.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
        this.binding.spinnerRelation.setAdapter((SpinnerAdapter) arrayAdapter2);
        if (this.intent.getStringExtra("relationType") == null || Objects.equals(this.intent.getStringExtra("relationType"), "") || ((String) Objects.requireNonNull(this.intent.getStringExtra("relationType"))).equalsIgnoreCase("Self")) {
            this.binding.spinnerRelation.setSelection(0);
            this.binding.spinnerRelation.setVisibility(8);
            this.binding.relativeTypeTV.setVisibility(8);
        } else {
            this.binding.spinnerRelation.setSelection(this.relationCodeSpinnerVal.indexOf(this.intent.getStringExtra("relationType")));
        }
        if (this.intent.getStringExtra("relationListList8DocCode") == null || this.intent.getStringExtra("relationListList8DocCode").equals("")) {
            this.binding.spinnerIR.setSelection(0);
            this.binding.spinnerIR.setVisibility(8);
            this.binding.documentTypeTV.setVisibility(8);
        } else {
            this.binding.spinnerIR.setSelection(this.List8docCode.indexOf(this.intent.getStringExtra("relationListList8DocCode")));
        }
        if (TextUtils.isEmpty(this.intent.getStringExtra("relativeEpic"))) {
            this.binding.txtRelativeEpic.setVisibility(8);
            this.binding.edtRelativeEpic.setVisibility(8);
        } else {
            this.binding.edtRelativeEpic.setText(this.intent.getStringExtra("relativeEpic"));
        }
        if (TextUtils.isEmpty(this.relationIs2003)) {
            this.binding.relativeFullLL.setVisibility(8);
        } else if (this.relationIs2003.equals("Y")) {
            this.binding.relative2003Yes.setChecked(true);
            this.binding.relative2003No.setVisibility(8);
            this.binding.relative2003LL.setVisibility(0);
            this.binding.oldACSerialPSLNoLL.setVisibility(0);
            this.binding.oldAcNo.setText(this.relationOldAcS);
            this.binding.oldPartNo.setText(this.relationOldPartS);
            this.binding.oldPslNo.setText(this.relationOldPSLS);
            if (TextUtils.isEmpty(this.relationOldAcS) || this.binding.oldAcNo.getText().toString().isEmpty()) {
                this.binding.oldACSerialPSLNoLL.setVisibility(8);
                this.binding.heading2003.setVisibility(8);
            }
            this.binding.relative2003Yes.setTextColor(-16777216);
        } else if (this.relationIs2003.equals("N")) {
            this.binding.relative2003No.setChecked(true);
            this.binding.relative2003Yes.setChecked(false);
            this.binding.relative2003Yes.setVisibility(8);
            this.binding.relative2003LL.setVisibility(8);
            this.binding.oldACSerialPSLNoLL.setVisibility(8);
            this.binding.relative2003No.setTextColor(-16777216);
        }
        this.binding.formCreatedBy.setText(TextUtils.isEmpty(this.electorName) ? "" : this.intent.getStringExtra("electorName"));
        try {
            String str = this.dob;
            if (str != null) {
                this.dob = simpleDateFormat2.format(simpleDateFormat.parse(str));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(this.aadharNoS)) {
            this.binding.aadharNumber.setText("");
            this.binding.linearAadharLayout.setVisibility(8);
        } else {
            this.commomUtility.getaadhar1(this, this.state, this.token, this.aadharNoS, this.atkband, this.rtkband, "sentBackTOAERO", new MultipleString() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda20
                @Override // in.gov.eci.bloapp.MultipleString
                public final void onCallBack(String str2, String str3) {
                    this.f$0.lambda$onCreate$0(str2, str3);
                }
            });
        }
        if (TextUtils.isEmpty(this.mobileNoS)) {
            this.binding.mobileNumber.setText("");
            this.binding.linearMobileNumber.setVisibility(8);
        } else {
            this.binding.mobileNumber.setText(this.mobileNoS);
        }
        if (TextUtils.isEmpty(this.fatherEpicS)) {
            this.binding.fatherEpicNumber.setText("");
            this.binding.linearFatherEpic.setVisibility(8);
        } else {
            this.binding.fatherEpicNumber.setText(this.fatherEpicS);
        }
        if (TextUtils.isEmpty(this.motherEpicS)) {
            this.binding.motherEpicNumber.setText("");
            this.binding.linearMotherEpic.setVisibility(8);
        } else {
            this.binding.motherEpicNumber.setText(this.motherEpicS);
        }
        if (TextUtils.isEmpty(this.spouseEpicS)) {
            this.binding.spouseEpicNumber.setText("");
            this.binding.linearSpouse.setVisibility(8);
        } else {
            this.binding.spouseEpicNumber.setText(this.spouseEpicS);
        }
        if (this.dob == null) {
            this.binding.dateOfBirth.setText("");
            this.binding.linearDob.setVisibility(8);
        } else {
            this.binding.dateOfBirth.setText(this.dob);
        }
        if (!TextUtils.isEmpty(this.citizenshipTypeS)) {
            if (this.citizenshipCat.equals("CAT-1")) {
                this.binding.indianWithPriorVoterID.setChecked(true);
                this.radioName = R.id.indianWithPriorVoterID;
                this.binding.indianWithPriorVoterID.setTextColor(-16777216);
                this.binding.bornInIndia.setVisibility(8);
                this.binding.notBornInIndia.setVisibility(8);
                this.binding.indianCitizen.setVisibility(8);
                this.binding.noDocument.setVisibility(8);
            } else if (this.citizenshipCat.equals("CAT-2") || this.citizenshipCat.equals("CAT-3") || this.citizenshipCat.equals("CAT-4")) {
                this.binding.bornInIndia.setChecked(r7);
                this.radioName = R.id.bornInIndia;
                this.binding.bornInIndia.setTextColor(-16777216);
                this.binding.bornInIndia.setVisibility(0);
                this.binding.notBornInIndia.setVisibility(8);
                this.binding.indianCitizen.setVisibility(8);
                this.binding.noDocument.setVisibility(8);
                this.binding.indianWithPriorVoterID.setVisibility(8);
            } else if (this.citizenshipCat.equals("CAT-5")) {
                this.binding.notBornInIndia.setChecked(r7);
                this.radioName = R.id.notBornInIndia;
                this.binding.notBornInIndia.setTextColor(-16777216);
                this.binding.notBornInIndia.setVisibility(0);
                this.binding.bornInIndia.setVisibility(8);
                this.binding.indianCitizen.setVisibility(8);
                this.binding.noDocument.setVisibility(8);
                this.binding.indianWithPriorVoterID.setVisibility(8);
            } else if (this.citizenshipCat.equals("CAT-6")) {
                this.binding.indianCitizen.setChecked(r7);
                this.radioName = R.id.indianCitizen;
                this.binding.indianCitizen.setTextColor(-16777216);
                this.binding.indianCitizen.setVisibility(0);
                this.binding.notBornInIndia.setVisibility(8);
                this.binding.bornInIndia.setVisibility(8);
                this.binding.noDocument.setVisibility(8);
                this.binding.indianWithPriorVoterID.setVisibility(8);
            } else if (this.documentUploadedFlg.equals("N")) {
                this.binding.noDocument.setChecked(r7);
                this.binding.noDocument.setTextColor(-16777216);
                this.binding.noDocument.setVisibility(0);
                this.binding.notBornInIndia.setVisibility(8);
                this.binding.bornInIndia.setVisibility(8);
                this.binding.indianCitizen.setVisibility(8);
                this.binding.indianWithPriorVoterID.setVisibility(8);
            }
        }
        this.binding.spinnerRelation.setEnabled(false);
        this.binding.spinnerRelation.setClickable(false);
        this.binding.spinnerIR.setEnabled(false);
        this.binding.spinnerIR.setClickable(false);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(r7, -125);
        calendar.getTime().getTime();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date());
        calendar2.add(r7, -18);
        calendar2.getTime().getTime();
        this.binding.selectDetails.getCheckedRadioButtonId();
        if (TextUtils.isEmpty(this.photoUrlS)) {
            this.binding.uploadElectorImage.setVisibility(0);
            this.binding.electorImageLL.setVisibility(8);
        } else if (!TextUtils.isEmpty(this.photoUrlS)) {
            getFile1(this.photoUrlS);
            if (this.photoUrlS.endsWith(".pdf")) {
                this.binding.electorImage.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
            this.binding.electorImageLL.setVisibility(0);
            this.binding.uploadElectorImage.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.annexureCUrlS)) {
            getFile4(this.annexureCUrlS);
            this.binding.fbImageLL.setVisibility(0);
            this.binding.fbUploadLL.setVisibility(8);
            this.binding.deleteBackImage.setVisibility(8);
            this.binding.annexPage1Layout.setVisibility(0);
            this.binding.photo1Name.setText(this.annexureCUrlS);
            if (this.annexureCUrlS.endsWith(".pdf")) {
                this.binding.frontImage.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        } else {
            if (TextUtils.isEmpty(this.srFormPage1UrlS) && TextUtils.isEmpty(this.srFormPage2UrlS)) {
                i = 0;
                this.binding.fbUploadLL.setVisibility(0);
                this.binding.fbImageLL.setVisibility(8);
                this.binding.uploadFrontPhoto.setVisibility(0);
                this.binding.uploadBackPhoto.setVisibility(0);
            } else {
                i = 0;
            }
            if (TextUtils.isEmpty(this.srFormPage1UrlS)) {
                this.binding.uploadFrontPhoto.setVisibility(i);
                this.binding.firstLL.setVisibility(8);
            }
            if (TextUtils.isEmpty(this.srFormPage2UrlS)) {
                this.binding.uploadBackPhoto.setVisibility(i);
                this.binding.secondLL.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.srFormPage1UrlS)) {
                getFile2(this.srFormPage1UrlS);
                this.binding.fbImageLL.setVisibility(0);
                this.binding.fbUploadLL.setVisibility(8);
                if (this.srFormPage1UrlS.endsWith(".pdf")) {
                    this.binding.frontImage.setImageResource(R.drawable.blo_pfd_thumbnail);
                }
            }
            if (!TextUtils.isEmpty(this.srFormPage2UrlS)) {
                getFile3(this.srFormPage2UrlS);
                this.binding.fbImageLL.setVisibility(0);
                this.binding.fbUploadLL.setVisibility(8);
                if (this.srFormPage2UrlS.endsWith(".pdf")) {
                    this.binding.backImage.setImageResource(R.drawable.blo_pfd_thumbnail);
                }
            }
        }
        this.binding.spinnerIR.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long l) {
                if (i4 == 0) {
                    ViewFormByAEROPage1.this.list8code = "";
                    return;
                }
                int i5 = i4 - 1;
                if (i5 < 0 || i5 >= ViewFormByAEROPage1.this.List8docName.size()) {
                    return;
                }
                ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
                viewFormByAEROPage1.list8code = viewFormByAEROPage1.List8docCode.get(i4);
                Logger.d(Constants.LIST8_CODE, ViewFormByAEROPage1.this.list8code);
            }
        });
        this.binding.aadharNumber.addTextChangedListener(new AnonymousClass2());
        this.binding.electorImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.frontImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.binding.backImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.deleteElectorImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewFormByAEROPage1.this.binding.electorImageLL.setVisibility(8);
                ViewFormByAEROPage1.this.binding.uploadElectorImage.setVisibility(0);
                ViewFormByAEROPage1.this.photoUrlS = "";
            }
        });
        this.binding.deleteFrontImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewFormByAEROPage1.this.binding.firstLL.setVisibility(8);
                ViewFormByAEROPage1.this.binding.uploadFrontPhoto.setVisibility(0);
                ViewFormByAEROPage1.this.binding.fbUploadLL.setVisibility(0);
                if (TextUtils.isEmpty(ViewFormByAEROPage1.this.srFormPage1UrlS) && TextUtils.isEmpty(ViewFormByAEROPage1.this.srFormPage2UrlS) && TextUtils.isEmpty(ViewFormByAEROPage1.this.annexureCUrlS)) {
                    ViewFormByAEROPage1.this.binding.uploadBackPhoto.setVisibility(8);
                }
                ViewFormByAEROPage1.this.srFormPage1UrlS = "";
                if (TextUtils.isEmpty(ViewFormByAEROPage1.this.annexureCUrlS)) {
                    return;
                }
                ViewFormByAEROPage1.this.annexureCUrlS = "";
                ViewFormByAEROPage1.this.binding.secondLL.setVisibility(8);
                ViewFormByAEROPage1.this.binding.uploadBackPhoto.setVisibility(0);
                ViewFormByAEROPage1.this.binding.annexPage1Layout.setVisibility(8);
                ViewFormByAEROPage1.this.binding.photo1Name.setText("");
            }
        });
        this.binding.deleteBackImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewFormByAEROPage1.this.binding.secondLL.setVisibility(8);
                ViewFormByAEROPage1.this.binding.uploadBackPhoto.setVisibility(0);
                if (TextUtils.isEmpty(ViewFormByAEROPage1.this.srFormPage1UrlS) && TextUtils.isEmpty(ViewFormByAEROPage1.this.srFormPage2UrlS) && TextUtils.isEmpty(ViewFormByAEROPage1.this.annexureCUrlS)) {
                    ViewFormByAEROPage1.this.binding.uploadFrontPhoto.setVisibility(8);
                }
                ViewFormByAEROPage1.this.binding.fbUploadLL.setVisibility(0);
                ViewFormByAEROPage1.this.srFormPage2UrlS = "";
            }
        });
        this.binding.nextButton.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent2 = new Intent((Context) ViewFormByAEROPage1.this, (Class<?>) ViewFormByAERODocuments.class);
                intent2.putExtra("citizenshipCat", ViewFormByAEROPage1.this.intent.getStringExtra("citizenshipTypeCat"));
                intent2.putExtra("list6DocUrl", ViewFormByAEROPage1.this.intent.getStringExtra("list6DocUrl"));
                intent2.putExtra("list6DocUrlPg2", ViewFormByAEROPage1.this.intent.getStringExtra("list6DocUrlPg2"));
                intent2.putExtra("list7DocUrl", ViewFormByAEROPage1.this.intent.getStringExtra("list7DocUrl"));
                intent2.putExtra("list7DocUrlPg2", ViewFormByAEROPage1.this.intent.getStringExtra("list7DocUrlPg2"));
                intent2.putExtra("preRevisionVoterDocUrl", ViewFormByAEROPage1.this.intent.getStringExtra("preRevisionVoterDocUrl"));
                intent2.putExtra("peRevisionVoterDocUrlPg2", ViewFormByAEROPage1.this.intent.getStringExtra("preRevisionVoterDocUrlPg2"));
                intent2.putExtra("list1DocUrl", ViewFormByAEROPage1.this.intent.getStringExtra("list1DocUrl"));
                intent2.putExtra("list1DocUrlPg2", ViewFormByAEROPage1.this.intent.getStringExtra("list1DocUrlPg2"));
                intent2.putExtra("list3DocUrl", ViewFormByAEROPage1.this.intent.getStringExtra("list3DocUrl"));
                intent2.putExtra("list3DocUrlPg2", ViewFormByAEROPage1.this.intent.getStringExtra("list3DocUrlPg2"));
                intent2.putExtra("list4DocUrl", ViewFormByAEROPage1.this.intent.getStringExtra("list4DocUrl"));
                intent2.putExtra("list4DocUrlPg2", ViewFormByAEROPage1.this.intent.getStringExtra("list4DocUrlPg2"));
                intent2.putExtra("list5DocUrl", ViewFormByAEROPage1.this.intent.getStringExtra("list5DocUrl"));
                intent2.putExtra("list5DocUrlPg2", ViewFormByAEROPage1.this.intent.getStringExtra("list5DocUrlPg2"));
                intent2.putExtra("list5DocUrlPg3", ViewFormByAEROPage1.this.intent.getStringExtra("list5DocUrlPg3"));
                intent2.putExtra("srFormPage1Url", ViewFormByAEROPage1.this.intent.getStringExtra("srFormPage1Url"));
                intent2.putExtra("srFormPage2Url", ViewFormByAEROPage1.this.intent.getStringExtra("srFormPage2Url"));
                intent2.putExtra("photoUrl", ViewFormByAEROPage1.this.intent.getStringExtra("photoUrl"));
                intent2.putExtra("annexureCUrl", ViewFormByAEROPage1.this.intent.getStringExtra("annexureCUrl"));
                intent2.putExtra("relationList8DocsPage1", ViewFormByAEROPage1.this.intent.getStringExtra("relationList8DocsPage1"));
                intent2.putExtra("relationList8DocsPage2", ViewFormByAEROPage1.this.intent.getStringExtra("relationList8DocsPage2"));
                intent2.putExtra("relationProofDocUrlPg1", ViewFormByAEROPage1.this.intent.getStringExtra("relationProofDocUrlPg1"));
                intent2.putExtra("relationProofDocUrlPg2", ViewFormByAEROPage1.this.intent.getStringExtra("relationProofDocUrlPg2"));
                ViewFormByAEROPage1.this.startActivity(intent2);
            }
        });
        this.binding.uploadElectorImage.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewFormByAEROPage1.this.photocount = 0;
                ViewFormByAEROPage1.this.pickFile();
            }
        });
        this.binding.uploadFrontPhoto.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewFormByAEROPage1.this.pickPhoto(101, "photo1Form");
            }
        });
        this.binding.uploadBackPhoto.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewFormByAEROPage1.this.pickPhoto(102, "FormPhoto2photo1Form");
            }
        });
        this.binding.cancelPhoto1Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(view);
            }
        });
        this.binding.cancelPhoto2Annexure.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
        if (TextUtils.isEmpty(this.relativeDocument1UrlS) && TextUtils.isEmpty(this.relativeDocument2UrlS)) {
            i2 = 0;
            this.binding.enumerationFormLayout.setVisibility(0);
            this.binding.fbImageLLNew.setVisibility(8);
            this.binding.uploadEnumerationFormPage1.setVisibility(0);
            this.binding.uploadEnumerationFormPage2.setVisibility(0);
        } else {
            i2 = 0;
        }
        if (TextUtils.isEmpty(this.relativeDocument1UrlS)) {
            this.binding.uploadEnumerationFormPage1.setVisibility(i2);
            this.binding.enumerationFormLayout.setVisibility(i2);
            this.binding.firstLLNew.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.relativeDocument2UrlS)) {
            this.binding.uploadEnumerationFormPage2.setVisibility(i2);
            this.binding.enumerationFormLayout.setVisibility(i2);
            this.binding.secondLLNew.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.relativeDocument1UrlS)) {
            getFile11(this.relativeDocument1UrlS);
            this.binding.fbImageLLNew.setVisibility(0);
            if (this.relativeDocument1UrlS.endsWith(".pdf")) {
                this.binding.frontImageNew.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
        if (!TextUtils.isEmpty(this.relativeDocument2UrlS)) {
            getFile21(this.relativeDocument2UrlS);
            this.binding.fbImageLLNew.setVisibility(0);
            if (this.relativeDocument2UrlS.endsWith(".pdf")) {
                this.binding.backImageNew.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
        if (TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
            i3 = 0;
            this.binding.supprtingDocumentsLayout.setVisibility(0);
            this.binding.fbImageLL1.setVisibility(8);
            this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
            this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
        } else {
            i3 = 0;
        }
        if (TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS)) {
            this.binding.uploadSupportingDocumentsPage1.setVisibility(i3);
            this.binding.supprtingDocumentsLayout.setVisibility(i3);
            this.binding.firstLL1.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
            this.binding.uploadSupportingDocumentsPage2.setVisibility(i3);
            this.binding.supprtingDocumentsLayout.setVisibility(i3);
            this.binding.secondLL1.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS)) {
            getFile31(this.relativeSupportingDocumentPage1UrlS);
            this.binding.fbImageLL1.setVisibility(0);
            if (this.relativeSupportingDocumentPage1UrlS.endsWith(".pdf")) {
                this.binding.frontImage1.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
        if (!TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
            getFile41(this.relativeSupportingDocumentPage2UrlS);
            this.binding.fbImageLL1.setVisibility(0);
            if (this.relativeSupportingDocumentPage2UrlS.endsWith(".pdf")) {
                this.binding.backImage1.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
        this.binding.relative2003RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.10
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i4) {
                if (ViewFormByAEROPage1.this.binding.relative2003Yes.isChecked()) {
                    ViewFormByAEROPage1.this.binding.relative2003LL.setVisibility(0);
                    ViewFormByAEROPage1.this.binding.oldACSerialPSLNoLL.setVisibility(0);
                }
                if (ViewFormByAEROPage1.this.binding.relative2003No.isChecked()) {
                    ViewFormByAEROPage1.this.binding.relative2003LL.setVisibility(8);
                    ViewFormByAEROPage1.this.binding.oldACSerialPSLNoLL.setVisibility(8);
                }
            }
        });
        this.binding.uploadEnumerationFormPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewFormByAEROPage1.this.pickPhoto(201, "rDP1_");
            }
        });
        this.binding.uploadEnumerationFormPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewFormByAEROPage1.this.pickPhoto(202, "rDP2_");
            }
        });
        this.binding.uploadSupportingDocumentsPage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(ViewFormByAEROPage1.this.list8code)) {
                    ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage1.showDialog1(viewFormByAEROPage1.alertText, ViewFormByAEROPage1.this.selectDocumentType);
                } else {
                    ViewFormByAEROPage1.this.pickPhoto(203, "sDP1_");
                }
            }
        });
        this.binding.uploadSupportingDocumentsPage2.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(ViewFormByAEROPage1.this.list8code)) {
                    ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage1.showDialog1(viewFormByAEROPage1.alertText, ViewFormByAEROPage1.this.selectDocumentType);
                } else {
                    ViewFormByAEROPage1.this.pickPhoto(204, "sDP2_");
                }
            }
        });
        this.binding.deleteFrontImageNew.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewFormByAEROPage1.this.binding.firstLLNew.setVisibility(8);
                ViewFormByAEROPage1.this.binding.uploadEnumerationFormPage1.setVisibility(0);
                ViewFormByAEROPage1.this.binding.enumerationFormLayout.setVisibility(0);
                ViewFormByAEROPage1.this.relativeDocument1UrlS = "";
                if (TextUtils.isEmpty(ViewFormByAEROPage1.this.relativeDocument1UrlS) && TextUtils.isEmpty(ViewFormByAEROPage1.this.relativeDocument2UrlS)) {
                    ViewFormByAEROPage1.this.binding.uploadEnumerationFormPage2.setVisibility(0);
                }
            }
        });
        this.binding.deleteBackImageNew.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewFormByAEROPage1.this.binding.secondLLNew.setVisibility(8);
                ViewFormByAEROPage1.this.binding.uploadEnumerationFormPage2.setVisibility(0);
                ViewFormByAEROPage1.this.relativeDocument2UrlS = "";
                if (TextUtils.isEmpty(ViewFormByAEROPage1.this.relativeDocument1UrlS) && TextUtils.isEmpty(ViewFormByAEROPage1.this.relativeDocument2UrlS)) {
                    ViewFormByAEROPage1.this.binding.uploadEnumerationFormPage1.setVisibility(0);
                }
                ViewFormByAEROPage1.this.binding.enumerationFormLayout.setVisibility(0);
            }
        });
        this.binding.deleteFrontImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewFormByAEROPage1.this.binding.firstLL1.setVisibility(8);
                ViewFormByAEROPage1.this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                ViewFormByAEROPage1.this.binding.supprtingDocumentsLayout.setVisibility(0);
                ViewFormByAEROPage1.this.relativeSupportingDocumentPage1UrlS = "";
                if (TextUtils.isEmpty(ViewFormByAEROPage1.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(ViewFormByAEROPage1.this.relativeSupportingDocumentPage2UrlS)) {
                    ViewFormByAEROPage1.this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                }
            }
        });
        this.binding.deleteBackImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewFormByAEROPage1.this.binding.secondLL1.setVisibility(8);
                ViewFormByAEROPage1.this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                ViewFormByAEROPage1.this.relativeSupportingDocumentPage2UrlS = "";
                if (TextUtils.isEmpty(ViewFormByAEROPage1.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(ViewFormByAEROPage1.this.relativeSupportingDocumentPage2UrlS)) {
                    ViewFormByAEROPage1.this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                }
                ViewFormByAEROPage1.this.binding.supprtingDocumentsLayout.setVisibility(0);
            }
        });
        this.binding.cancelEnumerationFormPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
        this.binding.cancelEnumerationFormPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$7(view);
            }
        });
        this.binding.cancelSupportingDocumentsPage1Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$8(view);
            }
        });
        this.binding.cancelSupportingDocumentsPage2Image.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$9(view);
            }
        });
        this.binding.spinnerRelation.setOnTouchListener(new View.OnTouchListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda21
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$onCreate$10(view, motionEvent);
            }
        });
        this.binding.spinnerRelation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.19
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long l) {
                if (ViewFormByAEROPage1.this.isUserAction) {
                    if (i4 == 0) {
                        ViewFormByAEROPage1.this.relationCode = "";
                    } else {
                        int i5 = i4 - 1;
                        if (i5 >= 0 && i5 < ViewFormByAEROPage1.this.relationNameSpinnerVal.size()) {
                            ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
                            viewFormByAEROPage1.relationCode = viewFormByAEROPage1.relationCodeSpinnerVal.get(i4);
                            Logger.d("list1Code", ViewFormByAEROPage1.this.relationCode);
                        }
                    }
                    ViewFormByAEROPage1.this.deletePhoto(201);
                    ViewFormByAEROPage1.this.deletePhoto(202);
                    ViewFormByAEROPage1.this.deletePhoto(203);
                    ViewFormByAEROPage1.this.deletePhoto(204);
                    ViewFormByAEROPage1.this.binding.oldAcNo.setText("");
                    ViewFormByAEROPage1.this.binding.oldPartNo.setText("");
                    ViewFormByAEROPage1.this.binding.oldPslNo.setText("");
                    ViewFormByAEROPage1.this.binding.firstLLNew.setVisibility(8);
                    ViewFormByAEROPage1.this.binding.uploadEnumerationFormPage1.setVisibility(0);
                    ViewFormByAEROPage1.this.binding.enumerationFormLayout.setVisibility(0);
                    ViewFormByAEROPage1.this.relativeDocument1UrlS = "";
                    if (TextUtils.isEmpty(ViewFormByAEROPage1.this.relativeDocument1UrlS) && TextUtils.isEmpty(ViewFormByAEROPage1.this.relativeDocument2UrlS)) {
                        ViewFormByAEROPage1.this.binding.uploadEnumerationFormPage2.setVisibility(0);
                    }
                    ViewFormByAEROPage1.this.binding.secondLLNew.setVisibility(8);
                    ViewFormByAEROPage1.this.binding.uploadEnumerationFormPage2.setVisibility(0);
                    ViewFormByAEROPage1.this.relativeDocument2UrlS = "";
                    if (TextUtils.isEmpty(ViewFormByAEROPage1.this.relativeDocument1UrlS) && TextUtils.isEmpty(ViewFormByAEROPage1.this.relativeDocument2UrlS)) {
                        ViewFormByAEROPage1.this.binding.uploadEnumerationFormPage1.setVisibility(0);
                    }
                    ViewFormByAEROPage1.this.binding.enumerationFormLayout.setVisibility(0);
                    ViewFormByAEROPage1.this.binding.firstLL1.setVisibility(8);
                    ViewFormByAEROPage1.this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                    ViewFormByAEROPage1.this.binding.supprtingDocumentsLayout.setVisibility(0);
                    ViewFormByAEROPage1.this.relativeSupportingDocumentPage1UrlS = "";
                    if (TextUtils.isEmpty(ViewFormByAEROPage1.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(ViewFormByAEROPage1.this.relativeSupportingDocumentPage2UrlS)) {
                        ViewFormByAEROPage1.this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                    }
                    ViewFormByAEROPage1.this.binding.secondLL1.setVisibility(8);
                    ViewFormByAEROPage1.this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                    ViewFormByAEROPage1.this.relativeSupportingDocumentPage2UrlS = "";
                    if (TextUtils.isEmpty(ViewFormByAEROPage1.this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(ViewFormByAEROPage1.this.relativeSupportingDocumentPage2UrlS)) {
                        ViewFormByAEROPage1.this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                    }
                    ViewFormByAEROPage1.this.binding.supprtingDocumentsLayout.setVisibility(0);
                }
            }
        });
        this.binding.frontImageNew.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$11(view);
            }
        });
        this.binding.backImageNew.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$12(view);
            }
        });
        this.binding.frontImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$13(view);
            }
        });
        this.binding.backImage1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$14(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(String str, String str2) {
        if (str.equals("n") || str.equals("N")) {
            showDialog1(this.invalidaadhar, str2);
        } else if (str.equalsIgnoreCase("D")) {
            this.binding.aadharNumber.setText("");
            this.binding.linearAadharLayout.setVisibility(8);
        } else {
            this.aadharref = this.aadharNoS;
            this.binding.aadharNumber.setText(str2);
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$2, reason: invalid class name */
    class AnonymousClass2 implements TextWatcher {
        AnonymousClass2() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Logger.d("", s.toString());
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (ViewFormByAEROPage1.this.binding.aadharNumber.getText().toString().length() != 12 || ViewFormByAEROPage1.this.binding.aadharNumber.getText().toString().contains("xx")) {
                return;
            }
            ViewFormByAEROPage1.this.alertDialog.show();
            try {
                String string = ViewFormByAEROPage1.this.binding.aadharNumber.getText().toString();
                ViewFormByAEROPage1.this.result = Verhoeff.validateVerhoeff(string);
                if (!ViewFormByAEROPage1.this.result) {
                    ViewFormByAEROPage1.this.binding.aadharNumber.setText("");
                    ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage1.showDialog1("", viewFormByAEROPage1.getString(R.string.invalidAadharMsg2));
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                } else {
                    ViewFormByAEROPage1.this.commomUtility.getaadharref(ViewFormByAEROPage1.this.getApplicationContext(), ViewFormByAEROPage1.this.state, ViewFormByAEROPage1.this.token, ViewFormByAEROPage1.this.binding.aadharNumber.getText().toString(), ViewFormByAEROPage1.this.atkband, ViewFormByAEROPage1.this.rtkband, "EFVerifyFormAERO", new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$2$$ExternalSyntheticLambda5
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str, String str2) {
                            this.f$0.lambda$onTextChanged$5(i, str, str2);
                        }
                    });
                }
            } catch (Exception e) {
                Logger.d("", e.toString());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$5(int i, String str, String str2) {
            if (i == 401) {
                ViewFormByAEROPage1.this.commomUtility.getRefreshToken(ViewFormByAEROPage1.this.getApplicationContext(), ViewFormByAEROPage1.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$2$$ExternalSyntheticLambda2
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str3, String str4) {
                        this.f$0.lambda$onTextChanged$3(i2, str3, str4);
                    }
                });
                return;
            }
            if (i == 200) {
                if (str.equals("N") || str.equals("n")) {
                    ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage1.showDialog1(viewFormByAEROPage1.invalidaadhar, str2);
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                    return;
                } else {
                    ViewFormByAEROPage1.this.aadharref = str2;
                    ViewFormByAEROPage1.this.aadharNoS = "";
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$2$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onTextChanged$4();
                        }
                    }, 2000L);
                    return;
                }
            }
            ViewFormByAEROPage1.this.showDialog1(ViewFormByAEROPage1.this.alertText + i, str2);
            ViewFormByAEROPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$3(int i, String str, String str2) {
            ViewFormByAEROPage1.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb in relation draft" + i + " " + str + " " + str2);
            if (i == 401 || i == 400) {
                ViewFormByAEROPage1.this.commomUtility.showMessageOK(ViewFormByAEROPage1.this.getApplicationContext(), ViewFormByAEROPage1.this.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$2$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onTextChanged$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ViewFormByAEROPage1.this.token = "Bearer " + str;
            ViewFormByAEROPage1.this.refreshToken = str2;
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setRefreshToken(str2);
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setToken("Bearer " + str);
            ViewFormByAEROPage1.this.commomUtility.getaadharref(ViewFormByAEROPage1.this.getApplicationContext(), ViewFormByAEROPage1.this.state, ViewFormByAEROPage1.this.token, ViewFormByAEROPage1.this.binding.aadharNumber.getText().toString(), ViewFormByAEROPage1.this.atkband, ViewFormByAEROPage1.this.rtkband, "EFVerifyFormAERO", new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$2$$ExternalSyntheticLambda1
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str3, String str4) {
                    this.f$0.lambda$onTextChanged$2(i2, str3, str4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAEROPage1.this.startActivity(new Intent(ViewFormByAEROPage1.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$2(int i, String str, String str2) {
            if (i == 200) {
                if (str.equals("N") || str.equals("n")) {
                    ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage1.showDialog1(viewFormByAEROPage1.invalidaadhar, str2);
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                    return;
                } else {
                    ViewFormByAEROPage1.this.aadharref = str2;
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$2$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onTextChanged$1();
                        }
                    }, 2000L);
                    return;
                }
            }
            ViewFormByAEROPage1.this.showDialog1(ViewFormByAEROPage1.this.alertText + i, str2);
            ViewFormByAEROPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$1() {
            ViewFormByAEROPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$4() {
            ViewFormByAEROPage1.this.alertDialog.dismiss();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Logger.d("", s.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        if (this.photoUrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file1, this.photoUrlS);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedurl1)) {
            showImageDialog(this.preSignedurl1, this.photoUrlS);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        if (!TextUtils.isEmpty(this.srFormPage1UrlS) && this.srFormPage1UrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file2, this.srFormPage1UrlS);
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
            }
        }
        if (!TextUtils.isEmpty(this.srFormPage1UrlS) && !this.srFormPage1UrlS.endsWith(".pdf")) {
            if (!TextUtils.isEmpty(this.preSignedurl2)) {
                showImageDialog(this.preSignedurl2, this.srFormPage1UrlS);
            } else {
                showImageDialog("", "");
            }
        }
        if (TextUtils.isEmpty(this.annexureCUrlS) || !this.annexureCUrlS.endsWith(".pdf")) {
            return;
        }
        try {
            showPersonPdfDialog(this.file4, this.annexureCUrlS);
        } catch (IOException e2) {
            Log.d("Exception in displaying pdf= ", e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        if (this.srFormPage2UrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file3, this.srFormPage2UrlS);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedurl3)) {
            showImageDialog(this.preSignedurl3, this.srFormPage2UrlS);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(View view) {
        deleteAnnexure(102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5(View view) {
        deleteAnnexure(103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        deletePhoto(201);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$7(View view) {
        deletePhoto(202);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$8(View view) {
        deletePhoto(203);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$9(View view) {
        deletePhoto(204);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$10(View view, MotionEvent motionEvent) {
        this.isUserAction = true;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$11(View view) {
        if (!TextUtils.isEmpty(this.relativeDocument1UrlS) && this.relativeDocument1UrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file11, this.relativeDocument1UrlS);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedurl3)) {
            showImageDialog(this.preSignedurl11, this.relativeDocument1UrlS);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$12(View view) {
        if (!TextUtils.isEmpty(this.relativeDocument2UrlS) && this.relativeDocument2UrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file21, this.relativeDocument2UrlS);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedurl21)) {
            showImageDialog(this.preSignedurl21, this.relativeDocument2UrlS);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$13(View view) {
        if (!TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS) && this.relativeSupportingDocumentPage1UrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file31, this.relativeSupportingDocumentPage1UrlS);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedurl31)) {
            showImageDialog(this.preSignedurl31, this.relativeSupportingDocumentPage1UrlS);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$14(View view) {
        if (!TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS) && this.relativeSupportingDocumentPage2UrlS.endsWith(".pdf")) {
            try {
                showPersonPdfDialog(this.file41, this.relativeSupportingDocumentPage2UrlS);
                return;
            } catch (IOException e) {
                Log.d("Exception in displaying pdf= ", e.getMessage());
                return;
            }
        }
        if (!TextUtils.isEmpty(this.preSignedurl41)) {
            showImageDialog(this.preSignedurl41, this.relativeSupportingDocumentPage2UrlS);
        } else {
            showImageDialog("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void pickFile() {
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        final String strReplaceAll = this.epicNoS.replaceAll("/", "_");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickFile$15(charSequenceArr, strReplaceAll, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickFile$15(CharSequence[] charSequenceArr, String str, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(this.takephoto)) {
            this.temp = str + "_voter_photo";
            this.alertDialog.show();
            ImagePicker.with(this).cropSquare().compress(512).cameraOnly().start(100);
        } else if (charSequenceArr[i].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void pickPhoto(final int code, final String listCode) {
        final String strReplaceAll = this.epicNoS.replaceAll("/", "_");
        final CharSequence[] charSequenceArr = {this.takephoto, this.cancel};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.addPhotoDialogMsg));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda14
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$pickPhoto$16(charSequenceArr, strReplaceAll, listCode, code, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$pickPhoto$16(CharSequence[] charSequenceArr, String str, String str2, int i, DialogInterface dialogInterface, int i2) {
        if (charSequenceArr[i2].equals(this.takephoto)) {
            this.temp = str + "_" + str2;
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog != null) {
                alertDialog.show();
            }
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(i);
            return;
        }
        if (charSequenceArr[i2].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showImageDialog(String preSignedUrlP, String name) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.blo_image_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_cancel_button);
        AppCompatImageView appCompatImageView = (TouchImageView) dialog.findViewById(R.id.image_card).findViewById(R.id.dialog_person_image);
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_image_name);
        Glide.with(this).load(preSignedUrlP).placeholder(R.drawable.blo_dummy_image).error(R.drawable.blo_dummy_image).into(appCompatImageView);
        textView.setText(name);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0521 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:101:0x053a A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:102:0x05c2  */
    /* JADX WARN: Code duplicated, block: B:104:0x05c6 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:106:0x05cc A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:107:0x0656  */
    /* JADX WARN: Code duplicated, block: B:109:0x065a A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:110:0x06a3 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:112:0x06b5 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:113:0x06ce A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:114:0x0756  */
    /* JADX WARN: Code duplicated, block: B:116:0x075a A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:118:0x0760 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:119:0x07ea  */
    /* JADX WARN: Code duplicated, block: B:121:0x07ee A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0837 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0849 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:125:0x0862 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:126:0x08ea  */
    /* JADX WARN: Code duplicated, block: B:128:0x08ee A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:130:0x08f4 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:131:0x097e  */
    /* JADX WARN: Code duplicated, block: B:133:0x0982 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:134:0x09cb A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:136:0x09dd A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:137:0x09f6 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:92:0x0432 A[Catch: Exception -> 0x0a92, TRY_ENTER, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0438 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:95:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:97:0x04c6 A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:98:0x050f A[Catch: Exception -> 0x0a92, TryCatch #10 {Exception -> 0x0a92, blocks: (B:92:0x0432, B:94:0x0438, B:138:0x0a7c, B:97:0x04c6, B:98:0x050f, B:100:0x0521, B:101:0x053a, B:104:0x05c6, B:106:0x05cc, B:109:0x065a, B:110:0x06a3, B:112:0x06b5, B:113:0x06ce, B:116:0x075a, B:118:0x0760, B:121:0x07ee, B:122:0x0837, B:124:0x0849, B:125:0x0862, B:128:0x08ee, B:130:0x08f4, B:133:0x0982, B:134:0x09cb, B:136:0x09dd, B:137:0x09f6, B:139:0x0a82, B:140:0x0a91), top: B:206:0x006b }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v35 */
    /* JADX WARN: Type inference failed for: r15v36 */
    /* JADX WARN: Type inference failed for: r15v37 */
    /* JADX WARN: Type inference failed for: r15v38 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r1v113, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v156, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v189, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v195, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v208, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v21, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v232, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v260, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v266, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v279, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v303, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v331, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v337, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v350, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v374, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v402, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v408, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v421, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v445, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v469, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v47, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v514, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r28v0 */
    /* JADX WARN: Type inference failed for: r28v1 */
    /* JADX WARN: Type inference failed for: r28v10 */
    /* JADX WARN: Type inference failed for: r28v13 */
    /* JADX WARN: Type inference failed for: r28v14 */
    /* JADX WARN: Type inference failed for: r28v15 */
    /* JADX WARN: Type inference failed for: r28v16 */
    /* JADX WARN: Type inference failed for: r28v17 */
    /* JADX WARN: Type inference failed for: r28v18 */
    /* JADX WARN: Type inference failed for: r28v19 */
    /* JADX WARN: Type inference failed for: r28v2 */
    /* JADX WARN: Type inference failed for: r28v22 */
    /* JADX WARN: Type inference failed for: r28v24 */
    /* JADX WARN: Type inference failed for: r28v25 */
    /* JADX WARN: Type inference failed for: r28v26 */
    /* JADX WARN: Type inference failed for: r28v27 */
    /* JADX WARN: Type inference failed for: r28v28 */
    /* JADX WARN: Type inference failed for: r28v29 */
    /* JADX WARN: Type inference failed for: r28v3 */
    /* JADX WARN: Type inference failed for: r28v30 */
    /* JADX WARN: Type inference failed for: r28v31 */
    /* JADX WARN: Type inference failed for: r28v32 */
    /* JADX WARN: Type inference failed for: r28v33 */
    /* JADX WARN: Type inference failed for: r28v34 */
    /* JADX WARN: Type inference failed for: r28v35 */
    /* JADX WARN: Type inference failed for: r28v4 */
    /* JADX WARN: Type inference failed for: r28v5 */
    /* JADX WARN: Type inference failed for: r28v6 */
    /* JADX WARN: Type inference failed for: r28v7 */
    /* JADX WARN: Type inference failed for: r28v8 */
    /* JADX WARN: Type inference failed for: r28v9 */
    /* JADX WARN: Type inference failed for: r2v103, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v115, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v133, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v145, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v163, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v175, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v193, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v206, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v220, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v34, types: [int] */
    /* JADX WARN: Type inference failed for: r2v56, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v73, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v85, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r31v0, types: [android.content.Context, in.gov.eci.bloapp.views.activity.SuperBaseActivity, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
    protected void onActivityResult(int i, int i2, Intent intent) {
        Object obj;
        ?? r15;
        ?? r28;
        ?? r12;
        Exception exc;
        ?? r29;
        ?? r210;
        Exception exc2;
        ?? r211;
        ?? r16;
        ?? r14;
        long j;
        double dRound;
        long j2;
        double dRound2;
        long j3;
        double dRound3;
        long j4;
        double dRound4;
        boolean z;
        ?? r17;
        int i3 = i;
        int i4 = i2;
        super.onActivityResult(i, i2, intent);
        ?? r18 = "";
        if (i4 != -1) {
            obj = "/";
            Object obj2 = "";
            r15 = 1;
            r15 = 1;
            if (i3 == 0) {
                Toast.makeText((Context) this, ImagePicker.getError(intent), 0).show();
                r12 = obj2;
            } else {
                Toast.makeText((Context) this, "No Image selected", 0).show();
                this.alertDialog.dismiss();
                this.binding.uploadFrontPhoto.setVisibility(0);
                this.binding.uploadBackPhoto.setVisibility(0);
                r12 = obj2;
            }
        } else {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), intent.getData());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
                this.pdfbyteArray = byteArrayOutputStream.toByteArray();
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
            try {
                Uri saveImagePath = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), "image", this.temp);
                obj = null;
                Cursor cursorQuery = getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
                try {
                    if (cursorQuery.getCount() <= 0) {
                        cursorQuery.close();
                        throw new IllegalArgumentException(this.imgmsg);
                    }
                    cursorQuery.moveToFirst();
                    String[] strArrSplit = saveImagePath.getPath().split("/");
                    try {
                        if (i3 != 101) {
                            r14 = strArrSplit;
                            obj = "/";
                            r18 = "";
                            r18 = 1;
                            r18 = 1;
                            r18 = 1;
                            r18 = 1;
                            r18 = 1;
                            r18 = 1;
                            i4 = i;
                            if (i4 == 102) {
                                long j5 = this.filesize;
                                try {
                                    if (j5 < 1024) {
                                        uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2str);
                                        this.binding.photo2Layout.setVisibility(0);
                                        this.binding.cancelPhoto2Annexure.setVisibility(0);
                                        this.binding.photo2Name.setVisibility(0);
                                        this.binding.photo2Size.setVisibility(0);
                                        this.binding.photo2.setVisibility(0);
                                        ImageView imageView = this.binding.photo2;
                                        byte[] bArr = this.pdfbyteArray;
                                        imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                                        this.binding.uploadBackPhoto.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.uploadBackPhoto.setEnabled(false);
                                        this.binding.photo2Name.setText(r14[r14.length - 1]);
                                        this.binding.photo2Size.setText(this.filesize + getString(R.string.kbMsg));
                                        r14 = r14;
                                        r18 = r18;
                                    } else if (j5 > 2048) {
                                        this.binding.photo2Layout.setVisibility(8);
                                        this.binding.cancelPhoto2Annexure.setVisibility(8);
                                        this.binding.photo2Name.setVisibility(8);
                                        this.binding.photo2Size.setVisibility(8);
                                        this.binding.photo2.setVisibility(8);
                                        this.binding.uploadBackPhoto.setEnabled(true);
                                        this.binding.uploadFrontPhoto.setVisibility(0);
                                        this.binding.uploadBackPhoto.setVisibility(0);
                                        showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                        r14 = r14;
                                        r18 = r18;
                                    } else {
                                        long j6 = j5 / 1024;
                                        this.filesize = j6;
                                        double dRound5 = Math.round(j6 * 100.0d) / 100.0d;
                                        if (dRound5 > 2.0d) {
                                            this.binding.photo2Layout.setVisibility(8);
                                            this.binding.uploadBackPhoto.setEnabled(true);
                                            showDialog1(this.alertText, this.imgmsg);
                                            r14 = r14;
                                            r18 = r18;
                                        } else {
                                            uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2str);
                                            this.binding.photo2Layout.setVisibility(0);
                                            this.binding.cancelPhoto2Annexure.setVisibility(0);
                                            this.binding.photo2Name.setVisibility(0);
                                            this.binding.photo2Size.setVisibility(0);
                                            this.binding.photo2.setVisibility(0);
                                            ImageView imageView2 = this.binding.photo2;
                                            byte[] bArr2 = this.pdfbyteArray;
                                            imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                                            this.binding.uploadBackPhoto.setTextColor(Color.parseColor(this.greycolor));
                                            this.binding.uploadBackPhoto.setEnabled(false);
                                            this.binding.photo2Name.setText(r14[r14.length - 1]);
                                            this.binding.photo2Size.setText(dRound5 + getString(R.string.mbMsg));
                                            r14 = r14;
                                            r18 = r18;
                                        }
                                    }
                                } catch (Exception e2) {
                                    exc2 = e2;
                                    i3 = i4;
                                    r16 = r18;
                                    r211 = r18;
                                    ?? r13 = r211;
                                    Logger.d(r13, exc2.getMessage());
                                    r12 = r13;
                                    r15 = r16;
                                    r28 = r211;
                                }
                            }
                            i3 = i;
                            if (i3 == 201) {
                                j4 = this.filesize;
                                if (j4 < 1024) {
                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
                                    this.binding.enumerationFormPage1.setVisibility(0);
                                    this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                    this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                    this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                    this.binding.enumerationFormPage1Image.setVisibility(0);
                                    ImageView imageView3 = this.binding.enumerationFormPage1Image;
                                    byte[] bArr3 = this.pdfbyteArray;
                                    imageView3.setImageBitmap(BitmapFactory.decodeByteArray(bArr3, 0, bArr3.length));
                                    this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                    this.binding.enumerationFormPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                    this.binding.enumerationFormPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                } else if (j4 > 2048) {
                                    this.binding.enumerationFormPage1.setVisibility(8);
                                    this.binding.cancelEnumerationFormPage1Image.setVisibility(8);
                                    this.binding.enumerationFormPage1ImageName.setVisibility(8);
                                    this.binding.enumerationFormPage1ImageSize.setVisibility(8);
                                    this.binding.enumerationFormPage1Image.setVisibility(8);
                                    this.binding.uploadEnumerationFormPage1.setEnabled(r18);
                                    this.binding.uploadEnumerationFormPage1.setVisibility(0);
                                    this.binding.uploadEnumerationFormPage2.setVisibility(0);
                                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                } else {
                                    long j7 = j4 / 1024;
                                    this.filesize = j7;
                                    dRound4 = Math.round(j7 * 100.0d) / 100.0d;
                                    if (dRound4 > 2.0d) {
                                        this.binding.enumerationFormPage1.setVisibility(8);
                                        this.binding.uploadEnumerationFormPage1.setEnabled(r18);
                                        showDialog1(this.alertText, this.imgmsg);
                                    } else {
                                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
                                        this.binding.enumerationFormPage1.setVisibility(0);
                                        this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                        this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                        this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                        this.binding.enumerationFormPage1Image.setVisibility(0);
                                        ImageView imageView4 = this.binding.enumerationFormPage1Image;
                                        byte[] bArr4 = this.pdfbyteArray;
                                        imageView4.setImageBitmap(BitmapFactory.decodeByteArray(bArr4, 0, bArr4.length));
                                        this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                        this.binding.enumerationFormPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                        this.binding.enumerationFormPage1ImageSize.setText(dRound4 + getString(R.string.mbMsg));
                                    }
                                }
                            } else if (i3 == 202) {
                                j3 = this.filesize;
                                if (j3 < 1024) {
                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
                                    this.binding.enumerationFormPage2.setVisibility(0);
                                    this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                                    this.binding.enumerationFormPage2ImageName.setVisibility(0);
                                    this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                                    this.binding.enumerationFormPage2Image.setVisibility(0);
                                    ImageView imageView5 = this.binding.enumerationFormPage2Image;
                                    byte[] bArr5 = this.pdfbyteArray;
                                    imageView5.setImageBitmap(BitmapFactory.decodeByteArray(bArr5, 0, bArr5.length));
                                    this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.uploadEnumerationFormPage2.setEnabled(false);
                                    this.binding.enumerationFormPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                    this.binding.enumerationFormPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                } else if (j3 > 2048) {
                                    this.binding.enumerationFormPage2.setVisibility(8);
                                    this.binding.cancelEnumerationFormPage2Image.setVisibility(8);
                                    this.binding.enumerationFormPage2ImageName.setVisibility(8);
                                    this.binding.enumerationFormPage2ImageSize.setVisibility(8);
                                    this.binding.enumerationFormPage2Image.setVisibility(8);
                                    this.binding.uploadEnumerationFormPage2.setEnabled(r18);
                                    this.binding.uploadEnumerationFormPage1.setVisibility(0);
                                    this.binding.uploadEnumerationFormPage2.setVisibility(0);
                                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                } else {
                                    long j8 = j3 / 1024;
                                    this.filesize = j8;
                                    dRound3 = Math.round(j8 * 100.0d) / 100.0d;
                                    if (dRound3 > 2.0d) {
                                        this.binding.enumerationFormPage2Image.setVisibility(8);
                                        this.binding.uploadEnumerationFormPage2.setEnabled(r18);
                                        showDialog1(this.alertText, this.imgmsg);
                                    } else {
                                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
                                        this.binding.enumerationFormPage2Image.setVisibility(0);
                                        this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                                        this.binding.enumerationFormPage2ImageName.setVisibility(0);
                                        this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                                        this.binding.enumerationFormPage2Image.setVisibility(0);
                                        ImageView imageView6 = this.binding.enumerationFormPage2Image;
                                        byte[] bArr6 = this.pdfbyteArray;
                                        imageView6.setImageBitmap(BitmapFactory.decodeByteArray(bArr6, 0, bArr6.length));
                                        this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.uploadEnumerationFormPage2.setEnabled(false);
                                        this.binding.enumerationFormPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                        this.binding.enumerationFormPage2ImageSize.setText(dRound3 + getString(R.string.mbMsg));
                                    }
                                }
                            } else if (i3 == 203) {
                                j2 = this.filesize;
                                if (j2 < 1024) {
                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                                    this.binding.supportingDocumentsPage1.setVisibility(0);
                                    this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                    this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                                    this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                                    this.binding.supportingDocumentsPage1Image.setVisibility(0);
                                    ImageView imageView7 = this.binding.supportingDocumentsPage1Image;
                                    byte[] bArr7 = this.pdfbyteArray;
                                    imageView7.setImageBitmap(BitmapFactory.decodeByteArray(bArr7, 0, bArr7.length));
                                    this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                                    this.binding.supportingDocumentsPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                    this.binding.supportingDocumentsPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                } else if (j2 > 2048) {
                                    this.binding.supportingDocumentsPage1.setVisibility(8);
                                    this.binding.cancelSupportingDocumentsPage1Image.setVisibility(8);
                                    this.binding.supportingDocumentsPage1ImageName.setVisibility(8);
                                    this.binding.supportingDocumentsPage1ImageSize.setVisibility(8);
                                    this.binding.supportingDocumentsPage1Image.setVisibility(8);
                                    this.binding.uploadSupportingDocumentsPage1.setEnabled(r18);
                                    this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                                    this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                } else {
                                    long j9 = j2 / 1024;
                                    this.filesize = j9;
                                    dRound2 = Math.round(j9 * 100.0d) / 100.0d;
                                    if (dRound2 > 2.0d) {
                                        this.binding.supportingDocumentsPage1.setVisibility(8);
                                        this.binding.uploadSupportingDocumentsPage1.setEnabled(r18);
                                        showDialog1(this.alertText, this.imgmsg);
                                    } else {
                                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                                        this.binding.supportingDocumentsPage1.setVisibility(0);
                                        this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                        this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                                        this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                                        this.binding.supportingDocumentsPage1Image.setVisibility(0);
                                        ImageView imageView8 = this.binding.supportingDocumentsPage1Image;
                                        byte[] bArr8 = this.pdfbyteArray;
                                        imageView8.setImageBitmap(BitmapFactory.decodeByteArray(bArr8, 0, bArr8.length));
                                        this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                                        this.binding.supportingDocumentsPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                        this.binding.supportingDocumentsPage1ImageSize.setText(dRound2 + getString(R.string.mbMsg));
                                    }
                                }
                            } else if (i3 == 204) {
                                j = this.filesize;
                                if (j < 1024) {
                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
                                    this.binding.supportingDocumentsPage2.setVisibility(0);
                                    this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                    this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                                    this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                                    this.binding.supportingDocumentsPage2Image.setVisibility(0);
                                    ImageView imageView9 = this.binding.supportingDocumentsPage2Image;
                                    byte[] bArr9 = this.pdfbyteArray;
                                    imageView9.setImageBitmap(BitmapFactory.decodeByteArray(bArr9, 0, bArr9.length));
                                    this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                    this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                                    this.binding.supportingDocumentsPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                    this.binding.supportingDocumentsPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                } else if (j > 2048) {
                                    this.binding.supportingDocumentsPage2.setVisibility(8);
                                    this.binding.cancelSupportingDocumentsPage2Image.setVisibility(8);
                                    this.binding.supportingDocumentsPage2ImageName.setVisibility(8);
                                    this.binding.supportingDocumentsPage2ImageSize.setVisibility(8);
                                    this.binding.supportingDocumentsPage2Image.setVisibility(8);
                                    this.binding.uploadSupportingDocumentsPage2.setEnabled(r18);
                                    this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                                    this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                } else {
                                    long j10 = j / 1024;
                                    this.filesize = j10;
                                    dRound = Math.round(j10 * 100.0d) / 100.0d;
                                    if (dRound > 2.0d) {
                                        this.binding.supportingDocumentsPage1.setVisibility(8);
                                        this.binding.uploadSupportingDocumentsPage2.setEnabled(r18);
                                        showDialog1(this.alertText, this.imgmsg);
                                    } else {
                                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
                                        this.binding.supportingDocumentsPage2.setVisibility(0);
                                        this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                        this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                                        this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                                        this.binding.supportingDocumentsPage2Image.setVisibility(0);
                                        ImageView imageView10 = this.binding.supportingDocumentsPage2Image;
                                        byte[] bArr10 = this.pdfbyteArray;
                                        imageView10.setImageBitmap(BitmapFactory.decodeByteArray(bArr10, 0, bArr10.length));
                                        this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                        this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                                        this.binding.supportingDocumentsPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                        this.binding.supportingDocumentsPage2ImageSize.setText(dRound + getString(R.string.mbMsg));
                                    }
                                }
                            }
                            cursorQuery.close();
                            r12 = r18;
                            r15 = r18;
                            r28 = r18;
                        } else {
                            obj = strArrSplit;
                            try {
                                long j11 = this.filesize;
                                try {
                                    if (j11 < 1024) {
                                        try {
                                            try {
                                                ?? r19 = obj;
                                                obj = "/";
                                                try {
                                                    uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1Str);
                                                    this.binding.annexPage1Layout.setVisibility(0);
                                                    this.binding.cancelPhoto1Annexure.setVisibility(0);
                                                    this.binding.photo1Name.setVisibility(0);
                                                    this.binding.photo1Size.setVisibility(0);
                                                    this.binding.photo1.setVisibility(0);
                                                    ImageView imageView11 = this.binding.photo1;
                                                    byte[] bArr11 = this.pdfbyteArray;
                                                    imageView11.setImageBitmap(BitmapFactory.decodeByteArray(bArr11, 0, bArr11.length));
                                                    this.binding.uploadFrontPhoto.setTextColor(Color.parseColor(this.greycolor));
                                                    this.binding.uploadFrontPhoto.setEnabled(false);
                                                    z = true;
                                                    try {
                                                        this.binding.photo1Name.setText(r19[r19.length - 1]);
                                                        this.binding.photo1Size.setText(this.filesize + getString(R.string.kbMsg));
                                                        r17 = r19;
                                                        r14 = r17;
                                                        r18 = z;
                                                        i3 = i;
                                                        if (i3 == 201) {
                                                            j4 = this.filesize;
                                                            if (j4 < 1024) {
                                                                uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
                                                                this.binding.enumerationFormPage1.setVisibility(0);
                                                                this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                                                this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                                                this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                                                this.binding.enumerationFormPage1Image.setVisibility(0);
                                                                ImageView imageView12 = this.binding.enumerationFormPage1Image;
                                                                byte[] bArr12 = this.pdfbyteArray;
                                                                imageView12.setImageBitmap(BitmapFactory.decodeByteArray(bArr12, 0, bArr12.length));
                                                                this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.greycolor));
                                                                this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                                                this.binding.enumerationFormPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                this.binding.enumerationFormPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                                            } else if (j4 > 2048) {
                                                                this.binding.enumerationFormPage1.setVisibility(8);
                                                                this.binding.cancelEnumerationFormPage1Image.setVisibility(8);
                                                                this.binding.enumerationFormPage1ImageName.setVisibility(8);
                                                                this.binding.enumerationFormPage1ImageSize.setVisibility(8);
                                                                this.binding.enumerationFormPage1Image.setVisibility(8);
                                                                this.binding.uploadEnumerationFormPage1.setEnabled(r18);
                                                                this.binding.uploadEnumerationFormPage1.setVisibility(0);
                                                                this.binding.uploadEnumerationFormPage2.setVisibility(0);
                                                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                                            } else {
                                                                long j12 = j4 / 1024;
                                                                this.filesize = j12;
                                                                dRound4 = Math.round(j12 * 100.0d) / 100.0d;
                                                                if (dRound4 > 2.0d) {
                                                                    this.binding.enumerationFormPage1.setVisibility(8);
                                                                    this.binding.uploadEnumerationFormPage1.setEnabled(r18);
                                                                    showDialog1(this.alertText, this.imgmsg);
                                                                } else {
                                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
                                                                    this.binding.enumerationFormPage1.setVisibility(0);
                                                                    this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                                                    this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                                                    this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                                                    this.binding.enumerationFormPage1Image.setVisibility(0);
                                                                    ImageView imageView13 = this.binding.enumerationFormPage1Image;
                                                                    byte[] bArr13 = this.pdfbyteArray;
                                                                    imageView13.setImageBitmap(BitmapFactory.decodeByteArray(bArr13, 0, bArr13.length));
                                                                    this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.greycolor));
                                                                    this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                                                    this.binding.enumerationFormPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                    this.binding.enumerationFormPage1ImageSize.setText(dRound4 + getString(R.string.mbMsg));
                                                                }
                                                            }
                                                        } else if (i3 == 202) {
                                                            j3 = this.filesize;
                                                            if (j3 < 1024) {
                                                                uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
                                                                this.binding.enumerationFormPage2.setVisibility(0);
                                                                this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                                                                this.binding.enumerationFormPage2ImageName.setVisibility(0);
                                                                this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                                                                this.binding.enumerationFormPage2Image.setVisibility(0);
                                                                ImageView imageView14 = this.binding.enumerationFormPage2Image;
                                                                byte[] bArr14 = this.pdfbyteArray;
                                                                imageView14.setImageBitmap(BitmapFactory.decodeByteArray(bArr14, 0, bArr14.length));
                                                                this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.greycolor));
                                                                this.binding.uploadEnumerationFormPage2.setEnabled(false);
                                                                this.binding.enumerationFormPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                this.binding.enumerationFormPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                                            } else if (j3 > 2048) {
                                                                this.binding.enumerationFormPage2.setVisibility(8);
                                                                this.binding.cancelEnumerationFormPage2Image.setVisibility(8);
                                                                this.binding.enumerationFormPage2ImageName.setVisibility(8);
                                                                this.binding.enumerationFormPage2ImageSize.setVisibility(8);
                                                                this.binding.enumerationFormPage2Image.setVisibility(8);
                                                                this.binding.uploadEnumerationFormPage2.setEnabled(r18);
                                                                this.binding.uploadEnumerationFormPage1.setVisibility(0);
                                                                this.binding.uploadEnumerationFormPage2.setVisibility(0);
                                                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                                            } else {
                                                                long j13 = j3 / 1024;
                                                                this.filesize = j13;
                                                                dRound3 = Math.round(j13 * 100.0d) / 100.0d;
                                                                if (dRound3 > 2.0d) {
                                                                    this.binding.enumerationFormPage2Image.setVisibility(8);
                                                                    this.binding.uploadEnumerationFormPage2.setEnabled(r18);
                                                                    showDialog1(this.alertText, this.imgmsg);
                                                                } else {
                                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
                                                                    this.binding.enumerationFormPage2Image.setVisibility(0);
                                                                    this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                                                                    this.binding.enumerationFormPage2ImageName.setVisibility(0);
                                                                    this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                                                                    this.binding.enumerationFormPage2Image.setVisibility(0);
                                                                    ImageView imageView15 = this.binding.enumerationFormPage2Image;
                                                                    byte[] bArr15 = this.pdfbyteArray;
                                                                    imageView15.setImageBitmap(BitmapFactory.decodeByteArray(bArr15, 0, bArr15.length));
                                                                    this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.greycolor));
                                                                    this.binding.uploadEnumerationFormPage2.setEnabled(false);
                                                                    this.binding.enumerationFormPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                    this.binding.enumerationFormPage2ImageSize.setText(dRound3 + getString(R.string.mbMsg));
                                                                }
                                                            }
                                                        } else if (i3 == 203) {
                                                            j2 = this.filesize;
                                                            if (j2 < 1024) {
                                                                uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                                                                this.binding.supportingDocumentsPage1.setVisibility(0);
                                                                this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                                                this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                                                                this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                                                                this.binding.supportingDocumentsPage1Image.setVisibility(0);
                                                                ImageView imageView16 = this.binding.supportingDocumentsPage1Image;
                                                                byte[] bArr16 = this.pdfbyteArray;
                                                                imageView16.setImageBitmap(BitmapFactory.decodeByteArray(bArr16, 0, bArr16.length));
                                                                this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                                                this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                                                                this.binding.supportingDocumentsPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                this.binding.supportingDocumentsPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                                            } else if (j2 > 2048) {
                                                                this.binding.supportingDocumentsPage1.setVisibility(8);
                                                                this.binding.cancelSupportingDocumentsPage1Image.setVisibility(8);
                                                                this.binding.supportingDocumentsPage1ImageName.setVisibility(8);
                                                                this.binding.supportingDocumentsPage1ImageSize.setVisibility(8);
                                                                this.binding.supportingDocumentsPage1Image.setVisibility(8);
                                                                this.binding.uploadSupportingDocumentsPage1.setEnabled(r18);
                                                                this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                                                                this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                                                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                                            } else {
                                                                long j14 = j2 / 1024;
                                                                this.filesize = j14;
                                                                dRound2 = Math.round(j14 * 100.0d) / 100.0d;
                                                                if (dRound2 > 2.0d) {
                                                                    this.binding.supportingDocumentsPage1.setVisibility(8);
                                                                    this.binding.uploadSupportingDocumentsPage1.setEnabled(r18);
                                                                    showDialog1(this.alertText, this.imgmsg);
                                                                } else {
                                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                                                                    this.binding.supportingDocumentsPage1.setVisibility(0);
                                                                    this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage1Image.setVisibility(0);
                                                                    ImageView imageView17 = this.binding.supportingDocumentsPage1Image;
                                                                    byte[] bArr17 = this.pdfbyteArray;
                                                                    imageView17.setImageBitmap(BitmapFactory.decodeByteArray(bArr17, 0, bArr17.length));
                                                                    this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                                                    this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                                                                    this.binding.supportingDocumentsPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                    this.binding.supportingDocumentsPage1ImageSize.setText(dRound2 + getString(R.string.mbMsg));
                                                                }
                                                            }
                                                        } else if (i3 == 204) {
                                                            j = this.filesize;
                                                            if (j < 1024) {
                                                                uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
                                                                this.binding.supportingDocumentsPage2.setVisibility(0);
                                                                this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                                                this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                                                                this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                                                                this.binding.supportingDocumentsPage2Image.setVisibility(0);
                                                                ImageView imageView18 = this.binding.supportingDocumentsPage2Image;
                                                                byte[] bArr18 = this.pdfbyteArray;
                                                                imageView18.setImageBitmap(BitmapFactory.decodeByteArray(bArr18, 0, bArr18.length));
                                                                this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                                                this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                                                                this.binding.supportingDocumentsPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                this.binding.supportingDocumentsPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                                            } else if (j > 2048) {
                                                                this.binding.supportingDocumentsPage2.setVisibility(8);
                                                                this.binding.cancelSupportingDocumentsPage2Image.setVisibility(8);
                                                                this.binding.supportingDocumentsPage2ImageName.setVisibility(8);
                                                                this.binding.supportingDocumentsPage2ImageSize.setVisibility(8);
                                                                this.binding.supportingDocumentsPage2Image.setVisibility(8);
                                                                this.binding.uploadSupportingDocumentsPage2.setEnabled(r18);
                                                                this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                                                                this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                                                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                                            } else {
                                                                long j15 = j / 1024;
                                                                this.filesize = j15;
                                                                dRound = Math.round(j15 * 100.0d) / 100.0d;
                                                                if (dRound > 2.0d) {
                                                                    this.binding.supportingDocumentsPage1.setVisibility(8);
                                                                    this.binding.uploadSupportingDocumentsPage2.setEnabled(r18);
                                                                    showDialog1(this.alertText, this.imgmsg);
                                                                } else {
                                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
                                                                    this.binding.supportingDocumentsPage2.setVisibility(0);
                                                                    this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage2Image.setVisibility(0);
                                                                    ImageView imageView19 = this.binding.supportingDocumentsPage2Image;
                                                                    byte[] bArr19 = this.pdfbyteArray;
                                                                    imageView19.setImageBitmap(BitmapFactory.decodeByteArray(bArr19, 0, bArr19.length));
                                                                    this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                                                    this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                                                                    this.binding.supportingDocumentsPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                    this.binding.supportingDocumentsPage2ImageSize.setText(dRound + getString(R.string.mbMsg));
                                                                }
                                                            }
                                                        }
                                                        cursorQuery.close();
                                                        r12 = r18;
                                                        r15 = r18;
                                                        r28 = r18;
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        exc2 = e;
                                                        r211 = "";
                                                        r16 = z;
                                                        ?? r110 = r211;
                                                        Logger.d(r110, exc2.getMessage());
                                                        r12 = r110;
                                                        r15 = r16;
                                                        r28 = r211;
                                                    }
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    z = true;
                                                }
                                            } catch (Exception e5) {
                                                e = e5;
                                                obj = "/";
                                                z = true;
                                            }
                                        } catch (Exception e6) {
                                            e = e6;
                                            obj = "/";
                                            z = true;
                                        }
                                    } else {
                                        ?? r111 = obj;
                                        z = true;
                                        obj = "/";
                                        if (j11 > 2048) {
                                            try {
                                                this.binding.annexPage1Layout.setVisibility(8);
                                                this.binding.cancelPhoto1Annexure.setVisibility(8);
                                                this.binding.photo1Name.setVisibility(8);
                                                this.binding.photo1Size.setVisibility(8);
                                                this.binding.photo1.setVisibility(8);
                                                this.binding.uploadFrontPhoto.setEnabled(true);
                                                this.binding.uploadFrontPhoto.setVisibility(0);
                                                this.binding.uploadBackPhoto.setVisibility(0);
                                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                                r17 = r111;
                                                r14 = r17;
                                            } catch (Exception e7) {
                                                e = e7;
                                                exc2 = e;
                                                r211 = "";
                                                r16 = z;
                                                ?? r112 = r211;
                                                Logger.d(r112, exc2.getMessage());
                                                r12 = r112;
                                                r15 = r16;
                                                r28 = r211;
                                            }
                                        } else {
                                            try {
                                                long j16 = j11 / 1024;
                                                this.filesize = j16;
                                                double dRound6 = Math.round(j16 * 100.0d) / 100.0d;
                                                if (dRound6 > 2.0d) {
                                                    this.binding.annexPage1Layout.setVisibility(8);
                                                    this.binding.uploadFrontPhoto.setEnabled(true);
                                                    showDialog1(this.alertText, this.imgmsg);
                                                    r14 = r111;
                                                } else {
                                                    try {
                                                        r18 = "";
                                                        r18 = 1;
                                                        r18 = 1;
                                                        try {
                                                            uploadPhoto(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1Str);
                                                            this.binding.annexPage1Layout.setVisibility(0);
                                                            this.binding.cancelPhoto1Annexure.setVisibility(0);
                                                            this.binding.photo1Name.setVisibility(0);
                                                            this.binding.photo1Size.setVisibility(0);
                                                            this.binding.photo1.setVisibility(0);
                                                            ImageView imageView20 = this.binding.photo1;
                                                            byte[] bArr20 = this.pdfbyteArray;
                                                            imageView20.setImageBitmap(BitmapFactory.decodeByteArray(bArr20, 0, bArr20.length));
                                                            this.binding.uploadFrontPhoto.setTextColor(Color.parseColor(this.greycolor));
                                                            this.binding.uploadFrontPhoto.setEnabled(false);
                                                            this.binding.photo1Name.setText(r111[r111.length - 1]);
                                                            this.binding.photo1Size.setText(dRound6 + getString(R.string.mbMsg));
                                                            r14 = r111;
                                                            r18 = r18;
                                                            i3 = i;
                                                            if (i3 == 201) {
                                                                j4 = this.filesize;
                                                                if (j4 < 1024) {
                                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
                                                                    this.binding.enumerationFormPage1.setVisibility(0);
                                                                    this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                                                    this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                                                    this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                                                    this.binding.enumerationFormPage1Image.setVisibility(0);
                                                                    ImageView imageView110 = this.binding.enumerationFormPage1Image;
                                                                    byte[] bArr110 = this.pdfbyteArray;
                                                                    imageView110.setImageBitmap(BitmapFactory.decodeByteArray(bArr110, 0, bArr110.length));
                                                                    this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.greycolor));
                                                                    this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                                                    this.binding.enumerationFormPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                    this.binding.enumerationFormPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                                                } else if (j4 > 2048) {
                                                                    this.binding.enumerationFormPage1.setVisibility(8);
                                                                    this.binding.cancelEnumerationFormPage1Image.setVisibility(8);
                                                                    this.binding.enumerationFormPage1ImageName.setVisibility(8);
                                                                    this.binding.enumerationFormPage1ImageSize.setVisibility(8);
                                                                    this.binding.enumerationFormPage1Image.setVisibility(8);
                                                                    this.binding.uploadEnumerationFormPage1.setEnabled(r18);
                                                                    this.binding.uploadEnumerationFormPage1.setVisibility(0);
                                                                    this.binding.uploadEnumerationFormPage2.setVisibility(0);
                                                                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                                                } else {
                                                                    long j17 = j4 / 1024;
                                                                    this.filesize = j17;
                                                                    dRound4 = Math.round(j17 * 100.0d) / 100.0d;
                                                                    if (dRound4 > 2.0d) {
                                                                        this.binding.enumerationFormPage1.setVisibility(8);
                                                                        this.binding.uploadEnumerationFormPage1.setEnabled(r18);
                                                                        showDialog1(this.alertText, this.imgmsg);
                                                                    } else {
                                                                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
                                                                        this.binding.enumerationFormPage1.setVisibility(0);
                                                                        this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                                                        this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                                                        this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                                                        this.binding.enumerationFormPage1Image.setVisibility(0);
                                                                        ImageView imageView111 = this.binding.enumerationFormPage1Image;
                                                                        byte[] bArr111 = this.pdfbyteArray;
                                                                        imageView111.setImageBitmap(BitmapFactory.decodeByteArray(bArr111, 0, bArr111.length));
                                                                        this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.greycolor));
                                                                        this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                                                        this.binding.enumerationFormPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                        this.binding.enumerationFormPage1ImageSize.setText(dRound4 + getString(R.string.mbMsg));
                                                                    }
                                                                }
                                                            } else if (i3 == 202) {
                                                                j3 = this.filesize;
                                                                if (j3 < 1024) {
                                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
                                                                    this.binding.enumerationFormPage2.setVisibility(0);
                                                                    this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                                                                    this.binding.enumerationFormPage2ImageName.setVisibility(0);
                                                                    this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                                                                    this.binding.enumerationFormPage2Image.setVisibility(0);
                                                                    ImageView imageView112 = this.binding.enumerationFormPage2Image;
                                                                    byte[] bArr112 = this.pdfbyteArray;
                                                                    imageView112.setImageBitmap(BitmapFactory.decodeByteArray(bArr112, 0, bArr112.length));
                                                                    this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.greycolor));
                                                                    this.binding.uploadEnumerationFormPage2.setEnabled(false);
                                                                    this.binding.enumerationFormPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                    this.binding.enumerationFormPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                                                } else if (j3 > 2048) {
                                                                    this.binding.enumerationFormPage2.setVisibility(8);
                                                                    this.binding.cancelEnumerationFormPage2Image.setVisibility(8);
                                                                    this.binding.enumerationFormPage2ImageName.setVisibility(8);
                                                                    this.binding.enumerationFormPage2ImageSize.setVisibility(8);
                                                                    this.binding.enumerationFormPage2Image.setVisibility(8);
                                                                    this.binding.uploadEnumerationFormPage2.setEnabled(r18);
                                                                    this.binding.uploadEnumerationFormPage1.setVisibility(0);
                                                                    this.binding.uploadEnumerationFormPage2.setVisibility(0);
                                                                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                                                } else {
                                                                    long j18 = j3 / 1024;
                                                                    this.filesize = j18;
                                                                    dRound3 = Math.round(j18 * 100.0d) / 100.0d;
                                                                    if (dRound3 > 2.0d) {
                                                                        this.binding.enumerationFormPage2Image.setVisibility(8);
                                                                        this.binding.uploadEnumerationFormPage2.setEnabled(r18);
                                                                        showDialog1(this.alertText, this.imgmsg);
                                                                    } else {
                                                                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
                                                                        this.binding.enumerationFormPage2Image.setVisibility(0);
                                                                        this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                                                                        this.binding.enumerationFormPage2ImageName.setVisibility(0);
                                                                        this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                                                                        this.binding.enumerationFormPage2Image.setVisibility(0);
                                                                        ImageView imageView113 = this.binding.enumerationFormPage2Image;
                                                                        byte[] bArr113 = this.pdfbyteArray;
                                                                        imageView113.setImageBitmap(BitmapFactory.decodeByteArray(bArr113, 0, bArr113.length));
                                                                        this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.greycolor));
                                                                        this.binding.uploadEnumerationFormPage2.setEnabled(false);
                                                                        this.binding.enumerationFormPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                        this.binding.enumerationFormPage2ImageSize.setText(dRound3 + getString(R.string.mbMsg));
                                                                    }
                                                                }
                                                            } else if (i3 == 203) {
                                                                j2 = this.filesize;
                                                                if (j2 < 1024) {
                                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                                                                    this.binding.supportingDocumentsPage1.setVisibility(0);
                                                                    this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage1Image.setVisibility(0);
                                                                    ImageView imageView114 = this.binding.supportingDocumentsPage1Image;
                                                                    byte[] bArr114 = this.pdfbyteArray;
                                                                    imageView114.setImageBitmap(BitmapFactory.decodeByteArray(bArr114, 0, bArr114.length));
                                                                    this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                                                    this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                                                                    this.binding.supportingDocumentsPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                    this.binding.supportingDocumentsPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                                                } else if (j2 > 2048) {
                                                                    this.binding.supportingDocumentsPage1.setVisibility(8);
                                                                    this.binding.cancelSupportingDocumentsPage1Image.setVisibility(8);
                                                                    this.binding.supportingDocumentsPage1ImageName.setVisibility(8);
                                                                    this.binding.supportingDocumentsPage1ImageSize.setVisibility(8);
                                                                    this.binding.supportingDocumentsPage1Image.setVisibility(8);
                                                                    this.binding.uploadSupportingDocumentsPage1.setEnabled(r18);
                                                                    this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                                                                    this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                                                                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                                                } else {
                                                                    long j19 = j2 / 1024;
                                                                    this.filesize = j19;
                                                                    dRound2 = Math.round(j19 * 100.0d) / 100.0d;
                                                                    if (dRound2 > 2.0d) {
                                                                        this.binding.supportingDocumentsPage1.setVisibility(8);
                                                                        this.binding.uploadSupportingDocumentsPage1.setEnabled(r18);
                                                                        showDialog1(this.alertText, this.imgmsg);
                                                                    } else {
                                                                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                                                                        this.binding.supportingDocumentsPage1.setVisibility(0);
                                                                        this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                                                        this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                                                                        this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                                                                        this.binding.supportingDocumentsPage1Image.setVisibility(0);
                                                                        ImageView imageView115 = this.binding.supportingDocumentsPage1Image;
                                                                        byte[] bArr115 = this.pdfbyteArray;
                                                                        imageView115.setImageBitmap(BitmapFactory.decodeByteArray(bArr115, 0, bArr115.length));
                                                                        this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                                                        this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                                                                        this.binding.supportingDocumentsPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                        this.binding.supportingDocumentsPage1ImageSize.setText(dRound2 + getString(R.string.mbMsg));
                                                                    }
                                                                }
                                                            } else if (i3 == 204) {
                                                                j = this.filesize;
                                                                if (j < 1024) {
                                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
                                                                    this.binding.supportingDocumentsPage2.setVisibility(0);
                                                                    this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                                                                    this.binding.supportingDocumentsPage2Image.setVisibility(0);
                                                                    ImageView imageView116 = this.binding.supportingDocumentsPage2Image;
                                                                    byte[] bArr116 = this.pdfbyteArray;
                                                                    imageView116.setImageBitmap(BitmapFactory.decodeByteArray(bArr116, 0, bArr116.length));
                                                                    this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                                                    this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                                                                    this.binding.supportingDocumentsPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                    this.binding.supportingDocumentsPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                                                } else if (j > 2048) {
                                                                    this.binding.supportingDocumentsPage2.setVisibility(8);
                                                                    this.binding.cancelSupportingDocumentsPage2Image.setVisibility(8);
                                                                    this.binding.supportingDocumentsPage2ImageName.setVisibility(8);
                                                                    this.binding.supportingDocumentsPage2ImageSize.setVisibility(8);
                                                                    this.binding.supportingDocumentsPage2Image.setVisibility(8);
                                                                    this.binding.uploadSupportingDocumentsPage2.setEnabled(r18);
                                                                    this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                                                                    this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                                                                    showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                                                } else {
                                                                    long j110 = j / 1024;
                                                                    this.filesize = j110;
                                                                    dRound = Math.round(j110 * 100.0d) / 100.0d;
                                                                    if (dRound > 2.0d) {
                                                                        this.binding.supportingDocumentsPage1.setVisibility(8);
                                                                        this.binding.uploadSupportingDocumentsPage2.setEnabled(r18);
                                                                        showDialog1(this.alertText, this.imgmsg);
                                                                    } else {
                                                                        uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
                                                                        this.binding.supportingDocumentsPage2.setVisibility(0);
                                                                        this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                                                        this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                                                                        this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                                                                        this.binding.supportingDocumentsPage2Image.setVisibility(0);
                                                                        ImageView imageView117 = this.binding.supportingDocumentsPage2Image;
                                                                        byte[] bArr117 = this.pdfbyteArray;
                                                                        imageView117.setImageBitmap(BitmapFactory.decodeByteArray(bArr117, 0, bArr117.length));
                                                                        this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                                                        this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                                                                        this.binding.supportingDocumentsPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                                        this.binding.supportingDocumentsPage2ImageSize.setText(dRound + getString(R.string.mbMsg));
                                                                    }
                                                                }
                                                            }
                                                            cursorQuery.close();
                                                            r12 = r18;
                                                            r15 = r18;
                                                            r28 = r18;
                                                        } catch (Exception e8) {
                                                            e = e8;
                                                            i3 = i;
                                                            r210 = r18;
                                                            exc2 = e;
                                                            r16 = r18;
                                                            r211 = r210;
                                                            ?? r113 = r211;
                                                            Logger.d(r113, exc2.getMessage());
                                                            r12 = r113;
                                                            r15 = r16;
                                                            r28 = r211;
                                                        }
                                                    } catch (Exception e9) {
                                                        e = e9;
                                                        r18 = "";
                                                        r18 = 1;
                                                    }
                                                }
                                            } catch (Exception e10) {
                                                e = e10;
                                                r18 = "";
                                                r18 = 1;
                                            }
                                            i3 = i;
                                            r210 = r18;
                                        }
                                        r18 = z;
                                        i3 = i;
                                        if (i3 == 201) {
                                            j4 = this.filesize;
                                            if (j4 < 1024) {
                                                uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
                                                this.binding.enumerationFormPage1.setVisibility(0);
                                                this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                                this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                                this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                                this.binding.enumerationFormPage1Image.setVisibility(0);
                                                ImageView imageView118 = this.binding.enumerationFormPage1Image;
                                                byte[] bArr118 = this.pdfbyteArray;
                                                imageView118.setImageBitmap(BitmapFactory.decodeByteArray(bArr118, 0, bArr118.length));
                                                this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.greycolor));
                                                this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                                this.binding.enumerationFormPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                this.binding.enumerationFormPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                            } else if (j4 > 2048) {
                                                this.binding.enumerationFormPage1.setVisibility(8);
                                                this.binding.cancelEnumerationFormPage1Image.setVisibility(8);
                                                this.binding.enumerationFormPage1ImageName.setVisibility(8);
                                                this.binding.enumerationFormPage1ImageSize.setVisibility(8);
                                                this.binding.enumerationFormPage1Image.setVisibility(8);
                                                this.binding.uploadEnumerationFormPage1.setEnabled(r18);
                                                this.binding.uploadEnumerationFormPage1.setVisibility(0);
                                                this.binding.uploadEnumerationFormPage2.setVisibility(0);
                                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                            } else {
                                                long j111 = j4 / 1024;
                                                this.filesize = j111;
                                                dRound4 = Math.round(j111 * 100.0d) / 100.0d;
                                                if (dRound4 > 2.0d) {
                                                    this.binding.enumerationFormPage1.setVisibility(8);
                                                    this.binding.uploadEnumerationFormPage1.setEnabled(r18);
                                                    showDialog1(this.alertText, this.imgmsg);
                                                } else {
                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo1strNew);
                                                    this.binding.enumerationFormPage1.setVisibility(0);
                                                    this.binding.cancelEnumerationFormPage1Image.setVisibility(0);
                                                    this.binding.enumerationFormPage1ImageName.setVisibility(0);
                                                    this.binding.enumerationFormPage1ImageSize.setVisibility(0);
                                                    this.binding.enumerationFormPage1Image.setVisibility(0);
                                                    ImageView imageView119 = this.binding.enumerationFormPage1Image;
                                                    byte[] bArr119 = this.pdfbyteArray;
                                                    imageView119.setImageBitmap(BitmapFactory.decodeByteArray(bArr119, 0, bArr119.length));
                                                    this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.greycolor));
                                                    this.binding.uploadEnumerationFormPage1.setEnabled(false);
                                                    this.binding.enumerationFormPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                    this.binding.enumerationFormPage1ImageSize.setText(dRound4 + getString(R.string.mbMsg));
                                                }
                                            }
                                        } else if (i3 == 202) {
                                            j3 = this.filesize;
                                            if (j3 < 1024) {
                                                uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
                                                this.binding.enumerationFormPage2.setVisibility(0);
                                                this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                                                this.binding.enumerationFormPage2ImageName.setVisibility(0);
                                                this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                                                this.binding.enumerationFormPage2Image.setVisibility(0);
                                                ImageView imageView1110 = this.binding.enumerationFormPage2Image;
                                                byte[] bArr1110 = this.pdfbyteArray;
                                                imageView1110.setImageBitmap(BitmapFactory.decodeByteArray(bArr1110, 0, bArr1110.length));
                                                this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.greycolor));
                                                this.binding.uploadEnumerationFormPage2.setEnabled(false);
                                                this.binding.enumerationFormPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                this.binding.enumerationFormPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                            } else if (j3 > 2048) {
                                                this.binding.enumerationFormPage2.setVisibility(8);
                                                this.binding.cancelEnumerationFormPage2Image.setVisibility(8);
                                                this.binding.enumerationFormPage2ImageName.setVisibility(8);
                                                this.binding.enumerationFormPage2ImageSize.setVisibility(8);
                                                this.binding.enumerationFormPage2Image.setVisibility(8);
                                                this.binding.uploadEnumerationFormPage2.setEnabled(r18);
                                                this.binding.uploadEnumerationFormPage1.setVisibility(0);
                                                this.binding.uploadEnumerationFormPage2.setVisibility(0);
                                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                            } else {
                                                long j112 = j3 / 1024;
                                                this.filesize = j112;
                                                dRound3 = Math.round(j112 * 100.0d) / 100.0d;
                                                if (dRound3 > 2.0d) {
                                                    this.binding.enumerationFormPage2Image.setVisibility(8);
                                                    this.binding.uploadEnumerationFormPage2.setEnabled(r18);
                                                    showDialog1(this.alertText, this.imgmsg);
                                                } else {
                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo2strNew);
                                                    this.binding.enumerationFormPage2Image.setVisibility(0);
                                                    this.binding.cancelEnumerationFormPage2Image.setVisibility(0);
                                                    this.binding.enumerationFormPage2ImageName.setVisibility(0);
                                                    this.binding.enumerationFormPage2ImageSize.setVisibility(0);
                                                    this.binding.enumerationFormPage2Image.setVisibility(0);
                                                    ImageView imageView1111 = this.binding.enumerationFormPage2Image;
                                                    byte[] bArr1111 = this.pdfbyteArray;
                                                    imageView1111.setImageBitmap(BitmapFactory.decodeByteArray(bArr1111, 0, bArr1111.length));
                                                    this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.greycolor));
                                                    this.binding.uploadEnumerationFormPage2.setEnabled(false);
                                                    this.binding.enumerationFormPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                    this.binding.enumerationFormPage2ImageSize.setText(dRound3 + getString(R.string.mbMsg));
                                                }
                                            }
                                        } else if (i3 == 203) {
                                            j2 = this.filesize;
                                            if (j2 < 1024) {
                                                uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                                                this.binding.supportingDocumentsPage1.setVisibility(0);
                                                this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                                this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                                                this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                                                this.binding.supportingDocumentsPage1Image.setVisibility(0);
                                                ImageView imageView1112 = this.binding.supportingDocumentsPage1Image;
                                                byte[] bArr1112 = this.pdfbyteArray;
                                                imageView1112.setImageBitmap(BitmapFactory.decodeByteArray(bArr1112, 0, bArr1112.length));
                                                this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                                this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                                                this.binding.supportingDocumentsPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                this.binding.supportingDocumentsPage1ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                            } else if (j2 > 2048) {
                                                this.binding.supportingDocumentsPage1.setVisibility(8);
                                                this.binding.cancelSupportingDocumentsPage1Image.setVisibility(8);
                                                this.binding.supportingDocumentsPage1ImageName.setVisibility(8);
                                                this.binding.supportingDocumentsPage1ImageSize.setVisibility(8);
                                                this.binding.supportingDocumentsPage1Image.setVisibility(8);
                                                this.binding.uploadSupportingDocumentsPage1.setEnabled(r18);
                                                this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                                                this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                            } else {
                                                long j113 = j2 / 1024;
                                                this.filesize = j113;
                                                dRound2 = Math.round(j113 * 100.0d) / 100.0d;
                                                if (dRound2 > 2.0d) {
                                                    this.binding.supportingDocumentsPage1.setVisibility(8);
                                                    this.binding.uploadSupportingDocumentsPage1.setEnabled(r18);
                                                    showDialog1(this.alertText, this.imgmsg);
                                                } else {
                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo3strNew);
                                                    this.binding.supportingDocumentsPage1.setVisibility(0);
                                                    this.binding.cancelSupportingDocumentsPage1Image.setVisibility(0);
                                                    this.binding.supportingDocumentsPage1ImageName.setVisibility(0);
                                                    this.binding.supportingDocumentsPage1ImageSize.setVisibility(0);
                                                    this.binding.supportingDocumentsPage1Image.setVisibility(0);
                                                    ImageView imageView1113 = this.binding.supportingDocumentsPage1Image;
                                                    byte[] bArr1113 = this.pdfbyteArray;
                                                    imageView1113.setImageBitmap(BitmapFactory.decodeByteArray(bArr1113, 0, bArr1113.length));
                                                    this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.greycolor));
                                                    this.binding.uploadSupportingDocumentsPage1.setEnabled(false);
                                                    this.binding.supportingDocumentsPage1ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                    this.binding.supportingDocumentsPage1ImageSize.setText(dRound2 + getString(R.string.mbMsg));
                                                }
                                            }
                                        } else if (i3 == 204) {
                                            j = this.filesize;
                                            if (j < 1024) {
                                                uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
                                                this.binding.supportingDocumentsPage2.setVisibility(0);
                                                this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                                this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                                                this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                                                this.binding.supportingDocumentsPage2Image.setVisibility(0);
                                                ImageView imageView1114 = this.binding.supportingDocumentsPage2Image;
                                                byte[] bArr1114 = this.pdfbyteArray;
                                                imageView1114.setImageBitmap(BitmapFactory.decodeByteArray(bArr1114, 0, bArr1114.length));
                                                this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                                this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                                                this.binding.supportingDocumentsPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                this.binding.supportingDocumentsPage2ImageSize.setText(this.filesize + getString(R.string.kbMsg));
                                            } else if (j > 2048) {
                                                this.binding.supportingDocumentsPage2.setVisibility(8);
                                                this.binding.cancelSupportingDocumentsPage2Image.setVisibility(8);
                                                this.binding.supportingDocumentsPage2ImageName.setVisibility(8);
                                                this.binding.supportingDocumentsPage2ImageSize.setVisibility(8);
                                                this.binding.supportingDocumentsPage2Image.setVisibility(8);
                                                this.binding.uploadSupportingDocumentsPage2.setEnabled(r18);
                                                this.binding.uploadSupportingDocumentsPage2.setVisibility(0);
                                                this.binding.uploadSupportingDocumentsPage1.setVisibility(0);
                                                showDialog1(this.alertText, getString(R.string.imageSizeExceededMsg));
                                            } else {
                                                long j114 = j / 1024;
                                                this.filesize = j114;
                                                dRound = Math.round(j114 * 100.0d) / 100.0d;
                                                if (dRound > 2.0d) {
                                                    this.binding.supportingDocumentsPage1.setVisibility(8);
                                                    this.binding.uploadSupportingDocumentsPage2.setEnabled(r18);
                                                    showDialog1(this.alertText, this.imgmsg);
                                                } else {
                                                    uploadPhoto(this.state, this.asmblyNO, this.partNoS, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photo4strNew);
                                                    this.binding.supportingDocumentsPage2.setVisibility(0);
                                                    this.binding.cancelSupportingDocumentsPage2Image.setVisibility(0);
                                                    this.binding.supportingDocumentsPage2ImageName.setVisibility(0);
                                                    this.binding.supportingDocumentsPage2ImageSize.setVisibility(0);
                                                    this.binding.supportingDocumentsPage2Image.setVisibility(0);
                                                    ImageView imageView1115 = this.binding.supportingDocumentsPage2Image;
                                                    byte[] bArr1115 = this.pdfbyteArray;
                                                    imageView1115.setImageBitmap(BitmapFactory.decodeByteArray(bArr1115, 0, bArr1115.length));
                                                    this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.greycolor));
                                                    this.binding.uploadSupportingDocumentsPage2.setEnabled(false);
                                                    this.binding.supportingDocumentsPage2ImageName.setText(r14[r14.length - (r18 == true ? 1 : 0)]);
                                                    this.binding.supportingDocumentsPage2ImageSize.setText(dRound + getString(R.string.mbMsg));
                                                }
                                            }
                                        }
                                        cursorQuery.close();
                                        r12 = r18;
                                        r15 = r18;
                                        r28 = r18;
                                    }
                                } catch (Exception e11) {
                                    e = e11;
                                }
                            } catch (Exception e12) {
                                e = e12;
                                obj = "/";
                            }
                        }
                    } catch (Exception e13) {
                        e = e13;
                    }
                } catch (Exception e14) {
                    e = e14;
                }
            } catch (Exception e15) {
                e = e15;
                obj = "/";
                r210 = "";
                r18 = 1;
            }
            exc2 = e;
            r16 = r18;
            r211 = r210;
            ?? r114 = r211;
            Logger.d(r114, exc2.getMessage());
            r12 = r114;
            r15 = r16;
            r28 = r211;
        }
        if (i3 == 100 && i2 == -1) {
            try {
                Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), intent.getData());
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                bitmap2.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream2);
                this.byteArray = byteArrayOutputStream2.toByteArray();
            } catch (Exception e16) {
                Logger.d(r12, e16.getMessage());
            }
            try {
                Uri saveImagePath2 = getSaveImagePath(Base64.encodeToString(this.byteArray, 0), this.img, this.temp);
                Cursor cursorQuery2 = getApplicationContext().getContentResolver().query(saveImagePath2, null, null, null, null);
                try {
                    if (cursorQuery2.getCount() <= 0) {
                        cursorQuery2.close();
                        throw new IllegalArgumentException(this.imgmsg);
                    }
                    cursorQuery2.moveToFirst();
                    String[] strArrSplit2 = saveImagePath2.getPath().split(obj);
                    long j20 = this.filesize;
                    try {
                        if (j20 < 1024) {
                            faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                            this.binding.passPhotoLayout.setVisibility(0);
                            this.binding.cancel.setVisibility(0);
                            this.binding.uploadElectorImage.setTextColor(Color.parseColor(this.greycolor));
                            this.binding.uploadElectorImage.setEnabled(false);
                            this.binding.photoNameTv2.setText(strArrSplit2[strArrSplit2.length - r15]);
                            this.binding.photoSize.setText(this.filesize + getString(R.string.kbMsg));
                            this.binding.photoSize.setVisibility(0);
                            this.binding.photoNameTv2.setVisibility(0);
                            this.binding.image.setVisibility(0);
                            ImageView imageView21 = this.binding.image;
                            byte[] bArr21 = this.byteArray;
                            imageView21.setImageBitmap(BitmapFactory.decodeByteArray(bArr21, 0, bArr21.length));
                        } else {
                            long j21 = j20 / 1024;
                            this.filesize = j21;
                            double dRound7 = Math.round(j21 * 100.0d) / 100.0d;
                            if (dRound7 > 2.0d) {
                                this.binding.passPhotoLayout.setVisibility(8);
                                this.binding.uploadElectorImage.setEnabled(r15);
                                this.binding.uploadElectorImage.setTextColor(Color.parseColor(this.blackColor));
                                showDialog1(this.alertText, this.imgmsg);
                            } else {
                                faceRecognition(this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.photostr);
                                this.binding.passPhotoLayout.setVisibility(0);
                                this.binding.uploadElectorImage.setTextColor(Color.parseColor(this.greycolor));
                                this.binding.uploadElectorImage.setEnabled(false);
                                this.binding.photoNameTv2.setText(strArrSplit2[strArrSplit2.length - r15]);
                                this.binding.photoSize.setText(dRound7 + getString(R.string.mbMsg));
                                ImageView imageView22 = this.binding.image;
                                byte[] bArr22 = this.byteArray;
                                imageView22.setImageBitmap(BitmapFactory.decodeByteArray(bArr22, 0, bArr22.length));
                            }
                            cursorQuery2.close();
                            return;
                        }
                        cursorQuery2.close();
                        return;
                    } catch (Exception e17) {
                        exc = e17;
                        r29 = r12;
                    }
                } catch (Exception e18) {
                    e = e18;
                    exc = e;
                    r29 = r28;
                }
            } catch (Exception e19) {
                e = e19;
                r28 = r12;
            }
            exc = e;
            r29 = r28;
            Logger.d(r29, exc.getMessage());
        }
    }

    private void openDatePicker() {
        this.binding.dateOfBirth.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(this.dobcalendar.getTime()));
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$18(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$18(View view) {
        onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile1(String fileref) {
        Log.d("File Ref1= ", fileref);
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass20(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$20, reason: invalid class name */
    class AnonymousClass20 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass20(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                if (ViewFormByAEROPage1.this.alertDialog != null) {
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                ViewFormByAEROPage1.this.preSignedurl1 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAEROPage1.this).load(ViewFormByAEROPage1.this.preSignedurl1).into(ViewFormByAEROPage1.this.binding.electorImage);
                } else {
                    ViewFormByAEROPage1.this.binding.electorImage.setImageDrawable(ContextCompat.getDrawable(ViewFormByAEROPage1.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage1.downloadPdfToCache(viewFormByAEROPage1.preSignedurl1, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.20.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAEROPage1.this.file1 = file;
                            Log.e("GETFILE", "FILE1::" + ViewFormByAEROPage1.this.file1);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAEROPage1.this.preSignedurl1)) {
                    ViewFormByAEROPage1.this.binding.electorImage.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAEROPage1.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                    ?? r5 = ViewFormByAEROPage1.this;
                    String str = ((ViewFormByAEROPage1) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$20$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAEROPage1.this.TAG, ViewFormByAEROPage1.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAEROPage1.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAEROPage1.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAEROPage1.this.TAG, e.getMessage());
                }
            }
            ViewFormByAEROPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            ViewFormByAEROPage1.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                ?? r5 = ViewFormByAEROPage1.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$20$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAEROPage1.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAEROPage1.this.getFile1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAEROPage1.this.startActivity(new Intent((Context) ViewFormByAEROPage1.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAEROPage1.this.TAG, ViewFormByAEROPage1.this.comingTag + t.getMessage());
            if (ViewFormByAEROPage1.this.alertDialog != null) {
                ViewFormByAEROPage1.this.alertDialog.dismiss();
            }
            ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
            viewFormByAEROPage1.showDialog1(viewFormByAEROPage1.getString(R.string.alertMsg), t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile2(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass21(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$21, reason: invalid class name */
    class AnonymousClass21 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass21(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                if (ViewFormByAEROPage1.this.alertDialog != null) {
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                ViewFormByAEROPage1.this.preSignedurl2 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAEROPage1.this).load(ViewFormByAEROPage1.this.preSignedurl2).into(ViewFormByAEROPage1.this.binding.frontImage);
                } else {
                    ViewFormByAEROPage1.this.binding.frontImage.setImageDrawable(ContextCompat.getDrawable(ViewFormByAEROPage1.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage1.downloadPdfToCache(viewFormByAEROPage1.preSignedurl2, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.21.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAEROPage1.this.file2 = file;
                            Log.e("GETFILE", "FILE2::" + ViewFormByAEROPage1.this.file2);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAEROPage1.this.preSignedurl2)) {
                    ViewFormByAEROPage1.this.binding.frontImage.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAEROPage1.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                    ?? r5 = ViewFormByAEROPage1.this;
                    String str = ((ViewFormByAEROPage1) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$21$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAEROPage1.this.TAG, ViewFormByAEROPage1.this.comingTag);
                }
            } else {
                try {
                    ViewFormByAEROPage1.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$21$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(ViewFormByAEROPage1.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAEROPage1.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAEROPage1.this.TAG, e.getMessage());
                }
            }
            ViewFormByAEROPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            ViewFormByAEROPage1.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                ?? r5 = ViewFormByAEROPage1.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$21$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAEROPage1.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAEROPage1.this.getFile2(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAEROPage1.this.startActivity(new Intent((Context) ViewFormByAEROPage1.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewFormByAEROPage1.this.alertDialog != null) {
                ViewFormByAEROPage1.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAEROPage1.this.TAG, ViewFormByAEROPage1.this.comingTag + t.getMessage());
            if (ViewFormByAEROPage1.this.alertDialog != null) {
                ViewFormByAEROPage1.this.alertDialog.dismiss();
            }
            ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
            viewFormByAEROPage1.showDialog1(viewFormByAEROPage1.getString(R.string.alertMsg), t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile3(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass22(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$22, reason: invalid class name */
    class AnonymousClass22 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass22(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                if (ViewFormByAEROPage1.this.alertDialog != null) {
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                ViewFormByAEROPage1.this.preSignedurl3 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAEROPage1.this).load(ViewFormByAEROPage1.this.preSignedurl3).into(ViewFormByAEROPage1.this.binding.backImage);
                } else {
                    ViewFormByAEROPage1.this.binding.backImage.setImageDrawable(ContextCompat.getDrawable(ViewFormByAEROPage1.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage1.downloadPdfToCache(viewFormByAEROPage1.preSignedurl3, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.22.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAEROPage1.this.file3 = file;
                            Log.e("GETFILE", "FILE3::" + ViewFormByAEROPage1.this.file3);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAEROPage1.this.preSignedurl3)) {
                    ViewFormByAEROPage1.this.binding.backImage.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAEROPage1.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                    ?? r5 = ViewFormByAEROPage1.this;
                    String str = ((ViewFormByAEROPage1) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$22$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAEROPage1.this.TAG, ViewFormByAEROPage1.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAEROPage1.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAEROPage1.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAEROPage1.this.TAG, e.getMessage());
                }
            }
            ViewFormByAEROPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            ViewFormByAEROPage1.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                ?? r5 = ViewFormByAEROPage1.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$22$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAEROPage1.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAEROPage1.this.getFile3(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAEROPage1.this.startActivity(new Intent((Context) ViewFormByAEROPage1.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAEROPage1.this.TAG, ViewFormByAEROPage1.this.comingTag + t.getMessage());
            if (ViewFormByAEROPage1.this.alertDialog != null) {
                ViewFormByAEROPage1.this.alertDialog.dismiss();
            }
            ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
            viewFormByAEROPage1.showDialog1(viewFormByAEROPage1.getString(R.string.alertMsg), t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile4(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass23(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$23, reason: invalid class name */
    class AnonymousClass23 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass23(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                if (ViewFormByAEROPage1.this.alertDialog != null) {
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                ViewFormByAEROPage1.this.preSignedurl4 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAEROPage1.this).load(ViewFormByAEROPage1.this.preSignedurl4).into(ViewFormByAEROPage1.this.binding.frontImage);
                } else {
                    ViewFormByAEROPage1.this.binding.frontImage.setImageDrawable(ContextCompat.getDrawable(ViewFormByAEROPage1.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage1.downloadPdfToCache(viewFormByAEROPage1.preSignedurl4, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.23.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAEROPage1.this.file1 = file;
                            Log.e("GETFILE", "FILE4::" + ViewFormByAEROPage1.this.file4);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAEROPage1.this.preSignedurl4)) {
                    ViewFormByAEROPage1.this.binding.backImage.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAEROPage1.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                    ?? r5 = ViewFormByAEROPage1.this;
                    String str = ((ViewFormByAEROPage1) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$23$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAEROPage1.this.TAG, ViewFormByAEROPage1.this.comingTag);
                }
            } else {
                try {
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAEROPage1.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAEROPage1.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAEROPage1.this.TAG, e.getMessage());
                }
            }
            ViewFormByAEROPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            ViewFormByAEROPage1.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                ?? r5 = ViewFormByAEROPage1.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$23$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAEROPage1.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAEROPage1.this.getFile4(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAEROPage1.this.startActivity(new Intent((Context) ViewFormByAEROPage1.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAEROPage1.this.TAG, ViewFormByAEROPage1.this.comingTag + t.getMessage());
            if (ViewFormByAEROPage1.this.alertDialog != null) {
                ViewFormByAEROPage1.this.alertDialog.dismiss();
            }
            ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
            viewFormByAEROPage1.showDialog1(viewFormByAEROPage1.getString(R.string.alertMsg), t.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$19(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$19(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        dialogInterface.dismiss();
    }

    public Uri getSaveImagePath(String fileNameBase64, String documentTypeSelected, String code) throws IOException {
        this.functionNameForLogBaseActivity = "getSaveImagePath ";
        Logger.d(this.TAG, "getSaveImagePath ");
        String str = new SimpleDateFormat("ddMMyyyyHHMMSS").format(new Date());
        File file = new File(getApplicationContext().getExternalFilesDir(null) + this.garudaTextBaseActivity);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (documentTypeSelected.equals(this.imageTextBaseActivity)) {
            String str2 = "img_" + code + str + this.jpgTextBaseActivity;
            this.saveImageFileName = str2;
            Logger.d(this.TAG, str2);
            Logger.d(this.TAG, this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
        } else if (documentTypeSelected.equals(this.pdfTextBaseActivity)) {
            this.saveImageFileName = "pdf_document" + str + this.pdfTextBaseActivity;
            Logger.d(this.TAG, this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
        }
        File file2 = new File(file, this.saveImageFileName);
        byte[] bArrDecode = Base64.decode(fileNameBase64, 0);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2, false);
            try {
                fileOutputStream.write(bArrDecode);
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            Logger.d(this.TAG, this.functionNameForLogBaseActivity + e.getMessage());
        }
        this.filesize = file2.length() / 1024;
        Logger.d(this.TAG, "filesize " + this.filesize);
        Logger.d(this.TAG, this.functionNameForLogBaseActivity + "imageUri : " + FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2));
        return FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void uploadPhoto(String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String Token, String reference, String uploadtype) {
        RestClient restClient = (RestClient) ApiClient.getClient1(this).create(RestClient.class);
        File file = new File(filepath + captureFileName);
        MultipartBody.Part partCreateFormData = MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data")));
        RequestBody requestBodyCreate = RequestBody.create(MediaType.parse("fileName"), captureFileName);
        restClient.uploadImageWithSIR(this.token, "blo", "BLOAPP", partCreateFormData, RequestBody.create(MediaType.parse("bucketName"), "objectstorage"), RequestBody.create(MediaType.parse("fileType"), "application/pdf"), requestBodyCreate, RequestBody.create(statecode, MediaType.parse("stateCode")), RequestBody.create(asmblyNo, MediaType.parse("acNo")), RequestBody.create(partno, MediaType.parse("partNo")), RequestBody.create("SR_FORM", MediaType.parse("type")), RequestBody.create("BLOAPP", MediaType.parse("appName"))).enqueue(new AnonymousClass24(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$24, reason: invalid class name */
    class AnonymousClass24 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass24(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v37, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 401) {
                CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                ?? r13 = ViewFormByAEROPage1.this;
                String str = ((ViewFormByAEROPage1) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$24$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                String strValueOf = String.valueOf(((JsonObject) response.body()).get("refId"));
                if (this.val$uploadtype.equals(ViewFormByAEROPage1.this.photostr)) {
                    ViewFormByAEROPage1.this.photoUrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(ViewFormByAEROPage1.this.photo1Str)) {
                    ViewFormByAEROPage1.this.srFormPage1UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(ViewFormByAEROPage1.this.photo2str)) {
                    ViewFormByAEROPage1.this.srFormPage2UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(ViewFormByAEROPage1.this.photo1strNew)) {
                    ViewFormByAEROPage1.this.relativeDocument1UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(ViewFormByAEROPage1.this.photo2strNew)) {
                    ViewFormByAEROPage1.this.relativeDocument2UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(ViewFormByAEROPage1.this.photo3strNew)) {
                    ViewFormByAEROPage1.this.relativeSupportingDocumentPage1UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                if (this.val$uploadtype.equals(ViewFormByAEROPage1.this.photo4strNew)) {
                    ViewFormByAEROPage1.this.relativeSupportingDocumentPage2UrlS = strValueOf.replace(RegexMatcher.JSON_STRING_REGEX, "");
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                    return;
                }
                return;
            }
            if (this.val$uploadtype.equals(ViewFormByAEROPage1.this.photostr)) {
                if (ViewFormByAEROPage1.this.alertDialog != null) {
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                ViewFormByAEROPage1.this.photocount = 0;
                ViewFormByAEROPage1.this.binding.passPhotoLayout.setVisibility(8);
                ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
                viewFormByAEROPage1.showDialog1(viewFormByAEROPage1.alertText, ViewFormByAEROPage1.this.fileNotFoundMessage);
                ViewFormByAEROPage1.this.binding.uploadElectorImage.setTextColor(Color.parseColor(ViewFormByAEROPage1.this.whitecolor));
                ViewFormByAEROPage1.this.binding.uploadElectorImage.setEnabled(true);
            }
            if (this.val$uploadtype.equals(ViewFormByAEROPage1.this.photo1Str)) {
                Log.d("Here", "Photo1 Str");
                if (ViewFormByAEROPage1.this.alertDialog != null) {
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                ViewFormByAEROPage1.this.photo1count = 0;
                ViewFormByAEROPage1.this.binding.annexPage1Layout.setVisibility(8);
                ViewFormByAEROPage1 viewFormByAEROPage2 = ViewFormByAEROPage1.this;
                viewFormByAEROPage2.showDialog1(viewFormByAEROPage2.alertText, ViewFormByAEROPage1.this.fileNotFoundMessage);
                ViewFormByAEROPage1.this.binding.uploadFrontPhoto.setTextColor(Color.parseColor(ViewFormByAEROPage1.this.whitecolor));
                ViewFormByAEROPage1.this.binding.uploadFrontPhoto.setEnabled(true);
            }
            if (this.val$uploadtype.equals(ViewFormByAEROPage1.this.photo2str)) {
                if (ViewFormByAEROPage1.this.alertDialog != null) {
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                ViewFormByAEROPage1.this.photo2count = 0;
                ViewFormByAEROPage1.this.binding.photo2Layout.setVisibility(8);
                ViewFormByAEROPage1 viewFormByAEROPage3 = ViewFormByAEROPage1.this;
                viewFormByAEROPage3.showDialog1(viewFormByAEROPage3.alertText, ViewFormByAEROPage1.this.fileNotFoundMessage);
                ViewFormByAEROPage1.this.binding.uploadBackPhoto.setTextColor(Color.parseColor(ViewFormByAEROPage1.this.whitecolor));
                ViewFormByAEROPage1.this.binding.uploadBackPhoto.setEnabled(true);
            }
            if (this.val$uploadtype.equals(ViewFormByAEROPage1.this.photo1strNew)) {
                if (ViewFormByAEROPage1.this.alertDialog != null) {
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                ViewFormByAEROPage1.this.photo1countNew = 0;
                ViewFormByAEROPage1.this.binding.enumerationFormPage1.setVisibility(8);
                ViewFormByAEROPage1 viewFormByAEROPage4 = ViewFormByAEROPage1.this;
                viewFormByAEROPage4.showDialog1(viewFormByAEROPage4.alertText, ViewFormByAEROPage1.this.fileNotFoundMessage);
                ViewFormByAEROPage1.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(ViewFormByAEROPage1.this.whitecolor));
                ViewFormByAEROPage1.this.binding.uploadEnumerationFormPage1.setEnabled(true);
            }
            if (this.val$uploadtype.equals(ViewFormByAEROPage1.this.photo2strNew)) {
                if (ViewFormByAEROPage1.this.alertDialog != null) {
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                ViewFormByAEROPage1.this.photo2countNew = 0;
                ViewFormByAEROPage1.this.binding.enumerationFormPage2.setVisibility(8);
                ViewFormByAEROPage1 viewFormByAEROPage5 = ViewFormByAEROPage1.this;
                viewFormByAEROPage5.showDialog1(viewFormByAEROPage5.alertText, ViewFormByAEROPage1.this.fileNotFoundMessage);
                ViewFormByAEROPage1.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(ViewFormByAEROPage1.this.whitecolor));
                ViewFormByAEROPage1.this.binding.uploadEnumerationFormPage2.setEnabled(true);
            }
            if (this.val$uploadtype.equals(ViewFormByAEROPage1.this.photo3strNew)) {
                if (ViewFormByAEROPage1.this.alertDialog != null) {
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                ViewFormByAEROPage1.this.photo3countNew = 0;
                ViewFormByAEROPage1.this.binding.supportingDocumentsPage1.setVisibility(8);
                ViewFormByAEROPage1 viewFormByAEROPage6 = ViewFormByAEROPage1.this;
                viewFormByAEROPage6.showDialog1(viewFormByAEROPage6.alertText, ViewFormByAEROPage1.this.fileNotFoundMessage);
                ViewFormByAEROPage1.this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(ViewFormByAEROPage1.this.whitecolor));
                ViewFormByAEROPage1.this.binding.uploadSupportingDocumentsPage1.setEnabled(true);
            }
            if (this.val$uploadtype.equals(ViewFormByAEROPage1.this.photo4strNew)) {
                if (ViewFormByAEROPage1.this.alertDialog != null) {
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                ViewFormByAEROPage1.this.photo4countNew = 0;
                ViewFormByAEROPage1.this.binding.supportingDocumentsPage2.setVisibility(8);
                ViewFormByAEROPage1 viewFormByAEROPage7 = ViewFormByAEROPage1.this;
                viewFormByAEROPage7.showDialog1(viewFormByAEROPage7.alertText, ViewFormByAEROPage1.this.fileNotFoundMessage);
                ViewFormByAEROPage1.this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(ViewFormByAEROPage1.this.whitecolor));
                ViewFormByAEROPage1.this.binding.uploadSupportingDocumentsPage2.setEnabled(true);
            }
            ViewFormByAEROPage1.this.alertDialog.dismiss();
            try {
                Logger.d("", new JSONObject(response.errorBody().string()).toString());
            } catch (IOException | JSONException e) {
                Logger.d("", e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public /* synthetic */ void lambda$onResponse$1(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9) {
            System.out.println("zxnbchdbvfhvb12 " + i + " " + str8 + " " + str9);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                ?? r2 = ViewFormByAEROPage1.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$24$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ViewFormByAEROPage1.this.token = "Bearer " + str8;
            ViewFormByAEROPage1.this.refreshToken = str9;
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setToken("Bearer " + str8);
            ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
            viewFormByAEROPage1.uploadPhoto(str, str2, str3, str4, str5, viewFormByAEROPage1.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAEROPage1.this.startActivity(new Intent((Context) ViewFormByAEROPage1.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (this.val$uploadtype.equals(ViewFormByAEROPage1.this.photostr)) {
                if (ViewFormByAEROPage1.this.photocount < 2 && TextUtils.isEmpty(ViewFormByAEROPage1.this.photoUrlS)) {
                    ViewFormByAEROPage1.this.photocount++;
                    ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage1.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, viewFormByAEROPage1.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                    ViewFormByAEROPage1.this.photocount = 0;
                    ViewFormByAEROPage1.this.binding.passPhotoLayout.setVisibility(8);
                    ViewFormByAEROPage1 viewFormByAEROPage2 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage2.showDialog1(viewFormByAEROPage2.alertText, ViewFormByAEROPage1.this.fileNotFoundMessage);
                    ViewFormByAEROPage1.this.binding.uploadElectorImage.setTextColor(Color.parseColor(ViewFormByAEROPage1.this.whitecolor));
                    ViewFormByAEROPage1.this.binding.uploadElectorImage.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(ViewFormByAEROPage1.this.photo1Str)) {
                if (ViewFormByAEROPage1.this.photo1count < 2 && TextUtils.isEmpty(ViewFormByAEROPage1.this.srFormPage1UrlS)) {
                    ViewFormByAEROPage1.this.photo1count++;
                    ViewFormByAEROPage1 viewFormByAEROPage3 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage3.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, viewFormByAEROPage3.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                    ViewFormByAEROPage1.this.photo1count = 0;
                    ViewFormByAEROPage1.this.binding.annexPage1Layout.setVisibility(8);
                    ViewFormByAEROPage1 viewFormByAEROPage4 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage4.showDialog1(viewFormByAEROPage4.alertText, ViewFormByAEROPage1.this.fileNotFoundMessage);
                    ViewFormByAEROPage1.this.binding.uploadFrontPhoto.setTextColor(Color.parseColor(ViewFormByAEROPage1.this.whitecolor));
                    ViewFormByAEROPage1.this.binding.uploadFrontPhoto.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(ViewFormByAEROPage1.this.photo2str)) {
                if (ViewFormByAEROPage1.this.photo2count < 2 && TextUtils.isEmpty(ViewFormByAEROPage1.this.srFormPage2UrlS)) {
                    ViewFormByAEROPage1.this.photo2count++;
                    ViewFormByAEROPage1 viewFormByAEROPage5 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage5.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, viewFormByAEROPage5.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                    ViewFormByAEROPage1.this.photo2count = 0;
                    ViewFormByAEROPage1.this.binding.photo2Layout.setVisibility(8);
                    ViewFormByAEROPage1 viewFormByAEROPage6 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage6.showDialog1(viewFormByAEROPage6.alertText, ViewFormByAEROPage1.this.fileNotFoundMessage);
                    ViewFormByAEROPage1.this.binding.uploadBackPhoto.setTextColor(Color.parseColor(ViewFormByAEROPage1.this.whitecolor));
                    ViewFormByAEROPage1.this.binding.uploadBackPhoto.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(ViewFormByAEROPage1.this.photo1strNew)) {
                if (ViewFormByAEROPage1.this.photo1countNew < 2 && TextUtils.isEmpty(ViewFormByAEROPage1.this.relativeDocument1UrlS)) {
                    ViewFormByAEROPage1.this.photo1countNew++;
                    ViewFormByAEROPage1 viewFormByAEROPage7 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage7.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, viewFormByAEROPage7.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                    ViewFormByAEROPage1.this.photo1countNew = 0;
                    ViewFormByAEROPage1.this.binding.enumerationFormPage1.setVisibility(8);
                    ViewFormByAEROPage1 viewFormByAEROPage8 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage8.showDialog1(viewFormByAEROPage8.alertText, ViewFormByAEROPage1.this.fileNotFoundMessage);
                    ViewFormByAEROPage1.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(ViewFormByAEROPage1.this.whitecolor));
                    ViewFormByAEROPage1.this.binding.uploadEnumerationFormPage2.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(ViewFormByAEROPage1.this.photo2strNew)) {
                if (ViewFormByAEROPage1.this.photo2countNew < 2 && TextUtils.isEmpty(ViewFormByAEROPage1.this.relativeDocument2UrlS)) {
                    ViewFormByAEROPage1.this.photo2countNew++;
                    ViewFormByAEROPage1 viewFormByAEROPage9 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage9.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, viewFormByAEROPage9.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                    ViewFormByAEROPage1.this.photo2countNew = 0;
                    ViewFormByAEROPage1.this.binding.enumerationFormPage2.setVisibility(8);
                    ViewFormByAEROPage1 viewFormByAEROPage10 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage10.showDialog1(viewFormByAEROPage10.alertText, ViewFormByAEROPage1.this.fileNotFoundMessage);
                    ViewFormByAEROPage1.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(ViewFormByAEROPage1.this.whitecolor));
                    ViewFormByAEROPage1.this.binding.uploadEnumerationFormPage2.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(ViewFormByAEROPage1.this.photo3strNew)) {
                if (ViewFormByAEROPage1.this.photo3countNew < 2 && TextUtils.isEmpty(ViewFormByAEROPage1.this.relativeSupportingDocumentPage1UrlS)) {
                    ViewFormByAEROPage1.this.photo3countNew++;
                    ViewFormByAEROPage1 viewFormByAEROPage11 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage11.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, viewFormByAEROPage11.token, this.val$reference, this.val$uploadtype);
                } else {
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                    ViewFormByAEROPage1.this.photo3countNew = 0;
                    ViewFormByAEROPage1.this.binding.supportingDocumentsPage1.setVisibility(8);
                    ViewFormByAEROPage1 viewFormByAEROPage12 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage12.showDialog1(viewFormByAEROPage12.alertText, ViewFormByAEROPage1.this.fileNotFoundMessage);
                    ViewFormByAEROPage1.this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(ViewFormByAEROPage1.this.whitecolor));
                    ViewFormByAEROPage1.this.binding.uploadEnumerationFormPage1.setEnabled(true);
                }
            }
            if (this.val$uploadtype.equals(ViewFormByAEROPage1.this.photo4strNew)) {
                if (ViewFormByAEROPage1.this.photo4countNew < 2 && TextUtils.isEmpty(ViewFormByAEROPage1.this.relativeSupportingDocumentPage2UrlS)) {
                    ViewFormByAEROPage1.this.photo4countNew++;
                    ViewFormByAEROPage1 viewFormByAEROPage13 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage13.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, viewFormByAEROPage13.token, this.val$reference, this.val$uploadtype);
                    return;
                }
                if (ViewFormByAEROPage1.this.alertDialog != null) {
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                ViewFormByAEROPage1.this.photo4countNew = 0;
                ViewFormByAEROPage1.this.binding.supportingDocumentsPage2.setVisibility(8);
                ViewFormByAEROPage1 viewFormByAEROPage14 = ViewFormByAEROPage1.this;
                viewFormByAEROPage14.showDialog1(viewFormByAEROPage14.alertText, ViewFormByAEROPage1.this.fileNotFoundMessage);
                ViewFormByAEROPage1.this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(ViewFormByAEROPage1.this.whitecolor));
                ViewFormByAEROPage1.this.binding.uploadEnumerationFormPage2.setEnabled(true);
            }
        }
    }

    public void faceRecognition(String statecode, String asmblyNo, String partno, String filepath, String captureFileName, String Token, String reference, String uploadtype) {
        RestClient restClient = (RestClient) ApiClient.getClient1(getApplicationContext()).create(RestClient.class);
        File file = new File(filepath + captureFileName);
        restClient.faceRecognitionApi(Token, SharedPref.getInstance(getApplicationContext()).getAtknBnd(), SharedPref.getInstance(getApplicationContext()).getRtknBnd(), "BLOAPP", statecode, "blo", "BLOAPP", MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data"))), RequestBody.create("image/" + captureFileName.substring(captureFileName.lastIndexOf(".")), MediaType.parse("fileType"))).enqueue(new AnonymousClass25(statecode, asmblyNo, partno, filepath, captureFileName, reference, uploadtype));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$25, reason: invalid class name */
    class AnonymousClass25 implements Callback<JsonObject> {
        final /* synthetic */ String val$asmblyNo;
        final /* synthetic */ String val$captureFileName;
        final /* synthetic */ String val$filepath;
        final /* synthetic */ String val$partno;
        final /* synthetic */ String val$reference;
        final /* synthetic */ String val$statecode;
        final /* synthetic */ String val$uploadtype;

        AnonymousClass25(final String val$statecode, final String val$asmblyNo, final String val$partno, final String val$filepath, final String val$captureFileName, final String val$reference, final String val$uploadtype) {
            this.val$statecode = val$statecode;
            this.val$asmblyNo = val$asmblyNo;
            this.val$partno = val$partno;
            this.val$filepath = val$filepath;
            this.val$captureFileName = val$captureFileName;
            this.val$reference = val$reference;
            this.val$uploadtype = val$uploadtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v5, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 401) {
                CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                ?? r13 = ViewFormByAEROPage1.this;
                String str = ((ViewFormByAEROPage1) r13).refreshToken;
                final String str2 = this.val$statecode;
                final String str3 = this.val$asmblyNo;
                final String str4 = this.val$partno;
                final String str5 = this.val$filepath;
                final String str6 = this.val$captureFileName;
                final String str7 = this.val$reference;
                final String str8 = this.val$uploadtype;
                commomUtility.getRefreshToken(r13, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$25$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str9, String str10) {
                        this.f$0.lambda$onResponse$1(str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
                    }
                });
                return;
            }
            if (response.code() == 200) {
                ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
                viewFormByAEROPage1.uploadPhoto(this.val$statecode, this.val$asmblyNo, this.val$partno, this.val$filepath, this.val$captureFileName, viewFormByAEROPage1.token, this.val$reference, this.val$uploadtype);
                return;
            }
            try {
                ViewFormByAEROPage1.this.binding.passPhotoLayout.setVisibility(8);
                ViewFormByAEROPage1.this.binding.uploadElectorImage.setEnabled(true);
                ViewFormByAEROPage1.this.binding.uploadElectorImage.setTextColor(Color.parseColor(ViewFormByAEROPage1.this.blackColor));
                new JSONObject(response.errorBody().string());
                ViewFormByAEROPage1 viewFormByAEROPage2 = ViewFormByAEROPage1.this;
                viewFormByAEROPage2.showDialog1(viewFormByAEROPage2.alertText, ViewFormByAEROPage1.this.getString(R.string.sizeOrHumanFaceMsg));
            } catch (IOException | JSONException e) {
                Logger.d("ViewFormByAeroPage1", e.toString());
            }
            ViewFormByAEROPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public /* synthetic */ void lambda$onResponse$1(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9) {
            System.out.println("zxnbchdbvfhvb12 " + i + " " + str8 + " " + str9);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                ?? r2 = ViewFormByAEROPage1.this;
                commomUtility.showMessageOK(r2, r2.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$25$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            ViewFormByAEROPage1.this.token = "Bearer " + str8;
            ViewFormByAEROPage1.this.refreshToken = str9;
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setRefreshToken(str9);
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setToken("Bearer " + str8);
            ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
            viewFormByAEROPage1.faceRecognition(str, str2, str3, str4, str5, viewFormByAEROPage1.token, str6, str7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAEROPage1.this.startActivity(new Intent((Context) ViewFormByAEROPage1.this, (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            ViewFormByAEROPage1.this.binding.passPhotoLayout.setVisibility(8);
            ViewFormByAEROPage1.this.binding.uploadElectorImage.setEnabled(true);
            ViewFormByAEROPage1.this.binding.uploadElectorImage.setTextColor(Color.parseColor(ViewFormByAEROPage1.this.blackColor));
            Logger.d(" ", t.getMessage());
            ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
            viewFormByAEROPage1.showDialog1(viewFormByAEROPage1.alertText, t.getMessage());
            ViewFormByAEROPage1.this.alertDialog.dismiss();
        }
    }

    private void deleteAnnexure(int code) {
        if (code == 102) {
            this.binding.uploadFrontPhoto.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadFrontPhoto.setEnabled(true);
            this.binding.annexPage1Layout.setVisibility(8);
            this.binding.photo1Size.setText("");
            this.srFormPage1UrlS = "";
            this.binding.photo1Name.setText("");
            this.binding.firstLL.setVisibility(8);
            this.binding.uploadFrontPhoto.setVisibility(0);
            this.binding.fbUploadLL.setVisibility(0);
            if (TextUtils.isEmpty(this.srFormPage1UrlS) && TextUtils.isEmpty(this.srFormPage2UrlS) && TextUtils.isEmpty(this.annexureCUrlS)) {
                this.binding.uploadBackPhoto.setVisibility(0);
            }
            this.srFormPage1UrlS = "";
            if (!TextUtils.isEmpty(this.annexureCUrlS)) {
                this.annexureCUrlS = "";
                this.binding.secondLL.setVisibility(8);
                this.binding.uploadBackPhoto.setVisibility(0);
            }
        }
        if (code == 103) {
            this.binding.uploadBackPhoto.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadBackPhoto.setEnabled(true);
            this.binding.photo2Layout.setVisibility(8);
            this.srFormPage2UrlS = "";
            this.binding.photo2Size.setText("");
            this.binding.photo2Name.setText("");
            this.binding.secondLL.setVisibility(8);
            this.binding.uploadBackPhoto.setVisibility(0);
            if (TextUtils.isEmpty(this.srFormPage1UrlS) && TextUtils.isEmpty(this.srFormPage2UrlS) && TextUtils.isEmpty(this.annexureCUrlS)) {
                this.binding.uploadFrontPhoto.setVisibility(0);
            }
            this.binding.fbUploadLL.setVisibility(0);
            this.srFormPage2UrlS = "";
        }
    }

    private void showdialogref(String title, String msg, final String type, final String filepathimg, final String captureFileName) {
        new android.app.AlertDialog.Builder(getApplicationContext()).setTitle(title).setMessage(msg).setCancelable(false).setPositiveButton(getString(R.string.retryMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda15
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showdialogref$20(filepathimg, captureFileName, type, dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showdialogref$20(String str, String str2, String str3, DialogInterface dialogInterface, int i) {
        this.alertDialog.show();
        dialogInterface.dismiss();
        uploadPhoto(this.state, this.asmblyNO, this.partNo, str, str2, this.token, this.referenceNo, str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog2(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.yesMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda12
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$21(dialogInterface, i);
            }
        }).setNegativeButton(getString(R.string.cancelMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda13
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog2$22(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$21(DialogInterface dialogInterface, int i) {
        this.binding.submitLayout.setVisibility(0);
        this.binding.nextButton.setVisibility(8);
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog2$22(DialogInterface dialogInterface, int i) {
        this.binding.submitLayout.setVisibility(0);
        this.binding.nextButton.setVisibility(8);
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDialog3(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton(getString(R.string.okMsg), new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda16
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog3$23(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showDialog3$23(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
        Intent intent = new Intent((Context) this, (Class<?>) FormDataForBloModificationList.class);
        intent.setFlags(67108864);
        intent.putExtra("restart", true);
        startActivity(intent);
    }

    private void showPersonPdfDialog(File preSignedUrl, String pdfNameFromObjectStorage) throws IOException {
        final Dialog dialog = new Dialog((Context) Objects.requireNonNull(this));
        dialog.setContentView(R.layout.blo_person_pdf_dialog_layout);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_dialog_cancel_button);
        PDFView pDFViewFindViewById = dialog.findViewById(R.id.person_pdf_card).findViewById(R.id.person_pdfView);
        TextView textView = (TextView) dialog.findViewById(R.id.person_dialog_pdf_name);
        pDFViewFindViewById.fromFile(preSignedUrl).pages(new int[]{0, 2, 1, 3, 3, 3}).enableSwipe(true).enableDoubletap(true).defaultPage(0).enableAnnotationRendering(false).password((String) null).load();
        textView.setText(pdfNameFromObjectStorage);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Uri getSaveImagePath(String fileNameBase64, String documentTypeSelected) throws IOException {
        this.functionNameForLogBaseActivity = "getSaveImagePath ";
        String str = new SimpleDateFormat("ddMMyyyyHHMMSS").format(new Date());
        File file = new File(getExternalFilesDir(null) + this.garudaTextBaseActivity);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (documentTypeSelected.equals(this.imageTextBaseActivity)) {
            this.saveImageFileName = "img_" + str + this.jpgTextBaseActivity;
        } else if (documentTypeSelected.equals(this.pdfTextBaseActivity)) {
            this.saveImageFileName = "pdf_document" + str + this.pdfTextBaseActivity;
        }
        File file2 = new File(file, this.saveImageFileName);
        byte[] bArrDecode = Base64.decode(fileNameBase64, 0);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2, false);
            try {
                fileOutputStream.write(bArrDecode);
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            Log.d("Value3", this.functionNameForLogBaseActivity + e.getMessage());
        }
        this.filesize = file2.length() / 1024;
        Logger.d("Test1= ", "filesize " + this.filesize);
        Logger.d("Test2= ", this.functionNameForLogBaseActivity + "imageUri : " + FileProvider.getUriForFile(this, "in.gov.eci.bloapp.provider", file2));
        return FileProvider.getUriForFile(this, "in.gov.eci.bloapp.provider", file2);
    }

    private void setRelationList() {
        this.relationList.add(this.selectRelationType);
        this.relationList.add("Self");
        this.relationList.add("Mother");
        this.relationList.add("Father");
        this.relationList.add("Spouse");
        this.relationList.add("Grand Father");
        this.relationList.add("Grand Mother");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deletePhoto(int code) {
        if (code == 201) {
            this.relativeDocument1UrlS = null;
            this.binding.uploadEnumerationFormPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadEnumerationFormPage1.setEnabled(true);
            this.binding.enumerationFormPage1Image.setVisibility(8);
            this.binding.enumerationFormPage1ImageSize.setText("");
            this.binding.enumerationFormPage1ImageName.setText("");
            this.binding.cancelEnumerationFormPage1Image.setVisibility(8);
            if (TextUtils.isEmpty(this.relativeDocument2UrlS) && TextUtils.isEmpty(this.relativeDocument1UrlS)) {
                this.binding.enumerationFormPage1.setVisibility(8);
                this.binding.enumerationFormPage2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 202) {
            this.relativeDocument2UrlS = null;
            this.binding.uploadEnumerationFormPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadEnumerationFormPage2.setEnabled(true);
            this.binding.enumerationFormPage2Image.setVisibility(8);
            this.binding.enumerationFormPage2ImageSize.setText("");
            this.binding.enumerationFormPage2ImageName.setText("");
            this.binding.cancelEnumerationFormPage2Image.setVisibility(8);
            if (TextUtils.isEmpty(this.relativeDocument2UrlS) && TextUtils.isEmpty(this.relativeDocument1UrlS)) {
                this.binding.enumerationFormPage1.setVisibility(8);
                this.binding.enumerationFormPage2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 203) {
            this.relativeSupportingDocumentPage1UrlS = null;
            this.binding.uploadSupportingDocumentsPage1.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadSupportingDocumentsPage1.setEnabled(true);
            this.binding.supportingDocumentsPage1Image.setVisibility(8);
            this.binding.supportingDocumentsPage1ImageName.setText("");
            this.binding.supportingDocumentsPage1ImageSize.setText("");
            this.binding.cancelSupportingDocumentsPage1Image.setVisibility(8);
            if (TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
                this.binding.supportingDocumentsPage1.setVisibility(8);
                this.binding.supportingDocumentsPage2.setVisibility(8);
                return;
            }
            return;
        }
        if (code == 204) {
            this.relativeSupportingDocumentPage2UrlS = null;
            this.binding.uploadSupportingDocumentsPage2.setTextColor(Color.parseColor(this.whitecolor));
            this.binding.uploadSupportingDocumentsPage2.setEnabled(true);
            this.binding.supportingDocumentsPage2Image.setVisibility(8);
            this.binding.supportingDocumentsPage2ImageName.setText("");
            this.binding.supportingDocumentsPage2ImageSize.setText("");
            this.binding.cancelSupportingDocumentsPage2Image.setVisibility(8);
            if (TextUtils.isEmpty(this.relativeSupportingDocumentPage1UrlS) && TextUtils.isEmpty(this.relativeSupportingDocumentPage2UrlS)) {
                this.binding.supportingDocumentsPage1.setVisibility(8);
                this.binding.supportingDocumentsPage2.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getList1(String list) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("Content-Type", "application/json");
        map.put("state", this.state);
        map.put("currentRole", "blo");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("lists", list);
        ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).getSpecialRevisionListSIR(map, map2).enqueue(new AnonymousClass26(list));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$26, reason: invalid class name */
    class AnonymousClass26 implements Callback<JsonObject> {
        final /* synthetic */ String val$list;

        AnonymousClass26(final String val$list) {
            this.val$list = val$list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v12, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference failed for: r9v13, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                if (ViewFormByAEROPage1.this.alertDialog != null) {
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                ViewFormByAEROPage1.this.payloadData1 = (JsonObject) response.body();
                if (ViewFormByAEROPage1.this.payloadData1 != null) {
                    JsonArray asJsonArray = ViewFormByAEROPage1.this.payloadData1.getAsJsonArray("payload");
                    int size = asJsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonObject asJsonObject = ViewFormByAEROPage1.this.gson.toJsonTree(asJsonArray.get(i)).getAsJsonObject();
                        if (this.val$list.equalsIgnoreCase("LIST-8") && ViewFormByAEROPage1.this.List8docName.size() != size + 1) {
                            ViewFormByAEROPage1.this.List8docName.add(String.valueOf(asJsonObject.get("docName")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            ViewFormByAEROPage1.this.List8docCode.add(String.valueOf(asJsonObject.get("docCode")).replace(RegexMatcher.JSON_STRING_REGEX, ""));
                            if (!ViewFormByAEROPage1.this.List8docName.contains(ViewFormByAEROPage1.this.selectDocumentType)) {
                                ViewFormByAEROPage1.this.List8docName.add(0, ViewFormByAEROPage1.this.selectDocumentType);
                                ViewFormByAEROPage1.this.List8docCode.add(0, null);
                            }
                            ?? r3 = ViewFormByAEROPage1.this;
                            ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r3, R.layout.blo_spinner_dropdown, r3.List8docName);
                            arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item_sir);
                            ViewFormByAEROPage1.this.binding.spinnerIR.setAdapter((SpinnerAdapter) arrayAdapter);
                            if (ViewFormByAEROPage1.this.intent.getStringExtra("relationListList8DocCode") == null || ViewFormByAEROPage1.this.intent.getStringExtra("relationListList8DocCode").equals("")) {
                                ViewFormByAEROPage1.this.binding.spinnerIR.setSelection(0);
                            } else {
                                ViewFormByAEROPage1.this.binding.spinnerIR.setSelection(ViewFormByAEROPage1.this.List8docCode.indexOf(ViewFormByAEROPage1.this.intent.getStringExtra("relationListList8DocCode")));
                            }
                        }
                    }
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                if (ViewFormByAEROPage1.this.alertDialog != null) {
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                try {
                    CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                    ?? r9 = ViewFormByAEROPage1.this;
                    String str = ((ViewFormByAEROPage1) r9).refreshToken;
                    final String str2 = this.val$list;
                    commomUtility.getRefreshToken(r9, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$26$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i2, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i2, str3, str4);
                        }
                    });
                    return;
                } catch (Exception e) {
                    Logger.e(ViewFormByAEROPage1.this.TAG, e.toString());
                    return;
                }
            }
            try {
                if (ViewFormByAEROPage1.this.alertDialog != null) {
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                Logger.e(ViewFormByAEROPage1.this.TAG, new JSONObject(response.errorBody().string()).optString("message"));
            } catch (IOException | JSONException e2) {
                if (ViewFormByAEROPage1.this.alertDialog != null) {
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                Logger.e(ViewFormByAEROPage1.this.TAG, e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            ViewFormByAEROPage1.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                ?? r5 = ViewFormByAEROPage1.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$26$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAEROPage1.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAEROPage1.this.getList1(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAEROPage1.this.startActivity(new Intent(ViewFormByAEROPage1.this.getApplication(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            if (ViewFormByAEROPage1.this.alertDialog != null) {
                ViewFormByAEROPage1.this.alertDialog.dismiss();
            }
            Logger.d(ViewFormByAEROPage1.this.TAG, "OnFailure" + t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile11(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass27(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$27, reason: invalid class name */
    class AnonymousClass27 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass27(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                if (ViewFormByAEROPage1.this.alertDialog != null) {
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                ViewFormByAEROPage1.this.preSignedurl11 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAEROPage1.this).load(ViewFormByAEROPage1.this.preSignedurl11).into(ViewFormByAEROPage1.this.binding.frontImageNew);
                } else {
                    ViewFormByAEROPage1.this.binding.frontImageNew.setImageDrawable(ContextCompat.getDrawable(ViewFormByAEROPage1.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage1.downloadPdfToCache(viewFormByAEROPage1.preSignedurl11, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.27.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAEROPage1.this.file11 = file;
                            Log.e("GETFILE", "FILE1::" + ViewFormByAEROPage1.this.file11);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAEROPage1.this.preSignedurl11)) {
                    ViewFormByAEROPage1.this.binding.frontImageNew.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAEROPage1.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                    ?? r5 = ViewFormByAEROPage1.this;
                    String str = ((ViewFormByAEROPage1) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$27$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAEROPage1.this.TAG, ViewFormByAEROPage1.this.comingTag);
                }
            } else {
                try {
                    ViewFormByAEROPage1.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$27$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(ViewFormByAEROPage1.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAEROPage1.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAEROPage1.this.TAG, e.getMessage());
                }
            }
            ViewFormByAEROPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            ViewFormByAEROPage1.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                ?? r5 = ViewFormByAEROPage1.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$27$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAEROPage1.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAEROPage1.this.getFile11(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAEROPage1.this.startActivity(new Intent((Context) ViewFormByAEROPage1.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewFormByAEROPage1.this.alertDialog != null) {
                ViewFormByAEROPage1.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAEROPage1.this.TAG, ViewFormByAEROPage1.this.comingTag + t.getMessage());
            if (ViewFormByAEROPage1.this.alertDialog != null) {
                ViewFormByAEROPage1.this.alertDialog.dismiss();
            }
            ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
            viewFormByAEROPage1.showDialog1(viewFormByAEROPage1.getString(R.string.alertMsg), t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile21(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass28(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$28, reason: invalid class name */
    class AnonymousClass28 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass28(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                if (ViewFormByAEROPage1.this.alertDialog != null) {
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                ViewFormByAEROPage1.this.preSignedurl21 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAEROPage1.this).load(ViewFormByAEROPage1.this.preSignedurl21).into(ViewFormByAEROPage1.this.binding.backImageNew);
                } else {
                    ViewFormByAEROPage1.this.binding.backImageNew.setImageDrawable(ContextCompat.getDrawable(ViewFormByAEROPage1.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage1.downloadPdfToCache(viewFormByAEROPage1.preSignedurl21, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.28.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAEROPage1.this.file21 = file;
                            Log.e("GETFILE", "FILE21::" + ViewFormByAEROPage1.this.file21);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAEROPage1.this.preSignedurl21)) {
                    ViewFormByAEROPage1.this.binding.backImageNew.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAEROPage1.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                    ?? r5 = ViewFormByAEROPage1.this;
                    String str = ((ViewFormByAEROPage1) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$28$$ExternalSyntheticLambda0
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAEROPage1.this.TAG, ViewFormByAEROPage1.this.comingTag);
                }
            } else {
                try {
                    ViewFormByAEROPage1.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$28$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(ViewFormByAEROPage1.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAEROPage1.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAEROPage1.this.TAG, e.getMessage());
                }
            }
            ViewFormByAEROPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            ViewFormByAEROPage1.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                ?? r5 = ViewFormByAEROPage1.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$28$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAEROPage1.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAEROPage1.this.getFile21(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAEROPage1.this.startActivity(new Intent((Context) ViewFormByAEROPage1.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewFormByAEROPage1.this.alertDialog != null) {
                ViewFormByAEROPage1.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAEROPage1.this.TAG, ViewFormByAEROPage1.this.comingTag + t.getMessage());
            if (ViewFormByAEROPage1.this.alertDialog != null) {
                ViewFormByAEROPage1.this.alertDialog.dismiss();
            }
            ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
            viewFormByAEROPage1.showDialog1(viewFormByAEROPage1.getString(R.string.alertMsg), t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile31(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass29(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$29, reason: invalid class name */
    class AnonymousClass29 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass29(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                if (ViewFormByAEROPage1.this.alertDialog != null) {
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                ViewFormByAEROPage1.this.preSignedurl31 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAEROPage1.this).load(ViewFormByAEROPage1.this.preSignedurl31).into(ViewFormByAEROPage1.this.binding.frontImage1);
                } else {
                    ViewFormByAEROPage1.this.binding.frontImage1.setImageDrawable(ContextCompat.getDrawable(ViewFormByAEROPage1.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage1.downloadPdfToCache(viewFormByAEROPage1.preSignedurl31, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.29.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAEROPage1.this.file31 = file;
                            Log.e("GETFILE", "FILE31::" + ViewFormByAEROPage1.this.file31);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAEROPage1.this.preSignedurl31)) {
                    ViewFormByAEROPage1.this.binding.frontImage1.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAEROPage1.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                    ?? r5 = ViewFormByAEROPage1.this;
                    String str = ((ViewFormByAEROPage1) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$29$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAEROPage1.this.TAG, ViewFormByAEROPage1.this.comingTag);
                }
            } else {
                try {
                    ViewFormByAEROPage1.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$29$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(ViewFormByAEROPage1.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAEROPage1.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAEROPage1.this.TAG, e.getMessage());
                }
            }
            ViewFormByAEROPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            ViewFormByAEROPage1.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                ?? r5 = ViewFormByAEROPage1.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$29$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAEROPage1.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAEROPage1.this.getFile31(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAEROPage1.this.startActivity(new Intent((Context) ViewFormByAEROPage1.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewFormByAEROPage1.this.alertDialog != null) {
                ViewFormByAEROPage1.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAEROPage1.this.TAG, ViewFormByAEROPage1.this.comingTag + t.getMessage());
            if (ViewFormByAEROPage1.this.alertDialog != null) {
                ViewFormByAEROPage1.this.alertDialog.dismiss();
            }
            ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
            viewFormByAEROPage1.showDialog1(viewFormByAEROPage1.getString(R.string.alertMsg), t.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getFile41(String fileref) {
        this.alertDialog.show();
        this.commomUtility.getRetrofitClient(this, this.token, this.atkband, this.rtkband).getFileforSIRPN(this.objectStorageString, fileref, this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass30(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$30, reason: invalid class name */
    class AnonymousClass30 implements Callback<JsonObject> {
        final /* synthetic */ String val$fileref;

        AnonymousClass30(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v15, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            if (response.code() == 200) {
                if (ViewFormByAEROPage1.this.alertDialog != null) {
                    ViewFormByAEROPage1.this.alertDialog.dismiss();
                }
                ViewFormByAEROPage1.this.preSignedurl41 = ((JsonObject) response.body()).get("preSignedUrl").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                if (!this.val$fileref.endsWith(".pdf")) {
                    Glide.with(ViewFormByAEROPage1.this).load(ViewFormByAEROPage1.this.preSignedurl41).into(ViewFormByAEROPage1.this.binding.backImage1);
                } else {
                    ViewFormByAEROPage1.this.binding.backImage1.setImageDrawable(ContextCompat.getDrawable(ViewFormByAEROPage1.this, R.drawable.blo_pdf_thumbnail));
                    ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
                    viewFormByAEROPage1.downloadPdfToCache(viewFormByAEROPage1.preSignedurl41, new pdfDownloadCallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1.30.1
                        @Override // in.gov.eci.bloapp.pdfDownloadCallback
                        public void downloaded(File file) {
                            ViewFormByAEROPage1.this.file41 = file;
                            Log.e("GETFILE", "FILE41::" + ViewFormByAEROPage1.this.file41);
                        }
                    });
                }
                if (TextUtils.isEmpty(ViewFormByAEROPage1.this.preSignedurl41)) {
                    ViewFormByAEROPage1.this.binding.backImage1.setImageBitmap(BitmapFactory.decodeResource(ViewFormByAEROPage1.this.getResources(), R.drawable.blo_dummy_image));
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                }
            } else if (response.code() == 401) {
                try {
                    CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                    ?? r5 = ViewFormByAEROPage1.this;
                    String str = ((ViewFormByAEROPage1) r5).refreshToken;
                    final String str2 = this.val$fileref;
                    commomUtility.getRefreshToken(r5, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$30$$ExternalSyntheticLambda1
                        @Override // in.gov.eci.bloapp.aadharcallback
                        public final void onCallBack(int i, String str3, String str4) {
                            this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                        }
                    });
                } catch (Exception unused) {
                    Logger.e(ViewFormByAEROPage1.this.TAG, ViewFormByAEROPage1.this.comingTag);
                }
            } else {
                try {
                    ViewFormByAEROPage1.this.runOnUiThread(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$30$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onResponse$2();
                        }
                    });
                    Logger.e(ViewFormByAEROPage1.this.TAG, new JSONObject(response.errorBody().string()).optString(ViewFormByAEROPage1.this.messageString));
                } catch (IOException | JSONException e) {
                    if (ViewFormByAEROPage1.this.alertDialog != null) {
                        ViewFormByAEROPage1.this.alertDialog.dismiss();
                    }
                    Logger.e(ViewFormByAEROPage1.this.TAG, e.getMessage());
                }
            }
            ViewFormByAEROPage1.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            ViewFormByAEROPage1.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + " " + str2 + " " + str3);
            if (i == 401 || i == 400) {
                CommomUtility commomUtility = ViewFormByAEROPage1.this.commomUtility;
                ?? r5 = ViewFormByAEROPage1.this;
                commomUtility.showMessageOK(r5, r5.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$30$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
            } else {
                ViewFormByAEROPage1.this.token = "Bearer " + str2;
                SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setRefreshToken(str3);
                SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setToken("Bearer " + str2);
                ViewFormByAEROPage1.this.getFile41(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(ViewFormByAEROPage1.this.getApplicationContext()).setLocaleBool(false);
            ViewFormByAEROPage1.this.startActivity(new Intent((Context) ViewFormByAEROPage1.this, (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2() {
            if (ViewFormByAEROPage1.this.alertDialog != null) {
                ViewFormByAEROPage1.this.alertDialog.dismiss();
            }
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.e(ViewFormByAEROPage1.this.TAG, ViewFormByAEROPage1.this.comingTag + t.getMessage());
            if (ViewFormByAEROPage1.this.alertDialog != null) {
                ViewFormByAEROPage1.this.alertDialog.dismiss();
            }
            ViewFormByAEROPage1 viewFormByAEROPage1 = ViewFormByAEROPage1.this;
            viewFormByAEROPage1.showDialog1(viewFormByAEROPage1.getString(R.string.alertMsg), t.getMessage());
        }
    }

    public void downloadPdfToCache(final String preSignedUrl, final pdfDownloadCallback callback) {
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: in.gov.eci.bloapp.views.activity.sir.ViewFormByAEROPage1$$ExternalSyntheticLambda17
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$downloadPdfToCache$25(preSignedUrl, callback);
                }
            });
        } catch (Exception e) {
            Log.e("GETFILEqq", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPdfToCache$25(String str, pdfDownloadCallback pdfdownloadcallback) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                throw new IOException("Server returned HTTP" + httpURLConnection.getResponseCode());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            File fileCreateTempFile = File.createTempFile("temp_pdf", ".pdf", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    fileOutputStream.close();
                    inputStream.close();
                    pdfdownloadcallback.downloaded(fileCreateTempFile);
                    Log.e("GETFILEq", "FILE119::" + fileCreateTempFile);
                    return;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (Exception e) {
            Log.e("GETFILEq", e.toString());
        }
    }
}
