/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package check;

import static check.FileNames.alladdress;
import static check.FileNames.partaddress;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 *
 * @author 陈勇强
 */
public class Check {
    
    
    
  public  String[] allName= new String[50];  //使用本变量前记得先使用printByFileReader方法
    String txt = "";
    
   public  void printByFileReader(String filePath) throws IOException
{
    File file = new File(alladdress);//文件路径
        FileReader fileReader = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(fileReader);
        String txt = "";
    for(int lines=0;lines<=35;lines++){
        txt = reader.readLine();
        allName[lines]=txt;
        // System.out.println("第"+lines+"行的内容是"+allName[lines]);
   }
        reader.close();
        fileReader.close();
}
   
  public static void check(String[] all,String s2){   //s2:partname
    //  boolean status=false;
      for(int i=1;i<=all.length;i++){
        boolean status =s2.contains(all[i]);
          if(!status) {
              System.out.println(all[i]+"未交作业");}
      }
  }
   
    public static void main(String[] args) throws IOException  {
        // TODO code application logic here
        FileNames partname = new FileNames();
        partname.GetFileName(partaddress);
        partname.Rename(partaddress);
        
        Check Allname  = new Check();
        Allname.printByFileReader(alladdress);
        
       Allname.check(Allname.allName,partname.GetFileName(partaddress));
       
   
    }
}
