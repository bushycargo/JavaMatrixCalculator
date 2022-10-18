package org.example;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] matrixOne = null;
        int[][] matrixTwo = null;
        int[][] matrixOut = null;
        while (true){
            if (matrixOne != null && matrixTwo != null){
                System.out.println("Matrix A: " + Arrays.deepToString(matrixOne));
                System.out.println("Matrix B: " + Arrays.deepToString(matrixTwo));
            }
            if (matrixOut != null){
                System.out.println("Matrix Out: " + Arrays.deepToString(matrixOut));
            }
            System.out.println("Matrix Calculator\n1)Enter Matrix A\n2)Enter Matrix B\n3)Calculate\n4)Print Matrix Out\n5)Quit\nPlease enter your selection:");

            switch (scanner.nextInt()) {
                case 1 -> matrixOne = enterMatrix();
                case 2 -> matrixTwo = enterMatrix();
                case 3 ->{
                    scanner.nextLine();
                    System.out.println("+, -, * or s*\nWhere s* is scalar multiplication");
                    String type = scanner.nextLine();
                    System.out.println("Which order? AB or BA");
                    String order = scanner.nextLine();
                    try{
                        if (Objects.equals(order, "AB") || Objects.equals(order, "ab")){
                            switch (type){
                                case "+" -> matrixOut = MatrixCalculator.addition(matrixOne, matrixTwo);
                                case "-" -> matrixOut = MatrixCalculator.subtraction(matrixOne, matrixTwo);
                                case "*" -> matrixOut = MatrixCalculator.multiplication(matrixOne, matrixTwo);
                                case "s*" -> {
                                    System.out.println("This only uses matrix A\nPlease enter your scalar");
                                    int scalar = scanner.nextInt();
                                    scanner.nextLine();
                                    matrixOut = MatrixCalculator.scalar(matrixOne, scalar);
                                }
                            }
                        } else{
                            switch (type){
                                case "+" -> matrixOut = MatrixCalculator.addition(matrixTwo, matrixOne);
                                case "-" -> matrixOut = MatrixCalculator.subtraction(matrixTwo, matrixOne);
                                case "*" -> matrixOut = MatrixCalculator.multiplication(matrixTwo, matrixOne);
                                case "s*" -> {
                                    System.out.println("This only uses matrix A\nPlease enter your scalar");
                                    int scalar = scanner.nextInt();
                                    scanner.nextLine();
                                    matrixOut = MatrixCalculator.scalar(matrixOne, scalar);
                                }
                            }
                        }
                    }catch (MatrixSizeException e){
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    assert matrixOut != null;
                    System.out.println(Arrays.deepToString(matrixOut));
                }
                case 5 -> System.exit(0);
            }
        }
    }

    private static int[][] enterMatrix(){
        try{
            System.out.println("Enter rows:");
            int rows = scanner.nextInt();
            System.out.println("Enter columns:");
            int columns = scanner.nextInt();

            int[][] matrix = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.println("Please Enter:\nRow " + i + " Column " + j);
                    matrix[i][j] = scanner.nextInt();
                }
            }

            return matrix;
        }
        catch (InputMismatchException e){
            System.out.println("Incorrect Input");
            return enterMatrix();
        }
    }
}