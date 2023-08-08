package ndb.dp;

public class DpFivo {

    public static int[] d = new int[100];
    public static int fivo(int n) {
        if (n == 1 || n == 2) {
            d[n] = 1;
            return 1;
        }
        if (d[n] != 0) return d[n];
        d[n] = fivo(n - 1) + fivo(n - 2);
        return d[n];
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        fivo(80);
        long end = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        fivo2(30);
        long end2 = System.currentTimeMillis();

        for (int n : d) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println(end - start);
        System.out.println(end2 - start2);
    }

    public static int fivo2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fivo(n - 1) + fivo(n - 2);
    }
}
