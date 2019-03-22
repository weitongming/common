package com.weitongming.algo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author tim.wei
 * @descriptionLL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 * LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 * @date Created on 2019/3/21.
 */
public class IsContinuous {




    @Test
    public void testNormal(){

//        System.out.println(isContinuous(new int[]{1, 2, 3, 4, 5}));
//        System.out.println(isContinuous(new int[]{1, 2, 3, 4, 0}));
//        System.out.println(isContinuous(new int[]{1, 2, 0, 4, 5}));
//        System.out.println(isContinuous(new int[]{1, 2, 0, 4, 5}));
//        System.out.println(isContinuous(new int[]{1,3,2,6,4}));
        System.out.println(isContinuous(new int[]{0,3,2,6,4}));
    }


    //自己解法 ，癞子算法
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length != 5){
            return false ;
        }
        Arrays.sort(numbers);
        int numOf0  = getNumOf0(numbers);
        int numOf0Origin = numOf0 ;
        for (int i = 0; i < numbers.length - 1; i++) {
            int valueLeft = numbers[i];
            int valueRight = numbers[i+1];
            if (valueLeft == 0){
                continue ;
            }
            int gap =  valueRight - valueLeft;
            if (gap == 0){
                return false;
            }
            if (gap == 1){
            }
            else if ( gap >= 2  && numOf0 > 0){
                numOf0 -= (gap -1 ) ;
            }
            else {
                return false;
            }
        }
        if (numOf0Origin > 0 ) {
            return numOf0 >= 0;
        }
        else return true;
    }

    @Test
    public void testNormal2(){

//        System.out.println(isContinuous(new int[]{1, 2, 3, 4, 5}));
//        System.out.println(isContinuous(new int[]{1, 2, 3, 4, 0}));
//        System.out.println(isContinuous(new int[]{1, 2, 0, 4, 5}));
//        System.out.println(isContinuous(new int[]{1, 2, 0, 4, 5}));
//        System.out.println(isContinuous(new int[]{1,3,2,6,4}));
        System.out.println(isContinuous2(new int[]{2,3,3,6,4}));
    }
    /**
     大神算法
     max 记录 最大值
     min 记录  最小值
     min ,max 都不记0
     满足条件 1 max - min <5
     2 除0外没有重复的数字(牌)
     3 数组长度 为5
     根据或运算以及与运算的特点计算出是否出现重复数字
     * @param numbers
     * @return
     */
    public boolean isContinuous2(int [] numbers) {
        if(numbers.length != 5) return false;
        int min = 14;
        int max = -1;
        int flag = 0;
        for (int number : numbers) {
            if (number < 0 || number > 13) return false;
            if (number == 0) continue;
            if (((flag >> number) & 1) == 1)
                return false;
            flag |= (1 << number);
            if (number > max) max = number;
            if (number < min) min = number;
            if (max - min >= 5) return false;
        }
        return true;
    }


    private int getNumOf0(int[] array){
        int count = 0 ;
        for (int current: array ) {
            if (current == 0){
                count ++ ;
            }
        }
        return count ;
    }

}
