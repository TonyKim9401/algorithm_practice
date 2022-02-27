import java.util.Arrays;
import java.util.Collections;

public class ReverseInteger {
    public static class Solution {
        public int[] solution(long n) {

            int[] answer = new int[(int)(Math.log10(n) + 1)];
            String[] arr = String.valueOf(n).split("");
            int index = 0;
            for(int i=arr.length-1; i>=0; i--){
                answer[index] = Integer.parseInt(arr[i]);
                index++;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] res = sol.solution(321456);
        for(int result : res){
            System.out.print(result);
        }
    }
}
