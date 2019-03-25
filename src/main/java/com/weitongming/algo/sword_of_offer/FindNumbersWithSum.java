package com.weitongming.algo.sword_of_offer;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author tim.wei
 * @description
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 解法：
    数列满足递增，设两个头尾两个指针i和j，
    若ai + aj == sum，就是答案（相差越远乘积越小）
    若ai + aj > sum，aj肯定不是答案之一（前面已得出 i 前面的数已是不可能），j -= 1
    若ai + aj < sum，ai肯定不是答案之一（前面已得出 j 后面的数已是不可能），i += 1
O(n)
 * @date Created on 2019/3/21.
 */
public class FindNumbersWithSum {

    @Test
    public void test1(){
        int [] array  = {1,2,3,4,5,6,7,8,9,10,11,12,14,23,56};
        System.out.println(FindNumbersWithSum(array ,15));
    }


    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int min = 0 ;
        int max = array.length - 1;
        ArrayList<Integer> res = new ArrayList<>(2);
        while(min < max){
            int value1 = array[min] ;
            int value2 = array[max] ;
            int result = value1 + value2 ;
            if (result > sum){
                max --;
            }
            else if (result == sum){
                res.add(value1 );
                res.add(value2);
                //第一个等于的就是乘积最小的
                return res;
            }
            else {
                min ++ ;
            }
        }
        return res;
    }
}
