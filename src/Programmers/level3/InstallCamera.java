package Programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstallCamera {
    public static void main(String[] args) {
        int solution = solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}});
        System.out.println(solution);
    }

    public static int solution(int[][] routes) {
        Camera camera = new Camera();
        CameraManage cameraManage = new CameraManage(routes, camera);
        cameraManage.calculateCameraCount();
        return camera.getCnt();
    }
}

class CameraManage {
    private final Camera camera;
    private List<Car> cars;

    public CameraManage(int[][] routes, Camera camera) {
        this.camera = camera;
        cars = new ArrayList<>();
        Arrays.stream(routes)
                .forEach(route -> cars.add(new Car(route[0], route[1])));
        cars.sort((o1, o2) -> o1.getEnd() - o2.getEnd());
    }

    public void calculateCameraCount() {
        for (Car car : cars) {
            if (camera.getLastPosition() < car.getStart()) {
                camera.plusCount();
                camera.updateLastPosition(car.getEnd());
            }
        }
    }
}

class Camera {
    private int cnt;
    private int lastPosition;

    public Camera() {
        this.lastPosition = Integer.MIN_VALUE;
    }

    public int getLastPosition() {
        return lastPosition;
    }

    public int getCnt() {
        return cnt;
    }

    public void plusCount() {
        cnt++;
    }

    public void updateLastPosition(int position) {
        lastPosition = position;
    }
}

class Car {
    private final int start;
    private final int end;

    public Car(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
