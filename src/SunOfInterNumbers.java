public class SunOfInterNumbers {
    public static class Solution {
        public long solution(int a, int b) {
            /*long answer = 0;

            int max = ( a > b ) ? a : b;
            int min = ( a > b ) ? b : a;
            for(int i=min; i <=max; i++){
                answer += i;
            }

            return answer;*/

            //등차수열의 합을 구하는 공식
            return sumAtoB(Math.max(a,b), Math.min(a,b));
        }
        private long sumAtoB(int max, int min){
            return (max + min) * (max-min+1) / 2;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(3,5));
    }
}
