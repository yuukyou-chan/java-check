/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package check;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

/**
 *
 * @author 陈勇强
 */
public class FileNames {

    static String partaddress = "E:\\电商1903作业\\电商1903java实验报告\\实验二";
    static String alladdress = "E:\\全体名单.txt";
    static String partName = "";  //调用txt前先使用FileName方法

    public FileNames() {
    }

    public static String GetFileName(String filePath) {
        File file = new File(filePath);
        String[] name = file.list();
        //String txt="";
        for (int i = 0; i < name.length; i++) {
            partName += name[i];
        }
           //System.out.println(partName);
        return partName;
    }

    public static void Rename(String filePath) throws IOException {
        File file = new File(filePath);
        String[] filename = new String[50];
       // file.renameTo(new File(filePath));
        //读取文件夹下的文件，存进一个文件数组
        File[] listfile = file.listFiles();
      
        //读取每个文件名称，找下标对应     
          
        String[] name = file.list();
       // for(int l=0;l<name.length;l++){
       // System.out.println(name[l]);}
        int k= 0;
        for (k=0; k < name.length; k++) {
            filename[k] += name[k];
         System.out.println("第"+k+"个文件名"+filename[k]);
        }
        
      //  File file = new File(partaddress);
     /* FileReader fileReader = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(fileReader);
        String txt = "";
    for(int lines=0;lines<=35;lines++){
        txt = reader.readLine();
        filename[lines]=txt;
        System.out.println("第"+lines+"行的内容是"+filename[lines]);
    }*/
        
//遍历重命名 
        Check check = new Check(); 
        check.printByFileReader(alladdress);
        Check Allname = new Check();
        Allname.printByFileReader(alladdress);
        //System.out.println();
        FileNames partname = new FileNames();
        partname.GetFileName(partaddress);
        //System.out.println(partname.FileName(partaddress));

        for (int i = 1; i < listfile.length; i++) {
            if (listfile[i].isFile()) {

               // boolean status = false;
                for (int j = 0; j <= Allname.allName.length; j++) {
                   boolean  status = filename[i].contains(Allname.allName[j]);    // ！BUG：第0个文件名nulldesktop.ini
                    // System.out.println(Allname.allName[j]);
                    if (status) {
                        String newname = "电商1903-java实验二-" + Allname.allName[j] + ".doc";
                        File refile = new File(filePath + File.separator + newname);
                        listfile[i].renameTo(refile);
                        System.out.println("重命名成功"+newname);
                        break;
                    }
                }

                /*  if(check.check(Allname.allName,partname.FileName(partaddress)))
                 {
                 for(int j=1;j<=35;j++){
                 //文件定位
                 String newname="电商1903-Java实验二"+Check.allName[j]+".doc";
                 File refile=new File(filePath+File.separator+newname);
                 listfile[i].renameTo(refile);
                 }
                 }*/
                System.out.println(listfile[i] + "重命名成功！");
            }
        }
    }

}
