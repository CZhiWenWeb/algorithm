package com.czw.algorithms.第四章.最短路径;

import com.czw.algorithms.第二章.排序.IndexMinPQ;

/**
 * @Author: czw
 * @CreateTime: 2020-03-05 13:53
 * @UpdeteTime: 2020-03-05 13:53
 * @Description:最短路径的Dijkstra算法
 */
public class DijkstraSP {
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;

	public DijkstraSP(EdgeWeightedDigraph G,int s){
		edgeTo=new DirectedEdge[G.V()];
		distTo=new double[G.V()];
		pq=new IndexMinPQ<>(G.V());
		for (int v=0;v<G.V();v++){
			distTo[v]=Double.POSITIVE_INFINITY;
		}
		distTo[s]=0.0;
		pq.insert(s,0.0);
		while (!pq.isEmpty())
			relax(G,pq.delMin());
	}
	private void relax(EdgeWeightedDigraph G,int v){
		for (DirectedEdge e:G.adj(v)){
			int w=e.to();
			if (distTo[w]>distTo[v]+e.weight()){
				distTo[w]=distTo[v]+e.weight();
				edgeTo[w]=e;
				if (pq.contains(w))
					pq.changeKey(w,distTo[w]);
				else
					pq.insert(w,distTo[w]);
			}
		}
	}
}
