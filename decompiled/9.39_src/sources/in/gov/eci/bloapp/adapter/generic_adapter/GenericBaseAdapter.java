package in.gov.eci.bloapp.adapter.generic_adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class GenericBaseAdapter extends BaseAdapter {
    private final GenericAdapterInterface genericAdapterInterface;

    public interface GenericAdapterInterface {
        int getCount();

        View getDropDownView(int position, View convertView, ViewGroup parent);

        Object getItem(int position);

        long getItemId(int position);

        View getView(int position, View convertView, ViewGroup parent);
    }

    public GenericBaseAdapter(GenericAdapterInterface genericAdapterInterface) {
        this.genericAdapterInterface = genericAdapterInterface;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.genericAdapterInterface.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.genericAdapterInterface.getItem(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.genericAdapterInterface.getItemId(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.genericAdapterInterface.getView(i, view, viewGroup);
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return this.genericAdapterInterface.getDropDownView(position, convertView, parent);
    }
}
