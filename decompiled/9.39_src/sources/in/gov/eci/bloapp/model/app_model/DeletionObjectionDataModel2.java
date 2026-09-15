package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class DeletionObjectionDataModel2 {

    @SerializedName("ASSEMBLY_DETAILS")
    public String assembly;

    @SerializedName("DISTRICT_DETAILS")
    public String district;

    @SerializedName("EPIC")
    public String epic;

    @SerializedName("NAME")
    public String name;

    @SerializedName("STATE_DETAILS")
    public String state;

    @SerializedName("SURNAME")
    public String surname;

    public DeletionObjectionDataModel2(String state, String district, String name, String surname, String epic) {
        this.state = state;
        this.district = district;
        this.name = name;
        this.surname = surname;
        this.epic = epic;
    }

    public String getState() {
        return this.state;
    }

    public String getDistrict() {
        return this.district;
    }

    public String getAssembly() {
        return this.assembly;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getEpic() {
        return this.epic;
    }
}
