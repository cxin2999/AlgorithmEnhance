package com.cxin.leetcodetest.nowCoderSolution;


import java.util.Scanner;

public class HJE03Ex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        replaceStr(in.nextLine().toCharArray());

    }

    public static void replaceStr(char[] str) {

        int count = 0;
        String result = "";
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '[') {
                count++;
            } else if (str[i] == ']') {
                count--;
            }
            //使用count来判断是否在方括号内部
            if (count == 0) {
                if (str[i] == '_' && (i == 0 || str[i - 1] != '\\')) {
                    result += "(^|$|[,+])";
                } else {
                    result += str[i];
                }
            } else {
                result += str[i];
            }
        }
        System.out.println(result);

    }

}