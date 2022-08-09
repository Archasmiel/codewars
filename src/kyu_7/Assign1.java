package kyu_7;

public class Assign1 {

    public static String longest (String s1, String s2) {
        StringBuilder res = new StringBuilder();
        for (int i = 'a' ; i <= 'z' ; i++)
            if (s1.indexOf(i) != -1 || s2.indexOf(i) != -1)
                res.append((char) i);
        return res.toString();
    }

    public static void main(String[] args) {
        String a = "xyaabbbccccdefww";
        String b = "xxxxyyyyabklmopq";
        System.out.println(longest(a, b));

        a = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(longest(a, a));
    }

}
