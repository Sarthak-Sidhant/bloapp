package dagger.hilt.android.internal.builders;

import android.app.Service;
import dagger.BindsInstance;
import dagger.hilt.android.components.ServiceComponent;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface ServiceComponentBuilder {
    ServiceComponent build();

    ServiceComponentBuilder service(@BindsInstance Service service);
}
