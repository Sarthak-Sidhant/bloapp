package in.gov.eci.bloapp.views.fragments.voterforms.trackstatus;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.RecyclerViewHolder;
import in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.databinding.BloFragmentTrackStatusButtonBinding;
import in.gov.eci.bloapp.databinding.BloTrackStatusRvItemBinding;
import in.gov.eci.bloapp.utils.Constants;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.VoterForms;
import in.gov.eci.bloapp.views.fragments.BaseFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class TrackStatusButtonFragment extends BaseFragment {
    String acNo;
    String accepted;
    String acceptedStr;
    String articleNumber;
    String asmblyName;
    String bloAssigned;
    final Retrofit.Builder builder1;
    final CommomUtility commomUtility;
    String currentStatus;
    String epicDispatchedDate;
    String epicNo;
    String erollUpdatedDate;
    String firstName;
    String formRefNo;
    String formType;
    String formsubmittedStr;
    BloFragmentTrackStatusButtonBinding fragmentTrackStatusButtonBinding;
    String fvrSubmitted;
    String fvrSubmittedHearingScheduled;
    String fvrVerifiedStr;
    String getBloAssignedStrin;
    String hearinScheduleStr;
    String hearingScheduled;
    String lastName;
    final OkHttpClient okHttpClient;
    String rejected;
    final Retrofit retrofit;
    private final List<String> stageList6;
    private final List<String> stageList8;
    String stateCode;
    String stateName;
    String status;
    String submissionDate;
    String submitted;
    final UserClient userClient;

    public TrackStatusButtonFragment() {
        CommomUtility commomUtility = new CommomUtility();
        this.commomUtility = commomUtility;
        OkHttpClient okHttpClientBuild = new OkHttpClient().newBuilder().connectTimeout(2L, TimeUnit.MINUTES).readTimeout(2L, TimeUnit.MINUTES).build();
        this.okHttpClient = okHttpClientBuild;
        Retrofit.Builder builderClient = new Retrofit.Builder().baseUrl(commomUtility.baseurl).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(okHttpClientBuild);
        this.builder1 = builderClient;
        Retrofit retrofitBuild = builderClient.build();
        this.retrofit = retrofitBuild;
        this.userClient = (UserClient) retrofitBuild.create(UserClient.class);
        this.stageList6 = new ArrayList();
        this.stageList8 = new ArrayList();
        this.formsubmittedStr = "Form Submitted";
        this.getBloAssignedStrin = "BLO Assigned";
        this.fvrVerifiedStr = "FVR Verified";
        this.hearinScheduleStr = "Hearing Scheduled";
        this.acceptedStr = "Accepted";
        this.articleNumber = "";
        this.status = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.fragmentTrackStatusButtonBinding = BloFragmentTrackStatusButtonBinding.inflate(getLayoutInflater());
        this.stateName = SharedPref.getInstance(requireContext()).getStateName();
        this.asmblyName = SharedPref.getInstance(requireContext()).getAssemblyName();
        this.stageList6.add(this.formsubmittedStr);
        this.stageList6.add(this.getBloAssignedStrin);
        this.stageList6.add(this.fvrVerifiedStr);
        this.stageList6.add(this.hearinScheduleStr);
        this.stageList6.add(this.acceptedStr);
        this.stageList6.add("EPIC Generated");
        this.stageList6.add("EPIC Dispatched");
        this.stageList6.add("currentStatus");
        this.stageList8.add(this.formsubmittedStr);
        this.stageList8.add(this.getBloAssignedStrin);
        this.stageList8.add(this.fvrVerifiedStr);
        this.stageList8.add(this.hearinScheduleStr);
        this.stageList8.add(this.acceptedStr);
        this.stageList8.add("currentStatus");
        char c = 1;
        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), new OnBackPressedCallback(1 == true ? 1 : 0) { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusButtonFragment.1
            public void handleOnBackPressed() {
                TrackStatusButtonFragment.this.startActivity(new Intent((Context) TrackStatusButtonFragment.this.getActivity(), (Class<?>) VoterForms.class));
            }
        });
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.firstName = arguments.getString(Constants.FIRST_NAME);
            this.lastName = arguments.getString(Constants.LAST_NAME);
            this.stateCode = arguments.getString("stateCode");
            this.acNo = arguments.getString("acNo");
            this.formRefNo = arguments.getString("formRefNo");
            this.formType = arguments.getString("formType");
            this.submissionDate = arguments.getString("submissionDate");
            this.currentStatus = arguments.getString("currentStatus");
            this.submitted = arguments.getString("submitted");
            this.bloAssigned = arguments.getString("bloAssigned");
            this.fvrSubmitted = arguments.getString("fvrSubmitted");
            this.epicNo = arguments.getString("epicNo");
            this.epicDispatchedDate = arguments.getString("epicDispatchedDate");
            this.hearingScheduled = arguments.getString("hearingScheduled");
            this.fvrSubmittedHearingScheduled = arguments.getString("fvrSubmittedHearingScheduled");
            this.accepted = arguments.getString("accepted");
            this.rejected = arguments.getString("rejected");
            this.erollUpdatedDate = arguments.getString("erollUpdatedDate");
        }
        Logger.d("formRefNo", this.formRefNo);
        this.fragmentTrackStatusButtonBinding.statusTv.setText(this.currentStatus);
        this.fragmentTrackStatusButtonBinding.refNoTv.setText(this.formRefNo);
        this.fragmentTrackStatusButtonBinding.firstNameTv.setText(this.firstName);
        this.fragmentTrackStatusButtonBinding.lastNameTv.setText(this.lastName);
        this.fragmentTrackStatusButtonBinding.stateTv.setText(this.stateName);
        this.fragmentTrackStatusButtonBinding.areaTv.setText(this.asmblyName);
        this.fragmentTrackStatusButtonBinding.formType.setText(this.formType);
        if (!this.submissionDate.equals("")) {
            String strSubstring = this.submissionDate.substring(0, 2);
            int i = Integer.parseInt(strSubstring);
            if (i >= 11 && i <= 13) {
                strSubstring = strSubstring + "th";
            }
            int i2 = i % 10;
            if (i2 == 1) {
                str = strSubstring + "st";
            } else if (i2 == 2) {
                str = strSubstring + "nd";
            } else if (i2 != 3) {
                str = strSubstring + "th";
            } else {
                str = strSubstring + "rd";
            }
            String strSubstring2 = this.submissionDate.substring(3, 5);
            String strSubstring3 = this.submissionDate.substring(6, 10);
            strSubstring2.hashCode();
            switch (strSubstring2.hashCode()) {
                case 1537:
                    c = !strSubstring2.equals("01") ? -1 : 0;
                    break;
                case 1538:
                    if (!strSubstring2.equals("02")) {
                        c = -1;
                    }
                    break;
                case 1539:
                    c = !strSubstring2.equals("03") ? -1 : 2;
                    break;
                case 1540:
                    c = !strSubstring2.equals("04") ? -1 : 3;
                    break;
                case 1541:
                    c = !strSubstring2.equals("05") ? -1 : 4;
                    break;
                case 1542:
                    c = !strSubstring2.equals("06") ? -1 : 5;
                    break;
                case 1543:
                    c = !strSubstring2.equals("07") ? -1 : 6;
                    break;
                case 1544:
                    c = !strSubstring2.equals("08") ? -1 : 7;
                    break;
                case 1545:
                    c = !strSubstring2.equals("09") ? -1 : 8;
                    break;
                case 1567:
                    c = !strSubstring2.equals("10") ? -1 : 9;
                    break;
                case 1568:
                    c = !strSubstring2.equals("11") ? -1 : 10;
                    break;
                case 1569:
                    c = !strSubstring2.equals("12") ? -1 : 11;
                    break;
                default:
                    c = -1;
                    break;
            }
            switch (c) {
                case 0:
                    strSubstring2 = "January";
                    break;
                case 1:
                    strSubstring2 = "February";
                    break;
                case 2:
                    strSubstring2 = "March";
                    break;
                case 3:
                    strSubstring2 = "April";
                    break;
                case 4:
                    strSubstring2 = "May";
                    break;
                case 5:
                    strSubstring2 = "June";
                    break;
                case 6:
                    strSubstring2 = "July";
                    break;
                case 7:
                    strSubstring2 = "August";
                    break;
                case '\b':
                    strSubstring2 = "September";
                    break;
                case '\t':
                    strSubstring2 = "October";
                    break;
                case '\n':
                    strSubstring2 = "November";
                    break;
                case 11:
                    strSubstring2 = "December";
                    break;
            }
            this.fragmentTrackStatusButtonBinding.submissiondateTv.setText(str + " " + strSubstring2 + ", " + strSubstring3);
        } else {
            this.fragmentTrackStatusButtonBinding.submissiondateTv.setText(this.submissionDate);
        }
        if (this.formType.equals("FORM6")) {
            if (this.currentStatus.equals("EROLL UPDATED")) {
                getDop();
            } else {
                initRecyclerViewAdapter1();
            }
        }
        if (this.formType.equals("FORM6A")) {
            initRecyclerViewAdapter2();
        }
        if (this.formType.equals("FORM7")) {
            initRecyclerViewAdapter3();
        }
        if (this.formType.equals("FORM8")) {
            if (this.currentStatus.equals("EROLL UPDATED")) {
                getDop();
            } else {
                initRecyclerViewAdapter5();
            }
        }
        return this.fragmentTrackStatusButtonBinding.getRoot();
    }

    private void getDop() {
        System.out.println(SharedPref.getInstance(requireContext()).getStateCode() + this.formRefNo + "PPPPPPPPPPPPPPPPPPP222222" + SharedPref.getInstance(requireContext()).getAtknBnd() + "44444444444444444444444444444444" + SharedPref.getInstance(requireContext()).getRtknBnd());
        Call<JsonObject> callErotrackDopstatus = this.userClient.erotrackDopstatus(this.formRefNo, SharedPref.getInstance(requireContext()).getStateCode(), SharedPref.getInstance(requireContext()).getToken(), SharedPref.getInstance(requireContext()).getAtknBnd(), SharedPref.getInstance(requireContext()).getRtknBnd(), "BLOAPP", "blo", "ANDROIDMOB");
        showProgressVisible();
        callErotrackDopstatus.enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusButtonFragment.2
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }

            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                System.out.println("PPPPPPPPPPPPPPPPPPP1111" + response.body());
                if (response.body() != null) {
                    TrackStatusButtonFragment.this.showProgressInVisible();
                    System.out.println(TrackStatusButtonFragment.this.stateCode + TrackStatusButtonFragment.this.formRefNo + "PPPPPPPPPPPPPPPPPPP222222" + response.body());
                    try {
                        JSONObject jSONObject = new JSONObject(String.valueOf(response.body()));
                        TrackStatusButtonFragment.this.articleNumber = jSONObject.get("articleNumber").toString();
                        if (jSONObject.get("status").toString().equals("ITEM_BOOK")) {
                            TrackStatusButtonFragment.this.status = "Order Booked";
                        } else if (jSONObject.get("status").toString().equals("ITEM_DELIVERY")) {
                            TrackStatusButtonFragment.this.status = "Delivered";
                        } else if (jSONObject.get("status").toString().equals("BEAT_DISPATCH")) {
                            TrackStatusButtonFragment.this.status = "Postman assign for delivery";
                        } else if (jSONObject.get("status").toString().equals("BAG_DISPATCH")) {
                            TrackStatusButtonFragment.this.status = "Bags In Transit for delivery";
                        } else if (jSONObject.get("status").toString().equals("ITEM_BAGGING")) {
                            TrackStatusButtonFragment.this.status = "In Transit to Post Office";
                        } else if (jSONObject.get("status").toString().equals("ITEM_RECEIVE")) {
                            TrackStatusButtonFragment.this.status = "Received at Post Office";
                        } else if (jSONObject.get("status").toString().equals("ITEM_REDIRECT")) {
                            TrackStatusButtonFragment.this.status = "Redirected to other Post Office";
                        } else if (jSONObject.get("status").toString().equals("ITEM_RETURN")) {
                            TrackStatusButtonFragment.this.status = "Returned to ECI";
                        } else if (jSONObject.get("status").toString().equals("ITEM_ONHOLD")) {
                            TrackStatusButtonFragment.this.status = "On-Hold";
                        } else if (jSONObject.get("status").toString().equals("TMO_RECEIVE")) {
                            TrackStatusButtonFragment.this.status = "TMO In Transit";
                        } else if (jSONObject.get("status").toString().equals("ITEM_CANCEL")) {
                            TrackStatusButtonFragment.this.status = "Cancelled";
                        } else if (jSONObject.get("status").toString().equals("ITEM_NONDELIVER")) {
                            TrackStatusButtonFragment.this.status = "Not Delivered";
                        }
                        System.out.println(jSONObject.get("status") + "LLLLLLLLLLLLLLLLL");
                        if (jSONObject.get("status").equals(null)) {
                            TrackStatusButtonFragment.this.status = "Not Dispatched , Under Printing";
                        }
                        if (jSONObject.get("status").toString().equals("Booked")) {
                            TrackStatusButtonFragment.this.status = "Not Dispatched , Under Printing";
                        }
                        if (TrackStatusButtonFragment.this.formType.equals("FORM8")) {
                            TrackStatusButtonFragment.this.initRecyclerViewAdapter4();
                        } else {
                            TrackStatusButtonFragment.this.initRecyclerViewAdapter6();
                        }
                        System.out.println("PPPPPPPPPPPPPPPPPPP" + jSONObject.get("message"));
                    } catch (JSONException unused) {
                        TrackStatusButtonFragment.this.showProgressInVisible();
                    }
                } else {
                    if (TrackStatusButtonFragment.this.formType.equals("FORM8")) {
                        TrackStatusButtonFragment.this.initRecyclerViewAdapter5();
                    } else {
                        TrackStatusButtonFragment.this.initRecyclerViewAdapter1();
                    }
                    TrackStatusButtonFragment.this.showProgressInVisible();
                    TrackStatusButtonFragment.this.showDialog("No message available");
                }
                TrackStatusButtonFragment.this.showProgressInVisible();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.blo_ic_baseline_warning_24);
        builder.setTitle("Error");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusButtonFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRecyclerViewAdapter1() {
        GenericRecyclerView genericRecyclerView = new GenericRecyclerView(new GenericRecyclerView.GenericRecyclerViewInterface() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusButtonFragment.3
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemViewType(int position) {
                return position;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RecyclerViewHolder(BloTrackStatusRvItemBinding.inflate(TrackStatusButtonFragment.this.getLayoutInflater()));
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public void onBindViewHolder(RecyclerViewHolder holder, int position) {
                ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_round_highlight_off_24);
                ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_tags_rounded_corners);
                ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line));
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals(TrackStatusButtonFragment.this.formsubmittedStr) && TrackStatusButtonFragment.this.submitted.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals(TrackStatusButtonFragment.this.getBloAssignedStrin) && TrackStatusButtonFragment.this.bloAssigned.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals(TrackStatusButtonFragment.this.fvrVerifiedStr) && TrackStatusButtonFragment.this.fvrSubmitted.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals(TrackStatusButtonFragment.this.hearinScheduleStr) && TrackStatusButtonFragment.this.hearingScheduled.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals(TrackStatusButtonFragment.this.acceptedStr) && TrackStatusButtonFragment.this.accepted.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals(TrackStatusButtonFragment.this.acceptedStr) && TrackStatusButtonFragment.this.rejected.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    ((BloTrackStatusRvItemBinding) holder.binding).stage.setText("Rejected");
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals("EPIC Generated") && !TrackStatusButtonFragment.this.epicNo.equals("")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    ((BloTrackStatusRvItemBinding) holder.binding).epic.setText(TrackStatusButtonFragment.this.epicNo);
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals("EPIC Dispatched") && !TrackStatusButtonFragment.this.epicDispatchedDate.equals("")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).epic.setText(TrackStatusButtonFragment.this.epicNo);
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals("currentStatus")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).layout.setVisibility(8);
                }
                if (position == TrackStatusButtonFragment.this.stageList6.size() - 2) {
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setVisibility(8);
                }
                ((BloTrackStatusRvItemBinding) holder.binding).stage.setText((CharSequence) TrackStatusButtonFragment.this.stageList6.get(position));
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemCount() {
                return TrackStatusButtonFragment.this.stageList6.size();
            }
        });
        this.fragmentTrackStatusButtonBinding.trackStatusBtnRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.fragmentTrackStatusButtonBinding.trackStatusBtnRv.setAdapter(genericRecyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRecyclerViewAdapter6() {
        GenericRecyclerView genericRecyclerView = new GenericRecyclerView(new GenericRecyclerView.GenericRecyclerViewInterface() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusButtonFragment.4
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemViewType(int position) {
                return position;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RecyclerViewHolder(BloTrackStatusRvItemBinding.inflate(TrackStatusButtonFragment.this.getLayoutInflater()));
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public void onBindViewHolder(RecyclerViewHolder holder, int position) {
                ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_round_highlight_off_24);
                ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_tags_rounded_corners);
                ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line));
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals(TrackStatusButtonFragment.this.formsubmittedStr) && TrackStatusButtonFragment.this.submitted.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals(TrackStatusButtonFragment.this.getBloAssignedStrin) && TrackStatusButtonFragment.this.bloAssigned.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals(TrackStatusButtonFragment.this.fvrVerifiedStr) && TrackStatusButtonFragment.this.fvrSubmitted.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals(TrackStatusButtonFragment.this.hearinScheduleStr) && TrackStatusButtonFragment.this.hearingScheduled.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals(TrackStatusButtonFragment.this.acceptedStr) && TrackStatusButtonFragment.this.accepted.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals(TrackStatusButtonFragment.this.acceptedStr) && TrackStatusButtonFragment.this.rejected.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    ((BloTrackStatusRvItemBinding) holder.binding).stage.setText("Rejected");
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals("EPIC Generated") && !TrackStatusButtonFragment.this.epicNo.equals("")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    ((BloTrackStatusRvItemBinding) holder.binding).epic.setText(TrackStatusButtonFragment.this.epicNo);
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals("EPIC Dispatched") && !TrackStatusButtonFragment.this.epicDispatchedDate.equals("")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).epic.setText(TrackStatusButtonFragment.this.epicNo);
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals("currentStatus")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    System.out.println(TrackStatusButtonFragment.this.status + "IIIIIIIIIIIIIIII");
                    if (TrackStatusButtonFragment.this.status.equals("Not Dispatched , Under Printing")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).stage.setText(TrackStatusButtonFragment.this.status);
                    } else {
                        ((BloTrackStatusRvItemBinding) holder.binding).stage.setText(TrackStatusButtonFragment.this.status);
                        ((BloTrackStatusRvItemBinding) holder.binding).epic.setText(TrackStatusButtonFragment.this.articleNumber);
                        ((BloTrackStatusRvItemBinding) holder.binding).click.setText("Click here to track");
                    }
                    ((BloTrackStatusRvItemBinding) holder.binding).click.setTextColor(-16776961);
                    ((BloTrackStatusRvItemBinding) holder.binding).click.setVisibility(0);
                    ((BloTrackStatusRvItemBinding) holder.binding).click.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusButtonFragment.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            TrackStatusButtonFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.indiapost.gov.in/_layouts/15/dop.portal.tracking/trackconsignment.aspx")));
                        }
                    });
                }
                if (position == TrackStatusButtonFragment.this.stageList6.size() - 1) {
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setVisibility(8);
                }
                if (!((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals("currentStatus")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).stage.setText((CharSequence) TrackStatusButtonFragment.this.stageList6.get(position));
                } else {
                    ((BloTrackStatusRvItemBinding) holder.binding).stage.setText(TrackStatusButtonFragment.this.status);
                }
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemCount() {
                return TrackStatusButtonFragment.this.stageList6.size();
            }
        });
        this.fragmentTrackStatusButtonBinding.trackStatusBtnRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.fragmentTrackStatusButtonBinding.trackStatusBtnRv.setAdapter(genericRecyclerView);
    }

    private void initRecyclerViewAdapter2() {
        GenericRecyclerView genericRecyclerView = new GenericRecyclerView(new GenericRecyclerView.GenericRecyclerViewInterface() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusButtonFragment.5
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemViewType(int position) {
                return position;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RecyclerViewHolder(BloTrackStatusRvItemBinding.inflate(TrackStatusButtonFragment.this.getLayoutInflater()));
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public void onBindViewHolder(RecyclerViewHolder holder, int position) {
                ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_round_highlight_off_24);
                ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_tags_rounded_corners);
                ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line));
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals(TrackStatusButtonFragment.this.formsubmittedStr) && TrackStatusButtonFragment.this.submitted.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals(TrackStatusButtonFragment.this.getBloAssignedStrin) && TrackStatusButtonFragment.this.bloAssigned.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals(TrackStatusButtonFragment.this.fvrVerifiedStr) && TrackStatusButtonFragment.this.fvrSubmitted.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals(TrackStatusButtonFragment.this.hearinScheduleStr) && TrackStatusButtonFragment.this.hearingScheduled.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals(TrackStatusButtonFragment.this.acceptedStr) && TrackStatusButtonFragment.this.accepted.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals(TrackStatusButtonFragment.this.acceptedStr) && TrackStatusButtonFragment.this.rejected.equals("Y")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    if (TrackStatusButtonFragment.this.accepted.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).stage.setText("Accepted");
                    } else {
                        ((BloTrackStatusRvItemBinding) holder.binding).stage.setText("Rejected");
                    }
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals("EPIC Generated") && !TrackStatusButtonFragment.this.epicNo.equals("")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    ((BloTrackStatusRvItemBinding) holder.binding).epic.setText(TrackStatusButtonFragment.this.epicNo);
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals("EPIC Dispatched") && !TrackStatusButtonFragment.this.epicDispatchedDate.equals("")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                    ((BloTrackStatusRvItemBinding) holder.binding).epic.setText(TrackStatusButtonFragment.this.epicNo);
                }
                if (((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals("currentStatus")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).layout.setVisibility(8);
                }
                if (position == TrackStatusButtonFragment.this.stageList6.size() - 2) {
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setVisibility(8);
                }
                ((BloTrackStatusRvItemBinding) holder.binding).stage.setText((CharSequence) TrackStatusButtonFragment.this.stageList6.get(position));
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemCount() {
                return TrackStatusButtonFragment.this.stageList6.size();
            }
        });
        this.fragmentTrackStatusButtonBinding.trackStatusBtnRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.fragmentTrackStatusButtonBinding.trackStatusBtnRv.setAdapter(genericRecyclerView);
    }

    private void initRecyclerViewAdapter3() {
        GenericRecyclerView genericRecyclerView = new GenericRecyclerView(new GenericRecyclerView.GenericRecyclerViewInterface() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusButtonFragment.6
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemViewType(int position) {
                return position;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RecyclerViewHolder(BloTrackStatusRvItemBinding.inflate(TrackStatusButtonFragment.this.getLayoutInflater()));
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public void onBindViewHolder(RecyclerViewHolder holder, int position) {
                ((BloTrackStatusRvItemBinding) holder.binding).stage.setText((CharSequence) TrackStatusButtonFragment.this.stageList8.get(position));
                try {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_round_highlight_off_24);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_tags_rounded_corners);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line));
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals(TrackStatusButtonFragment.this.formsubmittedStr) && TrackStatusButtonFragment.this.submitted.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    }
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals(TrackStatusButtonFragment.this.getBloAssignedStrin) && TrackStatusButtonFragment.this.bloAssigned.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    }
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals(TrackStatusButtonFragment.this.fvrVerifiedStr) && TrackStatusButtonFragment.this.fvrSubmitted.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    }
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals(TrackStatusButtonFragment.this.hearinScheduleStr) && TrackStatusButtonFragment.this.hearingScheduled.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    }
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals(TrackStatusButtonFragment.this.acceptedStr) && TrackStatusButtonFragment.this.accepted.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    }
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals(TrackStatusButtonFragment.this.acceptedStr) && TrackStatusButtonFragment.this.rejected.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                        if (TrackStatusButtonFragment.this.accepted.equals("Y")) {
                            ((BloTrackStatusRvItemBinding) holder.binding).stage.setText("Accepted");
                        } else {
                            ((BloTrackStatusRvItemBinding) holder.binding).stage.setText("Rejected");
                        }
                    }
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals("currentStatus")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).layout.setVisibility(8);
                    }
                } catch (Resources.NotFoundException e) {
                    Logger.d("logTag", e.getMessage());
                }
                if (position == TrackStatusButtonFragment.this.stageList8.size() - 2) {
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setVisibility(8);
                }
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemCount() {
                return TrackStatusButtonFragment.this.stageList8.size();
            }
        });
        this.fragmentTrackStatusButtonBinding.trackStatusBtnRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.fragmentTrackStatusButtonBinding.trackStatusBtnRv.setAdapter(genericRecyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRecyclerViewAdapter4() {
        GenericRecyclerView genericRecyclerView = new GenericRecyclerView(new GenericRecyclerView.GenericRecyclerViewInterface() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusButtonFragment.7
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemViewType(int position) {
                return position;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RecyclerViewHolder(BloTrackStatusRvItemBinding.inflate(TrackStatusButtonFragment.this.getLayoutInflater()));
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public void onBindViewHolder(RecyclerViewHolder holder, int position) {
                if (!((String) TrackStatusButtonFragment.this.stageList6.get(position)).equals("currentStatus")) {
                    ((BloTrackStatusRvItemBinding) holder.binding).stage.setText((CharSequence) TrackStatusButtonFragment.this.stageList8.get(position));
                } else {
                    ((BloTrackStatusRvItemBinding) holder.binding).stage.setText("Not Dispatched , Under Printing");
                }
                try {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_round_highlight_off_24);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_tags_rounded_corners);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line));
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals(TrackStatusButtonFragment.this.formsubmittedStr) && TrackStatusButtonFragment.this.submitted.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    }
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals(TrackStatusButtonFragment.this.getBloAssignedStrin) && TrackStatusButtonFragment.this.bloAssigned.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    }
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals(TrackStatusButtonFragment.this.fvrVerifiedStr) && TrackStatusButtonFragment.this.fvrSubmitted.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    }
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals(TrackStatusButtonFragment.this.hearinScheduleStr) && TrackStatusButtonFragment.this.hearingScheduled.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    }
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals(TrackStatusButtonFragment.this.acceptedStr) && TrackStatusButtonFragment.this.accepted.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    }
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals(TrackStatusButtonFragment.this.acceptedStr) && TrackStatusButtonFragment.this.rejected.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                        if (TrackStatusButtonFragment.this.accepted.equals("Y")) {
                            ((BloTrackStatusRvItemBinding) holder.binding).stage.setText("Accepted");
                        } else {
                            ((BloTrackStatusRvItemBinding) holder.binding).stage.setText("Rejected");
                        }
                    }
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals("currentStatus")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                        if (TrackStatusButtonFragment.this.status.equals("Not Dispatched , Under Printing")) {
                            ((BloTrackStatusRvItemBinding) holder.binding).stage.setText(TrackStatusButtonFragment.this.status);
                        } else {
                            ((BloTrackStatusRvItemBinding) holder.binding).stage.setText(TrackStatusButtonFragment.this.status);
                            ((BloTrackStatusRvItemBinding) holder.binding).epic.setText(TrackStatusButtonFragment.this.articleNumber);
                            ((BloTrackStatusRvItemBinding) holder.binding).click.setText("Click here to track");
                        }
                        ((BloTrackStatusRvItemBinding) holder.binding).click.setTextColor(-16776961);
                        ((BloTrackStatusRvItemBinding) holder.binding).click.setVisibility(0);
                        ((BloTrackStatusRvItemBinding) holder.binding).click.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusButtonFragment.7.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                TrackStatusButtonFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.indiapost.gov.in/_layouts/15/dop.portal.tracking/trackconsignment.aspx")));
                            }
                        });
                    }
                } catch (Resources.NotFoundException e) {
                    Logger.d("logTag", e.getMessage());
                }
                if (position == TrackStatusButtonFragment.this.stageList8.size() - 1) {
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setVisibility(8);
                }
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemCount() {
                return TrackStatusButtonFragment.this.stageList8.size();
            }
        });
        this.fragmentTrackStatusButtonBinding.trackStatusBtnRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.fragmentTrackStatusButtonBinding.trackStatusBtnRv.setAdapter(genericRecyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRecyclerViewAdapter5() {
        GenericRecyclerView genericRecyclerView = new GenericRecyclerView(new GenericRecyclerView.GenericRecyclerViewInterface() { // from class: in.gov.eci.bloapp.views.fragments.voterforms.trackstatus.TrackStatusButtonFragment.8
            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemViewType(int position) {
                return position;
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RecyclerViewHolder(BloTrackStatusRvItemBinding.inflate(TrackStatusButtonFragment.this.getLayoutInflater()));
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public void onBindViewHolder(RecyclerViewHolder holder, int position) {
                ((BloTrackStatusRvItemBinding) holder.binding).stage.setText((CharSequence) TrackStatusButtonFragment.this.stageList8.get(position));
                try {
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_round_highlight_off_24);
                    ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_tags_rounded_corners);
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line));
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals(TrackStatusButtonFragment.this.formsubmittedStr) && TrackStatusButtonFragment.this.submitted.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    }
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals(TrackStatusButtonFragment.this.getBloAssignedStrin) && TrackStatusButtonFragment.this.bloAssigned.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    }
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals(TrackStatusButtonFragment.this.fvrVerifiedStr) && TrackStatusButtonFragment.this.fvrSubmitted.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    }
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals(TrackStatusButtonFragment.this.hearinScheduleStr) && TrackStatusButtonFragment.this.hearingScheduled.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    }
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals(TrackStatusButtonFragment.this.acceptedStr) && TrackStatusButtonFragment.this.accepted.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                    }
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals(TrackStatusButtonFragment.this.acceptedStr) && TrackStatusButtonFragment.this.rejected.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                        if (TrackStatusButtonFragment.this.accepted.equals("Y")) {
                            ((BloTrackStatusRvItemBinding) holder.binding).stage.setText("Accepted");
                        } else {
                            ((BloTrackStatusRvItemBinding) holder.binding).stage.setText("Rejected");
                        }
                    }
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals(TrackStatusButtonFragment.this.acceptedStr) && TrackStatusButtonFragment.this.rejected.equals("Y")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setImageResource(R.drawable.blo_tick);
                        ((BloTrackStatusRvItemBinding) holder.binding).imageView.setBackgroundResource(R.drawable.blo_ellipse_request);
                        ((BloTrackStatusRvItemBinding) holder.binding).view1.setBackgroundColor(ContextCompat.getColor(TrackStatusButtonFragment.this.getContext(), R.color.blo_line_green));
                        ((BloTrackStatusRvItemBinding) holder.binding).stage.setText("Rejected");
                    }
                    if (((String) TrackStatusButtonFragment.this.stageList8.get(position)).equals("currentStatus")) {
                        ((BloTrackStatusRvItemBinding) holder.binding).layout.setVisibility(8);
                    }
                } catch (Resources.NotFoundException e) {
                    Logger.d("logTag", e.getMessage());
                }
                if (position == TrackStatusButtonFragment.this.stageList8.size() - 2) {
                    ((BloTrackStatusRvItemBinding) holder.binding).view1.setVisibility(8);
                }
            }

            @Override // in.gov.eci.bloapp.adapter.generic_adapter.GenericRecyclerView.GenericRecyclerViewInterface
            public int getItemCount() {
                return TrackStatusButtonFragment.this.stageList8.size();
            }
        });
        this.fragmentTrackStatusButtonBinding.trackStatusBtnRv.setLayoutManager(new GridLayoutManager(requireContext(), 1, 1, false));
        this.fragmentTrackStatusButtonBinding.trackStatusBtnRv.setAdapter(genericRecyclerView);
    }
}
