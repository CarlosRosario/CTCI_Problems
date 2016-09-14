package com.carlos;

import java.util.HashMap;
import java.util.Map;

public class Main {

    // There are three types of edits that can be performed on strings:
    // insert a character, remove a character, or replace a character. Given two strings,
    // write a function to check if they are one/zero edits away.

    public static void main(String[] args) {

        String s1 = "ple";
        String s2 = "pale";

        System.out.println(isOneAwayV2(s1,s2));

    }

    // Uses additional data structure
    public static boolean isOneAway(String s1, String s2){

        if(s1.equals(s2)){
            return true;
        }

        int lengthDifference = Math.abs(s1.length() - s2.length());
        if(lengthDifference > 1){
            return false;
        }

        Map<Character, Integer> frequencyMap = new HashMap<>();

        addCharacterFrequenciesForThisString(s1, frequencyMap);
        addCharacterFrequenciesForThisString(s2, frequencyMap);

        int missingCharacterCount = 0;
        for(Integer frequency: frequencyMap.values()){
            if(frequency %2 == 1){
                missingCharacterCount++;
            }
        }

        if(lengthDifference == 1){
            if(missingCharacterCount <= 1) {
                return true;
            }
        }
        else {
            if(missingCharacterCount <= 2){
                return true;
            }
        }

        return false;
    }

    public static void addCharacterFrequenciesForThisString(String s, Map<Character, Integer> m){

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(m.containsKey(ch)){
                m.put(ch, m.get(ch) + 1);
            }
            else {
                m.put(ch, 1);
            }
        }
    }

    public static boolean isOneAwayV2(String s1, String s2){
        if(s1.equals(s2)){
            return true;
        }

        int lengthDifference = Math.abs(s1.length() - s2.length());
        if(lengthDifference > 1){
            return false;
        }

        //shorterString and longerString can actually be the same length. I should call them something else so it's not confusing.
        String shorterString = s1.length() < s2.length() ? s1: s2;
        String longerString = s1.length() < s2.length() ? s2: s1;

        int shortStringIndex = 0;
        int longStringIndex = 0;
        boolean foundDifference = false;


        while(shortStringIndex < shorterString.length() && longStringIndex < longerString.length()){

            if(shorterString.charAt(shortStringIndex) != longerString.charAt(longStringIndex)){
                if(foundDifference) return false; // if more than one difference we're done
                foundDifference = true;

                // If the strings are not the same length, then a replace is not enough. We will need an insert/delete.
                if(shorterString.length() == longerString.length()){
                    shortStringIndex++;
                }
            }
            else {
                // if characters matched, go ahead and increment the shorter string index
                shortStringIndex++;
            }

            longStringIndex++;
        }

        return true;
    }

}
