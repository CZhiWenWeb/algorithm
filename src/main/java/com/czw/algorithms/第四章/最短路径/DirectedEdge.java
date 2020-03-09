package com.czw.algorithms.第四章.最短路径;

/**
 * @Author: czw
 * @CreateTime: 2020-03-03 14:49
 * @UpdeteTime: 2020-03-03 14:49
 * @Description:加权有向边
 */
public class DirectedEdge {
	//边的起点
	private final int v;
	//边的终点
	private final int w;
	//边的权重
	private final double weight;

	public DirectedEdge(int v,int w,double weight){
		this.v=v;
		this.w=w;
		this.weight=weight;
	}
	public double weight(){
		return weight;
	}

	public int from(){
		return v;
	}

	public int to(){
		return w;
	}

	@Override
	public String toString(){
		return String.format("%d->%d %.2f",v,w,weight);
	}
}
