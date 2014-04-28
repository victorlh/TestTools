package com.snake;
/**
 * 游戏界面
 * 此类用于绘制游戏画面
 *
 */
public class SnakePane {
  private Snake snake;//游戏界面上的蛇
  private int rows = 10;   //游戏界面的行数
  private int cols = 30;   //游戏界面的列数
  
  public int getRows(){
	  return this.rows;
  }
  
  public SnakePane(){
     //创建蛇
    this.snake = new Snake();
  }
  //为外界提供蛇
  public Snake getSnake(){
    return this.snake;
  }
  
  /**
   * 输出游戏画面的一帧
   */
  public void print(){
    /**
     * 循环套循环
     * 外层循环执行一次,内部循环执行一轮
     */
    for(int i = 0;i<rows;i++){
      for(int j = 0;j<cols;j++){
        //若是第一行或最后一行
        if(i==0||i==rows-1){
          System.out.print("-");//不能用println()方法!
        
        //若是第一列或最后一列
        }else if(j==0||j==cols-1){
          System.out.print("|");
        
        //若当前的i和j是蛇的一个关节,应画"#"
        }else if(snake.contains(i, j)){
          System.out.print("#");
        
        //不是屏幕上的可见点,就画" "(空格)
        }else{
          System.out.print(" ");
        }
      
      }
      System.out.println();//一列都画完了,画一个回行
    }
  }
}







