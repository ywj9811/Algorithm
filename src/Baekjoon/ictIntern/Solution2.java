package Baekjoon.ictIntern;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result2 {

    /*
     * Complete the 'numDuplicates' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY name
     *  2. INTEGER_ARRAY price
     *  3. INTEGER_ARRAY weight
     */

    public static int numDuplicates(List<String> name, List<Integer> price, List<Integer> weight) {
        Map<String, Integer> productCounts = new HashMap<>();
        // 같은 이름과 가격,무게를 가진 개수가 몇개인지 저장하기 위한 Map 생성

        for (int i = 0; i < name.size(); i++) {
            String description = name.get(i) + "," + price.get(i) + "," + weight.get(i);
            productCounts.put(description, productCounts.getOrDefault(description, 0) + 1);
            // 있다면 가져오고 없으면 0을 디폴트 값으로 넣어서 +1을 함
        }

        int duplicateCount = 0;

        // 중복된 것이 있는지 검사 -> 1보다 크면 이것은 중복된 것이 추가로 있는 것이니 -> 중복 증가 (하나만 남을때까지)
        // 하나는 포함 안함
        for (int count : productCounts.values()) {
            while (count > 1) {
                duplicateCount++;
                count--;
            }
        }

        return duplicateCount;
    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int nameCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> name = IntStream.range(0, nameCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int priceCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> price = IntStream.range(0, priceCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int weightCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> weight = IntStream.range(0, weightCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result2.numDuplicates(name, price, weight);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

