package in.gov.eci.bloapp.model;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class Form7ReasonSpinnerItem {
    private String code;
    private String codeDesc;

    public Form7ReasonSpinnerItem(String code, String codeDesc) {
        this.code = code;
        this.codeDesc = codeDesc;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeDesc() {
        return this.codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }

    public String toString() {
        return this.codeDesc;
    }
}
