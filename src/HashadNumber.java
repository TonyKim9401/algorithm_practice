public class HashadNumber {
    public static class Solution {
        public boolean solution(int x) {
            boolean answer = true;
            int xDigitSum = 0;
            //x의 길이 구하기
            int xLength = (int)(Math.log10(x)+1);

            //x자릿수들의 합 구하기
            String str = String.valueOf(x);
            for(int i=0; i<xLength; i++){
                xDigitSum += Integer.parseInt(String.valueOf(str.charAt(i)));
            }

            //x를 xDigitSum으로 나누었을때 0이면 return = true, 아니면 false
            return x % xDigitSum == 0;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(10));
    }
}
