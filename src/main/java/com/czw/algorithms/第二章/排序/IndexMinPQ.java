package com.czw.algorithms.第二章.排序;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Author: czw
 * @CreateTime: 2020-03-02 14:05
 * @UpdeteTime: 2020-03-02 14:05
 * @Description:
 */
public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer>{
	//maximum number of elements on PQ
	private int maxN;
	//number of elements on PQ
	private int n;
	//binary heap using 1-based indexing
	private int[] pq;
	//inverse of pq qp[pq[i]]=qp[qp[i]]=i
	private int[] qp;
	//keys[i]=priority of i
	private Key[] keys;

	public IndexMinPQ(int maxN){
		this.maxN=maxN;
		n=0;
		keys= (Key[]) new Comparable[maxN+1];
		pq=new int[maxN+1];
		qp=new int[maxN+1];
		for (int i=0;i<=maxN;i++)
			qp[i]=-1;
	}

	public boolean isEmpty(){
		return n==0;
	}

	public boolean contains(int i){
		return qp[i]!=-1;
	}

	public int size(){
		return n;
	}

	//associates key with index
	//i为key的优先级
	public void insert(int i,Key key){
		if (i<0||i>maxN)
			throw new IllegalArgumentException();
		if (contains(i))
			throw new IllegalArgumentException("is already");
		n++;
		//优先级为i的元素在二叉堆中的下标为n
		qp[i]=n;
		//二叉堆中下标为n的元素优先级为i
		pq[n]=i;
		//优先级为i的元素为key
		keys[i]=key;
		swim(n);
	}

	public int minIndex(){
		if (n==0)
			throw new NoSuchElementException();
		return pq[1];
	}

	public Key minKey(){
		if (n==0)
			throw new NoSuchElementException();
		return keys[pq[1]];
	}
	//remove a minimum key and return its associated index
	public int delMin(){
		if (n==0)
			throw new NoSuchElementException();
		int min=pq[1];
		exch(1,n--);
		sink(1);
		assert min==pq[n+1];
		//delete
		qp[min]=-1;
		//to help with garbage collection
		keys[min]=null;
		//not needed
		pq[n+1]=-1;

		return min;
	}
	//return the key associated with index{@code i}
	public Key keyOf(int i){
		if (i<0||i>=maxN)
			throw new IllegalArgumentException();
		if (!contains(i))
			throw new NoSuchElementException();
		else return keys[i];
	}
	//change the key associated with index{@code i}to the
	//specified value
	public void changeKey(int i,Key key){
		if (i<0||i>maxN)
			throw new IllegalArgumentException();
		if (!contains(i))
			throw new NoSuchElementException();
		keys[i]=key;
		swim(qp[i]);
		sink(qp[i]);
	}
	//decrease the key associated with index{@code i} to
	//the specified value
	public void decreaseKey(int i,Key key){
		if (i<0||i>=maxN)
			throw new IllegalArgumentException();
		if (!contains(i))
			throw new NoSuchElementException();
		if (keys[i].compareTo(key)<=0)
			throw new IllegalArgumentException();
		keys[i]=key;
		swim(qp[i]);
	}

	//increase the key associated with index{@code i} to
	//the specified value
	public void increaseKey(int i,Key key){
		if (i>0||i<maxN)
			throw new IllegalArgumentException();
		if (!contains(i))
			throw new NoSuchElementException();
		if (keys[i].compareTo(key)>=0)
			throw new IllegalArgumentException();
		keys[i]=key;
		sink(qp[i]);
	}

	//remove the key associated with index{@code i}
	public void delete(int i){
		if (i<0||i>=maxN)
			throw new IllegalArgumentException();
		if (!contains(i))
			throw new NoSuchElementException();
		int index=qp[i];
		exch(index,n--);
		swim(index);
		sink(index);
		keys[i]=null;
		qp[i]=-1;
	}

	private boolean greater(int i,int j){
		return keys[pq[i]].compareTo(keys[pq[j]])>0;
	}

	private void exch(int i,int j){
		int swap=pq[i];
		pq[i]=pq[j];
		pq[j]=swap;
		qp[pq[i]]=i;
		qp[pq[j]]=j;
	}

	private void swim(int k){
		while (k>1&&greater(k/2,k)){
			exch(k,k/2);
			k=k/2;
		}
	}

	private void sink(int k){
		while (2*k<=n){
			int j=2*k;
			if (j<n&&greater(j,j+1))
				j++;
			if (!greater(k,j))
				break;
			exch(k,j);
			k=j;
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return new HelpIteator();
	}

	private class HelpIteator implements Iterator<Integer>{
		//create a new pq
		private IndexMinPQ<Key> copy;

		public HelpIteator(){
			copy=new IndexMinPQ<>(pq.length-1);
			for (int i=1;i<=n;i++){
				copy.insert(pq[i],keys[pq[i]]);
			}
		}

		@Override
		public boolean hasNext() {
			return !copy.isEmpty();
		}

		@Override
		public Integer next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return copy.delMin();
		}
	}

}
