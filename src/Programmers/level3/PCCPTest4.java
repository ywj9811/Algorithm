package Programmers.level3;
import java.util.*;

public class PCCPTest4 {

    class Solution {
        public String[] solution(String[] expressions) {
            List<String> known = new ArrayList<>();
            List<String> unknown = new ArrayList<>();

            for (String expr : expressions) {
                if (expr.endsWith("= X")) {
                    unknown.add(expr);
                } else {
                    known.add(expr);
                }
            }

            // 유효한 진법들 추려내기
            List<Integer> validBases = new ArrayList<>();
            for (int base = 2; base <= 9; base++) {
                boolean isValid = true;
                for (String expr : known) {
                    if (!isValidInBase(expr, base)) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) validBases.add(base);
            }

            // unknown 수식 처리
            String[] result = new String[unknown.size()];
            for (int i = 0; i < unknown.size(); i++) {
                String expr = unknown.get(i);
                Set<String> resultSet = new HashSet<>();
                for (int base : validBases) {
                    String calc = calculate(expr, base);
                    if (calc != null) resultSet.add(calc);
                }
                if (resultSet.size() == 1) {
                    result[i] = expr.replace("X", resultSet.iterator().next());
                } else {
                    result[i] = expr.replace("X", "?");
                }

            }

            return result;
        }

        private boolean isValidInBase(String expr, int base) {
            String[] parts = expr.split(" ");
            try {
                int a = Integer.parseInt(parts[0], base);
                int b = Integer.parseInt(parts[2], base);
                int c = Integer.parseInt(parts[4], base);
                String op = parts[1];
                int expected = op.equals("+") ? a + b : a - b;
                return expected == c;
            } catch (Exception e) {
                return false;
            }
        }

        private String calculate(String expr, int base) {
            String[] parts = expr.split(" ");
            try {
                int a = Integer.parseInt(parts[0], base);
                int b = Integer.parseInt(parts[2], base);
                String op = parts[1];
                int result = op.equals("+") ? a + b : a - b;
                if (result < 0)
                    return null;
                return Integer.toString(result, base);
            } catch (Exception e) {
                return null;
            }
        }
    }

}
