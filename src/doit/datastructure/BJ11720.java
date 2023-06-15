package doit.datastructure;

import java.util.Scanner;

public class BJ11720 {
    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);
        final int length = sc.nextInt();
        final String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;

        for (char c : cNum) {
            sum += c - '0'; // 48로 대체 가능
        }
        System.out.println("sum = " + sum);

    }
}
