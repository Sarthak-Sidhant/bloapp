package in.gov.eci.bloapp.views.fragments.login;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import in.gov.eci.bloapp.databinding.BloFragmentLanguageSelectionBinding;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.utils.Utils;
import in.gov.eci.bloapp.views.activity.MainActivity;
import java.util.ArrayList;
import java.util.Objects;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FragmentLanguageSelection extends Hilt_FragmentLanguageSelection {
    private static final String TAG = "BloFragmentLanguageSelectionBinding";
    ArrayAdapter<String> adapter;
    String asmblyNO;
    private BloFragmentLanguageSelectionBinding binding;
    String langName;
    String langName2;
    String partLang;
    String partLang2;
    String partNo;
    int position;
    String stateCode;
    String token;
    String totalPartNumber;

    @Inject
    Utils utils;
    ArrayList<String> listOfValues = new ArrayList<>();
    ArrayList<String> partLanglist = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentLanguageSelectionBinding.inflate(getLayoutInflater());
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentLanguageSelection.1
            public void handleOnBackPressed() {
                FragmentLanguageSelection.this.openFragment(new FragmentPartNumberSelection());
            }
        });
        this.token = SharedPref.getInstance(requireContext()).getToken();
        this.partLang = SharedPref.getInstance(requireContext()).getPartNumberLanguageName();
        this.langName = SharedPref.getInstance(requireContext()).getLanguageName();
        this.stateCode = SharedPref.getInstance(requireContext()).getStateCode();
        this.asmblyNO = SharedPref.getInstance(requireContext()).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(requireContext()).getPartNumber();
        this.totalPartNumber = SharedPref.getInstance(requireContext()).getTotalPartNumber();
        this.partLang2 = SharedPref.getInstance(requireContext()).getPartNumberLanguageName2();
        this.langName2 = SharedPref.getInstance(requireContext()).getLanguageName2();
        Log.d(TAG, "partLang ---> " + this.partLang + "\nlangName ---> " + this.langName + "\npartLang2 ---> " + this.partLang2 + "\nlangName2 ---> " + this.langName2);
        ArrayList<String> arrayList = new ArrayList<>();
        this.listOfValues = arrayList;
        arrayList.add(this.langName);
        Log.d(TAG, "langName " + this.langName2);
        if (this.langName2.length() != 0) {
            this.listOfValues.add(this.langName2);
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.partLanglist = arrayList2;
        arrayList2.add(this.partLang);
        if (this.partLang2.length() != 0) {
            this.partLanglist.add(this.partLang2);
        }
        initCLickListener();
        this.binding.radioparent.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentLanguageSelection$$ExternalSyntheticLambda1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                this.f$0.lambda$onCreateView$0(radioGroup, i);
            }
        });
        this.adapter = new ArrayAdapter<>((Context) Objects.requireNonNull(getContext()), R.layout.simple_list_item_1, this.listOfValues);
        this.binding.singleSelect.setAdapter(this.adapter);
        this.binding.singleSelect.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentLanguageSelection$$ExternalSyntheticLambda2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                this.f$0.lambda$onCreateView$1(adapterView, view, i, j);
            }
        });
        this.binding.backBtnV.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentLanguageSelection$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$2(view);
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(RadioGroup radioGroup, int i) {
        int checkedRadioButtonId = this.binding.radioparent.getCheckedRadioButtonId();
        if (checkedRadioButtonId == 2131363638) {
            this.binding.education.setChecked(false);
        } else if (checkedRadioButtonId == 2131363529) {
            this.binding.employment.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(AdapterView adapterView, View view, int i, long j) {
        this.position = i;
        this.binding.education.setChecked(true);
        this.binding.employment.setChecked(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(View view) {
        openFragment(new FragmentPartNumberSelection());
    }

    private void initCLickListener() {
        this.binding.submit.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentLanguageSelection$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initCLickListener$4(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCLickListener$4(View view) {
        if (this.binding.singleSelect.getText().toString().isEmpty() && this.binding.education.isChecked()) {
            this.utils.showMessageOK(requireContext(), "Missing", "Select Language", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.login.FragmentLanguageSelection$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            return;
        }
        if (this.binding.employment.isChecked()) {
            SharedPref.getInstance(requireContext()).setChangeLanguage("en_in");
            SharedPref.getInstance(requireContext()).setLocaleBool(false);
        } else {
            SharedPref.getInstance(requireContext()).setChangeLanguage(this.partLanglist.get(this.position));
            SharedPref.getInstance(requireContext()).setLocaleBool(false);
        }
        Log.d(TAG, "language code " + SharedPref.getInstance(requireContext()).getChangeLanguage());
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
        getActivity().finish();
    }
}
