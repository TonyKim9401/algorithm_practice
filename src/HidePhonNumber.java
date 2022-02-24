public class HidePhonNumber {
    public static class Solution {
        public String solution(String phone_number) {
            String answer = "";
            for(int i=0; i<phone_number.length()-4; i++){
                answer += "*";
            }
            for(int i=phone_number.length()-4; i < phone_number.length(); i++) {
                answer += String.valueOf(phone_number.charAt(i));
            }
            // answer += phone_number.substring(phone_bumber.length() - 4);
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("0277778899"));
    }
}
