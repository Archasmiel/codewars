package katas.kyu7;

public class Assign2 {

    public static String oddOrEven (int[] array) {
        boolean even = true;
        for (int j : array) even = even ^ (j % 2 != 0);
        return even ? "even" : "odd";
    }

    public static void main(String[] args) {
        System.out.println(oddOrEven(new int[] {0}));
        System.out.println(oddOrEven(new int[] {0, 1, 4}));
        System.out.println(oddOrEven(new int[] {0, -1, -5}));
    }

}
