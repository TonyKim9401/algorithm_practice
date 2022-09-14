import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PickTwoAndSum {
    static class Solution {
        public int[] solution(int[] numbers) {
            int tempSum = 0;
            List<Integer> result = new ArrayList<>();

            for(int i = 0; i < numbers.length; i++){
                for(int j = i+1; j < numbers.length; j++){
                    tempSum = numbers[i] + numbers[j];
                    if(result.contains(tempSum)){
                        continue;
                    } else {
                        result.add(tempSum);
                    }
                }
            }

            return result.stream().sorted().mapToInt(i -> i).toArray();
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] result = solution.solution(new int[]{2,1,3,4,1});
        for (int i : result) {
            System.out.print(i);
        }

    }
}
