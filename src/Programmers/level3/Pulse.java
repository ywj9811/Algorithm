package Programmers.level3;

import java.util.Arrays;

public class Pulse {
    public static void main(String[] args) {
        int[] sequence = new int[]{2, 3, -6, 1, 3, -1, 2, 4};
        int[] firstSum = new int[sequence.length+1];
        int[] secondSum = new int[sequence.length+1];
        int[] first = new int[sequence.length+1];
        int[] second = new int[sequence.length+1];

        for (int i = 1; i <= sequence.length; i++) {
            if (i % 2 == 0) {
                first[i] = sequence[i-1];
                second[i] = sequence[i-1]*-1;
                continue;
            }
            first[i] = sequence[i-1]*-1;
            second[i] = sequence[i-1];
        }

        for (int i = 1; i <= sequence.length; i++) {
            firstSum[i] = firstSum[i-1] + first[i];
            secondSum[i] = secondSum[i-1] + second[i];
        }

        long max = Integer.MIN_VALUE;

        for (int i = 1; i < firstSum.length; i++) {
            for (int j = i; j < firstSum.length; j++) {
                int maxFirst = firstSum[j] - firstSum[i-1];
                if (maxFirst > max) {
                    max = maxFirst;
                }
                int maxSecond = secondSum[j] - firstSum[i-1];
                if (maxSecond > max) {
                    max = maxSecond;
                }
            }
        }

        System.out.println(max);
    }
}
