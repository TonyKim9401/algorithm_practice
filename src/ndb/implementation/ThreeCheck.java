package ndb.implementation;

import java.io.*;

public class ThreeCheck {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < N + 1; i ++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    String time = i +""+ j +""+ k;
                    if (time.contains("3")) answer += 1;
//                  if (time.indexOf("3") > -1) answer += 1;
                }
            }
        }

        System.out.println(answer);

    }
}
