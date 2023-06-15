package doit.datastructure;

import java.util.Scanner;

public class BJ11720 {
    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);
        final int length = sc.nextInt();
        final String sNum = sc.next();
        char[] cNum = new char[length];

        cNum = sNum.toCharArray();
        int sum = 0;

        for (char c : cNum) {
            sum += c - 48;
        }
        System.out.println("sum = " + sum);

    }
}
