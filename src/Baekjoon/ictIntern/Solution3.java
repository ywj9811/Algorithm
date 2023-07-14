package Baekjoon.ictIntern;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result3 {

    /*
     * Complete the 'findLargestSquareSize' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY samples as parameter.
     */

    public static int findLargestSquareSize(List<List<Integer>> samples) {
        int n = samples.size();
        int[][] dp = new int[n+1][n+1];
        // 정사각형 크기를 저장하기 위한 dp배열 생성
        int maxSize = 0;

        // samples 배열의 모든 위치를 순회하며,
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                // 해당 위치가 1인 경우
                if(samples.get(i).get(j) == 1){
                    // dp 배열에서 현재 위치를 기준으로 오른쪽, 아래, 현재 값 위치의 값 중 가장 작은 값을 찾아 1을 더한다.
                    // 그리고 dp[i+1][j+1] 에 저장하면 해당 위치를 오른쪽 하단 모서리로 하는 정사각형의 최대 크기를 알 수 있다.
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1], dp[i+1][j]), dp[i][j]) + 1;
                    maxSize = Math.max(maxSize, dp[i+1][j+1]);
                }
            }
        }
        // 가장 큰 정사각형의 크기를 반환합니다.
        return maxSize;
    }

}

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int samplesRows = Integer.parseInt(bufferedReader.readLine().trim());
        int samplesColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> samples = new ArrayList<>();

        IntStream.range(0, samplesRows).forEach(i -> {
            try {
                samples.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result3.findLargestSquareSize(samples);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
