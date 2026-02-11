package Programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeFunction {
    public static void main(String[] args) {
        int[] solution = new MakeFunction().solution(new int[]{93,30,55}, new int[]{1,30,5});
        Arrays.stream(solution).forEach(System.out::println);
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> deploys = new ArrayList<>();
        int deploy = 0;
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i <= progresses.length; i++) {
            if (i == progresses.length) {
                deploys.add(deploy);
                break;
            }
            int remain = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] > 0)
                remain++;
            progresses[i] = remain;
            if (i == 0) temp = remain;
            if (remain <= temp) {
                deploy++;
                continue;
            }
            temp = remain;
            deploys.add(deploy);
            deploy = 1;
        }

        return deploys.stream().mapToInt(i -> i).toArray();
    }
}
/**
 * 뒤가 먼저 개발될 ㅅ ㅜ있음
 * 뒤가 먼저 개발되면, 앞에 기능과 함께 배포됨
 *
 * 배포는 순서대로 진행하되(뒤에가 동시에 배포되기는 가능), 각 배포때마다 몇개의 기능이 배포되는가
 *
 * 7, 4, 11
 * 7-4
 * 11
 * 2개 1개
 * 5
 * 10
 * 5
 * ----
 * 5
 * 10
 * 1
 * 1
 * 10
 * 1
 *
 * 나보다 큰 수를 만나면 멈추고, 그때까지의 개수가 함께 배포되는 수
 * 이걸 반복해서 끝나면 배열로 응답.
 *
 * 그냥 단순하게 해도 될 것 같은데..?
 */