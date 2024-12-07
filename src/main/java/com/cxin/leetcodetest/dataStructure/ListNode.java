package com.cxin.leetcodetest.dataStructure;



public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode initByArray(int[] nums) {
        if(nums.length >0){
            ListNode nextNode = new ListNode(nums[nums.length - 1]);
            for (int i = nums.length -2; i >=0; i--) {
                ListNode cur = new ListNode(nums[i]);
                cur.setNext(nextNode);
                nextNode = cur;
            }
            return nextNode;
        }else {
            return null;
        }
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public static String toString(ListNode l) {
        if(l != null){
            int val = l.getVal();
            String res = "(" + val + ")";
            while (l.next != null){
                int nextVal = l.next.getVal();
                res += "->" + "(" + nextVal + ")";
                l = l.next;
            }
            return res;
        }else {
            return "";
        }
    }

    public static void main(String[] args) {
        int[] nums2 = new int[]{9,9,9,9,9,9,9};
        int[] nums1 = new int[]{9,9,9,9};
//        int[] nums2 = new int[]{1,1,1,1,1};
//        int[] nums1 = new int[]{1,1};
        ListNode l1 = initByArray(nums1);
        ListNode l2 = initByArray(nums2);
        System.out.println(toString(l1));
        System.out.println(toString(l2));
        ListNode result = l1;
        ListNode l1_front = null;
        while(l1 != null && l2 !=null){
            setListNodeVal(l1.val+l2.val,l1);
            l1_front = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null && l2 != null){
            l1_front.next = l2;
        }

        System.out.println(toString(result));
    }

    public static void setListNodeVal(int sum,ListNode l){
        int v = sum%10;
        int mul = sum/10;
        l.val = v;
        if(mul >0){
            if(l.next != null){
                setListNodeVal(mul + l.next.val,l.next);
            }else {
                l.next = new ListNode(mul);
            }
        }
    }
}
