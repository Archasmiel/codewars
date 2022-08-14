package katas.kyu7;

// https://www.codewars.com/kata/5390bac347d09b7da40006f6/train/java

import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Assign3 {

    static Logger logger = Logger.getGlobal();

    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.equals("")) return null;

        return Arrays.stream(phrase.split("[\\s]+"))
                .map(e -> " " + Character.toUpperCase(e.charAt(0)) + ((e.length() > 1) ? e.substring(1) : ""))
                .collect(Collectors.joining())
                .substring(1, phrase.length()+1);
    }

    public static void main(String[] args) {
        logger.info(() -> String.format("'%s'", toJadenCase("most trees are blue")));
    }

}
