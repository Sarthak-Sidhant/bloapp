package in.gov.eci.bloapp.views.fragments.voterforms.migration;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MyCallbackjsonTest;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentMigrationPreviewEpicBinding;
import in.gov.eci.bloapp.model.app_model.FormsinDraftMigrationModel;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.viewmodel.PreviewViewModel;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.XmlErrorCodes;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class Migration_preview_Epic extends Hilt_Migration_preview_Epic {
    private static final String ALERT = "Alert";
    private static final String DDMMHHSS = "yyyy-MM-dd";
    private static final String EXCEPTION = "Exception";
    private static final String MIGRATION_CATCH_MSG = "migration preview form";
    private static final String SESSION_TOKEN = "Session token expired please Login";
    private String addresscor;
    private String addresscorreg;
    private String addresssor;
    private String addresssorreg;
    AlertDialog alertDialog;
    private String appdate;
    private String base64element;
    BloFragmentMigrationPreviewEpicBinding binding;
    private String bloasmblyname;
    private String blodistrictname;
    Retrofit.Builder builder;
    private String coedistrict;
    private String cordob;
    private String corgender;
    private String corname;
    private String cornamereg;
    private String correlname;
    private String correlnamereg;
    private String epicNumber;
    private String orgaddress;
    private String orgaddressreg;
    private String orgdob;
    private String orggender;
    private String orghouseno;
    private String orghousenoreg;
    private String orgrelatname;
    private String orgrelatnamereg;
    private String orgstreet;
    private String ornamereg;
    private int position;
    String referencerlinkcoe8;
    private String refreshToken;
    private String regionalAssemblyName;
    private String regionalDistrictName;
    private String regionalStateName;
    private String relationType;
    Retrofit retrofit;
    private String sectionNO;
    private String sectionName;
    private String sectionNamereg;
    private String shiftingImage;
    private String sordistrict;
    private String stateName;
    private final ArrayList<String> teluguLang;
    PreviewViewModel viewModel;
    JsonArray epicDetailsArray = null;

    /* JADX INFO: renamed from: in, reason: collision with root package name */
    private final String[] f6in = new String[50];
    CommomUtility commonUtilClass = new CommomUtility();
    String delimeter = "‡";
    private String token = "";
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
    Gson gson = new GsonBuilder().setLenient().create();

    public Migration_preview_Epic() {
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(this.commonUtilClass.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(this.okHttpClient);
        this.builder = builderClient;
        this.retrofit = builderClient.build();
        this.shiftingImage = "";
        this.teluguLang = new ArrayList<>();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String str;
        String str2;
        String str3;
        Bundle bundle;
        String str4;
        String str5;
        Exception exc;
        String str6;
        this.binding = BloFragmentMigrationPreviewEpicBinding.inflate(getLayoutInflater());
        this.viewModel = (PreviewViewModel) new ViewModelProvider(this).get(PreviewViewModel.class);
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.regionalAssemblyName = SharedPref.getInstance(requireContext()).getAssemblyNameL1();
        this.regionalStateName = SharedPref.getInstance(requireContext()).getRegionalStateName();
        this.regionalDistrictName = SharedPref.getInstance(requireContext()).getDistrictNameL1();
        this.stateName = SharedPref.getInstance(requireContext()).getStateName();
        this.blodistrictname = SharedPref.getInstance(requireContext()).getDistrictName();
        this.bloasmblyname = SharedPref.getInstance(requireContext()).getAssemblyName();
        String assemblyNumber = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        String stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        String partNumber = SharedPref.getInstance(requireContext()).getPartNumber();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.blo_api_progress_bar, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireActivity()).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.alertDialog.setCancelable(false);
        this.alertDialog.setView(viewInflate);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.epicNumber = arguments.getString("Epicnumber").trim();
            this.ornamereg = arguments.getString("originalnameregional");
            this.corname = arguments.getString("CorrectName");
            this.cornamereg = arguments.getString("CorrectNameRegional");
            this.correlname = arguments.getString("CorrectRelativeName");
            System.out.println("kdbsi" + this.correlname);
            this.correlnamereg = arguments.getString("CorrectRelativeNameRegional");
            this.orgrelatname = arguments.getString("Originalrelativename");
            this.orgrelatnamereg = arguments.getString("Originalrelativenameregional");
            this.orggender = arguments.getString("Originalgender");
            String string = arguments.getString("Originalgenderregional");
            this.corgender = arguments.getString("Correctgender");
            this.orgdob = arguments.getString("Originaldob");
            this.cordob = arguments.getString("CorrectDOB");
            this.orgaddress = arguments.getString("Originaladdress");
            this.orgstreet = arguments.getString("orgstreet");
            String string2 = arguments.getString("orghouseno");
            this.orghouseno = string2;
            if (string2 == null || string2.equals("null")) {
                this.orghouseno = "";
            }
            String string3 = arguments.getString("orghousenoreg");
            this.orghousenoreg = string3;
            if (string3 == null || string3.equals("null")) {
                this.orghousenoreg = "";
            }
            String string4 = arguments.getString("SectionNumber");
            this.orgaddressreg = arguments.getString("Originaladdressregional");
            this.addresssor = arguments.getString("CorrectedaddressSOR");
            this.addresssorreg = arguments.getString("CorrectedaddressregionalSOR");
            this.addresscor = arguments.getString("CorrectedaddressCOR");
            this.addresscorreg = arguments.getString("CorrectedaddressregionalCOR");
            this.appdate = arguments.getString("Applicationdate");
            this.relationType = arguments.getString("RelationType");
            this.sordistrict = arguments.getString("SORDistrict");
            this.coedistrict = arguments.getString("COEDistrict");
            this.position = arguments.getInt("position");
            this.shiftingImage = arguments.getString("shiftingImage");
            String str7 = this.token;
            str2 = EXCEPTION;
            str = "";
            str3 = "draftname";
            bundle = arguments;
            getSection(stateCode, str7, assemblyNumber, partNumber, string4);
            try {
                if (this.ornamereg.contains("null")) {
                    this.ornamereg = str;
                }
                if (this.orgrelatname.contains("null")) {
                    this.orgrelatname = str;
                }
                if (this.orgrelatnamereg.contains("null")) {
                    this.orgrelatnamereg = str;
                }
                if (this.orggender.contains("null")) {
                    this.orggender = str;
                }
                string.contains("null");
                if (this.orgdob.contains("null")) {
                    this.orgdob = str;
                }
                if (this.orgaddress.contains("null")) {
                    this.orgaddress = str;
                }
                if (this.orgaddressreg.contains("null")) {
                    this.orgaddressreg = str;
                }
            } catch (Exception e) {
                Logger.d(str2, e.getMessage());
            }
            dataoneditbutton(bundle.getString(str3), bundle.getString(XmlErrorCodes.DATE), "Form 8");
        } else {
            str = "";
            str2 = EXCEPTION;
            str3 = "draftname";
            bundle = arguments;
        }
        this.teluguLang.add("భారత ఎన్నికల సంఘం");
        this.teluguLang.add("ఓటరు ఫోటో గుర్తింపు కార్డు");
        this.teluguLang.add("పేరు");
        this.teluguLang.add("తండ్రి పేరు");
        this.teluguLang.add("తల్లి పేరు");
        this.teluguLang.add("భర్త పేరు");
        this.teluguLang.add("భార్య పేరు");
        this.teluguLang.add("ఇతరుల పేరు");
        this.teluguLang.add("పురుషుడు");
        this.teluguLang.add("స్త్రీ");
        this.teluguLang.add("ధర్డ్ జండర్");
        this.teluguLang.add("లింగం");
        this.teluguLang.add("పుట్టిన తేది");
        this.teluguLang.add("వయస్సు");
        this.teluguLang.add("చిరునామా");
        this.teluguLang.add("జారి చేయు తేది");
        this.teluguLang.add("గమనిక");
        this.teluguLang.add("ఓటరు నమోదు అధికారి");
        this.teluguLang.add("ప్రతి ఎన్నికల ముందు, దయచేసి ప్రస్తుత ఎన్నికలలో మీ పేరు ఉందో లేదో సరిచూసుకోండి");
        this.teluguLang.add("ఈ కార్డు ఎన్నికల ప్రయోజనం కోసం తప్ప వయస్సుకు రుజువు కాదు");
        this.binding.district.setText("Electoral Registration Officer, " + assemblyNumber + StringUtils.SPACE + this.bloasmblyname);
        if (stateCode.equals("S01")) {
            this.binding.district1.setText(this.teluguLang.get(17) + ", " + assemblyNumber + StringUtils.SPACE + this.regionalAssemblyName);
        } else {
            this.binding.district1.setText("निर्वाचक निबंधन पदाधिकारी, " + assemblyNumber + StringUtils.SPACE + this.regionalAssemblyName);
        }
        String str8 = " : ";
        if (stateCode.equals("S01")) {
            this.binding.nameReg.setText(this.teluguLang.get(2) + " : ");
            this.binding.dobReg.setText(this.teluguLang.get(12) + " : ");
            this.binding.electionCommissionHindi.setText(this.teluguLang.get(0));
            this.binding.electorPhotoCard.setText(this.teluguLang.get(1));
            this.binding.add1.setText(this.teluguLang.get(14) + " : ");
            this.binding.genderReg.setText(this.teluguLang.get(11) + "/GENDER : ");
            this.binding.note.setText(this.teluguLang.get(16) + "/Note - ");
            this.binding.beforeReg.setText("1) " + this.teluguLang.get(18));
            this.binding.thisCard.setText("2) " + this.teluguLang.get(19));
        }
        try {
            if (this.corname.trim().isEmpty()) {
                this.binding.electorname1.setText(bundle.getString(str3));
                this.binding.electorname.setText(this.ornamereg);
            } else {
                this.binding.electorname1.setText(this.corname);
                this.binding.electorname.setText(this.cornamereg);
            }
        } catch (Exception e2) {
            Logger.d(str2, e2.getMessage());
        }
        try {
            String str9 = "FTHR";
            if (this.correlname.equals(StringUtils.SPACE)) {
                try {
                    str5 = r9;
                    try {
                        try {
                            if (this.relationType.equalsIgnoreCase(str5) || this.relationType.equalsIgnoreCase("FATHER") || this.relationType.equalsIgnoreCase("FTHR")) {
                                str6 = r8;
                                if (stateCode.equals("S01")) {
                                    this.binding.fatherhedhin.setText(this.teluguLang.get(3) + " : ");
                                } else {
                                    this.binding.fatherhedhin.setText("पिता का नाम : ");
                                }
                                this.binding.fathername.setText(this.orgrelatnamereg);
                                this.binding.fatherName1.setText(this.orgrelatname);
                            } else {
                                str6 = r8;
                                if (this.relationType.equalsIgnoreCase(str6) || this.relationType.equalsIgnoreCase("MOTHER") || this.relationType.equalsIgnoreCase("MTHR")) {
                                    if (stateCode.equals("S01")) {
                                        TextView textView = this.binding.fatherhedhin;
                                        str8 = this.teluguLang.get(4) + " : ";
                                        textView.setText(str8);
                                    } else {
                                        this.binding.fatherhedhin.setText("माता का नाम : ");
                                    }
                                    this.binding.fatherhed.setText("Mother's Name : ");
                                    this.binding.fathername.setText(this.orgrelatnamereg);
                                    this.binding.fatherName1.setText(this.orgrelatname);
                                } else if (this.relationType.equalsIgnoreCase("H") || this.relationType.equalsIgnoreCase("HUSBAND") || this.relationType.equalsIgnoreCase("HSBN")) {
                                    if (stateCode.equals("S01")) {
                                        this.binding.fatherhedhin.setText(this.teluguLang.get(5) + " : ");
                                    } else {
                                        this.binding.fatherhedhin.setText("पति का नाम : ");
                                    }
                                    this.binding.fatherhed.setText("Husband's Name : ");
                                    this.binding.fathername.setText(this.orgrelatnamereg);
                                    this.binding.fatherName1.setText(this.orgrelatname);
                                } else if (this.relationType.equalsIgnoreCase("W") || this.relationType.equalsIgnoreCase("WIFE")) {
                                    if (stateCode.equals("S01")) {
                                        this.binding.fatherhedhin.setText(this.teluguLang.get(6) + " : ");
                                    } else {
                                        this.binding.fatherhedhin.setText("पत्नी का नाम : ");
                                    }
                                    this.binding.fatherhed.setText("Wife's Name : ");
                                    this.binding.fathername.setText(this.orgrelatnamereg);
                                    this.binding.fatherName1.setText(this.orgrelatname);
                                } else if (this.relationType.equals("OTHER") || this.relationType.equals("Select Relation Type") || this.relationType.equals("null") || this.relationType.equalsIgnoreCase("L") || this.relationType.equalsIgnoreCase("O")) {
                                    if (stateCode.equals("S01")) {
                                        this.binding.fatherhedhin.setText(this.teluguLang.get(7) + " : ");
                                    } else {
                                        this.binding.fatherhedhin.setText("अन्य का नाम : ");
                                    }
                                    this.binding.fatherhed.setText("Other's Name : ");
                                    this.binding.fathername.setText(this.orgrelatnamereg);
                                    this.binding.fatherName1.setText(this.orgrelatname);
                                }
                            }
                            str4 = str6;
                        } catch (Exception e3) {
                            e = e3;
                            exc = e;
                            str4 = str9;
                            Logger.d(str2, exc.getMessage());
                        }
                    } catch (Exception e4) {
                        e = e4;
                        str9 = r8;
                    }
                } catch (Exception e5) {
                    e = e5;
                    str9 = r8;
                    str5 = r9;
                }
            } else {
                str4 = "M";
                str5 = "F";
                try {
                    if (this.relationType.equalsIgnoreCase(str5) || this.relationType.equalsIgnoreCase("FATHER") || this.relationType.equalsIgnoreCase("FTHR")) {
                        this.binding.fathername.setText(this.correlname);
                        TextView textView2 = this.binding.fatherName1;
                        str8 = this.correlnamereg;
                        textView2.setText(str8);
                    } else if (this.relationType.equalsIgnoreCase(str4) || this.relationType.equalsIgnoreCase("MOTHER") || this.relationType.equalsIgnoreCase("MTHR")) {
                        if (stateCode.equals("S01")) {
                            this.binding.fatherhedhin.setText(this.teluguLang.get(4) + " : ");
                        } else {
                            this.binding.fatherhedhin.setText("माता का नाम : ");
                        }
                        this.binding.fatherhed.setText("Mother's Name : ");
                        this.binding.fathername.setText(this.correlname);
                        TextView textView3 = this.binding.fatherName1;
                        str8 = this.correlnamereg;
                        textView3.setText(str8);
                    } else if (this.relationType.equalsIgnoreCase("H") || this.relationType.equalsIgnoreCase("HUSBAND")) {
                        if (stateCode.equals("S01")) {
                            this.binding.fatherhedhin.setText(this.teluguLang.get(5) + " : ");
                        } else {
                            this.binding.fatherhedhin.setText("पति का नाम : ");
                        }
                        this.binding.fatherhed.setText("Husband's Name : ");
                        this.binding.fathername.setText(this.correlname);
                        TextView textView4 = this.binding.fatherName1;
                        str8 = this.correlnamereg;
                        textView4.setText(str8);
                    } else if (this.relationType.equalsIgnoreCase("W") || this.relationType.equalsIgnoreCase("WIFE")) {
                        if (stateCode.equals("S01")) {
                            this.binding.fatherhedhin.setText(this.teluguLang.get(6) + " : ");
                        } else {
                            this.binding.fatherhedhin.setText("पत्नी का नाम : ");
                        }
                        this.binding.fatherhed.setText("Wife's Name : ");
                        this.binding.fathername.setText(this.correlname);
                        TextView textView5 = this.binding.fatherName1;
                        str8 = this.correlnamereg;
                        textView5.setText(str8);
                    } else if (this.relationType.equals("OTHER") || this.relationType.equals("Select Relation Type") || this.relationType.equalsIgnoreCase("L") || this.relationType.equalsIgnoreCase("O")) {
                        if (stateCode.equals("S01")) {
                            this.binding.fatherhedhin.setText(this.teluguLang.get(7) + " : ");
                        } else {
                            this.binding.fatherhedhin.setText("अन्य का नाम : ");
                        }
                        this.binding.fatherhed.setText("Other's Name : ");
                        this.binding.fathername.setText(this.correlname);
                        TextView textView6 = this.binding.fatherName1;
                        str8 = this.correlnamereg;
                        textView6.setText(str8);
                    }
                } catch (Exception e6) {
                    e = e6;
                    exc = e;
                    Logger.d(str2, exc.getMessage());
                }
            }
        } catch (Exception e7) {
            e = e7;
            str4 = r8;
            str5 = r9;
        }
        try {
            try {
                if (this.cordob.equals(str)) {
                    int iCalculateage = calculateage(this.orgdob);
                    if (iCalculateage == 0) {
                        str8 = "/";
                        this.binding.dob.setText(str8);
                    } else {
                        str8 = r10;
                        this.binding.dob.setText(this.orgdob + str8 + iCalculateage);
                    }
                } else {
                    str8 = r10;
                    int iCalculateagecorrected = calculateagecorrected(this.cordob);
                    if (iCalculateagecorrected == 0) {
                        this.binding.dob.setText(str8);
                    } else {
                        this.binding.dob.setText(this.cordob + str8 + iCalculateagecorrected);
                    }
                }
            } catch (Exception e8) {
                e = e8;
                Logger.d(str2, e.getMessage());
            }
        } catch (Exception e9) {
            e = e9;
            str8 = r10;
        }
        if (stateCode.equals("S04")) {
            this.binding.email.setText("www.ceobihar.nic.in");
        } else if (stateCode.equals("S05")) {
            this.binding.email.setText("www.ceogoa.nic.in");
        } else if (stateCode.equals("S03")) {
            this.binding.email.setText("www.ceoassam.nic.in");
        } else if (stateCode.equals("S28")) {
            this.binding.email.setText("www.ceo.uk.gov.in");
        } else if (stateCode.equals("S06")) {
            this.binding.email.setText("www.ceo.gujarat.gov.in");
        } else if (stateCode.equals("S20")) {
            this.binding.email.setText("www.ceorajasthan.nic.in");
        } else if (stateCode.equals("S08")) {
            this.binding.email.setText("www.ceohimachal.gov.in");
        } else if (stateCode.equals("S12")) {
            this.binding.email.setText("www.ceomadhyapradesh.nic.in");
        } else if (stateCode.equals("S26")) {
            this.binding.email.setText("www.ceochhattisgarh.nic.in");
        } else if (stateCode.equals("S16")) {
            this.binding.email.setText("www.ceo.mizoram.gov.in");
        } else if (stateCode.equals("S29")) {
            this.binding.email.setText("www.ceotelangana.nic.in");
        } else if (stateCode.equals("S02")) {
            this.binding.email.setText("www.ceoarunachal.nic.in");
        } else if (stateCode.equals("S01")) {
            this.binding.email.setText("www.ceoandhra.nic.in");
        } else if (stateCode.equals("S07")) {
            this.binding.email.setText("www.ceoharyana.gov.in");
        } else if (stateCode.equals("U02")) {
            this.binding.email.setText("www.ceochandigarh.gov.in");
        } else if (stateCode.equals("U01")) {
            this.binding.email.setText("www.as1.and.nic.in");
        } else if (stateCode.equals("U03")) {
            this.binding.email.setText("www.ceodaman.nic.in");
        } else if (stateCode.equals("S22")) {
            this.binding.email.setText("www.elections.tn.gov.in");
        } else if (stateCode.equals("S18")) {
            this.binding.email.setText("www.ceoorissa.nic.in");
        } else if (stateCode.equals("S19")) {
            this.binding.email.setText("www.ceopunjab.gov.in");
        } else if (stateCode.equals("S11")) {
            this.binding.email.setText("www.ceo.kerala.gov.in");
        } else if (stateCode.equals("S27")) {
            this.binding.email.setText("www.ceo.jharkhand.gov.in");
        } else if (stateCode.equals("S14")) {
            this.binding.email.setText("www.ceomanipur.nic.in");
        } else if (stateCode.equals("U05")) {
            this.binding.email.setText("www.ceodelhi.nic.in");
        } else if (stateCode.equals("S21")) {
            this.binding.email.setText("www.ceosikkim.nic.in");
        } else if (stateCode.equals("U07")) {
            this.binding.email.setText("www.ceoponducherry.py.gov.in");
        } else if (stateCode.equals("S10")) {
            this.binding.email.setText("www.ceo.karnataka.gov.in");
        } else if (stateCode.equals("S13")) {
            this.binding.email.setText("www.ceo.maharashtra.gov.in/");
        } else if (stateCode.equals("S15")) {
            this.binding.email.setText("www.ceomeghalaya.nic.in");
        } else if (stateCode.equals("S23")) {
            this.binding.email.setText("www.ceotripura.nic.in");
        } else if (stateCode.equals("S24")) {
            this.binding.email.setText("www.ceouttarpradesh.nic.in");
        } else if (stateCode.equals("S25")) {
            this.binding.email.setText("www.ceowestbengal.nic.in");
        } else if (stateCode.equals("U08")) {
            this.binding.email.setText("www.ceojk.nic.in");
        } else if (stateCode.equals("U09")) {
            this.binding.email.setText("www.ladakh.nic.in");
        } else if (stateCode.equals("U06")) {
            this.binding.email.setText("www.ceolakshadweep.gov.in");
        } else if (stateCode.equals("S17")) {
            this.binding.email.setText("www.ceo.nagaland.gov.in");
        }
        try {
            if (this.corgender.equals("Select Gender")) {
                if (stateCode.equals("S01")) {
                    if (this.orggender.equals(str4)) {
                        this.binding.gender.setText("Male/" + this.teluguLang.get(8));
                    } else if (this.orggender.equals(str5)) {
                        this.binding.gender.setText("Female/" + this.teluguLang.get(9));
                    } else {
                        this.binding.gender.setText("Third Gender/" + this.teluguLang.get(10));
                    }
                } else if (this.orggender.equals(str4)) {
                    this.binding.gender.setText("Male/पुस्र्ष");
                } else if (this.orggender.equals(str5)) {
                    this.binding.gender.setText("Female/महिला");
                } else {
                    this.binding.gender.setText("Third Gender/तीसरा लिंग");
                }
            } else if (stateCode.equals("S01")) {
                if (this.corgender.equals("MALE")) {
                    this.binding.gender.setText(this.corgender + str8 + this.teluguLang.get(8));
                }
                if (this.corgender.equals("FEMALE")) {
                    this.binding.gender.setText(this.corgender + str8 + this.teluguLang.get(9));
                }
                if (this.corgender.equals("THIRD GENDER")) {
                    this.binding.gender.setText(this.corgender + str8 + this.teluguLang.get(10));
                }
            } else {
                if (this.corgender.equals("MALE")) {
                    this.binding.gender.setText(this.corgender + "/पुस्र्ष");
                }
                if (this.corgender.equals("FEMALE")) {
                    this.binding.gender.setText(this.corgender + "/महिला");
                }
                if (this.corgender.equals("THIRD GENDER")) {
                    this.binding.gender.setText(this.corgender + "/तीसरा लिंग");
                }
            }
        } catch (Exception e10) {
            Logger.d(str2, e10.getMessage());
        }
        this.binding.subdate.setText(this.appdate);
        return this.binding.getRoot();
    }

    private void dataoneditbutton(String name, String date, String formtype) {
        this.viewModel.dataoneditbutton(name, date, formtype).observe(getViewLifecycleOwner(), new Observer() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Epic$$ExternalSyntheticLambda3
            public final void onChanged(Object obj) {
                this.f$0.lambda$dataoneditbutton$0((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dataoneditbutton$0(List list) {
        if (list.isEmpty()) {
            return;
        }
        String application = ((FormsinDraftMigrationModel) list.get(0)).getApplication();
        String photo8 = ((FormsinDraftMigrationModel) list.get(0)).getPhoto8();
        this.referencerlinkcoe8 = photo8;
        edit(application, photo8);
    }

    private void edit(String applicationdata, String img8) {
        try {
            if (!TextUtils.isEmpty(applicationdata)) {
                String[] strArrSplit = applicationdata.split(this.delimeter);
                if (strArrSplit[0].equals("Correction of Entries in Existing Electoral Roll") && strArrSplit[8].equals("PHOTO")) {
                    if (img8 != null && !img8.isEmpty() && !img8.equals("null")) {
                        getFile(img8);
                        System.out.println("kboisbruibr" + img8);
                    }
                } else {
                    getdetailsofInitialEpic(this.epicNumber, this.position);
                }
            } else {
                getdetailsofInitialEpic(this.epicNumber, this.position);
            }
        } catch (Exception e) {
            Logger.d(MIGRATION_CATCH_MSG, e.getMessage());
            getdetailsofInitialEpic(this.epicNumber, this.position);
        }
    }

    private void getdetailsofInitialEpic(final String initialEpic, final int position) {
        this.alertDialog.show();
        this.commonUtilClass.getdetailsofEpicforForm(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), initialEpic, new MyCallbackjsonTest() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Epic$$ExternalSyntheticLambda2
            @Override // in.gov.eci.bloapp.MyCallbackjsonTest
            public final void onCallbacktest(int i, JsonArray jsonArray) {
                this.f$0.lambda$getdetailsofInitialEpic$3(position, initialEpic, i, jsonArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdetailsofInitialEpic$3(final int i, final String str, int i2, JsonArray jsonArray) {
        if (i2 == 200) {
            if (jsonArray.size() != 0) {
                this.epicDetailsArray = jsonArray;
                this.f6in[1] = String.valueOf(jsonArray.get(i).getAsJsonObject().get("content").get("photo")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                String str2 = this.f6in[1];
                if (str2 != null || !str2.equals("") || !this.f6in[1].equals("null")) {
                    getFile(this.f6in[1]);
                    System.out.println("jhsdbak" + this.f6in[1]);
                }
                this.alertDialog.dismiss();
                return;
            }
            this.alertDialog.dismiss();
            return;
        }
        if (i2 == 401) {
            this.commonUtilClass.getRefreshToken(getContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Epic$$ExternalSyntheticLambda4
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i3, String str3, String str4) {
                    this.f$0.lambda$getdetailsofInitialEpic$2(str, i, i3, str3, str4);
                }
            });
        } else {
            getFile(this.shiftingImage);
            System.out.println("kjbsforoip" + this.shiftingImage);
        }
        this.alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdetailsofInitialEpic$2(String str, int i, int i2, String str2, String str3) {
        this.alertDialog.dismiss();
        System.out.println("zxnbchdbvfhvb " + i2 + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
        if (i2 == 401 || i2 == 400) {
            this.commonUtilClass.showMessageOK(requireContext(), SESSION_TOKEN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Epic$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.f$0.lambda$getdetailsofInitialEpic$1(dialogInterface, i3);
                }
            });
            return;
        }
        this.token = "Bearer " + str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str3);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str2);
        getdetailsofInitialEpic(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getdetailsofInitialEpic$1(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    public void getFile(String fileref) {
        this.commonUtilClass.getRetrofitClient(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd()).getFile("objectstorage", fileref, this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new AnonymousClass1(fileref));
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Epic$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<JsonObject> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final /* synthetic */ String val$fileref;

        AnonymousClass1(final String val$fileref) {
            this.val$fileref = val$fileref;
        }

        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            JSONObject jSONObject;
            if (response.code() == 200) {
                Migration_preview_Epic.this.base64element = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                byte[] bArrDecode = Base64.decode(Migration_preview_Epic.this.base64element, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (Migration_preview_Epic.this.base64element == null || Migration_preview_Epic.this.base64element.equals("null") || Migration_preview_Epic.this.base64element.equals("")) {
                    Migration_preview_Epic.this.binding.profile.setImageResource(R.drawable.blo_dummy_image);
                } else {
                    Migration_preview_Epic.this.binding.profile.setImageBitmap(bitmapDecodeByteArray);
                }
                Migration_preview_Epic.this.alertDialog.dismiss();
                return;
            }
            Migration_preview_Epic.this.alertDialog.dismiss();
            if (response.code() == 401) {
                CommomUtility commomUtility = Migration_preview_Epic.this.commonUtilClass;
                Context context = Migration_preview_Epic.this.getContext();
                String str = Migration_preview_Epic.this.refreshToken;
                final String str2 = this.val$fileref;
                commomUtility.getRefreshToken(context, str, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Epic$1$$ExternalSyntheticLambda0
                    @Override // in.gov.eci.bloapp.aadharcallback
                    public final void onCallBack(int i, String str3, String str4) {
                        this.f$0.lambda$onResponse$1(str2, i, str3, str4);
                    }
                });
            }
            try {
                jSONObject = new JSONObject(response.errorBody().string());
            } catch (IOException | JSONException e) {
                Logger.d(Migration_preview_Epic.MIGRATION_CATCH_MSG, e.getMessage());
                jSONObject = null;
            }
            try {
                String strOptString = jSONObject.optString("message");
                Migration_preview_Epic.this.binding.profile.setImageResource(R.drawable.blo_dummy_image);
                Logger.d("errorResponse", strOptString);
            } catch (Exception e2) {
                Logger.d(Migration_preview_Epic.MIGRATION_CATCH_MSG, e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(String str, int i, String str2, String str3) {
            Migration_preview_Epic.this.alertDialog.dismiss();
            System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
            if (i == 401 || i == 400) {
                Migration_preview_Epic.this.commonUtilClass.showMessageOK(Migration_preview_Epic.this.requireContext(), Migration_preview_Epic.SESSION_TOKEN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Epic$1$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onResponse$0(dialogInterface, i2);
                    }
                });
                return;
            }
            Migration_preview_Epic.this.token = "Bearer " + str2;
            SharedPref.getInstance(Migration_preview_Epic.this.requireContext()).setRefreshToken(str3);
            SharedPref.getInstance(Migration_preview_Epic.this.requireContext()).setToken("Bearer " + str2);
            Migration_preview_Epic.this.getFile(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Migration_preview_Epic.this.requireContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Migration_preview_Epic.this.requireContext()).setLocaleBool(false);
            Migration_preview_Epic.this.startActivity(new Intent((Context) Migration_preview_Epic.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonObject> call, Throwable t) {
            Logger.d("coming in onFailure ", t.getMessage());
        }
    }

    private int calculateage(String dOB) {
        try {
            if (dOB.isEmpty()) {
                return 0;
            }
            LocalDate localDate = LocalDate.parse(new SimpleDateFormat(DDMMHHSS).format(new Date(new SimpleDateFormat("yyyy/MM/dd").format(new SimpleDateFormat(DDMMHHSS).parse(dOB)))));
            LocalDate localDateNow = LocalDate.now();
            if (localDate == null || localDateNow == null) {
                return 0;
            }
            return Period.between(localDate, localDateNow).getYears();
        } catch (Exception unused) {
            return 0;
        }
    }

    private int calculateagecorrected(String dOB) {
        try {
            if (dOB.isEmpty()) {
                return 0;
            }
            LocalDate localDate = LocalDate.parse(new SimpleDateFormat(DDMMHHSS).format(new Date(dOB)));
            LocalDate localDateNow = LocalDate.now();
            if (localDate == null || localDateNow == null) {
                return 0;
            }
            return Period.between(localDate, localDateNow).getYears();
        } catch (Exception unused) {
            return 0;
        }
    }

    private void showDialog(String message) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle("Error");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Epic$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public void getSection(String stateCode, String token1, String asmblyNo, String partNo, String sectionNumber) {
        try {
            try {
                ((UserClient) ApiClient.getClient(getContext()).create(UserClient.class)).getSection1("ANDROIDMOB", token1, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", stateCode, "application/json", asmblyNo, partNo).enqueue(new AnonymousClass2(sectionNumber));
            } catch (Exception e) {
                e = e;
                Logger.d("Content", e.getMessage());
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Epic$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<JsonArray> {
        final /* synthetic */ String val$sectionNumber;

        AnonymousClass2(final String val$sectionNumber) {
            this.val$sectionNumber = val$sectionNumber;
        }

        public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
            if (response.code() == 200) {
                JsonArray jsonArray = (JsonArray) response.body();
                for (int i = 0; i < jsonArray.size(); i++) {
                    JsonObject asJsonObject = Migration_preview_Epic.this.gson.toJsonTree(jsonArray.get(i)).getAsJsonObject();
                    Migration_preview_Epic.this.sectionNO = String.valueOf(asJsonObject.get("sectionNo"));
                    if (this.val$sectionNumber.equals(Migration_preview_Epic.this.sectionNO)) {
                        Migration_preview_Epic.this.sectionName = String.valueOf(asJsonObject.get("sectionName")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                        Migration_preview_Epic.this.sectionNamereg = String.valueOf(asJsonObject.get("sectionNameL1")).replace(RegexMatcher.JSON_STRING_REGEX, "");
                    }
                }
                try {
                    if (Migration_preview_Epic.this.addresssor.equals("  ")) {
                        if (Migration_preview_Epic.this.addresscor.equals("  ")) {
                            if (!Migration_preview_Epic.this.orgaddress.contains("null")) {
                                if (Migration_preview_Epic.this.orgstreet == null || Migration_preview_Epic.this.orgstreet.equals("null") || Migration_preview_Epic.this.orgstreet.equals("")) {
                                    Migration_preview_Epic.this.binding.address.setText(Migration_preview_Epic.this.orghouseno + ", " + Migration_preview_Epic.this.sectionName + ", " + Migration_preview_Epic.this.bloasmblyname + ", " + Migration_preview_Epic.this.blodistrictname + ", " + Migration_preview_Epic.this.stateName);
                                    Migration_preview_Epic.this.binding.address1.setText(Migration_preview_Epic.this.orghousenoreg + ", " + Migration_preview_Epic.this.sectionNamereg + ", " + Migration_preview_Epic.this.regionalAssemblyName + ", " + Migration_preview_Epic.this.regionalDistrictName + ", " + Migration_preview_Epic.this.regionalStateName);
                                } else {
                                    Migration_preview_Epic.this.binding.address.setText(Migration_preview_Epic.this.orgaddress + ", " + Migration_preview_Epic.this.blodistrictname + ", " + Migration_preview_Epic.this.stateName);
                                    Migration_preview_Epic.this.binding.address1.setText(Migration_preview_Epic.this.orgaddressreg + ", " + Migration_preview_Epic.this.regionalDistrictName + ", " + Migration_preview_Epic.this.regionalStateName);
                                }
                            }
                        } else {
                            Migration_preview_Epic.this.binding.address.setText(Migration_preview_Epic.this.addresscor + ", " + Migration_preview_Epic.this.coedistrict + ", " + Migration_preview_Epic.this.stateName);
                            Migration_preview_Epic.this.binding.address1.setText(Migration_preview_Epic.this.addresscorreg + ", " + Migration_preview_Epic.this.regionalDistrictName + ", " + Migration_preview_Epic.this.regionalStateName);
                        }
                    } else {
                        Migration_preview_Epic.this.binding.address.setText(Migration_preview_Epic.this.addresssor + ", " + Migration_preview_Epic.this.sordistrict + ", " + Migration_preview_Epic.this.stateName);
                        Migration_preview_Epic.this.binding.address1.setText(Migration_preview_Epic.this.addresssorreg + ", " + Migration_preview_Epic.this.regionalDistrictName + ", " + Migration_preview_Epic.this.regionalStateName);
                    }
                    return;
                } catch (Exception e) {
                    Logger.d("exception", e.getMessage());
                    return;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject(response.errorBody().string());
                SharedPref.getInstance(Migration_preview_Epic.this.getContext()).setSectionData("");
                Logger.d("errorResponse", jSONObject.optString("message"));
                try {
                    if (Migration_preview_Epic.this.addresssor.equals("  ")) {
                        if (Migration_preview_Epic.this.addresscor.equals("  ")) {
                            if (!Migration_preview_Epic.this.orgaddress.contains("null")) {
                                if (Migration_preview_Epic.this.orgstreet == null || Migration_preview_Epic.this.orgstreet.equals("null") || Migration_preview_Epic.this.orgstreet.equals("")) {
                                    Migration_preview_Epic.this.binding.address.setText(Migration_preview_Epic.this.orghouseno + ", " + Migration_preview_Epic.this.bloasmblyname + ", " + Migration_preview_Epic.this.blodistrictname + ", " + Migration_preview_Epic.this.stateName);
                                    Migration_preview_Epic.this.binding.address1.setText(Migration_preview_Epic.this.orghousenoreg + ", " + Migration_preview_Epic.this.sectionNamereg + ", " + Migration_preview_Epic.this.regionalAssemblyName + ", " + Migration_preview_Epic.this.regionalDistrictName + ", " + Migration_preview_Epic.this.regionalStateName);
                                } else {
                                    Migration_preview_Epic.this.binding.address.setText(Migration_preview_Epic.this.orgaddress + ", " + Migration_preview_Epic.this.blodistrictname + ", " + Migration_preview_Epic.this.stateName);
                                    Migration_preview_Epic.this.binding.address1.setText(Migration_preview_Epic.this.orgaddressreg + ", " + Migration_preview_Epic.this.regionalDistrictName + ", " + Migration_preview_Epic.this.regionalStateName);
                                }
                            }
                        } else {
                            Migration_preview_Epic.this.binding.address.setText(Migration_preview_Epic.this.addresscor + ", " + Migration_preview_Epic.this.coedistrict + ", " + Migration_preview_Epic.this.stateName);
                            Migration_preview_Epic.this.binding.address1.setText(Migration_preview_Epic.this.addresscorreg + ", " + Migration_preview_Epic.this.regionalDistrictName + ", " + Migration_preview_Epic.this.regionalStateName);
                        }
                    } else {
                        Migration_preview_Epic.this.binding.address.setText(Migration_preview_Epic.this.addresssor + ", " + Migration_preview_Epic.this.sordistrict + ", " + Migration_preview_Epic.this.stateName);
                        Migration_preview_Epic.this.binding.address1.setText(Migration_preview_Epic.this.addresssorreg + ", " + Migration_preview_Epic.this.regionalDistrictName + ", " + Migration_preview_Epic.this.regionalStateName);
                    }
                } catch (Exception e2) {
                    Logger.d("exception", e2.getMessage());
                }
            } catch (IOException | JSONException e3) {
                SharedPref.getInstance(Migration_preview_Epic.this.getContext()).setSectionData("");
                if (response.code() == 401) {
                    Migration_preview_Epic.this.commonUtilClass.showMessageWithTitleOK(Migration_preview_Epic.this.requireContext(), "Alert", Migration_preview_Epic.SESSION_TOKEN, new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.migration.Migration_preview_Epic$2$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onResponse$0(dialogInterface, i2);
                        }
                    });
                }
                Logger.d("", e3.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(DialogInterface dialogInterface, int i) {
            SharedPref.getInstance(Migration_preview_Epic.this.getContext()).setIsLoggedIn(false);
            SharedPref.getInstance(Migration_preview_Epic.this.getContext()).setLocaleBool(false);
            Migration_preview_Epic.this.startActivity(new Intent((Context) Migration_preview_Epic.this.getActivity(), (Class<?>) LoginActivity.class));
        }

        public void onFailure(Call<JsonArray> call, Throwable t) {
            SharedPref.getInstance(Migration_preview_Epic.this.getContext()).setSectionData("");
            try {
                if (Migration_preview_Epic.this.addresssor.equals("  ")) {
                    if (Migration_preview_Epic.this.addresscor.equals("  ")) {
                        if (!Migration_preview_Epic.this.orgaddress.contains("null")) {
                            if (Migration_preview_Epic.this.orgstreet == null || Migration_preview_Epic.this.orgstreet.equals("null") || Migration_preview_Epic.this.orgstreet.equals("")) {
                                Migration_preview_Epic.this.binding.address.setText(Migration_preview_Epic.this.orghouseno + ", " + Migration_preview_Epic.this.bloasmblyname + ", " + Migration_preview_Epic.this.blodistrictname + ", " + Migration_preview_Epic.this.stateName);
                                Migration_preview_Epic.this.binding.address1.setText(Migration_preview_Epic.this.orghousenoreg + ", " + Migration_preview_Epic.this.sectionNamereg + ", " + Migration_preview_Epic.this.regionalAssemblyName + ", " + Migration_preview_Epic.this.regionalDistrictName + ", " + Migration_preview_Epic.this.regionalStateName);
                            } else {
                                Migration_preview_Epic.this.binding.address.setText(Migration_preview_Epic.this.orgaddress + ", " + Migration_preview_Epic.this.blodistrictname + ", " + Migration_preview_Epic.this.stateName);
                                Migration_preview_Epic.this.binding.address1.setText(Migration_preview_Epic.this.orgaddressreg + ", " + Migration_preview_Epic.this.regionalDistrictName + ", " + Migration_preview_Epic.this.regionalStateName);
                            }
                        }
                    } else {
                        Migration_preview_Epic.this.binding.address.setText(Migration_preview_Epic.this.addresscor + ", " + Migration_preview_Epic.this.coedistrict + ", " + Migration_preview_Epic.this.stateName);
                        Migration_preview_Epic.this.binding.address1.setText(Migration_preview_Epic.this.addresscorreg + ", " + Migration_preview_Epic.this.regionalDistrictName + ", " + Migration_preview_Epic.this.regionalStateName);
                    }
                } else {
                    Migration_preview_Epic.this.binding.address.setText(Migration_preview_Epic.this.addresssor + ", " + Migration_preview_Epic.this.sordistrict + ", " + Migration_preview_Epic.this.stateName);
                    Migration_preview_Epic.this.binding.address1.setText(Migration_preview_Epic.this.addresssorreg + ", " + Migration_preview_Epic.this.regionalDistrictName + ", " + Migration_preview_Epic.this.regionalStateName);
                }
            } catch (Exception e) {
                Logger.d(Migration_preview_Epic.EXCEPTION, e.getMessage());
            }
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }
}
