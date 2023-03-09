import java.util.ArrayList;
import java.util.List;

public class DifferentStringArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.getResult("3141592", "271");
        int result2 = solution.getResult("500220839878", "7");

        System.out.println("result = " + result);
        System.out.println("result2 = " + result2);
    }

    private static class Solution {
        public int getResult(String t, String p) {
            int count = 0;

            for (int i = 0; i <= t.length() - p.length(); i++) {
                count = Long.parseLong(t.substring(i, i + p.length())) <= Long.parseLong(p) ? count + 1 : count;
            }

            return count;
        }
    }
}
