package dagger.hilt.android.internal.builders;

import androidx.fragment.app.Fragment;
import dagger.BindsInstance;
import dagger.hilt.android.components.FragmentComponent;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface FragmentComponentBuilder {
    FragmentComponent build();

    FragmentComponentBuilder fragment(@BindsInstance Fragment fragment);
}
