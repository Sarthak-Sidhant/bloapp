package in.gov.eci.bloapp.network;

import in.gov.eci.bloapp.model.network_model.PostsResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface ApiInterface {
    @GET("posts")
    Call<List<PostsResponse>> getPosts();
}
