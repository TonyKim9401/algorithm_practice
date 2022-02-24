public class getAverage {

    public static class Solution {
        public double solution(int[] arr) {
            double answer = 0;
            for(int i=0; i<arr.length; i++){
                answer += arr[i];
            }
            return answer / arr.length;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{1,2,3,4}));
    }
}
