package katas.kyu5;

import java.util.ArrayList;
import java.util.List;

public class Assign2 {

    static class Circle {

        private final List<Integer> members = new ArrayList<>();
        private final Integer size, step;
        private int currIndex;

        public Circle(int n, int k) {
            currIndex = 0;
            size = n;
            step = k-1;
            for (int i = 1 ; i <= n ; i++) {
                members.add(i);
            }
        }

        public void killAll() {
            for (int i = 0 ; i < size ; i++) {
                if (hasMembers()) {
                    currIndex += step;
                    currIndex %= members.size();
                    members.remove(currIndex);
                }
            }
        }

        public boolean hasMembers() {
            return members.size() > 1;
        }

        public int getWinner() {
            return !hasMembers() ? members.get(0) : -1;
        }

    }

    public static int josephusSurvivor(final int n, final int k) {
        Circle circle = new Circle(n, k);
        circle.killAll();
        return circle.getWinner();
    }

    public static void main(String[] args) {
        System.out.println(josephusSurvivor(7, 3));

        for (int i = 2 ; i < 50 ; i++)
            System.out.print(josephusSurvivor(i, 2) + " ");
        System.out.println();
        for (int i = 2 ; i < 50 ; i++)
            System.out.print(josephusSurvivor(i, 3) + " ");
        System.out.println();
        for (int i = 2 ; i < 50 ; i++)
            System.out.print(josephusSurvivor(i, 4) + " ");
    }


}
