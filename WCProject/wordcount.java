import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

import java.util.regex.*;
public class wordcount {
	 public static void main(String[] args) {  
	 //Scanner scan=new Scanner(System.in);
	 //String com=scan.nextLine();
     //ѭ����ȡ���������ݣ�ֱ�������ȷ���������
	     String com="wc.exe";
		 for(int i=0;i<args.length;i++){
			 com+=" "+args[i];
		 }
	 while(true)
     { 	 
    	 //����������ʽ����û���������������Ƿ���ȷ
    	 String pattern = "wc.exe (-[cwlsa] )+[^(-[cwlsa] )]+(\\.)[^ ]+( -e .+(\\.)txt)?( -o .+(\\.)txt)?";
    	 boolean isMatch = Pattern.matches(pattern, com);
    	 //���ʽ��ȷ������ѭ����������������û�����
    	 if(isMatch){
    		 //���������в������½�WC��
    	     WC wordCount=new WC(com);
    	     if(wordCount.flag[0]==1){
    	    	 System.out.println(wordCount.getFile()+" "+"�ַ���:"+" "+wordCount.getNumofChar());
        	     try {
                      FileOutputStream out = new FileOutputStream(System.getProperty("user.dir")+"\\"+"result.txt");  
                      OutputStreamWriter outWriter = new OutputStreamWriter(out, "UTF-8");  
                      BufferedWriter bufWrite = new BufferedWriter(outWriter);
                      bufWrite.write(wordCount.getFile()+" "+"�ַ���:"+" "+wordCount.getNumofChar());       
                      bufWrite.close();  
                      outWriter.close();  
                      out.close(); 
           	     	} 
           	     catch (Exception e) {
          	            // TODO Auto-generated catch block
           	    	 System.out.println("�Ҳ���result.txt");
          	        }
    	     }
    	     if(wordCount.flag[1]==1){
    	    	 System.out.println(wordCount.getFile()+" "+"������:"+" "+wordCount.getNumofWord());
        	     try {
                     FileOutputStream out = new FileOutputStream(System.getProperty("user.dir")+"\\"+"result.txt");  
                     OutputStreamWriter outWriter = new OutputStreamWriter(out, "UTF-8");  
                     BufferedWriter bufWrite = new BufferedWriter(outWriter);
                     bufWrite.write(wordCount.getFile()+" "+"������:"+" "+wordCount.getNumofWord());       
                     bufWrite.close();  
                     outWriter.close();  
                     out.close(); 
          	     	} 
          	     catch (Exception e) {
         	            // TODO Auto-generated catch block
          	    	 System.out.println("�Ҳ���result.txt");
         	        }
    	     }
    	     if(wordCount.flag[2]==1){
    	    	 System.out.println(wordCount.getFile()+" "+"����:"+" "+wordCount.getNumofLine());
        	     try {
                     FileOutputStream out = new FileOutputStream(System.getProperty("user.dir")+"\\"+"result.txt");  
                     OutputStreamWriter outWriter = new OutputStreamWriter(out, "UTF-8");  
                     BufferedWriter bufWrite = new BufferedWriter(outWriter);
                     bufWrite.write(wordCount.getFile()+" "+"����:"+" "+wordCount.getNumofLine());       
                     bufWrite.close();  
                     outWriter.close();  
                     out.close(); 
          	     	} 
          	     catch (Exception e) {
         	            // TODO Auto-generated catch block
          	    	 System.out.println("�Ҳ���result.txt");
         	        }
    	     }
    	     if(wordCount.flag[3]==1){
    	    	 System.out.println(wordCount.getFile()+" "+"������/����/ע����:"+" "+wordCount.getNumofCode()+"/"+wordCount.getNumofEmpty()+"/"+wordCount.getNumofComment());
        	     try {
                     FileOutputStream out = new FileOutputStream(System.getProperty("user.dir")+"\\"+"result.txt");  
                     OutputStreamWriter outWriter = new OutputStreamWriter(out, "UTF-8");  
                     BufferedWriter bufWrite = new BufferedWriter(outWriter);
                     bufWrite.write(wordCount.getFile()+" "+"������/����/ע����:"+" "+wordCount.getNumofCode()+"/"+wordCount.getNumofEmpty()+"/"+wordCount.getNumofComment());       
                     bufWrite.close();  
                     outWriter.close();  
                     out.close(); 
          	     	} 
          	     catch (Exception e) {
         	            // TODO Auto-generated catch block
          	    	 System.out.println("�Ҳ���result.txt");
         	        }
    	     }

    		 //String pat = "((-[cwlsa] )+)([^(-[cwlsa] )]+(\\.).+)";
    	      
    	      // ���� Pattern ����
    	      //Pattern r = Pattern.compile(pat);
    	 
    	      // ���ڴ��� matcher ����
    	      //Matcher m = r.matcher(com);
    	      //if (m.find( )) {
    	         //System.out.println("Found value: " + m.group(1) );
    	         //System.out.println("Found value: " + m.group(3) );
    	         /*String[] txt=m.group(3).split(" -e ");
    	         System.out.println(txt[0]);
    	         //����-e����
    	         if(txt.length>1){
    	         if(txt[1].split(" -o ").length>0){
    	        	 System.out.println(txt[1].split(" -o ")[0]);
    	 		}
    	 		//����-o����ʱ
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
    	 else{System.out.println("�����ʽ��������������");
    	 		break;}	 
     }
     
     //System.out.println(com);
}
}

