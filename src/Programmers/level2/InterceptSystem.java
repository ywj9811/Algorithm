package Programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterceptSystem {
    public static void main(String[] args) {
        int[][] targets = new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
        CalculateIntercept calculateIntercept = new CalculateIntercept(targets);
        int result = calculateIntercept.calculateCount();

        System.out.println(result);
    }
}

class CalculateIntercept {
    private List<Bomb> bombs;
    public CalculateIntercept(int[][] targets) {
        bombs = new ArrayList<>();

        Arrays.stream(targets)
                .forEach(target -> {
                    bombs.add(new Bomb(target[0], target[1]));
                });

        bombs.sort((o1, o2) -> o1.getEnd() - o2.getEnd());
    }

    public int calculateCount() {
        int stand = 0;
        int cnt = 1;

        for (int i = 1; i < bombs.size(); i++) {
            if (bombs.get(stand).getEnd() <= bombs.get(i).getStart()) {
                stand = i;
                cnt++;
            }
        }

        return cnt;
    }
}

class Bomb {
    private int start;
    private int end;

    public Bomb(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
