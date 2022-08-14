package katas.kyu4;

import java.util.regex.Pattern;

public class Assign6 {

    public static Pattern multipleOf3() {
        // Regular expression that matches binary inputs that are multiple of 3
        return Pattern.compile("(1(01*0)*1|0)*");
    }

    public static void main(String[] args) {
        System.out.println(multipleOf3().matcher("000").matches());
    }

}
