package programmers.codingtest;

import java.util.*;
import java.util.stream.*;

public class NumberGame {
    static class Solution {
        public int solution(int[] A, int[] B) {
            int answer = 0;

            Arrays.sort(A);
            Arrays.sort(B);

            List<Integer> list = new ArrayList<>();
            for(int num : B) {
                list.add(num);
            }

            int idx = 0;
            for(int i = 0; i < list.size(); i++) {
                if (A[idx] < list.get(i)) {
                    answer += 1;
                    idx += 1;
                    list.remove(i);
                    i -= 1;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {

        int[] a = new int[]{5,1,3,7};
        IntStream.of(a).max().orElse(0);

        Solution solution = new Solution();
        int result = solution.solution(new int[]{5,1,3,7}, new int[]{2,2,6,8});
        System.out.println("result = " + result);
    }


}
