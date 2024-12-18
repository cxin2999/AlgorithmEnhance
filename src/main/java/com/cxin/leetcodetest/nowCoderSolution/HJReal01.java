package com.cxin.leetcodetest.nowCoderSolution;

import java.util.Scanner;

/**
 * 给定字符串target和source，判断target是否为source的子序列。你可以认为target和source 中仅包含英文小写字母，字符串source可能会很长，
 * 长度~=500,000，而target是个短字符串，长度<=100。字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置
 * 形成的新字符串，例如，'abc’是’aebycd’的一个子序列，而’ayb’不是。请找出最后一个序列的起始位置。
 * 示例1
 * 输入：
 * abc
 * eadbc
 * 输出：
 * 1
 * 示例2
 * 输入：
 * abc
 * abcaybec
 * 输出：
 * 3
 * 说明：abcaybec中第0位的abc也匹配，但却不是最后匹配的序列。abcaybec中第3位的aybec去掉字符y、e后也为abc，也与目标字符串相符，故输出最后一个序列aybec的第一个字符的索引位置3。
 */
public class HJReal01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String target = in.nextLine();
            String source = in.nextLine();
            int i = target.length() - 1;
            int j = source.length() - 1;
            while (i >= 0 && j >= 0) {
                if (target.charAt(i) == source.charAt(j)) {
                    i--;
                }
                j--;
            }
            if (i < 0) {
                System.out.println(j + 1);
            } else {
                System.out.println("Its not inStr");
            }
        }
    }
}
