public class CokeProblem {
    static class Solution {
        public int solution(int a, int b, int n) {
            int answer = 0;


            while( a <= n ) {
                n = n - a + b;
                answer += b;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(2, 1, 20);
        int result2 = solution.solution(3, 1, 20);

        System.out.println("result = " + result);
        System.out.println("result2 = " + result2);

    }
}
