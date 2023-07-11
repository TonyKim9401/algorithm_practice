package programmers;

import java.util.*;

public class PwForTwoPeople {
    static class Solution {
        public String solution(String s, String skip, int index) {
            String answer = "";

            String alphabet = "abcdefghijklmnopqrstuvwxyz";

            for(int i = 0; i < skip.length(); i++) {
                alphabet = alphabet.replace(String.valueOf(skip.charAt(i)), "");
            }

            for(int i = 0; i < s.length(); i++) {
                int idx = alphabet.indexOf(s.charAt(i)) + index;
                answer += String.valueOf(alphabet.charAt(idx % alphabet.length()));
            }


            return answer;
        }
    }

    public static void main(String[] args) {
    /*
        List<Integer> num = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            num.add(i);
        }
        for(int i = 0; i < 10; i++) {
            num.remove(i);
        }
        결과값 1 3 5 7 9 11 13 15 17 19 인덱스를 죽이고 다음 인덱스로 넘어가버리기 때문에 문제 발생!!
    */
        Solution solution = new Solution();
        String result = solution.solution("klmnopqrstuvwxyz", "abcdefghij", 20);
        System.out.println("result = " + result);
    }
}
