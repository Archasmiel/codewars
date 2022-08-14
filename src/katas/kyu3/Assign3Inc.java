package katas.kyu3;


import java.util.*;

public class Assign3Inc {

    public static int[] smaller(int[] unsorted) {
        Map<Integer, Integer> list = new HashMap<>();

        for (int i = unsorted.length-1 ; i >= 0 ; i--) {
            list.put(unsorted[i], list.getOrDefault(unsorted[i-1], 0) + 1);
            for (Map.Entry<Integer, Integer> entry: list.entrySet()) {
                // if ()
            }
        }

        System.out.println(list);

        System.out.println(list);

        return null;
    }

    public static void main(String[] args) {

//        int[] random = new int[100_000];
//        for (int i = 0 ; i < random.length ; i++) {
//            random[i] = (int) (Math.random() * 9);
//        }
//        System.out.println(Arrays.toString(smaller(random)));


        System.out.println(Arrays.toString(smaller(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(smaller(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(smaller(new int[]{3, 3, 0, 0, 0})));
        System.out.println(Arrays.toString(smaller(new int[]{1, 1, -1, 0, 0})));
    }

}
