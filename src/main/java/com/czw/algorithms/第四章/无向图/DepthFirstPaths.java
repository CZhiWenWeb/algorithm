package com.czw.algorithms.第四章.无向图;

import java.util.Iterator;
import java.util.Stack;

/**
 * @Author: czw
 * @CreateTime: 2020-02-24 10:29
 * @UpdeteTime: 2020-02-24 10:29
 * @Description:
 */
//深度优先搜索查找图中的路径
public class DepthFirstPaths {
	private boolean[] marked;
	//从起点到一个顶点的已知路径上的最后一个顶点
	private int[] edgeTo;
	//起点
	private final int s;

	public DepthFirstPaths(Graph G,int s){
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		this.s=s;
		dfs(G,s);
	}
	private void dfs(Graph G,int v){
		marked[v]=true;
		for (Iterator<Integer> it = G.adj(v); it.hasNext(); ) {
			int w = it.next();
			//对标记过的点不检测，会导致相互连接的点记录不全（使用数组进行记录，只能记录一个）
			if (!marked[w]){
				edgeTo[w]=v;
				dfs(G,w);
			}
		}
	}

	public boolean hashPathTo(int v){
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v){
		//不和起点联通的返回null
		if (!hashPathTo(v))
			return null;
		Stack<Integer> stack=new Stack<>();
		for (int w=v;w!=s;w=edgeTo[w]){
			stack.push(w);
		}
		stack.push(s);
		return stack;
	}
}
