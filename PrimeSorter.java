/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.primesorter;

/**
 *
 * @author Jericho Seriosa
 */
import java.util.Scanner;

public class PrimeSorter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);       
        System.out.println("Enter at least 15 integers:");        
        int[] inputArray = new int[15];
       
        getUserInput(inputArray, 0);
       
        System.out.println("Original Input:");
        displayArray(inputArray);
       
        removePrimes(inputArray, 0);
        
        System.out.println("Array after removing primes:");
        displayArray(inputArray);
        
        selectionSort(inputArray, 0);
        
        System.out.println("Sorted Prime Numbers (Descending Order):");
        displayArray(inputArray);
       
        System.out.println("Do you want to run again? (y/n)");
        char choice = scanner.next().charAt(0);

        if (choice == 'y' || choice == 'Y') {
            main(args); // Recursively call main to run again
        } else {
            System.out.println("Program exited.");
        }
    }

    
      private static void getUserInput(int[] array, int index) {
        Scanner scanner = new Scanner(System.in);

        if (index < array.length) {
            try {
                System.out.print("Enter integer #" + (index + 1) + ": ");
                int userInput = Integer.parseInt(scanner.nextLine());

                // Check for invalid input
                if (userInput <= 0) {
                    System.out.println("Invalid input. Please enter a positive non-zero integer.");
                    getUserInput(array, index); // Retry the current index
                } else {
                    array[index] = userInput;
                    getUserInput(array, index + 1); // Recursively call for the next index
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                getUserInput(array, index); // Retry the current index
            }
        }
    }

    
    private static void removePrimes(int[] array, int index) {
        if (index < array.length) {
            if (isPrime(array[index])) {
                array[index] = 0; 
            }
            removePrimes(array, index + 1); 
        }
    }

    
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    
    private static void selectionSort(int[] array, int start) {
        if (start < array.length - 1) {
            int minIndex = start;
            for (int i = start + 1; i < array.length; i++) {
                if (array[i] > array[minIndex]) {
                    minIndex = i;
                }
            }
            
            int temp = array[start];
            array[start] = array[minIndex];
            array[minIndex] = temp;

            selectionSort(array, start + 1); 
        }
    }

    
    private static void displayArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
