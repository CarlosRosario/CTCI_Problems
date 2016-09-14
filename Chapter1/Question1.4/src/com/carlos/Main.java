package com.carlos;

import java.util.HashMap;
import java.util.Map;

public class Main {

    // Given a string, write a function to check if is a permutation of a palindrome.
    // A plandrome is a word or phrase that is the same forwards and backwards. A permutation is a
    // rearrangement of letters. The palindrome does not need to be limited to just dictionary words

    public static void main(String[] args) {
        String string = "hannah ";
        System.out.println(isPermutationOfPalindrome(string));
    }

    public static boolean isPermutationOfPalindrome(String s){
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int length = s.length();
        int spacecount = 0;

        for(int i = 0; i < length; i++){
            char ch = s.charAt(i);

            if(ch == ' '){
                spacecount++;
                continue;
            }

            if(frequencyMap.containsKey(ch)){
                frequencyMap.put(ch, frequencyMap.get(ch) + 1);
            }
            else {
                frequencyMap.put(ch, 1);
            }
        }

        int evenFrequencyCount = 0;
        for (Integer frequency: frequencyMap.values()){
            if(frequency %2 == 0){
                evenFrequencyCount += frequency;
            }
        }


        int notCoutingSpaceLength = length - spacecount;
        if(notCoutingSpaceLength %2 == 0 && evenFrequencyCount == notCoutingSpaceLength){
            return true;
        }
        else if(notCoutingSpaceLength %2 == 1 && evenFrequencyCount == notCoutingSpaceLength - 1){
            return true;
        }

        return false;
    }
}
