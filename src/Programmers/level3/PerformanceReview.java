package Programmers.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PerformanceReview {
    public static void main(String[] args) {
        int[][] scores = new int[][]{{2,2},{1,4},{3,2},{3,2},{2,1}};

        Incentive incentive = new Incentive(scores);
        incentive.calculateRank();
        System.out.println(incentive.findTargetRank());
    }
}

class Incentive {
    private List<Review> incentives;

    public Incentive(int[][] scores) {
        this.incentives = settingIncentives(scores);
    }

    private List<Review> settingIncentives(int[][] scores) {
        List<Review> reviews = getTotalReviews(scores);

        Review standard = reviews.get(0);
        incentives = new ArrayList<>();
        incentives.add(standard);

        for (int i = 1; i < reviews.size(); i++) {
            Review comp = reviews.get(i);
            if (standard.getWork() > comp.getWork() && standard.getPartner() > comp.getPartner()) {
                continue;
            }
            standard = comp;
            incentives.add(comp);
        }

        incentives.sort(((o1, o2) -> o2.getTotal() - o1.getTotal()));

        return incentives;
    }

    private List<Review> getTotalReviews(int[][] scores) {
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review(true, scores[0][0], scores[0][1]));
        for (int i = 1; i < scores.length; i++) {
            reviews.add(new Review(false, scores[i][0], scores[i][1]));
        }

        reviews.sort((o1, o2) -> {
            if (o2.getWork() != o1.getWork()) {
                return o2.getWork() - o1.getWork();
            }
            return o1.getPartner() - o2.getPartner();
        });
        return reviews;
    }

    public void calculateRank() {
        incentives.get(0).updateRank(1);
        int cnt = 1;

        for (int i = 1; i < incentives.size(); i++) {
            Review before = incentives.get(i - 1);
            Review current = incentives.get(i);
            if (before.getTotal() == current.getTotal()) {
                current.updateRank(before.getRank());
                cnt++;
                continue;
            }
            current.updateRank(before.getRank() + cnt);
            cnt = 1;
        }
    }

    public int findTargetRank() {
        Optional<Review> target = incentives.stream()
                .filter(incentive -> incentive.isTarget())
                .findFirst();

        if (target.isEmpty()) {
            return -1;
        }

        return target.get().getRank();
    }
}

class Review {
    private boolean target;
    private int work;
    private int partner;
    private int rank;

    public Review(boolean target, int work, int partner) {
        this.target = target;
        this.work = work;
        this.partner = partner;
        this.rank = -1;
    }

    public boolean isTarget() {
        return target;
    }

    public int getWork() {
        return work;
    }

    public int getPartner() {
        return partner;
    }

    public int getRank() {
        return rank;
    }

    public int getTotal() {
        return work + partner;
    }

    public void updateRank(int rank) {
        this.rank = rank;
    }
}
