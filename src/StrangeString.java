import java.util.Locale;

public class StrangeString {
    public static class Solution {
        public String solution(String s) {
            String answer = "";
            String[] arr = s.split("");
            int check = 0;

            for(int i=0; i<arr.length; i++){
                check = (arr[i].equals(" ")) ? 0 : check+1;
                answer += (check%2!=0) ? arr[i].toUpperCase() : arr[i].toLowerCase();
            }

            /*for(int i=0; i<arr.length; i++){
                String str = arr[i];
                //공백이면 check 0으로 초기화, 컨티뉴
                if(str.equals(" ")){
                    answer += " ";
                    check = 0;
                    continue;
                }

                if(check%2==0){
                    answer += str.toUpperCase();
                } else {
                    answer += str.toLowerCase();
                }
                System.out.println(check);
                check++;
            }*/

            return answer;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("try hello world"));
    }
}
