package com.weitongming.algo;

import org.junit.Test;

/**
 * @author tim.wei
 * @description 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。

    这个题目的突破口在哪里？题目为什么要强调有一个数字出现一次，其他的出现两次？我们想到了异或运算的性质：
    任何一个数字异或它自己都等于0 。也就是说，如果我们从头到尾依次异或数组中的每一个数字，那么最终的结果刚好是那个只出现一次的数字，因为那些出现两次的数字全部在异或中抵消掉了。
    有了上面简单问题的解决方案之后，我们回到原始的问题。如果能够把原数组分为两个子数组。在每个子数组中，包含一个只出现一次的数字，而其它数字都出现两次。如果能够这样拆分原数组，按照前面的办法就是分别求出这两个只出现一次的数字了。
    我们还是从头到尾依次异或数组中的每一个数字，那么最终得到的结果就是两个只出现一次的数字的异或结果。因为其它数字都出现了两次，在异或中全部抵消掉了。由于这两个数字肯定不一样，那么这个异或结果肯定不为0 ，也就是说在这个结果数字的二进制表示中至少就有一位为1 。我们在结果数字中找到第一个为1 的位的位置，记为第N 位。现在我们以第N 位是不是1 为标准把原数组中的数字分成两个子数组，第一个子数组中每个数字的第N 位都为1 ，而第二个子数组的每个数字的第N 位都为0 。
    现在我们已经把原数组分成了两个子数组，每个子数组都包含一个只出现一次的数字，而其它数字都出现了两次。因此到此为止，所有的问题我们都已经解决
 * @date Created on 2019/3/19.
 */
public class FindNumsAppearOnce {


    private static int [] array = {1,3,5,7,2,4,6,8 ,3,5,7,2,4,6};



    @Test
    public void test(){
        int [] num1 = {0} ;
        int [] num2 = {0} ;
        findNumsAppearOnce(array ,num1 ,num2);
    }

    private static void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int result = 0 ;
        for (int a : array) {
            result = result ^ a ;
        }
        int index = getIndexOf1(result);
        for (int a : array) {
            if (isBit1(a ,index)){
                num1[0] ^= a;
            }
            else {
                num2[0] ^= a;
            }
        }
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }


    private static int getIndexOf1(int value ){
        int index = 0 ;
        while(value >= 1 ){
            if ((value & 1) == 1){
                return index;
            }
            index ++ ;
            value >>= 1;
        }
        return 0 ;
    }

    private static boolean isBit1(int value ,int index){
        return (value >> index & 1) == 1 ;
    }

    @Test
    public void testIsBit1() {
        System.out.println(isBit1(8 ,4));
        System.out.println(isBit1(8 ,4));
        System.out.println(isBit1(8 ,4));
    }

    @Test
    public void xor(){
        System.out.println(7 ^ 7);
        System.out.println(0b0111 ^ 0b0111);
        System.out.println(7 ^ 8);
        System.out.println(0b0111 ^ 0b1000);
    }


}
