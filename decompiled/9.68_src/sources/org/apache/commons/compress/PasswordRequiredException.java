package org.apache.commons.compress;

import java.io.IOException;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class PasswordRequiredException extends IOException {
    private static final long serialVersionUID = 1391070005491684483L;

    public PasswordRequiredException(String str) {
        super("Cannot read encrypted content from " + str + " without a password.");
    }
}
