package com.czw.algorithms.练习;

/**
 * @Author: czw
 * @CreateTime: 2020-04-03 09:54
 * @UpdeteTime: 2020-04-03 09:54
 * @Description:
 */
public class Temp{
	int i;
	public Temp(int i){
		this.i=i;
	}
	@Override
	public boolean equals(Object obj){
		Temp temp= (Temp) obj;
		return this.i==temp.i;
	}

	@Override
	public int hashCode(){
		int result=1;
		result=result*31+this.i;
		return result;
	}
}
