package Baekjoon.baekjoon_graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_11657 {
    private static int n;
    private static int m;
    private static long values[];
    private static Node[] nodes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        values = new long[n+1];
        nodes = new Node[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            Node node = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            nodes[i] = node;
        }

        Arrays.fill(values, Integer.MAX_VALUE);
        values[0] = 0;
        values[1] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Node node = nodes[j];

                if (values[node.start] != Integer.MAX_VALUE && values[node.end] > values[node.start] + node.value) {
                    values[node.end] = values[node.start] + node.value;
                }
                System.out.println(node.end + " 노드 값 : " + values[node.end]);
                /**
                 * 벨만 포드 알고리즘 수행 -> N-1 만큼 반복 N번째 반복에서 업데이트가 발생하면 음수 사이클 존재하는 것
                 */
            }
        }

        for (int i = 0; i < m; i++) {
            Node node = nodes[i];
            if (values[node.start] != Integer.MAX_VALUE && values[node.end] > values[node.start] + node.value) {
                System.out.println(-1);
                return;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (values[i] == Integer.MAX_VALUE) {
                System.out.println(-1);
                continue;
            }
            System.out.println(values[i]);
        }
    }

    private static class Node {
        int start;
        int end;
        int value;

        public Node(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}
