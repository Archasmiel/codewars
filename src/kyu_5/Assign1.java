package kyu_5;

import java.util.HashMap;
import java.util.Map;

public class Assign1 {

    public static boolean scramble(String str1, String str2) {
        Map<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        str1.chars().forEach(e -> map1.put((char) e, map1.getOrDefault((char) e, 0) + 1));
        str2.chars().forEach(e -> map2.put((char) e, map2.getOrDefault((char) e, 0) + 1));
        for (Map.Entry<Character, Integer> entry: map2.entrySet()) {
            if (map1.containsKey(entry.getKey())){
                if (map1.get(entry.getKey()) < entry.getValue()) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(scramble("rkqodlw","world"));
        System.out.println(scramble("cedewaraaossoqqyt","codewars"));
        System.out.println(scramble("katas","steak"));
        System.out.println(scramble("scriptjavx","javascript"));
        System.out.println(scramble("scriptingjava","javascript"));
        System.out.println(scramble("scriptsjava","javascripts"));
        System.out.println(scramble("javscripts","javascript"));
        System.out.println(scramble("aabbcamaomsccdd","commas"));
        System.out.println(scramble("commas","commas"));
        System.out.println(scramble("sammoc","commas"));
    }

}
