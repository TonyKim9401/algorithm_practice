public class CalcRestCost {

    public static class Solution {
        public long solution(int price, int money, int count) {
            long answer = -1;

            for(int i = 1; i <= count; i++){
                answer += price * i;
            }

            return answer - money + 1 > 0 ? answer - money + 1: 0;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        long solution1 = solution.solution(3, 20, 4);
        System.out.println(solution1);

    }
}
