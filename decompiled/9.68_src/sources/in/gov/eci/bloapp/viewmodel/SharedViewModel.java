package in.gov.eci.bloapp.viewmodel;

import androidx.lifecycle.ViewModel;
import in.gov.eci.bloapp.views.activity.newsir.model.MappingModel;
import in.gov.eci.bloapp.views.activity.newsir.model.MappingRoot;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class SharedViewModel extends ViewModel {
    private String acno;
    int age;
    private List<MappingModel> bloMappedList;
    private String dob;
    private String electorname;
    private Long epicId;
    private String epicNumber;
    private String from;
    private String gender;
    private MappingRoot mappingModel;
    private String partno;
    private String relationType;
    private String relativeName;
    private String serial;
    private String state;
    private List<MappingModel> systemMappedList;

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setData(MappingRoot mappingModel) {
        this.mappingModel = mappingModel;
    }

    public List<MappingModel> getBloMappedList() {
        return this.bloMappedList;
    }

    public List<MappingModel> getSystemMappedList() {
        return this.systemMappedList;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEpicNumber() {
        return this.epicNumber;
    }

    public void setEpicNumber(String epicNumber) {
        this.epicNumber = epicNumber;
    }

    public String getSerial() {
        return this.serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getElectorname() {
        return this.electorname;
    }

    public void setElectorname(String electorname) {
        this.electorname = electorname;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getEpicId() {
        return this.epicId;
    }

    public void setEpicId(Long epicId) {
        this.epicId = epicId;
    }

    public MappingRoot getMappingModel() {
        return this.mappingModel;
    }

    public void setMappingModel(MappingRoot mappingModel) {
        this.mappingModel = mappingModel;
    }

    public String getRelativeName() {
        return this.relativeName;
    }

    public void setRelativeName(String relativeName) {
        this.relativeName = relativeName;
    }

    public String getRelationType() {
        return this.relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAcno() {
        return this.acno;
    }

    public void setAcno(String acno) {
        this.acno = acno;
    }

    public String getPartno() {
        return this.partno;
    }

    public void setPartno(String partno) {
        this.partno = partno;
    }
}
