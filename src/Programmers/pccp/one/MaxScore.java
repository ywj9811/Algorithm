package Programmers.pccp.one;

public class MaxScore {
    private int n;
    private int m;
    private boolean[] visited;
    private int max = 0;

    public int solution(int[][] ability) {
        n = ability.length;
        m = ability[0].length;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(ability, 1, ability[i][0]);
            visited[i] = false;
        }

        return max;
    }

    public void dfs(int[][] ability, int depth, int sum) {
        if (depth == m) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            dfs(ability, depth+1, sum + ability[i][depth]);
            visited[i] = false;
        }
    }
}
