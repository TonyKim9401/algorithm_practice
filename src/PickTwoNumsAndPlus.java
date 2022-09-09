import java.util.*;

public class PickTwoNumsAndPlus {

    public static class Solution {
        public int[] solution(int[] numbers) {

            // 오름차순 정렬
            Arrays.sort(numbers);

            List<Integer> tempList = new ArrayList<>();
            for(int i = 0; i < numbers.length; i++){
                for(int j = 0; j < numbers.length; j++){
                    if(i == j) continue;
                    tempList.add(numbers[i] + numbers[j]);
                }
            }

            int[] ints = new int[tempList.size()];
            for(int i = 0; i < tempList.size(); i++){
                ints[i] = tempList.get(i);
            }

            int[] answer = Arrays.stream(ints).distinct().toArray();
            return answer;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] answer = solution.solution(new int[]{2, 1, 3, 4, 1});

        for (int i : answer) {
            System.out.println("i = " + i);
        }

    }

}
