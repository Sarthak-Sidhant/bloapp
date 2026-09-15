package in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MyCallback;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.databinding.BloFragmentEPICBinding;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class EPIC extends Fragment {
    BloFragmentEPICBinding binding;
    private String gender;
    String refreshToken;
    private String token;
    private final CommomUtility commonUtilClass = new CommomUtility();
    String byteArray = "byteArray";
    String relationSpinner = "relationSpinner";
    String relativeNameOfficial = "relativeNameOfficial";
    String relativeSurNameOfficial = "relativeSurNameOfficial";
    String relativeName = "relativeName";
    String relativeSurName = "relativeSurName";
    String genderPersonalSpinner = "genderPersonalSpinner";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentEPICBinding.inflate(getLayoutInflater());
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        String assemblyNumber = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        String assemblyNameL1 = SharedPref.getInstance(requireContext()).getAssemblyNameL1();
        String regionalStateName = SharedPref.getInstance(requireContext()).getRegionalStateName();
        final Bundle arguments = getArguments();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
        if (arguments.getString(this.byteArray) != null || !arguments.getString(this.byteArray).equals("") || !arguments.getString(this.byteArray).equals("null")) {
            this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), arguments.getString(this.byteArray), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.EPIC$$ExternalSyntheticLambda0
                @Override // in.gov.eci.bloapp.MyCallback
                public final void onCallback(int i, String str) {
                    this.f$0.lambda$onCreateView$3(arguments, i, str);
                }
            });
        }
        this.binding.electorname.setText(arguments.getString("firstnameOfficial") + " " + arguments.getString("surnameOfficial"));
        this.binding.electorname1.setText(arguments.getString("firstNameEd") + " " + arguments.getString("surNameEd"));
        if (arguments.getString(this.relationSpinner).equals("FATHER")) {
            this.binding.fathername.setText(arguments.getString(this.relativeNameOfficial) + " " + arguments.getString(this.relativeSurNameOfficial));
            this.binding.fatherName1.setText(arguments.getString(this.relativeName) + " " + arguments.getString(this.relativeSurName));
        } else if (arguments.getString(this.relationSpinner).equals("MOTHER")) {
            this.binding.fatherhedhin.setText("माता का नाम : ");
            this.binding.fatherhed.setText("Mother's Name : ");
            this.binding.fathername.setText(arguments.getString(this.relativeNameOfficial) + " " + arguments.getString(this.relativeSurNameOfficial));
            this.binding.fatherName1.setText(arguments.getString(this.relativeName) + " " + arguments.getString(this.relativeSurName));
        } else if (arguments.getString(this.relationSpinner).equals("HUSBAND")) {
            this.binding.fatherhedhin.setText("पति का नाम : ");
            this.binding.fatherhed.setText("Husband's Name : ");
            this.binding.fathername.setText(arguments.getString(this.relativeNameOfficial) + " " + arguments.getString(this.relativeSurNameOfficial));
            this.binding.fatherName1.setText(arguments.getString(this.relativeName) + " " + arguments.getString(this.relativeSurName));
        } else if (arguments.getString(this.relationSpinner).equals("WIFE")) {
            this.binding.fatherhedhin.setText("पत्नी का नाम : ");
            this.binding.fatherhed.setText("Wife's Name : ");
            this.binding.fathername.setText(arguments.getString(this.relativeNameOfficial) + " " + arguments.getString(this.relativeSurNameOfficial));
            this.binding.fatherName1.setText(arguments.getString(this.relativeName) + " " + arguments.getString(this.relativeSurName));
        } else if (arguments.getString(this.relationSpinner).equals("OTHER") || arguments.getString(this.relationSpinner).equals("Legal Guardian in case of orphan/Third Gender")) {
            this.binding.fatherhedhin.setText("अन्य का नाम : ");
            this.binding.fatherhed.setText("Other's Name : ");
            this.binding.fathername.setText(arguments.getString(this.relativeNameOfficial) + " " + arguments.getString(this.relativeSurNameOfficial));
            this.binding.fatherName1.setText(arguments.getString(this.relativeName) + " " + arguments.getString(this.relativeSurName));
        }
        if (arguments.getString(this.genderPersonalSpinner).equals("MALE")) {
            this.gender = "पुस्र्ष";
        } else if (arguments.getString(this.genderPersonalSpinner).equals("FEMALE")) {
            this.gender = "महिला";
        } else if (arguments.getString(this.genderPersonalSpinner).equals("THIRD GENDER")) {
            this.gender = "तीसरा लिंग";
        }
        this.binding.gender.setText(this.gender + "/" + arguments.getString(this.genderPersonalSpinner));
        this.binding.epicDistrict.setText("Electoral Registration Officer, " + assemblyNumber + " " + SharedPref.getInstance(getContext()).getAssemblyName());
        this.binding.epicDistrict1.setText("निर्वाचक निबंधन पदाधिकारी, " + assemblyNumber + " " + assemblyNameL1);
        try {
            this.binding.dob.setText(simpleDateFormat2.format(simpleDateFormat.parse(arguments.getString("dobEd"))));
        } catch (ParseException e) {
            Logger.d("", e.getMessage());
        }
        this.binding.address.setText(arguments.getString("housenoOfficial") + ", " + arguments.getString("streetOfficial") + ", " + arguments.getString("townOfficial") + ", " + SharedPref.getInstance(requireContext()).getDistrictNameL1() + ", " + regionalStateName);
        this.binding.address1.setText(arguments.getString("houseNoEd") + ", " + arguments.getString("streetEd") + ", " + arguments.getString("townEd") + ", " + arguments.getString("districtSpinner1") + ", " + arguments.getString("unionSpinner"));
        try {
            this.binding.subdate.setText(simpleDateFormat2.format(simpleDateFormat.parse(arguments.getString("dateEdDecleration"))));
        } catch (ParseException e2) {
            Logger.d("", e2.getMessage());
        }
        String string = arguments.getString("mSTATECODE");
        if (string.equals("S04")) {
            this.binding.email.setText("www.ceobihar.nic.in");
        } else if (string.equals("S05")) {
            this.binding.email.setText("www.ceogoa.nic.in");
        } else if (string.equals("S03")) {
            this.binding.email.setText("www.ceoassam.nic.in");
        } else if (string.equals("S28")) {
            this.binding.email.setText("www.ceo.uk.gov.in");
        } else if (string.equals("S06")) {
            this.binding.email.setText("www.ceo.gujarat.gov.in");
        } else if (string.equals("S20")) {
            this.binding.email.setText("www.ceorajasthan.nic.in");
        } else if (string.equals("S08")) {
            this.binding.email.setText("www.ceohimachal.gov.in");
        } else if (string.equals("S12")) {
            this.binding.email.setText("www.ceomadhyapradesh.nic.in");
        } else if (string.equals("S26")) {
            this.binding.email.setText("www.ceochhattisgarh.nic.in");
        } else if (string.equals("S16")) {
            this.binding.email.setText("www.ceo.mizoram.gov.in");
        } else if (string.equals("S29")) {
            this.binding.email.setText("www.ceotelangana.nic.in");
        } else if (string.equals("S02")) {
            this.binding.email.setText("www.ceoarunachal.nic.in");
        } else if (string.equals("U02")) {
            this.binding.email.setText("www.ceochandigarh.gov.in");
        } else if (string.equals("U01")) {
            this.binding.email.setText("www.as1.and.nic.in");
        } else if (string.equals("S22")) {
            this.binding.email.setText("www.elections.tn.gov.in");
        } else if (string.equals("U03")) {
            this.binding.email.setText("www.ceodaman.nic.in");
        } else if (string.equals("S07")) {
            this.binding.email.setText("www.ceoharyana.gov.in");
        } else if (string.equals("S14")) {
            this.binding.email.setText("www.ceomanipur.nic.in");
        } else if (string.equals("S11")) {
            this.binding.email.setText("www.ceo.kerala.gov.in");
        } else if (string.equals("S27")) {
            this.binding.email.setText("www.ceo.jharkhand.gov.in");
        } else if (string.equals("S01")) {
            this.binding.email.setText("www.ceoandhra.nic.in");
        } else if (string.equals("S19")) {
            this.binding.email.setText("www.ceopunjab.gov.in");
        } else if (string.equals("S18")) {
            this.binding.email.setText("www.ceoorissa.nic.in");
        } else if (string.equals("U05")) {
            this.binding.email.setText("www.ceodelhi.nic.in");
        } else if (string.equals("S21")) {
            this.binding.email.setText("www.ceosikkim.nic.in");
        } else if (string.equals("U07")) {
            this.binding.email.setText("www.ceoponducherry.py.gov.in");
        } else if (string.equals("S10")) {
            this.binding.email.setText("www.ceo.karnataka.gov.in");
        } else if (string.equals("S13")) {
            this.binding.email.setText("www.ceo.maharashtra.gov.in/");
        } else if (string.equals("S15")) {
            this.binding.email.setText("www.ceomeghalaya.nic.in");
        } else if (string.equals("S23")) {
            this.binding.email.setText("www.ceotripura.nic.in");
        } else if (string.equals("S24")) {
            this.binding.email.setText("www.ceouttarpradesh.nic.in");
        } else if (string.equals("S25")) {
            this.binding.email.setText("www.ceowestbengal.nic.in");
        } else if (string.equals("U08")) {
            this.binding.email.setText("www.ceojk.nic.in");
        } else if (string.equals("U09")) {
            this.binding.email.setText("www.ladakh.nic.in");
        } else if (string.equals("U06")) {
            this.binding.email.setText("www.ceolakshadweep.gov.in");
        } else if (string.equals("S17")) {
            this.binding.email.setText("www.ceo.nagaland.gov.in");
        }
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(final Bundle bundle, int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.EPIC$$ExternalSyntheticLambda3
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$onCreateView$2(bundle, i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.profile.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(Bundle bundle, int i, String str, String str2) {
        System.out.println("zxnbchdbvfhvb " + i + " " + str + " " + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.EPIC$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onCreateView$0(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), bundle.getString(this.byteArray), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.EPIC$$ExternalSyntheticLambda2
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$onCreateView$1(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(int i, String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.profile.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }
}
