package Programmers.level1;

public class GetAverage {
    public static double solution(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        double answer = ((double)sum/arr.length);
        return answer;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        double answer = solution(arr);
        System.out.println(answer);
    }
}
/**
 * arr은 길이 1 이상, 100 이하인 배열입니다.
 * arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.
 */
