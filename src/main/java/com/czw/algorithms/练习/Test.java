package com.czw.algorithms.练习;


import java.util.*;

/**
 * @Author: czw
 * @CreateTime: 2020-03-02 09:06
 * @UpdeteTime: 2020-03-02 09:06
 * @Description:
 */
public class Test {
	public boolean pyramidTransition(String bottom, List<String> allowed) {
		Map<String,List<Character>> map=new HashMap<>();
		for (String s:allowed){
			if (map.containsKey(s.substring(0,2))){
				map.get(s.substring(0,2)).add(s.charAt(2));
				continue;
			}
			List<Character> list=new ArrayList<>();
			list.add(s.charAt(2));
			map.put(s.substring(0,2),list);
		}

		return operate(bottom,map);
	}
	private boolean operate(String bottom, Map<String,List<Character>> map){
		if (bottom.length()==1)
			return true;
		boolean b=false;
		List<List<Character>> lists=new ArrayList<>();
		for (int i=1;i<bottom.length();i++){
			if (map.containsKey(bottom.substring(i-1,i+1))){
				lists.add(map.get(bottom.substring(i-1,i+1)));
			}else {
				return false;
			}
		}
		List<String> bs=new ArrayList<>();
		StringBuilder sb=new StringBuilder();
		aend(lists,sb,0,bs);
		for (String s:bs){
			b= operate(s, map) || b;
		}
		return b;
	}

	private void aend(List<List<Character>> lists,StringBuilder sb,int len,List<String> bs){
		if (len==lists.size()){
			bs.add(sb.toString());
			return;
		}
		for (Character c:lists.get(len)){
			sb.append(c);
			aend(lists,sb,len+1,bs);
			sb.deleteCharAt(sb.length()-1);
		}
	}

	public static void main(String[] args) {
		Test t = new Test();
		String[] strings=new String[]{"BCG","CCA","CAA","CCC","CCB", "GEA", "FFF"};
		List<String> list = new ArrayList<>(Arrays.asList(strings));
		boolean b=t.pyramidTransition("CCC",list );
	}

}

