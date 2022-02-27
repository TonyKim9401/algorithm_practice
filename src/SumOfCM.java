public class SumOfCM {
    public static class Solution {
        public int solution(int n) {
            int answer = 0;

            int check = 1;
            //n/2로 하면 n일때 보다 절반만 실행해도 되고 마지막에 n을 더해주면 된다.
            while(check <= n/2){
                answer += (n%check == 0) ? check : 0;
                check++;
            }

            return answer+n;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5));
    }
}
