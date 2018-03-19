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
    	      String pat = "((-[cwlsa] )+)([^(-[cwlsa] )]+(\\.).+)";
    	      
    	      // 创建 Pattern 对象
    	      Pattern r = Pattern.compile(pat);
    	 
    	      // 现在创建 matcher 对象
    	      Matcher m = r.matcher(com);
    	      if (m.find( )) {
    	         System.out.println("Found value: " + m.group(1) );
    	         System.out.println("Found value: " + m.group(3) );
    	         if(Pattern.matches(".*(-c ).*", m.group(1))){
    	        	 System.out.println("-c");
    	         }
    	         String[] txt=m.group(3).split(" -e ");
    	         System.out.println(txt[0]);
    	         //存在-e参数
    	         if(txt.length>1){
    	         if(txt[1].split(" -o ").length>0){
    	        	 System.out.println(txt[1].split(" -o ")[0]);
    	 		}
    	 		//存在-o参数时
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

