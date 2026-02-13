package Programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class FindDecimal {
    private Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        int solution = new FindDecimal().solution("17");
    }

    public int solution(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            boolean[] visited = new boolean[10];
            visited[i] = true;
            checkDecimal(Integer.parseInt(String.valueOf(numbers.charAt(i))));
            recursive(visited, numbers, String.valueOf(numbers.charAt(i)));
        }
        set.forEach(System.out::println);
        return set.size();
    }

    private void recursive(boolean[] visited, String numbers, String current) {
        for (int i = 0; i < numbers.length(); i++) {
            int value = Integer.parseInt(String.valueOf(numbers.charAt(i)));
            if (visited[i])
                continue;
            visited[i] = true;
            checkDecimal(Integer.parseInt(current + value));
            recursive(visited, numbers, current + numbers.charAt(i));
            visited[i] = false;
        }
    }

    private void checkDecimal(int value) {
        if (value < 2)
            return;
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0)
                return;
        }
        set.add(value);
    }
}
