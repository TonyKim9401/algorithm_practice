import java.util.Arrays;
import java.util.Collections;

public class StringADesc {
    public static class Solution {
        public String solution(String s) {
            String[] arr = s.split("");
            Arrays.sort(arr, Collections.reverseOrder());
            String answer = "";
            for(int i=0; i<arr.length; i++){
                answer += arr[i];
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("Zbcdefg"));
    }
}
