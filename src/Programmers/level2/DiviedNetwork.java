package Programmers.level2;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class DiviedNetwork {
    private boolean visited[];
    private int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int solution = new DiviedNetwork().solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}});
        System.out.println(solution);
    }

    public int solution(int n, int[][] wires) {

        for (int i = 0; i < wires.length; i++) {
            List<Integer>[] lists = makeList(n, wires);
            visited = new boolean[n+1];
            int a = wires[i][0];
            int b = wires[i][1];

            lists[a].remove(Integer.valueOf(b));
            lists[b].remove(Integer.valueOf(a));
            int sumA = recursive(a, lists);
            int sumB = recursive(b, lists);

            min = Math.min(min, abs(sumA - sumB));
        }

        return min;
    }

    private List<Integer>[] makeList(int n, int[][] wires) {
        List<Integer>[] list = new List[n+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] wire : wires) {
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }
        return list;
    }

    public int recursive(int start, List<Integer>[] list) {
        visited[start] = true;
        int cnt = 1;

        for (int i = 0; i < list[start].size(); i++) {
            if (visited[list[start].get(i)]) continue;
            cnt += recursive(list[start].get(i), list);
        }
        return cnt;
    }
}
