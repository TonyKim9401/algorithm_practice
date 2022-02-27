public class CaesarCipher {
    public static class Solution {
        public String solution(String s, int n) {
            String answer = "";

            String[] str = s.split("");

            String[] lower = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n"
                    ,"o","p","q","r","s","t","u","v","w","x","y","z"};
            String[] upper = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N"
                    ,"O","P","Q","R","S","T","U","V","W","X","Y","Z"};

            for(int i=0; i<str.length; i++){
                //공백
                if(str[i].equals(" ")){
                    answer += " ";
                    System.out.println(answer);
                }
                //소문자
                for(int j=0; j< lower.length; j++){
                    if(str[i].equals(lower[j])){
                        if(str[i].charAt(0) + n > 122){
                            int index = (str[i].charAt(0) + n) - 123;
                            answer += lower[index];
                            System.out.println(answer);
                            break;
                        } else {
                            answer += lower[j+n];
                            System.out.println(answer);
                            break;
                        }
                    }
                }
                //대문자
                for(int j=0; j< upper.length; j++){
                    if(str[i].equals(upper[j])){
                        if(str[i].charAt(0) + n > 90){
                            int index = (str[i].charAt(0) + n) - 91;
                            answer += upper[index];
                            System.out.println(answer);
                            break;
                        } else {
                            answer += upper[j+n];
                            System.out.println(answer);
                            break;
                        }
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("a B z",4));
    }
}
