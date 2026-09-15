package in.gov.eci.bloapp.views.customviews;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSpinner;
import in.gov.eci.bloapp.utils.Logger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class NoDefaultSpinner extends AppCompatSpinner {
    public NoDefaultSpinner(Context context) {
        super(context);
    }

    public NoDefaultSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoDefaultSpinner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setAdapter(SpinnerAdapter orig) {
        super.setAdapter(newProxy(orig));
        try {
            Method declaredMethod = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, -1);
            Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", Integer.TYPE);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(this, -1);
        } catch (Exception e) {
            Logger.d("NodefaultSpiunner", e.toString());
        }
    }

    protected SpinnerAdapter newProxy(SpinnerAdapter obj) {
        return (SpinnerAdapter) Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{SpinnerAdapter.class}, new SpinnerAdapterProxy(obj));
    }

    protected class SpinnerAdapterProxy implements InvocationHandler {
        protected Method getView;
        protected SpinnerAdapter obj;

        protected SpinnerAdapterProxy(SpinnerAdapter obj) {
            this.obj = obj;
            try {
                this.getView = SpinnerAdapter.class.getMethod("getView", Integer.TYPE, View.class, ViewGroup.class);
            } catch (Exception e) {
                Logger.d("NodefaultSpiunner", e.toString());
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
            try {
                if (m.equals(this.getView) && ((Integer) args[0]).intValue() < 0) {
                    return getView(((Integer) args[0]).intValue(), (View) args[1], (ViewGroup) args[2]);
                }
                return m.invoke(this.obj, args);
            } catch (IndexOutOfBoundsException e) {
                throw e.getCause();
            } catch (InvocationTargetException e2) {
                throw e2.getTargetException();
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            }
        }

        protected View getView(int position, View convertView, ViewGroup parent) throws IllegalAccessException {
            if (position < 0) {
                TextView textView = (TextView) ((LayoutInflater) NoDefaultSpinner.this.getContext().getSystemService("layout_inflater")).inflate(R.layout.simple_spinner_item, parent, false);
                textView.setText(NoDefaultSpinner.this.getPrompt());
                return textView;
            }
            return this.obj.getView(position, convertView, parent);
        }
    }
}
