package com.cxin.leetcodetest.nowCoderSolution;

import java.util.Scanner;

/**
 * 向⼀个空栈压⼊正整数，每当压⼊⼀个整数时，执⾏以下规则(设: 栈顶⾄栈底整数依次编号为n1、n2...nx， n1为最新压⼊的整数)
 * 1.如果n1=n2，则n1、n2全部出栈，压⼊新数据m(m=2*n1)
 * 2.如果n1=n2+...+ny(y的范围为[3,x]) ，则n1、n2...ny全部出栈，压⼊新数据m(m=2*n1)。
 * 3.如果上述规则都不满⾜，则不做操作
 * 如: 依次向栈压⼊6、1、2、3，当压⼊2时，栈顶⾄栈底依次为[2、1.6];当压⼊3时，3=2+1，3、2、1全部出栈，重新⼊栈整数6，此时栈顶⾄栈底
 * [6、6]; 6=6，两个6全部出栈，压⼊12，最终栈中只剩个元素12。
 * 向栈中输⼊⼀串数字，请输出应⽤此规则后栈中最终存留的数字。
 * 输⼊描述: 使⽤单个空格隔开的正整数的 字符串 ，如”5 6 7 8″， 左边的数字先⼊栈，输⼊的正整数个数为 x， 1<=x<=1000。
 * 输出描述: 最终栈中存留的元素值，元素值使⽤空格隔开，如”8 7 6 5″， 栈顶数字在左边。 6 1 2 3
 * 示例 1 输⼊输出 示例仅供调试，后台判题数据⼀般不包含示例
 * 输⼊
 * 5 10 20 50 85 1
 * 输出
 * 1 170
 * 说明
 * 5+10+20+50=85， 输⼊ 85 时， 5、 10、 20、 50、 85 全部出栈，⼊栈 170，最终依次出栈的数字为 1 和 170。
 * 示例2 输⼊输出示例仅供调试，后台判题数据⼀般不包含示例
 * 输⼊
 * 6 7 8 13 9
 * 输出
 * 9 13 8 7 6
 * 示例3 输⼊输出示例仅供调试，后台判题数据⼀般不包含示例
 * 输⼊
 * 1 2 5 7 9 1 2 2
 * 输出
 * 4 1 9 14 1
 * 输⼊
 * 1 2 5 7 9 1 4 2 2
 * 输出
 * 8 1 9 14 1
 */
public class HJE02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] s = input.split(" ");
        int[] stack = new int[s.length];
        int top = 0;//栈顶
        for (int i = 0; i < s.length; i++) {
            //入栈
            int cur = Integer.parseInt(s[i]);
            top = pushIntoStack(stack, top, cur);
        }
        for(int k = top-1;k >= 0;k--){
            System.out.print(stack[k]+" ");
        }
    }

    private static int pushIntoStack(int[] stack, int top, int cur) {
        stack[top++] = cur;//!! Integer.parseInt
        int j = top - 2;
        int sum = 0;
        while (j >= 0 && sum < cur) {
            sum += stack[j];
            if (sum == cur) {
                top = j;
                top = pushIntoStack(stack,top,2 * cur);
                break;
            } else {
                j--;
            }
        }
        return top;
    }
}
