import java.util.ArrayList;
import java.util.List;

public class RenderPrimNums {
    static class Solution {
        public int solution(int[] nums) {

            List<Integer> arr = new ArrayList<>();

            for(int i = 0; i < nums.length; i++){
                for(int j = i + 1; j < nums.length; j++){
                    for(int s = j + 1; s < nums.length; s++){
                        arr.add(nums[i] + nums[j] + nums[s]);
                    }
                }
            }
            for (Integer integer : arr) {
                System.out.print(integer + " ");
            }

            List<Integer> primeNums = new ArrayList<>();

            for(int i = 0; i < arr.size(); i++){
//                int target = (int)Math.sqrt(arr.get(i));
                int target = arr.get(i);
                int divisor = 2;
                boolean check = true;
                for(int j = divisor; j < target; j++){
                    if(target % j == 0){
                        check = false;
                        break;
                    }
                }
                if(check) primeNums.add(arr.get(i));
            }

            return primeNums.size();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{1,2,7,6,4});
        System.out.println(result);
    }
}
