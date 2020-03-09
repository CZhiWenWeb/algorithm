package com.czw.algorithms.第四章.最小生成树;

import com.czw.algorithms.util.Queue;
import com.czw.algorithms.第二章.排序.MinPQ;

/**
 * @Author: czw
 * @CreateTime: 2020-02-29 15:02
 * @UpdeteTime: 2020-02-29 15:02
 * @Description:
 * 最小生成树的Prim算法的延时实现
 */
public class LazyPriMST {
	//最小生成树的顶点
	private boolean[] marked;
	//最小生成树的边
	private Queue<Edge> mst;
	//横切边(包括失效的边)
	private MinPQ<Edge> pq;

	public LazyPriMST(EdgeWeightedGraph G){
		pq=new MinPQ<>();
		marked=new boolean[G.V()];
		mst=new Queue<>();
		//假设G是连通的
		visit(G,0);

		while (!pq.isEmpty()){
			//从pq中得到权重最小的边
			Edge e=pq.delMin();

			int v=e.either(),w=e.other(v);
			//跳过失效的边
			if (marked[v]&&marked[w])
				continue;
			//将边添加到树中
			mst.enqueue(e);
			//将顶点（v或w）添加到树中
			if (!marked[v])
				visit(G,v);
			if (!marked[w])
				visit(G,w);
		}
	}

	private void visit(EdgeWeightedGraph G,int v){
		//标记顶点v并将所有连接v和未被标记顶点的边加入pq
		marked[v]=true;
		for (Edge e:G.adj(v)){
			//如果和v连接的另一个顶点未被标记
			if (!marked[e.other(v)])
				pq.insert(e);
		}
	}

	public Iterable<Edge> edges(){
		return mst;
	}

	//public double weight(){
	//
	//}
}
