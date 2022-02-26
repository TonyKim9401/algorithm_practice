public class CheckSquareRoot {
    public static class Solution {
        public long solution(long n) {
            long answer = 0;

            /*double check = Math.sqrt((double) n);
            if(check - (long)check == 0.0){
                answer = (long)Math.pow((long)check + 1, 2);
            } else {
                answer = -1;
            }*/

            if(Math.pow((int)Math.sqrt((double)n),2) == n){
                return (long)Math.pow(Math.sqrt((double)n) + 1,2);
            }
            return -1;

        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        long res = sol.solution(144);
        System.out.println(res);
    }
}
