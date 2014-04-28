package com.snake;

import java.util.Scanner;

/**
 * 游戏测试类
 */
public class SnakeDemo {

  public static void main(String[] args) {
    /**
     * 创建游戏界面类
     */
    SnakePane pane = new SnakePane();
    Snake snake = pane.getSnake();//从游戏界面中获取蛇
    pane.print();//画一帧
    /**
     * 获取键盘输入的信息
     */
    Scanner scanner = new Scanner(System.in);
    String dir = null;
    while(true){
      dir = scanner.nextLine();
      if(dir.equalsIgnoreCase("q")){
        break;
      }else if(dir.equalsIgnoreCase("w")){
        snake.step(Snake.UP);
      }else if(dir.equalsIgnoreCase("s")){
        snake.step(Snake.DOWN);
      }else if(dir.equalsIgnoreCase("a")){
        snake.step(Snake.LEFT);
      }else if(dir.equalsIgnoreCase("d")){
        snake.step(Snake.RIGHT);
      }
      pane.print();
      
    }
  }

}




