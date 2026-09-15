package in.gov.eci.bloapp.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.HomeItemBinding;
import in.gov.eci.bloapp.model.BloAppProfile;
import in.gov.eci.bloapp.views.activity.newsir.callback.HomeItemClickCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class HomeAdapter extends RecyclerView.Adapter<holder> {
    List<BloAppProfile> al;
    private Context context;
    List<BloAppProfile> filteredAl;
    HomeItemClickCallback itemClickCallback;

    public HomeAdapter(List<BloAppProfile> al, Context context, HomeItemClickCallback itemClickCallback) {
        this.al = al;
        this.context = context;
        this.filteredAl = new ArrayList(al);
        this.itemClickCallback = itemClickCallback;
    }

    public holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new holder(HomeItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    public void onBindViewHolder(final holder holder2, int i) {
        BloAppProfile bloAppProfile = this.al.get(i);
        if (!TextUtils.isEmpty(bloAppProfile.getGenderstatics()) && bloAppProfile.getGenderstatics().equalsIgnoreCase("Y")) {
            holder2.itemView.genderTV.setText(this.context.getResources().getString(R.string.gender_stats));
            holder2.itemView.ivCard.setImageDrawable(this.context.getResources().getDrawable(R.drawable.gender_statis));
            holder2.itemView.rectangleGender.setBackground(this.context.getResources().getDrawable(R.drawable.rectangle3_sir));
            holder2.itemView.cardView1.setVisibility(0);
        }
        if (!TextUtils.isEmpty(bloAppProfile.getFormstaticis()) && bloAppProfile.getFormstaticis().equalsIgnoreCase("Y")) {
            holder2.itemView.genderTV.setText(this.context.getResources().getString(R.string.form_stats));
            holder2.itemView.ivCard.setImageDrawable(this.context.getResources().getDrawable(R.drawable.form_statistics));
            holder2.itemView.rectangleGender.setBackground(this.context.getResources().getDrawable(R.drawable.rectangle4_sir));
            holder2.itemView.cardView1.setVisibility(0);
        }
        if (!TextUtils.isEmpty(bloAppProfile.getFacility()) && bloAppProfile.getFacility().equalsIgnoreCase("Y")) {
            holder2.itemView.genderTV.setText(this.context.getResources().getString(R.string.blo_home_facilities));
            holder2.itemView.ivCard.setImageDrawable(this.context.getResources().getDrawable(R.drawable.facilities));
            holder2.itemView.rectangleGender.setBackground(this.context.getResources().getDrawable(R.drawable.rectangle1_sir));
            holder2.itemView.cardView1.setVisibility(0);
        }
        if (!TextUtils.isEmpty(bloAppProfile.getChecklist()) && bloAppProfile.getChecklist().equalsIgnoreCase("Y")) {
            holder2.itemView.genderTV.setText(this.context.getResources().getString(R.string.field_verification));
            holder2.itemView.ivCard.setImageDrawable(this.context.getResources().getDrawable(R.drawable.feld_verification));
            holder2.itemView.rectangleGender.setBackground(this.context.getResources().getDrawable(R.drawable.rectangle2_sir));
            holder2.itemView.cardView1.setVisibility(0);
        }
        if (!TextUtils.isEmpty(bloAppProfile.getForms()) && bloAppProfile.getForms().equalsIgnoreCase("Y")) {
            holder2.itemView.genderTV.setText(this.context.getResources().getString(R.string.blo_home_form));
            holder2.itemView.ivCard.setImageDrawable(this.context.getResources().getDrawable(R.drawable.forms_new));
            holder2.itemView.rectangleGender.setBackground(this.context.getResources().getDrawable(R.drawable.rectangle3_sir));
            holder2.itemView.cardView1.setVisibility(0);
        }
        if (!TextUtils.isEmpty(bloAppProfile.getH2h()) && bloAppProfile.getH2h().equalsIgnoreCase("Y")) {
            holder2.itemView.genderTV.setText(this.context.getResources().getString(R.string.blo_home_h2h));
            holder2.itemView.ivCard.setImageDrawable(this.context.getResources().getDrawable(R.drawable.h_h_survey));
            holder2.itemView.rectangleGender.setBackground(this.context.getResources().getDrawable(R.drawable.rectangle4_sir));
            holder2.itemView.cardView1.setVisibility(0);
        }
        if (!TextUtils.isEmpty(bloAppProfile.getBloRegister()) && bloAppProfile.getBloRegister().equalsIgnoreCase("Y")) {
            holder2.itemView.genderTV.setText(this.context.getResources().getString(R.string.blo_register));
            holder2.itemView.ivCard.setImageDrawable(this.context.getResources().getDrawable(R.drawable.blo_register));
            holder2.itemView.rectangleGender.setBackground(this.context.getResources().getDrawable(R.drawable.rectangle2_sir));
            holder2.itemView.cardView1.setVisibility(0);
        }
        if (!TextUtils.isEmpty(bloAppProfile.getDes()) && bloAppProfile.getDes().equalsIgnoreCase("Y")) {
            holder2.itemView.genderTV.setText(this.context.getResources().getString(R.string.blo_home_dse));
            holder2.itemView.ivCard.setImageDrawable(this.context.getResources().getDrawable(R.drawable.dse_new));
            holder2.itemView.rectangleGender.setBackground(this.context.getResources().getDrawable(R.drawable.rectangle1_sir));
            holder2.itemView.cardView1.setVisibility(0);
        }
        if (!TextUtils.isEmpty(bloAppProfile.getPse()) && bloAppProfile.getPse().equalsIgnoreCase("Y")) {
            holder2.itemView.genderTV.setText(this.context.getResources().getString(R.string.blo_home_pse));
            holder2.itemView.ivCard.setImageDrawable(this.context.getResources().getDrawable(R.drawable.pse_new));
            holder2.itemView.rectangleGender.setBackground(this.context.getResources().getDrawable(R.drawable.rectangle3_sir));
            holder2.itemView.cardView1.setVisibility(0);
        }
        if (!TextUtils.isEmpty(bloAppProfile.getBookacall()) && bloAppProfile.getBookacall().equalsIgnoreCase("Y")) {
            holder2.itemView.genderTV.setText(this.context.getResources().getString(R.string.book_a_call));
            holder2.itemView.ivCard.setImageDrawable(this.context.getResources().getDrawable(R.drawable.book_call));
            holder2.itemView.rectangleGender.setBackground(this.context.getResources().getDrawable(R.drawable.rectangle1_sir));
            holder2.itemView.cardView1.setVisibility(0);
        }
        if (!TextUtils.isEmpty(bloAppProfile.getSpecialRevision()) && bloAppProfile.getSpecialRevision().equalsIgnoreCase("Y")) {
            holder2.itemView.genderTV.setText(this.context.getResources().getString(R.string.special_creation));
            holder2.itemView.ivCard.setImageDrawable(this.context.getResources().getDrawable(R.drawable.sir_new));
            holder2.itemView.rectangleGender.setBackground(this.context.getResources().getDrawable(R.drawable.rectangle2_sir));
            holder2.itemView.cardView1.setVisibility(0);
        }
        if (!TextUtils.isEmpty(bloAppProfile.getElectorMapping()) && bloAppProfile.getElectorMapping().equalsIgnoreCase("Y")) {
            holder2.itemView.genderTV.setText(this.context.getResources().getString(R.string.home_elector_mapping));
            holder2.itemView.ivCard.setImageDrawable(this.context.getResources().getDrawable(R.drawable.electors_no_mapping));
            holder2.itemView.rectangleGender.setBackground(this.context.getResources().getDrawable(R.drawable.rectangle3_sir));
            holder2.itemView.cardView1.setVisibility(0);
        }
        if (!TextUtils.isEmpty(bloAppProfile.getDseActivity()) && bloAppProfile.getDseActivity().equalsIgnoreCase("Y")) {
            holder2.itemView.genderTV.setText("DSE Verification");
            holder2.itemView.ivCard.setImageDrawable(this.context.getResources().getDrawable(R.drawable.dse));
            holder2.itemView.rectangleGender.setBackground(this.context.getResources().getDrawable(R.drawable.rectangle3_sir));
            holder2.itemView.cardView1.setVisibility(0);
        }
        if (!TextUtils.isEmpty(bloAppProfile.getSelectPhoto()) && bloAppProfile.getSelectPhoto().equalsIgnoreCase("Y")) {
            holder2.itemView.genderTV.setText(this.context.getResources().getString(R.string.select_photo));
            holder2.itemView.ivCard.setImageDrawable(this.context.getResources().getDrawable(R.drawable.select_photo));
            holder2.itemView.rectangleGender.setBackground(this.context.getResources().getDrawable(R.drawable.rectangle3_sir));
            holder2.itemView.cardView1.setVisibility(0);
        }
        if (!TextUtils.isEmpty(bloAppProfile.getBla()) && bloAppProfile.getBla().equalsIgnoreCase("Y")) {
            holder2.itemView.genderTV.setText(this.context.getResources().getString(R.string.bla));
            holder2.itemView.ivCard.setImageDrawable(this.context.getResources().getDrawable(R.drawable.bla_creation));
            holder2.itemView.rectangleGender.setBackground(this.context.getResources().getDrawable(R.drawable.rectangle3_sir));
            holder2.itemView.cardView1.setVisibility(0);
        }
        if (!TextUtils.isEmpty(bloAppProfile.getFormatC()) && bloAppProfile.getFormatC().equalsIgnoreCase("Y")) {
            holder2.itemView.genderTV.setText(this.context.getResources().getString(R.string.format_c));
            holder2.itemView.ivCard.setImageDrawable(this.context.getResources().getDrawable(R.drawable.select_photo));
            holder2.itemView.rectangleGender.setBackground(this.context.getResources().getDrawable(R.drawable.rectangle3_sir));
            holder2.itemView.cardView1.setVisibility(0);
        }
        if (!TextUtils.isEmpty(bloAppProfile.getWebLogin()) && bloAppProfile.getWebLogin().equalsIgnoreCase("Y")) {
            holder2.itemView.genderTV.setText(this.context.getResources().getString(R.string.weblogin_homeIcon));
            holder2.itemView.ivCard.setImageDrawable(this.context.getResources().getDrawable(R.drawable.web_login_icon));
            holder2.itemView.rectangleGender.setBackground(this.context.getResources().getDrawable(R.drawable.rectangle1_sir));
            holder2.itemView.cardView1.setVisibility(0);
        }
        holder2.itemView.cardView1.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.HomeAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                HomeAdapter.this.itemClickCallback.onClicked(HomeAdapter.this.al.get(holder2.getAdapterPosition()), "click");
            }
        });
    }

    public int getItemCount() {
        return this.al.size();
    }

    class holder extends RecyclerView.ViewHolder {
        HomeItemBinding itemView;

        public holder(HomeItemBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }
    }

    public void fun(ArrayList<BloAppProfile> filteredAl) {
        this.al = filteredAl;
        notifyDataSetChanged();
    }
}
