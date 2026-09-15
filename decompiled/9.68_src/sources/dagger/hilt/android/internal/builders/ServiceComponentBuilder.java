package dagger.hilt.android.internal.builders;

import android.app.Service;
import dagger.BindsInstance;
import dagger.hilt.android.components.ServiceComponent;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface ServiceComponentBuilder {
    ServiceComponent build();

    ServiceComponentBuilder service(@BindsInstance Service service);
}
