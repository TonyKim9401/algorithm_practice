package ndb.binarysearch;

import java.util.*;
import java.io.*;

public class InstallModem {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int modem = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 1; // 좌표 집들 간의 최소 간격 0~1 사이
        int end = arr[arr.length - 1] - arr[0]; // 최대 간격 0~n 사이
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int value = arr[0];
            int cnt = 1;

            for (int i = 1; i < arr.length; i++) {
                // mid 간격대로 간격 올리며 공유기 설치
                if (arr[i] >= value + mid) {
                    value = arr[i];
                    cnt += 1;
                }
            }

            // 설치한 공유기 수가, 정해진 수보다 크거나 같으면
            if (cnt >= modem) {
                start = mid + 1;
                result = mid;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
