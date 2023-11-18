package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_1206 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++)
        {
/**
 * 총 10개의 테스트케이스가 주어진다.
 *
 * 각 테스트케이스의 첫 번째 줄에는 건물의 개수 N이 주어진다. (4 ≤ N ≤ 1000)
 *
 * 그 다음 줄에는 N개의 건물의 높이가 주어진다. (0 ≤ 각 건물의 높이 ≤ 255)
 *
 * 맨 왼쪽 두 칸과 맨 오른쪽 두 칸에 있는 건물은 항상 높이가 0이다. (예시에서 빨간색 땅 부분)
 */
            br.readLine();
            String s = br.readLine();
            String[] towers = s.split(" ");

            int cnt = 0;

            for (int i = 2; i < towers.length-2; i++) {
                int first = Integer.parseInt(towers[i]) - Integer.parseInt(towers[i - 2]);
                int second = Integer.parseInt(towers[i]) - Integer.parseInt(towers[i - 1]);
                int third = Integer.parseInt(towers[i]) - Integer.parseInt(towers[i + 1]);
                int fourth = Integer.parseInt(towers[i]) - Integer.parseInt(towers[i + 2]);
                int min1 = Math.min(first, second);
                int min2 = Math.min(third, fourth);
                int result = Math.min(min1, min2);
                if (result > 0)
                    cnt += result;
            }

            System.out.println("#" + test_case + " " + cnt);

        }
    }
}
