package com.czw.algorithms.第四章.无向图;

import com.czw.algorithms.第五章.子字符串查找.C;

import java.util.Iterator;

/**
 * @Author: czw
 * @CreateTime: 2020-02-25 14:28
 * @UpdeteTime: 2020-02-25 14:28
 * @Description:
 * 图的环检测
 */
public class Cycle {
	private boolean[] marked;

	private boolean hasCycle;

	public Cycle(Graph G){
		marked=new boolean[G.V()];
		for (int s=0;s<G.V();s++){
			if (!marked[s])
				dfs(G,s,s);
		}
	}
	private void dfs(Graph G,int v,int u){
		marked[v]=true;
		for (Iterator<Integer> it = G.adj(v); it.hasNext(); ) {
			int w = it.next();
			if (!marked[w])
				dfs(G,w,v);
			else if (w!=u)
				hasCycle=true;
		}
	}
	public boolean hasCycle(){
		return hasCycle;
	}

	public static void main(String[] args) throws Exception {
		SymbolGraph sg=new SymbolGraph("F:\\movies-hero.txt","/");
		Cycle c=new Cycle(sg.G());
		boolean b=c.hasCycle();
	}
}
