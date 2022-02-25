public class EVEN_ODD {
    public static class Solution {
        public String solution(int num) {
            return (num%2 ==0) ? "Even" : "Odd";
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5));
    }
}
