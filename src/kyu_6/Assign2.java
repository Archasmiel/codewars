package kyu_6;

import java.util.Arrays;

public class Assign2 {

    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null)
            return false;

        a = Arrays.stream(a).map(e -> e*e).toArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        System.out.println(comp(a, b));
    }

}
