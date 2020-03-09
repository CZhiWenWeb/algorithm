package com.czw.algorithms.util;

import java.util.Iterator;

/**
 * @Author: czw
 * @CreateTime: 2020-02-24 09:49
 * @UpdeteTime: 2020-02-24 09:49
 * @Description:链表实现的背包
 */
public class Bag<Item> implements Iterable<Item> {
	private Node first;
	private class Node{
		Item item;
		Node next;
	}

	public void add(Item item){
		Node oldFirst=first;
		first=new Node();
		first.item=item;
		first.next=oldFirst;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item>{
		private Node current=first;

		@Override
		public boolean hasNext() {
			return current!=null;
		}

		@Override
		public Item next() {
			Item item=current.item;
			current=current.next;
			return item;
		}
		//背包不提供删除
		@Override
		public void remove() {
			try {
				throw new Exception("you can not do that");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
