package katas.kyu4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Assign2 {

    public static List<String> genPINs(List<List<String>> pool) {
        List<String> temp = new ArrayList<>(), tempPool = new ArrayList<>();

        for (List<String> subPool: pool) {
            if (temp.size() == 0) {
                temp.addAll(subPool);
                continue;
            }
            tempPool.clear();
            for (String poolElem: subPool) {
                for (String i: temp) {
                    tempPool.add(i + poolElem);
                }
            }
            temp.clear();
            temp.addAll(tempPool);
        }

        return temp;
    }

    public static List<String> getNearNumbers(String num) {
        return switch (num) {
            case "1" -> Arrays.asList("1", "2", "4");
            case "3" -> Arrays.asList("2", "3", "6");
            case "7" -> Arrays.asList("4", "7", "8");
            case "9" -> Arrays.asList("6", "8", "9");

            case "2" -> Arrays.asList("1", "2", "3", "5");
            case "4" -> Arrays.asList("1", "4", "5", "7");
            case "6" -> Arrays.asList("3", "5", "6", "9");

            case "5" -> Arrays.asList("2", "4", "5", "6", "8");
            case "8" -> Arrays.asList("5", "7", "8", "9", "0");

            case "0" -> Arrays.asList("0", "8");
            default -> null;
        };
    }

    public static List<String> getPINs(String observed) {
        List<List<String>> pool = new ArrayList<>();
        Arrays.stream(observed.split("")).forEach(e -> pool.add(getNearNumbers(e)));
        return genPINs(pool);
    }

    public static void main(String[] args) {
        System.out.println(getPINs("23"));
        System.out.println(getPINs("2389"));
        System.out.println(getPINs("8"));
    }

}
