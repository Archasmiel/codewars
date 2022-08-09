package kyu_6;

import java.util.HashMap;
import java.util.Map;

public class Assign5 {

    static String encode(String word){
        word = word.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0 ; i < word.length() ; i++)
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);

        StringBuilder res = new StringBuilder();
        for (int i = 0 ; i < word.length() ; i++)
            res.append(map.get(word.charAt(i)) == 1 ? "(" : ")");

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(encode("din"));
        System.out.println(encode("recede" ));
        System.out.println(encode("Success"));
        System.out.println(encode("(( @"));
    }

}
