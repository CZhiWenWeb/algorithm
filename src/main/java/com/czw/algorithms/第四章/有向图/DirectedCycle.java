package com.czw.algorithms.第四章.有向图;

import java.util.Stack;

/**
 * @Author: czw
 * @CreateTime: 2020-02-26 09:45
 * @UpdeteTime: 2020-02-26 09:45
 * @Description:
 * 寻找有向环
 */
public class DirectedCycle {
	private boolean[] marked;

	private int[] edgeTo;
	//有向环中的所有顶点（如果存在）
	private Stack<Integer> cycle;
	//递归调用的栈上的所有顶点
	private boolean[] onStak;

	public DirectedCycle(Digraph G){
		onStak=new boolean[G.V()];
		edgeTo=new int[G.V()];
		marked=new boolean[G.V()];
		for (int v=0;v<G.V();v++){
			if (!marked[v])
				dfs(G,v);
		}
	}

	private void dfs(Digraph G,int v){
		onStak[v]=true;
		marked[v]=true;
		for (int w:G.adj(v)){
			if (this.hasCycle())
				return;
			else if (!marked[w]){
				edgeTo[w]=v;
				dfs(G,w);
			}else if (onStak[w]){
				cycle=new Stack<>();
				for (int x=v;x!=w;x=edgeTo[x])
					cycle.push(x);
				cycle.push(w);
				cycle.push(v);
			}
		}
		onStak[v]=false;
	}

	public boolean hasCycle(){
		return cycle!=null;
	}

	public Iterable<Integer> cycle(){
		return cycle;
	}
}
