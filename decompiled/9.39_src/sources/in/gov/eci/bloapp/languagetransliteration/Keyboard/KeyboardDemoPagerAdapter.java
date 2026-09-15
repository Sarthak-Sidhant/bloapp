package in.gov.eci.bloapp.languagetransliteration.Keyboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class KeyboardDemoPagerAdapter extends PagerAdapter {
    private final Context context;
    private final int[] imageList;

    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public KeyboardDemoPagerAdapter(Context context, int[] imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    public int getCount() {
        return this.imageList.length;
    }

    public Object instantiateItem(ViewGroup container, final int position) {
        View viewInflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.blo_layout_viewpager, (ViewGroup) null);
        viewInflate.findViewById(R.id.imageView).setVisibility(8);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.imageViewAnother);
        imageView.setVisibility(0);
        imageView.setImageResource(this.imageList[position]);
        ((ViewPager) container).addView(viewInflate, 0);
        return viewInflate;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }
}
