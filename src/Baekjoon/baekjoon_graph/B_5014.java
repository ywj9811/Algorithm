package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_5014 {
    public static void main(String[] args) {
        CalculateFloor calculateFloor = new CalculateFloor();
        calculateFloor.setting();
        int result = calculateFloor.getCnt();
        if (result == -1) {
            System.out.println("use the stairs");
            return;
        }
        System.out.println(result);
    }

}

class CalculateFloor {
    private int f;
    private int s;
    private int g;
    private int u;
    private int d;
    private boolean[] visited;

    public void setting() {
        Scanner sc = new Scanner(System.in);
        f = sc.nextInt();
        s = sc.nextInt();
        g = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        visited = new boolean[f+1];
    }

    public int getCnt() {
        PriorityQueue<Floor> queue = new PriorityQueue<>((o1, o2) -> o1.getCnt() - o2.getCnt());
        queue.add(new Floor(s, 0));
        visited[s] = true;
        int result = -1;
        while (!queue.isEmpty()) {
            Floor floor = queue.poll();
            if (floor.getCur() == g) {
                result = floor.getCnt();
                break;
            }
            if (floor.getCur() + u <= f && !visited[floor.getCur() + u]) {
                visited[floor.getCur() + u] = true;
                queue.add(new Floor(floor.getCur() + u, floor.getCnt() + 1));
            }
            if (floor.getCur() - d > 0 && !visited[floor.getCur() - d]) {
                visited[floor.getCur() - d] = true;
                queue.add(new Floor(floor.getCur() - d, floor.getCnt() + 1));
            }
        }

        return result;
    }
}

class Floor {
    private int cur;
    private int cnt;

    public Floor(int cur, int cnt) {
        this.cur = cur;
        this.cnt = cnt;
    }

    public int getCur() {
        return cur;
    }

    public int getCnt() {
        return cnt;
    }
}
