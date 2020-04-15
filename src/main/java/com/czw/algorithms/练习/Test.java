package com.czw.algorithms.练习;


import com.czw.algorithms.util.In;
import com.czw.algorithms.util.Test2;

import java.util.*;

/**
 * @Author: czw
 * @CreateTime: 2020-03-02 09:06
 * @UpdeteTime: 2020-03-02 09:06
 * @Description:
 */
public class Test {
	//public int coinChange(int[] coins, int amount){
	//	if (amount<1)
	//		return 0;
	//	return coinChange(coins,amount,new int[amount]);
	//}
	//private int coinChange(int[] coins,int rem,int[] count){
	//	if (rem<0)
	//		return -1;
	//	if (rem==0)
	//		return 0;
	//	if (count[rem-1]!=0)
	//		return count[rem-1];
	//	int min=Integer.MAX_VALUE;
	//	for (int coin:coins){
	//		int res=coinChange(coins,rem-coin,count);
	//		if (res>=0&&res<min){
	//			min=1+res;
	//		}
	//	}
	//	count[rem-1]=(min==Integer.MAX_VALUE)?-1:min;
	//	return count[rem-1];
	//}


	public static void main(String[] args) {
		Test t = new Test();
	}
}




