import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MockTest {

    static class Solution {
        public int[] solution(int[] answers) {
            int temp1 = 1;
            int result1 = 0;

            //student1
            for(int i = 0; i < answers.length; i++){
                if(temp1 > 5) temp1 = 1;
                if(answers[i] == temp1) result1++;
                temp1++;
            }

            //student2
            int temp2 = 1;
            int absValue = 2;
            int result2 = 0;

            for(int i = 0; i < answers.length; i++){
                if(temp2 > 5) temp2 = 1;
                if(i % 2 == 0){
                    if(answers[i] == absValue){
                        result2++;
                    }
                    continue;
                }
                if(answers[i] == temp2){
                    result2++;
                }
                temp2++;
                if(temp2 == 2) temp2++;
            }

            //student3
            int result3 = 0;

            for(int i = 0; i < answers.length; i++){
                int divisor = i % 10;
                switch(divisor){
                    case 0: if(answers[i] == 3) result3++; break;
                    case 1: if(answers[i] == 3) result3++; break;
                    case 2: if(answers[i] == 1) result3++; break;
                    case 3: if(answers[i] == 1) result3++; break;
                    case 4: if(answers[i] == 2) result3++; break;
                    case 5: if(answers[i] == 2) result3++; break;
                    case 6: if(answers[i] == 4) result3++; break;
                    case 7: if(answers[i] == 4) result3++; break;
                    case 8: if(answers[i] == 5) result3++; break;
                    case 9: if(answers[i] == 5) result3++; break;
                }
            }

            int max = Arrays.stream(new int[]{result1, result2, result3}).boxed().sorted().collect(Collectors.toList()).get(2);
            int[] arr = new int[]{result1, result2, result3};
            List<Integer> resultArr = new ArrayList<>();
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == max) resultArr.add(i+1);
            }

            return resultArr.stream().mapToInt(i -> i).toArray();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(new int[]{1,3,2,4,2});
        for (int i : result) {
            System.out.print(i);
        }
    }
}
