package Baekjoon.baekjoon_combination;

public class test3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 5}, new String[]{"PGP", "M"}));
    }

    private static int solution(int[] D, String[] T) {
        int n = D.length;
        int[] truckP = new int[n];
        int lastP = 0;
        int[] truckG = new int[n];
        int lastG = 0;
        int[] truckM = new int[n];
        int lastM = 0;

        for (int i = 0; i < n; i++) {
            String pgm = T[i];
            String[] split = pgm.split("");
            for (String s : split) {
                if (s.equals("P")) {
                    truckP[i]++;
                    lastP = i;
                    continue;
                }
                if (s.equals("G")) {
                    truckG[i]++;
                    lastG = i;
                    continue;
                }
                if (s.equals("M")) {
                    truckM[i]++;
                    lastM = i;
                }
            }
        }

        int totalP = 0;
        int totalG = 0;
        int totalM = 0;

        for (int i = 0; i <= lastP; i++) {
            totalP += D[i]*2;
            totalP += truckP[i];
        }
        for (int i = 0; i <= lastG; i++) {
            totalG += D[i]*2;
            totalG += truckG[i];
        }
        for (int i = 0; i <= lastM; i++) {
            totalM += D[i]*2;
            totalM += truckM[i];
        }

        return Math.max(Math.max(totalP, totalG), totalM);
    }
}
