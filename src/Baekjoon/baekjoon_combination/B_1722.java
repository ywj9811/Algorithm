package Baekjoon.baekjoon_combination;

import java.util.*;

public class B_1722 {
    private static int n;
    private static int problem;
    private static long factorial[] = new long[21];
    private static boolean visited[] = new boolean[21];
    private static int soon[] = new int[21];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        factorial[0] = 1;
        for (int i = 1; i < factorial.length; i++) {
            factorial[i] = factorial[i-1]*i;
        } //팩토리얼 초기화

        n = sc.nextInt();

        problem = sc.nextInt();

        if (problem == 1) {
            first(sc);
            return;
        }

        second(sc);
    }

    private static void first(Scanner sc) {
        long k = sc.nextLong(); // k번째 순열 찾기
        for (int i = 1; i <= n; i++) { // 각 자리 반복
            for (int j = 1, cnt = 1; j <= n; j++) {
                if (visited[j])
                    continue; //이미 순열에 포함된 숫자는 계산에서 빼기
                if (k <= cnt * factorial[n-i]) { //이번에 계산하는 자리수에서 나올 수 있는 경우의 수를 넘지 않는다면 해당 위치는 j가 맞음
                    k -= ((cnt-1) * factorial[n-i]); // 소모한 경우의 수 계산
                    soon[i] = j;
                    visited[j] = true;
                    break; // i 번째 자리는 완료, 다음 자리로 넘어가기
                }
                cnt++; // 1___ 에서 완료되지 못하면 2___ 로 넘어가야하니, 다음 숫자를 이용한다는 의미로 cnt++
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(soon[i] + " ");
        }
    }

    private static void second(Scanner sc) {
        long result = 1;

        for (int i = 1; i <= n; i++) {
            soon[i] = sc.nextInt(); // 순열 순서대로 입력
            long cnt = 0;
            for (int j = 1; j < soon[i]; j++) {
                if (!visited[j])
                    cnt++; // 입력 값이 몇번째 숫자인지 (사용된 것 제외)
            }
            result += cnt * factorial[n-i]; // 몇번째 숫자인지 파악 후 해당 자리수의 총 경우의 수 계산
            visited[soon[i]] = true;
        }
        System.out.println(result);
    }
}
