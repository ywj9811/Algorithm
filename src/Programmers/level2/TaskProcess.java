package Programmers.level2;

import java.util.*;

public class TaskProcess {
    public static void main(String[] args) {
        String[][] plans = new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};

        TaskManage taskManage = new TaskManage(plans);
        taskManage.processTask();

        String[] array = taskManage.getResult()
                .toArray(new String[0]);
        Arrays.stream(array).forEach(System.out::println);
    }
}

class TaskManage {
    private List<Task> tasks;
    private Stack<Task> pausedTasks;
    private int currentTime;
    private List<String> result;

    public TaskManage(String[][] plans) {
        tasks = new ArrayList<>();
        pausedTasks = new Stack<>();
        currentTime = 0;
        result = new ArrayList<>();

        Arrays.stream(plans)
                .forEach(plan -> tasks.add(TaskMapper.mapToTask(plan)));
        tasks.sort((o1, o2) -> o1.getStartTime() - o2.getStartTime());
    }

    public void processTask() {

        for (int i = 0; i < tasks.size(); i++) {
            Task currentTask = tasks.get(i);
            currentTime = currentTask.getStartTime();

            if (i < tasks.size() - 1) {
                Task nextTask = tasks.get(i + 1);
                int availableTime = nextTask.getStartTime() - currentTime;
                if (currentTask.isFinPossible(availableTime)) {
                    processTaskFin(currentTask, nextTask);
                } else {
                    processTaskPushStack(currentTask, nextTask, availableTime);
                }
            } else {
                result.add(currentTask.getName());
                while (!pausedTasks.isEmpty()) {
                    result.add(pausedTasks.pop().getName());
                }
            }
        }
    }

    private void processTaskFin(Task currentTask, Task nextTask) {
        result.add(currentTask.getName());
        currentTime += currentTask.getRemainTime();

        while (!pausedTasks.isEmpty()) {
            Task pausedTask = pausedTasks.pop();
            if (currentTime + pausedTask.getRemainTime() <= nextTask.getStartTime()) {
                result.add(pausedTask.getName());
                currentTime += pausedTask.getRemainTime();
            } else {
                processTaskPushStack(pausedTask, nextTask, nextTask.getStartTime() - currentTime);
                break;
            }
        }
    }

    private void processTaskPushStack(Task currentTask, Task nextTask, int availableTime) {
        currentTask.minusRemainTime(availableTime);
        pausedTasks.push(currentTask);
        currentTime = nextTask.getStartTime();
    }

    public List<String> getResult() {
        return result;
    }
}

class Task {
    private String name;
    private int startTime;
    private int remainTime;

    public Task(String name, int startTime, int remainTime) {
        this.name = name;
        this.startTime = startTime;
        this.remainTime = remainTime;
    }

    public String getName() {
        return name;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getRemainTime() {
        return remainTime;
    }

    public void minusRemainTime(int time) {
        this.remainTime -= time;
    }

    public boolean isFinPossible(int availableTime) {
        return availableTime >= remainTime;
    }
}

class TaskMapper {
    public static Task mapToTask(String[] plan) {
        String name = plan[0];
        String[] time = plan[1].split(":");
        int startTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        int playtime = Integer.parseInt(plan[2]);
        return new Task(name, startTime, playtime);
    }
}
