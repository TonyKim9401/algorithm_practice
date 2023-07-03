package programmers;

import java.util.*;

public class nearestLetter {
    static class Solution {
        public int[] solution(String s) {
            int[] answer = new int[s.length()];

            int[] aToZ = new int[26];
            for (int i = 0; i < 26; i++){
                aToZ[i] = -1;
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(aToZ[c - 97] != -1) {
                    int temp = aToZ[c - 97];
                    aToZ[c - 97] = i;
                    answer[i] = i - temp;
                } else {
                    aToZ[c - 97] =  i;
                    answer[i] = -1;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] bananas = solution.solution("banana");
        for (int banana : bananas) {
            System.out.print(banana + " ");
        }
    }
}
