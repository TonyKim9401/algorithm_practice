class Solution4 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for(int i=1; i<=n; i++){
            answer[i] = (long)x*(i+1);
        }

        return answer;
    }
}
public class IntervalXnumberN {
    public static void main(String[] args) {
        Solution4 sol4 = new Solution4();
        System.out.println(sol4.solution(2,5));
    }
}
