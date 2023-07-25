package Baekjoon.ictIntern;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Practice2 {
    /**
     * 각각 이름, 가격 및 무게가 있는 n개의 제품으로 구성된 복잡한 목록이 제공됩니다. 목록에 있는 중복 제품 수를 확인합니다.
     * 중복 제품에는 목록의 모든 필드(예: 이름, 가격 및 중량)에 대해 동일한 매개변수가 포함됩니다.
     * 예 :
     * 인덱스별로 정렬된 3개의 배열에 속성이 나열된 n = 5개의 제품이 있습니다.
     * 이름 = [공, 배트, 글러브, 글러브, 글러브]
     * 가격 = [2, 3, 1, 2, 1]
     * 가중치 = [2, 5, 1, 1, 1]
     *
     * 항목 0에 대한 완전한 항목 설명: (이름[0], 가격[0], 무게[0])은 (공, 2, 2)입니다.
     *
     * 이름 가격 가중치
     * 공 2 2
     * 박쥐 3 5
     * 장갑 1 1
     * 장갑 2 1
     * 장갑 1 1
     *
     * 처음 두 항목은 고유합니다. 인덱스 2와 4에 있는 두 개의 장갑은 세 속성 모두에서 동일하므로 1개의 중복이 있습니다. 인덱스 3의 마지막 장갑은 다른 두 장갑과 가격이 다르므로 중복이 아닙니다.
     *
     * 원래 목록에 1개의 중복 항목이 있습니다.
     *
     * 기능 설명
     * 아래 편집기에서 numDuplicates 함수를 완료하십시오. 이 함수는 제품 목록 내의 중복 수를 나타내는 정수를 반환해야 합니다.
     *
     * numDuplicates에는 다음 매개변수가 있습니다. 문자열 이름[n]: 크기 n의 문자열 배열, 여기서 이름[i]은 i의 인덱스에 있는 제품 이름을 나타냅니다.
     * int price[n]: 크기 n의 int 배열. 여기서 price[i]는 인덱스 i의 제품 가격을 나타냅니다.
     * int weight[n]: 크기 n의 int 배열, 여기서 weights[i]는 i의 인덱스에서 제품의 무게를 나타냅니다.
     *
     * 제약
     * 1 ≤ n ≤ 10^5 name[i]는 비어 있지 않고 최대 10자이며 모든 문자는 영문 소문자, ascii[a-z] 1 ≤ price[i], weight[i] ≤ 1000
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        List<List<Object>> objs = new ArrayList<>();
        List<Object> items;
        int dupCnt = 0;
        String dupObj = null;

        for (int i = 0; i < input; i++) {
            items = new ArrayList<>();
            String name = sc.next();
            int price = sc.nextInt();
            int weight = sc.nextInt();

            items.add(name);
            items.add(price);
            items.add(weight);
            objs.add(items);
        }

        objs.sort(new Comparator<List<Object>>() {
            @Override
            public int compare(List<Object> o1, List<Object> o2) {
                if (o1.get(0).toString().compareTo(o2.get(0).toString()) == 0) {
                    if (o1.get(1).toString().compareTo(o2.get(1).toString()) == 0)
                        return o1.get(2).toString().compareTo(o2.get(2).toString());
                    return o1.get(1).toString().compareTo(o2.get(1).toString());
                }
                return o1.get(0).toString().compareTo(o2.get(0).toString());
            }
        });

        for (int i = 0; i < objs.size() - 1; i++) {
            if (objs.get(i).get(0).equals(objs.get(i+1).get(0)) && objs.get(i).get(1).equals(objs.get(i+1).get(1)) && objs.get(i).get(2).equals(objs.get(i+1).get(2)))
                dupCnt++;
        }

        System.out.println(dupCnt);
    }
}
