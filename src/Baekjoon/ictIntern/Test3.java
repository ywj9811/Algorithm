package Baekjoon.ictIntern;

import java.util.*;

public class Test3 {
    static String[] products = new String[]{"laptop black thin fast", "tablet white thick slow", "desktop black thick fast"};
    static String[] purchased = new String[]{"laptop", "tablet"};
    public static void main(String[] args) {
        Map<String, List<String>> nameAndProperties = new HashMap<>();
        String answer = "";

        for (String product : products) {
            String[] splits = product.split(" ");
            List<String> properties = new ArrayList<>();
            for (int i = 1; i < splits.length; i++) {
                properties.add(splits[i]);
            }
            nameAndProperties.put(splits[0], properties);
        }

        Map<String, Integer> propertiesRank = new HashMap<>();

        for (String purchase : purchased) {
            List<String> purchasedProperties = nameAndProperties.get(purchase);
            for (String property : purchasedProperties) {
                int count = propertiesRank.getOrDefault(property, 0);
                propertiesRank.put(property, count+1);
            }
            nameAndProperties.remove(purchase);
        }
        // 구매 상품의 특성들 가져옴

        List<String> propertiesKeySet = new ArrayList<>(propertiesRank.keySet());
        Collections.sort(propertiesKeySet, (value1, value2) -> {
            int valueCompare = propertiesRank.get(value2).compareTo(propertiesRank.get(value1));
            if (valueCompare == 0) {
                return value1.compareTo(value2); // 키를 사전순으로 정렬
            }
            return valueCompare;
        });

        // keySet에 우선순위에 맞게 특성들이 들어있음

        Set<String> productKeySet = nameAndProperties.keySet();

        for (String propertiesKey : propertiesKeySet) {
            List<String> candidates = new ArrayList<>();
            for (String productKey : productKeySet) {
                List<String> properties = nameAndProperties.get(productKey);
                if (properties.contains(propertiesKey)) {
                    candidates.add(productKey);
                }
            }
            if (candidates.isEmpty())
                continue;
            if (candidates.size() == 1) {
                answer = candidates.get(0);
                break;
            }
            productKeySet = new HashSet<>();
            for (String candidate : candidates) {
                productKeySet.add(candidate);
            }
        }

        System.out.println(answer);
    }
}
