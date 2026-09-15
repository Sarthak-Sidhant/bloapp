package org.apache.commons.compress.archivers.tar;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class TarArchiveEntry implements ArchiveEntry, TarConstants {
    public static final int DEFAULT_DIR_MODE = 16877;
    public static final int DEFAULT_FILE_MODE = 33188;
    private static final TarArchiveEntry[] EMPTY_TAR_ARCHIVE_ENTRIES = new TarArchiveEntry[0];
    public static final int MAX_NAMELEN = 31;
    public static final int MILLIS_PER_SECOND = 1000;
    public static final long UNKNOWN = -1;
    private boolean checkSumOK;
    private int devMajor;
    private int devMinor;
    private final Map<String, String> extraPaxHeaders;
    private final File file;
    private long groupId;
    private String groupName;
    private boolean isExtended;
    private byte linkFlag;
    private String linkName;
    private String magic;
    private long modTime;
    private int mode;
    private String name;
    private boolean paxGNUSparse;
    private final boolean preserveAbsolutePath;
    private long realSize;
    private long size;
    private boolean starSparse;
    private long userId;
    private String userName;
    private String version;

    private TarArchiveEntry(boolean z) {
        this.name = "";
        this.userId = 0L;
        this.groupId = 0L;
        this.size = 0L;
        this.linkName = "";
        this.magic = "ustar\u0000";
        this.version = TarConstants.VERSION_POSIX;
        this.groupName = "";
        this.devMajor = 0;
        this.devMinor = 0;
        this.extraPaxHeaders = new HashMap();
        String property = System.getProperty("user.name", "");
        this.userName = property.length() > 31 ? property.substring(0, 31) : property;
        this.file = null;
        this.preserveAbsolutePath = z;
    }

    public TarArchiveEntry(String str) {
        this(str, false);
    }

    public TarArchiveEntry(String str, boolean z) {
        this(z);
        String strNormalizeFileName = normalizeFileName(str, z);
        boolean zEndsWith = strNormalizeFileName.endsWith("/");
        this.name = strNormalizeFileName;
        this.mode = zEndsWith ? DEFAULT_DIR_MODE : DEFAULT_FILE_MODE;
        this.linkFlag = zEndsWith ? TarConstants.LF_DIR : TarConstants.LF_NORMAL;
        this.modTime = new Date().getTime() / 1000;
        this.userName = "";
    }

    public TarArchiveEntry(String str, byte b) {
        this(str, b, false);
    }

    public TarArchiveEntry(String str, byte b, boolean z) {
        this(str, z);
        this.linkFlag = b;
        if (b == 76) {
            this.magic = TarConstants.MAGIC_GNU;
            this.version = TarConstants.VERSION_GNU_SPACE;
        }
    }

    public TarArchiveEntry(File file) {
        this(file, file.getPath());
    }

    public TarArchiveEntry(File file, String str) {
        this.name = "";
        this.userId = 0L;
        this.groupId = 0L;
        this.size = 0L;
        this.linkName = "";
        this.magic = "ustar\u0000";
        this.version = TarConstants.VERSION_POSIX;
        this.groupName = "";
        this.devMajor = 0;
        this.devMinor = 0;
        this.extraPaxHeaders = new HashMap();
        String strNormalizeFileName = normalizeFileName(str, false);
        this.file = file;
        if (file.isDirectory()) {
            this.mode = DEFAULT_DIR_MODE;
            this.linkFlag = TarConstants.LF_DIR;
            int length = strNormalizeFileName.length();
            if (length == 0 || strNormalizeFileName.charAt(length - 1) != '/') {
                this.name = strNormalizeFileName + "/";
            } else {
                this.name = strNormalizeFileName;
            }
        } else {
            this.mode = DEFAULT_FILE_MODE;
            this.linkFlag = TarConstants.LF_NORMAL;
            this.size = file.length();
            this.name = strNormalizeFileName;
        }
        this.modTime = file.lastModified() / 1000;
        this.userName = "";
        this.preserveAbsolutePath = false;
    }

    public TarArchiveEntry(byte[] bArr) {
        this(false);
        parseTarHeader(bArr);
    }

    public TarArchiveEntry(byte[] bArr, ZipEncoding zipEncoding) throws IOException {
        this(bArr, zipEncoding, false);
    }

    public TarArchiveEntry(byte[] bArr, ZipEncoding zipEncoding, boolean z) throws IOException {
        this(false);
        parseTarHeader(bArr, zipEncoding, false, z);
    }

    public boolean equals(TarArchiveEntry tarArchiveEntry) {
        return tarArchiveEntry != null && getName().equals(tarArchiveEntry.getName());
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return equals((TarArchiveEntry) obj);
    }

    public int hashCode() {
        return getName().hashCode();
    }

    public boolean isDescendent(TarArchiveEntry tarArchiveEntry) {
        return tarArchiveEntry.getName().startsWith(getName());
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = normalizeFileName(str, this.preserveAbsolutePath);
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public String getLinkName() {
        return this.linkName;
    }

    public void setLinkName(String str) {
        this.linkName = str;
    }

    @Deprecated
    public int getUserId() {
        return (int) this.userId;
    }

    public void setUserId(int i) {
        setUserId(i);
    }

    public long getLongUserId() {
        return this.userId;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    @Deprecated
    public int getGroupId() {
        return (int) this.groupId;
    }

    public void setGroupId(int i) {
        setGroupId(i);
    }

    public long getLongGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setIds(int i, int i2) {
        setUserId(i);
        setGroupId(i2);
    }

    public void setNames(String str, String str2) {
        setUserName(str);
        setGroupName(str2);
    }

    public void setModTime(long j) {
        this.modTime = j / 1000;
    }

    public void setModTime(Date date) {
        this.modTime = date.getTime() / 1000;
    }

    public Date getModTime() {
        return new Date(this.modTime * 1000);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public Date getLastModifiedDate() {
        return getModTime();
    }

    public boolean isCheckSumOK() {
        return this.checkSumOK;
    }

    public File getFile() {
        return this.file;
    }

    public int getMode() {
        return this.mode;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Size is out of range: " + j);
        }
        this.size = j;
    }

    public int getDevMajor() {
        return this.devMajor;
    }

    public void setDevMajor(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Major device number is out of range: " + i);
        }
        this.devMajor = i;
    }

    public int getDevMinor() {
        return this.devMinor;
    }

    public void setDevMinor(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Minor device number is out of range: " + i);
        }
        this.devMinor = i;
    }

    public boolean isExtended() {
        return this.isExtended;
    }

    public long getRealSize() {
        return this.realSize;
    }

    public boolean isGNUSparse() {
        return isOldGNUSparse() || isPaxGNUSparse();
    }

    public boolean isOldGNUSparse() {
        return this.linkFlag == 83;
    }

    public boolean isPaxGNUSparse() {
        return this.paxGNUSparse;
    }

    public boolean isStarSparse() {
        return this.starSparse;
    }

    public boolean isGNULongLinkEntry() {
        return this.linkFlag == 75;
    }

    public boolean isGNULongNameEntry() {
        return this.linkFlag == 76;
    }

    public boolean isPaxHeader() {
        byte b = this.linkFlag;
        return b == 120 || b == 88;
    }

    public boolean isGlobalPaxHeader() {
        return this.linkFlag == 103;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public boolean isDirectory() {
        File file = this.file;
        if (file != null) {
            return file.isDirectory();
        }
        if (this.linkFlag == 53) {
            return true;
        }
        return (isPaxHeader() || isGlobalPaxHeader() || !getName().endsWith("/")) ? false : true;
    }

    public boolean isFile() {
        File file = this.file;
        if (file != null) {
            return file.isFile();
        }
        byte b = this.linkFlag;
        if (b == 0 || b == 48) {
            return true;
        }
        return !getName().endsWith("/");
    }

    public boolean isSymbolicLink() {
        return this.linkFlag == 50;
    }

    public boolean isLink() {
        return this.linkFlag == 49;
    }

    public boolean isCharacterDevice() {
        return this.linkFlag == 51;
    }

    public boolean isBlockDevice() {
        return this.linkFlag == 52;
    }

    public boolean isFIFO() {
        return this.linkFlag == 54;
    }

    public boolean isSparse() {
        return isGNUSparse() || isStarSparse();
    }

    public Map<String, String> getExtraPaxHeaders() {
        return Collections.unmodifiableMap(this.extraPaxHeaders);
    }

    public void clearExtraPaxHeaders() {
        this.extraPaxHeaders.clear();
    }

    public void addPaxHeader(String str, String str2) {
        processPaxHeader(str, str2);
    }

    public String getExtraPaxHeader(String str) {
        return this.extraPaxHeaders.get(str);
    }

    void updateEntryFromPaxHeaders(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            processPaxHeader(entry.getKey(), entry.getValue(), map);
        }
    }

    private void processPaxHeader(String str, String str2) {
        processPaxHeader(str, str2, this.extraPaxHeaders);
    }

    private void processPaxHeader(String str, String str2, Map<String, String> map) {
        str.hashCode();
        switch (str) {
            case "SCHILY.devmajor":
                setDevMajor(Integer.parseInt(str2));
                break;
            case "SCHILY.devminor":
                setDevMinor(Integer.parseInt(str2));
                break;
            case "GNU.sparse.realsize":
                fillGNUSparse1xData(map);
                break;
            case "GNU.sparse.size":
                fillGNUSparse0xData(map);
                break;
            case "gid":
                setGroupId(Long.parseLong(str2));
                break;
            case "uid":
                setUserId(Long.parseLong(str2));
                break;
            case "path":
                setName(str2);
                break;
            case "size":
                setSize(Long.parseLong(str2));
                break;
            case "gname":
                setGroupName(str2);
                break;
            case "mtime":
                setModTime((long) (Double.parseDouble(str2) * 1000.0d));
                break;
            case "uname":
                setUserName(str2);
                break;
            case "SCHILY.filetype":
                if ("sparse".equals(str2)) {
                    fillStarSparseData(map);
                    break;
                }
                break;
            case "linkpath":
                setLinkName(str2);
                break;
            default:
                this.extraPaxHeaders.put(str, str2);
                break;
        }
    }

    public TarArchiveEntry[] getDirectoryEntries() {
        File file = this.file;
        if (file == null || !file.isDirectory()) {
            return EMPTY_TAR_ARCHIVE_ENTRIES;
        }
        String[] list = this.file.list();
        if (list == null) {
            return EMPTY_TAR_ARCHIVE_ENTRIES;
        }
        int length = list.length;
        TarArchiveEntry[] tarArchiveEntryArr = new TarArchiveEntry[length];
        for (int i = 0; i < length; i++) {
            tarArchiveEntryArr[i] = new TarArchiveEntry(new File(this.file, list[i]));
        }
        return tarArchiveEntryArr;
    }

    public void writeEntryHeader(byte[] bArr) {
        try {
            try {
                writeEntryHeader(bArr, TarUtils.DEFAULT_ENCODING, false);
            } catch (IOException unused) {
                writeEntryHeader(bArr, TarUtils.FALLBACK_ENCODING, false);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeEntryHeader(byte[] bArr, ZipEncoding zipEncoding, boolean z) throws IOException {
        int iWriteEntryHeaderField = writeEntryHeaderField(this.modTime, bArr, writeEntryHeaderField(this.size, bArr, writeEntryHeaderField(this.groupId, bArr, writeEntryHeaderField(this.userId, bArr, writeEntryHeaderField(this.mode, bArr, TarUtils.formatNameBytes(this.name, bArr, 0, 100, zipEncoding), 8, z), 8, z), 8, z), 12, z), 12, z);
        int i = 0;
        int i2 = iWriteEntryHeaderField;
        while (i < 8) {
            bArr[i2] = 32;
            i++;
            i2++;
        }
        bArr[i2] = this.linkFlag;
        for (int iWriteEntryHeaderField2 = writeEntryHeaderField(this.devMinor, bArr, writeEntryHeaderField(this.devMajor, bArr, TarUtils.formatNameBytes(this.groupName, bArr, TarUtils.formatNameBytes(this.userName, bArr, TarUtils.formatNameBytes(this.version, bArr, TarUtils.formatNameBytes(this.magic, bArr, TarUtils.formatNameBytes(this.linkName, bArr, i2 + 1, 100, zipEncoding), 6), 2), 32, zipEncoding), 32, zipEncoding), 8, z), 8, z); iWriteEntryHeaderField2 < bArr.length; iWriteEntryHeaderField2++) {
            bArr[iWriteEntryHeaderField2] = 0;
        }
        TarUtils.formatCheckSumOctalBytes(TarUtils.computeCheckSum(bArr), bArr, iWriteEntryHeaderField, 8);
    }

    private int writeEntryHeaderField(long j, byte[] bArr, int i, int i2, boolean z) {
        if (!z && (j < 0 || j >= (1 << ((i2 - 1) * 3)))) {
            return TarUtils.formatLongOctalBytes(0L, bArr, i, i2);
        }
        return TarUtils.formatLongOctalOrBinaryBytes(j, bArr, i, i2);
    }

    public void parseTarHeader(byte[] bArr) {
        try {
            try {
                parseTarHeader(bArr, TarUtils.DEFAULT_ENCODING);
            } catch (IOException unused) {
                parseTarHeader(bArr, TarUtils.DEFAULT_ENCODING, true, false);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void parseTarHeader(byte[] bArr, ZipEncoding zipEncoding) throws IOException {
        parseTarHeader(bArr, zipEncoding, false, false);
    }

    private void parseTarHeader(byte[] bArr, ZipEncoding zipEncoding, boolean z, boolean z2) throws IOException {
        String name;
        String name2;
        String name3;
        String name4;
        String name5;
        String name6;
        if (z) {
            name = TarUtils.parseName(bArr, 0, 100);
        } else {
            name = TarUtils.parseName(bArr, 0, 100, zipEncoding);
        }
        this.name = name;
        this.mode = (int) parseOctalOrBinary(bArr, 100, 8, z2);
        this.userId = (int) parseOctalOrBinary(bArr, 108, 8, z2);
        this.groupId = (int) parseOctalOrBinary(bArr, 116, 8, z2);
        this.size = TarUtils.parseOctalOrBinary(bArr, 124, 12);
        this.modTime = parseOctalOrBinary(bArr, 136, 12, z2);
        this.checkSumOK = TarUtils.verifyCheckSum(bArr);
        this.linkFlag = bArr[156];
        if (z) {
            name2 = TarUtils.parseName(bArr, 157, 100);
        } else {
            name2 = TarUtils.parseName(bArr, 157, 100, zipEncoding);
        }
        this.linkName = name2;
        this.magic = TarUtils.parseName(bArr, TarConstants.MAGIC_OFFSET, 6);
        this.version = TarUtils.parseName(bArr, TarConstants.VERSION_OFFSET, 2);
        if (z) {
            name3 = TarUtils.parseName(bArr, 265, 32);
        } else {
            name3 = TarUtils.parseName(bArr, 265, 32, zipEncoding);
        }
        this.userName = name3;
        if (z) {
            name4 = TarUtils.parseName(bArr, 297, 32);
        } else {
            name4 = TarUtils.parseName(bArr, 297, 32, zipEncoding);
        }
        this.groupName = name4;
        byte b = this.linkFlag;
        if (b == 51 || b == 52) {
            this.devMajor = (int) parseOctalOrBinary(bArr, 329, 8, z2);
            this.devMinor = (int) parseOctalOrBinary(bArr, 337, 8, z2);
        }
        int iEvaluateType = evaluateType(bArr);
        if (iEvaluateType == 2) {
            this.isExtended = TarUtils.parseBoolean(bArr, 482);
            this.realSize = TarUtils.parseOctal(bArr, 483, 12);
            return;
        }
        if (iEvaluateType == 4) {
            if (z) {
                name5 = TarUtils.parseName(bArr, 345, TarConstants.PREFIXLEN_XSTAR);
            } else {
                name5 = TarUtils.parseName(bArr, 345, TarConstants.PREFIXLEN_XSTAR, zipEncoding);
            }
            if (name5.length() > 0) {
                this.name = name5 + "/" + this.name;
                return;
            }
            return;
        }
        if (z) {
            name6 = TarUtils.parseName(bArr, 345, TarConstants.PREFIXLEN);
        } else {
            name6 = TarUtils.parseName(bArr, 345, TarConstants.PREFIXLEN, zipEncoding);
        }
        if (isDirectory() && !this.name.endsWith("/")) {
            this.name += "/";
        }
        if (name6.length() > 0) {
            this.name = name6 + "/" + this.name;
        }
    }

    private long parseOctalOrBinary(byte[] bArr, int i, int i2, boolean z) {
        if (z) {
            try {
                return TarUtils.parseOctalOrBinary(bArr, i, i2);
            } catch (IllegalArgumentException unused) {
                return -1L;
            }
        }
        return TarUtils.parseOctalOrBinary(bArr, i, i2);
    }

    private static String normalizeFileName(String str, boolean z) {
        String lowerCase;
        int iIndexOf;
        if (!z && (lowerCase = System.getProperty(SystemProperties.OS_NAME).toLowerCase(Locale.ENGLISH)) != null) {
            if (lowerCase.startsWith("windows")) {
                if (str.length() > 2) {
                    char cCharAt = str.charAt(0);
                    if (str.charAt(1) == ':' && ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z'))) {
                        str = str.substring(2);
                    }
                }
            } else if (lowerCase.contains("netware") && (iIndexOf = str.indexOf(58)) != -1) {
                str = str.substring(iIndexOf + 1);
            }
        }
        String strReplace = str.replace(File.separatorChar, IOUtils.DIR_SEPARATOR_UNIX);
        while (!z && strReplace.startsWith("/")) {
            strReplace = strReplace.substring(1);
        }
        return strReplace;
    }

    private int evaluateType(byte[] bArr) {
        if (ArchiveUtils.matchAsciiBuffer(TarConstants.MAGIC_GNU, bArr, TarConstants.MAGIC_OFFSET, 6)) {
            return 2;
        }
        if (ArchiveUtils.matchAsciiBuffer("ustar\u0000", bArr, TarConstants.MAGIC_OFFSET, 6)) {
            return ArchiveUtils.matchAsciiBuffer(TarConstants.MAGIC_XSTAR, bArr, TarConstants.XSTAR_MAGIC_OFFSET, 4) ? 4 : 3;
        }
        return 0;
    }

    void fillGNUSparse0xData(Map<String, String> map) {
        this.paxGNUSparse = true;
        this.realSize = Integer.parseInt(map.get("GNU.sparse.size"));
        if (map.containsKey("GNU.sparse.name")) {
            this.name = map.get("GNU.sparse.name");
        }
    }

    void fillGNUSparse1xData(Map<String, String> map) {
        this.paxGNUSparse = true;
        this.realSize = Integer.parseInt(map.get("GNU.sparse.realsize"));
        this.name = map.get("GNU.sparse.name");
    }

    void fillStarSparseData(Map<String, String> map) {
        this.starSparse = true;
        if (map.containsKey("SCHILY.realsize")) {
            this.realSize = Long.parseLong(map.get("SCHILY.realsize"));
        }
    }
}
