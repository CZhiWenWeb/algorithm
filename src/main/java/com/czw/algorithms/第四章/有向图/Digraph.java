package com.czw.algorithms.第四章.有向图;

import com.czw.algorithms.util.Bag;

/**
 * @Author: czw
 * @CreateTime: 2020-02-25 15:06
 * @UpdeteTime: 2020-02-25 15:06
 * @Description:有向图
 */
public class Digraph {
	private final int V;

	private int E;

	private Bag<Integer>[] adj;
	//创建一副含有V个顶点但没有边的有向图
	public Digraph(int V){
		this.V=V;
		this.E=0;
		adj=new Bag[V];
		for (int v=0;v<V;v++){
			adj[v]=new Bag<>();
		}
	}
	//顶点总数
	public int V(){
		return V;
	}
	//边的总数
	public int E(){
		return E;
	}
	//向有向图中添加一条边v->w
	public void addEdge(int v,int w){
		adj[v].add(w);
		E++;
	}
	//由v指出的边所连接的所有顶点
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	//该图的反向图
	public Digraph reverse(){
		Digraph R=new Digraph(V);
		for (int v=0;v<V;v++){
			for (int w:adj(v)){
				R.addEdge(w,v);
			}
		}
		return R;
	}
}
