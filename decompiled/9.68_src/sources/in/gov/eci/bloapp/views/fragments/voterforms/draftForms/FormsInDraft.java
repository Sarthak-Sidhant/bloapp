package in.gov.eci.bloapp.views.fragments.voterforms.draftForms;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.databinding.BloFragmentFormsInDraftBinding;
import in.gov.eci.bloapp.databinding.BloRecyclerViewItemBinding;
import in.gov.eci.bloapp.model.app_model.DraftFormsModel;
import in.gov.eci.bloapp.model.app_model.FormsModel;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.viewmodel.DraftinformsViewModel;
import in.gov.eci.bloapp.views.activity.MainActivity;
import in.gov.eci.bloapp.views.fragments.voterforms.VoterFormsFragment;
import in.gov.eci.bloapp.views.fragments.voterforms.aadhar_auth.AadhaarAuthenticationFormFragment;
import in.gov.eci.bloapp.views.fragments.voterforms.deletion_objection.DeletionObjectionForm;
import in.gov.eci.bloapp.views.fragments.voterforms.migration.MigrationCorrection;
import in.gov.eci.bloapp.views.fragments.voterforms.new_voter_registration.NewVoter;
import in.gov.eci.bloapp.views.fragments.voterforms.overseas.OverseasVoter;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class FormsInDraft extends Hilt_FormsInDraft implements View.OnClickListener {
    private GenericRecyclerView adapter;
    private BloFragmentFormsInDraftBinding binding1;
    private String datepass;
    String forms = "Forms";
    private String name;
    private List<DraftFormsModel> selectadhaarauthenticationvoter;
    private List<DraftFormsModel> selectdeletionObjectionvoter;
    private List<DraftFormsModel> selectnewvoter;
    private List<DraftFormsModel> selectoverseasElectorVoter;
    private List<DraftFormsModel> selectshiftingcorrectnessvoter;
    DraftinformsViewModel viewModel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding1 = BloFragmentFormsInDraftBinding.inflate(getLayoutInflater());
        this.viewModel = (DraftinformsViewModel) new ViewModelProvider(requireActivity()).get(DraftinformsViewModel.class);
        this.selectnewvoter = new ArrayList();
        this.selectoverseasElectorVoter = new ArrayList();
        this.selectadhaarauthenticationvoter = new ArrayList();
        this.selectdeletionObjectionvoter = new ArrayList();
        this.selectshiftingcorrectnessvoter = new ArrayList();
        this.binding1.newVotReg.setVisibility(8);
        this.binding1.overseasElectorVoter.setVisibility(8);
        this.binding1.addharAuth.setVisibility(8);
        this.binding1.deletionObjection.setVisibility(8);
        this.binding1.shiftingCorrectness.setVisibility(8);
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(true) { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft.1
            public void handleOnBackPressed() {
                FormsInDraft.this.openFragment1(new VoterFormsFragment(), FormsInDraft.this.forms);
            }
        });
        selectnewvoter();
        selectoverseasElectorVoter();
        selectadhaarauthenticationvoter();
        selectdeletionObjectionvoter();
        selectshiftingcorrectnessvoter();
        this.binding1.homeBtnIv.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.binding1.newVotReg.setOnClickListener(this);
        this.binding1.overseasElectorVoter.setOnClickListener(this);
        this.binding1.addharAuth.setOnClickListener(this);
        this.binding1.deletionObjection.setOnClickListener(this);
        this.binding1.shiftingCorrectness.setOnClickListener(this);
        this.binding1.backBtnIv.setOnClickListener(this);
        return this.binding1.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        startActivity(new Intent((Context) getActivity(), (Class<?>) MainActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectnewvoter() {
        this.viewModel.selectnewVoter().observe(getViewLifecycleOwner(), new Observer() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$$ExternalSyntheticLambda1
            public final void onChanged(Object obj) {
                this.f$0.lambda$selectnewvoter$1((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectnewvoter$1(List list) {
        this.selectnewvoter.clear();
        if (!list.isEmpty()) {
            Logger.d("TAG", String.valueOf(list.size()));
            for (int i = 0; i < list.size(); i++) {
                this.selectnewvoter.add(new DraftFormsModel(((FormsModel) list.get(i)).getName(), ((FormsModel) list.get(i)).getCreatedon()));
            }
            this.binding1.newVotReg.setVisibility(0);
            this.binding1.newVoterRecycler.setVisibility(0);
            initRecyclerViewAdapter1();
            this.binding1.newVoterRecycler.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
            this.binding1.newVoterRecycler.setAdapter(this.adapter);
            return;
        }
        this.binding1.newVotReg.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectoverseasElectorVoter() {
        this.viewModel.selectoverseasElectorVoter().observe(getViewLifecycleOwner(), new Observer() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                this.f$0.lambda$selectoverseasElectorVoter$2((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectoverseasElectorVoter$2(List list) {
        this.selectoverseasElectorVoter.clear();
        if (!list.isEmpty()) {
            Logger.d("TAG", String.valueOf(list.size()));
            for (int i = 0; i < list.size(); i++) {
                this.selectoverseasElectorVoter.add(new DraftFormsModel(((FormsModel) list.get(i)).getName(), ((FormsModel) list.get(i)).getCreatedon()));
            }
            this.binding1.overseasElectorVoter.setVisibility(0);
            this.binding1.overseasElectorVoterRecycler.setVisibility(0);
            initRecyclerViewAdapter2();
            this.binding1.overseasElectorVoterRecycler.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
            this.binding1.overseasElectorVoterRecycler.setAdapter(this.adapter);
            return;
        }
        this.binding1.overseasElectorVoter.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectadhaarauthenticationvoter() {
        this.viewModel.selectadhaarauthenticationvoter().observe(getViewLifecycleOwner(), new Observer() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$$ExternalSyntheticLambda2
            public final void onChanged(Object obj) {
                this.f$0.lambda$selectadhaarauthenticationvoter$3((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectadhaarauthenticationvoter$3(List list) {
        this.selectadhaarauthenticationvoter.clear();
        if (!list.isEmpty()) {
            Logger.d("TAG", String.valueOf(list.size()));
            for (int i = 0; i < list.size(); i++) {
                this.selectadhaarauthenticationvoter.add(new DraftFormsModel(((FormsModel) list.get(i)).getName(), ((FormsModel) list.get(i)).getCreatedon()));
            }
            this.binding1.addharAuth.setVisibility(0);
            this.binding1.aadhaarAuthRecycler.setVisibility(0);
            initRecyclerViewAdapter3();
            this.binding1.aadhaarAuthRecycler.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
            this.binding1.aadhaarAuthRecycler.setAdapter(this.adapter);
            return;
        }
        this.binding1.addharAuth.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectdeletionObjectionvoter() {
        this.viewModel.selectdeletionObjectionvoter().observe(getViewLifecycleOwner(), new Observer() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$$ExternalSyntheticLambda4
            public final void onChanged(Object obj) {
                this.f$0.lambda$selectdeletionObjectionvoter$4((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectdeletionObjectionvoter$4(List list) {
        this.selectdeletionObjectionvoter.clear();
        if (!list.isEmpty()) {
            Logger.d("TAG", String.valueOf(list.size()));
            for (int i = 0; i < list.size(); i++) {
                this.selectdeletionObjectionvoter.add(new DraftFormsModel(((FormsModel) list.get(i)).getName(), ((FormsModel) list.get(i)).getCreatedon()));
            }
            this.binding1.deletionObjection.setVisibility(0);
            this.binding1.deletionObjectionRecycler.setVisibility(0);
            initRecyclerViewAdapter4();
            this.binding1.deletionObjectionRecycler.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
            this.binding1.deletionObjectionRecycler.setAdapter(this.adapter);
            return;
        }
        this.binding1.deletionObjection.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectshiftingcorrectnessvoter() {
        this.viewModel.selectshiftingcorrectnessvoter().observe(getViewLifecycleOwner(), new Observer() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$$ExternalSyntheticLambda3
            public final void onChanged(Object obj) {
                this.f$0.lambda$selectshiftingcorrectnessvoter$5((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectshiftingcorrectnessvoter$5(List list) {
        this.selectshiftingcorrectnessvoter.clear();
        if (!list.isEmpty()) {
            Logger.d("TAG", String.valueOf(list.size()));
            for (int i = 0; i < list.size(); i++) {
                if (!TextUtils.isEmpty(((FormsModel) list.get(i)).getPersonaldetails()) && !((FormsModel) list.get(i)).getPersonaldetails().contains("selectPhoto")) {
                    this.selectshiftingcorrectnessvoter.add(new DraftFormsModel(((FormsModel) list.get(i)).getName(), ((FormsModel) list.get(i)).getCreatedon()));
                }
            }
            this.binding1.shiftingCorrectness.setVisibility(0);
            this.binding1.shiftingCorrectnessRecycler.setVisibility(0);
            initRecyclerViewAdapter5();
            this.binding1.shiftingCorrectnessRecycler.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
            this.binding1.shiftingCorrectnessRecycler.setAdapter(this.adapter);
            return;
        }
        this.binding1.shiftingCorrectness.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addhar_auth /* 2131362228 */:
                if (this.binding1.vector3.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.blo_vector).getConstantState()) {
                    this.binding1.vector3.setImageResource(R.drawable.blo_minus);
                    this.binding1.aadhaarAuthRecycler.setVisibility(0);
                } else {
                    this.binding1.vector3.setImageResource(R.drawable.blo_vector);
                    this.binding1.aadhaarAuthRecycler.setVisibility(8);
                }
                break;
            case R.id.back_btn_iv /* 2131362490 */:
                openFragment1(new VoterFormsFragment(), this.forms);
                break;
            case R.id.deletion_Objection /* 2131363178 */:
                if (this.binding1.vector4.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.blo_vector).getConstantState()) {
                    this.binding1.vector4.setImageResource(R.drawable.blo_minus);
                    this.binding1.deletionObjectionRecycler.setVisibility(0);
                } else {
                    this.binding1.vector4.setImageResource(R.drawable.blo_vector);
                    this.binding1.deletionObjectionRecycler.setVisibility(8);
                }
                break;
            case R.id.new_vot_reg /* 2131364993 */:
                if (this.binding1.vector1.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.blo_vector).getConstantState()) {
                    this.binding1.vector1.setImageResource(R.drawable.blo_minus);
                    this.binding1.newVoterRecycler.setVisibility(0);
                } else {
                    this.binding1.vector1.setImageResource(R.drawable.blo_vector);
                    this.binding1.newVoterRecycler.setVisibility(8);
                }
                break;
            case R.id.overseas_Elector_Voter /* 2131365163 */:
                if (this.binding1.vector2.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.blo_vector).getConstantState()) {
                    this.binding1.vector2.setImageResource(R.drawable.blo_minus);
                    this.binding1.overseasElectorVoterRecycler.setVisibility(0);
                } else {
                    this.binding1.vector2.setImageResource(R.drawable.blo_vector);
                    this.binding1.overseasElectorVoterRecycler.setVisibility(8);
                }
                break;
            case R.id.shifting_correctness /* 2131365924 */:
                if (this.binding1.vector5.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.blo_vector).getConstantState()) {
                    this.binding1.vector5.setImageResource(R.drawable.blo_minus);
                    this.binding1.shiftingCorrectnessRecycler.setVisibility(0);
                } else {
                    this.binding1.vector5.setImageResource(R.drawable.blo_vector);
                    this.binding1.shiftingCorrectnessRecycler.setVisibility(8);
                }
                break;
        }
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$2, reason: invalid class name */
    class AnonymousClass2 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass2() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloRecyclerViewItemBinding.inflate(FormsInDraft.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
            ((BloRecyclerViewItemBinding) holder.binding).button.setVisibility(8);
            ((BloRecyclerViewItemBinding) holder.binding).name.setText(((DraftFormsModel) FormsInDraft.this.selectnewvoter.get(position)).getName());
            ((BloRecyclerViewItemBinding) holder.binding).date.setText(((DraftFormsModel) FormsInDraft.this.selectnewvoter.get(position)).getCreatedon().substring(0, 10));
            ((BloRecyclerViewItemBinding) holder.binding).time.setText(((DraftFormsModel) FormsInDraft.this.selectnewvoter.get(position)).getCreatedon().substring(11));
            ((BloRecyclerViewItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FormsInDraft.AnonymousClass2.lambda$onBindViewHolder$0(holder, view);
                }
            });
            ((BloRecyclerViewItemBinding) holder.binding).delete.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$2$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$1(position, view);
                }
            });
            ((BloRecyclerViewItemBinding) holder.binding).edit.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$2$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$2(position, view);
                }
            });
        }

        static /* synthetic */ void lambda$onBindViewHolder$0(RecyclerViewHolder recyclerViewHolder, View view) {
            if (((BloRecyclerViewItemBinding) recyclerViewHolder.binding).button.getVisibility() == 8) {
                ((BloRecyclerViewItemBinding) recyclerViewHolder.binding).button.setVisibility(0);
            } else {
                ((BloRecyclerViewItemBinding) recyclerViewHolder.binding).button.setVisibility(8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(int i, View view) {
            FormsInDraft.this.viewModel.deletefromsindraft(((DraftFormsModel) FormsInDraft.this.selectnewvoter.get(i)).createdon);
            FormsInDraft.this.selectnewvoter();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$2(int i, View view) {
            FormsInDraft formsInDraft = FormsInDraft.this;
            formsInDraft.name = ((DraftFormsModel) formsInDraft.selectnewvoter.get(i)).getName();
            FormsInDraft formsInDraft2 = FormsInDraft.this;
            formsInDraft2.datepass = ((DraftFormsModel) formsInDraft2.selectnewvoter.get(i)).getCreatedon();
            FormsInDraft.this.openFragment(new NewVoter(), FormsInDraft.this.forms);
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return FormsInDraft.this.selectnewvoter.size();
        }
    }

    private void initRecyclerViewAdapter1() {
        this.adapter = new GenericRecyclerView(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$3, reason: invalid class name */
    class AnonymousClass3 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass3() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloRecyclerViewItemBinding.inflate(FormsInDraft.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
            ((BloRecyclerViewItemBinding) holder.binding).button.setVisibility(8);
            ((BloRecyclerViewItemBinding) holder.binding).name.setText(((DraftFormsModel) FormsInDraft.this.selectoverseasElectorVoter.get(position)).getName());
            ((BloRecyclerViewItemBinding) holder.binding).date.setText(((DraftFormsModel) FormsInDraft.this.selectoverseasElectorVoter.get(position)).getCreatedon().substring(0, 10));
            ((BloRecyclerViewItemBinding) holder.binding).time.setText(((DraftFormsModel) FormsInDraft.this.selectoverseasElectorVoter.get(position)).getCreatedon().substring(11));
            ((BloRecyclerViewItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$3$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FormsInDraft.AnonymousClass3.lambda$onBindViewHolder$0(holder, view);
                }
            });
            ((BloRecyclerViewItemBinding) holder.binding).delete.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$3$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$1(position, view);
                }
            });
            ((BloRecyclerViewItemBinding) holder.binding).edit.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$3$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$2(position, view);
                }
            });
        }

        static /* synthetic */ void lambda$onBindViewHolder$0(RecyclerViewHolder recyclerViewHolder, View view) {
            if (((BloRecyclerViewItemBinding) recyclerViewHolder.binding).button.getVisibility() == 8) {
                ((BloRecyclerViewItemBinding) recyclerViewHolder.binding).button.setVisibility(0);
            } else {
                ((BloRecyclerViewItemBinding) recyclerViewHolder.binding).button.setVisibility(8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(int i, View view) {
            FormsInDraft.this.viewModel.deletefromsindraft(((DraftFormsModel) FormsInDraft.this.selectoverseasElectorVoter.get(i)).createdon);
            FormsInDraft.this.selectoverseasElectorVoter();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$2(int i, View view) {
            FormsInDraft formsInDraft = FormsInDraft.this;
            formsInDraft.name = ((DraftFormsModel) formsInDraft.selectoverseasElectorVoter.get(i)).getName();
            FormsInDraft formsInDraft2 = FormsInDraft.this;
            formsInDraft2.datepass = ((DraftFormsModel) formsInDraft2.selectoverseasElectorVoter.get(i)).getCreatedon();
            FormsInDraft.this.openFragment(new OverseasVoter(), FormsInDraft.this.forms);
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return FormsInDraft.this.selectoverseasElectorVoter.size();
        }
    }

    private void initRecyclerViewAdapter2() {
        this.adapter = new GenericRecyclerView(new AnonymousClass3());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$4, reason: invalid class name */
    class AnonymousClass4 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass4() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloRecyclerViewItemBinding.inflate(FormsInDraft.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
            ((BloRecyclerViewItemBinding) holder.binding).button.setVisibility(8);
            ((BloRecyclerViewItemBinding) holder.binding).name.setText(((DraftFormsModel) FormsInDraft.this.selectadhaarauthenticationvoter.get(position)).getName());
            ((BloRecyclerViewItemBinding) holder.binding).date.setText(((DraftFormsModel) FormsInDraft.this.selectadhaarauthenticationvoter.get(position)).getCreatedon().substring(0, 10));
            ((BloRecyclerViewItemBinding) holder.binding).time.setText(((DraftFormsModel) FormsInDraft.this.selectadhaarauthenticationvoter.get(position)).getCreatedon().substring(11));
            ((BloRecyclerViewItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$4$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FormsInDraft.AnonymousClass4.lambda$onBindViewHolder$0(holder, view);
                }
            });
            ((BloRecyclerViewItemBinding) holder.binding).delete.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$4$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$1(position, view);
                }
            });
            ((BloRecyclerViewItemBinding) holder.binding).edit.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$4$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$2(position, view);
                }
            });
        }

        static /* synthetic */ void lambda$onBindViewHolder$0(RecyclerViewHolder recyclerViewHolder, View view) {
            if (((BloRecyclerViewItemBinding) recyclerViewHolder.binding).button.getVisibility() == 8) {
                ((BloRecyclerViewItemBinding) recyclerViewHolder.binding).button.setVisibility(0);
            } else {
                ((BloRecyclerViewItemBinding) recyclerViewHolder.binding).button.setVisibility(8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(int i, View view) {
            FormsInDraft.this.viewModel.deletefromsindraft(((DraftFormsModel) FormsInDraft.this.selectadhaarauthenticationvoter.get(i)).createdon);
            FormsInDraft.this.selectadhaarauthenticationvoter();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$2(int i, View view) {
            FormsInDraft formsInDraft = FormsInDraft.this;
            formsInDraft.name = ((DraftFormsModel) formsInDraft.selectadhaarauthenticationvoter.get(i)).getName();
            FormsInDraft formsInDraft2 = FormsInDraft.this;
            formsInDraft2.datepass = ((DraftFormsModel) formsInDraft2.selectadhaarauthenticationvoter.get(i)).getCreatedon();
            FormsInDraft.this.openFragment(new AadhaarAuthenticationFormFragment(), FormsInDraft.this.forms);
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return FormsInDraft.this.selectadhaarauthenticationvoter.size();
        }
    }

    private void initRecyclerViewAdapter3() {
        this.adapter = new GenericRecyclerView(new AnonymousClass4());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$5, reason: invalid class name */
    class AnonymousClass5 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass5() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloRecyclerViewItemBinding.inflate(FormsInDraft.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
            ((BloRecyclerViewItemBinding) holder.binding).button.setVisibility(8);
            ((BloRecyclerViewItemBinding) holder.binding).name.setText(((DraftFormsModel) FormsInDraft.this.selectdeletionObjectionvoter.get(position)).getName());
            ((BloRecyclerViewItemBinding) holder.binding).date.setText(((DraftFormsModel) FormsInDraft.this.selectdeletionObjectionvoter.get(position)).getCreatedon().substring(0, 10));
            ((BloRecyclerViewItemBinding) holder.binding).time.setText(((DraftFormsModel) FormsInDraft.this.selectdeletionObjectionvoter.get(position)).getCreatedon().substring(11));
            ((BloRecyclerViewItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$5$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FormsInDraft.AnonymousClass5.lambda$onBindViewHolder$0(holder, view);
                }
            });
            ((BloRecyclerViewItemBinding) holder.binding).delete.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$5$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$1(position, view);
                }
            });
            ((BloRecyclerViewItemBinding) holder.binding).edit.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$5$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$2(position, view);
                }
            });
        }

        static /* synthetic */ void lambda$onBindViewHolder$0(RecyclerViewHolder recyclerViewHolder, View view) {
            if (((BloRecyclerViewItemBinding) recyclerViewHolder.binding).button.getVisibility() == 8) {
                ((BloRecyclerViewItemBinding) recyclerViewHolder.binding).button.setVisibility(0);
            } else {
                ((BloRecyclerViewItemBinding) recyclerViewHolder.binding).button.setVisibility(8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(int i, View view) {
            FormsInDraft.this.viewModel.deletefromsindraft(((DraftFormsModel) FormsInDraft.this.selectdeletionObjectionvoter.get(i)).createdon);
            FormsInDraft.this.selectdeletionObjectionvoter();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$2(int i, View view) {
            FormsInDraft formsInDraft = FormsInDraft.this;
            formsInDraft.name = ((DraftFormsModel) formsInDraft.selectdeletionObjectionvoter.get(i)).getName();
            FormsInDraft formsInDraft2 = FormsInDraft.this;
            formsInDraft2.datepass = ((DraftFormsModel) formsInDraft2.selectdeletionObjectionvoter.get(i)).getCreatedon();
            FormsInDraft.this.openFragment(new DeletionObjectionForm(), FormsInDraft.this.forms);
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return FormsInDraft.this.selectdeletionObjectionvoter.size();
        }
    }

    private void initRecyclerViewAdapter4() {
        this.adapter = new GenericRecyclerView(new AnonymousClass5());
    }

    /* JADX INFO: renamed from: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$6, reason: invalid class name */
    class AnonymousClass6 implements GenericRecyclerView.GenericRecyclerViewInterface {
        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemViewType(int position) {
            return position;
        }

        AnonymousClass6() {
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerViewHolder(BloRecyclerViewItemBinding.inflate(FormsInDraft.this.getLayoutInflater()));
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
            ((BloRecyclerViewItemBinding) holder.binding).button.setVisibility(8);
            ((BloRecyclerViewItemBinding) holder.binding).name.setText(((DraftFormsModel) FormsInDraft.this.selectshiftingcorrectnessvoter.get(position)).getName());
            ((BloRecyclerViewItemBinding) holder.binding).date.setText(((DraftFormsModel) FormsInDraft.this.selectshiftingcorrectnessvoter.get(position)).getCreatedon().substring(0, 10));
            ((BloRecyclerViewItemBinding) holder.binding).time.setText(((DraftFormsModel) FormsInDraft.this.selectshiftingcorrectnessvoter.get(position)).getCreatedon().substring(11));
            ((BloRecyclerViewItemBinding) holder.binding).layout.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$6$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FormsInDraft.AnonymousClass6.lambda$onBindViewHolder$0(holder, view);
                }
            });
            ((BloRecyclerViewItemBinding) holder.binding).delete.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$6$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$1(position, view);
                }
            });
            ((BloRecyclerViewItemBinding) holder.binding).edit.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.draftForms.FormsInDraft$6$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$2(position, view);
                }
            });
        }

        static /* synthetic */ void lambda$onBindViewHolder$0(RecyclerViewHolder recyclerViewHolder, View view) {
            if (((BloRecyclerViewItemBinding) recyclerViewHolder.binding).button.getVisibility() == 8) {
                ((BloRecyclerViewItemBinding) recyclerViewHolder.binding).button.setVisibility(0);
            } else {
                ((BloRecyclerViewItemBinding) recyclerViewHolder.binding).button.setVisibility(8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(int i, View view) {
            FormsInDraft.this.viewModel.deletefromsindraft(((DraftFormsModel) FormsInDraft.this.selectshiftingcorrectnessvoter.get(i)).createdon);
            FormsInDraft.this.selectshiftingcorrectnessvoter();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$2(int i, View view) {
            FormsInDraft formsInDraft = FormsInDraft.this;
            formsInDraft.name = ((DraftFormsModel) formsInDraft.selectshiftingcorrectnessvoter.get(i)).getName();
            FormsInDraft formsInDraft2 = FormsInDraft.this;
            formsInDraft2.datepass = ((DraftFormsModel) formsInDraft2.selectshiftingcorrectnessvoter.get(i)).getCreatedon();
            FormsInDraft.this.openFragment2(new MigrationCorrection(), FormsInDraft.this.forms);
        }

        @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
        public int getItemCount() {
            return FormsInDraft.this.selectshiftingcorrectnessvoter.size();
        }
    }

    private void initRecyclerViewAdapter5() {
        this.adapter = new GenericRecyclerView(new AnonymousClass6());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment, String selectedFragment) {
        Bundle bundle = new Bundle();
        bundle.putString("name", this.name);
        bundle.putString(XmlErrorCodes.DATE, this.datepass);
        bundle.putString("form", "draftform");
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame_voter_forms, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment2(Fragment fragment, String selectedFragment) {
        Bundle bundle = new Bundle();
        bundle.putString("Flag", "DRAFT");
        bundle.putString("name", this.name);
        bundle.putString(XmlErrorCodes.DATE, this.datepass);
        bundle.putString("display", "lastlayout");
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame_voter_forms, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment1(Fragment fragment, String selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame_voter_forms, fragment, selectedFragment);
        fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransactionBeginTransaction.setTransition(4099);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding1 = null;
    }
}
