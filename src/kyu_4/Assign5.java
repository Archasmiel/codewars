package kyu_4;

import java.util.ArrayList;
import java.util.List;

public class Assign5 {

    public static void writeStack(StringBuilder builder, List<String> stack, int width, int chars, int words, int end) {

        int whitespaces = end == 0 ? width-chars : words-1;
        int wCount = stack.size() - 1;
        int wSize = wCount == 0 ? 0 : whitespaces / wCount;
        whitespaces %= wCount == 0 ? 1 : wCount;

        for (int i = 0 ; i < stack.size()-1 ; i++) {
            builder.append(stack.get(i));
            builder.append(" ".repeat(wSize));
            if (whitespaces > 0) {
                builder.append(" ");
                whitespaces--;
            }
        }
        builder.append(stack.get(stack.size()-1));
        if (end == 0) builder.append("\n");
    }

    public static String justify(String text, int width) {
        StringBuilder builder = new StringBuilder();
        List<String> stack = new ArrayList<>();
        String[] words = text.split(" ");

        int currentChars = 0;
        int currentWords = 0;

        for (int i = 0 ; i < words.length ; i++) {
            String word = words[i];

            if (currentChars + word.length() + currentWords <= width) {
                stack.add(word);
                currentChars += word.length();
                currentWords++;
            } else {
                writeStack(builder, stack, width, currentChars, currentWords, 0);
                stack.clear();
                stack.add(word);
                currentChars = word.length();
                currentWords = 1;
            }
            if (i == words.length-1) writeStack(builder, stack, width, currentChars, currentWords, 1);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        String LIPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sa"
                + "gittis dolor mauris, at elementum ligula tempor eget. In quis rhoncus nunc, at aliquet orci. Fusc"
                + "e at dolor sit amet felis suscipit tristique. Nam a imperdiet tellus. Nulla eu vestibulum urna. V"
                + "ivamus tincidunt suscipit enim, nec ultrices nisi volutpat ac. Maecenas sit amet lacinia arcu, no"
                + "n dictum justo. Donec sed quam vel risus faucibus euismod. Suspendisse rhoncus rhoncus felis at f"
                + "ermentum. Donec lorem magna, ultricies a nunc sit amet, blandit fringilla nunc. In vestibulum vel"
                + "it ac felis rhoncus pellentesque. Mauris at tellus enim. Aliquam eleifend tempus dapibus. Pellent"
                + "esque commodo, nisi sit amet hendrerit fringilla, ante odio porta lacus, ut elementum justo nulla"
                + " et dolor.";

        System.out.println(justify(LIPSUM, 30));
        System.out.println(justify("123 45 6", 7));
        System.out.println(justify("123", 7));
        System.out.println(justify("", 10));
    }

}
