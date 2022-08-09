package kyu_6;

public class Assign3 {

    public static String expandedForm(int num) {
        StringBuilder res = new StringBuilder();
        String numb = Integer.toString(num);
        for (int i = numb.length()-1 ; i >= 0 ; i--) {
            int n = Character.getNumericValue(numb.charAt(numb.length()-1-i));
            if (n > 0) {
                if (res.toString().equals("")){
                    res.append(n * (int) Math.pow(10, i));
                    continue;
                }
                res.append(" + ").append(n * (int) Math.pow(10, i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(12));
        System.out.println(expandedForm(43));
        System.out.println(expandedForm(1030));
    }

}
