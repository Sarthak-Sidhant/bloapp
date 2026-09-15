package org.apache.commons.io;

import java.io.File;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FileCleaner {
    static final FileCleaningTracker theInstance = new FileCleaningTracker();

    public static void track(File file, Object obj) {
        theInstance.track(file, obj);
    }

    public static void track(File file, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        theInstance.track(file, obj, fileDeleteStrategy);
    }

    public static void track(String str, Object obj) {
        theInstance.track(str, obj);
    }

    public static void track(String str, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        theInstance.track(str, obj, fileDeleteStrategy);
    }

    public static int getTrackCount() {
        return theInstance.getTrackCount();
    }

    public static synchronized void exitWhenFinished() {
        theInstance.exitWhenFinished();
    }

    public static FileCleaningTracker getInstance() {
        return theInstance;
    }
}
