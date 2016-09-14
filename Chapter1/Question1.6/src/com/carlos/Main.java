package com.carlos;

public class Main {



    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(compressString2(s));
    }

    // This will create the compressed String first, and then check if its length is less/greater than the original string
    public static String compressString(String s){
        StringBuilder compressedString = new StringBuilder();
        if(s.length() == 0) return "";

        char previous = s.charAt(0);
        int compressCount = 1;
        for(int i = 1; i < s.length(); i++){
            char ch = s.charAt(i);

            if (ch == previous){
                compressCount++;
            }
            else {
                compressedString.append(previous);
                compressedString.append(compressCount);
                compressCount = 1;
                previous = ch;
            }
        }
        compressedString.append(previous);
        compressedString.append(compressCount);
        return s.length() < compressedString.length() ? s : compressedString.toString();
    }

    // This will first check that the length of the compressed string is indeed less than the length of the original string before doing anything else.
    public static String compressString2(String s){

        int compressedStringLength = compressedStringLength(s);
        if(compressedStringLength >= s.length()) return s;


        StringBuilder compressedString = new StringBuilder();
        if(s.length() == 0) return "";

        char previous = s.charAt(0);
        int compressCount = 1;
        for(int i = 1; i < s.length(); i++){
            char ch = s.charAt(i);

            if (ch == previous){
                compressCount++;
            }
            else {
                compressedString.append(previous);
                compressedString.append(compressCount);
                compressCount = 1;
                previous = ch;
            }
        }
        compressedString.append(previous);
        compressedString.append(compressCount);
        return s.length() < compressedString.length() ? s : compressedString.toString();
    }

    public static int compressedStringLength(String s){
        int length = 0;
        int compressCount = 0;

        char previous = s.charAt(0);
        for(int i = 1; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == previous) {
                compressCount++;
            }
            else{
                length = 1 + String.valueOf(compressCount).length();
                previous = ch;
                compressCount = 1;
            }
        }

        return length;
    }

}
