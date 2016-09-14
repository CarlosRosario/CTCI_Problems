package com.carlos;

import java.util.*;

public class Main {

    // Given two strings, write a method to decide if one is a permutation of the other

    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = "cab";
        System.out.println(areStringsPermutationsOfEachOther2(s1, s2));


        //generatePermutations2("", s1);
    }

    // This solution uses a hashmap to keep a total frequency of characters in both strings. If all frequencies are even then the two strings are permutations.
    public static boolean areStringsPermutationsOfEachOther(String s1, String s2){

        Map<Character, Integer> frequencyMap = new HashMap<>();

        if(s1.length() != s2.length()){
            return false;
        }

        if(s1 == s2){
            return true;
        }

        for(int i = 0; i < s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if(frequencyMap.containsKey(c1)){
                frequencyMap.put(c1, frequencyMap.get(c1) + 1);
            }
            else {
                frequencyMap.put(c1, 1);
            }

            if(frequencyMap.containsKey(c2)){
                frequencyMap.put(c2, frequencyMap.get(c2) + 1);
            }
            else {
                frequencyMap.put(c2, 1);
            }
        }

        for (int frequency : frequencyMap.values()){

        }

        return true;
    }

    public static boolean areStringsPermutationsOfEachOther2(String s1, String s2){

        if(s1.length() != s2.length()){
            return false;
        }

        if(s1 == s2){
            return true;
        }

        s1 = sortString(s1);
        s2 = sortString(s2);

        if(s1.equals(s2)){
            return true;
        }
        else {
            return false;
        }
    }



    public static String sortString(String s){
        char [] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }





    // This will generate permutations of a string but, does not take duplicate characters into account.
    public static void generatePermutations(String prefix, String str){
        if(str.length() == 0){
            System.out.println(prefix); // Use a hashset here if concerned about duplicates. Then iterate through the set at the end to print out permutations.
        }
        else {
            for(int i = 0; i < str.length(); i++){
                generatePermutations(prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1));
            }
        }
    }


    // This will generate permutations of a string and takes duplicate characters into account.
    public static void generatePermutations2(String prefix, String str){
        Set<Character> charactersEncountered = new HashSet<>();

        if(str.length() == 0){
            System.out.println(prefix); // Use a hashset here if concerned about duplicates. Then iterate through the set at the end to print out permutations.
        }
        else {
            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                if(charactersEncountered.contains(ch)){
                    continue;
                }
                else {
                    charactersEncountered.add(ch);
                    generatePermutations2(prefix + ch, str.substring(0,i) + str.substring(i+1));
                }
            }
        }
    }

}
