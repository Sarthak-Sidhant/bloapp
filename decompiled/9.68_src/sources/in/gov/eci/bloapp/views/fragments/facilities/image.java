package in.gov.eci.bloapp.views.fragments.facilities;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import in.gov.eci.bloapp.R;
import in.gov.eci.bloapp.databinding.BloFragmentImageBinding;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class image extends Fragment {
    BloFragmentImageBinding binding;
    private String img;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = BloFragmentImageBinding.inflate(getLayoutInflater());
        this.img = getArguments().getString("uri");
        this.binding.image.setImageURI(Uri.parse(this.img));
        this.binding.button.setOnClickListener(new View.OnClickListener() { // from class: in.gov.eci.bloapp.views.fragments.facilities.image.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                image.this.openFragment(new Facilities());
            }
        });
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFragment(Fragment fragment) {
        Bundle bundle = new Bundle();
        bundle.putString("uri", this.img);
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransactionBeginTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.frame1, fragment);
        fragmentTransactionBeginTransaction.setTransition(4097);
        fragmentTransactionBeginTransaction.commit();
    }
}
