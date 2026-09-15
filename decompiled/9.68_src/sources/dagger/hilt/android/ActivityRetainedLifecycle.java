package dagger.hilt.android;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public interface ActivityRetainedLifecycle {

    public interface OnClearedListener {
        void onCleared();
    }

    void addOnClearedListener(OnClearedListener listener);

    void removeOnClearedListener(OnClearedListener listener);
}
