package programmers;

import java.util.*;

public class TheHallOfFrame {

    static class Solution {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];

            PriorityQueue<Integer> queue = new PriorityQueue<>();

            for(int i = 0; i < score.length; i++) {
                queue.add(score[i]);
                if (queue.size() > k) {
                    queue.poll();
                }
                answer[i] = queue.peek();
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(3, new int[]{10, 100, 20, 150, 1, 100, 200});
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}
