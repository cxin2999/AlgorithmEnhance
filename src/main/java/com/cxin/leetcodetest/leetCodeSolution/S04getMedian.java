package com.cxin.leetcodetest.leetCodeSolution;

public class S04getMedian {
    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 0, 0, 0, 0};
        int[] nums2 = new int[]{-1, 0, 0, 0, 0, 0, 1};
        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println("res = " + res);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int maxLength = totalLength / 2 + 1;
        int[] targetNums = new int[maxLength];
        int i = 0;
        int j = 0;
        double res = 0;
        int targetNumsIndex = 0;
        while (i < nums1.length && j < nums2.length && maxLength > targetNumsIndex) {
            if (nums1[i] < nums2[j]) {
                targetNums[targetNumsIndex++] = nums1[i];
                i++;
            } else {
                targetNums[targetNumsIndex++] = nums2[j];
                j++;
            }
        }
        if (maxLength > targetNumsIndex) {
            if (i == nums1.length) {
                while (maxLength > targetNumsIndex) {
                    targetNums[targetNumsIndex++] = nums2[j];
                    j++;
                }
            } else if (j == nums2.length) {
                while (maxLength > targetNumsIndex) {
                    targetNums[targetNumsIndex++] = nums1[i];
                    i++;
                }
            }
        }
        if (totalLength % 2 > 0) {//奇数个 用单个数得到中位数
            res = targetNums[totalLength / 2];
        } else {//偶数个用 两个数得到中位数
            res = (double) (targetNums[maxLength - 2] + targetNums[maxLength - 1]) / 2;
        }
        return res;
    }
}
