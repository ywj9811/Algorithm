package Programmers.level3;

public class Stations {
    public static void main(String[] args) {

    }

    private static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = 2 * w + 1;
        int position = 1;  // 현재 커버되지 않은 시작 위치
        int idx = 0; //stations 배열의 인덱스

        while (position <= n) {
            if (idx < stations.length && stations[idx] - w <= position) {
                // 현재 위치가 기존 기지국의 커버 범위 내라면
                position = stations[idx] + w + 1;
                idx++;
            } else {
                // 커버되지 않는 구간 → 새로운 기지국 설치
                answer++;
                position += coverage;
            }
        }

        return answer;
    }
}
