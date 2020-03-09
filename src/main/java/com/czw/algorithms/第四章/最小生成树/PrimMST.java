package com.czw.algorithms.第四章.最小生成树;

import com.czw.algorithms.util.In;
import com.czw.algorithms.第二章.排序.IndexMinPQ;

import java.io.File;

/**
 * @Author: czw
 * @CreateTime: 2020-03-02 13:52
 * @UpdeteTime: 2020-03-02 13:52
 * @Description:最小生成树的Prim算法（即时版本）
 */
public class PrimMST {
	//距离树最近的边
	private Edge[] edgeTo;
	//distTo[w]=edgeTo[w].weight()
	private double[] distTo;
	//如果v在树中则为true
	private boolean[] marked;
	//有效的横切边
	private IndexMinPQ<Double> pq;

	public PrimMST(EdgeWeightedGraph G){
		edgeTo=new Edge[G.V()];
		distTo=new double[G.V()];
		marked=new boolean[G.V()];
		for (int v=0;v<G.V();v++)
			distTo[v]=Double.POSITIVE_INFINITY;
		pq= new IndexMinPQ<>(G.V());

		distTo[0]=0.0;
		//用顶点0和权重0初始化pq
		pq.insert(0,0.0);
		while (!pq.isEmpty())
			visit(G,pq.delMin());
	}

	private void visit(EdgeWeightedGraph G,int v){
		//将顶点v添加到树中，更新数据
		marked[v]=true;
		for (Edge e:G.adj(v)){
			int w=e.other(v);

			if (marked[w])
				//v-w失效
				continue;
			if (e.weight()<distTo[w]){
			//	连接w和树的最佳边edge变为e
				edgeTo[w]=e;
				distTo[w]=e.weight();
				if (pq.contains(w))
					pq.changeKey(w,distTo[w]);
				else
					pq.insert(w,distTo[w]);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		File file=new File("F:\\book\\tinyEWG.txt");
		In in=new In(file);
		int v=in.readInt();
		EdgeWeightedGraph g=new EdgeWeightedGraph(v);
		double s=in.readDouble();
		while (in.hasNestLine()){
			String reads=in.readLine();
			reads= reads.equals("") ?in.readLine():reads;
			String[] ds=reads.split(" ");
			Edge edge=new Edge(Integer.parseInt(ds[0]),Integer.parseInt(ds[1]),Double.parseDouble(ds[2]));
			g.addEdge(edge);
		}

		PrimMST primMST=new PrimMST(g);

	}

}
