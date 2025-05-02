package Programmers.level3;

import java.util.*;

public class ChangeWords {
    private static List<String> values;
    private static List<String> visited;
    private static Map<String, Integer> results;

    public static void main(String[] args) {
        int solution = solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(solution);
    }

    private static int solution(String begin, String target, String[] words) {
        visited = new ArrayList<>();
        results = new HashMap<>();
        values = Arrays.asList(words);
        if (!values.contains(target))
            return 0;
        results.put(begin, 0);
        values.forEach(value -> results.put(value, 0));

        bfs(begin);
        return results.get(target);
    }

    private static void bfs(String begin) {
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);

        while (!queue.isEmpty()) {
            String poll = queue.poll();
            visited.add(poll);
            for (int i = 0; i < values.size(); i++) {
                if (check(poll, values.get(i))) {
                    if (!visited.contains(values.get(i))) {
                        visited.add(values.get(i));
                        results.put(values.get(i), results.get(poll)+1);
                        queue.add(values.get(i));
                    }
                }
            }
        }
    }

    private static boolean check(String from, String to) {
        int cnt = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i)) {
                cnt++;
            }
        }
        if (cnt == 1)
            return true;
        return false;
    }
}
