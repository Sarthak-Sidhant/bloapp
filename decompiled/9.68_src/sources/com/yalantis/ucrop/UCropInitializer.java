package com.yalantis.ucrop;

import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class UCropInitializer {
    public UCropInitializer setOkHttpClient(OkHttpClient okHttpClient) {
        OkHttpClientStore.INSTANCE.setClient(okHttpClient);
        return this;
    }
}
