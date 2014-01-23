package mc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MC {

    public void search(List<State> stI) {
        List<State> stR = new ArrayList<>();
        for (int i = 0; i < stI.size(); i++) {
            for (int ii = 0; ii < Action.MOVES.length; ii++) {
                State st = Action.moveR(stI.get(i).getS(), Action.MOVES[ii][0], Action.MOVES[ii][1]);
                if (st != null) {
                    if (Arrays.equals(st.getS(), new int[]{0, 0, 0, 3, 3, 1})) {
                        System.out.println("achou!");
                        return;
                    }
                    stR.add(st);
                }
            }
        }
        List<State> stL = new ArrayList<>();
        for (int i = 0; i < stR.size(); i++) {
            for (int ii = 0; ii < Action.MOVES.length; ii++) {
                State st = Action.moveL(stR.get(i).getS(), Action.MOVES[ii][0], Action.MOVES[ii][1]);
                if (st != null) {
                    stL.add(st);
                }
            }
        }
        search(stL);
    }
}
