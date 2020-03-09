package com.czw.algorithms.第四章.无向图;

import java.util.Iterator;

/**
 * @Author: czw
 * @CreateTime: 2020-02-25 14:44
 * @UpdeteTime: 2020-02-25 14:44
 * @Description:
 * 二分图（电影与演员的映射等）
 */
public class TwoColor {
	private boolean[] marked;
	private boolean[] color;
	private boolean isTwoColorable=true;
	public TwoColor(Graph G){
		marked=new boolean[G.V()];
		color=new boolean[G.V()];
		for (int s=0;s<G.V();s++){
			if (!marked[s])
				dfs(G,s);
		}
	}
	private void dfs(Graph G,int v){
		marked[v]=true;
		for (Iterator<Integer> it = G.adj(v); it.hasNext(); ) {
			int w = it.next();
			if (!marked[w]){
				color[w]=!color[v];
				dfs(G,w);
			}
			else if (color[w]==color[v])
				isTwoColorable=false;
		}
	}
	public boolean isBipartite(){
		return isTwoColorable;
	}
}
