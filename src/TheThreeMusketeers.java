public class TheThreeMusketeers {
    static class Solution {
        public int solution(int[] number) {
            int answer = 0;

            for(int i = 0; i < number.length - 2; i++) {
                for(int j = i + 1; j < number.length - 1; j++){
                    for(int k = j + 1; k < number.length; k++){
                        System.out.println(number[i] + " " + number[j] + " " + number[k]);
                        if(number[i] + number[j] + number[k] == 0) answer++;
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int result = solution.solution(new int[]{-2, 3, 0, 2, -5});
        int result = solution.solution(new int[]{-3, -2, -1, 0, 1, 2, 3});
        System.out.println("result = " + result);
    }
}
