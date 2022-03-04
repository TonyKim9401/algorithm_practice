import java.util.ArrayList;

public class HateSameNumber {
    public static class Solution {
        public int[] solution(int []arr) {

            ArrayList<Integer> temp = new ArrayList<>();

            for(int i=0; i<arr.length; i++){
                if(i != 0){
                    if(arr[i-1] == arr[i]){
                        continue;
                    } else {
                        temp.add(arr[i]);
                    }
                } else {
                    temp.add(arr[i]);
                }
            }
            int[] answer = new int[temp.size()];
            for(int i=0; i<temp.size(); i++){
                answer[i] = temp.get(i).intValue();
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = new int[]{1,1,3,3,0,1,1};
        sol.solution(arr);
    }
}
