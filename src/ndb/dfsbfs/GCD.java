package ndb.dfsbfs;

public class GCD {
    public static void main(String[] args) {
        // 유클리드 호제법
        int A = 192;
        int B = 162;

        int result = getGcd(B, A);
        System.out.println(result);
    }

    public static int getGcd(int A, int B) {
        if (A % B == 0) return B;
        return getGcd(B, A % B);
    }
}
