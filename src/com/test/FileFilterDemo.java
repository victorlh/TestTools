package com.test;





import java.io.File;
import java.io.FileFilter;

/**
 * FileFilter演示
 */
public class FileFilterDemo {

  public static void main(String[] args) {
	  File dir = new File("." + File.separator +"src"+
                          File.separator+"com"+File.separator+"test");
    if(dir.exists()){
      //1 创建文件过滤器JavaFileFilter
      JavaFileFilter filter = new JavaFileFilter();
      //2 调用dir的listFiles方法,获取符合标准的子项
      File[] subFile = dir.listFiles(filter);
      //3 输出子项名字(因该都是java源文件)
      for(int i=0;i<subFile.length;i++){
        System.out.println(subFile[i].getName());
      }
    }
  }
}

class JavaFileFilter implements FileFilter{
  /**
   * 此方法会被File的listFiles(FileFilter)方法回调
   * 此方法返回true是,File中的子项保留
   */
  public boolean accept(File file) {
    String fileName = file.getName();
    return fileName.endsWith(".java");
  }
  
}


