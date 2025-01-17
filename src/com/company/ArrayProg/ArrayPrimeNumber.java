package com.company.ArrayProg;

import java.util.Arrays;

public class ArrayPrimeNumber {
    public int[] primeNumber(int[] arr) {
        int[] prime = new int[arr.length];
        int index = 0; // To keep track of valid prime numbers

        for (int i = 0; i < arr.length; i++) {
            if (isPrime(arr[i])) {
                prime[index++] = arr[i]; // Store the prime number and move the index
            }
        }

        // Trim the array to the actual size of prime numbers
        int[] result = new int[index];
        System.arraycopy(prime, 0, result, 0, index);

        return result;
    }

    // Method to check if a number is prime
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false; // Numbers <= 1 are not prime
        }
        for (int j = 2; j <= Math.sqrt(num); j++) {
            if (num % j == 0) {
                return false; // Divisible by another number, not prime
            }
        }
        return true; // No divisors found, number is prime
    }

    public static void main(String[] args) {
        ArrayPrimeNumber primeNumber = new ArrayPrimeNumber();
        int[] arr = {2, 1, 3, 4, 5, 6, 7, 8, 9, 11};
        int[] prime = primeNumber.primeNumber(arr);

        System.out.println("Prime numbers in the array:");
        for (int number : prime) {
            System.out.println(number);
        }
        System.out.println(Arrays.toString(prime));
    }
}
