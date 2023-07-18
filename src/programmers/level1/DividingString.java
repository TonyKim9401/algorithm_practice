package programmers.level1;

public class DividingString {
    static class Solution {
        public int solution(String s) {
            int answer = 0;

            String x = String.valueOf(s.charAt(0));
            int[] comp = new int[2];

            for(int i = 0; i < s.length(); i++){

                if(x == null) {
                    x = String.valueOf(s.charAt(i));
                }
                if(x.equals(String.valueOf(s.charAt(i)))) {
                    comp[0]++;
                } else {
                    comp[1]++;
                }
                if(comp[0] == comp[1]){
                    answer++;
                    comp[0] = 0;
                    comp[1] = 0;
                    x = null;
                }
            }

            if(comp[0] != 0 || comp[1] !=0 ){
                answer++;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution("abracadabra");
        System.out.println("result = " + result);
    }
}
