package com.snake;

import java.util.LinkedList;

/**
 * 描述蛇的类
 * 这个类中应包含蛇当前的行进方向以及蛇的每一个关节
 *
 */
public class Snake {
  /**
   * java1.5后开始提供的一个新特性"泛型"
   * 在集合中使用泛型,可以约束集合中的元素类型.这样做的好处是
   * 1:向集合中存放元素时,类型统一
   * 2:从集合中获取元素时,不再需要造型(ClassCast)
   * 
   * LinkedList<Node>,当集合元素被约束为Node类型后,
   * 当前集合只能存放Node类型的实例.取出来的元素不需要造型.
   */
  private LinkedList<Node> nodes = new LinkedList<Node>();
  /**
   * 当前蛇的行进方向
   */
  private int dir;
  
  /**
   * 声明方向的常量
   */
  public static final int UP = -10;
  public static final int DOWN = 10;
  public static final int LEFT = -1;
  public static final int RIGHT = 1;
  /**
   * 无参构造方法
   * 在画面上创建一条蛇
   */
  public Snake(){
    nodes.add(new Node(2,10));
    nodes.add(new Node(2,11));
    nodes.add(new Node(3,11));
    nodes.add(new Node(4,11));
    nodes.add(new Node(5,11));
    nodes.add(new Node(5,12));
    nodes.add(new Node(5,13));
  }
  /**
   * 沿着当前的方向走一步
   */
  public void step(){
    Node head = nodes.getFirst();//获取第一个元素(脑袋)
    //根据脑袋的坐标与当前蛇的方向,计算新脑袋的坐标
    /**
     * UP   =-10 ==> i = -1  j =  0  
     * DOWN = 10 ==> i =  1  j =  0
     * LEFT = -1 ==> i =  0  j = -1 int型除int型结果还是int型
     */
    int i = head.getI() + dir/10;
    int j = head.getJ() + dir%10;
    
    head = new Node(i,j);//根据计算后的i,j创建新的脑袋
    /**
     * 将新的脑袋插入集合的第一元素上
     */
    nodes.addFirst(head);
    /**
     * 删除最后一个元素
     */
    nodes.removeLast();
    
  }
  /**
   * 根据给定的方向移动一步
   * @param dir
   * 1:判断给定方向是否为当前方向的反方向
   * 2:将给定的方向赋给当前蛇移动的方向
   * 3:让蛇按照当前的移动方向走一步  
   */
  public void step(int dir){
    //1
    if(this.dir + dir == 0){
      
    }else{
      //2
      this.dir = dir;
      //3
      this.step();
    }
  }
  
  /**
   * 判断给定的Node代表的点是否为蛇的一个关节
   */
  public boolean contains(Node node){
    /**
     * List集合中的方法contains(),判断给定的元素是否在当前
     * 集合中存在
     */
    return nodes.contains(node);
  }
  
  public boolean contains(int i,int j){
    return nodes.contains(new Node(i,j));
  }
  
  public String toString(){
    /**
     * 直接返回集合的toString方法.
     * 
     * [[2,3],[2,3] ,[2,5] ,[3,5] ,[4,5],[5,5]]
     */
    return nodes.toString();
  }
  
  public boolean equalsFirst(int i,int j){
	  Node head = nodes.getFirst();
	  return head.getI()==i&head.getJ()==j;
  }
}








