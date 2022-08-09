package kyu_6;

public class Assign6 {

    static int find(int[] arr){

        for (int i = 0 ; i < arr.length - 2 ; i++) {
            boolean st1 = arr[i] % 2 == 0;
            boolean st2 = arr[i+1] % 2 == 0;
            boolean st3 = arr[i+2] % 2 == 0;

            if ((st1 == st2) & (st1 == st3)) continue;
            if ((st1 ^ st2) & (st1 ^ st3)) return arr[i];
            if (st2 ^ st1) return arr[i+1];
            return arr[i+2];
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[] {2, 4, 0, 100, 4, 11, 2602, 36}));
        System.out.println(find(new int[] {160, 3, 1719, 19, 11, 13, -21}));
    }

}
