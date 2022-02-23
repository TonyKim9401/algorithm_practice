public class DigitPlus {
    public static class Solution {
        public int solution(int n) {
            int answer = 0;

            while(true){
                answer = answer + n%10;
                if(n < 10) break;
                n /= 10;
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int res = sol.solution(987);
        System.out.println(res);
    }
}
