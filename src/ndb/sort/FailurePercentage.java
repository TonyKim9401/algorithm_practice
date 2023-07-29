package ndb.sort;

import java.util.*;

public class FailurePercentage {

    public static class Stage{
        int stage;
        double failure;
        Stage(int s, double f) {
            stage = s;
            failure = f;
        }
    }

    public static void main(String[] args) {

        int N = 4;
//        int[] stages = new int[]{2,1,2,6,2,4,3,3};
        int[] stages = new int[]{4,4,4,4,4};
        int[] result = new int[N];
        int[] stagePlayer = new int[N + 1];

        int players = stages.length;

        //stages 정렬
        Arrays.sort(stages);

        //해당 stage에 플레이어가 없으면 0으로 고정
        for (int i = 0; i < stages.length; i++) {
            if (stages[i] > N) continue;
            stagePlayer[stages[i]] += 1;
        }

        List<Stage> list = new ArrayList<>();
        for (int i = 1; i < stagePlayer.length; i++) {
            double temp = stagePlayer[i] * 100;

            double percentage =  temp / players;

            if (stagePlayer[i] == 0) percentage = 0.0;
            list.add(new Stage(i, percentage));

            players -= stagePlayer[i];
        }

        list.sort((o1, o2) -> {
           if (o1.failure == o2.failure) {
               return o1.stage - o2.stage;
           }
           return Double.compare(o2.failure, o1.failure); // Double형에 주의!!!!!!!!
        });

        for (int i = 0; i < result.length; i++) {
            System.out.println(list.get(i).stage + " " + list.get(i).failure);
        }

        list.toArray();


    }
}
