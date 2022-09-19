import java.util.*;
import java.util.stream.Collectors;

public class PEUniform {
    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int count = 0;

            // lost와 reserve의 중복 제거한 lost
            List<Integer> temp = Arrays.stream(lost).boxed().collect(Collectors.toList());
            List<Integer> newLost = Arrays.stream(lost).boxed().collect(Collectors.toList());
            for (Integer integer : temp) {
                for (int i : reserve) {
                    if(integer == i){
                        newLost.remove(integer);
                    }
                }
            }
            // lost와 reserve의 중복을 제거한 reserve
            List<Integer> temp2 = Arrays.stream(reserve).boxed().collect(Collectors.toList());
            List<Integer> newReserve = Arrays.stream(reserve).boxed().collect(Collectors.toList());
            for (Integer integer : temp) {
                for (int i : reserve) {
                    if(integer == i){
                        newReserve.remove(integer);
                    }
                }
            }

            int[] students = new int[n];
            Arrays.fill(students,1);

            for (Integer integer : newLost) {
                students[integer-1] -= 1;
            }
            for (Integer integer : newReserve) {
                students[integer-1] += 1;
            }


            for(int i = 0; i < students.length; i++){
                if(students[i] == 2) {
                    if(i != 0 && students[i-1] == 0){
                        students[i-1] += 1;
                        students[i] -= 1;
                    } else if(i+1 != n && students[i+1] == 0){
                        students[i+1] += 1;
                        students[i] -= 1;
                    }
                }
            }


            for (int student : students) {
                System.out.print(student + " ");
                if(student > 0){
                    count++;
                }
            }
            System.out.println();

            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(4, new int[]{1,3}, new int[]{2,4});
        int result2 = solution.solution(5, new int[]{2,4}, new int[]{2,3,5});
        int result3 = solution.solution(3, new int[]{3}, new int[]{1});
        System.out.println();
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }
}
