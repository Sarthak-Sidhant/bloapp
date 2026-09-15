package in.gov.eci.bloapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.JsonObject;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.api.ApiClient;
import in.gov.eci.bloapp.api.service.UserClient;
import in.gov.eci.bloapp.utils.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class DialogListAdapter extends BaseAdapter {
    private String atkband;
    Context context;
    ArrayList<Integer> id;
    LayoutInflater inflator;
    ArrayList<String> list;
    private onItemDeletedListener listener;
    private int mainPosition;
    ArrayList<String> name;
    private String rtkband;
    UserClient service;
    private String state;
    private String token;

    public interface onItemDeletedListener {
        void onItemDeleted(int mainPosition, int newCount);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public DialogListAdapter(Context context, ArrayList<String> list, ArrayList<String> name, ArrayList<Integer> id, String token, String state, String atkband, String rtkband, int mainPosition, onItemDeletedListener listener) {
        this.context = context;
        this.list = list;
        this.name = name;
        this.inflator = LayoutInflater.from(context);
        this.token = token;
        this.state = state;
        this.id = id;
        this.service = (UserClient) ApiClient.getClient(context).create(UserClient.class);
        this.atkband = atkband;
        this.rtkband = rtkband;
        this.mainPosition = mainPosition;
        this.listener = listener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.list.get(i);
    }

    static class ViewHolder {
        ImageView ivDelete;
        TextView textView;

        ViewHolder() {
        }
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.inflator.inflate(R.layout.view_progny_list_item, (ViewGroup) null);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) view.findViewById(R.id.tvProgenyEpic);
            viewHolder.ivDelete = (ImageView) view.findViewById(R.id.ivDelete);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(this.name.get(i));
        final int iIntValue = this.id.get(i).intValue();
        viewHolder.ivDelete.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.adapter.DialogListAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$getView$0(iIntValue, i, view2);
            }
        });
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getView$0(int i, int i2, View view) {
        deleteProgeny(i, i2, this.list.get(i2));
    }

    private void deleteProgeny(int iD, final int pos, String progenyEpic) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", this.token);
        map.put("currentRole", "blo");
        map.put("state", this.state);
        map.put("Content-Type", "application/json");
        map.put("atkn_bnd", this.atkband);
        map.put("rtkn_bnd", this.rtkband);
        map.put("channelidobo", "BLOAPP");
        HashMap map2 = new HashMap();
        map2.put("ccode", Integer.valueOf(iD));
        map2.put("progenyEpicNo", progenyEpic);
        this.service.deleteFromProgeny(map, map2).enqueue(new Callback<JsonObject>() { // from class: in.gov.eci.bloapp.adapter.DialogListAdapter.1
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }

            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (response.code() == 200) {
                        DialogListAdapter.this.list.remove(pos);
                        DialogListAdapter.this.id.remove(pos);
                        DialogListAdapter.this.name.remove(pos);
                        DialogListAdapter.this.notifyDataSetChanged();
                        if (DialogListAdapter.this.listener != null) {
                            DialogListAdapter.this.listener.onItemDeleted(DialogListAdapter.this.mainPosition, DialogListAdapter.this.list.size());
                        }
                        Toast.makeText(DialogListAdapter.this.context, String.valueOf(((JsonObject) response.body()).get("message")), 1).show();
                        return;
                    }
                    Toast.makeText(DialogListAdapter.this.context, String.valueOf(((JsonObject) response.body()).get("message")), 1).show();
                    return;
                }
                try {
                    if (response.errorBody() != null) {
                        Toast.makeText(DialogListAdapter.this.context, new JSONObject(response.errorBody().string()).optString("message"), 1).show();
                    }
                } catch (Exception e) {
                    Logger.d("Elector Mapping adapter", e.toString());
                }
            }
        });
    }
}
