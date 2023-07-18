package programmers.level1;

import java.util.*;

public class NumberMate {
    static class Solution {
        public String solution(String X, String Y) {

            StringBuilder sb = new StringBuilder();

            List<Integer> list = new ArrayList<>();
            int[] xArr = new int[10];
            int[] yArr = new int[10];

            for(int i = 0; i < X.length(); i++){
                xArr[Integer.parseInt(String.valueOf(X.charAt(i)))]++;
            }
            for(int i = 0; i < Y.length(); i++){
                yArr[Integer.parseInt(String.valueOf(Y.charAt(i)))]++;
            }

            for(int i = 9; i >= 0; i--) {

                while(xArr[i] > 0 && yArr[i] > 0){
                    sb.append(i);
                    xArr[i]--;
                    yArr[i]--;
                }
            }
            if("".equals(sb.toString())) return "-1";
            if("0".equals(sb.toString().substring(0,1))) return "0";

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.solution("5525", "1255");
        System.out.println("result = " + result);
    }

}
