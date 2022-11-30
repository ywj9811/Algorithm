package Programmers.level1;

public class LottoMaxMin {
    public int[] solution(int[] lottos, int[] win_nums) {
        //0의 경우 알아볼 수 없는 번호 : 무엇이든 가능
        //최대 등수 : 0을 모두 당첨으로 계산
        //최소 등수 : 0을 모두 당첨이 아닌 것으로 계산
        int[] answer = new int[2];
        int[] grade = {6, 6, 5, 4, 3, 2, 1};
        int maxCount;
        int minCount;

        int countZero = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0)
                countZero++;
        }

        maxCount = countLotto(lottos, win_nums) + countZero;
        minCount = countLotto(lottos, win_nums);

        answer[0] = grade[maxCount];
        answer[1] = grade[minCount];

        return answer;
    }

    public int countLotto(int[] lottos, int[] win_nums) {
        int count = 0;
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < lottos.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    count++;
                    continue;
                }
            }
        }

        return count;
    }
}
