package ndb.greedy;

import java.util.Arrays;

public class SelectBowlingBall {
    public static void main(String[] args) {


        int n = 8;
//        int[] balls = {1, 3, 2, 3, 2};
        int[] balls = {1, 5, 4, 3, 2, 4, 5, 2};
        int count = 0;

        int[] arr = new int[11];

        for (int i = 0; i < balls.length; i++) {
            arr[balls[i]] += 1;
        }

        for (int i = 1; i <= balls.length; i++) {
            n -= arr[i];
            count += arr[i] * n;
        }

        System.out.println(count);

    }
}
