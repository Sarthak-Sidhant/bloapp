package com.yalantis.ucrop;

import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class OkHttpClientStore {
    public static final OkHttpClientStore INSTANCE = new OkHttpClientStore();
    private OkHttpClient client;

    private OkHttpClientStore() {
    }

    public OkHttpClient getClient() {
        if (this.client == null) {
            this.client = new OkHttpClient();
        }
        return this.client;
    }

    void setClient(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }
}
