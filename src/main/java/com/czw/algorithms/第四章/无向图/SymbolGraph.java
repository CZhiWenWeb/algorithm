package com.czw.algorithms.第四章.无向图;

import com.czw.algorithms.util.In;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @Author: czw
 * @CreateTime: 2020-02-24 14:57
 * @UpdeteTime: 2020-02-24 14:57
 * @Description:符号图
 */
public class SymbolGraph {
	//使用hashMap符号表：符号名->索引
	private HashMap<String,Integer> st;
	//反向索引，保存每个顶点索引对应的顶点名：索引->符号名
	private String[] keys;
	// 图
	private Graph G;
	//
	public SymbolGraph(String path,String sp) throws Exception {
		st=new HashMap<>();
		File file=new File(path);
		//第一遍
		In in=new In(file);
	//	构建索引
		while (in.hasNestLine()){
			//读取字符串
			String[] a=in.readLine().split(sp);
			//为每个不同的字符串关联一个索引
			for (String s : a) {
				if (!st.containsKey(s))
					st.put(s, st.size());
			}
		}
		//用来获得顶点名的反向索引是一个数组
		keys=new String[st.size()];
		for (String name:st.keySet()){
			keys[st.get(name)]=name;
		}
		G=new Graph(st.size());
		//第二遍(因为是使用bufferedInputStream进行读取，所以读取过后需要重新构建)
		in=new In(file);
		//	构建图
		while (in.hasNestLine()){
			// 将每一行的第一个顶点和该行的其他顶点相连
			String[] a=in.readLine().split(sp);
			int v=st.get(a[0]);
			for (int i=1;i<a.length;i++){
				G.addEdge(v,st.get(a[i]));
			}
		}
	}

	public boolean contains(String s){
		return st.containsKey(s);
	}
	public int index(String s){
		return st.get(s);
	}
	public String name(int v){
		return keys[v];
	}
	public Graph G(){
		return G;
	}

	public static void main(String[] args) throws Exception {
			SymbolGraph sg=new SymbolGraph("F:\\movies-hero.txt","/");
			Graph G=sg.G();
		for (Iterator<Integer> it = G.adj(sg.index("Almost Heroes (1998)")); it.hasNext(); ) {
			int w = it.next();
			System.out.println(sg.name(w));
		}
	}
}
