package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.SerializedName;
import in.gov.eci.bloapp.utils.Constants;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class NotificationItem {

    @SerializedName("createdDate")
    private String createdDate;

    @SerializedName("id")
    private String id;

    @SerializedName("isActive")
    private String isActive;

    @SerializedName("isSeen")
    private String isSeen;

    @SerializedName("message")
    private String message;

    @SerializedName(Constants.TITLE)
    private String title;

    @SerializedName("userId")
    private String userId;

    public NotificationItem() {
    }

    public NotificationItem(String id, String title, String message, String isSeen, String isActive, String createdDate, String userId) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.isSeen = isSeen;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.userId = userId;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getMessage() {
        return this.message;
    }

    public String isSeen() {
        return this.isSeen;
    }

    public String isActive() {
        return this.isActive;
    }

    public String getCreatedDate() {
        return this.createdDate;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setSeen(String seen) {
        this.isSeen = seen;
    }
}
