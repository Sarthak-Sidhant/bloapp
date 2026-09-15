package in.gov.eci.bloapp.views.activity.newsir.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.CommomUtility;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.utils.SharedPref;
import in.gov.eci.bloapp.views.activity.newsir.callback.PSEItemClickCallback;
import in.gov.eci.bloapp.views.activity.newsir.model.PSEClusterDetailsPayload;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class PSEClusterDetailsListAdapter extends RecyclerView.Adapter<holder> {
    private String acNo;
    List<PSEClusterDetailsPayload> al;
    private String atkband;
    CommomUtility commonUtilClass = new CommomUtility();
    private Context context;
    private String encodedImage;
    List<PSEClusterDetailsPayload> filteredAl;
    PSEItemClickCallback itemClickCallback;
    private String partNo;
    private String rtkband;
    private String token;

    public PSEClusterDetailsListAdapter(List<PSEClusterDetailsPayload> al, Context context, PSEItemClickCallback itemClickCallback) {
        this.al = al;
        this.context = context;
        this.filteredAl = new ArrayList(al);
        this.itemClickCallback = itemClickCallback;
        this.token = SharedPref.getInstance(context).getToken();
        this.atkband = SharedPref.getInstance(context).getAtknBnd();
        this.rtkband = SharedPref.getInstance(context).getRtknBnd();
        this.acNo = SharedPref.getInstance(context).getAssemblyNumber();
        this.partNo = SharedPref.getInstance(context).getPartNumber();
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pse_cluster_items, viewGroup, false));
    }

    public void onBindViewHolder(holder holder2, int i) {
        holder2.electorNametv.setText((TextUtils.isEmpty(this.al.get(i).getFirstName()) ? "" : this.al.get(i).getFirstName()) + StringUtils.SPACE + (TextUtils.isEmpty(this.al.get(i).getLastName()) ? "" : this.al.get(i).getLastName()));
        holder2.imageView9.setImageResource(R.drawable.blo_dummy_image);
        byte[] imageBytes = this.al.get(i).getImageBytes();
        if (imageBytes != null && imageBytes.length > 0) {
            holder2.imageView9.setImageBitmap(BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length));
        }
        holder2.Serial_No_tv.setText(this.context.getResources().getString(R.string.serial_no) + StringUtils.SPACE + String.valueOf(this.al.get(i).getSlnoInPart()));
        holder2.epic_no.setText(this.context.getResources().getString(R.string.epic_no) + StringUtils.SPACE + this.al.get(i).getEpicNo());
        holder2.AC_partNO.setText("AC No & AC Name : ");
        holder2.parnumber.setText("Part No : " + String.valueOf(this.al.get(i).getPartNo()));
        holder2.acno_name.setText(String.valueOf(this.al.get(i).getAcNo()) + " & " + (TextUtils.isEmpty(this.al.get(i).getAsmblyName()) ? "" : this.al.get(i).getAsmblyName()));
        holder2.address_et.setText("Address : " + (TextUtils.isEmpty(this.al.get(i).getAddress()) ? "" : this.al.get(i).getAddress()));
        if (!TextUtils.isEmpty(this.al.get(i).getIsUncollectable()) && this.al.get(i).getIsUncollectable().equalsIgnoreCase("Y")) {
            holder2.lv_watermark.setVisibility(0);
        } else {
            holder2.lv_watermark.setVisibility(4);
        }
        if (this.partNo.equalsIgnoreCase(String.valueOf(this.al.get(i).getPartNo())) && this.acNo.equals(String.valueOf(this.al.get(i).getAcNo()))) {
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
        TextView electorNametv;
        TextView epic_no;
        ImageView imageView9;
        ImageView iv_uncollectable;
        ConstraintLayout layout;
        LinearLayout lv_watermark;
        TextView parnumber;

        public holder(View itemView) {
            super(itemView);
            this.Serial_No_tv = (TextView) itemView.findViewById(R.id.Serial_No_tv);
            this.epic_no = (TextView) itemView.findViewById(R.id.epic_no);
            this.AC_partNO = (TextView) itemView.findViewById(R.id.AC_partNO);
            this.address_et = (TextView) itemView.findViewById(R.id.address_et);
            this.address_tv = (TextView) itemView.findViewById(R.id.address_tv);
            this.acno_name = (TextView) itemView.findViewById(R.id.acno_name);
            this.parnumber = (TextView) itemView.findViewById(R.id.parnumber);
            this.electorNametv = (TextView) itemView.findViewById(R.id.electorNametv);
            this.actionToken_layout = (LinearLayout) itemView.findViewById(R.id.actionToken_layout);
            this.lv_watermark = (LinearLayout) itemView.findViewById(R.id.lv_watermark);
            this.layout = itemView.findViewById(2131364428);
            this.imageView9 = (ImageView) itemView.findViewById(R.id.imageView9);
        }
    }

    public void fun(ArrayList<PSEClusterDetailsPayload> filteredAl) {
        this.al = filteredAl;
        notifyDataSetChanged();
    }
}
