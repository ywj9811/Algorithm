package Programmers.level3;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {
        int[] solution = new BestAlbum().solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> sumMap = new HashMap<>();
        Map<String, PriorityQueue<Song>> songMap = new HashMap<>();
        Comparator<Song> songComparator = (o1, o2) -> {
            if (o2.play == o1.play) return o1.idx - o2.idx;
            return o2.play - o1.play;
        };

        for (int i = 0; i < plays.length; i++) {
            sumMap.put(genres[i], sumMap.getOrDefault(genres[i], 0) + plays[i]);
            songMap.computeIfAbsent(genres[i], k -> new PriorityQueue<>(songComparator))
                    .add(new Song(plays[i], i));
        }

        List<String> sortedGenres = new ArrayList<>(sumMap.keySet());
        sortedGenres.sort((g1, g2) -> sumMap.get(g2) - sumMap.get(g1));

        List<Integer> answers = new ArrayList<>();

        for (String genre : sortedGenres) {
            PriorityQueue<Song> pq = songMap.get(genre);
            int count = 0;
            while (!pq.isEmpty() && count < 2) {
                answers.add(pq.poll().idx);
                count++;
            }
        }

        return answers.stream().mapToInt(i -> i).toArray();
    }

    private class Song {
        public Song(int play, int idx) {
            this.play = play;
            this.idx = idx;
        }

        int play;
        int idx;
    }
}
/**
 * 가장 많이 재생된 노래를 각 장르마다 두개씩 뽑이ㅏ서 출시
 * 노래는 고유번호로 구분
 *
 * 속한 노래가 많이 재생된 장르를 상단에 수록
 * 장르 내에서 많이 재생된 순으로
 * 장르 내에서 재생 횟수가 같은 노래 중 고유번호가 낮은 값을 우선으로
 *
 * 1. 재생수가 제일 우선
 * 2. 같을 경우 고유번호를 낮은 순으로
 *
 * 제공되는 노래 배열의 인덱스 == 고유번호
 *
 * [재생수, idx, 장르] 이렇게 배열을 만들고, 재생수를 내림차순으로 정렬?
 * idx를 기반으로 장르를 찾고, 해당 장르가 이미 2개 들어있으면 패스
 *
 * 우선 재생수 높은게 먼저 나오면서 그 다음에는 장르가 같은게 먼저 나오고
 * 해당 장르와 같은게 다 나옴?
 * 다음 재생수 높은거(장르) 나오고 반복
 */
