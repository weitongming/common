package com.weitongming.algo.sword_of_offer;

import org.junit.Test;

/**
 * @author tim.wei
 * @description汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * @date Created on 2019/3/21.
 */
public class LeftRotateString {


    @Test
    public void testNull(){
        LeftRotateString("" ,1);
    }

    @Test
    public void testNormal(){
        System.out.println(LeftRotateString("111222333" ,3));
        System.out.println(LeftRotateString("123444555" ,3));
    }


    public String LeftRotateString(String str,int n) {
        if (str==null || str.length() == 0){
            return "";
        }
        char[] array = str.toCharArray() ;

        StringBuilder sb = new StringBuilder() ;
        for (int i = n; i < array.length; i++) {
            sb.append(array[i]);
        }
        for (int i = 0; i < n; i++) {
            sb.append(array[i]);
        }
        return sb.toString();
    }
}
