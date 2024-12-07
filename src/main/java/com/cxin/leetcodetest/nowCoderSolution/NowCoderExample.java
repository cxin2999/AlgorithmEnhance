package com.cxin.leetcodetest.nowCoderSolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class NowCoderExample {
    //    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }
//    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            set.add(num);
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        list.sort((a, b) -> a - b);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
