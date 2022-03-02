
public class CountPNY {
    public static class Solution {
        boolean solution(String s) {

            s = s.toLowerCase();
            int equal = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == 'p') equal++;
                if(s.charAt(i) == 'y') equal--;
            }
            return (equal == 0) ? true : false;

            /*int p = 0;
            int y = 0;
            String[] arr = s.split("");
            for(int i=0; i<arr.length; i++) {
                if (arr[i].equals("y") || arr[i].equals("Y")) {
                    y++;
                }
                if (arr[i].equals("p") || arr[i].equals("P")) {
                    p++;
                }
            }
            return (p == y) ? true : false ;*/
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("pPoooyY"));
    }
}
