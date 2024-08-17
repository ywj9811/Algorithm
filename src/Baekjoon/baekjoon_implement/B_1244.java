package Baekjoon.baekjoon_implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B_1244 {
    private static int[] switches;
    private static int n;

    public static void main(String[] args) {
        /**
         * 스위치는 켜져있거나, 꺼져있음
         * 1 == 켜져있음
         * 0 == 꺼져있음
         *
         * 1 <= n <= 스위치 개수
         *
         * 남자 -> 스위치 번호가 n의 배수일 경우 스위치 상태 변경
         * 여자 -> n과 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아 그 스위치를 모두 변경 이때 구간에 포함된 스위치 개수는 항상 홀수
         *
         * 예를 들어, 여자의 경우 n == 3일때, 1-5, 2-4 대칭이라면, 1~5까지 모두 대칭이므로 1~5 모두 변경
         * 하지만, 만약 2-4부터 대칭이 아니라면? 3번만 변경
         */
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); //스위치 개수
        switches = new int[n+1];

        for (int i = 1; i <= n; i++) {
            switches[i] = sc.nextInt();
        }

        int k = sc.nextInt(); //학생 수
        List<int[]> students = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            students.add(new int[]{sc.nextInt(), sc.nextInt()});
        }

        students.forEach(student -> {
                    if (student[0] == 1) {
                        man(student[1]);
                    } else {
                        woman(student[1]);
                    }
                });
        for (int i = 1; i <= n; i++) {
            if (i != 1 && i % 20 == 1)
                System.out.println();
            System.out.print(switches[i] + " ");
        }
    }

    private static void man(int number) {
        for (int i = 1; i <= n/number; i++) {
            if (switches[number*i] == 1) {
                switches[number*i] = 0;
                continue;
            }
            switches[number*i] = 1;
        }
    }

    private static void woman(int number) {
        int a;
        int b;
        int start = number;
        int end = number;
        for (int i = 1; i <= n - number; i++) {
            if (number - i <= 0)
                break;
            a = switches[number - i];
            b = switches[number + i];

            if (a != b) {
                break;
            }
            start = number - i;
            end = number + i;
        }

        for (int i = start; i <= number; i++) {
            if (switches[i] == 1) {
                switches[i] = 0;
                continue;
            }
            switches[i] = 1;
        }

        for (int i = number+1; i <= end; i++) {
            if (switches[i] == 1) {
                switches[i] = 0;
                continue;
            }
            switches[i] = 1;
        }

    }
}
