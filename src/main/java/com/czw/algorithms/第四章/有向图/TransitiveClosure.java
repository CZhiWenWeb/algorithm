package com.czw.algorithms.第四章.有向图;

/**
 * @Author: czw
 * @CreateTime: 2020-02-27 09:49
 * @UpdeteTime: 2020-02-27 09:49
 * @Description:传递闭包
 *
 * 一个v个顶点的传递闭包是一副含有v^2条边的有向完全图，通常
 * 表示为一个布尔矩阵
 *
 *因为构造函数所需空间和v^2成正比，不适用大型有向图
 *
 * 有向图的传递闭包是由相同的一组顶点组成的另一幅有向图，
 * 在传递闭包中存在一条从v指向w的边当且仅当在G中w是从v可达的
 */
public class TransitiveClosure {
	private DirectedDFS[] all;

	TransitiveClosure(Digraph G){
		all=new DirectedDFS[G.V()];
		for (int v=0;v<G.V();v++){
			//对有所点使用dfs进行可达性分析(穷举)
			all[v]=new DirectedDFS(G,v);
		}
	}

	//以v为起点进行可达性分析，w被标记即可达
	boolean reachable(int v,int w){
		return all[v].marked(w);
	}
}
