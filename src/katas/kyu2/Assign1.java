package katas.kyu2;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Assign1 {

    public static IntStream stream() {
        return Stream.iterate(2L, PrimeUtil::next).limit(50_000_000).mapToInt(Long::intValue);
    }

    public static void main(String[] args) {
        stream().forEach(System.out::println);
    }

}

class PrimeUtil {
    private long lastPrime = 0L;

    // Computes the prime number after the last generated prime
    public long next() {
        lastPrime = next(lastPrime);
        return lastPrime;
    }

    // Computes the prime number after the specified number
    public static long next(long after) {
        long counter = after;

        // Keep looping until you find the next prime number
        while (!isPrime(++counter))
            ;

        return counter;
    }

    // Checks if the specified number is a prime number
    public static boolean isPrime(long number) {
        // <= 1 is not a prime number
        if (number <= 1) {
            return false;
        }

        // 2 is a prime number
        if (number == 2) {
            return true;
        }

        // Even numbers > 2 are not prime numbers
        if (number % 2 == 0) {
            return false;
        }

        long maxDivisor = (long) Math.sqrt(number);
        for (int counter = 3; counter <= maxDivisor; counter += 2) {
            if (number % counter == 0) {
                return false;
            }
        }

        return true;
    }
}
