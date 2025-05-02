package Programmers.level3;

import java.util.*;

public class JobsTest {
    public static void main(String[] args) {
        int[][] jobs = {
                {1, 5, 2, 3},
                {2, 2, 3, 2},
                {3, 1, 3, 3},
                {5, 2, 1, 5},
                {7, 1, 1, 1},
                {9, 1, 1, 1},
                {10, 2, 2, 9}
        };
        int[] result = solution(jobs);
        System.out.println(Arrays.toString(result)); // 예상 출력: [2, 1, 2, 3]
    }

    public static int[] solution(int[][] jobs) {
        CategoryManager categoryManager = new CategoryManager();
        JobManager manager = new JobManager(jobs, categoryManager);
        List<Integer> result = manager.processJobs();

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

}

class JobManager {
    private final List<Job> jobs;
    private final CategoryManager categoryManager;

    public JobManager(int[][] jobData, CategoryManager categoryManager) {
        jobs = new ArrayList<>();
        for (int i = 0; i < jobData.length; i++) {
            jobs.add(new Job(jobData[i][0], jobData[i][1], jobData[i][2], jobData[i][3]));
        }
        this.categoryManager = categoryManager;
    }

    public List<Integer> processJobs() {
        PriorityQueue<Job> queue = getAllJobsQueue();

        List<Integer> result = new ArrayList<>();
        int currentTime = 0;
        int previousCategory = -1;

        while (!queue.isEmpty()) {
            PriorityQueue<Job> availableQueue = checkAvailableJob(queue, currentTime);

            if (availableQueue.isEmpty()) {
                currentTime = queue.peek().getRequestTime();
                continue;
            }

            int selectedCategory = getSelectedCategory(previousCategory, availableQueue);

            boolean sameCategory = false;
            Iterator<Job> iterator = availableQueue.iterator();

            while (iterator.hasNext()) {
                Job job = iterator.next();
                if (job.getCategory() == selectedCategory) {
                    currentTime += job.getDuration();

                    if (selectedCategory != previousCategory) {
                        result.add(selectedCategory);
                        previousCategory = selectedCategory;
                    }
                    iterator.remove();
                    sameCategory = true;
                } else {
                    queue.add(job);
                }
            }

            if (!sameCategory) {
                categoryManager.removeValue(selectedCategory);
            }
        }

        return result;
    }

    private int getSelectedCategory(int previousCategory, PriorityQueue<Job> availableQueue) {
        int selectedCategory = previousCategory;

        if (selectedCategory == -1 || !categoryManager.checkContain(selectedCategory)) {
            selectedCategory = getSelectedCategory(availableQueue, selectedCategory);
        }
        return selectedCategory;
    }

    private PriorityQueue<Job> checkAvailableJob(PriorityQueue<Job> queue, int currentTime) {
        PriorityQueue<Job> availableQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getImportance() == o2.getImportance()) {
                return o1.getCategory() - o2.getCategory();
            }
            return o2.getImportance() - o1.getImportance();
        });

        while (!queue.isEmpty()) {
            if (queue.peek().getRequestTime() > currentTime)
                break;
            Job job = queue.poll();
            availableQueue.add(job);
            int importance = categoryManager.getImportance(job.getCategory());
            categoryManager.putImportance(job.getCategory(), importance + job.getImportance());
        }
        return availableQueue;
    }

    private PriorityQueue<Job> getAllJobsQueue() {
        PriorityQueue<Job> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getRequestTime() == o2.getRequestTime()) {
                return o2.getImportance() - o1.getImportance();
            }
            return o1.getRequestTime() - o2.getRequestTime();
        });

        queue.addAll(jobs);
        return queue;
    }

    private int getSelectedCategory(PriorityQueue<Job> availableQueue, int selectedCategory) {
        int maxImportance = -1;
        for (Job job : availableQueue){
            int category = job.getCategory();
            int importance = categoryManager.getImportance(category);

            if (importance > maxImportance || (importance == maxImportance && category < selectedCategory)) {
                maxImportance = importance;
                selectedCategory = category;
            }
        }
        return selectedCategory;
    }
}

class CategoryManager {
    private Map<Integer, Integer> categoryImportance;

    public CategoryManager() {
        this.categoryImportance = new HashMap<>();
    }

    public int getImportance(int key) {
        return categoryImportance.getOrDefault(key, 0);
    }

    public void putImportance(int key, int value) {
        categoryImportance.put(key, value);
    }

    public boolean checkContain(int key) {
        return categoryImportance.containsKey(key);
    }

    public void removeValue(int key) {
        categoryImportance.remove(key);
    }
}

class Job {
    private int requestTime;
    private int duration;
    private int category;
    private int importance;

    public Job(int requestTime, int duration, int category, int importance) {
        this.requestTime = requestTime;
        this.duration = duration;
        this.category = category;
        this.importance = importance;
    }

    public int getRequestTime() {
        return requestTime;
    }

    public int getDuration() {
        return duration;
    }

    public int getCategory() {
        return category;
    }

    public int getImportance() {
        return importance;
    }
}
