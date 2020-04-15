package com.czw.algorithms.第四章.最短路径;

import com.czw.algorithms.util.Queue;

import java.util.Stack;

/**
 * @Author: czw
 * @CreateTime: 2020-03-16 10:49
 * @UpdeteTime: 2020-03-16 10:49
 * @Description: 基于队列的Bellman-Ford算法，用于一般加权有向图的最短路径问题
 */
public class BellmanFordSP {
	//从起点到某个顶点的路径长度
	private double[] distTo;
	//从起点到某个顶点的最后一条边
	private DirectedEdge[] edgeTo;
	//改顶点是否存在与队列中
	private boolean[] onQ;
	//正在被放松的顶点
	private Queue<Integer> queue;
	//relax()的调用次数
	private int cost;
	//edgeTo[]中的是否有负权重环
	private Iterable<DirectedEdge> cycle;

	public BellmanFordSP(EdgeWeightedDigraph G, int s) {
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		onQ = new boolean[G.V()];
		queue = new Queue<>();
		for (int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		queue.enqueue(s);
		onQ[s] = true;
		while (!queue.isEmpty() && !hasNegativeCycle()) {
			int v = queue.dequeue();
			onQ[v] = false;
			relax(G, v);
		}
	}

	private void relax(EdgeWeightedDigraph G, int v) {
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (distTo[w] > distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if (!onQ[w]) {
					queue.enqueue(w);
					onQ[w] = true;
				}
			}
			if (cost++ % G.V() == 0) {
				findNegativeCycle();
				if (hasNegativeCycle())
					return;
			}
		}
	}

	//最短路径树实现中的标准查询算法
	public double distTo(int v) {
		return distTo[v];
	}

	public boolean hasPathTo(int v) {
		return distTo[v] != Double.POSITIVE_INFINITY;
	}

	public Iterable<DirectedEdge> pathTo(int v) {
		if (hasNegativeCycle())
			throw new UnsupportedOperationException("have Negative cycle");
		if (hasPathTo(v)) {
			Stack<DirectedEdge> edges = new Stack<>();
			for (DirectedEdge e=edgeTo[v]; e!=null; e=edgeTo[e.from()]){
				edges.push(e);
			}
			return edges;
		}
		return null;
	}

	private void findNegativeCycle() {
		int V=edgeTo.length;
		EdgeWeightedDigraph spt;
		spt=new EdgeWeightedDigraph(V);
		for (int v=0;v<V;v++)
			if (edgeTo[v]!=null)
				spt.addEdge(edgeTo[v]);
		EdgeWeightedDirectedCycle finder=new EdgeWeightedDirectedCycle(spt);
		cycle=finder.cycle();
	}


	public boolean hasNegativeCycle() {
		return cycle!=null;
	}

	public Iterable<DirectedEdge> negativeCycle() {
		return cycle;
	}
}
