package kyu_3;


import java.util.*;
import java.util.stream.Collectors;

public class Assign3Inc {

    public static int[] smaller(int[] unsorted) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = unsorted.length-1 ; i >= 0 ; i--) {
            if (!map.containsKey(unsorted[i]))
            map.put(unsorted[i], map.getOrDefault(unsorted[i], 0) + 1);
        }

        return unsorted;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smaller(new int[]{5, 4, 3, 2, 1})));
    }

}
