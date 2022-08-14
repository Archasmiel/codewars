package katas.kyu3;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.*;

// https://www.codewars.com/kata/540d0fdd3b6532e5c3000b5b

public class Assign2 {

    private static final Map<Integer, BigInteger> factorials = new HashMap<>();
    private static final BigInteger one = BigInteger.ONE;

    private static BigInteger pow(int n, int power) {
        return new BigInteger(String.valueOf(n)).pow(power);
    }

    private static BigInteger fact(int num) {
        if (!factorials.containsKey(0))
            factorials.put(0, one);

        if (!factorials.containsKey(num)) {
            BigInteger res = BigInteger.ONE;
            for (int i = 2 ; i <= num ; i++) {
                res = res.multiply(new BigInteger(String.valueOf(i)));
            }
            factorials.put(num, res);
            return res;
        }
        return factorials.get(num);
    }

    private static BigInteger binomCoef(int n, int k) {
        return fact(n).divide(fact(k)).divide(fact(n-k));
    }

    private static BigInteger multiplier(int a, int aPower, int b, int bPower, int n, int k) {
        return binomCoef(n, k)
                .multiply(pow(a, aPower))
                .multiply(pow(b, bPower));

    }





    public static String expand(String expr) {
        List<Integer> coefs = new ArrayList<>();
        Optional<MatchResult> variation = Pattern.compile("[a-z]+").matcher(expr).results().findFirst();
        String vari = "";
        if (variation.isPresent()) vari = variation.get().group();

        if (expr.startsWith("(-" + vari)) coefs.add(-1);
        else if (expr.startsWith("(" + vari)) coefs.add(1);
        Pattern.compile("-?[\\d]+").matcher(expr).results().map(MatchResult::group).forEach(e -> coefs.add(Integer.parseInt(e)));

        if (coefs.get(0) == 0 && coefs.get(1) == 0) return "0";
        if (coefs.get(0) == 0) return "" + (long) Math.pow(coefs.get(1), coefs.get(2));
        if (coefs.get(1) == 0) return (pow(coefs.get(0), coefs.get(2)).equals(one) ? "" : pow(coefs.get(0), coefs.get(2))) + vari + "^" + coefs.get(2);


        StringBuilder builder = new StringBuilder();
        for (int i = 0 ; i <= coefs.get(2) ; i++) {
            BigInteger multiplier = multiplier(coefs.get(0), coefs.get(2)-i, coefs.get(1), i, coefs.get(2), i);
            builder.append(multiplier.equals(one) ? "" : multiplier).append(vari).append("^").append(coefs.get(2)-i).append(" ");
        }

        String res = builder.toString()
                .replace(" ", "+")
                .replace("+-", "-")
                .replace(vari+"^0+", "")
                .replace(vari+"^1+", vari+"+")
                .replace(vari+"^1-", vari+"-");

        if (res.length() == 0) return "1";
        if (res.charAt(res.length()-1) == '-' || res.charAt(res.length()-1) == '+') res += "1";

        res = res.replace("-1"+vari+"^", "-"+vari+"^");

        return res;
    }


    public static void main(String[] args) {
        System.out.println(expand("(x+1)^2"));
        System.out.println(expand("(-7x-7)^0"));
        System.out.println(expand("(-247x+347)^0"));

        System.out.println(expand("(x+1)^2"));      // returns "x^2+2x+1"
        System.out.println(expand("(p-1)^3"));     // returns "p^3-3p^2+3p-1"
        System.out.println(expand("(2f+4)^6"));    // returns "64f^6+768f^5+3840f^4+10240f^3+15360f^2+12288f+4096"
        System.out.println(expand("(-2a-4)^0"));    // returns "1"
        System.out.println(expand("(-12t+43)^2"));  // returns "144t^2-1032t+1849"
        System.out.println(expand("(r+0)^203"));    // returns "r^203"
        System.out.println(expand("(-x-1)^2"));     // returns "x^2+2x+1"
    }


}
