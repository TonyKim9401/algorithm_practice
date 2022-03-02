public class BagicStringArray {
    public static class Solution {
        public boolean solution(String s) {
            boolean answer = true;

            if(s.length() >= 4 && s.length() <= 6) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) > 57 || s.charAt(i) < 48) return false;
                }
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("a234"));
        System.out.println(sol.solution("1234"));

    }
}
