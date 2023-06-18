package doit.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1940 {
    public static void main(String[] args) throws IOException {

         /*
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        int count = 0;

        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for(int i = 0; i < N - 1; i++) {
            int start_index = A[i];

            for(int j = i + 1; j < N; j++) {
                int sum = start_index + A[j];
                if (sum == M){
                    count++;
                }
            }
        }
        */

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int count = 0;
        final StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        int j = A.length - 1;
        Arrays.sort(A);

        while (i < j) {
            if (A[i] + A[j] < M) {
                i++;
            } else if (A[i] + A[j] > M) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }

        System.out.println(count);

    }
}
