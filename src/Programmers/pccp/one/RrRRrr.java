package Programmers.pccp.one;

public class RrRRrr {
    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int n = queries[i][0];
            int p = queries[i][1];
            String result = findParents(n, p);
            answer[i] = result;
        }
        return answer;
    }

    private String findParents(int n, int p) {
        int[] gen = new int[n+1];
        gen[n] = p;

        for (int i = n; i > 0; i--) {
            if (gen[i] % 4 == 0) {
                gen[i-1] = gen[i]/4;
                continue;
            }
            gen[i-1] = gen[i]/4 + 1;
        }

        return findResult(gen);
    }

    private String findResult(int[] gen) {
        String[] values = new String[gen.length];
        values[1] = "Rr";
        for (int i = 1; i < gen.length-1; i++) {
            if (values[i].equals("RR"))
                return "RR";
            if (values[i].equals("rr"))
                return "rr";
            int num = gen[i+1]%4;
            if (num == 1) {
                values[i+1] = "RR";
            }
            if (num == 2 || num == 3) {
                values[i+1] = "Rr";
            }
            if (num == 0) {
                values[i+1] = "rr";
            }
        }

        return values[gen.length-1];
    }
}
