class Solution {
    public int solution(String s) {
        int answer = 0;
        int mul = s.charAt(0) == 45? -1 : 1;
        String str = "";

        //부호 빼내기
        if(s.charAt(0) == '-' || s.charAt(0) == '+'){
            for(int i=1; i<s.length(); i++){
                str += String.valueOf(s.charAt(i));
            }
        }else{
            str = s;
        }

        int index = 0;

        for(int i=0; i<str.length(); i++){
            int set = 1;
            if(i == str.length()-1){
                set = 1;
            } else {
                for(int j=str.length()-i-1; j>0; j--){
                    set *= 10;
                }
            }
            index = Integer.parseInt(String.valueOf(str.charAt(i) - 48)) * set;
            answer += index;
        }
        answer *= mul;
        return answer;
    }
}
public class StringToInteger {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("+1234"));
    }
}
