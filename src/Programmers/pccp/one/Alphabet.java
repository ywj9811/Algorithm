package Programmers.pccp.one;

import java.util.*;

public class Alphabet {
    private String[] splits;
    private Map<String, Boolean> visited = new HashMap<>();

    public String solution(String input_string) {
        List<String> results = new ArrayList<>();

        splits = input_string.split("");

        for(int i = 0; i < splits.length; i++) {
            if (visited.get(splits[i]) == null) {
                visited.put(splits[i], false);
            }
        }

        for (int i = 0; i < splits.length; i++) {
            if (visited.get(splits[i])) {
                continue;
            }
            visited.put(splits[i], true);
            String result = check(splits[i], i);
            if (result != null) {
                results.add(result);
            }
        }

        if (results.size() == 0)
            return "N";

        Collections.sort(results);
        StringBuilder str = new StringBuilder();
        for (String result : results) {
            str.append(result);
        }

        return str.toString();
    }

    private String check(String start, int idx) {
        boolean twin = false;
        for (int i = idx+1; i < splits.length; i++) {
            if (!start.equals(splits[i]))
                twin = true;
            if (start.equals(splits[i]) && twin == true) {
                return start;
            }
        }
        return null;
    }
}
