
package mc;

public class Action {
    
    public static final int[][] MOVES = {{0,1},{1,0},{1,1},{0,2},{2,0}};
    
    public static State moveR(State state, int m, int c) {
        int[] s = state.getS();
        int b = 1;
        if (s[2] == 1 && m + c < 3 && m + c > 0) {
            s[0] -= m;
            s[1] -= c;
            s[2] -= b;
            return new State(s[0], s[1], s[2]);

        } else {
            return null;
        }
    }
    public static State moveL(State state, int m, int c) {
        int[] s = state.getS();
        int b = 1;
        if (s[5] == 1 && m + c < 3 && m + c > 0) {
            s[0] += m;
            s[1] += c;
            s[2] += b;
            return new State(s[0], s[1], s[2]);
        } else {
            return null;
        }
    }
    
}
