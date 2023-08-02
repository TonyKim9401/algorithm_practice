package programmers.codingtest;

import java.util.*;

public class Bells {
    static class Solution {
        public int solution(int[] bell) {
            int answer = 0;

            Map<Integer, Integer> bells = new HashMap<>();
            int total = bell[0] == 1 ? 1 : -1;
            bells.put(0, -1);
            bells.put(total, 0);

            for (int i = 1; i < bell.length; i++) {
                total += bell[i] == 1 ? 1 : -1;
                if (!bells.containsKey(total)){
                    bells.put(total, i);
                } else {
                    answer = Math.max(answer, i - bells.get(total));
                }
            }


            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{1, 2, 1, 1, 1, 2, 2, 1});
//        int result = solution.solution(new int[]{2,2,1,1,2,2,2,2,2,2,1});
        System.out.println(result);
    }
}
