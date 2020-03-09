package com.czw.algorithms.第四章.最短路径;

import com.czw.algorithms.util.Bag;
import com.czw.algorithms.util.In;

import java.io.File;

/**
 * @Author: czw
 * @CreateTime: 2020-03-03 14:54
 * @UpdeteTime: 2020-03-03 14:54
 * @Description:加权有向图的数据类型
 */
public class EdgeWeightedDigraph {
	//顶点总数
	private final int V;
	//边的总数
	private int E;
	//邻接表
	private Bag<DirectedEdge>[] adj;
	public int V(){
		return V;
	}
	public EdgeWeightedDigraph(int V){
		this.V=V;
		this.E=0;
		adj=new Bag[V];
		for (int v=0;v<V;v++){
			adj[v]=new Bag<>();
		}
	}

	public EdgeWeightedDigraph(In in) throws Exception {
		this.V=Integer.parseInt(in.readLine());
		adj=new Bag[this.V];
		for (int i=0;i<V;i++){
			adj[i]=new Bag<>();
		}
		int E=Integer.parseInt(in.readLine());
		while (in.hasNestLine()){
			String[] strings=in.readLine().split(" ");
			DirectedEdge e=new DirectedEdge(Integer.parseInt(strings[0]),
					Integer.parseInt(strings[1]),
					Double.parseDouble(strings[2]));
			addEdge(e);
		}
		if (E!=this.E){
			throw new Exception("构建错误");
		}
	}

	public void addEdge(DirectedEdge e){
		adj[e.from()].add(e);
		E++;
	}

	public Iterable<DirectedEdge> adj(int v){
		return adj[v];
	}

	public Iterable<DirectedEdge> edges(){
		Bag<DirectedEdge> bag=new Bag<>();
		for (int v=0;v<V;v++)
			for (DirectedEdge e:adj(v))
				bag.add(e);
		return bag;
	}

	public static void main(String[] args) throws Exception {
		In in=new In(new File("F:\\book\\tinyEWG.txt"));
		EdgeWeightedDigraph g=new EdgeWeightedDigraph(in);
	}
}
