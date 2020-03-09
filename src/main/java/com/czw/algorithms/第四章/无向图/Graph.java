package com.czw.algorithms.第四章.无向图;

import com.czw.algorithms.util.Bag;

import java.util.Iterator;

/**
 * @Author: czw
 * @CreateTime: 2020-02-24 09:43
 * @UpdeteTime: 2020-02-24 09:43
 * @Description:无向图
 */
//邻接表表示图
public class Graph {
	//顶点数目
	private final int V;
	// 边的数目
	private int E;
//	邻接表
	private Bag<Integer>[] adj;
	//初始化一个所有点都不相连的图
	public Graph(int V){
		this.V=V;this.E=0;
		//创建邻接表
		adj= (Bag<Integer>[]) new Bag[V];
		//将所有链表初始化为空
		for (int v=0;v<V;v++){
			adj[v]=new Bag<Integer>();
		}
	}
	public int V(){
		return V;
	}
	public int E(){
		return E;
	}
	//连接点的方法（存在大量连接时极其繁杂）
	public void addEdge(int v,int w){
		//将w添加到v的链表中
		adj[v].add(w);
		//将v添加到w的链表中
		adj[w].add(v);
		E++;
	}

	public Iterator<Integer> adj(int v){
		return  adj[v].iterator();
	}
}
