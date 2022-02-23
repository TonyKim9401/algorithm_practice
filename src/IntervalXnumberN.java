public class IntervalXnumberN {
    public static class Solution {
        public long[] solution(int x, int n) {
            long[] answer = new long[n];

            for(int i=1; i<=n; i++){
                answer[i] = (long)x*(i+1);
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(2,5));
    }
}
