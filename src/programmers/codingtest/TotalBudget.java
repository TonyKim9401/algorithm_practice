package programmers.codingtest;

import java.util.*;

public class TotalBudget {

    static class Solution {
        public int solution(int[] budgets, int M) {
            int answer= 0 ;

            int min = 0;
            int max = 0;
            for (int b : budgets) {
                if (b > max) max = b;
            }

            while (min < max) {
                int mid = (min + max) / 2;
                int sum = 0;

                for (int b : budgets) {
                    if (b > mid) sum += mid;
                    else sum += b;
                }

                if (sum <= M) {
                    min = mid + 1;
                    answer = mid;
                } else {
                    max = mid - 1;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{120, 110, 140, 150}, 485);
        System.out.println("result = " + result);
    }

}
