package com.cxin.leetcodetest.nowCoderSolution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 流浪地球计划在⾚道上均匀部署了N个转向发动机，按位置顺序编号为0~N-1。
 * 1） 初始状态下所有的发动机都是未启动状态；
 * 2） 发动机起动的⽅式分为“⼿动启动”和“关联启动”两种⽅式；
 * 3） 如果在时刻1⼀个发动机被启动，下⼀个时刻2与之相邻的两个发动机就会被“关联启动”；
 * 4） 如果准备启动某个发动机时，它已经被启动了，则什么都不⽤做；
 * 5） 发动机0与发动机N-1是相邻；
 * 地球联合政府准备挑选某些发动机在某些时刻进⾏“⼿动启动”，当然最终所有的发动机都会被启动。
 * 哪些发动机最晚被启动呢？
 * 输⼊描述：
 * 第⼀⾏两个数字N和E，中间有空格
 * N代表部署发动机的总个数，E代表计划⼿动启动的发动机总个数
 * 1<N<=1000，1<=E<=1000,E<=N
 * 接下来共E⾏，每⾏都是两个数字T和P，中间有空格
 * T代表发动机的⼿动启动时刻，P代表此发动机的位置编号。
 * 0<=T<=N,0<=P<=N
 * 输出描述：
 * 第⼀⾏⼀个数字N，以回⻋结束
 * N代表最后被启动的发动机个数
 * 第⼆⾏N个数字，中间有空格，以回⻋结束
 * 每个数字代表发动机的位置编号， 从⼩到⼤排序
 * 示例1：
 * 输⼊：
 * 8 2
 * 0 2
 * 0 6
 * 输出：
 * 2
 * 0 4
 * 说明：
 * 8个发动机，时刻0启动2和6号发动机
 * 示例2：
 * 输⼊：
 * 8 2
 * 0 0
 * 1 7
 * 输出：
 * 1
 * 4
 */
public class HJE01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ne = in.nextLine();
        String[] s = ne.split(" ");
        int n = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);
        int[] x = new int[n];
        Arrays.fill(x, -1);//数组值全部设置为 -1
        for (int i = 0; i < e; i++) {
            String tp = in.nextLine();
            String[] s2 = tp.split(" ");
            int t = Integer.parseInt(s2[0]);
            int p = Integer.parseInt(s2[1]);
            execute(x, t, p, n);
        }
        int maxT = 0;
        String maxTStr = "";
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i]);
            if (x[i] > maxT) {
                maxTStr = "";
                maxT = x[i];
                maxTStr += i + " ";
            } else if (x[i] == maxT) {
                maxTStr += i + " ";
            }
        }
        int length = maxTStr.replace(" ", "").length();
        System.out.println(length);
        System.out.println(maxTStr.substring(0, maxTStr.length() - 1));// 0 到 lenght-1 表示去掉最后一个字符

    }

    public static int[] execute(int[] x, int t, int p, int n) {//点火操作
        int max = n / 2 + 1;
        for (int i = 0; i < max; i++) {
            if (x[(p + i) % n] == -1 || x[(p + i) % n] > t) {
                x[(p + i) % n] = t;
            }
            if (x[(p - i + n) % n] == -1 || x[(p - i + n) % n] > t) {
                x[(p - i + n) % n] = t;
            }
            t++;
        }
        return x;
    }
}
