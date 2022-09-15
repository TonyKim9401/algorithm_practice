import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PhoneKetmon {
    static class Solution {
        public int solution(int[] nums) {
            int answer = nums.length / 2;
            int setSize = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList())).size();
            System.out.println(answer + " " + setSize);
            if(answer == setSize){
                return answer;
            } else {
                return (answer > setSize) ? setSize : answer;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result1 = solution.solution(new int[]{3, 1, 2, 3});
        int result2 = solution.solution(new int[]{3,3,3,2,2,4});
        int result3 = solution.solution(new int[]{3,3,3,2,2,2});
    }
}
