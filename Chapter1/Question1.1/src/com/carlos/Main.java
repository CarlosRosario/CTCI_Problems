package com.carlos;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String testString = "The quick brown fox jumped over the lazy dog";
        System.out.println(hasAllUniqueCharactersV2(testString));


        testString = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(hasAllUniqueCharactersV2(testString));

        testString = "asdkfja;sdkj230950925//adskfjas]j]]werk;laxxcmmcmcmmci3838383929348";
        System.out.println(hasAllUniqueCharactersV2(testString));


    }

    // This uses an additional data structure.
    public static boolean hasAllUniqueCharactersV1(String s){

        Set<Character> uniqueCharactersSet = new HashSet<Character>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(uniqueCharactersSet.contains(c)){
                return false;
            }
            else {
                uniqueCharactersSet.add(c);
            }
        }

        return true;
    }

    // This does not use an additional data structure
    public static boolean hasAllUniqueCharactersV2(String s){

        int a = 0;
        int b = a + 1;

        while(a < s.length()){

            if(b >= s.length()){
                a++;
                b = a + 1;
            }

            if(a >= s.length()  - 1) {
                return true;
            }

            if (s.charAt(a) == s.charAt(b)){
                return false;
            }
            b++;
        }
        return true;
    }
}
