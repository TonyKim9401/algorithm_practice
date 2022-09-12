import java.util.Arrays;

public class Budget {
    static class Solution {
        public int solution(int[] d, int budget) {
            int answer = 0;

            Arrays.sort(d);
            for (int idx : d) {
                budget -= idx;
                if(budget < 0) break;
                answer++;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{1,3,2,5,4}, 9);
        System.out.println(result);
    }
}
