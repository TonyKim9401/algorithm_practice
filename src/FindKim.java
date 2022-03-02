import java.util.Arrays;

public class FindKim {
    public static class Solution {
        public String solution(String[] seoul) {

            //마찬가지로 indexOf에서 for문을 자체적으로 돌려서 효율은 떨어짐
            int index = Arrays.asList(seoul).indexOf("Kim");

            /*int index = 0;
            for(int i=0; i<seoul.length; i++){
                if(seoul[i].equals("Kim")){
                    index = i;
                }
            }*/

            return "김서방은 "+index+"에 있다";
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] ex = new String[]{"Jane","Kim"};
        System.out.println(sol.solution(ex));
    }
}
