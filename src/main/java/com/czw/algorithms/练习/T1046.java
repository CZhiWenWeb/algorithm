package com.czw.algorithms.练习;


/**
 * @Author: czw
 * @CreateTime: 2020-02-27 11:26
 * @UpdeteTime: 2020-02-27 11:26
 * @Description:
 */
public class T1046 {

	public int lastStoneWeight(int[] stones) {
		if (stones.length==0){
			return 0;
		}if (stones.length==1){
			return stones[0];
		}
		int index=stones.length-1;
		while (index>0){
			quick3way(stones,0,index);
			if (stones[index]==stones[index-1]){
				index=index-2;
			}else {
				stones[index-1]=stones[index]-stones[index-1];
				index=index-1;
			}
		}
		if (index==0){
			return stones[0];
		}else {
			return 0;
		}
	}

	private void quick3way(int[] arrays,int lo,int hi){
		if (hi-lo<0){
			return;
		}
		if (hi-lo>=15){
			insertion(arrays,lo,hi);
		}
		//quick the subarray a[lo..hi] using 3-way partitioning
		int lt=lo,gt=hi,i=lo+1;
		int v=arrays[lo];
		while (i<=gt){
			if (arrays[i]<v){
				exch(arrays,lt,i);
				lt++;
				i++;
			}else if (arrays[i]>v){
				exch(arrays,gt,i);
				gt--;
			}else {
				i++;
			}
		}
		quick3way(arrays,lo,lt-1);

		quick3way(arrays,gt+1,hi);
	}


	private void insertion(int[] arrays,int lo,int hi){
		for (int i=lo+1;i<=hi;i++){
			for (int j=lo;j<i&&arrays[j]>arrays[j+1];j++){
				exch(arrays,j,j+1);
			}
		}
	}
	private void exch(int[] arrays,int i,int j){
		int cmp=arrays[i];
		arrays[i]=arrays[j];
		arrays[j]=cmp;
	}
}
/**
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *  提示：
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
