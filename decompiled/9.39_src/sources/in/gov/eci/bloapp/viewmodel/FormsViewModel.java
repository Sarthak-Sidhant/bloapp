package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.ViewModel;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.FormsRepo;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class FormsViewModel extends ViewModel {

    @Inject
    ApiInterface apiInterface;
    public FormsRepo repo;

    @Inject
    public FormsViewModel(FormsRepo repo) {
        this.repo = repo;
    }

    public void updateaadhar(String houseno, String streetno, String village, String postoffice, String pincode, String teshil, String referenceno, String formtype) {
        this.repo.updateaadhar(houseno, streetno, village, postoffice, pincode, teshil, referenceno, formtype);
    }
}
