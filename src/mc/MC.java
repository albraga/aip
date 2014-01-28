package mc;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MC {

    private static final int[][] ACT = {{0, 1, 1}, {1, 0, 1}, {1, 1, 1}, {0, 2, 1}, {2, 0, 1}};

    public List<int[]> moveR(List<int[]> sInList) {
        List<int[]> sList = new ArrayList<>();
        for (int[] sIn : sInList) {
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
                if (sTemp[0] <= 3 && sTemp[0] >= 0 && sTemp[1] <= 3 && sTemp[1] >= 0 && sTemp[2] <= 1 && sTemp[2] >= 0) {
                    if (!Arrays.equals(new int[]{sIn[6], sIn[7], sIn[8]}, new int[]{ACT[i][0], ACT[i][1], ACT[i][2]})) {
                        if (sTemp[0] >= sTemp[1] || sTemp[0] == 0 && sTemp[3] >= sTemp[4] || sTemp[3] == 0) {
                            sList.add(sTemp);
                        }
                    }
                }
            }
        }
        return removeTwofold(sList);
        //return sList;
    }

    public List<int[]> moveL(List<int[]> sInList) {
        List<int[]> sList = new ArrayList<>();
        for (int[] sIn : sInList) {
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
                if (sTemp[0] <= 3 && sTemp[0] >= 0 && sTemp[1] <= 3 && sTemp[1] >= 0 && sTemp[2] <= 1 && sTemp[2] >= 0) {
                    if (!Arrays.equals(new int[]{sIn[6], sIn[7], sIn[8]}, new int[]{ACT[i][0], ACT[i][1], ACT[i][2]})) {
                        if (sTemp[0] >= sTemp[1] || sTemp[0] == 0 && sTemp[3] >= sTemp[4] || sTemp[3] == 0) {
                            sList.add(sTemp);
                        }
                    }
                }
            }
        }
        return removeTwofold(sList);
        //return sList;
    }

    private List<int[]> removeTwofold(List<int[]> list) {
        int count = 0;
        List<int[]> filtered = new ArrayList<>();
        for (int ii = 0; ii < list.size(); ii++) {
            for (int i = 0; i < list.size(); i++) {
                if (Arrays.equals(new int[]{list.get(i)[0], list.get(i)[1], list.get(i)[2]}, new int[]{list.get(ii)[0], list.get(ii)[1], list.get(ii)[2]})) {
                    count++;
                }
            }
            if (count == 2) {
                filtered.add(list.get(ii));
            }
            count = 0;
        }
        return filtered;
    }
}
