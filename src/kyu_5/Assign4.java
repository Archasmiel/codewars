package kyu_5;

import java.util.*;

public class Assign4 {

    public static String factors(int n) {
        Map<Integer, Integer> factors = new HashMap<>();

        int nSave = n;
        for (int i = 2 ; i <= Math.sqrt(nSave) ; i++) {
            while (n % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                n /= i;
            }
            if (n == 1) break;
        }

        StringBuilder builder = new StringBuilder();
        factors.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> {
            if (entry.getValue() == 1) {
                builder.append(String.format("(%d)", entry.getKey()));
            } else {
                builder.append(String.format("(%d**%d)", entry.getKey(), entry.getValue()));
            }
        });

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(factors(100));
        System.out.println(factors(7775460));
    }

}
