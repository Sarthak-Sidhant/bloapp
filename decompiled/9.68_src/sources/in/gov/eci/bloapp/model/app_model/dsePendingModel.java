package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class dsePendingModel {

    @SerializedName("AGE")
    public String age;

    @SerializedName("CLUSTER_ID")
    public String clusterId;

    @SerializedName("DSE_TYPE")
    public int dseType;

    @SerializedName("FIRST_NAME")
    public String firstName;

    @SerializedName("GENDER")
    public String gender;

    @SerializedName("RELATION_TYPE")
    public String relationType;

    @SerializedName("RELATIVE_NAME")
    public String relativeName;

    public dsePendingModel(String clusterId, String firstName, String relativeName, String Gender, String age, String relationType, int dseType) {
        this.clusterId = clusterId;
        this.firstName = firstName;
        this.relativeName = relativeName;
        this.gender = Gender;
        this.age = age;
        this.relationType = relationType;
        this.dseType = dseType;
    }

    public int getDseType() {
        return this.dseType;
    }

    public void setDseType(int dseType) {
        this.dseType = dseType;
    }

    public String getRelativeName() {
        return this.relativeName;
    }

    public void setRelativeName(String relativeName) {
        this.relativeName = relativeName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRelationType() {
        return this.relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getClusterId() {
        return this.clusterId;
    }

    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }
}
