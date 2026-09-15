package in.gov.eci.bloapp.views.fragments.ContactUs;

import android.location.Geocoder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloFragmentContactusBinding;
import java.util.Locale;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class contactus extends Fragment {
    BloFragmentContactusBinding binding;
    String data = "https://www.google.com/maps/place/Nirvachan+Sadan/@28.6236842,77.2091338,17z/data=!3m1!4b1!4m5!3m4!1s0x390cfd4ca3fc509d:0xf06b0961a3ea7a51!8m2!3d28.623694!4d77.2113295";
    private GoogleMap mMap;
    private Marker marker;
    WebView webview;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentContactusBinding.inflate(getLayoutInflater());
        getChildFragmentManager().findFragmentById(R.id.map).getMapAsync(new OnMapReadyCallback() { // from class: in.gov.eci.bloapp.views.fragments.ContactUs.contactus.1
            public void onMapReady(GoogleMap googleMap) {
                contactus.this.mMap = googleMap;
                contactus.this.mMap.setMapType(1);
                LatLng latLng = new LatLng(28.6237782d, 77.210795d);
                contactus contactusVar = contactus.this;
                contactusVar.marker = contactusVar.mMap.addMarker(new MarkerOptions().position(latLng).title("Nirvachan Sadan"));
                contactus.this.mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15.0f));
                new Geocoder(contactus.this.getContext(), Locale.getDefault());
            }
        });
        return this.binding.getRoot();
    }
}
