package com.czw.algorithms.第四章.有向图;

import com.czw.algorithms.util.Queue;

import java.util.Stack;

/**
 * @Author: czw
 * @CreateTime: 2020-02-26 15:59
 * @UpdeteTime: 2020-02-26 15:59
 * @Description:
 * 有向图基于深度优先搜索的顶点排序
 */
public class DepthFirstOrder {
	private boolean[] marked;
	//所有顶点的前序(即dfs调用前)排序
	private Queue<Integer> pre;
	//所有顶点的后序(dfs调用后)排序
	private Queue<Integer> post;
	//所有顶点的逆后序排列
	private Stack<Integer> reversePost;

	public DepthFirstOrder(Digraph G){
		pre=new Queue<>();
		post=new Queue<>();
		reversePost=new Stack<>();
		marked=new boolean[G.V()];
		for (int v=0;v<G.V();v++){
			if (!marked[v])
				dfs(G,v);
		}
	}

	private void dfs(Digraph G,int v){
		marked[v]=true;
		pre.enqueue(v);
		for (int w:G.adj(v)){
			if (!marked[w])
				dfs(G,w);
		}
		post.enqueue(v);
		reversePost.push(v);
	}

	public Iterable<Integer> pre(){
		return pre;
	}
	public Iterable<Integer> post(){
		return post;
	}
	public Iterable<Integer> reversePost(){
		return reversePost;
	}
}
