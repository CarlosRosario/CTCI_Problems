package com.carlos;

public class Main {

    public static void main(String[] args) {

        char[][] image = new char[][] {
                {'a','b','c','d', 'A'},
                {'e','f','g','h', 'B'},
                {'i','j','k','l', 'C'},
                {'m','n','o','p', 'D'},
                {'E','F','G','H', 'Z'}
        };

        rotate(image);
    }

    public static void rotate(char[][] matrix) {

        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        if(rowLength != columnLength || rowLength < 2){
            return;
        }

        for(int outerLayer = 0; outerLayer < rowLength/2; outerLayer++){

            int indexLimit = rowLength - 1 - outerLayer;

            for(int i = outerLayer; i < indexLimit; i++){
                char right = matrix[i][indexLimit];
                int offset = i - outerLayer;
                // top -> right
                matrix[i][indexLimit] = matrix[outerLayer][i];

                // left -> top
                matrix[outerLayer][i] = matrix[indexLimit - offset][outerLayer];

                // bottom -> left
                matrix[indexLimit - offset][outerLayer] = matrix[indexLimit][indexLimit - offset];

                // right -> bottom
                matrix[indexLimit][indexLimit - offset] = right;
            }
        }

        // print out matrix
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < columnLength; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
