package in.gov.eci.bloapp.views.model;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes5.dex */
public class EpicIssuedRoot {
    private String message;
    private String outsideState;
    private String status;
    private String withinAC;
    private String withinState;

    public String getWithinAC() {
        return this.withinAC;
    }

    public void setWithinAC(String withinAC) {
        this.withinAC = withinAC;
    }

    public String getWithinState() {
        return this.withinState;
    }

    public void setWithinState(String withinState) {
        this.withinState = withinState;
    }

    public String getOutsideState() {
        return this.outsideState;
    }

    public void setOutsideState(String outsideState) {
        this.outsideState = outsideState;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
