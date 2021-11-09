package main;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        String stringInput;

        while (!quit) {
            System.out.println("Choose\n" +
                    "1 to enter a start\n" +
                    "0 to exit: \n");
            boolean hasNextInt = scanner.hasNextInt(); //returns true if the scanner's input is an integer
            if (hasNextInt) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 0:
                        System.out.println("You have left the program.");
                        quit = true;
                        break;
                    case 1:
                        MaxHeap<Integer> addMaxHeap = new MaxHeap<Integer>(1000);
                        System.out.print("Choose an option below:\n" +
                                "\n1. Sequential Insert" +
                                "\n2. Optimal Method\n");
                        hasNextInt = scanner.hasNextInt();
                        if (hasNextInt) {
                            choice = scanner.nextInt();
                            scanner.nextLine();
                            if (choice == 1) {
                                System.out.println("Enter a list of integers(with comma separated values): ");
                                String userArray = scanner.nextLine();
                                Integer[] testArray;
                                testArray = convertToIntegerArray(userArray);
                                addMaxHeap.sequentialInsert(testArray);
                                System.out.println("Sequential Insert: " + addMaxHeap.getTen() + "\n");
                                break;
                            } else if (choice == 2) {
                                System.out.println("Enter a list of integers(with comma separated values): ");
                                String userArray = scanner.nextLine();
                                Integer[] testArray;
                                testArray = convertToIntegerArray(userArray);
                                addMaxHeap.optimalMethod(testArray);
                                System.out.println("Sequential Insert: " + addMaxHeap.getTen() + "\n");
                                break;
                            }
                            else {
                                throw new IllegalArgumentException("Please choose an option by entering an integer: 1 or 2");
                            }
                        } else {
                            throw new IllegalArgumentException("Please choose an option by entering an integer: 1 or 2");
                        }

                }
            } else {
                System.out.println("Unable to parse choice: Please enter an integer of choice");
                throw new IllegalArgumentException("Please enter an integer of choice");
            }
        }
    }

    private static Integer[] convertToIntegerArray(String userArray)
    {
        userArray =  userArray.replaceAll("\\s", ""); // removing all spaces
        String[] integerArray = userArray.split(",");
        Integer[] numbers = new Integer[integerArray.length];
        for(int i = 0;i < integerArray.length;i++)
        {
            numbers[i] = Integer.parseInt(integerArray[i]);
        }

        return numbers;
    }
}
