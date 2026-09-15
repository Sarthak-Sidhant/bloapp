package in.gov.eci.bloapp.model.network_model;

import com.google.gson.annotations.SerializedName;
import in.gov.eci.bloapp.utils.Constants;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class PostsResponse {

    @SerializedName("body")
    public String body;

    @SerializedName("id")
    public String id;

    @SerializedName(Constants.TITLE)
    public String title;

    @SerializedName("userId")
    public String userId;
}
