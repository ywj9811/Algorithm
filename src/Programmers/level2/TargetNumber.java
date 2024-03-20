package Programmers.level2;

public class TargetNumber {
    private int count = 0;
    private int[] copyNumbers;
    private int copyTarget;

    public int solution(int[] numbers, int target) {
        int answer = 0;
        copyNumbers = numbers;
        copyTarget = target;

        plusDfs(0, 0);
        minusDfs(0, 0);

        return count;
    }

    private void plusDfs(int idx, int sum) {
        sum += copyNumbers[idx];
        if (idx+1 == copyNumbers.length) {
            if (sum == copyTarget) {
                count++;
            }
            return;
        }

        plusDfs(idx+1, sum);
        minusDfs(idx+1, sum);
    }

    private void minusDfs(int idx, int sum) {
        sum -= copyNumbers[idx];
        if (idx+1 == copyNumbers.length) {
            if (sum == copyTarget) {
                count++;
            }
            return;
        }

        plusDfs(idx+1, sum);
        minusDfs(idx+1, sum);
    }
}
