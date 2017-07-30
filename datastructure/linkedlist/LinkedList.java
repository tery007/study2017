package com.edu.tery.linkedlist;

/**
 * @author Create by tery007
 * @date   2017年7月30日
 * @Theme  单向链表
 */
public class LinkedList {
	
	private Node head;
	private Node last;
	private int  size;
	
	public void add(Object o){
		addLast(o);
	}
	public void add(int index , Object o){
		if(index<0){
			throw new IllegalArgumentException();
		}
		if(head==null){
			head=new Node();
			head.data=o;
			last=head;
		}else{
			Node node=head;
			Node preNode=new Node();
			for(int i=0;i<index;i++){
				if(node.next!=null){
					preNode=node;
					node=node.next;
				}else{
					break;
				}
			}
			Node newNode=new Node();
			newNode.data=o;
			newNode.next=node;
			preNode.next=newNode;
		}
		size++;
	}
	public Object get(int index){
		Node node=head;
		while(node.next!=null){
			node=node.next;
		}
		return node.data;
	}
	public Object remove(int index){
		return null;
	}
	
	public int size(){
		return size;
	}
	
	public void addFirst(Object o){
		if(head==null){
			head=new Node();
			head.data=o;
			last=head;
		}else{
			Node oldHead=head;
			Node newHead=new Node();
			newHead.data=o;
			newHead.next=oldHead;
			head=newHead;
		}
		size++;
	}
	public void addLast(Object o){
		if(head==null){
			head=new Node();
			head.data=o;
			last=head;
		}else{
			Node node=head;
			while(node.next!=null){
				node=node.next;
			}
			last=node.next;
			last.data=o;
		}
		size++;
	}
	public Object removeFirst(){
		return null;
	}
	public Object removeLast(){
		return null;
	}
	
	
	private static  class Node{
		Object data;
		Node next;
		
	}
	
	
}
