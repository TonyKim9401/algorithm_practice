package programmers.codingtest;

import java.util.LinkedList;
import java.util.Queue;

public class BicycleFactory {
    static class Solution {
        public int solution(int[][] cost, int[][] order) {
            int answer = 0;

            /*
            int month = order[order.length-1][0];
            int total = 0;

            for(int i = 0; i < order.length; i++) {
                total += order[i][1];
            }

            int monthLimit = month * cost[0][0]; // 400
            int rest = total - monthLimit;

            answer += monthLimit * cost[0][1];

                answer += rest * cost[1][1];
            for(int i = 1; i < cost.length; i++) {
            }
            망함
            */
            Queue<Integer> q = new LinkedList<>();


            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(
                new int[][]{{0,10}, {50,20}, {100, 30}, {200, 40}}
                , new int[][]{{3, 50}, {7, 200}, {8, 200}});
        System.out.println("result = " + result);
    }
}
