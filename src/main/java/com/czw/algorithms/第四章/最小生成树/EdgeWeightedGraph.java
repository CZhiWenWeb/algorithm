package com.czw.algorithms.第四章.最小生成树;

import com.czw.algorithms.util.Bag;

/**
 * @Author: czw
 * @CreateTime: 2020-02-29 14:25
 * @UpdeteTime: 2020-02-29 14:25
 * @Description:
 * 加权无向图的数据类型
 */
public class EdgeWeightedGraph {
	//顶点总数
	private final int V;
	//边的总数
	private int E;
	//邻接表
	private Bag<Edge>[] adj;

	public EdgeWeightedGraph(int V){
		this.V=V;
		this.E=0;
		adj=new Bag[V];
		for (int v=0;v<V;v++){
			adj[v]=new Bag<>();
		}
	}

	public int V(){
		return V;
	}
	public void addEdge(Edge edge){
		int v=edge.either(),w=edge.other(v);
		//两个顶点都存储它所在边的权重
		adj[v].add(edge);
		adj[w].add(edge);
		E++;
	}

	public Iterable<Edge> adj(int v){
		return adj[v];
	}

	public Iterable<Edge> edges(){
		Bag<Edge> b=new Bag<>();
		for (int v=0;v<V;v++){
			for (Edge e:adj[v]){
				//防止一条边多次记录和自环的记录
				if (e.other(v)>v)
					b.add(e);
			}
		}
		return b;
	}
}
