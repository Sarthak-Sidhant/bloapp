package in.gov.eci.bloapp.api.model;

import com.google.gson.annotations.SerializedName;
import in.gov.eci.bloapp.entity.ListData;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class DocumentResponse {

    @SerializedName("payload")
    public List<ListData> data;

    @SerializedName("message")
    public String message;

    @SerializedName("refId")
    public String refId;

    @SerializedName("status")
    public String status;

    @SerializedName("statusCode")
    public String statusCode;
}
