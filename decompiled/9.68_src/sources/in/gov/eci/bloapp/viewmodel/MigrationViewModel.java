package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.gov.eci.bloapp.model.app_model.FormsinDraftMigrationModel;
import in.gov.eci.bloapp.repository.MigrationRepository;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class MigrationViewModel extends ViewModel {
    public MutableLiveData<List<FormsinDraftMigrationModel>> _data;
    public LiveData<List<FormsinDraftMigrationModel>> data;
    public MigrationRepository migrationRepository;

    @Inject
    public MigrationViewModel(MigrationRepository migrationRepository) {
        MutableLiveData<List<FormsinDraftMigrationModel>> mutableLiveData = new MutableLiveData<>();
        this._data = mutableLiveData;
        this.data = mutableLiveData;
        this.migrationRepository = migrationRepository;
    }

    public boolean isFormExists(String referencenumber) {
        return this.migrationRepository.isFormExists(referencenumber);
    }

    public void insertforms(String name, String insertState, String personal, int seq, String formtype, String referenceNumber, String created_on, String formGeneratedfor, String epicNumber) {
        this.migrationRepository.insertforms(name, insertState, personal, seq, formtype, referenceNumber, created_on, formGeneratedfor, epicNumber);
    }

    public void updatepersonalpage(String referenceNumber, String application, int stepseq) {
        this.migrationRepository.updatepersonalpage(referenceNumber, application, stepseq);
    }

    public void updateapplicationSOR(String referenceNumber, String application, int seq, String img) {
        this.migrationRepository.updateapplicationSOR(referenceNumber, application, seq, img);
    }

    public void updateapplicationROM(String referenceNumber, String application, int seq, boolean DISATTACHMENT, String img) {
        this.migrationRepository.updateapplicationROM(referenceNumber, application, seq, DISATTACHMENT, img);
    }

    public void updateapplicationIOR(String referenceNumber, String application, int seq, boolean LOSTATTACHMENT, String img) {
        this.migrationRepository.updateapplicationIOR(referenceNumber, application, seq, LOSTATTACHMENT, img);
    }

    public void updateapplicationCOE(String referenceNumber, String application, int seq, boolean cb1, boolean cb2, boolean cb3, boolean cb4, boolean cb5, boolean cb6, boolean cb7, boolean cb8, String img1, String img2, String img3, String img4, String img5, String img6, String img8) {
        this.migrationRepository.updateapplicationCOE(referenceNumber, application, seq, cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, img1, img2, img3, img4, img5, img6, img8);
    }

    public LiveData<List<FormsinDraftMigrationModel>> dataoneditbutton(String name, String date, String formtype) {
        LiveData<List<FormsinDraftMigrationModel>> liveDataDataoneditbutton = this.migrationRepository.dataoneditbutton(name, date, formtype);
        this.data = liveDataDataoneditbutton;
        return liveDataDataoneditbutton;
    }

    public void updateAnnexureD(String referencenumber, String citizenshipType, String citizenshipTypeCat, String ctDocTypeForSelf, String ctDocOfSelfUrl, int stepSeqence, String doctypeselfFileName, String doctypeselFileSize, String before2004ParentType, String doctypeFather, String doctypeMother, String docURLFather, String docURLMother, String before2004docFileName, String before2004docFileSize, String after2004isParentIndian, String after2004ParentNameNotindian, String after2004doctypeFather, String after2004doctypeMother, String after2004docURLFather, String after2004docURLMother, String after2004MotherFileName, String after2004MotherFileSize, String after2004FatherFileName, String after2004FatherFileSize, String bornOutofIndiadoctype, String bornOutofIndiadocURL, String bornOutofIndiaFileName, String bornOutofIndiaFileSize, String citizenAquuireddoctype, String citizenAquuireddocURL, String citizenAquuiredFileName, String citizenAquuiredFileSize, String annexuresignatureURL, String anexSignFileName, String anexSignFileSize, String isOtherState) {
        this.migrationRepository.updateAnnexureD(referencenumber, citizenshipType, citizenshipTypeCat, ctDocTypeForSelf, ctDocOfSelfUrl, stepSeqence, doctypeselfFileName, doctypeselFileSize, before2004ParentType, doctypeFather, doctypeMother, docURLFather, docURLMother, before2004docFileName, before2004docFileSize, after2004isParentIndian, after2004ParentNameNotindian, after2004doctypeFather, after2004doctypeMother, after2004docURLFather, after2004docURLMother, after2004MotherFileName, after2004MotherFileSize, after2004FatherFileName, after2004FatherFileSize, bornOutofIndiadoctype, bornOutofIndiadocURL, bornOutofIndiaFileName, bornOutofIndiaFileSize, citizenAquuireddoctype, citizenAquuireddocURL, citizenAquuiredFileName, citizenAquuiredFileSize, annexuresignatureURL, anexSignFileName, anexSignFileSize, isOtherState);
    }

    public void updateDeclartionForm(String declarationForm, String referencenumber, int i) {
        this.migrationRepository.updateDeclarationForm(declarationForm, referencenumber, i);
    }
}
