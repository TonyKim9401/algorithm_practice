package ndb.implementation;

public class LuckyStraight {
    public static void main(String[] args) {

//        String str = "123402";
        String str = "7755";

        int half = (str.length() / 2);

        int left = 0;
        int right = 0;

        for (int i = 0; i < str.length(); i++) {
            if (i < half) {
                left += str.charAt(i) - '0';
            } else {
                right += str.charAt(i) - '0';
            }
        }

        if (left == right) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }

    }
}
