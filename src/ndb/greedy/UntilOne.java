package ndb.greedy;

public class UntilOne {
    public static void main(String[] args) {

        int answer = 0;
        int N = 25;
        int k = 4;

        while (true) {
            int target = (N / k) * k;
            answer += N - target;
            N = target;
            if (N < k) break;
            answer += 1;
            N /= k;
        }

        answer += N - 1;



        System.out.println(answer);
    }
}
