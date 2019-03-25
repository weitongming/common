package com.weitongming.algo.sword_of_offer;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author tim.wei
 * @description
 *
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * @date Created on 2019/3/19.
 *
 *
 * 双指针技术，就是相当于有一个窗口，窗口的左右两边就是两个指针，
 * 我们根据窗口内值之和来确定窗口的位置和宽度。非常牛逼的思路，
 * 虽然双指针或者所谓的滑动窗口技巧还是蛮常见的，但是这一题还真想不到这个思路。
 */
public class FindContinuousSequence {


    @Test
    public void testSum(){
        FindContinuousSequence(100);
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(sum / 5) ;
        int low  = 1 , hight  = 2 ;
        while(low < hight){
            int value = getSumOfArea(low ,hight);
            if (value  < sum){
                hight += 1;

            }
            else if (value  > sum){
                low += 1;
            }
            else if (value  == sum){
                ArrayList<Integer> answer = new ArrayList<>(hight - low);
                for (int j = low; j <= hight; j++) {
                    answer.add(j);
                }
                result.add(answer);
                low += 1;
            }

        }
        System.out.println(result.toString() );
        return result ;
    }

    private int getSumOfArea(int low ,int hight ){
        int result =   (low + hight) * (hight -low +1 ) / 2 ;
        return result ;
    }
}
