import java.util.Scanner;
import java.util.regex.*;
public class wordcount {
	 public static void main(String[] args) {  
	 Scanner scan=new Scanner(System.in);
	 String com=scan.nextLine();
     //ѭ����ȡ���������ݣ�ֱ�������ȷ���������
	 while(true)
     { 	 
    	 //����������ʽ����û���������������Ƿ���ȷ
    	 String pattern = ".*wc.exe (-[cwlsa] )+[^(-[cwlsa] )]+(\\.)[^ ]+( -e .+(\\.)txt)?( -o .+(\\.)txt)?";
    	 boolean isMatch = Pattern.matches(pattern, com);
    	 //���ʽ��ȷ������ѭ����������������û�����
    	 if(isMatch){
    	      String pat = "((-[cwlsa] )+)([^(-[cwlsa] )]+(\\.).+)";
    	      
    	      // ���� Pattern ����
    	      Pattern r = Pattern.compile(pat);
    	 
    	      // ���ڴ��� matcher ����
    	      Matcher m = r.matcher(com);
    	      if (m.find( )) {
    	         System.out.println("Found value: " + m.group(1) );
    	         System.out.println("Found value: " + m.group(3) );
    	         if(Pattern.matches(".*(-c ).*", m.group(1))){
    	        	 System.out.println("-c");
    	         }
    	         String[] txt=m.group(3).split(" -e ");
    	         System.out.println(txt[0]);
    	         //����-e����
    	         if(txt.length>1){
    	         if(txt[1].split(" -o ").length>0){
    	        	 System.out.println(txt[1].split(" -o ")[0]);
    	 		}
    	 		//����-o����ʱ
    	         if(txt[1].split(" -o ").length==2){
    	        	 System.out.println(txt[1].split(" -o ")[1]);
    	 		}}
    	         System.out.println(System.getProperty("user.dir"));
    	      } else {
    	         System.out.println("NO MATCH");}
    	      
    		 break;
    	 }
    	 else{com=scan.nextLine();}	 
     }
     
     System.out.println(com);
     scan.close();
}
}

