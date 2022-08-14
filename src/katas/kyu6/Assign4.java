package katas.kyu6;

import java.util.Arrays;

public class Assign4 {

    public static String[] solution(String s) {
        return (s.length() % 2 == 1 ? s + "_" : s).split("(?<=\\G.{2})");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("abc")));
        System.out.println(Arrays.toString(solution("abcdef")));
    }

}
