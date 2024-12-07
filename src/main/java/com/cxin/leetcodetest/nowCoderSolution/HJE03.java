package com.cxin.leetcodetest.nowCoderSolution;

import java.util.Scanner;

/**
 * 为了便于业务交互，约定⼀个对输⼊的字符串中的下划线做统⼀替换
 * 具体要求L对于给定的 输⼊字符串 ，将其中包含的每⼀个下划线"_"，使⽤特殊字符串"(^|$|[,+])"替换，并输出替换后的结果
 * 其中的例外场景不做替换，场景如下：
 * 1.在⼀堆⽅括号之内的下划线则不替换
 * 2.为转义的下划线，即"\_"则不替换
 * 备注：
 * 1.调⽤者已经保证，输⼊ 表达式 的⽅括号会成对出现，并且⽅括号会存在嵌套。即存在"[xx[yyyy]xxx]"这种形式的字符串
 * 2.输⼊字符串的⻓度范围：[0, 10000]
 * 示例1
 * 输⼊
 * "^(_9494)"
 * 输出
 * "^((^|$|[,+])9494)"
 * <p>
 * <p>
 * <p>
 * <p>
 * [xx[yyyy]xxx]
 * 1112222211110
 */
public class HJE03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            char[] input = in.nextLine().toCharArray();
            StringBuilder output = new StringBuilder();
            int count = 0;
            for (int i = 0; i < input.length; i++) {
                char c = input[i];
                if (c == '[') count++;
                if (c == ']') count--;
                if (count == 0 && c == '_' && (i == 0 || input[i - 1] != '\\')) {//count == 0 不在括号内
                    output.append("(^|$|[,+])");
                } else {
                    output.append(c);
                }
            }
            System.out.println(output);

        }
    }
}
