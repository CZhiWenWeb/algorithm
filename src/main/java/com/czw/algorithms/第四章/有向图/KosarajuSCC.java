package com.czw.algorithms.第四章.有向图;

/**
 * @Author: czw
 * @CreateTime: 2020-02-26 17:02
 * @UpdeteTime: 2020-02-26 17:02
 * @Description:
 * 计算强连通分量的kosaraju算法
 * 定义：如果两个顶点v和w是互相可达的，则称它们为强连通的，
 * 如果一副有向图中的任意两个顶点都是强连通的，则称这副有向图
 * 是强连通的。
 * 强连通分量性质：1.自反性：任意顶点v和自己都是强连通的
 * 2.对称性：如果v和w是强连通的，那么w和w也是强连通的
 * 3.传递性：如果v和w是强连通的且w和x也是强连通，那么v和x强连通
 */
public class KosarajuSCC {
	//已访问过的顶点
	private boolean[] marked;
	//强连通分量的标识符
	private int[] id;
	//强连通分量的数量
	private int count;

	public KosarajuSCC(Digraph G){
		marked=new boolean[G.V()];
		id=new int[G.V()];
		DepthFirstOrder order=new DepthFirstOrder(G.reverse());
		for (int s:order.reversePost()){
			if (!marked[s]){
				dfs(G,s);
				count++;
			}
		}
	}
	private void dfs(Digraph G,int v){
		marked[v]=true;
		id[v]=count;
		for (int w:G.adj(v)){
			if (!marked[w])
				dfs(G,w);
		}
	}
	public boolean stronglyConnected(int v,int w){
		return id[v]==id[w];
	}
	public int id(int v){
		return id[v];
	}
	public int count(){
		return count;
	}
}
