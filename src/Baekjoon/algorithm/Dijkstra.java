package Baekjoon.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dijkstra {
    static List<Point>[] nodes;
    private static final int INF = 100_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        int[] sum = new int[v+1];
        nodes = new List[v+1];

        Arrays.fill(sum, INF);

        for(int i = 1; i <= v; i++){
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[Integer.parseInt(st.nextToken())]
                    .add(
                            new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))
                    );
        }

        PriorityQueue<Point> queue = new PriorityQueue<>();
        boolean[] check = new boolean[v + 1];
        queue.add(new Point(start, 0));
        sum[start] = 0;

        while(!queue.isEmpty()){
            Point curNode = queue.poll();
            int cur = curNode.end;

            if(check[cur] == true) continue;
            check[cur] = true;

            for(Point node : nodes[cur]){
                if(sum[node.end] > sum[cur] + node.weight){
                    sum[node.end] = sum[cur] + node.weight;
                    queue.add(new Point(node.end, sum[node.end]));
                }
            }
        }

        for(int i = 1; i <= v; i++){
            if(sum[i] == INF)
                System.out.println("INF");
            else
                System.out.println(sum[i]);
        }
    }
}
class Point implements Comparable<Point>{
    int end, weight;

    public Point(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Point o) {
        return weight - o.weight;
    }
}
