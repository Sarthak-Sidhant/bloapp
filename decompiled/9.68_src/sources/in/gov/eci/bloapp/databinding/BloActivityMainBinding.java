package in.gov.eci.bloapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.navigation.NavigationView;
import in.gov.eci.bloapp.R;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public final class BloActivityMainBinding implements ViewBinding {
    public final DrawerLayout drawerLayout;
    public final NavigationView navView;
    private final DrawerLayout rootView;

    private BloActivityMainBinding(DrawerLayout rootView, DrawerLayout drawerLayout, NavigationView navView) {
        this.rootView = rootView;
        this.drawerLayout = drawerLayout;
        this.navView = navView;
    }

    public DrawerLayout getRoot() {
        return this.rootView;
    }

    public static BloActivityMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BloActivityMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.blo_activity_main, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BloActivityMainBinding bind(View rootView) {
        DrawerLayout drawerLayout = (DrawerLayout) rootView;
        NavigationView navigationViewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.nav_view);
        if (navigationViewFindChildViewById != null) {
            return new BloActivityMainBinding(drawerLayout, drawerLayout, navigationViewFindChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.nav_view)));
    }
}
