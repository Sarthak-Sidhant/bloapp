package dagger.hilt.android;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface ActivityRetainedLifecycle {

    public interface OnClearedListener {
        void onCleared();
    }

    void addOnClearedListener(OnClearedListener listener);

    void removeOnClearedListener(OnClearedListener listener);
}
