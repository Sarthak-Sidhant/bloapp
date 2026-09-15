package in.gov.eci.bloapp.room.roommodel;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class RegistrationModel {
    public String email;
    public String epicNum;
    public String firstName;
    public Long id;
    public String lastName;
    public String mobNo;
    public String password;

    public RegistrationModel(Long id, String firstName, String lastName, String mobNo, String email, String password, String epicNum) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobNo = mobNo;
        this.email = email;
        this.password = password;
        this.epicNum = epicNum;
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getMobNo() {
        return this.mobNo;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEpicNum() {
        return this.epicNum;
    }
}
