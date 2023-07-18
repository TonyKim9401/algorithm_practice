package programmers.level1;

import java.util.*;

public class FruitsSeller {

    static class Solution {
        public int solution(int k, int m, int[] score) {
            int answer = 0;

            Arrays.sort(score);

            for(int i = score.length; i >= m; i -= m){
                answer += score[i - m] * m;
            }


            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer2 = solution.solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2});
        System.out.println(answer2);

    }
}
