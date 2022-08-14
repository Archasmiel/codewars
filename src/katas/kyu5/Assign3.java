package katas.kyu5;

import java.util.ArrayList;
import java.util.List;

public class Assign3 {

    static class Circle<T> {

        private final List<T> members = new ArrayList<>();
        private final List<T> losers = new ArrayList<>();
        private final Integer size, step;
        private int currIndex;

        public Circle(List<T> members, int k) {
            currIndex = 0;
            size = members.size();
            step = k-1;
            this.members.addAll(members);
        }

        public void killAll() {
            for (int i = 0 ; i < size ; i++) {
                if (hasMembers()) {
                    currIndex += step;
                    currIndex %= members.size();
                    losers.add(members.remove(currIndex));
                }
            }
        }

        public boolean hasMembers() {
            return members.size() > 1;
        }

        public List<T> getLosers() {
            return losers;
        }

    }

    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        Circle<T> circle = new Circle<>(items, k);
        circle.killAll();
        return circle.getLosers();
    }

}
