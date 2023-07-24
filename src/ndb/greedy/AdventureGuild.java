package ndb.greedy;

import java.util.*;
import java.util.stream.*;

public class AdventureGuild {
    public static void main(String[] args) {

        int N = 5;
        int[] players = {2,3,1,2,2};

        Arrays.sort(players);
        int answer = 0;
        int count = 0;

        //[1] [2 2] 2 3
        for (int i = 0; i < players.length; i++) {
            count += 1;

            if (count >= players[i]) {
                answer += 1;
                count = 0;
            }

        }

        System.out.println(count);


    }
}
