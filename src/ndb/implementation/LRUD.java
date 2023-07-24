package ndb.implementation;

public class LRUD {
    public static void main(String[] args) {

        int N = 5;

        String[] moves = {"R", "R","R", "U", "D", "D"};


        //        동  남  서  북
        int[] y = {0, 1,  0, -1};
        int[] x = {1, 0, -1 , 0};

        //                y, x
        int[] location = {1, 1};

        for (String move : moves) {
            if (move.equals("R")) {
                int temp = location[1] + x[0];
                if (temp > N) continue;
                location[1] += x[0];
            } else if (move.equals("L")) {
                int temp = location[1] + x[2];
                if (temp < 1) continue;
                location[1] -= x[2];
            } else if (move.equals("U")) {
                int temp = location[0] + y[3];
                if (temp < 1) continue;
                location[0] += y[3];
            } else  { // D
                int temp = location[0] + y[1];
                if (temp > N) continue;
                location[0] += y[1];
            }
        }

        System.out.println(location[0] + " " + location[1]);

    }
}
