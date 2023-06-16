package doit.datastructure;

import java.util.Scanner;

public class BJ2018 {
    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;

        while (end_index != N) {
            /**
             * N과 투포인트의 합이 같으면
             * 카운트 + 1
             * 끝점 + 1
             * 합 = 합 + 끝점 인덱스값
             */
            if (sum == N) {
                count++;
                end_index++;
                sum += end_index;
            }
            /**
             * sum이 N보다 크면
             * sum = sum - 시작 인덱스 값
             * 시작 인덱스 + 1
             */
            else if (sum > N) {
                sum -= start_index;
                start_index++;
            }
            /**
             * sun이 N보다 작으면
             * 끝점 + 1
             * sum = sum + 끝점
             */
            else if (sum < N) {
                end_index++;
                sum += end_index;
            }
        }

        System.out.println(count);

    }
}
