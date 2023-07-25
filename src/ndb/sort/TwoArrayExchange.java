package ndb.sort;

import java.util.*;
import java.util.stream.*;

public class TwoArrayExchange {

    public static void main(String[] args) {

        int k = 3;
        int[] A = {1,2,5,4,3};
        Integer[] B = {5,5,5,6,6};

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int idxB = 0;
        for (int i = 0; i < k; i++) {
            if (A[i] < B[idxB]) {
                A[i] = B[idxB];
                idxB += 1;
            }
            else break;
        }

        System.out.println(IntStream.of(A).sum());



    }

}
