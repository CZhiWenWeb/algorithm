package com.czw.algorithms.第四章.有向图;

import com.czw.algorithms.第四章.最短路径.EdgeWeightedDigraph;

/**
 * @Author: czw
 * @CreateTime: 2020-02-26 16:11
 * @UpdeteTime: 2020-02-26 16:11
 * @Description:
 * 拓扑排序:对有向无环图G进行拓扑排序，是将G中所有顶点拍成一个线性序列，
 * 使得图中任意一对顶点u和v，若边<u,v>包含于E（G），则u在线性序列中出现出现在
 * v之前，这样的线性序列称为满足拓扑次序
 */
public class Topological {
	//顶点的拓扑顺序
	private Iterable<Integer> order;

	public Topological(Digraph G){
		DirectedCycle cyclefinder=new DirectedCycle(G);
		if (!cyclefinder.hasCycle()){
			DepthFirstOrder dfs=new DepthFirstOrder(G);
			order=dfs.reversePost();
		}
	}
	//
	//public Topological(EdgeWeightedDigraph G){
	//	DirectedCycle cyclefinder=new DirectedCycle(G);
	//	if (!cyclefinder.hasCycle()){
	//
	//	}
	//}

	public Iterable<Integer> order(){
		return order;
	}

	public boolean isDAG(){
		return order!=null;
	}

}
