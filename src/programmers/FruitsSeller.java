package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class FruitsSeller {

    static class Solution {
        public int solution(int k, int m, int[] score) {
            int answer = 0;

            List<Integer> list = Arrays.stream(score).boxed().collect(Collectors.toList());
            Collections.sort(list);

            int rest = list.size() % m;

            if(rest > 0){
                for(int i = 0; i < rest; i++){
                    list.remove(0);
                }
            }

            int count = 0;
            int[] inBox = new int[m];
            for(int i = 0; i < list.size(); i++) {
                inBox[count] = list.get(i);
                if(count + 1 == m){
                    answer += Arrays.stream(inBox).min().getAsInt() * m;
                    count = 0;
                } else {
                    count++;
                }
            }


            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer2 = solution.solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2});
        System.out.println(answer2);

    }
}
