package Baekjoon.baekjoon_recursion;

import java.util.*;

public class B_1759 {
    static String[] result;
    static List<String> alphabets;
    static int L;
    static int C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        result = new String[L];
        alphabets = new ArrayList<>();

        for (int i = 0; i < C; i++) {
            alphabets.add(sc.next());
        }
        Collections.sort(alphabets);

        getResult(0,0);
    }

    public static void getResult(int start, int cnt) {
        if(cnt == L) {
            String resultString = Arrays.toString(result).replace(", ", "").replace("[", "").replace("]", "");
            if (getCount(resultString))
                System.out.println(resultString);
            return;
        }

        for(int i=start; i<C; i++) {
            result[cnt] = alphabets.get(i);
            getResult(i+1,cnt+1);
        }
    }

    private static boolean getCount(String result) {
        int vowelCount = 0;
        if (result.contains("a")) {
            vowelCount++;
        }
        if (result.contains("e")) {
            vowelCount++;
        }
        if (result.contains("i")) {
            vowelCount++;
        }
        if (result.contains("o")) {
            vowelCount++;
        }
        if (result.contains("u")) {
            vowelCount++;
        }
        if (L-vowelCount < 2 || vowelCount < 1)
            return false;
        return true;
    }
}
