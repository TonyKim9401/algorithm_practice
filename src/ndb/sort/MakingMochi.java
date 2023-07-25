package ndb.sort;

import java.util.stream.*;

public class MakingMochi {
    public static void main(String[] args) {

        int[] arr = {19, 15, 10, 17};
        int M = 6;

        int min = 0;
        int max = IntStream.of(arr).max().getAsInt();
        int answer = 0;

        while (min <= max) {

            int mid = (min + max) / 2;

            int sum = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > mid) sum += arr[i] - mid;
            }

            if (sum >= M) {
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }

        }

        System.out.println(answer);

    }
}
