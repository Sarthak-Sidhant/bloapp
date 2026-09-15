package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.gov.eci.bloapp.model.app_model.FormsinDraftMigrationModel;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.repository.MigrationRepository;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class PreviewEpicViewModel extends ViewModel {
    public MutableLiveData<List<FormsinDraftMigrationModel>> _data;

    @Inject
    ApiInterface apiInterface;
    public LiveData<List<FormsinDraftMigrationModel>> data;
    public MigrationRepository migrationRepository;

    @Inject
    public PreviewEpicViewModel(MigrationRepository migrationRepository) {
        MutableLiveData<List<FormsinDraftMigrationModel>> mutableLiveData = new MutableLiveData<>();
        this._data = mutableLiveData;
        this.data = mutableLiveData;
        this.migrationRepository = migrationRepository;
    }

    public void insertforms(String name, String insertState, String personal, int seq, String formtype, String reference_number, String created_on, String formGeneratedfor, String epicNumber) {
        this.migrationRepository.insertforms(name, insertState, personal, seq, formtype, reference_number, created_on, formGeneratedfor, epicNumber);
    }

    public void updateapplicationCOE(String reference_number, String application, int seq, boolean cb1, boolean cb2, boolean cb3, boolean cb4, boolean cb5, boolean cb6, boolean cb7, boolean cb8, String img1, String img2, String img3, String img4, String img5, String img6, String img8) {
        this.migrationRepository.updateapplicationCOE(reference_number, application, seq, cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, img1, img2, img3, img4, img5, img6, img8);
    }

    public LiveData<List<FormsinDraftMigrationModel>> dataoneditbutton(String name, String date, String formtype) {
        LiveData<List<FormsinDraftMigrationModel>> liveDataDataoneditbutton = this.migrationRepository.dataoneditbutton(name, date, formtype);
        this.data = liveDataDataoneditbutton;
        return liveDataDataoneditbutton;
    }
}
