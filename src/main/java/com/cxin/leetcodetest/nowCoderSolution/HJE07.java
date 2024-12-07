package com.cxin.leetcodetest.nowCoderSolution;

import java.util.Scanner;

/**
 * 题⽬描述：
 * 存在⼀个m*n的 ⼆维数组 ，其成员取值范围为0,1,2。其中值为1的元素具备同化特性，每经过1S，将上下左右值为0的元素同化为1。⽽值为2的元素，
 * 免疫同化。
 * 将数组所有成员随机 初始化 为0或2，再将矩阵的[0,0]元素修改成1，在经过⾜够⻓的时间后，求矩阵中有多少个元素是0或2（即0和2数量之和）。
 * 输⼊描述：
 * 输⼊的前两个数字是矩阵⼤⼩。后⾯的数字是矩阵内容。
 * 输出描述：
 * 返回矩阵中⾮1的元素个数
 * 补充说明：
 * m和n不会超过30(含30)。
 * 示例1
 * 输⼊：
 * 输出：
 * 说明：输⼊数字前两个数字是矩阵⼤⼩。后⾯的是数字是矩阵内容。
 * 这个矩阵的内容如下：
 * {
 *  0,0,0,0
 *  0,2,2,2
 *  0,2,0,0
 *  0,2,0,0
 * }
 * 起始位置 (0,0)被修改为1后，最终只能同化矩阵为：
 * {
 *  1,1,1,1
 *  1,2,2,2
 *  1,2,0,0
 *  1,2,0,0
 * }
 * 所以矩阵中⾮1的元素个数为9。
 */

/**
 * 2024-12-08 01:20:03
 */
public class HJE07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int [][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = in.nextInt();
            }
        }
        map = same(map,0,0);
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] != 1){
                    count++;
                }
                System.out.print(map[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println(count);

    }

    public static int[][] same(int[][] map,int i,int j){
        int m = map.length;
        int n = map[0].length;
        map[i][j] = 1;
        if(i-1 >0 && map[i-1][j] == 0){//up
            map = same(map,i-1,j);
        }
        if(i+1 < m && map[i+1][j] == 0){
            map = same(map,i+1,j);
        }
        if(j-1 >0 && map[i][j-1] == 0){
            map = same(map,i,j-1);
        }
        if(j+1 < n && map[i][j+1] == 0){
            map = same(map,i,j+1);
        }
        return map;
    }
}
