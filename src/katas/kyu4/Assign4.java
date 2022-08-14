package katas.kyu4;

import java.util.ArrayList;
import java.util.List;

public class Assign4 {

    public static String rangeExtraction(int[] arr) {
        StringBuilder builder = new StringBuilder();
        List<List<Integer>> strikes = new ArrayList<>();

        strikes.add(new ArrayList<>());
        strikes.get(0).add(arr[0]);
        int index = 0, last = arr[0];
        for (int i = 1 ; i < arr.length ; i++) {
            if (arr[i] != last + 1) {
                index++;
                strikes.add(new ArrayList<>());
            }
            strikes.get(index).add(arr[i]);
            last = arr[i];
        }

        for (List<Integer> list: strikes) {
            if (!builder.isEmpty()) builder.append(",");
            if (list.size() == 1) {
                builder.append(list.get(0));
            } else {
                builder.append(list.get(0)).append(list.size() == 2 ? "," : "-").append(list.get(list.size()-1));
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(rangeExtraction(new int[] {-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,14,15,17,18,19,20}));
        System.out.println("-6,-3-1,3-5,7-11,14,15,17-20");

        System.out.println(rangeExtraction(new int[] {-3,-2,-1,2,10,15,16,18,19,20,24}));
        System.out.println("-3--1,2,10,15,16,18-20");
    }

}
