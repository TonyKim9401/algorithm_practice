package doit.datastructure;

import java.util.Arrays;
import java.util.Scanner;

public class BJ1546 {
    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        int sum = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            if (temp > max) max = temp;
            sum += temp;
        }
        System.out.println(sum * 100.0 / max / N);

    }
}
