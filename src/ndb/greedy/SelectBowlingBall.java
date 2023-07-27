package ndb.greedy;

import java.util.Arrays;

public class SelectBowlingBall {
    public static void main(String[] args) {

//        int[] balls = {1, 3, 2, 3, 2};
        int[] balls = {1, 5, 4, 3, 2, 4, 5, 2};
        int count = 0;

        int[] ints = Arrays.stream(balls).distinct().toArray();

        for (int i = 1; i < balls.length; i++) {
            count += i;
        }

        int override = balls.length - ints.length;

        System.out.println(count - override);

    }
}
