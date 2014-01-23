
package mc;

public class Action {
    
    public static final int[][] MOVES = {{0,1},{1,0},{1,1},{0,2},{2,0}};
    
    public static State moveR(int[] s, int m, int c) {
        int b = 1;
        if (s[2] == 1) {
            s[0] -= m;
            s[1] -= c;
            s[2] -= b;
            State st = new State(s[0], s[1], s[2]);
            if(st.getS()[1] > st.getS()[0])
                return null;
            return st;
        } else {
            return null;
        }
    }
    public static State moveL(int[] s, int m, int c) {
        int b = 1;
        if (s[5] == 1) {
            s[0] += m;
            s[1] += c;
            s[2] += b;
            return new State(s[0], s[1], s[2]);
        } else {
            return null;
        }
    }
    
}
