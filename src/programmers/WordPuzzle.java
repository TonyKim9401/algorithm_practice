package programmers;

import java.util.*;

public class WordPuzzle {
    static class Solution {
        public int solution(String[] strs, String t) {
            int answer = 0;

            int strsLength = strs.length;
            int[] dp = new int[t.length() + 1];

            for (int i = 1; i < t.length() + 1; i++) {
                for (int j = 0; j < strsLength; j++) {

                    String word = strs[j];
                    int wordLength = word.length();
                    if (i - wordLength < 0) continue;

                    if (word.equals(t.substring(i - wordLength, i))) {
                        if (i - wordLength == 0) {
                            dp[i] = 1;
                            continue;
                        }
                        if (dp[i - wordLength] > 0) {
                            dp[i] = dp[i] == 0 ? dp[i - wordLength] + 1 :
                                    Math.min(dp[i], dp[i - wordLength] + 1);
                        }
                    }
                }
            }

            answer = dp[t.length()];
            if (answer == 0) return -1;
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int result = solution.solution(new String[]{"ba","na","n","a"}, "banana");
        int result = solution.solution(new String[]{"app","ap","p","l","e","ple","pp"}, "apple");
//        int result = solution.solution(new String[]{"ba","an","nan","ban","n"}, "banana");
        System.out.println(result);
    }
}
