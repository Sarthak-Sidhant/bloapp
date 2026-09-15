package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class AssemblyModel {

    @SerializedName("AC_ID")
    public int ac_id;

    @SerializedName("ASMBLY_NAME")
    public String assembly_name;

    @SerializedName("ASMBLY_NO")
    public String assembly_no;

    @SerializedName("CATEGORY")
    public String category;

    @SerializedName("DISTRICT_CD")
    public String district_cd;

    @SerializedName("EPIC_PREFIX")
    public String epic_prefix;

    @SerializedName("IS_ACTIVE")
    public String is_active;

    @SerializedName("STATE_CD")
    public String state_cd;

    public AssemblyModel(int ac_id, String state_cd, String district_cd, String assembly_no, String assembly_name, String category, String is_active, String epic_prefix) {
        this.ac_id = ac_id;
        this.state_cd = state_cd;
        this.district_cd = district_cd;
        this.assembly_no = assembly_no;
        this.assembly_name = assembly_name;
        this.category = category;
        this.is_active = is_active;
        this.epic_prefix = epic_prefix;
    }

    public int getAc_id() {
        return this.ac_id;
    }

    public String getState_cd() {
        return this.state_cd;
    }

    public String getDistrict_cd() {
        return this.district_cd;
    }

    public String getAssembly_no() {
        return this.assembly_no;
    }

    public String getAssembly_name() {
        return this.assembly_name;
    }

    public String getCategory() {
        return this.category;
    }

    public String getIs_active() {
        return this.is_active;
    }

    public String getEpic_prefix() {
        return this.epic_prefix;
    }
}
