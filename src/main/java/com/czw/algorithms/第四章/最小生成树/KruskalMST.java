package com.czw.algorithms.第四章.最小生成树;

import com.czw.algorithms.util.Queue;
import com.czw.algorithms.第二章.排序.MinPQ;

/**
 * @Author: czw
 * @CreateTime: 2020-03-03 13:41
 * @UpdeteTime: 2020-03-03 13:41
 * @Description:
 * 最小生成树的kruskal算法
 */
public class KruskalMST {
	private Queue<Edge> mst;

	public KruskalMST(EdgeWeightedGraph G){
		mst=new Queue<>();
		MinPQ<Edge> pq=new MinPQ<>();
		for (Edge e:G.edges())
			pq.insert(e);



	}
}
