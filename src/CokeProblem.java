public class CokeProblem {
    static class Solution {
        public int solution(int a, int b, int n) {
            int answer = 0;

            // 실패, 수정 필요 2022.10.21
            int rcvCoke = 0;

            while(a <= n) {

                rcvCoke = n / a;
                n = n - (rcvCoke * a) + rcvCoke;
                answer += rcvCoke;

            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(2, 1, 20);
//        int result = solution.solution(3, 1, 20);

        System.out.println("result = " + result);

    }
}
