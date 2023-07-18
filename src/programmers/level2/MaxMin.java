package programmers.level2;

public class MaxMin {
    static class Solution {
        public String solution(String s) {
            String[] split = s.split(" ");
            int max = Math.max(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            int min = max;
            for(int i = 1; i < split.length; i++){
                int value = Integer.parseInt(split[i]);
                max = Math.max(max, value);
                min = Math.min(min, value);
            }
            return min + " " + max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String result = solution.solution("-1 -1");
        String result = solution.solution("-1 -2 -3 -4");
//        String result = solution.solution("1 2 3 4");
        System.out.println("result = " + result);
    }
}
