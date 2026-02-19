package Programmers.level2;

public class Carpet {
    public static void main(String[] args) {
        int[] solution = new Carpet().solution(24, 24);
        System.out.println(solution[0] + " , " + solution[1]);
    }

    public int[] solution(int brown, int yellow) {
        double target = Math.sqrt(yellow);

        for (int i = 1; i <= target; i++) {
            if (yellow % i == 0) {
                 if (brown == (i * 2) + (((yellow/i) + 2) * 2)) {
                     return new int[]{(yellow/i) + 2, i + 2};
                 }
            }
        }
        return null;
    }
}
