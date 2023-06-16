package doit.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class BJ11659 {
    public static void main(String[] args) throws IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int suNo = Integer.parseInt(st.nextToken());
        int quizNo = Integer.parseInt(st.nextToken());

        // 0번째 인덱스를 무시하기 위해서 + 1로 한칸 더 늘려놓음
        // int, long 배열의 경우 값이 없으면 0으로 자동 생성
        long[] S = new long[suNo + 1];
        S[0] = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= suNo; i++){
            S[i] = S[i-1] +  Integer.parseInt(st.nextToken());
        }

        for(int q = 0; q <= quizNo; q++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(S[j] - S[i-1]);
        }

/*
        final Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        int[] S = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        //합배열 만들기
        S[0] = A[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i-1] + A[i];
        }

        for (int s = 0; s < M; s++) {
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;
            if (i == 0){
                System.out.println(S[j]);
                continue;
            }
            System.out.println(S[j] - S[i-1]);
        }
*/

    }

}
