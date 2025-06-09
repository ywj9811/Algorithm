package Programmers.level3;

import java.util.*;

public class ReturnSolider {
    private static boolean visited[];
    private static int dp[];
    private static List<Integer> link[];

    public static void main(String[] args) {
        int n1 = 3;
        int[][] roads1 = {{1, 2}, {2, 3}};
        int[] sources1 = {2, 3};
        int destination1 = 1;
        System.out.println("Test 1: " + Arrays.toString(solution(n1, roads1, sources1, destination1)));

        // 테스트 케이스 2
        int n2 = 5;
        int[][] roads2 = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
        int[] sources2 = {1, 3, 5};
        int destination2 = 5;
        System.out.println("Test 2: " + Arrays.toString(solution(n2, roads2, sources2, destination2)));
    }
    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 역방향 bfs를 사용. destination에서 bfs를 해서 sources에 해당하는 값들을 넣어주면 될 듯
        visited = new boolean[n+1];
        dp = new int[n+1];
        link = new List[n+1];
        Arrays.fill(dp, -1);
        for (int i = 0; i < link.length; i++) {
            link[i] = new ArrayList<>();
        }
        for (int i = 0; i < roads.length; i++) {
            link[roads[i][0]].add(roads[i][1]);
            link[roads[i][1]].add(roads[i][0]);
        }
        bfs(destination);

        int[] result = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            result[i] = dp[sources[i]];
        }

        return result;
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        dp[start] = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<Integer> links = link[poll];
            for (int next : links) {
                if (visited[next])
                    continue;
                visited[next] = true;
                queue.add(next);
                dp[next] = dp[poll]+1;
            }
        }
    }
}
