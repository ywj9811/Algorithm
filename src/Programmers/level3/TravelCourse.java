package Programmers.level3;

import java.util.*;

public class TravelCourse {
    private static int n;
    private static boolean[] visited;
    private static List<String> results = new ArrayList<>();
    private static String[][] ticket;

    public static void main(String[] args) {
        String[] solution = solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        String[] solution1 = solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});
        for (String s : solution) {
            System.out.print(s + " ");
        }

        System.out.println();

        for (String s : solution1) {
            System.out.print(s + " ");
        }
    }

    public static String[] solution(String[][] tickets) {
        n = tickets.length;
        visited = new boolean[n];
        ticket = new String[n][2];

        for (int i = 0; i < tickets.length; i++) {
            for (int j = 0; j < 2; j++) {
                ticket[i][j] = tickets[i][j];
            }
        }
        for (int i = 0; i < ticket.length; i++) {
            if (ticket[i][0].equals("ICN")) {
                visited[i] = true;
                dfs(i, ticket[i][0] + " " + ticket[i][1], 1);
                visited[i] = false;
            }
        }

        Collections.sort(results);
        return results.get(0).split(" ");
    }

    private static void dfs(int start, String route, int depth) {
        if (depth == n) {
            results.add(route);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && ticket[i][0].equals(ticket[start][1])) {
                visited[i] = true;
                dfs(i, route + " " + ticket[i][1], depth+1);
                visited[i] = false;
            }
        }
    }
}
