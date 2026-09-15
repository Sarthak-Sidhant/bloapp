package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.gov.eci.bloapp.model.app_model.DraftNewVoterModel;
import in.gov.eci.bloapp.repository.NewVoterrepository;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class NewVoterViewModel extends ViewModel {
    public LiveData<List<DraftNewVoterModel>> data;
    public MutableLiveData<List<DraftNewVoterModel>> dataMutable;
    public NewVoterrepository requestWheelchairRepository;

    @Inject
    public NewVoterViewModel(NewVoterrepository requestWheelchairRepository) {
        MutableLiveData<List<DraftNewVoterModel>> mutableLiveData = new MutableLiveData<>();
        this.dataMutable = mutableLiveData;
        this.data = mutableLiveData;
        this.requestWheelchairRepository = requestWheelchairRepository;
    }

    public void insertforms(String s, String insertState, String personal, int i, String s1, String referencenumber, String datecreated, String byteArray, String pdfbyteArray2, String section) {
        this.requestWheelchairRepository.insertforms(s, insertState, personal, i, s1, referencenumber, datecreated, byteArray, pdfbyteArray2, section);
    }

    public void updateresidence(String referencenumber, String residence, int i, String pdfbyteArray) {
        this.requestWheelchairRepository.updateresidence(referencenumber, residence, i, pdfbyteArray);
    }

    public void updateDetails(String referencenumber, String details, int i, String pdfbyteArray1) {
        this.requestWheelchairRepository.updateDetails(referencenumber, details, i, pdfbyteArray1);
    }

    public LiveData<List<DraftNewVoterModel>> dataoneditbutton(String name, String date, String formtype) {
        LiveData<List<DraftNewVoterModel>> liveDataDataoneditbutton = this.requestWheelchairRepository.dataoneditbutton(name, date, formtype);
        this.data = liveDataDataoneditbutton;
        return liveDataDataoneditbutton;
    }

    public void insertData(String toString, String toString1, String toString2, String toString3, String toString4, String toString5, String toString6, byte[] byteArray, int family, String toString9, String toString10, String mobile, String toString11, String email, String toString12, String aadhar, String toString13, String gender, String toString14, byte[] pdfbyteArray2, String toString15, String toString16, String toString17, String toString18, String toString19, String toString20, String referencenumber, String createddate) {
        this.requestWheelchairRepository.inserData(toString, toString1, toString2, toString3, toString4, toString5, toString6, byteArray, family, toString9, toString10, mobile, toString11, email, toString12, aadhar, toString13, gender, toString14, pdfbyteArray2, toString15, toString16, toString17, toString18, toString19, toString20, referencenumber, createddate);
    }

    public void updateFamily(String referencenumber, String family_detail, int i) {
        this.requestWheelchairRepository.updateFamily(referencenumber, family_detail, i);
    }

    public void updatedeclaration(String referencenumber, String declaration, int i) {
        this.requestWheelchairRepository.updatedeclaration(referencenumber, declaration, i);
    }

    public void updatepersonal(String name, String personal, String referencenumber, int i, String photoref, String birthref) {
        this.requestWheelchairRepository.updatepersonal(name, personal, referencenumber, i, photoref, birthref);
    }

    public void updateAnnexureD(String referencenumber, String citizenshipType, String citizenshipTypeCat, String ctDocTypeForSelf, String ctDocOfSelfUrl, int stepSeqence, String doctypeselfFileName, String doctypeselFileSize, String before2004ParentType, String doctypeFather, String doctypeMother, String docURLFather, String docURLMother, String before2004docFileName, String before2004docFileSize, String after2004isParentIndian, String after2004ParentNameNotindian, String after2004doctypeFather, String after2004doctypeMother, String after2004docURLFather, String after2004docURLMother, String after2004MotherFileName, String after2004MotherFileSize, String after2004FatherFileName, String after2004FatherFileSize, String bornOutofIndiadoctype, String bornOutofIndiadocURL, String bornOutofIndiaFileName, String bornOutofIndiaFileSize, String citizenAquuireddoctype, String citizenAquuireddocURL, String citizenAquuiredFileName, String citizenAquuiredFileSize, String annexuresignatureURL, String anexSignFileName, String anexSignFileSize) {
        this.requestWheelchairRepository.updateAnnexureD(referencenumber, citizenshipType, citizenshipTypeCat, ctDocTypeForSelf, ctDocOfSelfUrl, stepSeqence, doctypeselfFileName, doctypeselFileSize, before2004ParentType, doctypeFather, doctypeMother, docURLFather, docURLMother, before2004docFileName, before2004docFileSize, after2004isParentIndian, after2004ParentNameNotindian, after2004doctypeFather, after2004doctypeMother, after2004docURLFather, after2004docURLMother, after2004MotherFileName, after2004MotherFileSize, after2004FatherFileName, after2004FatherFileSize, bornOutofIndiadoctype, bornOutofIndiadocURL, bornOutofIndiaFileName, bornOutofIndiaFileSize, citizenAquuireddoctype, citizenAquuireddocURL, citizenAquuiredFileName, citizenAquuiredFileSize, annexuresignatureURL, anexSignFileName, anexSignFileSize);
    }

    public void updateDeclarationForm(String declarationForm, String referencenumber, int i) {
        this.requestWheelchairRepository.updateDeclarationForm(declarationForm, referencenumber, i);
    }
}
