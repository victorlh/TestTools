package com.snakeTest;

public class SnakePane {
	private int i;
	private int j;
	Snake snake;
	
	public SnakePane(){
		snake = new Snake();
		i=20;
		j=20;
	}
	
	
	public SnakePane(int i,int j){
		this.i = i;
		this.j = j;
		snake = new Snake();
	}
	
	public int getI(){
		return this.i;
	}
	
	public int getJ(){
		return this.j;
	}
	
	public Snake GetSnake(){
		return this.snake;
	}
	
	
	/**
	 * 画出每一帧
	 */
	public void print(){
		for(int k=0;k<i;k++){
			for(int w=0;w<j;w++){
				if(k==0||k==i-1){
					//画出边框
					System.out.print("—");
				}else if(w==0||w==j-1){
					System.out.print("|");
				}else if(snake.contains(k, w)){
				//画出snake
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	

}
