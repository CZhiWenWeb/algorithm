package com.czw.algorithms.第四章.最短路径;


import java.util.Stack;

/**
 * @Author: czw
 * @CreateTime: 2020-03-19 10:34
 * @UpdeteTime: 2020-03-19 10:34
 * @Description:
 */
public class EdgeWeightedDirectedCycle {
	//marked[v]=has vertex v been marked?
	private boolean[] marked;
	//edgeTo[v]=previous edge on path to v
	private DirectedEdge[] edgeTo;
	//onStack[v]=is vertex on the stack?
	private boolean[] onStack;
	//directed cycle or null if no such cycle
	private Stack<DirectedEdge> cycle;

	public EdgeWeightedDirectedCycle(EdgeWeightedDigraph G){
		marked=new boolean[G.V()];
		onStack=new boolean[G.V()];
		edgeTo=new DirectedEdge[G.V()];
		for (int v=0;v<G.V();v++)
			if (!marked[v])
				dfs(G,v);
	}

	private void dfs(EdgeWeightedDigraph G,int v){
		onStack[v]=true;
		marked[v]=true;
		for (DirectedEdge e:G.adj(v)){
			int w=e.to();

			if (cycle!=null)
				return;
			//found new vertex so recur
			else if (!marked[w]){
				edgeTo[w]=e;
				dfs(G,w);
			}
			//trace back directed cycle
			else if (onStack[w]){
				cycle=new Stack<>();
				DirectedEdge f=e;
				while (f.from()!=w){
					cycle.push(f);
					f=edgeTo[f.from()];
				}
				cycle.push(f);
				return;
			}
		}
		onStack[v]=false;
	}

	public boolean hasCycle(){
		return cycle!=null;
	}

	public Iterable<DirectedEdge> cycle(){
		return cycle;
	}
}
