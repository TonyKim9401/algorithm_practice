package programmers.codingtest;

import java.util.*;

public class BiggestNumber {
    static class Solution {
        public String solution(int[] numbers) {
            StringBuilder sb = new StringBuilder();
            List<String> splitNum = new ArrayList<>();
            for (int num : numbers) {
                splitNum.add(String.valueOf(num));
            }

            splitNum.sort((o1, o2) -> {
                String post = o1 + o2;
                String pre = o2 + o1;
                return pre.compareTo(post);
            });

            if (splitNum.get(0).equals("0")) return "0";

            for (String value : splitNum) {
                sb.append(value);
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.solution(new int[]{3,30,34,5,9});
        System.out.println(result);
    }
}
