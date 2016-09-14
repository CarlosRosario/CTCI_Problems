package com.carlos;

public class Main {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1, 2, 0},
                {4,5,6},
                {3,0,1},
                {2,9,9}
        };

        //zeroify(matrix);
        zeroify2(matrix);
    }

    // Uses O(n^2) space..
    public static void zeroify(int[][] matrix){
        boolean[] zeroRow = new boolean[matrix.length];
        boolean[] zeroCol = new boolean[matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0) {
                    zeroRow[i] = true;
                    zeroCol[j] = true;
                }
            }
        }

        for(int i = 0; i < zeroRow.length; i++){
            if (zeroRow[i] == true){
                for(int j = 0; j < matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < zeroCol.length; i++){
            if(zeroCol[i] == true){
                for(int j = 0; j < matrix.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }
        printMatrix(matrix);
    }

    // Uses O(1) space
    public static void zeroify2(int[][] matrix){
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // Check if first row has a zero
        for(int j = 0; j < matrix.length; j++){
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // Check if first col has a zero
        for(int i = 0; i < matrix[0].length; i++){
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // nullify rows
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        // nullify columns
        for(int j = 0; j < matrix[0].length; j++){
            if(matrix[0][j] == 0){
                for(int i = 1; i < matrix.length; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        // nullify first row if necessary
        if(firstRowHasZero){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }

        // nullify first column if necessary
        if(firstColHasZero){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }

        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
