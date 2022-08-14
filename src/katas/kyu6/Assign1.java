package katas.kyu6;

public class Assign1 {

    public static long digPow(int n, int p) {
        long res = 0;
        String num = Integer.toString(n);
        for (int i = 0 ; i < num.length() ; i++) {
            res += Math.pow(Character.getNumericValue(num.charAt(i)), p++);
        }

        if (Math.floor((double) res / n) == (double) res / n)
            return res;

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(digPow(89, 1));
        System.out.println(digPow(92, 1));
        System.out.println(digPow(46288, 3));
    }

}
