import java.util.Arrays;
import java.util.List;

public class PressKeypad {
    static class Solution {
        public String solution(int[] numbers, String hand) {

            // 개 망해서 다시 해야함.
            return null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result1 = solution.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
        String result2 = solution.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
        String result3 = solution.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right");

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
