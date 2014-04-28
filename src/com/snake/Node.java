package com.snake;
/**
 * Node类
 * 代表游戏画面上的一个点.其最主要的就是记录一对横纵坐标
 * 此类的一个实例可以代表蛇的一个关节,也可以代表一个食物
 */
public class Node {
  private int i ;
  private int j ;
  
  public Node(){    
  }
  public Node(int i ,int j){
    this.i = i;
    this.j = j;
  }
  public int getI() {
    return i;
  }
  public void setI(int i) {
    this.i = i;
  }
  public int getJ() {
    return j;
  }
  public void setJ(int j) {
    this.j = j;
  }
  //重写toString()方法,此方法返回当前代表的点的坐标
  public String toString(){
    return "[" + i + "," + j + "]";
  }
  
  public boolean equals(Object obj){
    if(obj == null){
      return false;
    }
    if(obj == this){
      return true;
    }
    if(obj instanceof Node){
      Node node = (Node)obj;
      return this.i == node.i && this.j == node.j;
    }
    return false;
  }
  
  public int hashCode(){
    return (i<<16)|j;
  }
  
}





