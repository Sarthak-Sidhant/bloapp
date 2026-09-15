package org.apache.commons.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class FileSystemUtils {
    private static final int INIT_PROBLEM = -1;
    private static final FileSystemUtils INSTANCE = new FileSystemUtils();
    private static final int OS;
    private static final int OTHER = 0;
    private static final int POSIX_UNIX = 3;
    private static final int UNIX = 2;
    private static final int WINDOWS = 1;

    static {
        int i = -1;
        try {
            String property = System.getProperty(SystemProperties.OS_NAME);
            if (property == null) {
                throw new IOException("os.name not found");
            }
            String lowerCase = property.toLowerCase();
            if (lowerCase.indexOf("windows") != -1) {
                i = 1;
            } else if (lowerCase.indexOf("linux") == -1 && lowerCase.indexOf("sun os") == -1 && lowerCase.indexOf("sunos") == -1 && lowerCase.indexOf("solaris") == -1 && lowerCase.indexOf("mpe/ix") == -1 && lowerCase.indexOf("freebsd") == -1 && lowerCase.indexOf("irix") == -1 && lowerCase.indexOf("digital unix") == -1 && lowerCase.indexOf("unix") == -1 && lowerCase.indexOf("mac os x") == -1) {
                i = (lowerCase.indexOf("hp-ux") == -1 && lowerCase.indexOf("aix") == -1) ? 0 : 3;
            } else {
                i = 2;
            }
            OS = i;
        } catch (Exception unused) {
        }
    }

    public static long freeSpace(String str) throws IOException {
        return INSTANCE.freeSpaceOS(str, OS, false);
    }

    public static long freeSpaceKb(String str) throws IOException {
        return INSTANCE.freeSpaceOS(str, OS, true);
    }

    long freeSpaceOS(String str, int i, boolean z) throws Throwable {
        if (str == null) {
            throw new IllegalArgumentException("Path must not be empty");
        }
        if (i == 0) {
            throw new IllegalStateException("Unsupported operating system");
        }
        if (i == 1) {
            long jFreeSpaceWindows = freeSpaceWindows(str);
            return z ? jFreeSpaceWindows / 1024 : jFreeSpaceWindows;
        }
        if (i == 2) {
            return freeSpaceUnix(str, z, false);
        }
        if (i == 3) {
            return freeSpaceUnix(str, z, true);
        }
        throw new IllegalStateException("Exception caught when determining operating system");
    }

    long freeSpaceWindows(String str) throws Throwable {
        String strNormalize = FilenameUtils.normalize(str);
        if (strNormalize.length() > 2 && strNormalize.charAt(1) == ':') {
            strNormalize = strNormalize.substring(0, 2);
        }
        List listPerformCommand = performCommand(new String[]{"cmd.exe", "/C", new StringBuffer("dir /-c ").append(strNormalize).toString()}, Integer.MAX_VALUE);
        for (int size = listPerformCommand.size() - 1; size >= 0; size--) {
            String str2 = (String) listPerformCommand.get(size);
            if (str2.length() > 0) {
                return parseDir(str2, strNormalize);
            }
        }
        throw new IOException(new StringBuffer("Command line 'dir /-c' did not return any info for path '").append(strNormalize).append("'").toString());
    }

    long parseDir(String str, String str2) throws IOException {
        int i;
        int i2;
        int i3;
        int length = str.length();
        while (true) {
            length--;
            i = 0;
            if (length < 0) {
                i2 = 0;
                break;
            }
            if (Character.isDigit(str.charAt(length))) {
                i2 = length + 1;
                break;
            }
        }
        while (true) {
            if (length < 0) {
                i3 = 0;
                break;
            }
            char cCharAt = str.charAt(length);
            if (!Character.isDigit(cCharAt) && cCharAt != ',' && cCharAt != '.') {
                i3 = length + 1;
                break;
            }
            length--;
        }
        if (length < 0) {
            throw new IOException(new StringBuffer("Command line 'dir /-c' did not return valid info for path '").append(str2).append("'").toString());
        }
        StringBuffer stringBuffer = new StringBuffer(str.substring(i3, i2));
        while (i < stringBuffer.length()) {
            if (stringBuffer.charAt(i) == ',' || stringBuffer.charAt(i) == '.') {
                stringBuffer.deleteCharAt(i);
                i--;
            }
            i++;
        }
        return parseBytes(stringBuffer.toString(), str2);
    }

    long freeSpaceUnix(String str, boolean z, boolean z2) throws Throwable {
        String string;
        if (str.length() == 0) {
            throw new IllegalArgumentException("Path must not be empty");
        }
        String strNormalize = FilenameUtils.normalize(str);
        if (!z) {
            string = "-";
        } else {
            string = "-k";
        }
        if (z2) {
            string = new StringBuffer().append(string).append("P").toString();
        }
        List listPerformCommand = performCommand(string.length() > 1 ? new String[]{"df", string, strNormalize} : new String[]{"df", strNormalize}, 3);
        if (listPerformCommand.size() < 2) {
            throw new IOException(new StringBuffer("Command line 'df' did not return info as expected for path '").append(strNormalize).append("'- response was ").append(listPerformCommand).toString());
        }
        StringTokenizer stringTokenizer = new StringTokenizer((String) listPerformCommand.get(1), StringUtils.SPACE);
        if (stringTokenizer.countTokens() < 4) {
            if (stringTokenizer.countTokens() == 1 && listPerformCommand.size() >= 3) {
                stringTokenizer = new StringTokenizer((String) listPerformCommand.get(2), StringUtils.SPACE);
            } else {
                throw new IOException(new StringBuffer("Command line 'df' did not return data as expected for path '").append(strNormalize).append("'- check path is valid").toString());
            }
        } else {
            stringTokenizer.nextToken();
        }
        stringTokenizer.nextToken();
        stringTokenizer.nextToken();
        return parseBytes(stringTokenizer.nextToken(), strNormalize);
    }

    long parseBytes(String str, String str2) throws IOException {
        try {
            long j = Long.parseLong(str);
            if (j >= 0) {
                return j;
            }
            throw new IOException(new StringBuffer("Command line 'df' did not find free space in response for path '").append(str2).append("'- check path is valid").toString());
        } catch (NumberFormatException unused) {
            throw new IOException(new StringBuffer("Command line 'df' did not return numeric data as expected for path '").append(str2).append("'- check path is valid").toString());
        }
    }

    /* JADX WARN: Code duplicated, block: B:61:0x0110  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.BufferedReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    List performCommand(String[] strArr, int i) throws Throwable {
        Process processOpenProcess;
        OutputStream outputStream;
        InputStream inputStream;
        InputStream errorStream;
        ?? bufferedReader;
        ?? r7;
        ArrayList arrayList = new ArrayList(20);
        InputStream inputStream2 = null;
        try {
            processOpenProcess = openProcess(strArr);
            try {
                inputStream = processOpenProcess.getInputStream();
                try {
                    outputStream = processOpenProcess.getOutputStream();
                    try {
                        errorStream = processOpenProcess.getErrorStream();
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                            try {
                                for (String line = bufferedReader.readLine(); line != null && arrayList.size() < i; line = bufferedReader.readLine()) {
                                    arrayList.add(line.toLowerCase().trim());
                                }
                                processOpenProcess.waitFor();
                                if (processOpenProcess.exitValue() != 0) {
                                    throw new IOException(new StringBuffer().append("Command line returned OS error code '").append(processOpenProcess.exitValue()).append("' for command ").append(Arrays.asList(strArr)).toString());
                                }
                                if (arrayList.size() == 0) {
                                    throw new IOException(new StringBuffer().append("Command line did not return any info for command ").append(Arrays.asList(strArr)).toString());
                                }
                                IOUtils.closeQuietly(inputStream);
                                IOUtils.closeQuietly(outputStream);
                                IOUtils.closeQuietly(errorStream);
                                IOUtils.closeQuietly((Reader) bufferedReader);
                                if (processOpenProcess != null) {
                                    processOpenProcess.destroy();
                                }
                                return arrayList;
                            } catch (InterruptedException e) {
                                e = e;
                                inputStream2 = processOpenProcess;
                                bufferedReader = bufferedReader;
                                try {
                                    throw new IOException(new StringBuffer().append("Command line threw an InterruptedException '").append(e.getMessage()).append("' for command ").append(Arrays.asList(strArr)).toString());
                                } catch (Throwable th) {
                                    th = th;
                                    processOpenProcess = inputStream2;
                                    inputStream2 = inputStream;
                                    r7 = bufferedReader;
                                    IOUtils.closeQuietly(inputStream2);
                                    IOUtils.closeQuietly(outputStream);
                                    IOUtils.closeQuietly(errorStream);
                                    IOUtils.closeQuietly((Reader) r7);
                                    if (processOpenProcess != null) {
                                        processOpenProcess.destroy();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream2 = inputStream;
                                r7 = bufferedReader;
                                IOUtils.closeQuietly(inputStream2);
                                IOUtils.closeQuietly(outputStream);
                                IOUtils.closeQuietly(errorStream);
                                IOUtils.closeQuietly((Reader) r7);
                                if (processOpenProcess != null) {
                                    processOpenProcess.destroy();
                                }
                                throw th;
                            }
                        } catch (InterruptedException e2) {
                            e = e2;
                            bufferedReader = 0;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = 0;
                        }
                    } catch (InterruptedException e3) {
                        e = e3;
                        errorStream = null;
                        bufferedReader = errorStream;
                        inputStream2 = processOpenProcess;
                        bufferedReader = bufferedReader;
                        throw new IOException(new StringBuffer().append("Command line threw an InterruptedException '").append(e.getMessage()).append("' for command ").append(Arrays.asList(strArr)).toString());
                    } catch (Throwable th4) {
                        th = th4;
                        errorStream = null;
                        bufferedReader = errorStream;
                        inputStream2 = inputStream;
                        r7 = bufferedReader;
                        IOUtils.closeQuietly(inputStream2);
                        IOUtils.closeQuietly(outputStream);
                        IOUtils.closeQuietly(errorStream);
                        IOUtils.closeQuietly((Reader) r7);
                        if (processOpenProcess != null) {
                            processOpenProcess.destroy();
                        }
                        throw th;
                    }
                } catch (InterruptedException e4) {
                    e = e4;
                    outputStream = null;
                    errorStream = outputStream;
                    bufferedReader = errorStream;
                    inputStream2 = processOpenProcess;
                    bufferedReader = bufferedReader;
                    throw new IOException(new StringBuffer().append("Command line threw an InterruptedException '").append(e.getMessage()).append("' for command ").append(Arrays.asList(strArr)).toString());
                } catch (Throwable th5) {
                    th = th5;
                    outputStream = null;
                    errorStream = null;
                }
            } catch (InterruptedException e5) {
                e = e5;
                inputStream = null;
                outputStream = null;
            } catch (Throwable th6) {
                th = th6;
                outputStream = null;
                errorStream = outputStream;
                r7 = errorStream;
                IOUtils.closeQuietly(inputStream2);
                IOUtils.closeQuietly(outputStream);
                IOUtils.closeQuietly(errorStream);
                IOUtils.closeQuietly((Reader) r7);
                if (processOpenProcess != null) {
                    processOpenProcess.destroy();
                }
                throw th;
            }
        } catch (InterruptedException e6) {
            e = e6;
            inputStream = null;
            outputStream = null;
            errorStream = null;
            bufferedReader = 0;
        } catch (Throwable th7) {
            th = th7;
            processOpenProcess = null;
            outputStream = null;
        }
    }

    Process openProcess(String[] strArr) throws IOException {
        return Runtime.getRuntime().exec(strArr);
    }
}
