package com.cxin.leetcodetest.nowCoderSolution;

import java.util.Scanner;

/**
 * 题⽬描述
 * 求出⼤于或等于 N 的最⼩ 回⽂素数 。
 * 回顾⼀下，如果⼀个数⼤于 1，且其因数只有 1 和它⾃身，那么这个数是素数。
 * 例如，2，3，5，7，11 以及 13 是素数。
 * 回顾⼀下，如果⼀个数从左往⽯读与从右往左读是⼀样的，那么这个数是 回⽂数Q例如，12321 是回⽂数。
 * 示例 1:
 * 输⼊:6
 * 输出:7
 * 示例 2:
 * 输⼊:8
 * 输出:11
 */
public class HJE04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int input = in.nextInt();
            while (!isSymmetrical(input) || !isPrimeNum(input)) {
                input++;
            }
            System.out.println(input);
        }
    }

    /**
     * v1.0
     * 判断是否是素数
     * @param num
     * @return
     *
     * 两种情况
     * 1. 2是素数
     * 2. 2 <= i < num 循环 num%i ==0 余数=0证明除净了，不是素数
     */
//    public static boolean isPrimeNum(int num){
//        boolean res = true;
//        if(num ==2) return true;
//        for (int i = 2; i < num; i++) {
//            if(num % i == 0){//取余，余数=0证明除净了，不是素数
//                return false;
//            }
//        }
//        return res;
//    }

    /**
     * v1.2
     *
     * @param num
     * @return 1. <=1都不是素数
     * 2. 检查2 到 √num（如果一个因子大于√num，那另一个因子一定小于√num）
     */
    public static boolean isPrimeNum(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {//取余，余数=0证明除净了，不是素数
                return false;
            }
        }
        return true;
    }

    //TODO 寻找下一个回文数
    public static boolean isSymmetrical(int num) {
        if (num > 0 && num < 10) {
            return true;
        } else {
            char[] chars = String.valueOf(num).toCharArray();
            int i = 0;
            int j = chars.length - 1;
            while (i <= j) {
                if (chars[i] != chars[j]) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }

}
