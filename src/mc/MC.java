package mc;

import java.util.ArrayList;
import java.util.List;

public class MC {

    private final int[][] action = {{0, 1}, {1, 0}, {1, 1}, {0, 2}, {2, 0}};

    public int[][] moveR(int[] stt) {
        int[][] sts = new int[5][2];
        for (int ii = 0; ii < sts.length; ii++) {
            int a = stt[8];
            int b = stt[9];
            int c = stt[10];
            int d = stt[11];
            int e = stt[12];
            int f = stt[13];
            int g = action[ii][0];
            int h = action[ii][1];
            int i = stt[8] - g;
            int j = stt[9] - h;
            int k = 0;
            int l = 3 - i;
            int m = 3 - j;
            int n = 1;
            sts[ii] = new int[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n};
        }
        List<int[]> stList = new ArrayList<>();
        for (int[] s : sts) {
            if(s[8] >= s[9] && s[11] >= s[12]) {
                stList.add(s);
            }
        }
        int[][] filtered = new int[stList.size()][14];
        for (int i = 0; i < stList.size(); i++) {
            filtered[i] = stList.get(i);
        }
        return filtered;
    }
    
    public int[][] moveL(int[] stt) {
        int[][] sts = new int[5][2];
        for (int ii = 0; ii < sts.length; ii++) {
            int a = stt[8];
            int b = stt[9];
            int c = stt[10];
            int d = stt[11];
            int e = stt[12];
            int f = stt[13];
            int g = action[ii][0];
            int h = action[ii][1];
            int i = stt[8] - action[ii][0];
            int j = stt[9] - action[ii][1];
            int k = 1;
            int l = stt[11] + action[ii][0];
            int m = stt[12] + action[ii][1];
            int n = 0;
            sts[ii] = new int[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n};
        }
        List<int[]> stLeft = new ArrayList<>();
        for (int[] s : sts) {
            if(s[8] >= s[9] && s[11] >= s[12]) {
                stLeft.add(s);
            }
        }
        int[][] filtered = new int[stLeft.size()][14];
        for (int i = 0; i < stLeft.size(); i++) {
            filtered[i] = stLeft.get(i);
        }
        return filtered;
    }
}
