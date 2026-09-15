package in.gov.eci.bloapp.views.fragments.bla;

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
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.FileProvider;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MyCallback;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.ActivityBlaBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.BaseActivity;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class BlaActivity extends BaseActivity {
    private static final String SESSION = "Session Expired. Please Login again.";
    private String abbrev;
    AlertDialog alertDialog;
    private String asmblyNO;
    private String atkband;
    private ActivityBlaBinding binding;
    String email;
    private String epic;
    protected long filesize;
    String mobile;
    private ArrayList<String> partAbbrev;
    private int partId;
    private String partNo;
    private ArrayList<String> partyName;
    private String partyType;
    private byte[] pdfbyteArray;
    private String photoURL;
    private String referenceNo;
    private String refreshToken;
    private String rtkband;
    protected String saveImageFileName;
    private String state;
    private String statuscode;
    private String token;
    private String userFname;
    private String userLname;
    String applicationpdf = "application/pdf";
    String chooseFile = "Choose File";
    String takephoto = "Take Photo";
    String choosegallery = "Choose Image from Gallery";
    String cancel = "Cancel";
    String choosepdf = "Choose PDF from Gallery";
    String addphoto = "Add Photo!";
    String imgmsg = "Can't obtain file name, cursor is empty";
    String pdf3 = "PDF size exceeded 3MB limit.";
    String upload = "Please upload file again.";
    String greycolor = "#99000000";
    String functionNameForLogBaseActivity = "";
    private final String TAG = "BLA_2_Creation_TAG";
    private String firstName = "";
    public JsonArray bla1Details = null;
    String alertText = "Alert";
    String passref = StringUtils.SPACE;
    String imageTextBaseActivity = "image";
    String pdfTextBaseActivity = ".pdf";
    String jpgTextBaseActivity = ".jpg";
    private String photoref = "";
    String fileNameTextBaseActivity = "fileName";
    private String lastName = "";
    String garudaTextBaseActivity = "GARUDA";
    String filepathimg = "/storage/self/primary/Android/data/in.gov.eci.bloapp/filesGaruda/";
    String photostr = "Photo";
    private final Map<String, String> nameToAbbrevMap = new HashMap();
    CommomUtility commomUtility = new CommomUtility();
    ActivityResultLauncher<Intent> activityResultLauncher1 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new AnonymousClass1());

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$1, reason: invalid class name */
    class AnonymousClass1 implements ActivityResultCallback<ActivityResult> {
        AnonymousClass1() {
        }

        /* JADX WARN: Code duplicated, block: B:32:0x008a A[Catch: Exception -> 0x021b, TryCatch #2 {Exception -> 0x021b, blocks: (B:30:0x005f, B:32:0x008a, B:34:0x00a6, B:39:0x01c6, B:35:0x0116, B:37:0x012c, B:38:0x0159, B:40:0x020e, B:41:0x021a), top: B:49:0x005f }] */
        /* JADX WARN: Code duplicated, block: B:34:0x00a6 A[Catch: Exception -> 0x021b, TryCatch #2 {Exception -> 0x021b, blocks: (B:30:0x005f, B:32:0x008a, B:34:0x00a6, B:39:0x01c6, B:35:0x0116, B:37:0x012c, B:38:0x0159, B:40:0x020e, B:41:0x021a), top: B:49:0x005f }] */
        /* JADX WARN: Code duplicated, block: B:35:0x0116 A[Catch: Exception -> 0x021b, TryCatch #2 {Exception -> 0x021b, blocks: (B:30:0x005f, B:32:0x008a, B:34:0x00a6, B:39:0x01c6, B:35:0x0116, B:37:0x012c, B:38:0x0159, B:40:0x020e, B:41:0x021a), top: B:49:0x005f }] */
        /* JADX WARN: Code duplicated, block: B:37:0x012c A[Catch: Exception -> 0x021b, TryCatch #2 {Exception -> 0x021b, blocks: (B:30:0x005f, B:32:0x008a, B:34:0x00a6, B:39:0x01c6, B:35:0x0116, B:37:0x012c, B:38:0x0159, B:40:0x020e, B:41:0x021a), top: B:49:0x005f }] */
        /* JADX WARN: Code duplicated, block: B:38:0x0159 A[Catch: Exception -> 0x021b, TryCatch #2 {Exception -> 0x021b, blocks: (B:30:0x005f, B:32:0x008a, B:34:0x00a6, B:39:0x01c6, B:35:0x0116, B:37:0x012c, B:38:0x0159, B:40:0x020e, B:41:0x021a), top: B:49:0x005f }] */
        /* JADX WARN: Code duplicated, block: B:40:0x020e A[Catch: Exception -> 0x021b, TryCatch #2 {Exception -> 0x021b, blocks: (B:30:0x005f, B:32:0x008a, B:34:0x00a6, B:39:0x01c6, B:35:0x0116, B:37:0x012c, B:38:0x0159, B:40:0x020e, B:41:0x021a), top: B:49:0x005f }] */
        public void onActivityResult(ActivityResult result) throws Throwable {
            ByteArrayOutputStream byteArrayOutputStream;
            Uri saveImagePath;
            Cursor cursorQuery;
            String[] strArrSplit;
            double dRound;
            Throwable th;
            if (result.getResultCode() != -1) {
                return;
            }
            Uri data = result.getData().getData();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                InputStream inputStreamOpenInputStream = BlaActivity.this.getContentResolver().openInputStream(data);
                try {
                    try {
                        try {
                            byte[] bArr = new byte[1024];
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            while (true) {
                                try {
                                    int i = inputStreamOpenInputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    } else {
                                        byteArrayOutputStream.write(bArr, 0, i);
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (inputStreamOpenInputStream != null) {
                                        try {
                                            inputStreamOpenInputStream.close();
                                        } catch (Throwable th3) {
                                            th.addSuppressed(th3);
                                        }
                                    }
                                    throw th;
                                }
                            }
                            if (inputStreamOpenInputStream != null) {
                                inputStreamOpenInputStream.close();
                            }
                        } catch (Exception e) {
                            e = e;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            Logger.d("", e.getMessage());
                            byteArrayOutputStream = byteArrayOutputStream2;
                            BlaActivity.this.pdfbyteArray = byteArrayOutputStream.toByteArray();
                            saveImagePath = BlaActivity.this.getSaveImagePath(Base64.encodeToString(BlaActivity.this.pdfbyteArray, 0), ".pdf");
                            cursorQuery = BlaActivity.this.getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
                            if (cursorQuery.getCount() > 0) {
                                cursorQuery.close();
                                throw new IllegalArgumentException(BlaActivity.this.imgmsg);
                            }
                            cursorQuery.moveToFirst();
                            strArrSplit = saveImagePath.getPath().split("/");
                            if (BlaActivity.this.filesize < 1024) {
                                double dRound2 = Math.round(BlaActivity.this.filesize * 100.0d) / 100.0d;
                                BlaActivity.this.binding.deathCerti.setVisibility(0);
                                BlaActivity.this.binding.size.setVisibility(0);
                                BlaActivity.this.binding.photo.setImageResource(R.drawable.blo_pfd_thumbnail);
                                BlaActivity.this.binding.chooseFile.setTextColor(Color.parseColor(BlaActivity.this.greycolor));
                                BlaActivity.this.binding.photoname.setText(strArrSplit[strArrSplit.length - 1]);
                                BlaActivity.this.binding.size.setText(dRound2 + "KB");
                            } else {
                                dRound = Math.round(((double) (BlaActivity.this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                                if (dRound > 3.0d) {
                                    BlaActivity.this.binding.deathCerti.setVisibility(8);
                                    BlaActivity.this.binding.delete.setVisibility(8);
                                    BlaActivity.this.binding.photo.setVisibility(8);
                                    BlaActivity blaActivity = BlaActivity.this;
                                    blaActivity.showDialog1(blaActivity.alertText, "PDF size exceeded 3MB limit.");
                                } else {
                                    BlaActivity.this.binding.delete.setVisibility(0);
                                    BlaActivity.this.binding.deathCerti.setVisibility(0);
                                    BlaActivity.this.binding.size.setVisibility(0);
                                    BlaActivity.this.binding.photo.setImageResource(R.drawable.blo_pfd_thumbnail);
                                    BlaActivity.this.binding.chooseFile.setTextColor(Color.parseColor(BlaActivity.this.greycolor));
                                    BlaActivity.this.binding.photoname.setText(strArrSplit[strArrSplit.length - 1]);
                                    BlaActivity.this.binding.size.setText(dRound + "MB");
                                }
                            }
                            BlaActivity.this.commomUtility.uploadToServer2(BlaActivity.this.getApplicationContext(), BlaActivity.this.state, BlaActivity.this.asmblyNO, BlaActivity.this.partNo, BlaActivity.this.filepathimg, BlaActivity.this.saveImageFileName, BlaActivity.this.token, BlaActivity.this.referenceNo, BlaActivity.this.atkband, BlaActivity.this.rtkband, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$1$$ExternalSyntheticLambda3
                                @Override // in.gov.eci.bloapp.MyCallback
                                public final void onCallback(int i2, String str) {
                                    this.f$0.lambda$onActivityResult$5(i2, str);
                                }
                            });
                            cursorQuery.close();
                            return;
                        }
                        saveImagePath = BlaActivity.this.getSaveImagePath(Base64.encodeToString(BlaActivity.this.pdfbyteArray, 0), ".pdf");
                        cursorQuery = BlaActivity.this.getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.close();
                            throw new IllegalArgumentException(BlaActivity.this.imgmsg);
                        }
                        cursorQuery.moveToFirst();
                        strArrSplit = saveImagePath.getPath().split("/");
                        if (BlaActivity.this.filesize < 1024) {
                            double dRound3 = Math.round(BlaActivity.this.filesize * 100.0d) / 100.0d;
                            BlaActivity.this.binding.deathCerti.setVisibility(0);
                            BlaActivity.this.binding.size.setVisibility(0);
                            BlaActivity.this.binding.photo.setImageResource(R.drawable.blo_pfd_thumbnail);
                            BlaActivity.this.binding.chooseFile.setTextColor(Color.parseColor(BlaActivity.this.greycolor));
                            BlaActivity.this.binding.photoname.setText(strArrSplit[strArrSplit.length - 1]);
                            BlaActivity.this.binding.size.setText(dRound3 + "KB");
                        } else {
                            dRound = Math.round(((double) (BlaActivity.this.filesize / 1024.0f)) * 100.0d) / 100.0d;
                            if (dRound > 3.0d) {
                                BlaActivity.this.binding.deathCerti.setVisibility(8);
                                BlaActivity.this.binding.delete.setVisibility(8);
                                BlaActivity.this.binding.photo.setVisibility(8);
                                BlaActivity blaActivity2 = BlaActivity.this;
                                blaActivity2.showDialog1(blaActivity2.alertText, "PDF size exceeded 3MB limit.");
                            } else {
                                BlaActivity.this.binding.delete.setVisibility(0);
                                BlaActivity.this.binding.deathCerti.setVisibility(0);
                                BlaActivity.this.binding.size.setVisibility(0);
                                BlaActivity.this.binding.photo.setImageResource(R.drawable.blo_pfd_thumbnail);
                                BlaActivity.this.binding.chooseFile.setTextColor(Color.parseColor(BlaActivity.this.greycolor));
                                BlaActivity.this.binding.photoname.setText(strArrSplit[strArrSplit.length - 1]);
                                BlaActivity.this.binding.size.setText(dRound + "MB");
                            }
                        }
                        BlaActivity.this.commomUtility.uploadToServer2(BlaActivity.this.getApplicationContext(), BlaActivity.this.state, BlaActivity.this.asmblyNO, BlaActivity.this.partNo, BlaActivity.this.filepathimg, BlaActivity.this.saveImageFileName, BlaActivity.this.token, BlaActivity.this.referenceNo, BlaActivity.this.atkband, BlaActivity.this.rtkband, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$1$$ExternalSyntheticLambda3
                            @Override // in.gov.eci.bloapp.MyCallback
                            public final void onCallback(int i2, String str) {
                                this.f$0.lambda$onActivityResult$5(i2, str);
                            }
                        });
                        cursorQuery.close();
                        return;
                    } catch (Exception e2) {
                        Logger.d("", e2.getMessage());
                        return;
                    }
                    BlaActivity.this.pdfbyteArray = byteArrayOutputStream.toByteArray();
                } catch (Throwable th4) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    th = th4;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$5(int i, String str) {
            if (i == 401) {
                BlaActivity.this.commomUtility.getRefreshToken(BlaActivity.this.getApplicationContext(), BlaActivity.this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$1$$ExternalSyntheticLambda4
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str2, String str3) {
                        this.f$0.lambda$onActivityResult$3(i2, str2, str3);
                    }
                });
            } else {
                BlaActivity.this.photoref = str;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$1$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onActivityResult$4();
                    }
                }, 1000L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
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
        public /* synthetic */ void lambda$onActivityResult$3(int i, String str, String str2) {
            BlaActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb in relation draft" + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
            if (i == 401 || i == 400) {
                BlaActivity.this.commomUtility.showMessageOK(BlaActivity.this, BlaActivity.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onActivityResult$0(dialogInterface, i2);
                    }
                });
                return;
            }
            BlaActivity.this.token = "Bearer " + str;
            BlaActivity.this.refreshToken = str2;
            SharedPref.getInstance(BlaActivity.this.getApplicationContext()).setRefreshToken(str2);
            SharedPref.getInstance(BlaActivity.this.getApplicationContext()).setToken("Bearer " + str);
            BlaActivity.this.commomUtility.uploadToServer2(BlaActivity.this.getApplicationContext(), BlaActivity.this.state, BlaActivity.this.asmblyNO, BlaActivity.this.partNo, BlaActivity.this.filepathimg, BlaActivity.this.saveImageFileName, BlaActivity.this.token, BlaActivity.this.referenceNo, BlaActivity.this.atkband, BlaActivity.this.rtkband, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$1$$ExternalSyntheticLambda1
                @Override // in.gov.eci.bloapp.MyCallback
                public final void onCallback(int i2, String str3) {
                    this.f$0.lambda$onActivityResult$2(i2, str3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(BlaActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(BlaActivity.this.getApplicationContext()).setLocaleBool(false);
            BlaActivity.this.startActivity(new Intent(BlaActivity.this.getApplication(), (Class<?>) LoginActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$2(int i, String str) {
            BlaActivity.this.photoref = str;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onActivityResult$1();
                }
            }, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$1() {
            BlaActivity.this.alertDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onActivityResult$4() {
            BlaActivity.this.alertDialog.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // in.gov.eci.bloapp.views.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPref.getInstance(getApplicationContext()).getToken();
        SharedPref.getInstance(getApplicationContext()).getStateCode();
        ActivityBlaBinding activityBlaBindingInflate = ActivityBlaBinding.inflate(getLayoutInflater());
        this.binding = activityBlaBindingInflate;
        setContentView(activityBlaBindingInflate.getRoot());
        this.atkband = SharedPref.getInstance(getApplicationContext()).getAtknBnd();
        this.rtkband = SharedPref.getInstance(getApplicationContext()).getRtknBnd();
        this.token = SharedPref.getInstance(getApplicationContext()).getToken();
        this.state = SharedPref.getInstance(getApplicationContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(getApplicationContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(getApplicationContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(getApplicationContext()).getRefreshToken();
        this.binding.bla2part.setText(this.partNo);
        ArrayList arrayList = new ArrayList();
        arrayList.add("Select Party Type");
        arrayList.add("National");
        arrayList.add("State");
        arrayList.add("Registered unrecognized Political Party (RUPP)");
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) this, android.R.layout.simple_spinner_item, (List) arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.partyTypeSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
        this.binding.partyTypeSpinner.setSelection(0);
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.partyName = arrayList2;
        arrayList2.add(0, "Select Party Name");
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, this.partyName);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.partyNameSpinner.setAdapter((SpinnerAdapter) arrayAdapter2);
        this.binding.partyNameSpinner.setSelection(0);
        initClickListener();
        loadData();
        this.binding.validate.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.chooseFile.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.delete.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.binding.blaSubmit.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$3(view);
            }
        });
        this.binding.mobile.addTextChangedListener(new TextWatcher() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity.2
            boolean hasShowMessage = false;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (s.length() == 10 && s.toString().matches("\\d{10}") && !this.hasShowMessage) {
                    Logger.d("BLA_2_Creation_TAG", s.toString());
                    this.hasShowMessage = true;
                } else if (s.length() > 10) {
                    this.hasShowMessage = false;
                    BlaActivity blaActivity = BlaActivity.this;
                    blaActivity.showDialog1(blaActivity.alertText, "Please enter valid mobile number");
                }
            }
        });
        View viewInflate = getLayoutInflater().inflate(R.layout.blo_day_begin_progressbar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        validate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        selectImage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        deleteImage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        submit();
    }

    private void deleteImage() {
        this.binding.size.setText("");
        this.binding.photoname.setText("");
        this.binding.delete.setVisibility(8);
        this.binding.chooseFile.setEnabled(true);
        this.binding.photo.setVisibility(8);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == -1) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                this.pdfbyteArray = byteArrayOutputStream.toByteArray();
            } catch (Exception e) {
                Logger.d("", e.getMessage());
            }
            try {
                Uri saveImagePath = getSaveImagePath(Base64.encodeToString(this.pdfbyteArray, 0), "image");
                Cursor cursorQuery = getApplicationContext().getContentResolver().query(saveImagePath, null, null, null, null);
                if (cursorQuery.getCount() <= 0) {
                    cursorQuery.close();
                    throw new IllegalArgumentException(this.imgmsg);
                }
                cursorQuery.moveToFirst();
                String[] strArrSplit = saveImagePath.getPath().split("/");
                long j = this.filesize;
                if (j < 1024) {
                    this.binding.deathCerti.setVisibility(0);
                    this.binding.delete.setVisibility(0);
                    this.binding.photoname.setVisibility(0);
                    this.binding.size.setVisibility(0);
                    this.binding.photo.setVisibility(0);
                    ImageView imageView = this.binding.photo;
                    byte[] bArr = this.pdfbyteArray;
                    imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    this.binding.chooseFile.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.photoname.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.size.setText(this.filesize + "KB");
                } else if (j > 2048) {
                    this.binding.deathCerti.setVisibility(8);
                    this.binding.delete.setVisibility(8);
                    this.binding.photoname.setVisibility(8);
                    this.binding.size.setVisibility(8);
                    this.binding.photo.setVisibility(8);
                    showDialog1(this.alertText, "Image size exceeded 2MB limit.");
                } else {
                    long j2 = j / 1024;
                    this.filesize = j2;
                    double dRound = Math.round(j2 * 100.0d) / 100.0d;
                    this.binding.deathCerti.setVisibility(0);
                    this.binding.delete.setVisibility(0);
                    this.binding.photoname.setVisibility(0);
                    this.binding.size.setVisibility(0);
                    this.binding.photo.setVisibility(0);
                    ImageView imageView2 = this.binding.photo;
                    byte[] bArr2 = this.pdfbyteArray;
                    imageView2.setImageBitmap(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length));
                    this.binding.chooseFile.setTextColor(Color.parseColor(this.greycolor));
                    this.binding.photoname.setText(strArrSplit[strArrSplit.length - 1]);
                    this.binding.size.setText(dRound + "MB");
                }
                this.commomUtility.uploadToServer2(getApplicationContext(), this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.atkband, this.rtkband, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$$ExternalSyntheticLambda9
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i, String str) {
                        this.f$0.lambda$onActivityResult$9(i, str);
                    }
                });
            } catch (Exception e2) {
                Logger.d("", e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$9(int i, final String str) {
        if (i == 401) {
            this.commomUtility.getRefreshToken(getApplicationContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$$ExternalSyntheticLambda5
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$onActivityResult$7(str, i2, str2, str3);
                }
            });
        } else {
            this.photoref = str;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onActivityResult$8();
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onActivityResult$7(final String str, int i, String str2, String str3) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb in relation draft" + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
        if (i == 401 || i == 400) {
            this.commomUtility.showMessageOK(this, SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$$ExternalSyntheticLambda10
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onActivityResult$4(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str2;
        this.refreshToken = str3;
        SharedPref.getInstance(getApplicationContext()).setRefreshToken(str3);
        SharedPref.getInstance(getApplicationContext()).setToken("Bearer " + str2);
        this.commomUtility.uploadToServer2(getApplicationContext(), this.state, this.asmblyNO, this.partNo, this.filepathimg, this.saveImageFileName, this.token, this.referenceNo, this.atkband, this.rtkband, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$$ExternalSyntheticLambda11
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str4) {
                this.f$0.lambda$onActivityResult$6(str, i2, str4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$4(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(getApplicationContext()).setIsLoggedIn(false);
        SharedPref.getInstance(getApplicationContext()).setLocaleBool(false);
        startActivity(new Intent(getApplicationContext(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$6(String str, int i, String str2) {
        this.photoref = str;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onActivityResult$5();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$5() {
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$8() {
        this.alertDialog.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void selectImage() {
        final CharSequence[] charSequenceArr = {this.takephoto, this.choosegallery, this.choosepdf, this.cancel};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Photo!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$selectImage$10(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$selectImage$10(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(this.takephoto)) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).cameraOnly().start(101);
            return;
        }
        if (charSequenceArr[i].equals(this.choosegallery)) {
            this.alertDialog.show();
            ImagePicker.with(this).crop().compress(512).galleryOnly().start(101);
        } else if (charSequenceArr[i].equals(this.choosepdf)) {
            this.alertDialog.show();
            openfile1();
        } else if (charSequenceArr[i].equals(this.cancel)) {
            dialogInterface.dismiss();
        }
    }

    private void openfile1() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/pdf"});
        this.activityResultLauncher1.launch(Intent.createChooser(intent, "Choose File"));
    }

    private void submit() {
        if (!this.binding.mobile.getText().toString().isEmpty() && !this.binding.mobile.getText().toString().matches(RegexMatcher.MOBILE_REGEX) && this.binding.mobile.getText().toString().length() != 10) {
            showDialog1(this.alertText, "Please enter correct Mobile no");
        }
        if (!this.binding.blaEmail.getText().toString().isEmpty() && !this.binding.blaEmail.getText().toString().matches(RegexMatcher.EMAIL_REGEX)) {
            showDialog1(this.alertText, "Please enter correct Email");
        }
        if (this.photoref.isEmpty() || this.photoref == null) {
            showDialog1(this.alertText, "Please upload appointment letter");
            this.binding.blaSubmit.setClickable(false);
            return;
        }
        HashMap map = new HashMap();
        map.put("partyId", Integer.valueOf(this.partId));
        map.put("userFname", this.userFname);
        map.put("userLname", this.userLname);
        map.put("mobileNumber", this.binding.mobile.getText().toString());
        map.put("designation", "BLA2");
        map.put("stateCd", this.state);
        map.put("districtCd", SharedPref.getInstance(getApplicationContext()).getDistrictCode());
        map.put("acNo", Integer.valueOf(Integer.parseInt(this.asmblyNO)));
        map.put("partNo", Integer.valueOf(Integer.parseInt(this.partNo)));
        map.put("roleId", 167);
        map.put("partyAbbre", this.abbrev);
        map.put("firstLogin", "Y");
        map.put("blaOfficeName", "");
        map.put("blaAppointmentLetter", this.photoref);
        map.put("authorizedStates", this.state);
        map.put("authorizedDistricts", SharedPref.getInstance(getApplicationContext()).getDistrictCode());
        map.put("authorizedAcs", this.asmblyNO);
        map.put("authorizedParts", this.partNo);
        map.put("photoUrl", this.photoURL);
        map.put("email", this.binding.blaEmail.getText().toString());
        map.put("epicNumber", this.epic);
        this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).createBla2(this.state, "blo", map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity.3
            public void onFailure(Call<JsonObject> call, Throwable throwable) {
            }

            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (!response.isSuccessful()) {
                        String string = new JSONObject(response.errorBody().string()).getString("payload");
                        BlaActivity blaActivity = BlaActivity.this;
                        blaActivity.showDialog(blaActivity.alertText, string);
                    } else {
                        String string2 = new JSONObject(((JsonObject) response.body()).toString()).getString("payload");
                        BlaActivity blaActivity2 = BlaActivity.this;
                        blaActivity2.showDialog(blaActivity2.alertText, string2);
                    }
                } catch (Exception e) {
                    Logger.d("ApplicationDetsailsFragment", e.toString());
                }
            }
        });
    }

    private void initClickListener() {
        this.binding.backBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initClickListener$11(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickListener$11(View view) {
        finish();
    }

    public void loadData() {
        this.binding.partyTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity.4
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                if (position != 0) {
                    String string = parent.getItemAtPosition(position).toString();
                    if (string.equalsIgnoreCase("National")) {
                        BlaActivity.this.partyType = "national";
                        BlaActivity.this.binding.partyNameSpinner.setSelection(0);
                        BlaActivity.this.abbrev = "";
                    } else if (string.equalsIgnoreCase("State")) {
                        BlaActivity.this.partyType = "state";
                        BlaActivity.this.binding.partyNameSpinner.setSelection(0);
                        BlaActivity.this.abbrev = "";
                    } else if (string.equalsIgnoreCase("Registered unrecognized Political Party (RUPP)")) {
                        BlaActivity.this.partyType = "Registered Unrecognised";
                        BlaActivity.this.binding.partyNameSpinner.setSelection(0);
                        BlaActivity.this.abbrev = "";
                    }
                    BlaActivity blaActivity = BlaActivity.this;
                    blaActivity.getPoliticalParty(blaActivity.partyType);
                }
            }
        });
    }

    public void getPoliticalParty(String partyType) {
        this.partAbbrev = new ArrayList<>();
        try {
            this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getAllPoliticalPartyDetail(partyType, this.token, "BLOAPP", "BLOAPP", "blo", this.state).enqueue(new AnonymousClass5(partyType));
        } catch (Exception e) {
            Logger.d("BLA_2_Creation_TAG", e.toString());
        }
        this.binding.partyNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity.6
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                BlaActivity.this.binding.shortAbbrev.setText("");
                BlaActivity.this.binding.bla1name.setText("");
                String str = (String) BlaActivity.this.partyName.get(position);
                BlaActivity blaActivity = BlaActivity.this;
                blaActivity.abbrev = (String) blaActivity.nameToAbbrevMap.get(str);
                BlaActivity.this.binding.shortAbbrev.setText(BlaActivity.this.abbrev != null ? BlaActivity.this.abbrev : "");
                BlaActivity.this.getBla1Name();
            }
        });
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$5, reason: invalid class name */
    class AnonymousClass5 implements Callback<JsonObject> {
        final /* synthetic */ String val$partyType;

        AnonymousClass5(final String val$partyType) {
            this.val$partyType = val$partyType;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [android.content.Context, in.gov.eci.bloapp.views.fragments.bla.BlaActivity] */
        /* JADX WARN: Type inference failed for: r9v2, types: [android.content.Context, in.gov.eci.bloapp.views.fragments.bla.BlaActivity] */
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
                JsonObject jsonObject = (JsonObject) response.body();
                if (jsonObject != null) {
                    BlaActivity.this.partyName.clear();
                    BlaActivity.this.partAbbrev.clear();
                    BlaActivity.this.nameToAbbrevMap.clear();
                    JsonArray asJsonArray = jsonObject.getAsJsonArray("payload");
                    BlaActivity.this.partyName.add(0, "Select Party Name");
                    BlaActivity.this.binding.partyNameSpinner.setSelection(0);
                    for (int i = 0; i < asJsonArray.size(); i++) {
                        JsonObject asJsonObject = asJsonArray.get(i).getAsJsonObject();
                        String strReplaceAll = String.valueOf(asJsonObject.get("partyName")).replaceAll("^\"|\"$", "").replaceAll(" null | null", StringUtils.SPACE);
                        String strReplaceAll2 = String.valueOf(asJsonObject.get("partyAbbre")).replaceAll("^\"|\"$", "").replaceAll(" null | null", StringUtils.SPACE);
                        BlaActivity.this.partyName.add(strReplaceAll);
                        BlaActivity.this.partAbbrev.add(strReplaceAll2);
                        BlaActivity.this.nameToAbbrevMap.put(strReplaceAll, strReplaceAll2);
                        ?? r0 = BlaActivity.this;
                        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) r0, android.R.layout.simple_spinner_item, ((BlaActivity) r0).partyName);
                        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        BlaActivity.this.binding.partyNameSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
                    }
                    return;
                }
                return;
            }
            if (response.code() == 401) {
                CommomUtility commomUtility = BlaActivity.this.commomUtility;
                ?? r9 = BlaActivity.this;
                String str = ((BlaActivity) r9).refreshToken;
                final String str2 = this.val$partyType;
                commomUtility.getRefreshToken(r9, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$5$$ExternalSyntheticLambda1
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i2, String str3, String str4) {
                        this.f$0.lambda$onResponse$1(str2, i2, str3, str4);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
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
            BlaActivity.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                BlaActivity.this.commomUtility.showMessageOK(BlaActivity.this, BlaActivity.SESSION, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$5$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            BlaActivity.this.token = "Bearer " + str2;
            SharedPref.getInstance(BlaActivity.this.getApplicationContext()).setRefreshToken(str3);
            SharedPref.getInstance(BlaActivity.this.getApplicationContext()).setToken("Bearer " + str2);
            BlaActivity.this.getPoliticalParty(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(BlaActivity.this.getApplicationContext()).setIsLoggedIn(false);
            SharedPref.getInstance(BlaActivity.this.getApplicationContext()).setLocaleBool(false);
            BlaActivity.this.startActivity(new Intent(BlaActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d(StringUtils.SPACE, t.getMessage());
            BlaActivity blaActivity = BlaActivity.this;
            blaActivity.showDialog1(blaActivity.alertText, t.getMessage());
            BlaActivity.this.alertDialog.dismiss();
        }
    }

    public void getBla1Name() {
        try {
            HashMap map = new HashMap();
            map.put("stateCd", this.state);
            map.put("districtCd", SharedPref.getInstance(getApplicationContext()).getDistrictCode());
            map.put("acNo", SharedPref.getInstance(getApplicationContext()).getAssemblyNumber());
            map.put("partyAbbre", this.abbrev);
            this.commomUtility.getRetrofitClient(getApplicationContext(), this.token, this.atkband, this.rtkband).getBLA1Details(this.state, "blo", this.token, map).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity.7
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    JsonObject jsonObject;
                    Logger.d("BLA_2_Creation_TAG", String.valueOf(response.code()));
                    if (response.code() != 200 || (jsonObject = (JsonObject) response.body()) == null) {
                        return;
                    }
                    String strValueOf = String.valueOf(jsonObject.get("statusCode"));
                    if (strValueOf.equals("200")) {
                        JsonObject jsonObject2 = jsonObject.get("payload");
                        BlaActivity.this.firstName = String.valueOf(jsonObject2.get("userFname")).replaceAll("^\"|\"$", "").replaceAll(" null | null", StringUtils.SPACE);
                        BlaActivity.this.lastName = String.valueOf(jsonObject2.get("userLname")).replaceAll("^\"|\"$", "").replaceAll(" null | null", StringUtils.SPACE);
                        if (!BlaActivity.this.firstName.isEmpty()) {
                            BlaActivity.this.binding.bla1name.setText(BlaActivity.this.firstName + StringUtils.SPACE + BlaActivity.this.lastName);
                            return;
                        }
                        BlaActivity.this.binding.partyTypeSpinner.setSelection(0);
                        BlaActivity.this.binding.partyNameSpinner.setSelection(0);
                        BlaActivity.this.abbrev = "";
                        return;
                    }
                    if (strValueOf.equals("404")) {
                        BlaActivity.this.alertDialog.dismiss();
                        BlaActivity blaActivity = BlaActivity.this;
                        blaActivity.showDialog1(blaActivity.alertText, "Please create BLA1");
                        BlaActivity.this.binding.partyTypeSpinner.setSelection(0);
                        BlaActivity.this.partyName.clear();
                        BlaActivity.this.partyName.add(0, "Select Party Name");
                        BlaActivity.this.binding.partyNameSpinner.setSelection(0);
                        BlaActivity.this.binding.bla1name.setText("");
                        BlaActivity.this.binding.bla2epic.setText("");
                        BlaActivity.this.binding.shortAbbrev.setText("");
                        BlaActivity.this.abbrev = "";
                        return;
                    }
                    BlaActivity blaActivity2 = BlaActivity.this;
                    blaActivity2.showDialog1(blaActivity2.alertText, response.message());
                    BlaActivity.this.binding.partyTypeSpinner.setSelection(0);
                    BlaActivity.this.binding.partyNameSpinner.setSelection(0);
                    BlaActivity.this.abbrev = "";
                }

                public void onFailure(Call<JsonObject> call, Throwable throwable) {
                    BlaActivity blaActivity = BlaActivity.this;
                    blaActivity.showDialog1(blaActivity.alertText, throwable.getMessage());
                    BlaActivity.this.binding.partyTypeSpinner.setSelection(0);
                    BlaActivity.this.binding.partyNameSpinner.setSelection(0);
                    BlaActivity.this.abbrev = "";
                }
            });
        } catch (Exception e) {
            Logger.d("BLA_2_Creation_TAG", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog1(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog1$12(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog1$12(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showDialog(String alertText, String message) {
        new android.app.AlertDialog.Builder(this).setTitle(alertText).setMessage(message).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$$ExternalSyntheticLambda12
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog$13(dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog$13(DialogInterface dialogInterface, int i) {
        this.alertDialog.dismiss();
        dialogInterface.dismiss();
        startActivity(new Intent(getApplicationContext(), (Class<?>) BlaActivity.class));
    }

    private void validate() {
        String string = this.binding.bla2epic.getText().toString();
        this.epic = string;
        if (string.isEmpty() && this.firstName.isEmpty()) {
            this.binding.validate.setClickable(false);
            showDialog1(this.alertText, "Please fill all the details");
        } else {
            HashMap map = new HashMap();
            map.put("epicNumber", this.epic);
            map.put("isActive", "Y");
            ((UserClient) ApiClient.getClient(getApplicationContext()).create(UserClient.class)).getEpicForForm8(this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "ANDROIDMOB", map).enqueue(new AnonymousClass8());
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$8, reason: invalid class name */
    class AnonymousClass8 implements Callback<JsonArray> {
        static /* synthetic */ void lambda$onResponse$0() {
        }

        AnonymousClass8() {
        }

        public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
            if (response.code() == 200) {
                if (!((JsonArray) response.body()).isEmpty()) {
                    JsonObject jsonObject = ((JsonArray) response.body()).get(0).get("content");
                    BlaActivity.this.partId = Integer.parseInt(String.valueOf(jsonObject.get("partId")).replaceAll("^\"|\"$", "").replaceAll(" null | null", StringUtils.SPACE));
                    BlaActivity.this.userFname = String.valueOf(jsonObject.get("applicantFirstName")).replaceAll("^\"|\"$", "").replaceAll(" null | null", StringUtils.SPACE);
                    BlaActivity.this.userLname = String.valueOf(jsonObject.get("applicantLastName")).replaceAll("^\"|\"$", "").replaceAll(" null | null", StringUtils.SPACE);
                    BlaActivity.this.referenceNo = String.valueOf(jsonObject.get("formReferenceNo")).replaceAll("^\"|\"$", "").replaceAll(" null | null", StringUtils.SPACE);
                    BlaActivity.this.photoURL = String.valueOf(jsonObject.get("photo")).replaceAll("^\"|\"$", "").replaceAll(" null | null", StringUtils.SPACE);
                    new Handler().postDelayed(new Runnable() { // from class: in.gov.eci.bloapp.views.fragments.bla.BlaActivity$8$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            BlaActivity.AnonymousClass8.lambda$onResponse$0();
                        }
                    }, 2000L);
                } else {
                    new JsonObject();
                    Logger.d("BLA_2_Creation_TAG", "In fetchEPICData() -> else part ----> Response Body is null .............................");
                }
            }
            if (BlaActivity.this.userFname != null) {
                BlaActivity.this.binding.bla2name.setText(BlaActivity.this.userFname + StringUtils.SPACE + BlaActivity.this.userLname);
                BlaActivity.this.binding.layoutBla2.setVisibility(0);
            } else {
                BlaActivity blaActivity = BlaActivity.this;
                blaActivity.showDialog1(blaActivity.alertText, "Epic number is not valid");
            }
        }

        public void onFailure(Call<JsonArray> call, Throwable t) {
            Logger.d(StringUtils.SPACE, t.getMessage());
            BlaActivity blaActivity = BlaActivity.this;
            blaActivity.showDialog1(blaActivity.alertText, t.getMessage());
            BlaActivity.this.alertDialog.dismiss();
        }
    }

    public Uri getSaveImagePath(String fileNameBase64, String documentTypeSelected) throws IOException {
        this.functionNameForLogBaseActivity = "getSaveImagePath ";
        Logger.d("BLA_2_Creation_TAG", "getSaveImagePath ");
        String str = new SimpleDateFormat("ddMMyyyyHHMMSS").format(new Date());
        File file = new File(getApplicationContext().getExternalFilesDir(null) + this.garudaTextBaseActivity);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (documentTypeSelected.equals(this.imageTextBaseActivity)) {
            this.saveImageFileName = "img_" + str + this.jpgTextBaseActivity;
            Logger.d("BLA_2_Creation_TAG", this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
        } else if (documentTypeSelected.equals(this.pdfTextBaseActivity)) {
            this.saveImageFileName = "pdf_document" + str + this.pdfTextBaseActivity;
            Logger.d("BLA_2_Creation_TAG", this.functionNameForLogBaseActivity + this.fileNameTextBaseActivity + this.saveImageFileName);
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
            Logger.d("BLA_2_Creation_TAG", this.functionNameForLogBaseActivity + e.getMessage());
        }
        this.filesize = file2.length() / 1024;
        Logger.d("BLA_2_Creation_TAG", "filesize " + this.filesize);
        Logger.d("BLA_2_Creation_TAG", this.functionNameForLogBaseActivity + "imageUri : " + FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2));
        return FileProvider.getUriForFile(getApplicationContext(), "in.gov.eci.bloapp.provider", file2);
    }
}
