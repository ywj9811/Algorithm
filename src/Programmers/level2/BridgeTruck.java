package Programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

public class BridgeTruck {
    private static Queue<TruckQueue> bridgeQueue = new LinkedList<>();
    private static List<Integer> trucks;
    public static void main(String[] args) {
        int solution = solution(2, 10, new int[]{7, 4, 5, 6});
        System.out.println(solution);
    }

    private static int solution(int bridge, int weight, int[] truck) {
        int answer = 0;

        trucks = Arrays.stream(truck)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        addQueue(weight, 0);

        while (!bridgeQueue.isEmpty() || !trucks.isEmpty()) {
            answer++;
            bridgeQueue.forEach(bq -> bq.addLocation());
            if (!bridgeQueue.isEmpty() && bridgeQueue.peek().location > bridge) {
                bridgeQueue.poll();
            }
            addQueue(weight, 1);
        }

        return answer;
    }

    private static void addQueue(int weight, int location) {
        int truckWeightInBridge = bridgeQueue.stream()
                .mapToInt(que -> que.truckWeight)
                .sum();
        int availableWeight = weight - truckWeightInBridge;
        if (availableWeight > 0) {
            Iterator<Integer> it = trucks.iterator();
            if (it.hasNext()) {
                int tWeight = it.next();
                if (tWeight <= availableWeight) {
                    bridgeQueue.add(new TruckQueue(tWeight, location));
                    it.remove(); // 리스트에서 현재 항목을 즉시, 안전하게 삭제
                    return;
                }
            }
        }
    }

    static class TruckQueue {
        public TruckQueue(int truckWeight, int location) {
            this.truckWeight = truckWeight;
            this.location = location;
        }

        public void addLocation() {
            location++;
        }

        int truckWeight;
        int location;
    }
}
/**
 * 트럭 여러대가 다리를 지나감.
 * 순서가 정해짐
 * 모든 트럭이 건너려면 최소 몇초?
 *
 * 다리는 버틸 수 있는 최대 무게가 정해짐
 *
 * 1초에 1씩 지날 수 있음
 *
 * 먼저 들어간놈이 먼저 나와야하니 큐를 이용할 수 있음
 *
 * truck을 무게순으로 정렬
 * -> 오름차순 정렬해서, 최대한 함께 지나갈 수 있도록 하는게 좋지 않을까?
 * -> 내림차순 정렬해서, 무거운 놈부터 지나가면서 함께갈 수 있는 것들은 함께 지나갈 수 있도록 해야할까?
 *
 * 내림차순으로 정렬하도록 하고,
 * 트럭 무게, 현재 위치 이렇게 가지는 객체를 큐에 담아서 처리하도록 함.
 *
 * 매번 반복의 마무리시 객체의 위치를 +1 하고, 만약 다리길이를 넘어간다면 flag = 1 로 설정한 후 큐에 추가할 수 있는지 배열 탐색을 시작하도록 함.
 * -> 반복 시작시 if (flag == 1) addQueue() 를 진행하도록 함
 */