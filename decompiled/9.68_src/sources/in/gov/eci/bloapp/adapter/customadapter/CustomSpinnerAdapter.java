package in.gov.eci.bloapp.adapter.customadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class CustomSpinnerAdapter extends ArrayAdapter {
    public CustomSpinnerAdapter(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        view.setPadding(0, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        return view;
    }
}
