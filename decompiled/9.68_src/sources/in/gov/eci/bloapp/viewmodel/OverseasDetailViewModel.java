package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.gov.eci.bloapp.model.app_model.FormsinDraftOverseasModel;
import in.gov.eci.bloapp.repository.OverseasDetailsRepository;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class OverseasDetailViewModel extends ViewModel {
    public LiveData<List<FormsinDraftOverseasModel>> data;
    public MutableLiveData<List<FormsinDraftOverseasModel>> dataMutable;
    public OverseasDetailsRepository requestWheelchairRepository;

    @Inject
    public OverseasDetailViewModel(OverseasDetailsRepository requestWheelchairRepository) {
        MutableLiveData<List<FormsinDraftOverseasModel>> mutableLiveData = new MutableLiveData<>();
        this.dataMutable = mutableLiveData;
        this.data = mutableLiveData;
        this.requestWheelchairRepository = requestWheelchairRepository;
    }

    public void insertData(String refe) {
        this.requestWheelchairRepository.insertData(refe);
    }

    public void insertforms(String name, String insertState, String personal, int seq, String formtype, String referencenumber, String createdon, String img) {
        this.requestWheelchairRepository.insertforms(name, insertState, personal, seq, formtype, referencenumber, createdon, img);
    }

    public void updateresidence(String referencenumber, String residence, int seq) {
        this.requestWheelchairRepository.updateresidence(referencenumber, residence, seq);
    }

    public void updatepassport(String referencenumber, String passport, int seq, String passprtpdf) {
        this.requestWheelchairRepository.updatepassport(referencenumber, passport, seq, passprtpdf);
    }

    public void updateVisa(String referencenumber, String visa, int seq) {
        this.requestWheelchairRepository.updateVisa(referencenumber, visa, seq);
    }

    public void updateordinary(String referencenumber, String visa, int seq) {
        this.requestWheelchairRepository.updateordinary(referencenumber, visa, seq);
    }

    public void updateoutsideIndia(String referencenumber, String outsideindia, int seq) {
        this.requestWheelchairRepository.updateoutsideIndia(referencenumber, outsideindia, seq);
    }

    public LiveData<List<FormsinDraftOverseasModel>> dataoneditbutton(String name, String date, String formtype) {
        LiveData<List<FormsinDraftOverseasModel>> liveDataDataoneditbutton = this.requestWheelchairRepository.dataoneditbutton(name, date, formtype);
        this.data = liveDataDataoneditbutton;
        return liveDataDataoneditbutton;
    }

    public void updatedeclaration(String referencenumber, String declaration, int i) {
        this.requestWheelchairRepository.updatedeclaration(referencenumber, declaration, i);
    }

    public void updatepersonal(String name, String personal, String referencenumber, int i, String photoref, String date) {
        this.requestWheelchairRepository.updatepersonal(name, personal, referencenumber, i, photoref, date);
    }
}
