package in.gov.eci.bloapp.model.app_model;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class DraftFormsModel {
    public String createdon;
    public String name;

    public DraftFormsModel(String name, String createdon) {
        this.name = name;
        this.createdon = createdon;
    }

    public String getName() {
        return this.name;
    }

    public String getCreatedon() {
        return this.createdon;
    }
}
