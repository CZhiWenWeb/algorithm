package com.czw.algorithms.第五章.正则表达式;

import com.czw.algorithms.第四章.有向图.Digraph;

import java.util.Stack;

/**
 * @Author: czw
 * @CreateTime: 2020-03-21 17:17
 * @UpdeteTime: 2020-03-21 17:17
 * @Description:
 * 正则表达式的模式匹配
 */
public class NFA {
	//匹配转换
	private char[] re;
	//epsilon转换
	private Digraph G;
	//状态数量
	private int M;

	public NFA(String regexp){
	//	根据给定的正则表达式构造NFA
		Stack<Integer> ops=new Stack<>();
		re=regexp.toCharArray();
		M=re.length;
		G=new Digraph(M+1);

		for (int i=0;i<M;i++){
			int lp=i;
			if (re[i]=='('||re[i]=='|'){
				ops.push(i);
			}else if (re[i]==')'){
				int or=ops.pop();
			}
		}
	}
}
