package org.example;

public class MatrixCalculator {
    public static int[][] addition(int[][] matrixOne, int[][] matrixTwo) throws MatrixSizeException {

        if (matrixOne.length != matrixTwo.length || matrixOne[0].length != matrixTwo[0].length)
           throw new MatrixSizeException();

        int[][] matrixOut = new int[matrixOne.length][matrixOne[0].length];

        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixOne[0].length; j++) {
                matrixOut[i][j] = matrixOne[i][j] + matrixTwo[i][j];
            }
        }

        return matrixOut;
    }

    public static int[][] subtraction(int[][] matrixOne, int[][] matrixTwo) throws MatrixSizeException {
        if (matrixOne.length != matrixTwo.length || matrixOne[0].length != matrixTwo[0].length)
            throw new MatrixSizeException();

        int[][] matrixOut = new int[matrixOne.length][matrixOne[0].length];

        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixOne[0].length; j++) {
                matrixOut[i][j] = matrixOne[i][j] - matrixTwo[i][j];
            }
        }

        return matrixOut;
    }

    public static int[][] scalar(int[][] matrixOne, int scale) throws MatrixSizeException {

        int[][] matrixOut = new int[matrixOne.length][matrixOne[0].length];

        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixOne[0].length; j++) {
                matrixOut[i][j] = matrixOne[i][j] * scale;
            }
        }

        return matrixOut;
    }

    public static int[][] multiplication(int[][] matrixOne, int[][] matrixTwo) throws MatrixSizeException {
        if (matrixOne[0].length != matrixTwo.length)
            throw new MatrixSizeException();

        int[][] matrixOut = new int[matrixOne.length][matrixTwo[0].length];

        //Foreach position in matrixOut
        for (int i = 0; i < matrixOut.length; i++) {
            for (int j = 0; j < matrixOut[0].length; j++) {
                for (int k = 0; k < matrixOne[0].length; k++) {
                    matrixOut[i][j] = matrixOut[i][j] + matrixOne[i][k] * matrixTwo[k][j];
                }
            }
        }

        return matrixOut;
    }
}

