package Baekjoon.baekjoon_graph;

import java.util.*;
import java.io.*;

public class B_1916 {

    private static List<City>[] nodes;
    private static boolean[] visited;
    private static final int INF = 100_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        int[] results = new int[n+1];
        visited = new boolean[n+1];
        nodes = new List[n+1];
        Arrays.fill(nodes, new ArrayList<>());
        Arrays.fill(results, INF);

        for (int i = 0; i < e; i++){
            String[] inputs = br.readLine().split(" ");
            int from = Integer.parseInt(inputs[0]);
            City City = new City(Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]));
            nodes[from].add(City);
            System.out.println("from : " + from);
        }

        String[] inputs = br.readLine().split(" ");
        int start = Integer.parseInt(inputs[0]);
        int target = Integer.parseInt(inputs[1]);

        PriorityQueue<City> queue = new PriorityQueue<>();
        queue.add(new City(start, 0));
        results[start] = 0;
        
        while (!queue.isEmpty()) {
            City now = queue.poll();
            int nowCity = now.to;
            System.out.println("1. nowCity : " + nowCity);

            if (visited[nowCity])
                continue;
            visited[nowCity] = true;
            for (City city : nodes[nowCity]) {
                System.out.println("이번놈 " + city.to);
                if (visited[city.to])
                    continue;

                if (results[city.to] > (results[nowCity] + city.weight)) {
                    results[city.to] = (results[nowCity] + city.weight);
                    queue.add(new City(city.to, results[city.to]));
                }
            }
        }
//        for (int i : results)
//            System.out.println(i);
        System.out.println(results[target]);
    }
}
class City implements Comparable<City> {
    int to;
    int weight;
    public City(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(City o1) {
        return weight - o1.weight;
    }
}
