package in.gov.eci.bloapp.api.model;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public class User {
    private String avgResptime;
    private String created_timestamp;
    private String jwt;
    private String resp_CODE_COUNT;
    private String resp_CODE_DTLS;
    private String source_server_name;
    private String total_users_session_hit;
    private String transactionName;
    private String unique_users_session_count;
    private String usage_percentage;

    public User(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return this.jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public User(String usage_percentage, String source_server_name, String avg_resptime, String transaction_name, String resp_CODE_COUNT, String resp_CODE_DTLS, String total_users_session_hit, String unique_users_session_count, String created_timestamp) {
        this.usage_percentage = usage_percentage;
        this.source_server_name = source_server_name;
        this.avgResptime = this.avgResptime;
        this.transactionName = this.transactionName;
        this.resp_CODE_COUNT = resp_CODE_COUNT;
        this.resp_CODE_DTLS = resp_CODE_DTLS;
        this.total_users_session_hit = total_users_session_hit;
        this.unique_users_session_count = unique_users_session_count;
        this.created_timestamp = created_timestamp;
    }

    public String getAvgResptime() {
        return this.avgResptime;
    }

    public void setAvgResptime(String avgResptime) {
        this.avgResptime = avgResptime;
    }

    public String getTransactionName() {
        return this.transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public String getUsage_percentage() {
        return this.usage_percentage;
    }

    public void setUsage_percentage(String usage_percentage) {
        this.usage_percentage = usage_percentage;
    }

    public String getSource_server_name() {
        return this.source_server_name;
    }

    public void setSource_server_name(String source_server_name) {
        this.source_server_name = source_server_name;
    }

    public String getResp_CODE_COUNT() {
        return this.resp_CODE_COUNT;
    }

    public void setResp_CODE_COUNT(String resp_CODE_COUNT) {
        this.resp_CODE_COUNT = resp_CODE_COUNT;
    }

    public String getResp_CODE_DTLS() {
        return this.resp_CODE_DTLS;
    }

    public void setResp_CODE_DTLS(String resp_CODE_DTLS) {
        this.resp_CODE_DTLS = resp_CODE_DTLS;
    }

    public String getTotal_users_session_hit() {
        return this.total_users_session_hit;
    }

    public void setTotal_users_session_hit(String total_users_session_hit) {
        this.total_users_session_hit = total_users_session_hit;
    }

    public String getUnique_users_session_count() {
        return this.unique_users_session_count;
    }

    public void setUnique_users_session_count(String unique_users_session_count) {
        this.unique_users_session_count = unique_users_session_count;
    }

    public String getCreated_timestamp() {
        return this.created_timestamp;
    }

    public void setCreated_timestamp(String created_timestamp) {
        this.created_timestamp = created_timestamp;
    }
}
