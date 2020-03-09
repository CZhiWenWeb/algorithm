package com.czw.algorithms.第四章.有向图;

/**
 * @Author: czw
 * @CreateTime: 2020-02-25 15:48
 * @UpdeteTime: 2020-02-25 15:48
 * @Description:
 * 可达性分析可用于标记-清除的垃圾收集
 *
 */
public class DirectedDFS {
	private boolean[] marked;

	public DirectedDFS(Digraph G,int s){
		marked=new boolean[G.V()];
		dfs(G,s);
	}

	public DirectedDFS(Digraph G,Iterable<Integer> sources){
		marked=new boolean[G.V()];
		for (int s:sources){
			if (!marked[s])
				dfs(G,s);
		}
	}
	//着份深度优先搜索的实现能够判断给定的一个或一组顶点能到达哪些顶点
	private void dfs(Digraph G,int v){
		marked[v]=true;
		for (int w:G.adj(v)){
			if (!marked[w])
				dfs(G,w);
		}
	}

	public boolean marked(int v){
		return marked[v];
	}

}
