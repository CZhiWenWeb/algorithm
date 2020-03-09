package com.czw.algorithms.练习;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntFunction;

/**
 * @Author: czw
 * @CreateTime: 2020-02-28 13:56
 * @UpdeteTime: 2020-02-28 13:56
 * @Description:
 */
public class T826 {

	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
		int[][] job=new int[difficulty.length][2];
		for (int i=0;i<difficulty.length;i++){
			job[i][0]=difficulty[i];
			job[i][1]=profit[i];
		}

		Arrays.sort(job,(o1,o2)->{
			return o1[0]-o2[0];
		});

		int ans=0;

		for (int i=1;i<job.length;i++){
			job[i][1]=Math.max(job[i-1][1],job[i][1]);
			if (i+1<job.length&&job[i][0]==job[i+1][0]){
				job[i][1]=Math.max(job[i][1],job[i+1][1]);
			}
		}

		for (int i=0;i<worker.length;i++){
			int can=-1;
			int left=0,right=job.length-1;
			while (left<=right){
				int mid=(left+right)>>1;
				if (worker[i]<job[mid][0]){
					right=mid-1;
				}else if (worker[i]>job[mid][0]){
					can=mid;
					left=mid+1;
				}else {
					ans+=job[mid][1];
					can=-1;
					break;
				}
			}

			if (can!=-1){
				ans+=job[can][1];
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		T826 t826=new T826();
		int i=t826.maxProfitAssignment(new int[]{23, 30, 35, 35, 43, 46, 47, 81, 83, 98},
				new int[]{8, 11, 11, 20, 33, 37, 60, 72, 87, 95},
				new int[]{95, 46, 47, 97, 11, 35, 99, 56, 41, 92});
	}
}

/**
 * 有一些工作：difficulty[i] 表示第i个工作的难度，profit[i]表示第i个工作的收益。
 * <p>
 * 现在我们有一些工人。worker[i]是第i个工人的能力，即该工人只能完成难度小于等于worker[i]的工作。
 * <p>
 * 每一个工人都最多只能安排一个工作，但是一个工作可以完成多次。
 * <p>
 * 举个例子，如果3个工人都尝试完成一份报酬为1的同样工作，那么总收益为 $3。如果一个工人不能完成任何工作，他的收益为 $0 。
 * <p>
 * 我们能得到的最大收益是多少？
 * <p>
 * 示例：
 * <p>
 * 输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * 输出: 100
 * 解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。
 * 提示:
 * <p>
 * 1 <= difficulty.length = profit.length <= 10000
 * 1 <= worker.length <= 10000
 * difficulty[i], profit[i], worker[i]  的范围是 [1, 10^5]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-profit-assigning-work
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
