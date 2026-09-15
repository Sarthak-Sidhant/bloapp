package dagger.hilt.android.internal.builders;

import androidx.fragment.app.Fragment;
import dagger.BindsInstance;
import dagger.hilt.android.components.FragmentComponent;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface FragmentComponentBuilder {
    FragmentComponent build();

    FragmentComponentBuilder fragment(@BindsInstance Fragment fragment);
}
