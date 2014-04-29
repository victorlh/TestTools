package com.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QuestionDemo {
  public static void main(String[] args)
    throws Exception{
    //读取questions.txt文件为 Question 的集合
    List<Question> questions = 
      read("src/questions.txt");
    BufferedReader console = 
       new BufferedReader(
           new InputStreamReader(System.in));
    //迭代每个问题
    for (Question q : questions) {
      //输出一个题, 
      System.out.println(q);
      System.out.print("请选择:");
      //获取用户的选择, 
      //阻塞式IO
      String str = console.readLine().trim();
      //与标准答案比较, 
      if(str.charAt(0)==q.getAnswer()){
        //如果一致, 提示答对了
        System.out.println("恭喜你, 继续下一题.");
      }else{
    	  System.out.println("对不起答错了，请重试！");
    	  break;  
      }
      
    }
     
  }

  private static List<Question> 
    read(String filename) throws IOException {
    List<Question> list = 
      new ArrayList<Question>();
    
    BufferedReader in = new BufferedReader(
  		  new InputStreamReader(new FileInputStream(filename),"utf-8"));   
//    BufferedReader in = 
//      new BufferedReader(new FileReader(filename));
    String str;
    while((str = in.readLine())!=null){
      Question q = new Question();
      //从开始到空格处 做为id
      String id = str.substring(0,str.indexOf(' ')); 
      q.setId(Integer.parseInt(id));
      //从空格处 到行尾做为问题的内容
      q.setText(str.substring(str.indexOf(' ')));
      //以下为四个选项
      q.getOptions().add(in.readLine());
      q.getOptions().add(in.readLine());
      q.getOptions().add(in.readLine());
      q.getOptions().add(in.readLine());
      //获取最后一个行做为问题的答案
      q.setAnswer(in.readLine().charAt(0));
      list.add(q);
    } 
    return list;
  }

}




