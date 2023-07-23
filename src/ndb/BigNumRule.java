package ndb;

import java.util.Arrays;

public class BigNumRule {
    public static void main(String[] args) {

        int N = 5;
        int M = 8;
        int k = 3;

        int[] arr = new int[]{2,4,5,3,6};

        Arrays.sort(arr);
        int answer = 0;

        while(M > 0) {

            for(int i = 0; i < k; i++) {
                if (M == 0) break;
                answer += arr[arr.length-1];
                M -= 1;
            }
            if (M == 0) break;
            answer += arr[arr.length - 2];
            M -= 1;
        }

        System.out.println(answer);

    }
}
