import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.regex.*;
public class wordcount {
	 public static void main(String[] args) {  
	 Scanner scan=new Scanner(System.in);
	 String com=scan.nextLine();
     //循环获取命令行内容，直到获得正确的输入参数
	 while(true)
     { 	 
    	 //利用正则表达式检查用户命令行输入参数是否正确
    	 String pattern = ".*wc.exe (-[cwlsa] )+[^(-[cwlsa] )]+(\\.)[^ ]+( -e .+(\\.)txt)?( -o .+(\\.)txt)?";
    	 boolean isMatch = Pattern.matches(pattern, com);
    	 //表达式正确则跳出循环，否则继续接受用户输入
    	 if(isMatch){
    	     WC wordCount=new WC(com);
    	     System.out.println(wordCount.getFile()+wordCount.getNumofWord());
    		 //String pat = "((-[cwlsa] )+)([^(-[cwlsa] )]+(\\.).+)";
    	      
    	      // 创建 Pattern 对象
    	      //Pattern r = Pattern.compile(pat);
    	 
    	      // 现在创建 matcher 对象
    	      //Matcher m = r.matcher(com);
    	      //if (m.find( )) {
    	         //System.out.println("Found value: " + m.group(1) );
    	         //System.out.println("Found value: " + m.group(3) );
    	         /*String[] txt=m.group(3).split(" -e ");
    	         System.out.println(txt[0]);
    	         //存在-e参数
    	         if(txt.length>1){
    	         if(txt[1].split(" -o ").length>0){
    	        	 System.out.println(txt[1].split(" -o ")[0]);
    	 		}
    	 		//存在-o参数时
    	         if(txt[1].split(" -o ").length==2){
    	        	 System.out.println(txt[1].split(" -o ")[1]);
    	 		}}*/
    	         //fileFinder finder = new fileFinder();  
    	         
    	         //List<String> filenameList = new ArrayList<String>();
    	         //System.out.println(txt[0].split("\\*")[1]);
    	         //System.out.println(txt[0].split("\\*").length);
    	         /*if(txt[0].split("\\*").length>1){
    	         if(txt[0].split("\\*")[0].length()>0){
    	         finder.findFiles(txt[0].split("\\.")[1] ,txt[0].split("\\*")[0] , filenameList);}
    	         else{finder.findFiles(txt[0].split("\\.")[1] ,System.getProperty("user.dir"), filenameList);}}
    	         else{finder.findFiles(txt[0].split("\\.")[1] ,System.getProperty("user.dir"), filenameList);}*/
    	         //readFileByLines file= new readFileByLines(System.getProperty("user.dir")+"\\"+txt[0]);
    	         //ArrayList<String>  lineArray = new ArrayList<String> ();
    	         //lineArray=file.fileString();
    	         //for(String line:lineArray){
    	        //	 System.out.println(line);
    	         //}
    	         
    	      //} else {
    	         //System.out.println("NO MATCH");}
    	      
    		 break;
    	 }
    	 else{com=scan.nextLine();}	 
     }
     
     System.out.println(com);
     scan.close();
}
}

