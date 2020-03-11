//package com.czw.algorithms.第四章.最短路径;
//
//import com.czw.algorithms.第四章.有向图.Topological;
//
///**
// * @Author: czw
// * @CreateTime: 2020-03-09 09:28
// * @UpdeteTime: 2020-03-09 09:28
// * @Description:
// * 无环加权有向图的最短路径
// */
//public class AcyclicSP {
//	private DirectedEdge[] edgeTo;
//	private double[] distTo;
//	public AcyclicSP(EdgeWeightedDigraph G,int s){
//		edgeTo=new DirectedEdge[G.V()];
//		distTo=new double[G.V()];
//		for (int v=0;v<G.V();v++)
//			distTo[v]=Double.POSITIVE_INFINITY;
//		distTo[s]=0.0;
//		Topological top=new Topological(G);
//		for (int v:top.order()){
//			relax(G,v);
//		}
//	}
//	private void relax(EdgeWeightedDigraph G,int v){
//		for (DirectedEdge e:G.adj(v)){
//			int w=e.to();
//			if (distTo[w]>distTo[v]+e.weight()){
//				distTo[w]=distTo[v]+e.weight();
//				edgeTo[w]=e;
//			}
//		}
//	}
//}
