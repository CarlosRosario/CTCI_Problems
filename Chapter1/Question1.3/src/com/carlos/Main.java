package com.carlos;

public class Main {

    public static void main(String[] args) {

        String testString = "Say No  ";
        URLify2(testString, 6);

    }

    public static void URLify(String s, int trueLength){

        char[] chars = s.toCharArray();
        int numberOfSpaces = 0;
        int endOfString = trueLength - 1;

        for(int i = 0; i < endOfString; i++){
            if(chars[i] == ' '){
                numberOfSpaces++;
            }
        }

        int numberOfWords = numberOfSpaces + 1;
        int nthWord = numberOfWords;
        int nthSpace = numberOfSpaces;

        for(int i = endOfString; i >= 0; i--){
            if(chars[i] != ' '){
                int scootFactor = numberOfSpaces * (nthWord - 1);
                if(numberOfSpaces == 1 && nthWord != 1) {
                    scootFactor++;
                }
                int scootedIndex = i + scootFactor;
                chars[scootedIndex] = chars[i];
            }
            else {
                int scootedIndex = i + (numberOfSpaces * (nthSpace - 1));
                chars[scootedIndex] = '%';
                chars[scootedIndex+1] = '2';
                chars[scootedIndex+2] = '0';
                nthWord--;
                nthSpace--;
            }
        }
        System.out.println(new String(chars));
    }

    public static void URLify2(String s, int trueLength){

        char[] chars = s.toCharArray();
        int numberOfSpaces = 0;
        int endOfString = trueLength - 1;

        for(int i = 0; i < endOfString; i++){
            if(chars[i] == ' '){
                numberOfSpaces++;
            }
        }

        int endOfURLifiedString = trueLength + numberOfSpaces * 2 - 1;
        System.out.println(endOfURLifiedString);
        for(int i = endOfString; i >= 0; i--){
            if(chars[i] != ' '){
                chars[endOfURLifiedString] = chars[i];
                endOfURLifiedString--;
            }
            else {
                chars[endOfURLifiedString] = '0';
                chars[endOfURLifiedString - 1] = '2';
                chars[endOfURLifiedString - 2] = '%';
                endOfURLifiedString = endOfURLifiedString -3;

            }
        }
        System.out.println(new String(chars));
    }
}
