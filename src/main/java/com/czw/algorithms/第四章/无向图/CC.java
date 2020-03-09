package com.czw.algorithms.第四章.无向图;

import java.util.Iterator;

/**
 * @Author: czw
 * @CreateTime: 2020-02-24 14:02
 * @UpdeteTime: 2020-02-24 14:02
 * @Description:深度优先搜索图中的联通分量
 */
public class CC {
	private boolean[] marked;
	private int[] id;
	//联通分量数
	private int count;

	public CC(Graph G){
		marked=new boolean[G.V()];
		id=new int[G.V()];
		for (int s=0;s<G.V();s++){
			if (!marked[s]){
				dfs(G,s);
				count++;
			}
		}
	}

	private void dfs(Graph G,int v){
		marked[v]=true;
		id[v]=count;
		for (Iterator<Integer> it = G.adj(v); it.hasNext(); ) {
			int w = it.next();
			if (!marked[w])
				dfs(G,w);
		}
	}
	//v与w联通吗
	public boolean connected(int v,int w){
		return id[v]==id[w];
	}
	//v所在的联通分量的标识符(0-count()-1)
	public int id(int v){
		return id[v];
	}
	//连通分量数
	public int count(){
		return count;
	}
}
