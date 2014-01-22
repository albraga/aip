package planning;

public class MC {

    int[] initialState = {3, 3, 1, 0, 0, 0};

    int[] action(int[] s, int m, int c, int b) {
        if (((m + c) * -1) <= 2 && (m * -1) > 0 && (c * -1) > 0 && s[0] >= m && s[1] >= c && s[2] >= b) {
            s[0] += m;
            s[1] += c;
            s[2] += b;
            s[3] = (s[0] - 3) * -1;
            s[4] = (s[1] - 3) * -1;
            s[5] = (s[2] - 1) * -1;
        }
        
        return s;
    }
}
