package ndb.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class FactoryNum {
    public static void main(String[] args) {
        int N = 9;
        int result = factories(4);
        System.out.println(result);

    }

    public static int factories(int N) {
        if (N == 1) {
            return 1;
        }
        return N * factories(N - 1);
    }
}
