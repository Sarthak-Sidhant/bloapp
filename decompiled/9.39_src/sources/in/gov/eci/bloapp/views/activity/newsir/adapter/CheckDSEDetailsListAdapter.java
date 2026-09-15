package in.gov.eci.bloapp.views.activity.newsir.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.utils.Logger;
import in.gov.eci.bloapp.utils.RegexMatcher;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.newsir.model.CheckDSEDetailsPayload;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class CheckDSEDetailsListAdapter extends RecyclerView.Adapter<holder> {
    private String acNo;
    List<CheckDSEDetailsPayload> al;
    private String atkband;
    CommomUtility commonUtilClass = new CommomUtility();
    private Context context;
    private String encodedImage;
    List<CheckDSEDetailsPayload> filteredAl;
    private OnItemSelectedListener listener;
    private String partNo;
    private String rtkband;
    private String token;

    public interface OnItemSelectedListener {
        void onItemSelected();
    }

    public CheckDSEDetailsListAdapter(List<CheckDSEDetailsPayload> al, Context context, OnItemSelectedListener listener) {
        this.al = al;
        this.context = context;
        this.filteredAl = new ArrayList(al);
        this.token = SharedPref.getInstance(context).getToken();
        this.atkband = SharedPref.getInstance(context).getAtknBnd();
        this.rtkband = SharedPref.getInstance(context).getRtknBnd();
        this.acNo = SharedPref.getInstance(context).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(context).getPartNumber();
        this.listener = listener;
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.check_dse_items, viewGroup, false));
    }

    public void onBindViewHolder(final holder holder2, int i) {
        holder2.icon.setImageResource(this.al.get(i).isSelected() ? R.drawable.inactive_radio : R.drawable.active_radio);
        holder2.epic_no.setText(this.context.getResources().getString(R.string.epic_no) + " " + this.al.get(i).getEpicNumber());
        holder2.AC_partNO.setText("AC No : " + this.al.get(i).getAcNumber());
        holder2.acno_name.setText("AC Name : " + (TextUtils.isEmpty(this.al.get(i).getAsmblyName()) ? "" : this.al.get(i).getAsmblyName()));
        holder2.parnumber.setText("Part No : " + String.valueOf(this.al.get(i).getPartNumber()));
        if (this.al.get(i).getLocalityStreet() == null) {
            this.al.get(i).setLocalityStreet("");
        }
        if (this.al.get(i).getTownVillage() == null) {
            this.al.get(i).setTownVillage("");
        }
        String str = this.al.get(i).getHouseNumber() + " " + this.al.get(i).getLocalityStreet() + " " + this.al.get(i).getTownVillage();
        holder2.address_et.setText("Address : " + (TextUtils.isEmpty(str) ? "" : str));
        if (this.al.get(i).getPhoto() != null) {
            this.commonUtilClass.getRetrofitClient(this.context, this.token, this.atkband, this.rtkband).getFile("objectstorage", this.al.get(i).getPhoto(), this.token, this.atkband, this.rtkband, "BLOAPP", "blo", "BLOAPP", "ANDROIDMOB").enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.CheckDSEDetailsListAdapter.1
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    if (response.code() == 200) {
                        ((JsonObject) response.body()).get("file");
                        CheckDSEDetailsListAdapter.this.encodedImage = ((JsonObject) response.body()).get("file").toString().replace(RegexMatcher.JSON_STRING_REGEX, "");
                        if (CheckDSEDetailsListAdapter.this.encodedImage == null) {
                            holder2.imageView9.setImageBitmap(BitmapFactory.decodeResource(CheckDSEDetailsListAdapter.this.context.getResources(), R.drawable.blo_dummy_image));
                        } else {
                            byte[] bArrDecode = Base64.decode(CheckDSEDetailsListAdapter.this.encodedImage, 0);
                            holder2.imageView9.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                        }
                    }
                }

                public void onFailure(Call<JsonObject> call, Throwable t) {
                    Logger.d("COMING_IN_ON_FAILURE", t.getMessage());
                }
            });
        } else {
            holder2.imageView9.setImageBitmap(BitmapFactory.decodeResource(this.context.getResources(), R.drawable.blo_dummy_image));
        }
        if (this.partNo.equalsIgnoreCase(String.valueOf(this.al.get(i).getPartNumber())) && this.acNo.equals(String.valueOf(this.al.get(i).getAcNumber()))) {
            holder2.layout.setBackgroundColor(Color.parseColor("#C9F2FF"));
        } else {
            holder2.layout.setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }

    public int getItemCount() {
        return this.al.size();
    }

    class holder extends RecyclerView.ViewHolder {
        TextView AC_partNO;
        TextView Serial_No_tv;
        TextView acno_name;
        LinearLayout actionToken_layout;
        TextView address_et;
        TextView address_tv;
        TextView epic_no;
        ImageView icon;
        ImageView imageView9;
        LinearLayout layout;
        TextView parnumber;

        public holder(View itemView) {
            super(itemView);
            this.icon = (ImageView) itemView.findViewById(2131364119);
            this.epic_no = (TextView) itemView.findViewById(R.id.epic_no);
            this.AC_partNO = (TextView) itemView.findViewById(R.id.AC_partNO);
            this.address_et = (TextView) itemView.findViewById(R.id.address_et);
            this.address_tv = (TextView) itemView.findViewById(R.id.address_tv);
            this.acno_name = (TextView) itemView.findViewById(R.id.acno_name);
            this.parnumber = (TextView) itemView.findViewById(R.id.parnumber);
            this.actionToken_layout = (LinearLayout) itemView.findViewById(R.id.actionToken_layout);
            this.layout = (LinearLayout) itemView.findViewById(2131364291);
            this.imageView9 = (ImageView) itemView.findViewById(R.id.imageView9);
            itemView.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.activity.newsir.adapter.CheckDSEDetailsListAdapter$holder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            int i = 0;
            while (true) {
                if (i >= CheckDSEDetailsListAdapter.this.al.size()) {
                    i = -1;
                    break;
                } else {
                    if (CheckDSEDetailsListAdapter.this.al.get(i).isSelected()) {
                        CheckDSEDetailsListAdapter.this.al.get(i).setSelected(false);
                        break;
                    }
                    i++;
                }
            }
            CheckDSEDetailsListAdapter.this.al.get(getAdapterPosition()).setSelected(true);
            if (i != -1) {
                CheckDSEDetailsListAdapter.this.notifyItemChanged(i);
            }
            CheckDSEDetailsListAdapter.this.notifyItemChanged(getAdapterPosition());
            CheckDSEDetailsListAdapter.this.listener.onItemSelected();
        }
    }

    public void fun(ArrayList<CheckDSEDetailsPayload> filteredAl) {
        this.al = filteredAl;
        notifyDataSetChanged();
    }
}
