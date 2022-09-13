public class ReverseTernary {
    static class Solution {
        public int solution(int n) {
            return Integer.parseInt(new StringBuilder(Integer.toString(n, 3)).reverse().toString(),3);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(125);
        System.out.println(result);
    }

}
