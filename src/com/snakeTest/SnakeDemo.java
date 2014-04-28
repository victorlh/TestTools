package com.snakeTest;

import java.util.Scanner;

public class SnakeDemo {
	
	public static void main(String args[]){
		int row = 20;
		int cols = 40;
		SnakePane snakePane = new SnakePane(row,cols);
		snakePane.print();
		Snake snake = snakePane.GetSnake();
		
		//输入一次 打印一次
		Scanner scanner = new Scanner(System.in);
		String dir = null; 
		while(true){
			dir = scanner.nextLine();
			if(dir.equals("q")){
				break;
			}else if(dir.equals("w")){
				snake.step(snake.DOWN);
			}else if(dir.equals("a")){
				snake.step(snake.LEFT);
			}else if(dir.equals("d")){
				snake.step(snake.RIGHT);
			}else if(dir.equals("f")){
				snake.step(snake.UP);
			}
			snakePane.print();
		}
		
		
	}

}
