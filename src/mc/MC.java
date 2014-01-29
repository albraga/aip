package mc;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class MC {

    private static final int[][] ACT = {{0, 1, 1}, {1, 0, 1}, {1, 1, 1}, {0, 2, 1}, {2, 0, 1}};
    private static LinkedList<List<int[]>> lList = new LinkedList<>();

    public void search(List<int[]> sList) {
        lList.addLast(removeDup(sList));
        for (int[] s : lList.getLast()) {
            System.out.println(s[0] + " " + s[1] + " " + s[2] + " " + s[3] + " " + s[4] + " " + s[5]);
        }
        System.out.println("////////////////////////////////////////////////////////////");
        lList.addLast(removeDup(moveR(lList.getLast())));
        if (isGoal(lList.getLast())) {
            return;
        }
        for (int[] s : lList.getLast()) {
            System.out.println(s[0] + " " + s[1] + " " + s[2] + " " + s[3] + " " + s[4] + " " + s[5]);
        }
        System.out.println("////////////////////////////////////////////////////////////");
        List<int[]> ml = removeDup(moveL(removeDup(lList.getLast())));

        for (int[] s : ml) {
            System.out.println(s[0] + " " + s[1] + " " + s[2] + " " + s[3] + " " + s[4] + " " + s[5]);
        }
        search(ml);
    }

    private boolean isGoal(List<int[]> sList) {
        for (int[] stt : sList) {
            if (Arrays.equals(new int[]{stt[0], stt[1], stt[2]}, new int[]{0, 0, 0})) {
                return true;
            }
        }
        return false;
    }

    private List<int[]> moveR(List<int[]> sInList) {
        List<int[]> sList = new ArrayList<>();
        for (int[] sIn : sInList) {
            for (int i = 0; i < ACT.length; i++) {
                int[] sTemp = new int[6];
                sTemp[0] = sIn[0] - ACT[i][0];
                sTemp[1] = sIn[1] - ACT[i][1];
                sTemp[2] = sIn[2] - ACT[i][2];
                sTemp[3] = sIn[3] + ACT[i][0];
                sTemp[4] = sIn[4] + ACT[i][1];
                sTemp[5] = sIn[5] + ACT[i][2];
                if (sTemp[0] <= 3 && sTemp[0] >= 0 && sTemp[1] <= 3 && sTemp[1] >= 0 && sTemp[2] <= 1 && sTemp[2] >= 0) {
                    if (sTemp[0] >= sTemp[1] || sTemp[0] == 0 && sTemp[3] >= sTemp[4] || sTemp[3] == 0) {
                        sList.add(sTemp);
                    }

                }
            }
        }
        return removeDup(sList);
    }

    private List<int[]> moveL(List<int[]> sInList) {
        List<int[]> sList = new ArrayList<>();
        for (int[] sIn : sInList) {
            for (int i = 0; i < ACT.length; i++) {
                int[] sTemp = new int[6];
                sTemp[0] = sIn[0] + ACT[i][0];
                sTemp[1] = sIn[1] + ACT[i][1];
                sTemp[2] = sIn[2] + ACT[i][2];
                sTemp[3] = sIn[3] - ACT[i][0];
                sTemp[4] = sIn[4] - ACT[i][1];
                sTemp[5] = sIn[5] - ACT[i][2];
                if (sTemp[0] <= 3 && sTemp[0] >= 0 && sTemp[1] <= 3 && sTemp[1] >= 0 && sTemp[2] <= 1 && sTemp[2] >= 0) {
                    if (sTemp[0] >= sTemp[1] || sTemp[0] == 0 && sTemp[3] >= sTemp[4] || sTemp[3] == 0) {
                        sList.add(sTemp);
                    }

                }
            }
        }
        return removeDup(sList);
    }

    private List<int[]> removeDup(List<int[]> list) {
        HashSet<int[]> hs = new HashSet<>();
        hs.addAll(list);
        list.clear();
        list.addAll(hs);
        return list;
    }

    private List<int[]> removeParent(List<int[]> grandpa, List<int[]> parent, List<int[]> child) {
        List<int[]> dup = new ArrayList<>();
        for (int[] p : parent) {
            for (int[] c : child) {
                if (Arrays.equals(c, p)) {
                    dup.add(c);
                }
            }
        }
        for (int[] pa : grandpa) {
            for (int[] c : child) {
                if (Arrays.equals(c, pa)) {
                    dup.add(c);
                }
            }
        }
        for (int[] d : dup) {
            child.remove(d);
        }
        return child;
    }
}
