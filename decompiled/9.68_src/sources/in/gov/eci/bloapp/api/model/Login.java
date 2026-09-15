package in.gov.eci.bloapp.api.model;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class Login {
    private final String password;
    private final String username;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String toString() {
        return "Login{username='" + this.username + "', password='" + this.password + "'}";
    }
}
