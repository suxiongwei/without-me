package com.sxw.learn.test;

import com.google.common.base.Joiner;

import java.util.*;

public class Test {
    // crcoakroak
    public static int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs == null || croakOfFrogs.length() == 0 || !croakOfFrogs.startsWith("c")) return -1;
        int ans = 0;
        while (!croakOfFrogs.equals("") && croakOfFrogs.contains("croak")) {
            ans++;
            croakOfFrogs = croakOfFrogs.replaceAll("croak", "");
        }
        if (!croakOfFrogs.equals("")) {
            return -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next();
//        System.out.println("hello world");
//        System.out.println(getNum("gwwanang"));
    }

}
