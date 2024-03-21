package Baekjoon.baekjoon_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B_1167 {
    private static List<List<Integer>>[] nodes;
    private static boolean[][] visited;
    private static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        nodes = new List[n+1];
        nodes[0] = new ArrayList<>();
        visited = new boolean[n+1][n+1];

        for (int i = 1 ; i < n+1; i++) {
            nodes[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            while (st.hasMoreTokens()) {
                List<Integer> eachNode = new ArrayList<>();
                int next = Integer.parseInt(st.nextToken());
                if (next == -1)
                    break ;
                int length = Integer.parseInt(st.nextToken());
                eachNode.add(i);
                eachNode.add(next);
                eachNode.add(length);
                nodes[i].add(eachNode);
            }
        }

            dfs(0, 1, 0);

            System.out.println(max);
    }

    private static void dfs(int from, int to, int sum) {
        visited[from][to] = true;
        int size = nodes[to].size();
        for (int i = 0; i < size; i++) {
            List<Integer> eachNodes = nodes[to].get(i);
            from = eachNodes.get(0);
            to = eachNodes.get(1);
            Integer length = eachNodes.get(2);
            if (visited[from][to]) {
                if (max < sum)
                    max = sum;
                return;
            }
            sum += length;
            dfs(from, to, sum);
        }
    }
}
