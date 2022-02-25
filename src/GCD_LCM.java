public class GCD_LCM {
    public static class Solution {
        public int[] solution(int n, int m){

            //둘중 큰수와 작은수 구하기
            int bigger = (n > m) ? n : m;
            int smaller = (n < m) ? n : m;

            //최대공약수 구하기
            int gcd = smaller;
            while(true){
                if(smaller%gcd != 0 || bigger%gcd != 0){
                    gcd--;
                }else{
                    break;
                }
            }

            //최소공배수 구하기
            int lcm = bigger;
            while(true){
                if(lcm%bigger == 0 && lcm%smaller == 0){
                    break;
                }else{
                    lcm++;
                }
            }

            int[] answer = {gcd,lcm};
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] res = sol.solution(3,12);
        System.out.println(res[0] + " " + res[1]);
    }
}
