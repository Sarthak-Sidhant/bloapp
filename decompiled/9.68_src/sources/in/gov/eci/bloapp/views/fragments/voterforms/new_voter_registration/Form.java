package in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.MyCallback;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.aadharcallback;
import in.gov.eci.bloapp.databinding.BloFragmentFormBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.Utils;
import in.gov.eci.bloapp.views.activity.LoginActivity;
import in.gov.eci.bloapp.views.activity.newsir.model.FormverificationPayload;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class Form extends Fragment {
    BloFragmentFormBinding binding;
    String choiceOfannexureD;
    String citizenshipTypeCat;
    String decFormFilename;
    String doc1filename;
    String doc2filename;
    String doc3filename;
    String doc4filename;
    String doc5filename;
    String doc6filename;
    String doc7filename;
    String doc8filename;
    String doc9filename;
    String fathersNationality;
    String flagcat3scenerio1;
    String flagcat3scenerio2;
    String flagcat4scenerio1;
    String flagcat4scenerio2;
    String flagcat4scenerio3;
    FormverificationPayload formverificationPayload;
    String headerForProgenyRB;
    String headerForProgenyorNA;
    String headerForSelfRB;
    boolean isAnnexureenabled;
    String list17ocUrl;
    String list1CodeName;
    String list1Doc;
    String list1DocUrl;
    String list2DocUrl;
    String list2codeName;
    String list3DocUrl;
    String list3codeName;
    String list4DocUrl;
    String list4codeName;
    String list5DocUrl;
    String list5codeName;
    String list6DocUrl;
    String list6codeName;
    String list7codeName;
    String list8codeName;
    String mothersNationality;
    String progencyrelationType;
    String refreshToken;
    String signatureFileSize;
    String signatureFilename;
    String signatureURL;
    String stateCode;
    private String token;
    private final CommomUtility commonUtilClass = new CommomUtility();
    private final String session = "Session Expired. Please Login again.";
    String byteArray = "byteArray";
    String pdfbyteArray2 = "pdfbyteArray2";
    String pdfbyteArray = "pdfbyteArray";
    String pdfbyteArray1 = "pdfbyteArray1";
    String jpeg = ".jpeg";
    ArrayList<String> StateList = new ArrayList<>();
    ArrayList<String> StateNameList = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentFormBinding.inflate(getLayoutInflater());
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.refreshToken = SharedPref.getInstance(requireContext()).getRefreshToken();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        final Bundle arguments = getArguments();
        this.binding.state.setText(arguments.getString("stateSpinner"));
        this.binding.district.setText(arguments.getString("districtSpinner"));
        this.binding.constituency.setText(arguments.getString("noEd") + " | " + arguments.getString("assemblyEd"));
        this.binding.namepreview.setText(arguments.getString("firstNameEd"));
        this.binding.namepreview1.setText(arguments.getString("firstnameOfficial"));
        this.binding.lastnamepreview.setText(arguments.getString("surNameEd"));
        this.binding.lastnamepreview1.setText(arguments.getString("surnameOfficial"));
        this.binding.relnamepreview.setText(arguments.getString("relativeName"));
        this.binding.relnamepreview1.setText(arguments.getString("relativeNameOfficial"));
        this.binding.relsurnamepreview.setText(arguments.getString("relativeSurName"));
        this.binding.relsurnamepreview1.setText(arguments.getString("relativeSurNameOfficial"));
        this.binding.relationtype.setText(arguments.getString("relationSpinner"));
        this.StateList = SharedPref.getInstance(requireContext()).getAcListCode(Constants.STATE_LIST_CODE);
        this.StateNameList = SharedPref.getInstance(requireContext()).getAcListName(Constants.STATE_LIST_NAME);
        this.binding.filenamepreview.setText(arguments.getString("choosePhoto"));
        if (arguments.getString(this.byteArray) != null || !arguments.getString(this.byteArray).equals("") || !arguments.getString(this.byteArray).equals("null")) {
            if (arguments.getString("choosePhoto").contains(".pdf")) {
                this.binding.imagepreview.setImageResource(R.drawable.blo_pfd_thumbnail);
            } else {
                this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), arguments.getString(this.byteArray), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda31
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i, String str) {
                        this.f$0.lambda$onCreateView$3(arguments, i, str);
                    }
                });
            }
        }
        if (arguments.getString("mobile").equals("Self")) {
            this.binding.self.setChecked(true);
            this.binding.relative.setEnabled(false);
        } else if (arguments.getString("mobile").equals("Relative mentioned above")) {
            this.binding.relative.setChecked(true);
            this.binding.self.setEnabled(false);
        }
        this.binding.mobile.setText("+91-" + arguments.getString("mobileNumEd"));
        if (arguments.getString("email").equals("Self")) {
            this.binding.selfRb.setChecked(true);
            this.binding.emailRb.setEnabled(false);
        } else if (arguments.getString("email").equals("Relative mentioned above")) {
            this.binding.emailRb.setChecked(true);
            this.binding.selfRb.setEnabled(false);
        }
        this.binding.email.setText(arguments.getString("emailEd"));
        if (arguments.getString("aadhar").equals("Aadhaar Number")) {
            this.binding.aadharRb.setChecked(true);
            this.binding.noAadharRb.setEnabled(false);
        } else if (arguments.getString("aadhar").equals("I am not able to furnish my Aadhaar Number because I don’t have Aadhaar Number.")) {
            this.binding.noAadharRb.setChecked(true);
            this.binding.aadharRb.setEnabled(false);
        }
        if (arguments.getString("aadharEd").length() != 12) {
            this.binding.aadhar.setText(arguments.getString("aadharEd"));
        } else {
            this.binding.aadhar.setText(Utils.maskAadhaar(arguments.getString("aadharEd")));
        }
        this.binding.gender.setText(arguments.getString("genderPersonalSpinner"));
        this.binding.dob.setText(arguments.getString("dobEd"));
        this.binding.ageproof.setText(arguments.getString("documentSpinner"));
        this.binding.anyage.setText(arguments.getString("otherEd"));
        this.binding.agefilename.setText(arguments.getString("photoname"));
        if (arguments.getString(this.pdfbyteArray2) != null || !arguments.getString(this.pdfbyteArray2).equals("") || !arguments.getString(this.pdfbyteArray2).equals("null")) {
            if (this.binding.agefilename.getText().toString().contains(".jpg") || this.binding.agefilename.getText().toString().contains(this.jpeg) || this.binding.agefilename.getText().toString().contains(".png")) {
                this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), arguments.getString(this.pdfbyteArray2), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda32
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i, String str) {
                        this.f$0.lambda$onCreateView$7(arguments, i, str);
                    }
                });
            } else {
                this.binding.ageimg.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
        this.binding.houseno.setText(arguments.getString("houseNoEd"));
        this.binding.housenoreg.setText(arguments.getString("housenoOfficial"));
        this.binding.street.setText(arguments.getString("streetEd"));
        this.binding.streetreg.setText(arguments.getString("streetOfficial"));
        this.binding.town.setText(arguments.getString("townEd"));
        this.binding.townreg.setText(arguments.getString("townOfficial"));
        this.binding.postoffice.setText(arguments.getString("postofficeEd"));
        this.binding.postofficereg.setText(arguments.getString("postofficeOfficial"));
        this.binding.pincode.setText(arguments.getString("pincodeEd"));
        this.binding.tehsil.setText(arguments.getString("tehsilEd"));
        this.binding.tehsilreg.setText(arguments.getString("tehsilOfficial"));
        this.binding.districtadd.setText(arguments.getString("districtSpinner1"));
        this.binding.stateut.setText(arguments.getString("unionSpinner"));
        this.binding.addproof.setText(arguments.getString("documentSp"));
        this.binding.anyadd.setText(arguments.getString("anyOtherEd"));
        this.binding.addfilename.setText(arguments.getString("chooseFileTv3"));
        if (arguments.getString(this.pdfbyteArray) != null || !arguments.getString(this.pdfbyteArray).equals("") || !arguments.getString(this.pdfbyteArray).equals("null")) {
            if (this.binding.addfilename.getText().toString().contains(".jpg") || this.binding.addfilename.getText().toString().contains(this.jpeg) || this.binding.addfilename.getText().toString().contains(".png")) {
                this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), arguments.getString(this.pdfbyteArray), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda34
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i, String str) {
                        this.f$0.lambda$onCreateView$11(arguments, i, str);
                    }
                });
            } else {
                this.binding.addimg.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
        if (arguments.getString("Loco").equals("Locomotive")) {
            this.binding.loco.setChecked(true);
        }
        if (arguments.getString("visual").equals("visual")) {
            this.binding.visual.setChecked(true);
        }
        if (arguments.getString("deaf").equals("deaf")) {
            this.binding.deaf.setChecked(true);
        }
        if (arguments.getString("other").equals("other")) {
            this.binding.other.setChecked(true);
            this.binding.otherEdDetails.setVisibility(0);
            this.binding.otherEdDetails.setText(arguments.getString("otherEdDetails"));
        }
        this.binding.percent.setText(arguments.getString("percentageEd") + " %");
        if (arguments.getString("yesno").equals("Yes")) {
            this.binding.yes.setChecked(true);
            this.binding.linear.setVisibility(0);
            this.binding.no.setEnabled(false);
            this.binding.disfilename.setText(arguments.getString("chooseFileTv4"));
            if (arguments.getString(this.pdfbyteArray1) != null || !arguments.getString(this.pdfbyteArray1).equals("") || !arguments.getString(this.pdfbyteArray1).equals("null")) {
                if (this.binding.disfilename.getText().toString().contains(".jpg") || this.binding.disfilename.getText().toString().contains(this.jpeg) || this.binding.disfilename.getText().toString().contains(".png")) {
                    this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), arguments.getString(this.pdfbyteArray1), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda35
                        @Override // in.gov.eci.bloapp.MyCallback
                        public final void onCallback(int i, String str) {
                            this.f$0.lambda$onCreateView$15(arguments, i, str);
                        }
                    });
                } else {
                    this.binding.disimg.setImageResource(R.drawable.blo_pfd_thumbnail);
                }
            }
        } else if (arguments.getString("yesno").equals("No")) {
            this.binding.no.setChecked(true);
            this.binding.linear.setVisibility(8);
            this.binding.yes.setEnabled(false);
        }
        this.binding.familyname.setText(arguments.getString("familyMemberName"));
        this.binding.epicfam.setText(arguments.getString("familyEpic"));
        if (arguments.getString("familySp").equals("Select Relation Type")) {
            this.binding.relafamily.setText(StringUtils.SPACE);
        } else {
            this.binding.relafamily.setText(arguments.getString("familySp"));
        }
        if (arguments != null && arguments.containsKey("isIndia") && !TextUtils.isEmpty(arguments.getString("isIndia")) && arguments.getString("isIndia").equalsIgnoreCase("Y")) {
            this.binding.indiaRb.setChecked(true);
            this.binding.outsideRb.setEnabled(false);
            this.binding.indiaLayout.setVisibility(0);
            this.binding.outsideIndiaLayout.setVisibility(8);
            this.binding.village.setText(arguments.getString("townDecSp"));
            this.binding.statedec.setText(arguments.getString("stateDecSp"));
            this.binding.districtdec.setText(arguments.getString("districtDecSp"));
        } else if (arguments != null && arguments.containsKey("isIndia") && !TextUtils.isEmpty(arguments.getString("isIndia")) && arguments.getString("isIndia").equalsIgnoreCase("N")) {
            this.binding.outsideRb.setChecked(true);
            this.binding.indiaRb.setEnabled(false);
            this.binding.indiaLayout.setVisibility(8);
            this.binding.outsideIndiaLayout.setVisibility(0);
            this.binding.countrydec.setText(arguments.getString("outsideIndia"));
        }
        this.binding.doumentdec.setText(arguments.getString("documentName"));
        this.binding.date.setText(arguments.getString("dobDec"));
        this.binding.place.setText(arguments.getString("placeEd"));
        this.binding.datedec.setText(arguments.getString("dateEdDecleration"));
        this.choiceOfannexureD = arguments.getString("ChoiceOfannexureD");
        this.citizenshipTypeCat = arguments.getString("citizenshipTypeCat");
        arguments.getString("list1Doc");
        arguments.getString("list2Doc");
        arguments.getString("list3Doc");
        arguments.getString("list4Doc");
        arguments.getString("list5Doc");
        arguments.getString("list6Doc");
        arguments.getString("list7Doc");
        arguments.getString("list8Doc");
        this.list1DocUrl = arguments.getString("list1DocUrl");
        this.list2DocUrl = arguments.getString("list2DocUrl");
        this.list3DocUrl = arguments.getString("list3DocUrl");
        this.list4DocUrl = arguments.getString("list4DocUrl");
        this.list5DocUrl = arguments.getString("list5DocUrl");
        this.list6DocUrl = arguments.getString("list6DocUrl");
        this.list17ocUrl = arguments.getString("list7DocUrl");
        this.fathersNationality = arguments.getString("fathersNationality");
        this.mothersNationality = arguments.getString("mothersNationality");
        arguments.getString("moldAcNo");
        arguments.getString("moldPartNo");
        arguments.getString("moldPslNo");
        arguments.getString("foldAcNo");
        arguments.getString("foldPartNo");
        arguments.getString("foldPslNo");
        this.list1CodeName = arguments.getString("list1DocName");
        this.list2codeName = arguments.getString("list2DocName");
        this.list3codeName = arguments.getString("list3DocName");
        this.list4codeName = arguments.getString("list4DocName");
        this.list5codeName = arguments.getString("list5DocName");
        this.list6codeName = arguments.getString("list6DocName");
        this.list7codeName = arguments.getString("list7DocName");
        this.list8codeName = arguments.getString("list8DocName");
        this.doc1filename = arguments.getString("doc1filename");
        this.doc2filename = arguments.getString("doc2filename");
        this.doc3filename = arguments.getString("doc3filename");
        this.doc4filename = arguments.getString("doc4filename");
        this.doc5filename = arguments.getString("doc5filename");
        this.doc6filename = arguments.getString("doc6filename");
        this.doc7filename = arguments.getString("doc7filename");
        this.doc8filename = arguments.getString("doc8filename");
        this.doc9filename = arguments.getString("doc9filename");
        this.flagcat4scenerio1 = arguments.getString("flagcat4scenerio1");
        this.flagcat4scenerio2 = arguments.getString("flagcat4scenerio2");
        this.flagcat3scenerio1 = arguments.getString("flagcat3scenerio1");
        this.flagcat3scenerio2 = arguments.getString("flagcat3scenerio2");
        this.flagcat4scenerio3 = arguments.getString("flagcat4scenerio3");
        this.signatureURL = arguments.getString("signatureURL");
        this.signatureFilename = arguments.getString("signatureFilename");
        this.signatureFileSize = arguments.getString("signatureFileSize");
        boolean z = arguments.getBoolean("isAnnexureenabled");
        this.isAnnexureenabled = z;
        if (z) {
            annexureDView();
            this.binding.decFormPrevFragment.llAnxureDeclaration.setVisibility(8);
        } else {
            this.binding.annexurePrevFragment.llAnxureDeclaration.setVisibility(8);
        }
        this.progencyrelationType = arguments.getString("progencyrelationType");
        this.headerForProgenyorNA = arguments.getString("headerForProgenyorNA");
        this.headerForProgenyRB = arguments.getString("headerForProgenyRB");
        this.headerForSelfRB = arguments.getString("headerForSelfRB");
        FormverificationPayload formverificationPayload = (FormverificationPayload) arguments.getParcelable("declarationForm");
        this.formverificationPayload = formverificationPayload;
        formverificationPayload.setEpicId(0L);
        if (!this.isAnnexureenabled && (Utils.isValideSIRState(this.stateCode) || Utils.isValide19SIRState(this.stateCode))) {
            if (this.formverificationPayload != null) {
                setDeclarationUI();
                this.binding.decFormPrevFragment.llAnxureDeclaration.setVisibility(0);
                this.binding.decFormPrevFragment.rb2003.setEnabled(false);
                this.binding.decFormPrevFragment.rb2025.setEnabled(false);
                if (!TextUtils.isEmpty(this.formverificationPayload.getIs2003Selected()) && this.formverificationPayload.getIs2003Selected().equalsIgnoreCase("Y")) {
                    this.binding.decFormPrevFragment.rb2003.setChecked(true);
                    this.binding.decFormPrevFragment.tabTV.setText(this.headerForProgenyorNA);
                    this.binding.decFormPrevFragment.prevprogenyRb.setText(this.headerForProgenyRB);
                    this.binding.decFormPrevFragment.selfRb.setText(this.headerForSelfRB);
                } else if (!TextUtils.isEmpty(this.formverificationPayload.getIs2003Selected()) && this.formverificationPayload.getIs2003Selected().equalsIgnoreCase("N")) {
                    this.binding.decFormPrevFragment.rb2025.setChecked(true);
                    this.binding.decFormPrevFragment.prevprogenyRb.setText(getString(R.string.ef_progeny_2003_text, new Object[]{"2025/2026"}));
                    this.binding.decFormPrevFragment.tabTV.setText(getString(R.string.elector_tab_title, new Object[]{"2025/2026"}));
                    this.binding.decFormPrevFragment.selfRb.setText(getString(R.string.ef_was_elector_2003_text, new Object[]{"2025/2026"}));
                }
                this.binding.decFormPrevFragment.prevfatherEpicNumber.setText(TextUtils.isEmpty(this.formverificationPayload.getFatherOrGuardianEpicNo()) ? "" : this.formverificationPayload.getFatherOrGuardianEpicNo());
                this.binding.decFormPrevFragment.prevfatherName.setText(TextUtils.isEmpty(this.formverificationPayload.getFatherOrGuardianName()) ? "" : this.formverificationPayload.getFatherOrGuardianName());
                this.binding.decFormPrevFragment.prevmotherEpicNumber.setText(TextUtils.isEmpty(this.formverificationPayload.getMothersEpicNo()) ? "" : this.formverificationPayload.getMothersEpicNo());
                this.binding.decFormPrevFragment.prevmotherName.setText(TextUtils.isEmpty(this.formverificationPayload.getMothersName()) ? "" : this.formverificationPayload.getMothersName());
                this.binding.decFormPrevFragment.prevspouseEpicNumber.setText(TextUtils.isEmpty(this.formverificationPayload.getSpouseEpicNo()) ? "" : this.formverificationPayload.getSpouseEpicNo());
                this.binding.decFormPrevFragment.prevsspouseName.setText(TextUtils.isEmpty(this.formverificationPayload.getSpouseName()) ? "" : this.formverificationPayload.getSpouseName());
                this.binding.decFormPrevFragment.prevtvRlName.setText(TextUtils.isEmpty(this.formverificationPayload.getRlnPrgyName()) ? "" : this.formverificationPayload.getRlnPrgyName());
                this.binding.decFormPrevFragment.prevtvRlEpic.setText(TextUtils.isEmpty(this.formverificationPayload.getRlnPrgyEpic()) ? "" : this.formverificationPayload.getRlnPrgyEpic());
                this.binding.decFormPrevFragment.prevtvRlName1.setText(TextUtils.isEmpty(this.formverificationPayload.getRlnPrgyRlnName()) ? "" : this.formverificationPayload.getRlnPrgyRlnName());
                setRelativeType(this.formverificationPayload.getRlnPrgyRlnType(), this.binding.decFormPrevFragment.prevtvRlRelation);
                this.binding.decFormPrevFragment.prevtvRlState.setText(TextUtils.isEmpty(this.formverificationPayload.getRelationOldStateName()) ? "" : this.formverificationPayload.getRelationOldStateName());
                this.binding.decFormPrevFragment.prevtvRlAcName.setText(TextUtils.isEmpty(this.formverificationPayload.getRelationOldAcName()) ? "" : this.formverificationPayload.getRelationOldAcName());
                this.binding.decFormPrevFragment.prevtvRlAcNo.setText(this.formverificationPayload.getRelationOldAcNo() == 0 ? "" : String.valueOf(this.formverificationPayload.getRelationOldAcNo()));
                this.binding.decFormPrevFragment.prevtvRlPartNo.setText(this.formverificationPayload.getRelationOldPartNo() == 0 ? "" : String.valueOf(this.formverificationPayload.getRelationOldPartNo()));
                this.binding.decFormPrevFragment.prevtvRlSrNo.setText(this.formverificationPayload.getRelationOldPslNo() == 0 ? "" : String.valueOf(this.formverificationPayload.getRelationOldPslNo()));
                this.binding.decFormPrevFragment.neitherRb.setText(R.string.ef_neither_self_nor_progeny_text);
                setRelativeType(this.formverificationPayload.getRelationType(), this.binding.decFormPrevFragment.progenyRelationSpinner);
                if (this.formverificationPayload.getCategoryType() != null && this.formverificationPayload.getCategoryType().equalsIgnoreCase("Progeny")) {
                    this.binding.decFormPrevFragment.prevprogenyRb.setChecked(true);
                    this.binding.decFormPrevFragment.prevprogenyRb.setClickable(false);
                    this.binding.decFormPrevFragment.prevprogenyRb.setTextColor(-16777216);
                    this.binding.decFormPrevFragment.prevrelativeCardView.setVisibility(0);
                    setRelativeType(this.formverificationPayload.getRelationType(), this.binding.decFormPrevFragment.progenyRelationSpinner);
                } else if (this.formverificationPayload.getCategoryType() != null && this.formverificationPayload.getCategoryType().equalsIgnoreCase("self")) {
                    this.binding.decFormPrevFragment.selfRb.setChecked(true);
                    this.binding.decFormPrevFragment.selfCardView.setVisibility(0);
                    if (!TextUtils.isEmpty(this.formverificationPayload.getApplicantEligibleInPrevSir()) && !this.formverificationPayload.getApplicantEligibleInPrevSir().equalsIgnoreCase("Y")) {
                        this.formverificationPayload.getApplicantEligibleInPrevSir().equalsIgnoreCase("N");
                    }
                    if (checkProgenyEmpty()) {
                        this.binding.decFormPrevFragment.prevrelativeCardView.setVisibility(8);
                    } else {
                        this.binding.decFormPrevFragment.prevrelativeCardView.setVisibility(0);
                    }
                    this.binding.decFormPrevFragment.tvEpic.setText(TextUtils.isEmpty(this.formverificationPayload.getSelfOldEpic()) ? "" : this.formverificationPayload.getSelfOldEpic());
                    this.binding.decFormPrevFragment.tvName.setText(TextUtils.isEmpty(this.formverificationPayload.getSelfOldName()) ? "" : this.formverificationPayload.getSelfOldName());
                    this.binding.decFormPrevFragment.tvName1.setText(TextUtils.isEmpty(this.formverificationPayload.getSelfOldRlnName()) ? "" : this.formverificationPayload.getSelfOldRlnName());
                    if (!TextUtils.isEmpty(this.formverificationPayload.getSelfOldRlnType())) {
                        setRelativeType(this.formverificationPayload.getSelfOldRlnType(), this.binding.decFormPrevFragment.tvRelation);
                    }
                    if (!TextUtils.isEmpty(this.formverificationPayload.getOldStateCd()) && this.StateList.size() > 0 && this.StateNameList.size() > 0) {
                        for (int i = 0; i < this.StateList.size(); i++) {
                            if (this.StateList.get(i).equalsIgnoreCase(this.formverificationPayload.getOldStateCd())) {
                                this.binding.decFormPrevFragment.tvState.setText(TextUtils.isEmpty(this.StateNameList.get(i)) ? "" : this.StateNameList.get(i));
                                break;
                            }
                        }
                    }
                    this.binding.decFormPrevFragment.tvAcName.setText(TextUtils.isEmpty(this.formverificationPayload.getOldAcName()) ? "" : this.formverificationPayload.getOldAcName());
                    if (this.formverificationPayload.getOldAcNo() != 0) {
                        this.binding.decFormPrevFragment.tvAcNo.setText(String.valueOf(this.formverificationPayload.getOldAcNo()));
                    }
                    if (this.formverificationPayload.getOldPartNo() != 0) {
                        this.binding.decFormPrevFragment.tvPartNo.setText(String.valueOf(this.formverificationPayload.getOldPartNo()));
                    }
                    if (this.formverificationPayload.getOldPslNo() != 0) {
                        this.binding.decFormPrevFragment.tvSrNo.setText(String.valueOf(this.formverificationPayload.getOldPslNo()));
                    }
                } else {
                    this.binding.decFormPrevFragment.neitherRb.setChecked(true);
                    this.binding.decFormPrevFragment.neitherRb.setClickable(false);
                    this.binding.decFormPrevFragment.neitherRb.setTextColor(-16777216);
                    this.binding.decFormPrevFragment.neitherRb.setText(getString(R.string.ef_neither_self_nor_progeny_text));
                    this.binding.decFormPrevFragment.prevrelativeCardView.setVisibility(8);
                }
                if (!this.formverificationPayload.spouseName.equals("")) {
                    this.binding.decFormPrevFragment.prevsspouseName.setText(this.formverificationPayload.spouseName);
                } else {
                    this.binding.decFormPrevFragment.llSpouseName.setVisibility(8);
                }
                if (!this.formverificationPayload.spouseEpicNo.equals("")) {
                    this.binding.decFormPrevFragment.prevspouseEpicNumber.setText(this.formverificationPayload.spouseEpicNo);
                } else {
                    this.binding.decFormPrevFragment.llSpouseEpicNo.setVisibility(8);
                }
                if (!this.formverificationPayload.fatherOrGuardianEpicNo.equals("")) {
                    this.binding.decFormPrevFragment.prevfatherEpicNumber.setText(this.formverificationPayload.fatherOrGuardianEpicNo);
                } else {
                    this.binding.decFormPrevFragment.llFatherEpicNo.setVisibility(8);
                }
                if (!this.formverificationPayload.fatherOrGuardianName.equals("")) {
                    this.binding.decFormPrevFragment.prevfatherName.setText(this.formverificationPayload.fatherOrGuardianName);
                } else {
                    this.binding.decFormPrevFragment.llFatherEpicName.setVisibility(8);
                }
                if (!this.formverificationPayload.mothersEpicNo.equals("")) {
                    this.binding.decFormPrevFragment.prevmotherEpicNumber.setText(this.formverificationPayload.mothersEpicNo);
                } else {
                    this.binding.decFormPrevFragment.llMotherEpic.setVisibility(8);
                }
                if (!this.formverificationPayload.mothersName.equals("")) {
                    this.binding.decFormPrevFragment.prevmotherName.setText(this.formverificationPayload.mothersName);
                } else {
                    this.binding.decFormPrevFragment.llMotherName.setVisibility(8);
                }
                this.decFormFilename = arguments.getString("decFormFilename");
                Log.d("decFormSignUrl== ", this.formverificationPayload.getDecForm6Url());
                if (this.formverificationPayload.getDecForm6Url() != null) {
                    Log.d("decFormSignUrl== if", this.formverificationPayload.getDecForm6Url());
                    this.binding.decFormPrevFragment.prevBloSignCardView.setVisibility(0);
                    this.binding.decFormPrevFragment.decFormSignHeader.setVisibility(0);
                    this.binding.decFormPrevFragment.decFormSignName.setText(this.decFormFilename);
                    if (this.formverificationPayload.getDecForm6Url() != null || !this.formverificationPayload.getDecForm6Url().equals("") || !this.formverificationPayload.getDecForm6Url().equals("null")) {
                        if (this.formverificationPayload.getDecForm6Url().contains(".jpg") || this.formverificationPayload.getDecForm6Url().contains(this.jpeg) || this.formverificationPayload.getDecForm6Url().contains(".png")) {
                            this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.formverificationPayload.getDecForm6Url(), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda36
                                @Override // in.gov.eci.bloapp.MyCallback
                                public final void onCallback(int i2, String str) {
                                    this.f$0.lambda$onCreateView$16(i2, str);
                                }
                            });
                        } else {
                            this.binding.decFormPrevFragment.decFormSignImage.setImageResource(R.drawable.blo_pfd_thumbnail);
                        }
                    }
                } else {
                    Log.d("decFormSignUrl== else", this.formverificationPayload.getDecForm6Url());
                }
            } else {
                Log.d("formverificationPayload==", "else part");
            }
        }
        if (!TextUtils.isEmpty(arguments.getString("addDocUrl"))) {
            this.binding.lvAddDoc.setVisibility(0);
            this.binding.addDocFilename.setText(arguments.getString("addDocImageName"));
            this.binding.addDocProof.setText(arguments.getString("addDocName"));
            if (arguments.getString("addDocUrl") != null || !arguments.getString("addDocUrl").equals("") || !arguments.getString("addDocUrl").equals("null")) {
                if (this.binding.addDocFilename.getText().toString().contains(".jpg") || this.binding.addDocFilename.getText().toString().contains(this.jpeg) || this.binding.addDocFilename.getText().toString().contains(".png")) {
                    this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), arguments.getString("addDocUrl"), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda37
                        @Override // in.gov.eci.bloapp.MyCallback
                        public final void onCallback(int i2, String str) {
                            this.f$0.lambda$onCreateView$20(arguments, i2, str);
                        }
                    });
                } else {
                    this.binding.addDocImg.setImageResource(R.drawable.blo_pfd_thumbnail);
                }
            }
        } else {
            this.binding.lvAddDoc.setVisibility(8);
        }
        if (!TextUtils.isEmpty(arguments.getString("offlineSignedPage1Url"))) {
            this.binding.addDoc1Filename.setText(arguments.getString("addDoc1ImageName"));
            if (arguments.getString("offlineSignedPage1Url") != null || !arguments.getString("offlineSignedPage1Url").equals("") || !arguments.getString("offlineSignedPage1Url").equals("null")) {
                if (this.binding.addDoc1Filename.getText().toString().contains(".jpg") || this.binding.addDoc1Filename.getText().toString().contains(this.jpeg) || this.binding.addDoc1Filename.getText().toString().contains(".png")) {
                    this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), arguments.getString("offlineSignedPage1Url"), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda38
                        @Override // in.gov.eci.bloapp.MyCallback
                        public final void onCallback(int i2, String str) {
                            this.f$0.lambda$onCreateView$24(arguments, i2, str);
                        }
                    });
                } else {
                    this.binding.addDoc1Img.setImageResource(R.drawable.blo_pfd_thumbnail);
                }
            }
        }
        if (!TextUtils.isEmpty(arguments.getString("offlineSignedPage2Url"))) {
            this.binding.addDoc2Filename.setText(arguments.getString("addDoc2ImageName"));
            if (arguments.getString("offlineSignedPage2Url") != null || !arguments.getString("offlineSignedPage2Url").equals("") || !arguments.getString("offlineSignedPage2Url").equals("null")) {
                if (this.binding.addDoc2Filename.getText().toString().contains(".jpg") || this.binding.addDoc2Filename.getText().toString().contains(this.jpeg) || this.binding.addDoc2Filename.getText().toString().contains(".png")) {
                    this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), arguments.getString("offlineSignedPage2Url"), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda39
                        @Override // in.gov.eci.bloapp.MyCallback
                        public final void onCallback(int i2, String str) {
                            this.f$0.lambda$onCreateView$28(arguments, i2, str);
                        }
                    });
                } else {
                    this.binding.addDoc2Img.setImageResource(R.drawable.blo_pfd_thumbnail);
                }
            }
        }
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(final Bundle bundle, int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda42
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$onCreateView$2(bundle, i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.imagepreview.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(Bundle bundle, int i, String str, String str2) {
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda0
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
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), bundle.getString(this.byteArray), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda11
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
        this.binding.imagepreview.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$7(final Bundle bundle, int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda30
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$onCreateView$6(bundle, i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.ageimg.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$6(Bundle bundle, int i, String str, String str2) {
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda46
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onCreateView$4(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), bundle.getString(this.byteArray), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda47
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$onCreateView$5(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$4(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$5(int i, String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.ageimg.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$11(final Bundle bundle, int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda6
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$onCreateView$10(bundle, i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.addimg.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$10(Bundle bundle, int i, String str, String str2) {
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda65
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onCreateView$8(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), bundle.getString(this.byteArray), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda67
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$onCreateView$9(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$8(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$9(int i, String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.addimg.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$15(final Bundle bundle, int i, final String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda73
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$onCreateView$14(bundle, str, i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.disimg.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$14(Bundle bundle, final String str, int i, String str2, String str3) {
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda55
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onCreateView$12(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str2;
        this.refreshToken = str3;
        SharedPref.getInstance(requireContext()).setRefreshToken(str3);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str2);
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), bundle.getString(this.byteArray), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda66
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str4) {
                this.f$0.lambda$onCreateView$13(str, i2, str4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$12(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$13(String str, int i, String str2) {
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.disimg.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$16(int i, String str) {
        this.binding.decFormPrevFragment.decFormSignName.setVisibility(0);
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.decFormPrevFragment.decFormSignImage.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$20(final Bundle bundle, int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda50
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$onCreateView$19(bundle, i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.addDocImg.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$19(Bundle bundle, int i, String str, String str2) {
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda22
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onCreateView$17(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), bundle.getString("addDocUrl"), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda33
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$onCreateView$18(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$17(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$18(int i, String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.addDocImg.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$24(final Bundle bundle, int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda74
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$onCreateView$23(bundle, i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.addDoc1Img.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$23(Bundle bundle, int i, String str, String str2) {
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda7
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onCreateView$21(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), bundle.getString("offlineSignedPage1Url"), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda8
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$onCreateView$22(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$21(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$22(int i, String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.addDoc1Img.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$28(final Bundle bundle, int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda71
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$onCreateView$27(bundle, i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.addDoc2Img.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$27(Bundle bundle, int i, String str, String str2) {
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda62
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onCreateView$25(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), bundle.getString("offlineSignedPage2Url"), new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda63
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$onCreateView$26(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$25(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$26(int i, String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.addDoc2Img.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    private void annexureDView() {
        if (this.choiceOfannexureD.equalsIgnoreCase(getString(R.string.born_india))) {
            this.binding.annexurePrevFragment.formAnnxBornIndia.setChecked(true);
            String str = this.list1CodeName;
            if (str != null || !str.equalsIgnoreCase("")) {
                this.binding.annexurePrevFragment.citiCatDocSpinner.setText(this.list1CodeName);
            } else {
                this.binding.annexurePrevFragment.citiCatDocSpinner.setText("NA");
            }
            if (this.citizenshipTypeCat.equalsIgnoreCase("CAT-2")) {
                this.binding.annexurePrevFragment.bloHeader.setText("Born India(before  01.07.1987)");
                this.binding.annexurePrevFragment.selectBothParentLayout.setVisibility(8);
                this.binding.annexurePrevFragment.selectParentLayout.setVisibility(8);
                this.binding.annexurePrevFragment.annexIndianCommonBody.setVisibility(8);
                this.binding.annexurePrevFragment.annexNonIndianCommonBody.setVisibility(8);
                this.binding.annexurePrevFragment.selectParentLayoutBetween.setVisibility(8);
                this.binding.annexurePrevFragment.forIndianParentLayoutBetween.setVisibility(8);
                String str2 = this.doc1filename;
                if (str2 != null || !str2.equalsIgnoreCase("")) {
                    this.binding.annexurePrevFragment.citizenshipCatfilename.setText(this.doc1filename);
                } else {
                    this.binding.annexurePrevFragment.citizenshipCatfilename.setVisibility(8);
                }
            } else if (this.citizenshipTypeCat.equalsIgnoreCase("CAT-3")) {
                this.binding.annexurePrevFragment.bloHeader.setText("Born India(between 01.07.1987 and 02.12.2004)");
                this.binding.annexurePrevFragment.selectBothParentLayout.setVisibility(8);
                this.binding.annexurePrevFragment.selectParentLayout.setVisibility(8);
                this.binding.annexurePrevFragment.annexIndianCommonBody.setVisibility(8);
                this.binding.annexurePrevFragment.annexNonIndianCommonBody.setVisibility(8);
                this.binding.annexurePrevFragment.selectParentLayoutBetween.setVisibility(0);
                this.binding.annexurePrevFragment.forIndianParentLayoutBetween.setVisibility(0);
                String str3 = this.doc2filename;
                if (str3 != null || !str3.equalsIgnoreCase("")) {
                    this.binding.annexurePrevFragment.citizenshipCatfilename.setText(this.doc2filename);
                } else {
                    this.binding.annexurePrevFragment.citizenshipCatfilename.setVisibility(8);
                }
            } else if (this.citizenshipTypeCat.equalsIgnoreCase("CAT-4")) {
                this.binding.annexurePrevFragment.bloHeader.setText("Born India (after 02.12.2004)");
                this.binding.annexurePrevFragment.selectBothParentLayout.setVisibility(0);
                this.binding.annexurePrevFragment.selectParentLayout.setVisibility(0);
                this.binding.annexurePrevFragment.annexIndianCommonBody.setVisibility(0);
                this.binding.annexurePrevFragment.annexNonIndianCommonBody.setVisibility(0);
                this.binding.annexurePrevFragment.selectParentLayoutBetween.setVisibility(8);
                this.binding.annexurePrevFragment.forIndianParentLayoutBetween.setVisibility(8);
                String str4 = this.doc4filename;
                if (str4 != null || !str4.equalsIgnoreCase("")) {
                    this.binding.annexurePrevFragment.citizenshipCatfilename.setText(this.doc4filename);
                } else {
                    this.binding.annexurePrevFragment.citizenshipCatfilename.setVisibility(8);
                }
            }
            String str5 = this.list1DocUrl;
            if (str5 != null || !str5.equals("") || !this.list1DocUrl.equals("null")) {
                if (this.list1DocUrl.contains(".jpg") || this.list1DocUrl.contains(this.jpeg) || this.list1DocUrl.contains(".png")) {
                    this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list1DocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda13
                        @Override // in.gov.eci.bloapp.MyCallback
                        public final void onCallback(int i, String str6) {
                            this.f$0.lambda$annexureDView$32(i, str6);
                        }
                    });
                } else {
                    this.binding.annexurePrevFragment.addimg1.setImageResource(R.drawable.blo_pfd_thumbnail);
                }
            } else {
                this.binding.annexurePrevFragment.addimg1.setVisibility(8);
            }
            if (this.flagcat4scenerio1.equalsIgnoreCase("Y")) {
                this.binding.annexurePrevFragment.parentYesRb.setChecked(true);
                this.binding.annexurePrevFragment.indianParentTv2.setText("Father:");
                this.binding.annexurePrevFragment.indianFatherSpinner.setText(this.list3codeName);
                this.binding.annexurePrevFragment.addfilename2.setText(this.doc5filename);
                String str6 = this.list3DocUrl;
                if (str6 != null || !str6.equals("") || !this.list3DocUrl.equals("null")) {
                    if (this.list3DocUrl.contains(".jpg") || this.list3DocUrl.contains(this.jpeg) || this.list3DocUrl.contains(".png")) {
                        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list3DocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda16
                            @Override // in.gov.eci.bloapp.MyCallback
                            public final void onCallback(int i, String str7) {
                                this.f$0.lambda$annexureDView$36(i, str7);
                            }
                        });
                    } else {
                        this.binding.annexurePrevFragment.addimg2.setImageResource(R.drawable.blo_pfd_thumbnail);
                    }
                }
                this.binding.annexurePrevFragment.indianParentTvMother.setText("Mother:");
                this.binding.annexurePrevFragment.indianMotherSpinner.setText(this.list4codeName);
                this.binding.annexurePrevFragment.addfilenameMother.setText(this.doc5filename);
                String str7 = this.list4DocUrl;
                if (str7 != null || !str7.equals("") || !this.list4DocUrl.equals("null")) {
                    if (this.list4DocUrl.contains(".jpg") || this.list4DocUrl.contains(this.jpeg) || this.list4DocUrl.contains(".png")) {
                        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list4DocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda17
                            @Override // in.gov.eci.bloapp.MyCallback
                            public final void onCallback(int i, String str8) {
                                this.f$0.lambda$annexureDView$40(i, str8);
                            }
                        });
                    } else {
                        this.binding.annexurePrevFragment.addimgMotherIndian.setImageResource(R.drawable.blo_pfd_thumbnail);
                    }
                }
                this.binding.annexurePrevFragment.selectParentLayout.setVisibility(8);
                this.binding.annexurePrevFragment.annexNonIndianCommonBody.setVisibility(8);
            } else {
                this.binding.annexurePrevFragment.parentNoRb.setChecked(true);
                if (this.mothersNationality.equalsIgnoreCase("Non-Indian")) {
                    this.binding.annexurePrevFragment.forIndianParentMotherLayout.setVisibility(8);
                    this.binding.annexurePrevFragment.forIndianParentMotherLayout1.setVisibility(8);
                    this.binding.annexurePrevFragment.parentFatherRb.setChecked(true);
                    this.binding.annexurePrevFragment.parentMotherRb.setChecked(false);
                    this.binding.annexurePrevFragment.indianParentTv2.setText("Father:");
                    this.binding.annexurePrevFragment.indianFatherSpinner.setText(this.list3codeName);
                    this.binding.annexurePrevFragment.addfilename2.setText(this.doc5filename);
                    String str8 = this.list3DocUrl;
                    if (str8 != null || !str8.equals("") || !this.list3DocUrl.equals("null")) {
                        if (this.list3DocUrl.contains(".jpg") || this.list3DocUrl.contains(this.jpeg) || this.list3DocUrl.contains(".png")) {
                            this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list3DocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda18
                                @Override // in.gov.eci.bloapp.MyCallback
                                public final void onCallback(int i, String str9) {
                                    this.f$0.lambda$annexureDView$44(i, str9);
                                }
                            });
                        } else {
                            this.binding.annexurePrevFragment.addimg2.setImageResource(R.drawable.blo_pfd_thumbnail);
                        }
                    }
                    this.binding.annexurePrevFragment.nonIndianParentTv2.setText("Mother:");
                    this.binding.annexurePrevFragment.districtadd3.setText(this.list5codeName);
                    this.binding.annexurePrevFragment.addfilename3.setText(this.doc7filename);
                    String str9 = this.list5DocUrl;
                    if (str9 != null || !str9.equals("") || !this.list5DocUrl.equals("null")) {
                        if (this.list5DocUrl.contains(".jpg") || this.list5DocUrl.contains(this.jpeg) || this.list5DocUrl.contains(".png")) {
                            this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list5DocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda19
                                @Override // in.gov.eci.bloapp.MyCallback
                                public final void onCallback(int i, String str10) {
                                    this.f$0.lambda$annexureDView$48(i, str10);
                                }
                            });
                        } else {
                            this.binding.annexurePrevFragment.addimg3.setImageResource(R.drawable.blo_pfd_thumbnail);
                        }
                    }
                } else if (this.fathersNationality.equalsIgnoreCase("Non-Indian")) {
                    this.binding.annexurePrevFragment.forIndianParentLayout.setVisibility(8);
                    this.binding.annexurePrevFragment.forIndianParentLayoutFather.setVisibility(8);
                    this.binding.annexurePrevFragment.parentFatherRb.setChecked(false);
                    this.binding.annexurePrevFragment.parentMotherRb.setChecked(true);
                    this.binding.annexurePrevFragment.indianParentTvMother.setText("Mother:");
                    this.binding.annexurePrevFragment.indianMotherSpinner.setText(this.list4codeName);
                    String str10 = this.doc5filename;
                    if (str10 != null && !str10.equalsIgnoreCase("")) {
                        this.binding.annexurePrevFragment.addfilenameMother.setText(this.doc5filename);
                    } else {
                        this.binding.annexurePrevFragment.addfilenameMother.setText(this.doc6filename);
                    }
                    String str11 = this.list4DocUrl;
                    if (str11 != null || !str11.equals("") || !this.list4DocUrl.equals("null")) {
                        if (this.list4DocUrl.contains(".jpg") || this.list4DocUrl.contains(this.jpeg) || this.list4DocUrl.contains(".png")) {
                            this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list4DocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda20
                                @Override // in.gov.eci.bloapp.MyCallback
                                public final void onCallback(int i, String str12) {
                                    this.f$0.lambda$annexureDView$52(i, str12);
                                }
                            });
                        } else {
                            this.binding.annexurePrevFragment.addimgMotherIndian.setImageResource(R.drawable.blo_pfd_thumbnail);
                        }
                    }
                    this.binding.annexurePrevFragment.nonIndianParentTv2.setText("Father:");
                    this.binding.annexurePrevFragment.districtadd3.setText(this.list5codeName);
                    this.binding.annexurePrevFragment.addfilename3.setText(this.doc7filename);
                    String str12 = this.list5DocUrl;
                    if (str12 != null || !str12.equals("") || !this.list5DocUrl.equals("null")) {
                        if (this.list5DocUrl.contains(".jpg") || this.list5DocUrl.contains(this.jpeg) || this.list5DocUrl.contains(".png")) {
                            this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list5DocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda21
                                @Override // in.gov.eci.bloapp.MyCallback
                                public final void onCallback(int i, String str13) {
                                    this.f$0.lambda$annexureDView$56(i, str13);
                                }
                            });
                        } else {
                            this.binding.annexurePrevFragment.addimg3.setImageResource(R.drawable.blo_pfd_thumbnail);
                        }
                    }
                }
            }
            if (this.flagcat3scenerio1.equalsIgnoreCase("Y")) {
                this.binding.annexurePrevFragment.parentFatherRbBetween.setChecked(true);
                this.binding.annexurePrevFragment.parentMotherRbBetween.setChecked(false);
                this.binding.annexurePrevFragment.parentSpinnerBetween.setText(this.list3codeName);
                this.binding.annexurePrevFragment.betweenfilename.setText(this.doc3filename);
                String str13 = this.list3DocUrl;
                if (str13 != null || !str13.equals("") || !this.list3DocUrl.equals("null")) {
                    if (this.list3DocUrl.contains(".jpg") || this.list3DocUrl.contains(this.jpeg) || this.list3DocUrl.contains(".png")) {
                        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list3DocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda23
                            @Override // in.gov.eci.bloapp.MyCallback
                            public final void onCallback(int i, String str14) {
                                this.f$0.lambda$annexureDView$60(i, str14);
                            }
                        });
                    } else {
                        this.binding.annexurePrevFragment.betweenimage.setImageResource(R.drawable.blo_pfd_thumbnail);
                    }
                }
            }
            if (this.flagcat3scenerio2.equalsIgnoreCase("Y")) {
                this.binding.annexurePrevFragment.parentFatherRbBetween.setChecked(false);
                this.binding.annexurePrevFragment.parentMotherRbBetween.setChecked(true);
                this.binding.annexurePrevFragment.parentSpinnerBetween.setText(this.list4codeName);
                this.binding.annexurePrevFragment.betweenfilename.setText(this.doc3filename);
                String str14 = this.list4DocUrl;
                if (str14 != null || !str14.equals("") || !this.list4DocUrl.equals("null")) {
                    if (this.list4DocUrl.contains(".jpg") || this.list4DocUrl.contains(this.jpeg) || this.list4DocUrl.contains(".png")) {
                        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list4DocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda24
                            @Override // in.gov.eci.bloapp.MyCallback
                            public final void onCallback(int i, String str15) {
                                this.f$0.lambda$annexureDView$64(i, str15);
                            }
                        });
                    } else {
                        this.binding.annexurePrevFragment.betweenimage.setImageResource(R.drawable.blo_pfd_thumbnail);
                    }
                }
            }
        } else if (this.choiceOfannexureD.equalsIgnoreCase(getString(R.string.not_born))) {
            this.binding.annexurePrevFragment.selectBothParentLayout.setVisibility(8);
            this.binding.annexurePrevFragment.selectParentLayout.setVisibility(8);
            this.binding.annexurePrevFragment.annexIndianCommonBody.setVisibility(8);
            this.binding.annexurePrevFragment.annexNonIndianCommonBody.setVisibility(8);
            this.binding.annexurePrevFragment.selectParentLayoutBetween.setVisibility(8);
            this.binding.annexurePrevFragment.forIndianParentLayoutBetween.setVisibility(8);
            this.binding.annexurePrevFragment.formAnnxNotBorn.setChecked(true);
            this.binding.annexurePrevFragment.citiCatDocSpinner.setText(this.list6codeName);
            this.binding.annexurePrevFragment.citizenshipCatfilename.setText(this.doc8filename);
            if (this.citizenshipTypeCat.equalsIgnoreCase("CAT-5")) {
                this.binding.annexurePrevFragment.bloHeader.setText("Not Born In India");
            }
            String str15 = this.list6DocUrl;
            if (str15 != null || !str15.equals("") || !this.list6DocUrl.equals("null")) {
                if (this.list6DocUrl.contains(".jpg") || this.list6DocUrl.contains(this.jpeg) || this.list6DocUrl.contains(".png")) {
                    this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list6DocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda25
                        @Override // in.gov.eci.bloapp.MyCallback
                        public final void onCallback(int i, String str16) {
                            this.f$0.lambda$annexureDView$68(i, str16);
                        }
                    });
                } else {
                    this.binding.annexurePrevFragment.addimg1.setImageResource(R.drawable.blo_pfd_thumbnail);
                }
            }
        } else if (this.choiceOfannexureD.equalsIgnoreCase(getString(R.string.registration_naturalization))) {
            this.binding.annexurePrevFragment.selectBothParentLayout.setVisibility(8);
            this.binding.annexurePrevFragment.selectParentLayout.setVisibility(8);
            this.binding.annexurePrevFragment.annexIndianCommonBody.setVisibility(8);
            this.binding.annexurePrevFragment.annexNonIndianCommonBody.setVisibility(8);
            this.binding.annexurePrevFragment.selectParentLayoutBetween.setVisibility(8);
            this.binding.annexurePrevFragment.forIndianParentLayoutBetween.setVisibility(8);
            this.binding.annexurePrevFragment.formAnnxIndiaCitize.setChecked(true);
            this.binding.annexurePrevFragment.citiCatDocSpinner.setText(this.list7codeName);
            this.binding.annexurePrevFragment.citizenshipCatfilename.setText(this.doc8filename);
            if (this.citizenshipTypeCat.equalsIgnoreCase("CAT-6")) {
                this.binding.annexurePrevFragment.bloHeader.setText("Indian citizenship by Registration/Naturalisation");
            }
            String str16 = this.list17ocUrl;
            if (str16 != null || !str16.equals("") || !this.list17ocUrl.equals("null")) {
                if (this.list17ocUrl.contains(".jpg") || this.list17ocUrl.contains(this.jpeg) || this.list17ocUrl.contains(".png")) {
                    this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list17ocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda14
                        @Override // in.gov.eci.bloapp.MyCallback
                        public final void onCallback(int i, String str17) {
                            this.f$0.lambda$annexureDView$72(i, str17);
                        }
                    });
                } else {
                    this.binding.annexurePrevFragment.addimg1.setImageResource(R.drawable.blo_pfd_thumbnail);
                }
            }
        }
        if (this.signatureURL != null) {
            this.binding.annexurePrevFragment.annexSignHeader.setVisibility(0);
            this.binding.annexurePrevFragment.signName.setText(this.signatureFilename);
            String str17 = this.signatureURL;
            if (str17 == null && str17.equals("") && this.signatureURL.equals("null")) {
                return;
            }
            if (this.signatureURL.contains(".jpg") || this.signatureURL.contains(this.jpeg) || this.signatureURL.contains(".png")) {
                this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.signatureURL, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda15
                    @Override // in.gov.eci.bloapp.MyCallback
                    public final void onCallback(int i, String str18) {
                        this.f$0.lambda$annexureDView$76(i, str18);
                    }
                });
            } else {
                this.binding.annexurePrevFragment.signImage.setImageResource(R.drawable.blo_pfd_thumbnail);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$32(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda72
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$annexureDView$31(i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.annexurePrevFragment.addimg1.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$31(int i, String str, String str2) {
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda59
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$annexureDView$29(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list1DocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda60
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$annexureDView$30(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$29(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$30(int i, String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.annexurePrevFragment.addimg1.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$36(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda54
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$annexureDView$35(i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.annexurePrevFragment.addimg2.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$35(int i, String str, String str2) {
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$annexureDView$33(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list3DocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda2
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$annexureDView$34(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$33(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$34(int i, String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.annexurePrevFragment.addimg2.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$40(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda51
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$annexureDView$39(i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.annexurePrevFragment.addimgMotherIndian.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$39(int i, String str, String str2) {
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda40
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$annexureDView$37(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list4DocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda41
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$annexureDView$38(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$37(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$38(int i, String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.annexurePrevFragment.addimgMotherIndian.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$44(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda68
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$annexureDView$43(i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.annexurePrevFragment.addimg2.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$43(int i, String str, String str2) {
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$annexureDView$41(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list3DocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda4
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$annexureDView$42(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$41(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$42(int i, String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.annexurePrevFragment.addimg2.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$48(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda56
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$annexureDView$47(i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.annexurePrevFragment.addimg3.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$47(int i, String str, String str2) {
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda69
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$annexureDView$45(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list5DocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda70
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$annexureDView$46(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$45(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$46(int i, String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.annexurePrevFragment.addimg3.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$52(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda61
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$annexureDView$51(i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.annexurePrevFragment.addimgMotherIndian.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$51(int i, String str, String str2) {
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda10
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$annexureDView$49(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list4DocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda12
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$annexureDView$50(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$49(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$50(int i, String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.annexurePrevFragment.addimgMotherIndian.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$56(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda49
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$annexureDView$55(i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.annexurePrevFragment.addimg3.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$55(int i, String str, String str2) {
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda52
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$annexureDView$53(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list5DocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda53
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$annexureDView$54(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$53(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$54(int i, String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.annexurePrevFragment.addimg3.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$60(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda48
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$annexureDView$59(i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.annexurePrevFragment.betweenimage.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$59(int i, String str, String str2) {
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda28
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$annexureDView$57(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list3DocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda29
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$annexureDView$58(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$57(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$58(int i, String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.annexurePrevFragment.betweenimage.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$64(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda64
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$annexureDView$63(i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.annexurePrevFragment.betweenimage.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$63(int i, String str, String str2) {
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda26
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$annexureDView$61(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list4DocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda27
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$annexureDView$62(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$61(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$62(int i, String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.annexurePrevFragment.betweenimage.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$68(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda5
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$annexureDView$67(i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.annexurePrevFragment.addimg1.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$67(int i, String str, String str2) {
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda57
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$annexureDView$65(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list6DocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda58
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$annexureDView$66(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$65(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$66(int i, String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.annexurePrevFragment.addimg1.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$72(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda9
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$annexureDView$71(i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.annexurePrevFragment.addimg1.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$71(int i, String str, String str2) {
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda43
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$annexureDView$69(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list17ocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda45
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$annexureDView$70(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$69(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$70(int i, String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.annexurePrevFragment.addimg1.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$76(int i, String str) {
        if (i == 401) {
            this.commonUtilClass.getRefreshToken(requireContext(), this.refreshToken, new aadharcallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda44
                @Override // in.gov.eci.bloapp.aadharcallback
                public final void onCallBack(int i2, String str2, String str3) {
                    this.f$0.lambda$annexureDView$75(i2, str2, str3);
                }
            });
        } else {
            byte[] bArrDecode = Base64.decode(str, 0);
            this.binding.annexurePrevFragment.signImage.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$75(int i, String str, String str2) {
        System.out.println("zxnbchdbvfhvb " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2);
        if (i == 401 || i == 400) {
            this.commonUtilClass.showMessageOK(getContext(), "Session Expired. Please Login again.", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda75
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$annexureDView$73(dialogInterface, i2);
                }
            });
            return;
        }
        this.token = "Bearer " + str;
        this.refreshToken = str2;
        SharedPref.getInstance(requireContext()).setRefreshToken(str2);
        SharedPref.getInstance(requireContext()).setToken("Bearer " + str);
        this.commonUtilClass.getuploadedfile(getContext(), this.token, SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), this.list17ocUrl, new MyCallback() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.Form$$ExternalSyntheticLambda76
            @Override // in.gov.eci.bloapp.MyCallback
            public final void onCallback(int i2, String str3) {
                this.f$0.lambda$annexureDView$74(i2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$73(DialogInterface dialogInterface, int i) {
        SharedPref.getInstance(requireContext()).setIsLoggedIn(false);
        SharedPref.getInstance(requireContext()).setLocaleBool(false);
        startActivity(new Intent((Context) getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$annexureDView$74(int i, String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        this.binding.annexurePrevFragment.addimg1.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    public void setRelativeType(String relativeType, TextView textView) {
        if (TextUtils.isEmpty(relativeType)) {
            return;
        }
        if (relativeType.equals("GMTH")) {
            textView.setText("Grand Mother");
        } else if (relativeType.equals("GFTH")) {
            textView.setText("Grand Father");
        } else if (relativeType.equals("MTHR") || relativeType.equalsIgnoreCase("Mother") || relativeType.equalsIgnoreCase("M")) {
            textView.setText("Mother");
        } else if (relativeType.equals("FTHR") || relativeType.equals("F") || relativeType.equalsIgnoreCase("Father")) {
            textView.setText("Father");
        } else if (relativeType.equals("HSBN") || relativeType.equals("H") || relativeType.equalsIgnoreCase("Husband")) {
            textView.setText("Husband");
        } else if (relativeType.equals("OTHR") || relativeType.equalsIgnoreCase("O") || relativeType.equalsIgnoreCase("Other")) {
            textView.setText("Other");
        } else if (TextUtils.isEmpty(relativeType)) {
            textView.setText("");
        } else {
            textView.setText(relativeType);
        }
        this.progencyrelationType = textView.getText().toString();
    }

    private boolean checkProgenyEmpty() {
        return this.formverificationPayload.getRelationOldAcNo() == 0 && this.formverificationPayload.getRelationOldPartNo() == 0 && this.formverificationPayload.getRelationOldPslNo() == 0 && TextUtils.isEmpty(this.formverificationPayload.getRelationOldStateCd()) && TextUtils.isEmpty(this.formverificationPayload.getRlnPrgyEpic()) && TextUtils.isEmpty(this.formverificationPayload.getRlnPrgyName()) && TextUtils.isEmpty(this.formverificationPayload.getRlnPrgyRlnName()) && TextUtils.isEmpty(this.formverificationPayload.getRlnPrgyRlnType());
    }

    public void setDeclarationUI() {
        if (Utils.isValideSIRState(this.stateCode)) {
            this.binding.decFormPrevFragment.llAnxureDeclaration.removeView(this.binding.decFormPrevFragment.radiochooseCardView);
            this.binding.decFormPrevFragment.llAnxureDeclaration.removeView(this.binding.decFormPrevFragment.lvCategoryRadio);
            this.binding.decFormPrevFragment.llAnxureDeclaration.removeView(this.binding.decFormPrevFragment.decformCommonHeader);
            this.binding.decFormPrevFragment.llAnxureDeclaration.removeView(this.binding.decFormPrevFragment.selfCardView);
            this.binding.decFormPrevFragment.llAnxureDeclaration.removeView(this.binding.decFormPrevFragment.prevrelativeCardView);
            this.binding.decFormPrevFragment.llAnxureDeclaration.removeView(this.binding.decFormPrevFragment.prevBloSignCardView);
            this.binding.decFormPrevFragment.llAnxureDeclaration.addView(this.binding.decFormPrevFragment.decformCommonHeader);
            this.binding.decFormPrevFragment.llAnxureDeclaration.addView(this.binding.decFormPrevFragment.radiochooseCardView);
            this.binding.decFormPrevFragment.llAnxureDeclaration.addView(this.binding.decFormPrevFragment.lvCategoryRadio);
            this.binding.decFormPrevFragment.llAnxureDeclaration.addView(this.binding.decFormPrevFragment.selfCardView);
            this.binding.decFormPrevFragment.llAnxureDeclaration.addView(this.binding.decFormPrevFragment.prevrelativeCardView);
            this.binding.decFormPrevFragment.llAnxureDeclaration.addView(this.binding.decFormPrevFragment.prevBloSignCardView);
            return;
        }
        if (Utils.isValide19SIRState(this.stateCode)) {
            this.binding.decFormPrevFragment.llAnxureDeclaration.removeView(this.binding.decFormPrevFragment.radiochooseCardView);
            this.binding.decFormPrevFragment.llAnxureDeclaration.removeView(this.binding.decFormPrevFragment.lvCategoryRadio);
            this.binding.decFormPrevFragment.llAnxureDeclaration.removeView(this.binding.decFormPrevFragment.decformCommonHeader);
            this.binding.decFormPrevFragment.llAnxureDeclaration.removeView(this.binding.decFormPrevFragment.selfCardView);
            this.binding.decFormPrevFragment.llAnxureDeclaration.removeView(this.binding.decFormPrevFragment.prevrelativeCardView);
            this.binding.decFormPrevFragment.llAnxureDeclaration.removeView(this.binding.decFormPrevFragment.prevBloSignCardView);
            this.binding.decFormPrevFragment.llAnxureDeclaration.addView(this.binding.decFormPrevFragment.radiochooseCardView);
            this.binding.decFormPrevFragment.llAnxureDeclaration.addView(this.binding.decFormPrevFragment.lvCategoryRadio);
            this.binding.decFormPrevFragment.llAnxureDeclaration.addView(this.binding.decFormPrevFragment.selfCardView);
            this.binding.decFormPrevFragment.llAnxureDeclaration.addView(this.binding.decFormPrevFragment.prevrelativeCardView);
            this.binding.decFormPrevFragment.llAnxureDeclaration.addView(this.binding.decFormPrevFragment.decformCommonHeader);
            this.binding.decFormPrevFragment.llAnxureDeclaration.addView(this.binding.decFormPrevFragment.prevBloSignCardView);
        }
    }
}
