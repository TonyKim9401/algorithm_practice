import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SumNotExist {
    static class Solution {
        public int solution(int[] numbers) {
            return 45 - Arrays.stream(numbers).sum();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{1,2,3,4,6,7,8,0});
        System.out.println(result);
    }
}
