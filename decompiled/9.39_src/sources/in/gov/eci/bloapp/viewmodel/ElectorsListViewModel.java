package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.gov.eci.bloapp.model.electors_list.ElectorsListModel;
import in.gov.eci.bloapp.repository.ElectorsListRepository;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ElectorsListViewModel extends ViewModel {
    ElectorsListRepository electorsListRepository;
    MutableLiveData<ElectorsListModel.getEpicList.Root> getEpicListLiveData = new MutableLiveData<>();
    MutableLiveData<ElectorsListModel.getEpicDetails.Root> getEpicDetailsLiveData = new MutableLiveData<>();

    @Inject
    public ElectorsListViewModel(ElectorsListRepository electorsListRepository) {
        this.electorsListRepository = electorsListRepository;
    }

    public MutableLiveData<ElectorsListModel.getEpicList.Root> getEpicList() {
        return this.getEpicListLiveData;
    }

    public MutableLiveData<ElectorsListModel.getEpicDetails.Root> getEpicDetails() {
        return this.getEpicDetailsLiveData;
    }

    public void getEpicList(String token, String currentRole, String state, String acNo, String partNumber) {
        this.electorsListRepository.getEpicList(token, currentRole, state, acNo, partNumber, this.getEpicListLiveData);
    }
}
