package com.czw.algorithms.第四章.有向图;

import java.util.Stack;

/**
 * @Author: czw
 * @CreateTime: 2020-02-26 08:56
 * @UpdeteTime: 2020-02-26 08:56
 * @Description:
 */
public class DepthFirstDirectedPaths {

	private boolean[] marked;
	private int[] edgeTo;
	private final int s;

	public DepthFirstDirectedPaths(Digraph digraph, int s){
		this.s=s;
		this.edgeTo=new int[digraph.V()];
		this.marked=new boolean[digraph.V()];
		dfs(digraph,s);
	}
	private void dfs(Digraph digraph,int s){
		marked[s]=true;
		for (int w:digraph.adj(s)){
			if (!marked[w]){
				edgeTo[w]=s;
				dfs(digraph,w);
			}
		}
	}

	public boolean hashPathTo(int v){
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v){
		if (!hashPathTo(v))
			return null;
		Stack<Integer> stack=new Stack<>();
		for (int i=v;i!=s;i=edgeTo[i]){
			stack.push(i);
		}
		stack.push(s);
		return stack;
	}
}
