package dagger.hilt.android.internal.builders;

import android.view.View;
import dagger.BindsInstance;
import dagger.hilt.android.components.ViewComponent;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface ViewComponentBuilder {
    ViewComponent build();

    ViewComponentBuilder view(@BindsInstance View view);
}
