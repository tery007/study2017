package org.litespring.beans.factory.config;

import java.util.Stack;

/**
 * @author wanglei
 * @description
 * @date Created on 2019/1/31
 **/
public class Solution {

    /**
     * 给定int数组和目标值，返回数组中符合的两个数字相加等于目标值的下标
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        if (length == 0) {
            throw new IllegalArgumentException("numbers is null");
        }
        int[] indexes = new int[2];
        for (int i = 0; i <length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    indexes[0]=i;
                    indexes[1]=j;
                    return indexes;
                }
            }
        }
        return indexes;
    }


    /**
     * 两个数相加，用二进制位运算实现
     * @param num1
     * @param num2
     * @return
     */
    public static int aplusb(int num1, int num2) {
        //个位数相加，不考虑进位的值
        int sum = num1 ^ num2;
        //个位数相加，获取进位的值
        int carry = (num1 & num2) << 1;
        //如果进位值不为0，重复上面的步骤
        while (carry != 0) {
            int a = sum;
            int b = carry;
            sum = a ^ b;
            carry = (a & b) << 1;
        }
        System.out.println(sum);
        return sum;
    }

    /**
     * 两个数相减
     * num1: 减数
     * num2: 被减数
     */
    int substract(int num1, int num2){
        // 先求减数的补码（取反加一）
        int subtractor = aplusb(~num2, 1);
        // aplusb()即上述加法运算
        int result = aplusb(num1, subtractor);
        return result ;
    }

    /**
     * 给定一个包含n个小写字母的字符串s，要求将字符串划分成若干个连续子串，子串中的字母类型相同，同时子串的字母个数不超过k，输出最少划分的子串数量。
     * 【例】给定 s = "aabbbc", k = 2, 返回4
     * 【解释】
     * 划分成 "aa", "bb", "b", "c" 四个子串
     * @param s
     * @param k
     * @return
     */
    public static int getAns(String s, int k) {
        // Write your code here
        Stack<Character> stack=new Stack();
        int result = 0;
        for(int i=0;i<s.length();){
            Character current=s.charAt(i);
            if(stack.size()>0) {
                if (stack.size()>=k || !stack.peek().equals(current)) {
                    stack.clear();
                    result++;
                    continue;
                }
            }
            stack.push(current);
             i++;
        }
        return result+1;

    }


    public static void main(String[] args) {
//        int[] numbers = new int[]{15, 2, 7, 11};
//        twoSum(numbers, 9);
//        aplusb(513, 529);
        getAns("bbbcabcab", 2);
        
    }
}
