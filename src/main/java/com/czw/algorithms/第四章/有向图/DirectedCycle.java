package com.czw.algorithms.第四章.有向图;

import com.czw.algorithms.第四章.最短路径.DirectedEdge;
import com.czw.algorithms.第四章.最短路径.EdgeWeightedDigraph;

import java.util.Stack;

/**
 * @Author: czw
 * @CreateTime: 2020-02-26 09:45
 * @UpdeteTime: 2020-02-26 09:45
 * @Description:
 * 寻找有向环
 */
public class DirectedCycle {
	//marked[v]=has vertex v been marked?
	private boolean[] marked;
	//edgeTo[v]=previous vertex on path to v
	private int[] edgeTo;
	//onStack[v]=is vertex on the stack?
	private boolean[] onStack;
	//directed cycle(or null if no such cycle)
	private Stack<Integer> cycle;

	public DirectedCycle(Digraph G){
		marked=new boolean[G.V()];
		onStack=new boolean[G.V()];
		edgeTo=new int[G.V()];
		for (int v=0;v<G.V();v++)
			if (!marked[v]&&cycle==null)
				dfs(G,v);
	}

	private void dfs(Digraph G,int v){
		onStack[v]=true;
		marked[v]=true;
		for (int w:G.adj(v)){
			if (cycle!=null)
				return;
			//found new vertex,so recur
			else if (!marked[w]){
				edgeTo[w]=v;
				dfs(G,v);
			}
			//trace back directed cycle
			else if (onStack[w]){
				cycle=new Stack<>();
				for (int x=v;x!=w;x=edgeTo[x]){
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);
			}
		}
		onStack[v]=false;
	}

	public boolean hasCycle(){
		return cycle!=null;
	}

	public Iterable<Integer> cycle(){
		return cycle;
	}
}
