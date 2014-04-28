package com.snakeTest;

import java.util.LinkedList;

public class Snake {
	private LinkedList<Node> nodes = new LinkedList();
	//方向
	public static int dir;
	
	//方向向量
	public static final int UP = -1;
	public static final int DOWN = 1;
	public static final int LEFT = -10;
	public static final int RIGHT = 10;
	
	//初始化Snake
	public Snake(){
		nodes.add(new Node(2,2));
		nodes.add(new Node(2,3));
		nodes.add(new Node(2,4));
		nodes.add(new Node(3,4));
		nodes.add(new Node(3,5));
	}
	
	//向前行
	public void step(){
		//向前行一步
		//新增snake头
		int i = nodes.getFirst().getI()+this.dir%10;
		int j = nodes.getFirst().getJ()+this.dir/10;
		nodes.addFirst(new Node(i,j));
		//删除最后一个节点
		nodes.removeLast();
	}
	
	public void step(int row,int cols){
		//向前行一步
		//新增snake头
		int i = nodes.getFirst().getI()+this.dir%10;
		int j = nodes.getFirst().getJ()+this.dir/10;
		if(i<1){
			i= row+i+1;
		}else if(j<1){
			j= cols+j+1;
		}else if(i>row){
			i= i-row+1;
		}else if(j>cols){
			i= i-cols+1;
		}
		nodes.addFirst(new Node(i,j));
		//删除最后一个节点
		nodes.removeLast();
	}
	
	public void step(int dir){
		if(this.dir+dir == 0){
			
		}else{
			this.dir = dir;
			this.step();
		}		
	}
	
	public void step(int dri,int row,int cols){
		if(this.dir+dir == 0){
			
		}else{
			this.dir = dir;
			this.step(row,cols);
		}
	}
	
	public boolean contains(int i,int j){
		return nodes.contains(new Node(i,j));
	}

}
