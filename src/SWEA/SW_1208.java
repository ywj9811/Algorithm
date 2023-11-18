package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_1208 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {
            /**
             * 가로 길이는 항상 100으로 주어진다.
             *
             * 모든 위치에서 상자의 높이는 1이상 100이하로 주어진다.
             *
             * 덤프 횟수는 1이상 1000이하로 주어진다.
             *
             * 주어진 덤프 횟수 이내에 평탄화가 완료되면 더 이상 덤프를 수행할 수 없으므로 그 때의 최고점과 최저점의 높이 차를 반환한다 (주어진 data에 따라 0 또는 1이 된다).
             *
             * [입력]
             *
             * 총 10개의 테스트 케이스가 주어지며, 각 테스트 케이스의 첫 번째 줄에는 덤프 횟수가 주어진다. 그리고 다음 줄에 각 상자의 높이값이 주어진다.
             *
             * [출력]
             *
             * #부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스의 최고점과 최저점의 높이 차를 출력한다.
             */
            int chance = Integer.parseInt(br.readLine());
            String[] split = br.readLine().split(" ");
            int[] tall = new int[split.length];
            int min = 0;
            int max = 0;
            int[] minMax;

            for (int i = 0; i < split.length; i++) {
                tall[i] = Integer.parseInt(split[i]);
            }
            while (chance > 0) {
                minMax = findMinMax(tall);

                tall[minMax[0]]++;
                tall[minMax[1]]--;

                minMax = findMinMax(tall);

                min = tall[minMax[0]];
                max = tall[minMax[1]];

                if (max - min <= 1) {
                    System.out.println("#" + test_case + " " + (max-min));
                    break;
                }

                chance--;
            }
            System.out.println("#" + test_case + " " + (max-min));
        }
    }

    static int[] findMinMax(int[] tall) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        int maxIdx = 0;
        int minIdx = 0;
        int[] minMax = new int[2];
        for (int i = 0; i < tall.length; i++) {
            if (max < tall[i]) {
                max = tall[i];
                maxIdx = i;
            }
            if (min > tall[i]) {
                min = tall[i];
                minIdx = i;
            }
        }

        minMax[0] = minIdx;
        minMax[1] = maxIdx;
        return minMax;
    }
}
