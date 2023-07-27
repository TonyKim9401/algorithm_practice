package ndb.greedy;

import java.util.*;
import java.util.stream.*;
import java.io.*;

public class AdventureGuild {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] players = new int[N];
        int count = 0;
        int answer = 0;

        for (int i = 0; i <N; i++) {
            players[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(players);

        for (int player : players) {
            count += 1; // for 문 횟수 만큼의 총 사람 수
            if (count >= player) { // 구획 나누기
                answer += 1;
                count = 0;
            }
        }

        System.out.println(answer);
    }
}
