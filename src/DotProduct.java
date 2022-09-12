import java.util.stream.IntStream;

public class DotProduct {
    static class Solution {
        public int solution(int[] a, int[] b) {
            /*int answer = 0;
            for(int i = 0; i < a.length; i++){
                answer += a[i] * b[i];
            }
            return answer;*/
            return IntStream.range(0, a.length).map(idx -> a[idx] * b[idx]).sum();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2});
        System.out.println(result);
    }
}
