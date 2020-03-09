package com.czw.algorithms.第四章.最小生成树;

/**
 * @Author: czw
 * @CreateTime: 2020-03-03 13:47
 * @UpdeteTime: 2020-03-03 13:47
 * @Description:union-find
 */
public class UF {
	//parent[i]=parent of i
	private int[] parent;
	//rank[i]=rank of subtree rooted at
	//i(never more than 31)
	private byte[] rank;
	//number of components
	private int count;

	public UF(int n){
		if (n<0)
			throw new IllegalArgumentException();
		count=n;
		parent=new int[n];
		rank=new byte[n];
		for (int i=0;i<n;i++){
			parent[i]=i;
			rank[i]=0;
		}
	}


}
