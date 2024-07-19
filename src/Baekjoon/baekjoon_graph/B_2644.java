package Baekjoon.baekjoon_graph;

import java.util.*;

public class B_2644 {
    private static int chon[];
    private static List<Re> family[];
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int start = sc.nextInt();
        int end = sc.nextInt();
        int relation = sc.nextInt();

        visited = new boolean[total+1];
        chon = new int[total+1];
        family = new List[total+1];
        visited[start] = true;

        for (int i = 1; i <= total; i++) {
            family[i] = new ArrayList<>();
        }

        for (int i = 0; i < relation; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            family[a].add(new Re(a, b));
            family[b].add(new Re(b, a));
        }

        Queue<List<Re>> queue = new LinkedList<>();
        queue.add(family[start]);

        while (!queue.isEmpty()) {
            List<Re> poll = queue.poll();
            for (Re re : poll) {
                if (!visited[re.you]) {
                    visited[re.you] = true;
                    chon[re.you] = chon[re.me]+1;
                    if (re.you == end) {
                        System.out.println(chon[re.you]);
                        return;
                    }
                    queue.add(family[re.you]);
                }
            }
        }

        System.out.println(-1);
    }

    private static class Re {
        int me;
        int you;

        public Re(int me, int you) {
            this.me = me;
            this.you = you;
        }

    }
}
