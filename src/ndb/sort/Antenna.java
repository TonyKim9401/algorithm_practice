package ndb.sort;

import java.util.*;
import java.io.*;

public class Antenna {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 안테나 위치 입력받고
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //  오름차순으로 정렬
        Arrays.sort(arr);

        // 중간값(아니면 하나 왼쪽)구하기
        int mid = (arr.length - 1) / 2;

        System.out.println(arr[mid]);
    }
}
