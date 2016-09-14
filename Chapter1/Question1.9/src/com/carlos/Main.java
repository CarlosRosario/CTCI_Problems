package com.carlos;

public class Main {

    public static void main(String[] args) {

        String s1 = "erbottlewat";
        String s2 = "waterbottle";

        System.out.println(isRotation(s1, s2));


    }

    public static boolean isRotation(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        if(s1.equals(s2)){
            return true;
        }

        String s3 = s2 + s2;
        return s3.contains(s1);

    }
}
