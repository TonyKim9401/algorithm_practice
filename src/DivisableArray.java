import java.util.ArrayList;
import java.util.Collections;

public class DivisableArray {
    public static class Solution {
        public int[] solution(int[] arr, int divisor) {
            ArrayList<Integer> str = new ArrayList<>();
            for(int i=0; i<arr.length; i++){
                if(arr[i] % divisor == 0){
                    str.add(arr[i]);
                }
            }
            Collections.sort(str);
            if(str.size() == 0){
                int[] answer = new int[]{-1};
                return answer;
            }
            int[] answer = new int[str.size()];
            for(int i=0; i<str.size(); i++){
                answer[i] = str.get(i);
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] ex = new int[]{3,2,6};
        sol.solution(ex,10);
    }
}
