package Programmers.level2;

import java.util.Arrays;

public class Boat {
    public static void main(String[] args) {
        int solution = new Boat().solution(new int[]{70, 80, 50, 50}, 100);
        System.out.println(solution);
    }

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int a = 0;
        int b = people.length-1;

        while (a <= b) {
            if (a == b) {
                answer++;
                break;
            }
            int sum = people[a] + people[b];
            if (limit >= sum) {
                a++;
                b--;
            } else {
                b--;
            }
            answer++;
        }

        return answer;
    }
}
