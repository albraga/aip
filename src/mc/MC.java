package mc;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MC {

    private static final int[][] ACT = {{0, 1, 1}, {1, 0, 1}, {1, 1, 1}, {0, 2, 1}, {2, 0, 1}};

    public List<int[]> moveR(int[] sIn) {
        List<int[]> sList = new ArrayList<>();
        for (int i = 0; i < ACT.length; i++) {
            int[] sTemp = new int[9];
            sTemp[0] = sIn[0] - ACT[i][0];
            sTemp[1] = sIn[1] - ACT[i][1];
            sTemp[2] = sIn[2] - ACT[i][2];
            sTemp[3] = sIn[3] + ACT[i][0];
            sTemp[4] = sIn[4] + ACT[i][1];
            sTemp[5] = sIn[5] + ACT[i][2];
            sTemp[6] = ACT[i][0];
            sTemp[7] = ACT[i][1];
            sTemp[8] = ACT[i][2];
            if (!Arrays.equals(new int[]{sIn[6], sIn[7], sIn[8]}, new int[]{ACT[i][0], ACT[i][1], ACT[i][2]})) {
                if (sTemp[0] >= sTemp[1] || sTemp[0] == 0 && sTemp[3] >= sTemp[4] || sTemp[3] == 0) {
                    sList.add(sTemp);
                }
            }
        }
        return sList;
    }

    public List<int[]> moveL(int[] sIn) {
        List<int[]> sList = new ArrayList<>();
        for (int i = 0; i < ACT.length; i++) {
            int[] sTemp = new int[9];
            sTemp[0] = sIn[0] + ACT[i][0];
            sTemp[1] = sIn[1] + ACT[i][1];
            sTemp[2] = sIn[2] + ACT[i][2];
            sTemp[3] = sIn[3] - ACT[i][0];
            sTemp[4] = sIn[4] - ACT[i][1];
            sTemp[5] = sIn[5] - ACT[i][2];
            sTemp[6] = ACT[i][0];
            sTemp[7] = ACT[i][1];
            sTemp[8] = ACT[i][2];
            if (!Arrays.equals(new int[]{sIn[6], sIn[7], sIn[8]}, new int[]{ACT[i][0], ACT[i][1], ACT[i][2]})) {
                if (sTemp[0] >= sTemp[1] || sTemp[0] == 0 && sTemp[3] >= sTemp[4] || sTemp[3] == 0) {
                    sList.add(sTemp);
                }
            }
        }
        return sList;
    }
}
