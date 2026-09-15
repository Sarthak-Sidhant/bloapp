package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.gov.eci.bloapp.model.app_model.DeletionObjectionDraftModel;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.DeletionObjectionRepository;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class DeletionObjectionViewModel extends ViewModel {

    @Inject
    ApiInterface apiInterface;
    LiveData<List<DeletionObjectionDraftModel>> data;
    DeletionObjectionRepository deletionObjectionRepository;
    MutableLiveData<List<DeletionObjectionDraftModel>> editData;

    @Inject
    public DeletionObjectionViewModel(DeletionObjectionRepository deletionObjectionRepository) {
        MutableLiveData<List<DeletionObjectionDraftModel>> mutableLiveData = new MutableLiveData<>();
        this.editData = mutableLiveData;
        this.data = mutableLiveData;
        this.deletionObjectionRepository = deletionObjectionRepository;
    }

    public void updateData(String objectionOptions, String objectionOptionsSubcategory, String epic, String declarationdate, String declarationplace, byte[] photo, String referenceNo, String createdOn, String status, String requestType) {
        this.deletionObjectionRepository.updateData(objectionOptions, objectionOptionsSubcategory, epic, declarationdate, declarationplace, photo, referenceNo, createdOn, status, requestType);
    }

    public void insertforms(String name, String insertState, String personal, int seq, String formtype, String reference_number, String createdOn, String formOrigin, String epicNumber) {
        this.deletionObjectionRepository.insertforms(name, insertState, personal, seq, formtype, reference_number, createdOn, formOrigin, epicNumber);
    }

    public void updatepersonaldetails(String referenceNumber, String personalDetails, int seq) {
        this.deletionObjectionRepository.updatepersonaldetails(referenceNumber, personalDetails, seq);
    }

    public void updaterejectionoptions(String referenceNumber, String rejectionOptions, String deathcertiAttach, byte[] photo, int seq) {
        this.deletionObjectionRepository.updaterejectionoptions(referenceNumber, rejectionOptions, deathcertiAttach, photo, seq);
    }

    public void updaterequestraisedetails(String referenceNumber, String requestDetails, int seq) {
        this.deletionObjectionRepository.updaterequestraisedetails(referenceNumber, requestDetails, seq);
    }

    public LiveData<List<DeletionObjectionDraftModel>> dataoneditbutton(String name, String date, String formtype) {
        LiveData<List<DeletionObjectionDraftModel>> liveDataDataoneditbutton = this.deletionObjectionRepository.dataoneditbutton(name, date, formtype);
        this.data = liveDataDataoneditbutton;
        return liveDataDataoneditbutton;
    }
}
