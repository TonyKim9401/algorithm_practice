package programmers;

import java.util.*;

public class CharacterTypeTest {
    static class Solution {
        public String solution(String[] survey, int[] choices) {
            String answer = "";

            int[][] board = new int[4][2];
            int[] score = new int[]{3,2,1,0,1,2,3};

            for(int i = 0; i < survey.length; i++) {
                String character = survey[i];
                if(choices[i] == 4) continue;
                int choice = choices[i] - 1;
                if(character.equals("RT")) {
                    if(choice < 4) {
                        board[0][0] += score[choice];
                    } else {
                        board[0][1] += score[choice];
                    }
                    continue;
                }
                if(character.equals("TR")) {
                    if(choice < 4) {
                        board[0][1] += score[choice];
                    } else {
                        board[0][0] += score[choice];
                    }
                    continue;
                }
                if(character.equals("CF")) {
                    if(choice < 4) {
                        board[1][0] += score[choice];
                    } else {
                        board[1][1] += score[choice];
                    }
                    continue;
                }
                if(character.equals("FC")) {
                    if(choice < 4) {
                        board[1][1] += score[choice];
                    } else {
                        board[1][0] += score[choice];
                    }
                    continue;
                }
                if(character.equals("JM")) {
                    if(choice < 4) {
                        board[2][0] += score[choice];
                    } else {
                        board[2][1] += score[choice];
                    }
                    continue;
                }
                if(character.equals("MJ")) {
                    if(choice < 4) {
                        board[2][1] += score[choice];
                    } else {
                        board[2][0] += score[choice];
                    }
                    continue;
                }
                if(character.equals("AN")) {
                    if(choice < 4) {
                        board[3][0] += score[choice];
                    } else {
                        board[3][1] += score[choice];
                    }
                    continue;
                }
                if(character.equals("NA")) {
                    if(choice < 4) {
                        board[3][1] += score[choice];
                    } else {
                        board[3][0] += score[choice];
                    }
                }
            }

            int[] comp;
            for(int i = 0; i < 4; i++){
                comp = board[i];
                if(i == 0) answer += comp[0] >= comp[1] ? "R" : "T";
                else if(i == 1) answer += comp[0] >= comp[1] ? "C" : "F";
                else if(i == 2) answer += comp[0] >= comp[1] ? "J" : "M";
                else if(i == 3) answer += comp[0] >= comp[1] ? "A" : "N";
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String result = solution.solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3});
        String result = solution.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
        System.out.println("result = " + result);
    }
}
