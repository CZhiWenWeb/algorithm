package com.czw.algorithms.第四章.无向图;

import com.czw.algorithms.util.Queue;

import java.util.Iterator;
import java.util.Stack;

/**
 * @Author: czw
 * @CreateTime: 2020-02-24 11:05
 * @UpdeteTime: 2020-02-24 11:05
 * @Description:广度优先搜索图中的路径
 */
public class BreadthFirstPaths {
	//到达该顶点的最短路径已经知吗
	private boolean[] marked;
	//到达该顶点的已知路径上的最后一个顶点
	private int[] edgeTo;
	//起点
	private final int s;

	public BreadthFirstPaths(Graph G,int s){
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];;
		this.s=s;
		bfs(G,s);
	}

	private void bfs(Graph G,int s){
		Queue<Integer> queue=new Queue<>();
		//标记起点
		marked[s]=true;
		queue.enqueue(s);
		while (!queue.isEmpty()){
			//从队列中删去下一个顶点
			int v=queue.dequeue();
			for (Iterator<Integer> it = G.adj(v); it.hasNext(); ) {
				int w = it.next();
				//对于每个未被标记的相邻顶点
				if (!marked[w]){
					//保存最短路径的最后一条边
					edgeTo[w]=v;
					//标记它，因为最短路径已知
					marked[w]=true;
					//并将它添加到队列中
					queue.enqueue(w);
				}
			}
		}
	}

	public boolean hasPathTo(int v){
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v){
		//不和起点联通的返回null
		if (!hasPathTo(v))
			return null;
		Stack<Integer> stack=new Stack<>();
		for (int w=v;w!=s;w=edgeTo[w]){
			stack.push(w);
		}
		stack.push(s);
		return stack;
	}

}
