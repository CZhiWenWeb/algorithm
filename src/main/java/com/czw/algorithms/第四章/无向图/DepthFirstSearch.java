package com.czw.algorithms.第四章.无向图;

import java.util.Iterator;

/**
 * @Author: czw
 * @CreateTime: 2020-02-24 10:06
 * @UpdeteTime: 2020-02-24 10:06
 * @Description:
 */
//深度优先搜索法
public class DepthFirstSearch {
	private boolean[] marked;
	private int count;

	public DepthFirstSearch(Graph G,int s){
		marked=new boolean[G.V()];
		dfs(G,s);
	}
	// 深度优先
	private void dfs(Graph G,int v){
		marked[v]=true;
		count++;
		for (Iterator<Integer> it = G.adj(v); it.hasNext(); ) {
			int w = it.next();
			if (!marked[w]){
				dfs(G,w);
			}
		}
	}
	//点w是否被标记
	public boolean marded(int w){
		return marked[w];
	}
	//以s为起点联通的点的个数
	public int count(){
		return count;
	}
}
