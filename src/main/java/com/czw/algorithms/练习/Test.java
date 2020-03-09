package com.czw.algorithms.练习;


import java.util.HashSet;

/**
 * @Author: czw
 * @CreateTime: 2020-03-02 09:06
 * @UpdeteTime: 2020-03-02 09:06
 * @Description:
 */
public class Test {

	public int longestPalindromeSubseq(String s) {
		int[] dp=new int[s.length()-1];
		dp[0]=1;dp[1]=1;
		for (int i=0;i<s.length()-1;i++){
			if (s.charAt(i)==s.charAt(i+1)){
				dp[1]=2;
				break;
			}
		}
		return 0;
	}


	public static void main(String[] args) {
		Test t = new Test();
		int i=t.longestPalindromeSubseq("bbbab");
	}

}

