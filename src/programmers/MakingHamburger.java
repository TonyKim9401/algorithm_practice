package programmers;

import java.util.*;

public class MakingHamburger {
    static class Solution {
        public int solution(int[] ingredient) {
            int answer = 0;

            Stack<Integer> check = new Stack<>();

            for(int content : ingredient) {
                check.push(content);
                if(check.size() >= 4) {
                    int idx = check.size();
                    if(check.get(idx -4) == 1
                        &&check.get(idx - 3) == 2
                        &&check.get(idx - 2) == 3
                        &&check.get(idx - 1) == 1) {
                        answer++;
                        check.pop();
                        check.pop();
                        check.pop();
                        check.pop();
                    }
                }
            }


            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 1});
        System.out.println("result = " + result);
    }
}
