package in.gov.eci.bloapp.utils;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class Verhoeff {
    static int[][] d = {new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{1, 2, 3, 4, 0, 6, 7, 8, 9, 5}, new int[]{2, 3, 4, 0, 1, 7, 8, 9, 5, 6}, new int[]{3, 4, 0, 1, 2, 8, 9, 5, 6, 7}, new int[]{4, 0, 1, 2, 3, 9, 5, 6, 7, 8}, new int[]{5, 9, 8, 7, 6, 0, 4, 3, 2, 1}, new int[]{6, 5, 9, 8, 7, 1, 0, 4, 3, 2}, new int[]{7, 6, 5, 9, 8, 2, 1, 0, 4, 3}, new int[]{8, 7, 6, 5, 9, 3, 2, 1, 0, 4}, new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}};
    static int[][] p = {new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{1, 5, 7, 6, 2, 8, 3, 0, 9, 4}, new int[]{5, 8, 0, 3, 7, 9, 6, 1, 4, 2}, new int[]{8, 9, 1, 6, 0, 4, 3, 5, 2, 7}, new int[]{9, 4, 5, 3, 1, 2, 6, 8, 7, 0}, new int[]{4, 2, 8, 6, 5, 7, 3, 9, 0, 1}, new int[]{2, 7, 9, 3, 8, 0, 6, 4, 1, 5}, new int[]{7, 0, 4, 6, 9, 1, 3, 2, 5, 8}};
    static int[] inv = {0, 4, 3, 2, 1, 5, 6, 7, 8, 9};

    public static boolean validateVerhoeff(String num) {
        int[] iArrStringToReversedIntArray = StringToReversedIntArray(num);
        int i = 0;
        for (int i2 = 0; i2 < iArrStringToReversedIntArray.length; i2++) {
            i = d[i][p[i2 % 8][iArrStringToReversedIntArray[i2]]];
        }
        return i == 0;
    }

    private static int[] StringToReversedIntArray(String num) {
        int[] iArr = new int[num.length()];
        int i = 0;
        while (i < num.length()) {
            int i2 = i + 1;
            iArr[i] = Integer.parseInt(num.substring(i, i2));
            i = i2;
        }
        return Reverse(iArr);
    }

    private static int[] Reverse(int[] myArray) {
        int[] iArr = new int[myArray.length];
        int i = 0;
        while (i < myArray.length) {
            int i2 = i + 1;
            iArr[i] = myArray[myArray.length - i2];
            i = i2;
        }
        return iArr;
    }
}
