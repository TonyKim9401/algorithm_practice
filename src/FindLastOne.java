public class FindLastOne {
    public static class Solution {
        public int solution(int n) {
            int answer = 1;

            while(true){
                if(n % answer == 1){
                    break;
                }
                answer++;
            }

            return answer;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int answer = solution.solution(12);
        System.out.println("solution = " + answer);

    }
}
