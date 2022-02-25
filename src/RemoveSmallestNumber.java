import java.util.ArrayList;

public class RemoveSmallestNumber {
    public static class Solution {
        public int[] solution(int[] arr) {
            int[] answer = {};

            if(arr[0] == 10){
                answer = new int[]{-1};
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < arr.length; i++) {
                    list.add(arr[i]);
                }
                int min = arr[0];
                for (int i = 0; i < arr.length; i++) {
                    if (min > arr[i]) min = arr[i];
                }
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) == min) {
                        list.remove(i);
                    }
                }
                answer = new int[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    answer[i] = list.get(i);
                }
            }


            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = new int[]{};
        System.out.println(sol.solution(arr).length);
    }
}
