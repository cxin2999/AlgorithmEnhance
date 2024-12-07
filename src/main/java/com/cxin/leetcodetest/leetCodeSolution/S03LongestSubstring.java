package com.cxin.leetcodetest.leetCodeSolution;

import java.util.HashSet;

public class S03LongestSubstring {
    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("anviaj");
        System.out.println("i = " + i);
    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && !set.contains(s.charAt(j))) {//j < s.length()需要放前面
                set.add(s.charAt(j));
                j++;
            }
            max = Math.max(max, j - i);
            set.remove(s.charAt(i));
        }
        return max;
    }
}
