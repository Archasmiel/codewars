package kyu_4;

import java.util.*;

public class Assign3 {

    static class SearchingWay {

        public String result;
        public Map<Character, Set<Character>> map;

        public SearchingWay(Character currNode, Map<Character, Set<Character>> map) {
            this.map = map;
            recursiveSearch("" + currNode, currNode);
        }

        public void recursiveSearch(String res, Character currNode) {
            if (map.get(currNode).size() > 0) {
                for (Character i: map.get(currNode)) {
                    recursiveSearch(res+i, i);
                }
            } else {
                if (res.length() == map.keySet().size()) result = res;
            }
        }

    }



    public static String recoverSecret(char[][] triplets) {
        Map<Character, Integer> times = new HashMap<>();
        for (char[] triplet: triplets){
            for (int i = 0 ; i < 3 ; i++) {
                times.put(triplet[i], times.getOrDefault(triplet[i], 0) + i);
            }
        }

        char firstChar = 0;
        for (Map.Entry<Character, Integer> entry: times.entrySet()) {
            if (entry.getValue() == 0) {
                firstChar = entry.getKey();
                break;
            }
        }

        Map<Character, Set<Character>> map = new HashMap<>();
        for (char[] triplet: triplets){
            if (!map.containsKey(triplet[0])) map.put(triplet[0], new HashSet<>());
            map.get(triplet[0]).add(triplet[1]);

            if (!map.containsKey(triplet[1])) map.put(triplet[1], new HashSet<>());
            map.get(triplet[1]).add(triplet[2]);

            if (!map.containsKey(triplet[2])) map.put(triplet[2], new HashSet<>());
        }

        SearchingWay sw = new SearchingWay(firstChar, map);

        return sw.result;
    }

    public static void main(String[] args) {
        char[][] triplets = {
                {'t','u','p'},
                {'w','h','i'},
                {'t','s','u'},
                {'a','t','s'},
                {'h','a','p'},
                {'t','i','s'},
                {'w','h','s'}
        };
        System.out.println(recoverSecret(triplets));
    }


}
