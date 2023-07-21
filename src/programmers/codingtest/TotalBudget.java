package programmers.codingtest;

import java.util.*;

public class TotalBudget {

    static class Solution {
        public int solution(int[] budgets, int M) {

            int answer = 0;

            int average = M / budgets.length;
            int rest = M % budgets.length;

            // 모든 요청 배정 가능
            if (rest == 0) {
                return average;
            }

            // 평균보다 작은 예산만 담고 어디까지 인지 확인
            List<Integer> smallList = new ArrayList<>();
            int smallSize = 0;
            for (int i = 0; i < budgets.length; i++) {
                if (budgets[i] <= average) {
                    smallSize += 1;
                    smallList.add(budgets[i]);
                    continue;
                }
                break;
            }
            int averageTotal = Arrays.stream(budgets).sum() / budgets.length;
            int restSize = budgets.length - smallSize;
            int restBudget = M - smallList.stream().mapToInt(s -> s).sum();

            for (int i = average; i <= averageTotal; i++) {
                if (i * restSize > restBudget) {
                    answer = i - 1;
                    break;
                }
            }

            return answer;

            /*
            int answer = 0;

            int average = M / budgets.length;
            int rest = M % budgets.length;

            // 모든 요청 배정 가능
            if (rest == 0) {
                return average;
            }

            // 평균보다 작은 예산만 담고 어디까지 인지 확인
            List<Integer> smallList = new ArrayList<>();
            int smallSize = 0;
            for (int i = 0; i < budgets.length; i++) {
                if (budgets[i] <= average) {
                    smallSize += 1;
                    smallList.add(budgets[i]);
                    continue;
                }
                break;
            }

            // 평균보다 작은 예산의 전체합
            int smallTotal = smallList.stream().mapToInt(s -> s).sum();

            // 전체 예산 - 작은 예산의 합
            int restBudget = M - smallTotal;
            // 전체 지방수 - 작은 예산 지방 수
            int restSize = budgets.length - smallSize;

            return restBudget / restSize;
            */
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{120, 110, 140, 150}, 485);
        System.out.println("result = " + result);
    }

}
