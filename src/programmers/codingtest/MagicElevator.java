package programmers.codingtest;

import java.util.*;
public class MagicElevator {
    static class Solution {
        public int solution(int storey) {
            int answer = 0;

            while(storey > 0) {
                int division = storey % 10;
                storey /= 10;

                if (division < 5) {
                    answer += division;
                } else if (division == 5) {
                    if (storey % 10 >= 5) {
                        storey += 1;
                    }
                    answer += division;
                } else {
                    answer += 10 - division;
                    storey += 1;
                }

            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(2554);
//        int result = solution.solution(295);
        System.out.println("result = " + result);
    }
}
