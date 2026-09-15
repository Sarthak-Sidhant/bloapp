package in.gov.eci.bloapp.model.electors_list;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class ElectorsListModel {

    public class getEpicList {
        public getEpicList() {
        }

        public class Root {
            String aadhaarRef;
            String aadharStatus;
            String age;
            String applicantName;
            String applicantNameL1;
            String epic;
            int epicId;
            String gender;
            String mobile;
            String pwd;
            String relationName;
            String relationNameL1;
            String relationType;
            int serialNo;

            public Root() {
            }

            @SerializedName("epicId")
            public int getEpicId() {
                return this.epicId;
            }

            public void setEpicId(int epicId) {
                this.epicId = epicId;
            }

            @SerializedName("epic")
            public String getEpic() {
                return this.epic;
            }

            public void setEpic(String epic) {
                this.epic = epic;
            }

            @SerializedName("serialNo")
            public int getSerialNo() {
                return this.serialNo;
            }

            public void setSerialNo(int serialNo) {
                this.serialNo = serialNo;
            }

            @SerializedName("aadhaarRef")
            public String getAadhaarRef() {
                return this.aadhaarRef;
            }

            public void setAadhaarRef(String aadhaarRef) {
                this.aadhaarRef = aadhaarRef;
            }

            @SerializedName("aadharStatus")
            public String getAadharStatus() {
                return this.aadharStatus;
            }

            public void setAadharStatus(String aadharStatus) {
                this.aadharStatus = aadharStatus;
            }

            @SerializedName("applicantName")
            public String getApplicantName() {
                return this.applicantName;
            }

            public void setApplicantName(String applicantName) {
                this.applicantName = applicantName;
            }

            @SerializedName("applicantNameL1")
            public String getApplicantNameL1() {
                return this.applicantNameL1;
            }

            public void setApplicantNameL1(String applicantNameL1) {
                this.applicantNameL1 = applicantNameL1;
            }

            @SerializedName("relationName")
            public String getRelationName() {
                return this.relationName;
            }

            public void setRelationName(String relationName) {
                this.relationName = relationName;
            }

            @SerializedName("relationNameL1")
            public String getRelationNameL1() {
                return this.relationNameL1;
            }

            public void setRelationNameL1(String relationNameL1) {
                this.relationNameL1 = relationNameL1;
            }

            @SerializedName("gender")
            public String getGender() {
                return this.gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            @SerializedName("relationType")
            public String getRelationType() {
                return this.relationType;
            }

            public void setRelationType(String relationType) {
                this.relationType = relationType;
            }

            @SerializedName("age")
            public String getAge() {
                return this.age;
            }

            public void setAge(String age) {
                this.age = age;
            }

            @SerializedName("mobile")
            public String getMobile() {
                return this.mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            @SerializedName("pwd")
            public String getPwd() {
                return this.pwd;
            }

            public void setPwd(String pwd) {
                this.pwd = pwd;
            }
        }
    }

    public class getEpicDetails {
        public getEpicDetails() {
        }

        public class Payload {
            String address;
            String addressL1;
            String age;
            String applicantName;
            String applicantNameL1;
            String assemblyName;
            String districtName;
            String gender;
            String mobile;
            String partNo;
            String photo;
            String relationName;
            String relationNameL1;
            String relationType;
            String sectionNo;
            int serialNo;
            String stateName;

            public Payload() {
            }

            @SerializedName("serialNo")
            public int getSerialNo() {
                return this.serialNo;
            }

            public void setSerialNo(int serialNo) {
                this.serialNo = serialNo;
            }

            @SerializedName("applicantName")
            public String getApplicantName() {
                return this.applicantName;
            }

            public void setApplicantName(String applicantName) {
                this.applicantName = applicantName;
            }

            @SerializedName("applicantNameL1")
            public String getApplicantNameL1() {
                return this.applicantNameL1;
            }

            public void setApplicantNameL1(String applicantNameL1) {
                this.applicantNameL1 = applicantNameL1;
            }

            @SerializedName("relationName")
            public String getRelationName() {
                return this.relationName;
            }

            public void setRelationName(String relationName) {
                this.relationName = relationName;
            }

            @SerializedName("relationNameL1")
            public String getRelationNameL1() {
                return this.relationNameL1;
            }

            public void setRelationNameL1(String relationNameL1) {
                this.relationNameL1 = relationNameL1;
            }

            @SerializedName("gender")
            public String getGender() {
                return this.gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            @SerializedName("age")
            public String getAge() {
                return this.age;
            }

            public void setAge(String age) {
                this.age = age;
            }

            @SerializedName("assemblyName")
            public String getAssemblyName() {
                return this.assemblyName;
            }

            public void setAssemblyName(String assemblyName) {
                this.assemblyName = assemblyName;
            }

            @SerializedName("address")
            public String getAddress() {
                return this.address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            @SerializedName("addressL1")
            public String getAddressL1() {
                return this.addressL1;
            }

            public void setAddressL1(String addressL1) {
                this.addressL1 = addressL1;
            }

            @SerializedName("districtName")
            public String getDistrictName() {
                return this.districtName;
            }

            public void setDistrictName(String districtName) {
                this.districtName = districtName;
            }

            @SerializedName("stateName")
            public String getStateName() {
                return this.stateName;
            }

            public void setStateName(String stateName) {
                this.stateName = stateName;
            }

            @SerializedName("partNo")
            public String getPartNo() {
                return this.partNo;
            }

            public void setPartNo(String partNo) {
                this.partNo = partNo;
            }

            @SerializedName("sectionNo")
            public String getSectionNo() {
                return this.sectionNo;
            }

            public void setSectionNo(String sectionNo) {
                this.sectionNo = sectionNo;
            }

            @SerializedName("mobile")
            public String getMobile() {
                return this.mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            @SerializedName("relationType")
            public String getRelationType() {
                return this.relationType;
            }

            public void setRelationType(String relationType) {
                this.relationType = relationType;
            }

            @SerializedName("photo")
            public String getPhoto() {
                return this.photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }

        public class Root {
            String message;
            ArrayList<Payload> payload;
            Object refId;
            String status;
            int statusCode;

            public Root() {
            }

            @SerializedName("status")
            public String getStatus() {
                return this.status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            @SerializedName("statusCode")
            public int getStatusCode() {
                return this.statusCode;
            }

            public void setStatusCode(int statusCode) {
                this.statusCode = statusCode;
            }

            @SerializedName("refId")
            public Object getRefId() {
                return this.refId;
            }

            public void setRefId(Object refId) {
                this.refId = refId;
            }

            @SerializedName("message")
            public String getMessage() {
                return this.message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            @SerializedName("payload")
            public ArrayList<Payload> getPayload() {
                return this.payload;
            }

            public void setPayload(ArrayList<Payload> payload) {
                this.payload = payload;
            }
        }
    }
}
