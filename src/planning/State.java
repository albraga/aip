package planning;

public class State {

    private final int[] stt = new int[6];

    public State(int m, int c, int b) {
        stt[0] = m;
        stt[1] = c;
        stt[2] = b;
        stt[3] = (stt[0] - 3) * -1;
        stt[4] = (stt[1] - 3) * -1;
        stt[5] = (stt[2] - 1) * -1;
    }

    public int[] getS() {
        return stt;
    }
    
}
