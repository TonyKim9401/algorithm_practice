public class SumOfDivisor {
    static class Solution {
        public int solution(int left, int right) {
            int answer = 0;
            int count = 0;
            int divisor = 1;
            for(int i = left; i <= right; i++){
                while(true){
                    if(i % divisor == 0) count++;
                    if(i == divisor){
                        answer += count % 2 == 0 ? i : i*-1;
                        break;
                    }
                    divisor++;
                }
                count = 0;
                divisor = 1;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(13,17);
        System.out.println(result);
    }
}
