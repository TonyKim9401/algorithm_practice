package ndb;

public class UntilOne {
    public static void main(String[] args) {

        int answer = 0;
        int N = 25;
        int k = 3;

        while (N != 1) {
            answer += 1;
            if (N % k != 0) {
                N -= 1;
            } else {
                N /= k;
            }
        }



        System.out.println(answer);
    }
}
