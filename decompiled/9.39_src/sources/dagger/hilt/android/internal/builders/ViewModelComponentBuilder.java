package dagger.hilt.android.internal.builders;

import androidx.lifecycle.SavedStateHandle;
import dagger.BindsInstance;
import dagger.hilt.android.components.ViewModelComponent;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface ViewModelComponentBuilder {
    ViewModelComponent build();

    ViewModelComponentBuilder savedStateHandle(@BindsInstance SavedStateHandle handle);
}
