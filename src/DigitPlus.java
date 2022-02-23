class Solution3 {
    public int solution(int n) {
        int answer = 0;

        while(true){
            answer = answer + n%10;
            if(n < 10) break;
            n /= 10;
        }

        return answer;
    }
}

public class DigitPlus {
    public static void main(String[] args) {
        Solution3 sol3 = new Solution3();
        int res = sol3.solution(987);
        System.out.println(res);
    }
}
