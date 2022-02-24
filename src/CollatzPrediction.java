public class CollatzPrediction {
    public static class Solution {
        public int solution(int number) {
            int answer = 0;
            long num = number;
            while (num != 1) {
                if (answer >= 450) {
                    answer = -1;
                    break;
                }
                answer++;
                num = ( num%2 == 0) ? num /=2 : num*3+1;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(	1));
    }
}
