public class PosNagNumSum {
    private static class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;

            for(int i = 0; i < absolutes.length; i++){
                answer += (signs[i] == true) ? absolutes[i] : absolutes[i] * -1;
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{4, 7, 12}, new boolean[]{true, false, true});
        System.out.println(result);

    }
}
