package ndb.greedy;

import java.util.Arrays;

public class BigNumRule {
    public static void main(String[] args) {

        int N = 5;
        int M = 8;
        int k = 3;

        int[] arr = new int[]{2,4,5,3,6};

        Arrays.sort(arr);
        int answer = 0;
        int count = 0;
        count += (M / (k + 1)) * k;
        count += M % (k + 1);

        answer += count * arr[arr.length - 1];
        answer += (M - count) * arr[arr.length - 2];

        System.out.println(answer);

    }
}
